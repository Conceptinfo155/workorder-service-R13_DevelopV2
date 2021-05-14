package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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

import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.GetWorkorderRequest;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GetWorkOrderCommand {
	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(GetWorkOrderCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate woRestTemplate;

	@Value("${amilgetworkorder.url}")
	private String getWorkOrderUrl;

	/** The amdocs user name. */
	@Value("${amilgetworkorder.authToken}")
	private String amdocsAuthToken;

	/**
	 * Get workorder.
	 *
	 * @param orderNumber the order number
	 * @param authToken   the auth token
	 * @return the response entity
	 */
	@HystrixCommand(groupKey = "getWorkorderHystrix", commandKey = "getWorkorderHystrix", fallbackMethod = "getWorkorderHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class })
	public AMILWorkorderResponse getWorkorder(GetWorkorderRequest workOrder, String authToken) {
		AMILWorkorderResponse amilResponse = null;
		LOG.info("Entering into GETWorkorder() method");
		MDC.put("downstream", "amil");
		MDC.put("sourceName", "Orion");
		MDC.put("downstreamUrl", getWorkOrderUrl);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.set("Authorization", "Basic " + amdocsAuthToken);
		HttpEntity<GetWorkorderRequest> entity = new HttpEntity<>(workOrder, header);
		ResponseEntity<AMILWorkorderResponse> amilResponseEntity = woRestTemplate.exchange(getWorkOrderUrl,
				HttpMethod.POST, entity, AMILWorkorderResponse.class);
		if (amilResponseEntity != null) {
			return amilResponseEntity.getBody();
		} else {
			return amilResponse;
		}
	}

	/**
	 * Hystrix Fallback method
	 * 
	 * @param orderNumber
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "getWorkorderHystrix")
	public AMILWorkorderResponse getWorkorderHystrixFallback(GetWorkorderRequest orderNumber, String authToken,
			Throwable e) throws OrionMiddlewareServiceException {
		LOG.error("Fallback {}", e);
		throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR, e);
	}

}
