package com.comcast.orion.workorder.command;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.MediaType;


/**
 * The Class ProductCommand.
 */
@Component
public class ProductCommand {

		/** The log. */
		private final Logger log = LoggerFactory.getLogger(this.getClass());

		/** The product rest template. */
		@Autowired
		private RestTemplate productRestTemplate;

		/** getServiceDetailsEndpoint */
		@Value("${product.getServiceDetails.endpoint}")
		private String getServiceDetailsEndpoint;
		private static final String BVE = "BVE";
	/*
	 * @Autowired ObjectMapper objectMapper;
	 */
		/**
		 * @param customerId 
		 * @param siteId
		 * @param request
		 * @return
		 */
		@HystrixCommand(groupKey = "serviceDetailsHystrix", commandKey = "serviceDetailsHystrix", fallbackMethod = "serviceDetailsHystrixFallback", ignoreExceptions = {
				HttpServerErrorException.class, HttpClientErrorException.class,RestClientException.class, UnknownHttpStatusCodeException.class })
		public ResponseEntity<String> getServiceDetails(String customerId, String siteId) {

			log.info("Invoking endpoint {}", getServiceDetailsEndpoint);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("trackingId", MDC.get("trackingId"));
			HttpEntity<String> entity = new HttpEntity<>(headers);
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(getServiceDetailsEndpoint);
				builder.queryParam("customerId", customerId);
				builder.queryParam("siteId", siteId);				
			ResponseEntity<String> responseEntity = productRestTemplate.exchange(builder.build().toString(),HttpMethod.GET,entity, String.class);	
			return responseEntity;
		}

		/**
		 * @param request
		 * @param e
		 * @return
		 * @throws OrionMiddlewareServiceException
		 */
		@HystrixCommand(groupKey = "serviceDetailsHystrix")
		public ResponseEntity<String> serviceDetailsHystrixFallback(String customerId, String siteId, Throwable e) throws OrionMiddlewareServiceException {
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);
		}

	}
