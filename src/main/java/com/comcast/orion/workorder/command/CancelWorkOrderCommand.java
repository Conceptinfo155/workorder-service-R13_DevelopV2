package com.comcast.orion.workorder.command;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class CancelUpdateWorkOrderCommand.
 */
@Component
public class CancelWorkOrderCommand {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(CancelWorkOrderCommand.class);

	/** The woRestTemplate. */
	@Autowired
	private RestTemplate cancelRestTemplate;
	
	/**
	 * ServiceUtil
	 */
	@Autowired
	private ServiceUtil serviceUtil;

	/**
	 * scheduleServiceUrl
	 */
	@Value("${update.workorder.url}")
	private String  updateworkorderUrl;
	private static final String WORKORDER ="workorder";
	


	/**
	 * @param workOrderId 
	 * @param cancelApmtRequest
	 * @return
	 */
	@HystrixCommand(groupKey = "cancelWorkOrderHystrix", commandKey = "cancelWorkOrderHystrix", fallbackMethod = "cancelWorkOrderHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class,UnknownHttpStatusCodeException.class,ResourceAccessException.class })
	public UpdateWOResponse cancelWorkOrder(UpdateWORequest updateWORequest, String workOrderId) {
		log.info("Inside the CancelWorkOrderCommand##cancelWorkOrder method.");
		ResponseEntity<UpdateWOResponse> updateWOResponse = null;
		HttpHeaders headers = serviceUtil.httpHeader(WORKORDER);
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("ordernumber", workOrderId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(updateworkorderUrl);
		HttpEntity<UpdateWORequest> entity = new HttpEntity<>(updateWORequest, headers);
		updateWOResponse = cancelRestTemplate.postForEntity(builder.buildAndExpand(uriParams).toUri(), entity,
				UpdateWOResponse.class);
		return updateWOResponse.getBody();
	}

	/**
	 * @param bookApmtRequest
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "cancelWorkOrderHystrix")
	public UpdateWOResponse cancelWorkOrderHystrixFallback(UpdateWORequest updateWORequest, String workOrderId, Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);
	}

}
