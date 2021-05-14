package com.comcast.orion.workorder.command;

import org.slf4j.Logger;

import org.springframework.http.HttpMethod;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class LocationRequestCommand.
 */
@Component
public class LocationRequestCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(LocationRequestCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate locationRestTemplate;

	/** The service util. */
	@Autowired
	private ServiceUtil serviceUtil;
	
	@Value("${workorder.orion.location.url}")
	private String  locationServiceUrl;
	
	/**
	 * Gets the location.
	 *
	 * @param locationRequest the location request
	 * @param authorization the authorization
	 * @param operationName the operation name
	 * @return the location
	 */
	@HystrixCommand(groupKey = "locationRequestHystrix", commandKey = "locationRequestHystrix", fallbackMethod = "locationRequestHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, OrionMiddlewareServiceException.class,UnknownHttpStatusCodeException.class })
	public ResponseEntity<LocationServiceResponse> getLocation(String locationId) {
		LOG.info("Request to Location service: locationRequest " + locationId);
		MDC.put("downstream", "location");
		MDC.put("sourceName", "Orion");
		MDC.put("downstreamUrl", locationServiceUrl);
		HttpHeaders headers = new HttpHeaders();
		//Removed below as xspinteceptor will be pass the Authorization token
		//headers.set("Authorization", authorization);
		headers.set("trackingId", MDC.get("trackingId") + "_schedule");
		//US1715624 changes
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(locationServiceUrl);
		builder.queryParam("eLocId",locationId);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		return locationRestTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				LocationServiceResponse.class);
	}

	/**
	 * Location request hystrix fallback.
	 *
	 * @param locationRequest
	 *            the location request
	 * @param authorization
	 *            the authorization
	 * @param e
	 *            the e
	 * @return the response entity
	 * @throws OrionMiddlewareServiceException
	 *             the orion middleware service exception
	 */
	@HystrixCommand(groupKey = "locationRequestHystrix")
	public ResponseEntity<LocationServiceResponse> locationRequestHystrixFallback(String locationId, Throwable e) throws OrionMiddlewareServiceException {
		LOG.error("Inside the GetReservationCommand##getReservationHystrixFallback method.");
		throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR,e);

	}

}
