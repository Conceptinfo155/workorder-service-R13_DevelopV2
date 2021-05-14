package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class UpdateWorkOrderCommand.
 */
@Component
public class UpdateWorkOrderCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(UpdateWorkOrderCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate woRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Value("${workorder.wfx.updateworkorder.url}")
	private String  updateWorkOrderUrl;
	

	/**
	 * Update workorder.
	 *
	 * @param wfxUpdateWorkOrderRequest the wfx update work order request
	 * @param orderNumber the order number
	 * @param authToken the auth token
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "updateWOHystrix", commandKey = "updateWOHystrix", fallbackMethod = "updateWOHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class })
	public ResponseEntity<WFXUpdateWorkOrderResponse> updateWorkorder(
			WFXUpdateWorkOrderRequest wfxUpdateWorkOrderRequest, String orderNumber, String authToken) {
		LOG.info("Entering into updateWorkorder() method");
			LOG.info("wfxUpdateWorkOrderRequest : {}",  wfxUpdateWorkOrderRequest);
			
		HttpHeaders headers = serviceUtil.httpHeaders(authToken.trim());
		HttpEntity<WFXUpdateWorkOrderRequest> entity = new HttpEntity<>(wfxUpdateWorkOrderRequest, headers);
		return woRestTemplate.postForEntity(updateWorkOrderUrl + "/" + orderNumber, entity,
				WFXUpdateWorkOrderResponse.class);

	}

	/**
	 * Update WO hystrix fallback.
	 *
	 * @param wfxUpdateWorkOrderRequest the wfx update work order request
	 * @param orderNumber the order number
	 * @param authToken the auth token
	 * @param e the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service exception
	 */
	@HystrixCommand(groupKey = "updateWOHystrix")
	public ResponseEntity<WFXUpdateWorkOrderResponse> updateWOHystrixFallback(
			WFXUpdateWorkOrderRequest wfxUpdateWorkOrderRequest, String orderNumber, String authToken, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR, e);
	}
}
