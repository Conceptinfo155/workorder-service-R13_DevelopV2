package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.command.SiteCommand;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class SQOSiteActivator {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SiteCommand siteCommand;

    @Autowired
    ObjectMapper objectMapper;

    private static final String ERROR_LOG = "SQOSiteActivator::downstream::error";

    @ServiceActivator(inputChannel = "sqoScheduleWoSiteChannel", outputChannel = "sqoScheduleWoAggregator")
    public Object getSite(SQOScheduleWO sqoScheduleWO){
        log.info("SQOSiteActivator::getSite::enters");
        SiteResponse siteResponse;
        try {
            siteResponse = siteCommand.getSiteDetailV2(sqoScheduleWO.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getSiteId(), "scheduleworkorder");
            log.info("SQOSiteActivator::getSite::exits");
            return siteResponse != null ? siteResponse : new SiteResponse();
        }catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e){
            log.error(ERROR_LOG, e);
            siteResponse = new SiteResponse();
            siteResponse.setErrors(new ArrayList<>());
            if (HttpStatus.NOT_FOUND.value() == e.getRawStatusCode()
                    || HttpStatus.SERVICE_UNAVAILABLE.value() == e.getRawStatusCode()
                    && e.getResponseBodyAsString().contains("ZuulException")) {
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                        ,OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
            }
            try {
                siteResponse = objectMapper.readValue(e.getResponseBodyAsString(), SiteResponse.class);
                if(!CollectionUtils.isEmpty(siteResponse.getErrors())){
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                            siteResponse.getErrors().get(0).getMessage());
                }
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        "Error parsing downstream response");
            } catch (IOException ioException) {
                log.error(ERROR_LOG,ioException);
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        "Error parsing downstream response");
            }
        }catch (Exception e){
            log.error(ERROR_LOG, e);
            if(e instanceof OrionMiddlewareServiceException) {
                OrionMiddlewareServiceException orionMiddlewareServiceException = (OrionMiddlewareServiceException) e;
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                        ,orionMiddlewareServiceException.getErrorMessage());
            }else{
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                        ,OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
            }
        }
    }

}
