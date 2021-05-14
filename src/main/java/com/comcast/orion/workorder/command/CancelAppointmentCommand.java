package com.comcast.orion.workorder.command;

import org.slf4j.Logger;
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
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponseDetails;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class CancelAppointmentCommand.
 */
@Component
public class CancelAppointmentCommand {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(CancelAppointmentCommand.class);

	/** The scheduleRestTemplate. */
	@Autowired
	private RestTemplate scheduleRestTemplate;
	
	/**
	 * ServiceUtil
	 */
	@Autowired
	private ServiceUtil serviceUtil;

	/**
	 * scheduleServiceUrl
	 */
	@Value("${schedule.orion.cancelampt.url}")
	private String  scheduleServiceCancelUrl;
	private static final String SCHEDULE= "schedule";
	


	/**
	 * @param cancelApmtRequest
	 * @return
	 */
	@HystrixCommand(groupKey = "cancelAppointmentHystrix", commandKey = "cancelAppointmentHystrix", fallbackMethod = "cancelAppointmentHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class,UnknownHttpStatusCodeException.class,ResourceAccessException.class })
	public CancelAppointmentResponseDetails cancelAppointment(CancelApmtRequest cancelApmtRequest) {
		log.info("Inside the CancelAppointmentCommand##cancelAppointment method.");
		ResponseEntity<CancelAppointmentResponseDetails> cancelAppointmentResponseDetails = null;
		MDC.put("downstream", SCHEDULE);
		HttpHeaders headers = serviceUtil.httpHeader(SCHEDULE);
		HttpEntity<CancelApmtRequest> entity = new HttpEntity<>(cancelApmtRequest, headers);
		cancelAppointmentResponseDetails = scheduleRestTemplate.postForEntity(scheduleServiceCancelUrl, entity,
				CancelAppointmentResponseDetails.class);
		return cancelAppointmentResponseDetails.getBody();
	}

	/**
	 * @param bookApmtRequest
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "cancelAppointmentHystrix")
	public CancelAppointmentResponseDetails cancelAppointmentHystrixFallback(CancelApmtRequest cancelApmtRequest, Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e);
	}

}
