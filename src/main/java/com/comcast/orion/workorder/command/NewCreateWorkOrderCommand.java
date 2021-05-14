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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.command.WebSecAuthCommand;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.utils.SessionUtil;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class CreateWorkOrderCommand.
 */
@Component
public class NewCreateWorkOrderCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(NewCreateWorkOrderCommand.class);
	
	/**
	 * WebSecAuthCommand
	 */
	@Autowired
	private WebSecAuthCommand authCommand;

	/** The wo rest template. */
	@Autowired
	private RestTemplate nWoRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;

	@Value("${workorder.wfx.nCreateworkorder.url}")
	private String createWorkOrderUrl;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Value("${workorder.wfx.Source}")
	private String workOrderSource;

	/**
	 * Creates the workorder.
	 *
	 * @param wfxCreateWorkOrderRequest the wfx create work order request
	 * @param orderNumber               the order number
	 * @param authToken 
	 * @param authToken                 the auth token
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException 
	 */
	@HystrixCommand(groupKey = "newCreateWOHystrix", commandKey = "newCreateWOHystrix", fallbackMethod = "newCreateWOHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class })
	public ResponseEntity<WFXCreateWorkOrderRespone> createWorkorder(
			WFXCreateWorkOrderRequest wfxCreateRequest,
			String orderNumber) throws OrionMiddlewareServiceException {
		ResponseEntity<WFXCreateWorkOrderRespone> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Source", workOrderSource);
		//Removed below code since added xspInterceptor to generate token 
		/*getAuthToken();
		headers.set("Authorization", "Bearer " + SessionUtil.getAuthorization());*/
		HttpEntity<WFXCreateWorkOrderRequest> entity = new HttpEntity<>(wfxCreateRequest,headers);		
		//try {
			responseEntity = nWoRestTemplate.exchange(createWorkOrderUrl + "/" + orderNumber, HttpMethod.PUT, entity,
				WFXCreateWorkOrderRespone.class);
		//}
		/*catch(HttpClientErrorException | HttpServerErrorException ex) {
			if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
				LOG.info("Token got expired. So creating a token again ");
				getAuthToken();
				headers.set("Authorization", "Bearer " + SessionUtil.getAuthorization());
				HttpEntity<WFXCreateWorkOrderRequest> hEntity = new HttpEntity<>(wfxCreateRequest,headers);
				responseEntity =  nWoRestTemplate.exchange(createWorkOrderUrl + "/" + orderNumber, HttpMethod.POST, hEntity,
						WFXCreateWorkOrderRespone.class);
			}
		}*/
		return responseEntity;
	}

	/**
	 * Creates the WO hystrix fallback.
	 *
	 * @param wfxCreateWorkOrderRequest the wfx create work order request
	 * @param orderNumber               the order number
	 * @param authToken                 the auth token
	 * @param e                         the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service
	 *                                         exception
	 */
	@HystrixCommand(groupKey = "newCreateWOHystrix")
	public ResponseEntity<WFXCreateWorkOrderRespone> newCreateWOHystrixFallback(
			WFXCreateWorkOrderRequest wfxCreateRequest,
			String orderNumber, Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR, e);
	}

	/**
	 * return auth token
	 * @throws OrionMiddlewareServiceException
	 */
	private void getAuthToken() throws OrionMiddlewareServiceException {
		LOG.info("Invoke the WorkorderServiceImpl#getAuthToken () -- start ");
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = authCommand.getAuthToken();
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(ex.getResponseBodyAsString(), ex);
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_100, "Unable to get the websec token");
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