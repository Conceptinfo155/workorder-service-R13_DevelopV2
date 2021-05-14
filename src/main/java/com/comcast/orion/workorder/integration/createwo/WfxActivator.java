package com.comcast.orion.workorder.integration.createwo;

import static net.logstash.logback.marker.Markers.append;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.command.ONPCommand;
import com.comcast.orion.workorder.domain.onp.insertwo.InsertWORequest;
import com.comcast.orion.workorder.domain.onp.insertwo.Job;
import com.comcast.orion.workorder.domain.onp.insertwo.JobCustomer;
import com.comcast.orion.workorder.domain.onp.insertwo.WorkOrderRequest;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.command.NewCreateWorkOrderCommand;
import com.comcast.orion.workorder.command.SiteCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.createwo.Address;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;

@Component
public class WfxActivator {
	private static final String HTTP_CLIENT_ERROR = null;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private NewCreateWorkOrderCommand newCreateWorkOrderCommand;
	
	@Autowired
	CreateWorkOrderMapper createWorkOrderMapper;

	@Autowired
	ONPCommand onpCommand;

	@ServiceActivator(inputChannel = "wfxChannel", outputChannel = "createWorkorderOut")
	public Object createWfxWorkorder(@Payload CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		LOG.info("Inside WfxActivator :: createWfxWorkorder");
		return invokeWfx(createWorkorderWrapper);
	}
	
	private Object invokeWfx(CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		ResponseEntity<WFXCreateWorkOrderRespone> response = null;
		CreateWorkorderResponse createWorkorderResponse =new CreateWorkorderResponse();
		try {
			try {
				LOG.info(objectMapper.writeValueAsString(createWorkorderWrapper.getWfxCreateWorkOrderRequest()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response = newCreateWorkOrderCommand.createWorkorder(createWorkorderWrapper.getWfxCreateWorkOrderRequest(), createWorkorderWrapper.getOrderNumber());
		} catch (HttpClientErrorException | HttpServerErrorException httpClientErrorException) {
			LOG.error(HTTP_CLIENT_ERROR, httpClientErrorException);
			if (httpClientErrorException.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Failed to create a work order with this request: ");
			}
		} catch (ResourceAccessException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
		}
		if (null != response && null != response.getBody()) {
			createWorkorderResponse = createWorkOrderMapper
					.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(response.getBody());
			LOG.info("CreateWorkorderResponse : {}", createWorkorderResponse);
			try {
				InsertWORequest insertWORequest = getOnpInsertWORequest(createWorkorderWrapper);
				onpCommand.insertWOEvent(getNotificationPayloadString(insertWORequest));
			}catch (Exception e){
				LOG.info("Error posting to ONP", e);
			}
		}
		return createWorkorderResponse;

	}

	/**
	 * builds the InsertWORequest
	 * @param createWorkorderWrapper
	 * @throws OrionMiddlewareServiceException
	 */
	private InsertWORequest getOnpInsertWORequest(CreateWorkorderWrapper createWorkorderWrapper){
		InsertWORequest insertWORequest = new InsertWORequest();
		WorkOrderRequest workOrderRequest = new WorkOrderRequest();
		workOrderRequest.setWorkOrderId(createWorkorderWrapper.getOrderNumber());
		workOrderRequest.setSource("SQO");
		Job job = new Job();
		com.comcast.orion.workorder.domain.nWFX.create.Job wfxCreateWorkOrderRequestJob = createWorkorderWrapper.getWfxCreateWorkOrderRequest().getJob();
		job.setJobNum(wfxCreateWorkOrderRequestJob.getJobNum());
		job.setJobClassCd(wfxCreateWorkOrderRequestJob.getJobClassCd());
		if(StringUtils.isNotEmpty(wfxCreateWorkOrderRequestJob.getJobUnits().toString()))
			job.setJobUnits(wfxCreateWorkOrderRequestJob.getJobUnits().toString());
		job.setScheduleDate(wfxCreateWorkOrderRequestJob.getScheduleDate());
		job.setJobTypeCd(wfxCreateWorkOrderRequestJob.getJobTypeCd());
		job.setDispatcherStatusCd(wfxCreateWorkOrderRequestJob.getDispatcherStatusCd());
		job.setTimeSlotCd(wfxCreateWorkOrderRequestJob.getTimeSlotCd());
		job.setTroubleCallIndicator(wfxCreateWorkOrderRequestJob.getTroubleCallIndicator());
		com.comcast.orion.workorder.domain.onp.insertwo.JobCustomer jobCustomer = new JobCustomer();
		jobCustomer.setCustomerId(createWorkorderWrapper.getWfxCreateWorkOrderRequest().getJobCustomer().getCustomerId());
		jobCustomer.setSiteId(createWorkorderWrapper.getWorkorderRequest().getCreateWorkorderRequest().getJobCustomer().getSiteId());
		workOrderRequest.setJobCustomer(jobCustomer);
		workOrderRequest.setJob(job);
		insertWORequest.setWorkOrderRequest(workOrderRequest);
		return insertWORequest;
	}

	/**
	 * Mapping request to string payload
	 */
	private String getNotificationPayloadString(Object request)
			throws OrionMiddlewareServiceException {
		String strPayload = "";
		try {
			strPayload = objectMapper.writeValueAsString(request);
			LOG.info("Onp request payload {}", strPayload);
		} catch (JsonProcessingException e) {
			LOG.error("Error occurred on converting the callback obj to String :: {}", e.getMessage());
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,
					"Error occurred on converting the callback object to String");
		}
		return strPayload;
	}
	
}
