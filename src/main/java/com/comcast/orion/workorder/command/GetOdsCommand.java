package com.comcast.orion.workorder.command;

import java.io.IOException;
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

import com.comcast.orion.workorder.domain.ods.customer.ODSCustomerResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class GetOdsCommand {

	/** The log. */
	private static final Logger LOG = LoggerFactory.getLogger(GetOdsCommand.class);
	/** The ods rest template. */
	@Autowired
	private RestTemplate odsRestTemplate;

	@Value("${ods.customer.endpoint}")
	private String getOdsUrl;

	@Value("${ods.customer.source}")
	private String source;
	
	@Autowired
	ObjectMapper mapper;

	/**
	 * Get getOdsCustomer.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 *
	 */
	@HystrixCommand(groupKey = "odsDetailsHystrix", commandKey = "odsDetailsHystrix", fallbackMethod = "getOdsCustomerHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class })
	public ODSCustomerResponse getOdsCustomer(String customerId) throws OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		ODSCustomerResponse response = new ODSCustomerResponse();
		LOG.info("Entering into getOdsCustomer() method");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("trackingId", MDC.get("trackingId"));
		headers.set("source", source);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("customerId", customerId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getOdsUrl);

		ResponseEntity<String> responseEntity = odsRestTemplate
				.exchange(builder.build(uriParams).toString(), HttpMethod.GET, entity, String.class);
		if (responseEntity != null) {
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			response=mapper.readValue(responseEntity.getBody(), ODSCustomerResponse.class);
		}
		return response;
	}

	/**
	 * Hystrix Fallback method
	 * 
	 * @param request
	 * @param e
	 * @return
	 * @throws Throwable
	 */
	@HystrixCommand(groupKey = "odsDetailsHystrix")
	public ODSCustomerResponse getOdsCustomerHystrixFallback(String customerId, Throwable e) throws Throwable {
		LOG.error("Fallback {}", e);
		throw new OrionMiddlewareServiceException(OrionErrorCode.ODS_SERVICE_CONNECTIVITY_ERROR, e);
	}

}
