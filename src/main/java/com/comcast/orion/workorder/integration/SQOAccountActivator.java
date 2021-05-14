package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.command.AccountCommand;
import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountResponse;
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

@Component
public class SQOAccountActivator {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountCommand accountCommand;

    @Autowired
    ObjectMapper objectMapper;

    private static final String ERROR_LOG = "SQOAccountActivator::downstream::error";

    @ServiceActivator(inputChannel = "sqoScheduleWoCustomerChannel", outputChannel = "sqoScheduleWoAggregator")
    public Object getCustomerDetails(SQOScheduleWO sqoScheduleWO){
        log.info("SQOAccountActivator::getCustomerDetails::enters");
        CustomerAccountResponse customerAccountResponse;
        try {
            customerAccountResponse = accountCommand.getCustomerDetails(sqoScheduleWO.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getCustomerId());
            log.info("SQOAccountActivator::getCustomerDetails::exits");
            return customerAccountResponse != null ? customerAccountResponse : new SiteResponse();
        }catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e){
            log.error(ERROR_LOG, e);
            if (HttpStatus.NOT_FOUND.value() == e.getRawStatusCode()
                    || HttpStatus.SERVICE_UNAVAILABLE.value() == e.getRawStatusCode()
                    && e.getResponseBodyAsString().contains("ZuulException")) {
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        OrionErrorCode.ACCOUNT_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
            }
            try {
                customerAccountResponse = objectMapper.readValue(e.getResponseBodyAsString(), CustomerAccountResponse.class);
                if(!CollectionUtils.isEmpty(customerAccountResponse.getErrors())){
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                            customerAccountResponse.getErrors().get(0).getMessage());
                }
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        "Error getting customer information");
            } catch (IOException ioException) {
                log.error("SQOAccountActivator::parsing error",ioException);
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        "Error parsing downstream response");
            }
        }catch (OrionMiddlewareServiceException e){
            log.error(ERROR_LOG, e);
            return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                    ,e.getErrorMessage());
        }catch (Exception e){
            log.error(ERROR_LOG, e);
            return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                    OrionErrorCode.ACCOUNT_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
        }
    }

}
