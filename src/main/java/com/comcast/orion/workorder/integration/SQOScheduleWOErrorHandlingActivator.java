/*
package com.comcast.orion.workorder.integration;

import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Component
public class SQOScheduleWOErrorHandlingActivator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());



	@ServiceActivator(inputChannel = "SQOScheduleWOerrorChannel", outputChannel="aggregatorWorkorderChannel")
	public Object errorHandler(Message message)
			throws OrionMiddlewareServiceException {
		log.info("Inside ErrorHandlingActivator :: errorHandler() :: start");
		MessageHandlingException ex = (MessageHandlingException) message.getPayload();
		OrionMiddlewareServiceException  exception = (OrionMiddlewareServiceException) ex.getCause();
		Message message2 = ex.getFailedMessage();
		MessageHeaders headers = message2.getHeaders();
		ErrorMessage  response = new ErrorMessage();
		response.setStatus(exception.getErrorCode());
			
		Message message3 = MessageBuilder.withPayload(response)
    			.setHeader("sequenceSize", headers.get("sequenceSize"))
    			.setHeader("sequenceNumber", headers.get("sequenceNumber"))
    			.setHeader("correlationId", headers.get("correlationId"))
    			.setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), headers.get("INVOKE_SERVICE"))
                .build();
		log.info("Inside ErrorHandlingActivator :: errorHandler() :: start");
		return  message3;
	}

}
*/
