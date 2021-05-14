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

import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * The Class BookAppointmentCommand.
 */
@Component
public class BookAppointmentCommand {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(BookAppointmentCommand.class);

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
	@Value("${schedule.orion.BookAmpt.url}")
	private String  scheduleServiceUrl;
	


	/**
	 * @param bookApmtRequest
	 * @return
	 */
	@HystrixCommand(groupKey = "bookAppointmentHystrix", commandKey = "bookAppointmentHystrix", fallbackMethod = "bookAppointmentHystrixFallback", ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class,UnknownHttpStatusCodeException.class,ResourceAccessException.class })
	public ResponseEntity<BookAppointmentResponseDetails> bookAppointment(BookApmtRequest bookApmtRequest) {
		log.info("Inside the BookAppointmentCommand##getBookAppointment method.");
		MDC.put("downstream", "schedule");
		HttpHeaders headers = serviceUtil.httpHeader("schedule");
		HttpEntity<BookApmtRequest> entity = new HttpEntity<>(bookApmtRequest, headers);
		return scheduleRestTemplate.postForEntity(scheduleServiceUrl, entity,
				BookAppointmentResponseDetails.class);
	}

	/**
	 * @param bookApmtRequest
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "bookAppointmentHystrix")
	public ResponseEntity<BookAppointmentResponseDetails> bookAppointmentHystrixFallback(BookApmtRequest bookApmtRequest, Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR, e);
	}

}
