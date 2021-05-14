package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.utils.Base64Util;
import com.comcast.orion.workorder.utils.EsiConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class WebSecAuthCommand {

	/** The wo rest template. */
	@Autowired
	private RestTemplate nWoRestTemplate;

	/**
	 * The log
	 */
	private static final Logger log = LoggerFactory.getLogger(WebSecAuthCommand.class);

	public WebSecAuthCommand() {
		super();
	}
	
	@Value("${oauth.server.url}")
	private String oauth;
	
	@Value("${oauth.server.clientId}")
	private String clientId;
	
	@Value("${oauth.server.client_secret}")
	private String clientSecret;
	
	@Value("${oauth.server.scope}")
	private String scope;
	
	@Value("${oauth.server.grant_type}")
	private String grantType;

	
	
	/**
	 * websecAuth token
	 * @return
	 */
	@HystrixCommand(groupKey = "websecAuthHystrix", commandKey = "websecAuthHystrix", fallbackMethod = "websecAuthHystrixFallback", ignoreExceptions = {HttpClientErrorException.class, HttpServerErrorException.class })
	public ResponseEntity<String> getAuthToken() {
		log.info("invoke the WebSecAuthCommand#getAuthToken -- start");
		HttpHeaders headers = httpHeaders();
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers, headers);
		return nWoRestTemplate.postForEntity(oauth, entity, String.class);

	}
	
	/**
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "websecAuthHystrix")
	public ResponseEntity<String> websecAuthHystrixFallback(Throwable e)
			throws OrionMiddlewareServiceException {
		log.error("in websecAuthHystrixFallback method.");
		throw new OrionMiddlewareServiceException( OrionErrorCode.CONNECTIVITY_ERROR,e);
	}
	
	
	/**
	 * @return HttpHeaders
	 */
	private HttpHeaders httpHeaders() {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		httpHeader.set(EsiConstants.CLIENT_ID, clientId);
		try {
		    httpHeader.set(EsiConstants.CLIENT_SECRET,Base64Util.decode(clientSecret));
		} catch (Exception e) {
		    log.debug("WebSecAuthCommand::httpHeaders():: Decoding exception found "
				+ e.getMessage());
		}
		httpHeader.set(EsiConstants.GRANT_TYPE, grantType);
		httpHeader.set(EsiConstants.SCOPE, scope);
		return httpHeader;
	}

}
