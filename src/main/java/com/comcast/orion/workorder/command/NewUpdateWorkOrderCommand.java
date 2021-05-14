package com.comcast.orion.workorder.command;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.SessionUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class UpdateWorkOrderCommand.
 */
@Component
public class NewUpdateWorkOrderCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(NewUpdateWorkOrderCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate nWoRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;

	/**
	 * WebSecAuthCommand
	 */
	@Autowired
	private WebSecAuthCommand authCommand;

	@Autowired
	ObjectMapper objectMapper;

	@Value("${workorder.wfx.nUpdateworkorder.url}")
	private String updateWorkOrderUrl;

	@Value("${workorder.wfx.Source}")
	private String workOrderSource;

	/**
	 * Update workorder.
	 *
	 * @param wfxUpdateWorkOrderRequest the wfx update work order request
	 * @param orderNumber               the order number
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "newUpdateWOHystrix", commandKey = "newUpdateWOHystrix", fallbackMethod = "newUpdateWOHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class })
	public ResponseEntity<WFXUpdateWorkOrderResponse> updateWorkorder(WFXNewUpdateWorkOrderRequest wfxUpdateRequest,
			String orderNumber) throws OrionMiddlewareServiceException {
		ResponseEntity<WFXUpdateWorkOrderResponse> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Source", workOrderSource);
		getAuthToken();
		headers.set("Authorization", "Bearer " + SessionUtil.getAuthorization());
		HttpEntity<WFXNewUpdateWorkOrderRequest> entity = new HttpEntity<>(wfxUpdateRequest, headers);
		responseEntity = nWoRestTemplate.postForEntity(updateWorkOrderUrl + "/" + orderNumber, entity,
					WFXUpdateWorkOrderResponse.class);
		return responseEntity;

	}

	/**
	 * Update WO hystrix fallback.
	 *
	 * @param wfxUpdateWorkOrderRequest the wfx update work order request
	 * @param orderNumber               the order number
	 * @param authToken                 the auth token
	 * @param e                         the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service
	 *                                         exception
	 */
	@HystrixCommand(groupKey = "newUpdateWOHystrix")
	public ResponseEntity<WFXUpdateWorkOrderResponse> newUpdateWOHystrixFallback(
			WFXNewUpdateWorkOrderRequest wfxUpdateRequest, String orderNumber, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR, e);
	}

	/**
	 * return auth token
	 * 
	 * @throws OrionMiddlewareServiceException
	 */
	private void getAuthToken() throws OrionMiddlewareServiceException {
		LOG.info("Invoke the WorkorderServiceImpl#getAuthToken () -- start ");
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = authCommand.getAuthToken();
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(ex.getResponseBodyAsString(), ex);
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_100,
					"Unable to get the websec token");
		}
		Map<String, String> authMap = null;
		try {
			authMap = objectMapper.readValue(responseEntity.getBody(), Map.class);
		} catch (IOException ex) {
			LOG.info("getAuthToken.HttpServerErrorException : {}", ex);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, ex.getMessage());
		}
		LOG.info("In WorkorderServiceImpl.getAuthToken() " + responseEntity.getBody());
		String authToken = authMap.get("access_token");
		if (null != authToken) {
			SessionUtil.setAuthorization(authToken.trim());
		} else {
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
		}
	}
}
