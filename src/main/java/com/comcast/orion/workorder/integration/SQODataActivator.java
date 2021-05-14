package com.comcast.orion.workorder.integration;

import com.comcast.orion.data.vo.CustomerVO;
import com.comcast.orion.workorder.command.DataCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.io.IOException;

@Component
public class SQODataActivator {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DataCommand dataCommand;

    @Autowired
    ObjectMapper objectMapper;

    private static final String ERROR_LOG = "SQODataActivator::downstream::error";

    @ServiceActivator(inputChannel = "sqoScheduleWoOrderChannel", outputChannel = "sqoScheduleWoAggregator")
    public Object getOrderSummary(SQOScheduleWO sqoScheduleWO){
        log.info("SQODataActivator::getOrderSummary::enters");
        try {
            CustomerVO customerVO = dataCommand.getOrderSummary(sqoScheduleWO.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getCustomerId(),sqoScheduleWO.getScheduleWorkorderRequest().getSolutionDetails().get(0).getProductOfferInstanceId());
            log.info("SQODataActivator::getOrderSummary::exits");
            return customerVO != null ? customerVO : new CustomerVO();
        }catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e){
            log.error(ERROR_LOG, e);
            if (HttpStatus.NOT_FOUND.value() == e.getRawStatusCode()
                    || HttpStatus.SERVICE_UNAVAILABLE.value() == e.getRawStatusCode()
                    && e.getResponseBodyAsString().contains("ZuulException")) {
                try {
                    ErrorMessage errorMessage = objectMapper.readValue(e.getResponseBodyAsString(), ErrorMessage.class);
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                            errorMessage.getErrors().get(0).getCode()+"-"+errorMessage.getErrors().get(0).getMessage());
                }catch (IOException io){
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                            ,OrionErrorCode.DATA_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
                }
            }
            try {
                ErrorMessage errorMessage = objectMapper.readValue(e.getResponseBodyAsString(), ErrorMessage.class);
                if(errorMessage == null || errorMessage.getErrors().isEmpty())
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                            "Error parsing downstream response");
                else{
                    return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                            errorMessage.getErrors().get(0).getCode()+"-"+errorMessage.getErrors().get(0).getMessage());
                }
            } catch (IOException ioException) {
                return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
                        "Error parsing downstream response");
            }
        }catch (OrionMiddlewareServiceException e){
            log.error(ERROR_LOG, e);
            return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                    ,e.getErrorMessage());
        }catch (Exception e){
            log.error(ERROR_LOG, e);
            return new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED
                    ,OrionErrorCode.DATA_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
        }
    }

}
