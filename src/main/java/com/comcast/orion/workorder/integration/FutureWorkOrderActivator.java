package com.comcast.orion.workorder.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.domain.Error;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.service.WordorderService;
import com.comcast.orion.workorder.service.WorkorderServiceImpl;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.GetFutureWorkOrderMapper;

@Component
public class FutureWorkOrderActivator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * WordorderService
	 */
	@Autowired
	private WordorderService workorderService;

	@Autowired
	private WorkorderServiceImpl impl;

	@Autowired
	private GetFutureWorkOrderMapper getFutureWorkOrderMapper;

	@ServiceActivator(inputChannel = "futureWorkOrderChannel", outputChannel = "aggregatorChannel")
	public Object getFutureWorkOrderResponse(GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse) {
		log.info("Inside FutureWorkOrderActivator :: getFutureWorkOrderResponse");
		return invokeFutureWorkOrder(futureWorkOrderWFXResponse);
	}

	private Object invokeFutureWorkOrder(GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse) {
		log.info("Inside FutureWorkOrderActivator :: invokeFutureWorkOrder");
		WorkOrderDetail workOrderDetailsResponse = null;
		WorkorderResponse futureWorkOrderOdoResponse = null;
		String authToken = null;
		String workOrderNumber = null;
		try {
			if (futureWorkOrderWFXResponse != null && futureWorkOrderWFXResponse.getJob()!=null && futureWorkOrderWFXResponse.getJob().getWorkOrderNum() != null) {
				workOrderNumber = futureWorkOrderWFXResponse.getJob().getWorkOrderNum();
				//authToken = impl.getAuthToken("scheduleworkorder");
				futureWorkOrderOdoResponse = workorderService.getWorkOrderDetails(workOrderNumber, authToken, null);
				log.info("ODO Response in parallel call : " + futureWorkOrderOdoResponse);
				workOrderDetailsResponse = getFutureWorkOrderMapper.mapWorkOrderResponseToFutureWorkOrderResponse(
						futureWorkOrderWFXResponse, futureWorkOrderOdoResponse);
				log.info("FutureWorkOrder Response in parallel call : " + workOrderDetailsResponse);
			}
		} catch (OrionMiddlewareServiceException e) {
			Error error = new Error();
			error.setCode(e.getErrorCode());
			error.setMessage(e.getErrorMessage());
			return error;
//		} catch (HttpServerErrorException | HttpClientErrorException ex) {
//			log.error("HttpServerErrorException/HttpClientErrorException in TdsServiceActivator", ex);
//			Error error = new Error();
//			log.info("Error Message >> {}", ex.getResponseBodyAsString());
//			if (ex.getStatusCode() == HttpStatus.NOT_FOUND
//					&& !ex.getResponseBodyAsString().contains("does not exist")) {
//				error.setCode(Constants.NOT_FOUND);
//				error.setMessage(Constants.NO_DATA_FOUND_IN_AMIL);
//			} else {
//				error.setCode(Constants.CONNECTIVITY_ERROR);
//				error.setMessage(Constants.NOT_ABLE_TO_CONNECT_TO_AMIL);
//			}
//			return error;
		}
		return workOrderDetailsResponse;
	}
}
