/**
 * 
 */
package com.comcast.orion.workorder.service;

import javax.validation.Valid;

import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getfutureworkorder.FutureWorkorderResponse;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.pointofinterest.request.DeletePointOfRequest;
import com.comcast.orion.workorder.domain.pointofinterest.response.DeletePointOfResponse;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.utils.exceptions.CancelWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.RescheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import com.comcast.orion.workorder.domain.poi.POIRequest;
import com.comcast.orion.workorder.domain.poi.POIResponse;

/**
 * 
 *
 */


public interface WordorderService {

	/**
	 * @param createWORequest
	 * @param orderNumber
	 * @param operationName
	 * @param token
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	public CreateWorkorderResponse createWorkorder(CreateWORequest createWORequest, String orderNumber,
			String operationName, String token) throws OrionMiddlewareServiceException;

	/**
	 * @param updateWORequest
	 * @param orderNumber
	 * @param operationName
	 * @param token
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	public UpdateWorkorderResponse updateWorkorder(UpdateWORequest updateWORequest, String orderNumber,
			String operationName, String token) throws OrionMiddlewareServiceException;

	WorkorderResponse getWorkOrderDetails(String workOrderNumber, String operation, String trackingId, String siteId, String customerId, String include)throws OrionMiddlewareServiceException;
	
	WorkorderResponse getWorkOrderDetails(String workOrderNumber, String operation, String trackingId)throws OrionMiddlewareServiceException;

	GetWorkorderOMWResponse getWFXWorkOrder(String workOrderNumber)throws OrionMiddlewareServiceException;

	/**
	 * @param request
	 * @param ticketId
	 * @return
	 * @throws ScheduleWorkOrderException
	 * @throws OrionMiddlewareServiceException 
	 */
	public ScheduleWorkorderResponse scheduleWorkorder(ScheduleWorkorder request) throws ScheduleWorkOrderException, OrionMiddlewareServiceException;
	RescheduleWorkorderResponse reschdeuleWorkOrder(RescheduleRequest rescheduleRequest, String workOrderNumber) throws RescheduleWorkOrderException;

	/**
	 * @param workOrderId
	 * @param siteId
	 * @param scheduleIndicator 
	 * @param operationName
	 * @return
	 * @throws CancelWorkOrderException
	 */
	public CancelWorkorderResponse cancelWorkOrder(String workOrderId, String siteId, boolean scheduleIndicator,
			String reasonCodes) throws CancelWorkOrderException;
	
	/**
	 * @param createWORequest
	 * @param orderNumber
	 * @param operationName
	 * @param token
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	public  GetWorkorderBySiteIdResponse[] getWorkOrderBySiteId(String siteId, String dispatcherStatusCd, String scheduleDate) throws OrionMiddlewareServiceException;

	public FutureWorkorderResponse getFutureWorkOrderBySiteId(String siteId) throws OrionMiddlewareServiceException;

	public WorkorderResponse getEnrichedWorkOrderDetails(String workOrderNumber, String authToken, String trackingId,
			String siteId, String customerId, String include) throws OrionMiddlewareServiceException;

	public DeletePointOfResponse deletePointOfInterest(@Valid DeletePointOfRequest request)
			throws OrionMiddlewareServiceException;
	
	public POIResponse createPOI( POIRequest request, String token) throws OrionMiddlewareServiceException;

	/**
	 * SQO schedule work order
	 * @param sqoScheduleWO
	 */
	SQOScheduleWoResponse sqoScheduleWO(SQOScheduleWO sqoScheduleWO) throws OrionMiddlewareServiceException, ScheduleWorkOrderException;

	
}
