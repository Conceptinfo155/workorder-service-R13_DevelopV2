package com.comcast.orion.workorder.integration;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.workorder.command.GetOdsCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.ods.customer.ODSCustomerResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OdsActivator {

	private static final Logger LOG = LoggerFactory.getLogger(OdsActivator.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private GetOdsCommand getOdsCommand;
	
	@ServiceActivator(inputChannel = "odsChannel", outputChannel = "aggregatorWorkorderChannel")
	public Object getOdsCustomerDetails(@Header(name = "CustomerId", required = false) String customerId)
			throws OrionMiddlewareServiceException {
		LOG.info("Inside OdsActivator :: getOdsCustomerDetails");
		ODSCustomerResponse response = new ODSCustomerResponse();
		try {
			response = getOdsCommand.getOdsCustomer(customerId);
		} catch (HttpServerErrorException | HttpClientErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error("(Suppressed) Exception Occurred in OdsActivator#getOdsCustomerDetails --- HttpServerErrorException - Message: {}", ex);
			/*try {
				if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
						|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
						|| (ex.getResponseBodyAsString() != null
								&& ex.getResponseBodyAsString().contains("ZuulException"))) {
					throw new OrionMiddlewareServiceException(OrionErrorCode.ODS_SERVICE_CONNECTIVITY_ERROR);
					LOG.error(HTTP_CLIENT_ERROR, e);
				} else {
					ErrorMessage errorMessage = objectMapper.readValue(ex.getResponseBodyAsString(),
							ErrorMessage.class);
					List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage.getErrors();
					if (errorList != null && errorList.size() > 0) {
						com.comcast.orion.workorder.domain.Error error = errorList.get(0);
						throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_INSTALLBASE,
								error.getMessage());
					}
				}
			} catch (IOException e) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_PRODUCT,
						"Error while processing the response from product service : " + e.getMessage());
			}*/
		} catch (RestClientException e) {
			LOG.error("(Suppressed) Exception Occurred in OdsActivator#getOdsCustomerDetails --- RestClientException - Message: {}", e);
			//throw new OrionMiddlewareServiceException(OrionErrorCode.ODS_SERVICE_CONNECTIVITY_ERROR);
		} catch (Exception e) {
			LOG.error("(Suppressed) Exception Occurred in OdsActivator#getOdsCustomerDetails --- Exception - Message: {}", e);
			//throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
		}
		return response;
	}
}
