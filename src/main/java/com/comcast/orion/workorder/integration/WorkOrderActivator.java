package com.comcast.orion.workorder.integration;

import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;

import com.comcast.orion.workorder.command.GetWorkOrderCommand;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.GetWorkorderRequest;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.WorkOrderDetailsRequest;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.GetWorkOrderMapper;

@Component
public class WorkOrderActivator {
	private static final String HTTP_CLIENT_ERROR = null;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/**
	 * GetWorkOrderCommand
	 */
	@Autowired
	private GetWorkOrderCommand getWorkOrderCommand;
	
	/**
	 * GetWorkOrderMapper
	 */
	@Autowired
	private GetWorkOrderMapper getWorkOrderMapper;



	
	@ServiceActivator(inputChannel = "workOrderDetailsChannel", outputChannel = "aggregatorWorkorderChannel")
	public Object getWorkOrderDetails(String workOrderNumber) throws OrionMiddlewareServiceException {
		LOG.info("Inside WorkOrderActivator :: getWorkOrderDetails");
		return invokeWorkOrder(workOrderNumber);
	}
	
	private Object invokeWorkOrder(String workOrderNumber) throws OrionMiddlewareServiceException {
		
		String authToken = null;
		AMILWorkorderResponse amilResponse = null;
		WorkorderResponse workorderResponse = null;
		
		try {
			amilResponse = getWorkOrderCommand.getWorkorder(constructRequestObject(workOrderNumber), authToken);
			if (amilResponse == null) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECH_AMIL_ERR);
			}
			workorderResponse = getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(amilResponse);
		} catch (HttpClientErrorException | ResourceAccessException e) {
			LOG.error(HTTP_CLIENT_ERROR, e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR);
		} catch (RestClientException restClientException) {
			HttpServerErrorException e = (HttpServerErrorException) restClientException;
			throw new OrionMiddlewareServiceException(getErrorCode(e.getResponseBodyAsString()));

		}
		return workorderResponse;
		
	}
	
	/**
	 * @param workOrderNumber
	 * @return
	 */
	private GetWorkorderRequest constructRequestObject(String workOrderNumber) {
		GetWorkorderRequest workOrderRequest = new GetWorkorderRequest();
		WorkOrderDetailsRequest workOrderDetailsRequest = new WorkOrderDetailsRequest();
		workOrderDetailsRequest.setWorkOrderId(workOrderNumber);
		workOrderRequest.setWorkOrderDetailsRequest(workOrderDetailsRequest);
		return workOrderRequest;

	}
	
	OrionErrorCode getErrorCode(String responseJSON) throws OrionMiddlewareServiceException {

		JSONParser parser = new JSONParser();
		JSONObject json;
		OrionErrorCode code = OrionErrorCode.GETWO_CONNECTIVITY_ERROR;
		try {
			json = (JSONObject) parser.parse(responseJSON);
			JSONObject objectRoot = (JSONObject) json.get("ROOT");
			Map errorObject = (JSONObject) objectRoot.get("Error");
			Iterator<Map.Entry> itr1 = errorObject.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				LOG.info(pair.getKey() + " : " + pair.getValue());
				if (pair.getKey().equals("Number")) {
					if (pair.getValue().equals("BUS_AMIL_ERR")) {
						code = OrionErrorCode.BUS_AMIL_ERR;
					} else {
						code = OrionErrorCode.TECH_AMIL_ERR;
					}
				}

			}

		} catch (Exception e) {
			LOG.error("Exception Occurred in LocationServiceImpl#getWorkOrderDetails --- Exception - Message: {}", e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR);
		}
		return code;

	}
	
	
}
