package com.comcast.orion.workorder.integration.createwo;

import static net.logstash.logback.marker.Markers.append;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.command.SiteCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.createwo.Address;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.JobCustomer;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;

@Component
public class SiteActivator {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * GetWorkOrderCommand
	 */
	@Autowired
	private SiteCommand siteCommand;
	
	@Value("${createworkorder.allowtolocationcall}")
	boolean allowtolocationcall;
	
	@Autowired
	CreateWorkOrderMapper createWorkOrderMapper;
	
	@Autowired
	private RetryTemplate siteRetryTemplate;
	
	@Value("${sitev2.info}")
	private String sitev2Include;
	
	@Value("${sitev2.source}")
	private String sitev2Source;
	
	@Value("${sitev2.endpoint}")
	private String sitev2Endpoint;
	
	
	@ServiceActivator(inputChannel = "siteChannel", outputChannel = "createworkorderFilterIn")
	public Object getSitev2Details(@Payload CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		LOG.info("Inside SiteActivator :: getSiteDetails");
		return invokeSite(createWorkorderWrapper);
	}
	
	private Object invokeSite(CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		SiteResponse siteDetail = null;
		CreateWORequest createWORequest= createWorkorderWrapper.getWorkorderRequest();
		CreateWorkorderRequest createWorkorderRequest =new CreateWorkorderRequest();
		/** Make a retry operation for 3 times(as per siteRetryMaxAttempts config) when siteApi returns  HttpClientErrorException,HttpServerErrorException
		 * Ignore retry operation when siteApi returns business error**/
		try {
		siteDetail= siteRetryTemplate.execute(new RetryCallback<SiteResponse, OrionMiddlewareServiceException>() {
			@Override
			public SiteResponse doWithRetry(RetryContext arg0){
				return siteCommand.getSiteDetailV2(createWORequest.getCreateWorkorderRequest().getJobCustomer().getSiteId(),WorkOrderConstants.CREATEWORKORDER);
			}
		});
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("invokeSite exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			/** Set siteError as true to redirect the call to loction api when siteApi returns any error 
			 * and allowtolocationcall(config) is false */
			if(!allowtolocationcall)
				createWorkorderWrapper.setSiteErrorExists(true);
		} catch (ResourceAccessException ex) {
			LOG.error(append("invokeSite exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			if(!allowtolocationcall)
				createWorkorderWrapper.setSiteErrorExists(true);
		}
		if(siteDetail !=null ){
			/**Mapping location details into wfx request when allowtolocationcall(config) is false */
			if(!allowtolocationcall){
				createWorkorderRequest =siteResponseToCreateWorkOrderRequest(siteDetail,createWORequest.getCreateWorkorderRequest());
				createWorkorderWrapper.setCreateWorkorderRequest(createWorkorderRequest);
			}
			 //Added below condition to set siteSignageName as part of US1885802
			if(StringUtils.isNotEmpty(siteDetail.getSiteSignageName())){
				createWorkorderWrapper.setSiteSignageName(siteDetail.getSiteSignageName());
			}else if(StringUtils.isNotEmpty(siteDetail.getSiteName())){
				createWorkorderWrapper.setSiteSignageName(siteDetail.getSiteName());
			}
		}
		return createWorkorderWrapper;
	}
	
	public CreateWorkorderRequest siteResponseToCreateWorkOrderRequest(SiteResponse siteDetail,
			CreateWorkorderRequest workOrderRequest) {

		CreateWorkorderRequest woRequest = createWorkOrderMapper.mappingSiteResponseToWorkorderRequest(siteDetail);

		if (workOrderRequest.getJobLocation().getAddress() != null) {

			Address woRequestAddress = workOrderRequest.getJobLocation().getAddress();
			Address locationAddress = woRequest.getJobLocation().getAddress();

			String addrLine1 = StringUtils.isNotBlank(woRequestAddress.getAddrLine1()) ? woRequestAddress.getAddrLine1()
					: locationAddress.getAddrLine1();
			String addrLine2 = StringUtils.isNotBlank(woRequestAddress.getAddrLine2()) ? woRequestAddress.getAddrLine2()
					: locationAddress.getAddrLine2();
			String city = StringUtils.isNotBlank(woRequestAddress.getCity()) ? woRequestAddress.getCity()
					: locationAddress.getCity();
			String state = StringUtils.isNotBlank(woRequestAddress.getState()) ? woRequestAddress.getState()
					: locationAddress.getState();
			String zipCode = StringUtils.isNotBlank(woRequestAddress.getZipCode()) ? woRequestAddress.getZipCode()
					: locationAddress.getZipCode();

			workOrderRequest.getJobLocation().getAddress().setAddrLine1(addrLine1);
			workOrderRequest.getJobLocation().getAddress().setAddrLine2(addrLine2);
			workOrderRequest.getJobLocation().getAddress().setCity(city);
			workOrderRequest.getJobLocation().getAddress().setState(state);
			workOrderRequest.getJobLocation().getAddress().setZipCode(zipCode);

		} else {
			if(woRequest.getJobLocation()!=null)
			workOrderRequest.getJobLocation().setAddress(woRequest.getJobLocation().getAddress());
		}

		workOrderRequest.setBusinessUnit(woRequest.getBusinessUnit());
		workOrderRequest.setRouteCriteria(woRequest.getRouteCriteria());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		workOrderRequest.setCreateDateTime(sdt);
		return workOrderRequest;
		
	}
	
}
