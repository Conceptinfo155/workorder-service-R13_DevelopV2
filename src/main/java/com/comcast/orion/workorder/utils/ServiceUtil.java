package com.comcast.orion.workorder.utils;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * The Class ServiceUtil.
 */
@Service("serviceUtil")
public class ServiceUtil {

	@Value("${workorder.wfx.Source}")
	private String workOrderSource;

	/**
	 * Http headers.
	 *
	 * @param authToken
	 *            the auth token
	 * @return the http headers
	 */
	public HttpHeaders httpHeaders(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", "application/json, text/plain");
		headers.set("Source", workOrderSource);
		headers.set("accessToken", authToken);
		return headers;
	}

	/**
	 * Location http headers.
	 *
	 * @param authToken
	 *            the auth token
	 * @return the http headers
	 */
	public HttpHeaders locationHttpHeaders(String authToken,String operationName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", "application/json");
		//Authorization will be set xsp-security jar using PlatformAuthenticationClientInterceptor
		headers.set("trackingId", MDC.get("trackingId")+"_"+operationName);
		return headers;
	} 
	
	/**
	 * @param operationName
	 * @return
	 */
	public HttpHeaders httpHeader(String operationName) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", "application/json");
		//Authorization will be set xsp-security jar using PlatformAuthenticationClientInterceptor
		headers.set("trackingId", MDC.get("trackingId")+ operationName);
		return headers;
	} 

}
