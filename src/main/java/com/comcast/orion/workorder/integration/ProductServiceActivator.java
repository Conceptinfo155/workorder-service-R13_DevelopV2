package com.comcast.orion.workorder.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.workorder.command.ProductCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.domain.product.response.Site;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProductServiceActivator {
	

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceActivator.class);

	/**
	 * ProductCommand
	 */
	@Autowired
	private ProductCommand productCommand;
	
	/**
	 * ObjectMapper
	 */
	@Autowired
	private ObjectMapper objectMapper;

	
	@ServiceActivator(inputChannel = "productChannel", outputChannel = "aggregatorWorkorderChannel")
	public Object getWorkOrderDetails(@Header(name = "CustomerId", required = false) String customerId,@Header(name = "SITE_ID", required = false) String siteId) throws OrionMiddlewareServiceException {
		LOG.info("Inside WorkOrderActivator :: getWorkOrderDetails");
		return invokeProduct(customerId, siteId);
	}
	
	private Object invokeProduct(String customerId, String siteId) throws OrionMiddlewareServiceException {
		
		String authToken = null;
		ResponseEntity<String> responseEntity = null;
		List<Site> sites = new ArrayList<Site>();
		ServiceDetailsResponse serviceDetailsResponse = null;
		boolean productResFlag = false;
		
		{
			try {
				if (productResFlag == false) {
					responseEntity = productCommand.getServiceDetails(customerId, siteId);
					productResFlag = true;
					if (responseEntity.getStatusCode() == HttpStatus.OK) {
						ObjectMapper objectMapper = new ObjectMapper();
						objectMapper.configure(
								DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						if (null != responseEntity) {
							if (null != responseEntity.getBody()
									&& !responseEntity.getBody().isEmpty()) {
								serviceDetailsResponse = objectMapper.readValue(
										responseEntity.getBody(), ServiceDetailsResponse.class);
							}
						}
					} else {
						throw new OrionMiddlewareServiceException(
								OrionErrorCode.BUSINESS_ERROR_PRODUCT_INVALID_ID);
					}
				}
			return serviceDetailsResponse;
			} catch (HttpServerErrorException | HttpClientErrorException
					| UnknownHttpStatusCodeException ex) {
				try {
					if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
							|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
							|| (ex.getResponseBodyAsString() != null && ex
									.getResponseBodyAsString().contains("ZuulException"))) {
						throw new OrionMiddlewareServiceException(
								OrionErrorCode.PRODUCT_SERVICE_CONNECTIVITY_ERROR);
					} else {
						ErrorMessage errorMessage = objectMapper
								.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
						List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage
								.getErrors();
						if (errorList != null && errorList.size() > 0) {
							com.comcast.orion.workorder.domain.Error error = errorList.get(0);
							throw new OrionMiddlewareServiceException(
									OrionErrorCode.BUSINESS_ERROR_PRODUCT, error.getMessage());
						}
					}
				} catch (IOException e) {
					throw new OrionMiddlewareServiceException(
							OrionErrorCode.BUSINESS_ERROR_PRODUCT,
							"Error while processing the response from product service : "
									+ e.getMessage());
				}
			} catch (RestClientException e) {
				throw new OrionMiddlewareServiceException(
						OrionErrorCode.PRODUCT_SERVICE_CONNECTIVITY_ERROR);
			} catch (Exception e) {
				LOG.error(
						"Exception Occurred in WorkorderServiceImpl#getWorkOrderDetails --- Exception - Message: {}",
						e);
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
			}
		}
		return serviceDetailsResponse;
	
	}
}