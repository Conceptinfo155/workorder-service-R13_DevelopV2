package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class WorkorderAuthCommand.
 */
@Component
public class WorkorderAuthCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(WorkorderAuthCommand.class);

	/** The wo rest template. */
	@Autowired
	 private RestTemplate woRestTemplate;

	@Value("${workorder.wfx.Source}")
	private String workOrderSource;
	
	@Value("${workorder.wfx.Authorization}")
	private String workOrderAuthorization;

	@Value("${workorder.wfx.oauth.server.url}")
	private String wfxOauthServerUrl;
	
	/**
	 * Workorder login.
	 *
	 * @param operationName the operation name
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "woAuthHystrix", 
			commandKey = "woAuthHystrix", 
			fallbackMethod = "woAuthHystrixFallback",
			ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class })
	public ResponseEntity<String> workorderLogin(String operationName) {
		LOG.info("Entering into workorderLogin() method");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Source", workOrderSource);
		headers.set("Authorization", workOrderAuthorization);
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
		return woRestTemplate.exchange(wfxOauthServerUrl, HttpMethod.GET, entity,
				String.class);
	}

	/**
	 * Wo auth hystrix fallback.
	 *
	 * @param operationName the operation name
	 * @param e the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service exception
	 */
	@HystrixCommand(groupKey = "woAuthHystrix")
	public ResponseEntity<String> woAuthHystrixFallback(String operationName, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR, e);
	}
}
