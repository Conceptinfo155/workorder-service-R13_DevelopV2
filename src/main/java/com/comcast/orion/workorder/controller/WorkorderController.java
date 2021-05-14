package com.comcast.orion.workorder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.QueryParam;

import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWOResponse;
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
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.service.WordorderService;
import com.comcast.orion.workorder.utils.CreateWOValidation;
import com.comcast.orion.workorder.utils.ValidationUtil;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.CancelWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.RescheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ValidationException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import com.comcast.orion.workorder.domain.poi.POIRequest;
import com.comcast.orion.workorder.domain.poi.POIResponse;

/**
 * WorkorderController
 *
 */
@RestController
@Api(tags = "WorkOrder Service", value = "workorder", description = "Manage work order and posts work order event to AMIL through AMDOCS call back service")
@RequestMapping("/workorder/v2")
@Validated
public class WorkorderController {

	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WorkorderController.class);

	/**
	 * WordorderService
	 */
	@Autowired
	private WordorderService workorderService;

	/**
	 * ValidationUtil
	 */
	@Autowired
	private ValidationUtil validationUtil;

	/**
	 * CreateWOValidation
	 */
	@Autowired
	private CreateWOValidation woValidation;

	/**
	 * @param httpServletRequest
	 * @param request
	 * @param orderNumber
	 * @param token
	 * @param httpServletResponse
	 * @return CreateWOResponse
	 * @throws OrionMiddlewareServiceException
	 */
	@RequestMapping(value = "/createworkorder/{ordernumber}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "create work order to  create work order in WFX route and dispatch sytem for "
			+ "trouble call, special request and Install request", response = CreateWorkorderResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<CreateWOResponse> createWorkorder(HttpServletRequest httpServletRequest,
			@Valid @RequestBody CreateWORequest request, @PathVariable("ordernumber") String orderNumber,
			@RequestHeader(value = "Authorization") String token, HttpServletResponse httpServletResponse)
			throws OrionMiddlewareServiceException {
		LOG.debug("WorkorderController - > createWorkorder() -> " + "orderNumber -> :{}", orderNumber);
		woValidation.validateCreateWorkOrderRequest(request);
		CreateWorkorderResponse createWorkorderResponse = workorderService.createWorkorder(request, orderNumber,
				WorkOrderConstants.CREATEWORKORDER, token);
		return new ResponseEntity<>(new CreateWOResponse().withCreateWorkorderResponse(createWorkorderResponse),
				HttpStatus.OK);

	}

	/**
	 * @param httpServletRequest
	 * @param workOrderNumber
	 * @param authToken
	 * @param response
	 * @return WorkorderResponse
	 * @throws OrionMiddlewareServiceException
	 * @throws ScheduleWorkOrderException
	 */

	@PatchMapping(value = "/{workOrderNumber}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "Reschedule", notes = "Reschedule the appointment", response = RescheduleWorkorderResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = RescheduleWorkorderResponse.class),
			@ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class),
			@ApiResponse(code = 590, message = "Internal Server Error", response = ErrorMessage.class) })
	public ResponseEntity<RescheduleWorkorderResponse> reScheduleAppointment(HttpServletRequest httpServletRequest,
			@Valid @PathVariable(value = "workOrderNumber", required = true) @Size(min = 1, max = 20, message = "size must be between 1 and 20") String workOrderNumber,
			@Valid @RequestBody @NotNull RescheduleRequest rescheduleRequest,
			@Valid @RequestHeader(value = "Authorization") String authToken, HttpServletResponse response)
			throws RescheduleWorkOrderException {
		LOG.info("WorkorderController - > reScheduleAppointment -> orderNumber -> :{}", workOrderNumber);
		validationUtil.validateRescheduleWORequest(rescheduleRequest);
		return new ResponseEntity<RescheduleWorkorderResponse>(
				workorderService.reschdeuleWorkOrder(rescheduleRequest, workOrderNumber), HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param workOrderNumber
	 * @param authToken
	 * @param response
	 * @return WorkorderResponse
	 * @throws OrionMiddlewareServiceException
	 */

	@GetMapping(value = "/{workOrderNumber}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "WFX workorder", notes = "Return WFX Workorder details ", response = WorkorderResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = WorkorderResponse.class),
			@ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class), })
	public ResponseEntity<GetWorkorderOMWResponse> getWFXWorkorder(HttpServletRequest httpServletRequest,
			@Valid @PathVariable(value = "workOrderNumber", required = true) @Size(min = 1, max = 20, message = "size must be between 1 and 20") String workOrderNumber,
			@RequestHeader(value = "Authorization") String authToken, HttpServletResponse response)
			throws OrionMiddlewareServiceException {
		LOG.info("WorkorderController - > getWFXWorkorder -> orderNumber -> :{}", workOrderNumber);
		return new ResponseEntity<GetWorkorderOMWResponse>(workorderService.getWFXWorkOrder(workOrderNumber),
				HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param workOrderNumber
	 * @param authToken
	 * @param response
	 * @return WorkorderResponse
	 * @throws OrionMiddlewareServiceException
	 */
	@GetMapping(value = "/odo/{workOrderNumber}")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiOperation(value = "workorder details", notes = "Return workorder details ", response = WorkorderResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = WorkorderResponse.class),
			@ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class), })
	public ResponseEntity<WorkorderResponse> getWorkorderDetails(HttpServletRequest httpServletRequest,
			@Valid @PathVariable(value = "workOrderNumber", required = false) @Size(min = 1, max = 20, message = "size must be between 1 and 20") String workOrderNumber,
			@RequestParam(value = "siteId", required = false) String siteId,
			@RequestParam(value = "customerId", required = false) String customerId,
			@RequestParam(value = "include", required = false) String include,
			@RequestHeader(value = "Authorization") String authToken, @RequestHeader(value = "trackingId", required = false) String trackingId, HttpServletResponse response)
			throws ValidationException, OrionMiddlewareServiceException {
		LOG.info("WorkorderController - > getWorkorderDetails -> orderNumber -> :{}", workOrderNumber);
		return new ResponseEntity<WorkorderResponse>(workorderService.getWorkOrderDetails(workOrderNumber, authToken, trackingId, siteId, customerId, include),
				HttpStatus.OK);
	}
	
	/**
	 * @param httpServletRequest
	 * @param updateWORequest
	 * @param orderNumber
	 * @param token
	 * @param response
	 * @return UpdateWOResponse
	 * @throws ValidationException
	 * @throws OrionMiddlewareServiceException
	 */
	@RequestMapping(value = "/updateworkorder/{ordernumber}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Update work order to update work order details in WFX route and dispatch system for the given work order number."
			+ "Work order can be cancelled by passing cancel reason code and work order number", response = UpdateWorkorderResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class), })

	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<UpdateWOResponse> updateWorkorder(HttpServletRequest httpServletRequest,
			@RequestBody UpdateWORequest updateWORequest, @PathVariable("ordernumber") String orderNumber,
			@RequestHeader(value = "Authorization") String token, HttpServletResponse response)
			throws ValidationException, OrionMiddlewareServiceException {
		LOG.debug("WorkorderController - > updateOrder() -> orderNumber -> :{}", orderNumber);

		validationUtil.validateUpdateWORequest(updateWORequest.getUpdateWorkorderRequest());

		UpdateWorkorderResponse updateWorkorderResponse = workorderService.updateWorkorder(updateWORequest, orderNumber,
				WorkOrderConstants.UPDATE_WORKORDER.getValue(), token);
		return new ResponseEntity<>(new UpdateWOResponse().withUpdateWorkorderResponse(updateWorkorderResponse),
				HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param request
	 * @param workordernumber
	 * @param trackingId
	 * @param response
	 * @return
	 * @throws OrionMiddlewareServiceException
	 * @throws ScheduleWorkOrderException
	 */
	@RequestMapping(value = "/scheduleworkorder", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "schedule work order to  create work order in WFX route and dispatch sytem for "
			+ "trouble call, special request and Install request", response = ScheduleWorkorder.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class),
			@ApiResponse(code = 400, message = "Bad request : {\"errors\":[{\"code\":\"CONTRACT_VALIDATION_ERROR\",\"message\":\"billingArrangementId  length should be between 1 and 32.\"}]}"),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable : {\"errors\":[{\"code\":\"CONNECTIVITY_ERROR\",\"message\":\"Not able to connect to WFX.\"}]}"),
			@ApiResponse(code = 590, message = "Dependency Error : {\"errors\":[{\"code\":\"BUSINESS_ERROR_WFX\",\"message\":\"TECH_AMIL_ERR - {\\\"Error Description\\\": \\\"WFX Error", response = ErrorMessage.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<ScheduleWorkorderResponse> scheduleWorkorder(HttpServletRequest httpServletRequest,
			@Valid @RequestBody ScheduleWorkorder request,
			@RequestHeader(value = "trackingId", required = false) String trackingId, HttpServletResponse response)
			throws ScheduleWorkOrderException, OrionMiddlewareServiceException {
		validationUtil.validateScheduleIndicators(request.getScheduleWorkorderRequest());
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderService.scheduleWorkorder(request);
		return new ResponseEntity<ScheduleWorkorderResponse>(scheduleWorkorderResponse, HttpStatus.OK);

	}

	/**
	 * @param httpServletRequest
	 * @param request
	 * @param trackingId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/sqo/scheduleWorkOrder", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "schedule work order to  create work order in WFX route and dispatch sytem for "
			+ "trouble call, special request and Install request", response = ScheduleWorkorder.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class),
			@ApiResponse(code = 400, message = "Bad request : {\"errors\":[{\"code\":\"CONTRACT_VALIDATION_ERROR\",\"message\":\"billingArrangementId  length should be between 1 and 32.\"}]}"),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable : {\"errors\":[{\"code\":\"CONNECTIVITY_ERROR\",\"message\":\"Not able to connect to WFX.\"}]}"),
			@ApiResponse(code = 590, message = "Dependency Error : {\"errors\":[{\"code\":\"BUSINESS_ERROR_WFX\",\"message\":\"TECH_AMIL_ERR - {\\\"Error Description\\\": \\\"WFX Error", response = ErrorMessage.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity scheduleWo(HttpServletRequest httpServletRequest,
																	   @Valid @RequestBody SQOScheduleWO request,
																	   @RequestHeader(value = "trackingId", required = false) String trackingId, HttpServletResponse response) throws OrionMiddlewareServiceException, ScheduleWorkOrderException {
		validationUtil.validateSQOScheduleWORequest(request.getScheduleWorkorderRequest());
		SQOScheduleWoResponse sqoScheduleWoResponse = workorderService.sqoScheduleWO(request);
		return new ResponseEntity<>(sqoScheduleWoResponse,HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param workOrderId
	 * @param siteId
	 * @param trackingId
	 * @param httpServletResponse
	 * @return
	 * @throws CancelWorkOrderException
	 */
	@RequestMapping(value = "{workOrderId}/site/{siteId}", method = RequestMethod.DELETE, produces = "application/json")
	@ApiOperation(value = "Cancel Work Order", notes = "The operation is exposed by OMW for cancelling the work order and subsequently cancelling the appointment.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable", response = ErrorMessage.class),
			@ApiResponse(code = 590, message = "Dependency Error", response = ErrorMessage.class), })
	public ResponseEntity<CancelWorkorderResponse> cancelWorkOrder(HttpServletRequest httpServletRequest,
			@Valid @NotNull @Size(max = 20, min = 1, message = "workOrderId length should be between 1 and 20.") @PathVariable(name = "workOrderId", required = true) String workOrderId,
			@Valid @NotNull @Size(max = 20, min = 1, message = "siteId length should be between 1 and 20.") @PathVariable(name = "siteId", required = true) String siteId,
			@RequestParam(name = "noScheduleIndicator", required = false) boolean scheduleIndicator,
			@Valid @NotNull @Size(min = 1) @RequestParam(name = "reasonCodes", required = true) String reasonCodes,
			@RequestHeader(value = "trackingId", required = false) String trackingId,
			HttpServletResponse httpServletResponse) throws CancelWorkOrderException {

		LOG.debug("Request workOrderId = {}, siteId = {}", workOrderId, siteId);

		CancelWorkorderResponse cancelWorkorderResponse = workorderService.cancelWorkOrder(workOrderId, siteId,
				scheduleIndicator, reasonCodes);

		return new ResponseEntity<>(cancelWorkorderResponse, HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param workOrderId
	 * @param siteId
	 * @param trackingId
	 * @param httpServletResponse
	 * @return
	 * @throws CancelWorkOrderException
	 */
	@RequestMapping(value = "site/{siteId}/workorders", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Get Work Order by Site ID", notes = "The operation is exposed by OMW for retreiving workorder associated to sites.")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable", response = ErrorMessage.class),
			@ApiResponse(code = 590, message = "Dependency Error", response = ErrorMessage.class), })
	public ResponseEntity<GetWorkorderBySiteIdResponse[]> getWorkOrderBySiteId(HttpServletRequest httpServletRequest,
			@Valid @NotNull @Size(max = 80, min = 1, message = "siteId length should be between 1 and 80.") @PathVariable(name = "siteId", required = true) String siteId,
			@Valid @Size(max = 5, min = 0, message = "dispatcherStatusCd length should be less than 5.") @QueryParam(value = "dispatcherStatusCd") String dispatcherStatusCd,
			@Valid @Size(max = 10, min = 0, message = "scheduleDate length should be less than 10.") @QueryParam(value = "scheduleDate") String scheduleDate,
			@RequestHeader(value = "trackingId", required = false) String trackingId,
			HttpServletResponse httpServletResponse) throws OrionMiddlewareServiceException {

		LOG.debug("Request siteId =" + siteId + "; dispatcherStatusCd =" + dispatcherStatusCd + "; scheduleDate ="
				+ scheduleDate);

		GetWorkorderBySiteIdResponse[] getWorkorderBySiteIdResponse = workorderService.getWorkOrderBySiteId(siteId,
				dispatcherStatusCd, scheduleDate);

		return new ResponseEntity<>(getWorkorderBySiteIdResponse, HttpStatus.OK);
	}

	/**
	 * @param httpServletRequest
	 * @param siteId
	 * @param trackingId
	 * @param httpServletResponse
	 * @return
	 * @throws CancelWorkOrderException
	 */
	@RequestMapping(value = "site/{siteId}/futureworkorders", method = RequestMethod.GET, produces = "application/json")
	@ApiOperation(value = "Future workorder details", notes = "The operation is exposed by OMW for retreiving future workorders associated to sites.", response = FutureWorkorderResponse.class)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = FutureWorkorderResponse.class),
			@ApiResponse(code = 400, message = "Bad request", response = ErrorMessage.class),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable", response = ErrorMessage.class),
			@ApiResponse(code = 590, message = "Dependency Error", response = ErrorMessage.class), })
	public ResponseEntity<FutureWorkorderResponse> getFutureWorkorderDetails(HttpServletRequest httpServletRequest,
			@Valid @NotNull @Size(max = 80, min = 1, message = "siteId length should be between 1 and 80.") @PathVariable(name = "siteId", required = true) String siteId,
			@RequestHeader(value = "trackingId", required = false) String trackingId,
			HttpServletResponse httpServletResponse) throws OrionMiddlewareServiceException {

		LOG.debug("Request siteId =" + siteId);
		FutureWorkorderResponse getWorkorderBySiteIdResponse = workorderService.getFutureWorkOrderBySiteId(siteId);
		return new ResponseEntity<>(getWorkorderBySiteIdResponse, HttpStatus.OK);
	}
	
	
	/**
	 * @param httpServletRequest
	 * @param request
	 * @param trackingId
	 * @param response
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@RequestMapping(value = "/pointofinterest", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Api to delete customer from OT when id is passed", response = ScheduleWorkorder.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class),
			@ApiResponse(code = 400, message = "Bad request : {\"errors\":[{\"code\":\"CONTRACT_VALIDATION_ERROR\",\"message\":\"id cannot be Null or Empty.\"}]}"),
			@ApiResponse(code = 404, message = "Not Found", response = ErrorMessage.class),
			@ApiResponse(code = 503, message = "Service Not Reachable : {\"errors\":[{\"code\":\"CONNECTIVITY_ERROR\",\"message\":\"Not able to connect to OT.\"}]}"),
			@ApiResponse(code = 590, message = "Dependency Error : {\"errors\":[{\"code\":\"BUSINESS_ERROR_OT\",\"message\":\"TECH_OT_ERR - {\\\"Error Description\\\": \\\"OT Error", response = ErrorMessage.class) })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<DeletePointOfResponse> deletePointOfInterest(HttpServletRequest httpServletRequest,
			@Valid @RequestBody DeletePointOfRequest request,
			@RequestHeader(value = "trackingId", required = false) String trackingId, HttpServletResponse response)
			throws OrionMiddlewareServiceException {
		DeletePointOfResponse deletePointOfInterestResponse = workorderService.deletePointOfInterest(request);
		return new ResponseEntity<DeletePointOfResponse>(deletePointOfInterestResponse, HttpStatus.OK);

	}

	@RequestMapping(value = "/pointofinterest", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "create or update Customer and Site in OT ", response = POIResponse.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request", response = ErrorMessage.class),
			@ApiResponse(code = 500, message = "Error processing request", response = ErrorMessage.class), })
	@ApiImplicitParams({
			@ApiImplicitParam(name = "trackingId", value = "trackingId", required = false, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header") })
	public ResponseEntity<POIResponse> createPOI(HttpServletRequest httpServletRequest,
			@Valid @RequestBody POIRequest  request, 
			@RequestHeader(value = "Authorization") String token, HttpServletResponse httpServletResponse)
			throws OrionMiddlewareServiceException {
		LOG.debug("WorkorderController - > createPOI()");
		POIResponse poiRes = workorderService.createPOI(request, token);
		return new ResponseEntity<>(poiRes, HttpStatus.OK);
	}
}

