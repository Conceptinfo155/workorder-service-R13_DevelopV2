package com.comcast.orion.workorder.command;

import java.util.Arrays;
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
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.utils.DiscoveryClientUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ReferenceDataCommand {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClientUtil discoveryClientUtil;

	@Autowired
	private RestTemplate referenceDataRestTemplate;

	@Value("${omw.referencedata.path}")
	private String path;

	@Value("${omw.referencedata.endpoint}")
	private String omwReferenceDataServiceEndpoint;

	@Value("${omw.referencedata.serviceDiscovery}")
	private boolean serviceDiscovery;

	@Value("${omw.referencedata.serviceName}")
	private String serviceName;

	@HystrixCommand(groupKey = "referenceDataHystrix", commandKey = "referenceDataHystrix", fallbackMethod = "referenceDataHystrixFallBack", ignoreExceptions = {
			HttpServerErrorException.class, HttpClientErrorException.class })
	public ReferenceDataResponse getReferenceData(String templateName) throws OrionMiddlewareServiceException {
		log.info("Inside the ReferenceDataCommand#getReferenceData method --- start");
		// Authorization will be set via xsp
		HttpHeaders header = new HttpHeaders();
		MDC.put("downstream", "referencedata");
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void> entity = new HttpEntity<>(header);
		Map<String, String> params = new HashMap<>();
		params.put("referencetemplatename", templateName);
		String endPoint = null;
		if (serviceDiscovery) {
			endPoint = discoveryClientUtil.getUriFromEureka(serviceName);
		} else {
			endPoint = omwReferenceDataServiceEndpoint;
		}
		ResponseEntity<ReferenceDataResponse> response = referenceDataRestTemplate.exchange(endPoint + path,
				HttpMethod.GET, entity, ReferenceDataResponse.class, params);
		return response.getBody();
	}

	@HystrixCommand(groupKey = "referenceDataHystrix")
	public ReferenceDataResponse referenceDataHystrixFallBack(String templateName, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.REFERENCEDATA_SERVICE_CONNECTIVITY_ERROR, e);
	}

}
