package com.comcast.orion.workorder.command;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GetWFXWorkOrderBySiteIdCommand {
	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(GetWFXWorkOrderBySiteIdCommand.class);



	@Value("${workorder.wfx.getWorkorderBySiteId.url}")
	private String getWorkorderBySiteIdUrl;

	@Value("${workorder.wfx.getWorkorderBySiteId.OrderMgtSystem}")
	private String OrderMgtSystem;

	
	
	@Autowired
	ObjectMapper objectMapper;
	
	/** The wo rest template. */
	@Autowired
	private RestTemplate woRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;
	
	
	/**
	 * Get WFX the workorder.
	 *
	 * @param orderNumber the order number
	 * @param authToken   the auth token
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "getWFXWoBySiteHystrix", commandKey = "getWFXWoBySiteHystrix", fallbackMethod = "getWFXWoBySiteHystrix", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class, OrionMiddlewareServiceException.class })
	public GetWorkorderBySiteIdResponse[] getWFXWorkorder(String siteId, String authToken, String dispatcherStatusCd, String scheduleDate) throws OrionMiddlewareServiceException {

		LOG.info("Entering into getWFXWorkorder() method");

		HttpHeaders headers = serviceUtil.httpHeaders(authToken.trim());
		HttpEntity<HttpHeaders> entity = new HttpEntity<>(headers);
				
		//UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getWorkorderBySiteIdUrl);
		
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getWorkorderBySiteIdUrl);
		if(!StringUtils.isEmpty(OrderMgtSystem)) {
			builder.queryParam("OrderMgtSystem", OrderMgtSystem);
		}
		if(!StringUtils.isEmpty(siteId)) {
			builder.queryParam("AccountNum", siteId);
		}
		if(!StringUtils.isEmpty(dispatcherStatusCd)) {
			builder.queryParam("DispatcherStatusCd", dispatcherStatusCd);
		}
		if(!StringUtils.isEmpty(scheduleDate)) {
			builder.queryParam("ScheduleDate", scheduleDate);
		}
		
		URI endpoint=builder.build().encode().toUri();
		LOG.info("WFA endpoint is : " +endpoint.toString());
		
		ResponseEntity<String> responseEntity = woRestTemplate.exchange(endpoint.toString(), HttpMethod.GET, entity,
				String.class);
		
		GetWorkorderBySiteIdResponse[] getWorkorderBySiteIdResponse = null;
		
		try {
			getWorkorderBySiteIdResponse = objectMapper.readValue(responseEntity.getBody(), GetWorkorderBySiteIdResponse[].class);
			LOG.info(getWorkorderBySiteIdResponse.toString());
		}catch (NullPointerException | IOException e) {
			LOG.error("Exception {}",e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.RESPONSE_PROCESS_ERROR, e);
		}
		return getWorkorderBySiteIdResponse;	
	}

	/**
	 * Get the WO hystrix fallback.
	 * 
	 * @param orderNumber the order number
	 * @param authToken   the auth token
	 * @param e           the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException the orion middleware service
	 *                                         exception
	 */
	@HystrixCommand(groupKey = "getWFXWoBySiteHystrix")
	public GetWorkorderBySiteIdResponse[] getWFXWoBySiteHystrix(String siteId, String authToken, String dispatcherStatusCd, String scheduleDate, Throwable e)
			throws OrionMiddlewareServiceException {
		LOG.info("getWFXWOHystrix() Fallback{} " );
		throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);
	}

}
