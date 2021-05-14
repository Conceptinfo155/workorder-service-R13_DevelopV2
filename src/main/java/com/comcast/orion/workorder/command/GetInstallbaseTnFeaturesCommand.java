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
import org.springframework.web.util.UriComponentsBuilder;
import com.comcast.orion.workorder.domain.installbase.tnFeature.TNFeaturesResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GetInstallbaseTnFeaturesCommand {
	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(GetInstallbaseTnFeaturesCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate installbaseRestTemplate;

	@Value("${installbase.tnFeatures.url}")
	private String getInstallbaseUrl;

	/**
	 * Get getInstallbaseTnFeatures.
	 *
	 */
	@HystrixCommand(groupKey = "getInstallbaseTnFeaturesHystrix", commandKey = "getInstallbaseTnFeaturesHystrix", fallbackMethod = "getInstallbaseTnFeaturesHystrixFallback", ignoreExceptions = {HttpClientErrorException.class, HttpServerErrorException.class })
	public TNFeaturesResponse getInstallbaseTnFeatures(String serviceId, String serviceType, String trackingId) throws OrionMiddlewareServiceException {
		TNFeaturesResponse response = null;
		LOG.info("Entering into getInstallbaseTnFeatures() method");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("trackingId", trackingId);
		HttpEntity<String> entity = new HttpEntity<>(headers);		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getInstallbaseUrl);
		builder.queryParam("serviceId", serviceId);
		builder.queryParam("serviceType", serviceType);

		ResponseEntity<TNFeaturesResponse> responseEntity = installbaseRestTemplate.exchange(builder.build().toString(), HttpMethod.GET, entity, TNFeaturesResponse.class);
		if (responseEntity != null) {
			return responseEntity.getBody();
		} else {
			return response;
		}
	
	}

	/**
	 * Hystrix Fallback method
	 * 
	 * @param orderNumber
	 * @param e
	 * @return
	 * @throws Throwable 
	 */
	@HystrixCommand(groupKey = "getInstallbaseTnFeaturesHystrix")
	public TNFeaturesResponse getInstallbaseTnFeaturesHystrixFallback(String serviceId, String serviceType, String trackingId, Throwable e) throws Throwable {
		LOG.error("Fallback {}", e);
		throw e;
	}

}
