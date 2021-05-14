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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.comcast.orion.workorder.domain.installbase.tnFeature.TNFeaturesResponse;
import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class VMSTnFeaturesCommand {
	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(VMSTnFeaturesCommand.class);

	/** The wo rest template. */
	@Autowired
	private RestTemplate vmsRestTemplate;

	@Value("${vms.tnFeatures.url}")
	private String vmsEndpoint;

	/**
	 * Get getInstallbaseTnFeatures.
	 *
	 */
	@HystrixCommand(groupKey = "vmsTnFeaturesHystrix", commandKey = "vmsTnFeaturesHystrix", fallbackMethod = "vmsTnFeaturesHystrixFallback", ignoreExceptions = {HttpClientErrorException.class, HttpServerErrorException.class })
	public DTTNFeaturesResponse getVMSTnFeatures(String designId) throws OrionMiddlewareServiceException {
		DTTNFeaturesResponse response = null;
		LOG.info("Entering into getVMSTnFeatures() method");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.set("trackingId", trackingId);
		HttpEntity<String> entity = new HttpEntity<>(headers);		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(vmsEndpoint);
		Map<String, String> params = new HashMap<String, String>();
		params.put("designId", designId);
		//builder.queryParam("DesignID", designId);

		ResponseEntity<DTTNFeaturesResponse> responseEntity = vmsRestTemplate.exchange(builder.build().toString(), HttpMethod.GET, entity, DTTNFeaturesResponse.class,params);
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
	@HystrixCommand(groupKey = "vmsTnFeaturesHystrix")
	public DTTNFeaturesResponse vmsTnFeaturesHystrixFallback(String designId, Throwable e) throws Throwable {
		LOG.error("Fallback {}", e);
		throw new OrionMiddlewareServiceException(OrionErrorCode.VMS_CONNECTIVITY_ERROR);
	}

}
