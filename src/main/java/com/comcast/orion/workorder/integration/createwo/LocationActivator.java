package com.comcast.orion.workorder.integration.createwo;

import static net.logstash.logback.marker.Markers.append;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.comcast.orion.workorder.command.LocationRequestCommand;
import com.comcast.orion.workorder.command.SiteCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.createwo.Address;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;

@Component
public class LocationActivator {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * GetWorkOrderCommand
	 */
	@Autowired
	private LocationRequestCommand locationRequestCommand;
	
	@Autowired
	CreateWorkOrderMapper createWorkOrderMapper;
	
	@ServiceActivator(inputChannel = "locationChannel", outputChannel = "createworkorderAggregatorChannel")
	public Object getLocationDetails(@Payload CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		LOG.info("Inside SiteActivator :: getSiteDetails");
		return invokeLocation(createWorkorderWrapper);
	}
	
	private Object invokeLocation(CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException {
		ResponseEntity<LocationServiceResponse> responseEntity = null;
		CreateWORequest createWORequest= createWorkorderWrapper.getWorkorderRequest();
		try {
			//US1715624 changes
			responseEntity = locationRequestCommand.getLocation(createWORequest.getCreateWorkorderRequest().getJobLocation().getAddrId());
			if(responseEntity.getBody() !=null){
				CreateWorkorderRequest workOrderRequest = locationResponseToCreateWorkOrderRequest(responseEntity.getBody(),
						createWORequest.getCreateWorkorderRequest());
				createWorkorderWrapper.setCreateWorkorderRequest(workOrderRequest);
			}
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(append("invokeLocation exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOG.info("Not able to connect location service");
				throw new OrionMiddlewareServiceException(OrionErrorCode.LOCATION_SERVICE_CONNECTIVITY_ERROR);
			} else if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Error occured in Location Service. No Address found with this request.");
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Error occured in Location Service :: " + ex.getMessage());
			}
		}
		return createWorkorderWrapper;
	}
	
	public CreateWorkorderRequest locationResponseToCreateWorkOrderRequest(LocationServiceResponse locationServiceResponse,
			CreateWorkorderRequest workOrderRequest) {

		CreateWorkorderRequest destination = createWorkOrderMapper.locationResponseToWorkOrderRequest(locationServiceResponse);

		if (workOrderRequest.getJobLocation().getAddress() != null) {

			Address woRequestAddress = workOrderRequest.getJobLocation().getAddress();
			Address locationAddress = destination.getJobLocation().getAddress();

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

			if(workOrderRequest.getJobLocation() != null && destination.getJobLocation() != null) {
				workOrderRequest.getJobLocation().setNode(destination.getJobLocation().getNode());
				workOrderRequest.getJobLocation().setDropType(destination.getJobLocation().getDropType());
				workOrderRequest.getJobLocation().setDropTag1(destination.getJobLocation().getDropTag1());
				workOrderRequest.getJobLocation().setDropTag2(destination.getJobLocation().getDropTag2());
				workOrderRequest.getJobLocation().setDropTag3(destination.getJobLocation().getDropTag3());
				workOrderRequest.getJobLocation().setBridgerAddress(destination.getJobLocation().getBridgerAddress());
				workOrderRequest.getJobLocation().setManagementArea(destination.getJobLocation().getManagementArea());
				workOrderRequest.getJobLocation().setHookupType(destination.getJobLocation().getHookupType());
			}
			
		} else {
			if(destination.getJobLocation()!=null)
			workOrderRequest.getJobLocation().setAddress(destination.getJobLocation().getAddress());
		}

		workOrderRequest.setBusinessUnit(destination.getBusinessUnit());
		workOrderRequest.setRouteCriteria(destination.getRouteCriteria());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		workOrderRequest.setCreateDateTime(sdt);
		return workOrderRequest;
		
	}
}
