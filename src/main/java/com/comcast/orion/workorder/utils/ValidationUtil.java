package com.comcast.orion.workorder.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.comcast.orion.workorder.domain.Error;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderRequest;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderRequest.RequestType;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderRequest;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.RescheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ValidationException;

/**
 * ValidationUtil
 *
 */
@Service("validationUtil")
public class ValidationUtil {
	
	@Value("#{'${workorder.solutionType}'.split(',')}")
	private List<String> solutionType;
	
	@Value("#{'${workorder.transportType}'.split(',')}")
	private List<String> transportType;
	
	@Value("#{'${workorder.orderType}'.split(',')}")
	private List<String> orderType;
	
	@Value("#{'${orderType.toIgnoreTransportType}'.split(',')}")
	private List<String> toIgnoreTransportType;
	
	@Value("#{'${orderType.toAllowJobReasonCodeType}'.split(',')}")
	private List<String> toAllowJobReasonCodeType;

	private static final String FAILURE = "FAILURE";

	/**
	 * OPERATION_NAME
	 */
	public static final String OPERATION_NAME = "operation";

	/**
	 * dispatchConstraintValidation
	 */
	private static final List<String> dispatchConstraintValidation = Arrays.asList("wfxDispatchLogin", "jobLocation",
			"jobLocation.addrId", "job.orderMgtSystem", "job.dispatcherStatusCd");

	/**
	 * constraintValidation
	 */
	private static final List<String> constraintValidation = Arrays.asList("wfxDispatchLogin", "jobLocation",
			"jobLocation.addrId");

	/**
	 * ValidationUtil
	 */
	private ValidationUtil() {

	}

