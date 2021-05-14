package com.comcast.orion.workorder.command;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.updateappointment.request.UpdateAppointmentRequest;
import com.comcast.orion.workorder.domain.updateappointment.response.UpdateAppointmentResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class UpdateAppointmentCommand {
	/** The log. */
	private final Logger log = LoggerFactory.getLogger(UpdateAppointmentCommand.class);

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
	@Value("${schedule.orion.UpdateAmpt.url}")
	private String  scheduleServiceUrl;
	

	/**
	 * @param updateApmtRequest
	 * @return UpdateAppointmentResponse
	 */
	@HystrixCommand(groupKey = "updateAppointmentHystrix", commandKey = "updateAppointmentHystrix", fallbackMethod = "updateAppointmentHystrixFallback",
			ignoreExceptions = {
			HttpClientErrorException.class, HttpServerErrorException.class, ResourceAccessException.class })
	public ResponseEntity<UpdateAppointmentResponse> updateAppointment(UpdateAppointmentRequest updateRequest, String oldAppointment) {
		log.info("Inside the UpdateAppointmentCommand##getupdateAppointment method.");
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("appointmentId", oldAppointment);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(scheduleServiceUrl);	
		HttpHeaders headers = serviceUtil.httpHeader("schedule");
		HttpEntity<UpdateAppointmentRequest> entity = new HttpEntity<>(updateRequest, headers);
		return scheduleRestTemplate.exchange(builder.buildAndExpand(uriParams).toUri(),HttpMethod.PATCH, entity,
				UpdateAppointmentResponse.class);
}
	
	/**
	 * @param bookApmtRequest
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "updateAppointmentHystrix")
	public ResponseEntity<UpdateAppointmentResponse> updateAppointmentHystrixFallback(UpdateAppointmentRequest updateRequest, String oldAppointment,
			Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR, e);
	}


	
}
