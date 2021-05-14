package com.comcast.orion.workorder.command;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class SiteCommand.
 */
@Component
public class SiteCommand {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(SiteCommand.class);

	/** The siteRestTemplate. */
	@Autowired
	private RestTemplate siteRestTemplate;

	/**
	 * ServiceUtil
	 */
	@Autowired
	private ServiceUtil serviceUtil;

	/**
	 * siteEndpoint
	 */
	@Value("${omw.site.getdetail}")
	private String siteEndpoint;
	
	@Value("${site.locationIdentifierInfo}")
	private String locationIdentifierInfo;
	
	@Value("${site.Info}")
	private String siteinclude;
	
	@Value("${sitev2.info}")
	private String sitev2Include;
	
	@Value("${sitev2.source}")
	private String sitev2Source;
	
	@Value("${sitev2.endpoint}")
	private String sitev2Endpoint;
	
	@Value("${site.all}")
	private String siteAll;
	
	private static final String SCHEDULEWORKORDER ="scheduleworkorder";
	private static final String CANCELWORKORDER ="cancelworkorder";
	private static final String	RESCHEDULEWORKORDER="reScheduleAppointment";
	private static final String	CREATEWORKORDER="createWorkOrder";

	/**
	 * @param siteid
	 * @param operationName
	 * @return
	 */
	@HystrixCommand(groupKey = "siteHystrix", commandKey = "siteHystrix", fallbackMethod = "siteHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class,HttpServerErrorException.class,UnknownHttpStatusCodeException.class,ResourceAccessException.class })
	public SiteResponse getSiteDetail(String siteid, String operationName) {
		log.info("Enter SiteCommand :: getSiteDetail");
		HttpHeaders headers = serviceUtil.httpHeader("site");
		MDC.put("downstream", "site");
		MDC.put("sourceName", "Orion");
		MDC.put("downstreamUrl", siteEndpoint);
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("siteId", siteid);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(siteEndpoint);
		if(operationName.equals(SCHEDULEWORKORDER)) {
			builder.queryParam("include", siteinclude);
		} else if(operationName.equals(CANCELWORKORDER)) {
			builder.queryParam("include", locationIdentifierInfo);
		}else if(operationName.equals(RESCHEDULEWORKORDER)) {
			builder.queryParam("include", siteAll);
		}
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
		ResponseEntity<SiteResponse> siteResponse = siteRestTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, entity,
				SiteResponse.class);
		return siteResponse.getBody();
		
	}
	
	@HystrixCommand(groupKey = "siteV2Hystrix", commandKey = "siteV2Hystrix", fallbackMethod = "siteV2HystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class,HttpServerErrorException.class,UnknownHttpStatusCodeException.class,ResourceAccessException.class })
	public com.comcast.orion.workorder.domain.sitev2.SiteResponse getSiteDetailV2(String siteid, String operationName) {
		log.info("Enter SiteCommand :: getSiteDetail");
		HttpHeaders headers = serviceUtil.httpHeader("sitev2");
		MDC.put("downstream", "sitev2");
		MDC.put("sourceName", "Orion");
		MDC.put("downstreamUrl", sitev2Include);
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("siteId", siteid);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(sitev2Endpoint);
		if(operationName.equals(CREATEWORKORDER)) {
			builder.queryParam("include", sitev2Include);
			builder.queryParam("source", sitev2Source);
		} else if(operationName.equals(SCHEDULEWORKORDER)) {
			builder.queryParam("include", siteinclude);
			builder.queryParam("source", sitev2Source);
		}
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
		ResponseEntity<com.comcast.orion.workorder.domain.sitev2.SiteResponse> siteResponse = siteRestTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, entity,
				com.comcast.orion.workorder.domain.sitev2.SiteResponse.class);
		return siteResponse.getBody();
		
	}

	/**
	 * @param siteid
	 * @param operationName
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "siteV2Hystrix")
	public com.comcast.orion.workorder.domain.sitev2.SiteResponse siteV2HystrixFallback(String siteid,String operationName,Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);

	}
	
	/**
	 * @param siteid
	 * @param operationName
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "siteHystrix")
	public SiteResponse siteHystrixFallback(String siteid,String operationName,Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);

	}


}