	/**
	 * This method validates update workorder request
	 * 
	 * @param updateWorkorderRequest
	 * @throws ValidationException
	 */
	public void validateUpdateWORequest(UpdateWorkorderRequest updateWorkorderRequest) throws ValidationException {
		if (null == updateWorkorderRequest) {
			List<Error> errors = new ArrayList<>();
			Error error = new Error();
			error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
			error.setMessage("updateWorkorderRequest may not be null");
			errors.add(error);
			throw new ValidationException("Orion Schema Validation Error", errors, HttpStatus.BAD_REQUEST);
		}
		List<Error> errors = new ArrayList<>();
		String dispatcherStatusCode = null;
		Boolean flag = false;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UpdateWorkorderRequest>> constraintViolations = validator
				.validate(updateWorkorderRequest);
		Iterator<ConstraintViolation<UpdateWorkorderRequest>> iterator = constraintViolations.iterator();
		if (updateWorkorderRequest.getJob() != null) {
			dispatcherStatusCode = updateWorkorderRequest.getJob().getDispatcherStatusCd();

		}
		while (iterator.hasNext()) {
			ConstraintViolation<UpdateWorkorderRequest> constraintViolation = iterator.next();
			if (constraintViolation.getMessage().equals("may not be null")) {
				if (updateWorkorderRequest != null && dispatcherStatusCode != null
						&& dispatcherStatusCode.contentEquals("X")) {
					flag = setFlag(dispatchConstraintValidation, constraintViolation.getPropertyPath().toString());
				} else {
					flag = setFlag(constraintValidation, constraintViolation.getPropertyPath().toString());
				}

			} else {
				flag = true;
			}
			if (flag) {
				Error error = new Error();
				error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				error.setMessage(constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage());
				errors.add(error);

			}
		}
		if (!errors.isEmpty()) {
			throw new ValidationException("Orion Schema Validation Error", errors, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * This method sets the flag
	 * 
	 * @param constraintlist
	 * @param path
	 * @return flag
	 */
	Boolean setFlag(List<String> constraintlist, String path) {
		Boolean flag = false;
		for (String violation : constraintlist) {
			if (path.equals(violation)) {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * @param scheduleWorkorderRequest
	 * @throws ScheduleWorkOrderException
	 */
	public void validateScheduleIndicators(ScheduleWorkorderRequest scheduleWorkorderRequest)
			throws ScheduleWorkOrderException {
		if (scheduleWorkorderRequest.getSolutionDetails() != null) {
			for(SolutionDetail solutionDetail:scheduleWorkorderRequest.getSolutionDetails()) {
				
				
			if(solutionDetail.getOrderType()!= null) {
				//Modified below condition as part of US1819565
				if(toAllowJobReasonCodeType.contains(solutionDetail.getOrderType().toUpperCase())){
					if(scheduleWorkorderRequest.getCreateWorkOrder().getJob() != null) {
						if(scheduleWorkorderRequest.getCreateWorkOrder().getJob().getJobReasonCode() == null) {
						  throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,"scheduleWorkorderRequest.createWorkorder.job.jobReasonCode: is mandatory");
						}
					}else {
						throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,"scheduleWorkorderRequest.createWorkorder.job.jobReasonCode: is mandatory");
					}
					//Modified below condition as part of US1819565
				} else if (!toIgnoreTransportType.contains(solutionDetail.getOrderType().toUpperCase()) 
							&& StringUtils.isBlank(solutionDetail.getTransportType())) {
						throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, "scheduleWorkorderRequest.solutionDetail.transport: is mandatory");

					}
			}
			}
		}
		if (RequestType.NEW_REQUEST.value().equals(scheduleWorkorderRequest.getRequestType().value())) {
			if ((scheduleWorkorderRequest.getNoCrTicketIndicator() == null
					|| !scheduleWorkorderRequest.getNoCrTicketIndicator())
					&& (scheduleWorkorderRequest.getTicketNumber() == null
							|| scheduleWorkorderRequest.getTicketNumber() == "")) {
				throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
						"scheduleWorkorderRequest.ticketNumber : may not be null when noCrTicketIndicator is false or not available");
			}
			if((scheduleWorkorderRequest.getNoScheduleIndicator() == null
					|| !scheduleWorkorderRequest.getNoScheduleIndicator())) {
				validateScheduleWORequest(scheduleWorkorderRequest);
			}
		}

	}

	/**
	 * @param scheduleWorkorderRequest
	 * @throws RescheduleWorkOrderException
	 */
	public void validateSQOScheduleWORequest(com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest scheduleWorkorderRequest)
			throws ScheduleWorkOrderException {
		List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> errorList = new ArrayList<>();
		if (scheduleWorkorderRequest.getBookAppointment() == null) {
			errorList.add(
					getInvalidScheduleWORequestError("scheduleWorkorderRequest.bookAppointment : may not be null"));
		} else {
			if (scheduleWorkorderRequest.getBookAppointment() != null
					&& (scheduleWorkorderRequest.getBookAppointment().getOptionId() == null
					|| scheduleWorkorderRequest.getBookAppointment().getOptionId() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.bookAppointment.optionId : may not be null"));
			}

			if (scheduleWorkorderRequest.getBookAppointment() != null
					&& (scheduleWorkorderRequest.getBookAppointment().getReservationId() == null
					|| scheduleWorkorderRequest.getBookAppointment().getReservationId() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.bookAppointment.reservationId : may not be null"));
			}

			if (scheduleWorkorderRequest.getCreateWorkOrder().getJob() != null
					&& (scheduleWorkorderRequest.getCreateWorkOrder().getJob().getScheduleDate() == null
					|| scheduleWorkorderRequest.getCreateWorkOrder().getJob().getScheduleDate() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.createWorkOrder.job.scheduleDate : may not be null"));
			}

			if (scheduleWorkorderRequest.getCreateWorkOrder().getJob() != null
					&& (scheduleWorkorderRequest.getCreateWorkOrder().getJob().getTimeSlotCd() == null
					|| scheduleWorkorderRequest.getCreateWorkOrder().getJob().getTimeSlotCd() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.createWorkOrder.job.timeSlotCd : may not be null"));
			}
		}
		populateInvalidScheduleWOException(errorList);

	}

	/**
	 * @param scheduleWorkorderRequest
	 * @throws RescheduleWorkOrderException
	 */
	public void validateScheduleWORequest(ScheduleWorkorderRequest scheduleWorkorderRequest)
			throws ScheduleWorkOrderException {
		List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> errorList = new ArrayList<>();		
		if (scheduleWorkorderRequest.getBookAppointment() == null) {
			errorList.add(
					getInvalidScheduleWORequestError("scheduleWorkorderRequest.bookAppointment : may not be null"));
		} else {
			if (scheduleWorkorderRequest.getBookAppointment() != null
					&& (scheduleWorkorderRequest.getBookAppointment().getOptionId() == null
							|| scheduleWorkorderRequest.getBookAppointment().getOptionId() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.bookAppointment.optionId : may not be null"));
			}

			if (scheduleWorkorderRequest.getBookAppointment() != null
					&& (scheduleWorkorderRequest.getBookAppointment().getReservationId() == null
							|| scheduleWorkorderRequest.getBookAppointment().getReservationId() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.bookAppointment.reservationId : may not be null"));
			}

			if (scheduleWorkorderRequest.getCreateWorkOrder().getJob() != null
					&& (scheduleWorkorderRequest.getCreateWorkOrder().getJob().getScheduleDate() == null
							|| scheduleWorkorderRequest.getCreateWorkOrder().getJob().getScheduleDate() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.createWorkOrder.job.scheduleDate : may not be null"));
			}

			if (scheduleWorkorderRequest.getCreateWorkOrder().getJob() != null
					&& (scheduleWorkorderRequest.getCreateWorkOrder().getJob().getTimeSlotCd() == null
							|| scheduleWorkorderRequest.getCreateWorkOrder().getJob().getTimeSlotCd() == "")) {
				errorList.add(getInvalidScheduleWORequestError(
						"scheduleWorkorderRequest.createWorkOrder.job.timeSlotCd : may not be null"));
			}
		}
		populateInvalidScheduleWOException(errorList);

	}
	
	
	/**
	 * @param rescheduleRequest
	 * @throws RescheduleWorkOrderException 
	 */
	public void validateRescheduleWORequest(RescheduleRequest rescheduleRequest) throws RescheduleWorkOrderException {
		if (rescheduleRequest.getSolutionDetails() != null) {
			for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solutionDetail : rescheduleRequest
					.getSolutionDetails()) {
				if (solutionDetail != null) {
					if (!solutionDetail.getOrderType().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_TC)
							&& (solutionDetail.getSolutionType().isEmpty()
									|| solutionDetail.getSolutionType() == null)) {
						List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
						errorList.add(getInvalidrequestError(
								"RescheduleWorkorderRequest.solutionType: SolutionType value is mandatory"));
						populateInvalidRequestException(errorList);
					}
					if (solutionDetail.getSolutionType() != null) {
						/*if ((solutionDetail.getTransportType() != null)
								&& (!transportType.contains(solutionDetail.getTransportType()))) {
							List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
							errorList.add(getInvalidrequestError(
									"RescheduleWorkorderRequest.transportType: invalid value is passed"));
							populateInvalidRequestException(errorList);
						}*/
						if ((solutionDetail.getOrderType() != null)
								&& (!orderType.stream().anyMatch(solutionDetail.getOrderType()::equalsIgnoreCase))) {
							List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
							errorList.add(getInvalidrequestError(
									"RescheduleWorkorderRequest.orderType: invalid value is passed"));
							populateInvalidRequestException(errorList);
						}
					}
					//US1760966 - Start
					//Modified below condition as part of US1819565
					if (toAllowJobReasonCodeType.contains(solutionDetail.getOrderType().toUpperCase())
						&& StringUtils.isEmpty(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode())) {
						List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
						errorList.add(getInvalidrequestError(
								"workOrder.job.jobReasonCode : JobReasonCode value is mandatory"));
						populateInvalidRequestException(errorList);
					}
					//Modified below condition as part of US1819565
					if (!toIgnoreTransportType.contains(solutionDetail.getOrderType().toUpperCase())
							&& StringUtils.isEmpty(solutionDetail.getTransportType())) {
						List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
						errorList.add(getInvalidrequestError(
								"RescheduleWorkorderRequest.transportType: TransportType value is mandatory"));
						populateInvalidRequestException(errorList);
					}
					//US1760966 - End
				}
			}
		if (rescheduleRequest.getAppointment().getNoScheduleIndicator() == null
				|| !rescheduleRequest.getAppointment().getNoScheduleIndicator()) {
			List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
			if (rescheduleRequest.getAppointment() != null
					&& (rescheduleRequest.getAppointment().getOptionId() == null
					|| rescheduleRequest.getAppointment().getOptionId() == "")) {
				errorList.add(getInvalidrequestError("appointment.optionId : may not be null"));
			}

			if (rescheduleRequest.getAppointment() != null
					&& (rescheduleRequest.getAppointment().getReservationId() == null
							|| rescheduleRequest.getAppointment().getReservationId() == "")) {
				errorList.add(getInvalidrequestError("appointment.reservationId : may not be null"));
			}

			if (rescheduleRequest.getWorkOrder().getJob() != null
					&& (rescheduleRequest.getWorkOrder().getJob().getScheduleDate() == null
					|| rescheduleRequest.getWorkOrder().getJob().getScheduleDate() == "")) {
				errorList.add(getInvalidrequestError("workOrder.job.scheduleDate : may not be null"));
			}

			if (rescheduleRequest.getWorkOrder().getJob() != null
					&& (rescheduleRequest.getWorkOrder().getJob().getTimeSlotCd() == null
					|| rescheduleRequest.getWorkOrder().getJob().getTimeSlotCd() == "")) {
				errorList.add(getInvalidrequestError("workOrder.job.timeSlotCd : may not be null"));
			}
			populateInvalidRequestException(errorList);
		}else if(rescheduleRequest.getAppointment().getNoScheduleIndicator()
				&& rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator() != null
				&& rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator()) {
			List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
			errorList.add(getInvalidrequestError("appointment.noScheduleIndicator and appointment.scheduleANoScheduleIndicator can not be true together"));
			populateInvalidRequestException(errorList);
		}
		}
	}

	/**
	 * @param errorMessage
	 * @return
	 */
	/**
	 * @param errorMessage
	 * @return
	 */
	com.comcast.orion.workorder.domain.reschedule.response.Error getInvalidrequestError(String errorMessage) {
		com.comcast.orion.workorder.domain.reschedule.response.Error error = new com.comcast.orion.workorder.domain.reschedule.response.Error();
		error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
		error.setMessage(errorMessage);
		return error;
	}
	
	/**
	 * @param errorList
	 * @throws RescheduleWorkOrderException
	 */
	void populateInvalidRequestException(List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList) throws RescheduleWorkOrderException {
		if (!CollectionUtils.isEmpty(errorList)) {
			RescheduleWorkorderResponse woResponse = new RescheduleWorkorderResponse();
			woResponse.setErrors(errorList);
			woResponse.setStatus(FAILURE);
			throw new RescheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, woResponse);
		}
	}
	
	/**
	 * @param errorList
	 * @throws ScheduleWorkOrderException
	 */
	void populateInvalidScheduleWOException(List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> errorList) throws ScheduleWorkOrderException {
		if (!CollectionUtils.isEmpty(errorList)) {
			ScheduleWorkorderResponse woResponse = new ScheduleWorkorderResponse();
			woResponse.setErrors(errorList);
			woResponse.setStatus(FAILURE);
			throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, woResponse);
		}
	}
	
	/**
	 * @param errorMessage
	 * @return
	 */
	com.comcast.orion.workorder.domain.scheduleWorkOrder.Error getInvalidScheduleWORequestError(String errorMessage) {
		com.comcast.orion.workorder.domain.scheduleWorkOrder.Error error = new com.comcast.orion.workorder.domain.scheduleWorkOrder.Error();
		error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
		error.setMessage(errorMessage);
		return error;
	}

}
