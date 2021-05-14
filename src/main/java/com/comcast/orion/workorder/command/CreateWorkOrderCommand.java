package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class CreateWorkOrderCommand.
 */
@Component
public class CreateWorkOrderCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(CreateWorkOrderCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate woRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Value("${workorder.wfx.createworkorder.url}")
	private String  createWorkOrderUrl;

	/**
	 * Creates the workorder.
	 *
	 * @param wfxCreateWorkOrderRequest
	 *            the wfx create work order request
	 * @param orderNumber
	 *            the order number
	 * @param authToken
	 *            the auth token
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "createWOHystrix", commandKey = "createWOHystrix", fallbackMethod = "createWOHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class })
	public ResponseEntity<WFXCreateWorkOrderRespone> createWorkorder(
			WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest, String orderNumber, String authToken) {
		
			LOG.info("Entering into createWorkorder() method");
			LOG.info("WFXCreateWorkOrderRequest : {}", wfxCreateWorkOrderRequest);
		
		HttpHeaders headers = serviceUtil.httpHeaders(authToken.trim());
		HttpEntity<WFXCreateWorkOrderRequest> entity = new HttpEntity<>(wfxCreateWorkOrderRequest, headers);
		return woRestTemplate.exchange(createWorkOrderUrl + "/" + orderNumber,
				HttpMethod.PUT, entity, WFXCreateWorkOrderRespone.class);
	}

	/**
	 * Creates the WO hystrix fallback.
	 *
	 * @param wfxCreateWorkOrderRequest
	 *            the wfx create work order request
	 * @param orderNumber
	 *            the order number
	 * @param authToken
	 *            the auth token
	 * @param e
	 *            the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException
	 *             the orion middleware service exception
	 */
	@HystrixCommand(groupKey = "createWOHystrix")
	public ResponseEntity<WFXCreateWorkOrderRespone> createWOHystrixFallback(
			WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest, String orderNumber, String authToken, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR, e);
	}

}
