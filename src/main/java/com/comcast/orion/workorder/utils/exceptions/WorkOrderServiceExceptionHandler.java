package com.comcast.orion.workorder.utils.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.comcast.orion.workorder.domain.Error;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * WorkOrderServiceExceptionHandler
 *
 */
@RestControllerAdvice
@Service("workOrderServiceExceptionHandler")
public class WorkOrderServiceExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String FAILURE = "FAILURE";

	/**
	 * Logger
	 */
	private final Logger log = LoggerFactory.getLogger(WorkOrderServiceExceptionHandler.class);
	
	/**
	 * TRACKINGID
	 */
	private static final String TRACKINGID = "trackingId";
	
	/**
	 * @param orionMiddlewareServiceException
	 * @return ErrorMessage
	 */
	   //This method handles OMW Exception
	@ExceptionHandler(OrionMiddlewareServiceException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> handleOrionException(
			OrionMiddlewareServiceException orionMiddlewareServiceException) {
		log.error("Exception occur workOrderServiceExceptionHandler#handleOrionException -- start {}", orionMiddlewareServiceException.getErrorMessage());
		String trackingId = MDC.get(TRACKINGID);
		ErrorMessage errorMessage = new ErrorMessage();
		List<Error> listerror = new ArrayList<>();
		Error errormsg = new Error();
		errormsg.setCode(orionMiddlewareServiceException.getErrorCode());
		errormsg.setMessage(orionMiddlewareServiceException.getErrorMessage());
		listerror.add(errormsg);
		errorMessage.setErrors(listerror);
		errorMessage.setStatus(FAILURE);
		return ResponseEntity.status(orionMiddlewareServiceException.getHttpStatus()).header(TRACKINGID,trackingId)
				.body(errorMessage);
	}	
	
	@ExceptionHandler(ScheduleWorkOrderException.class)
	@ResponseBody
	public ResponseEntity<ScheduleWorkorderResponse> handleScheduleWorkOrderException(
			ScheduleWorkOrderException scheduleWorkOrderException) {
		ScheduleWorkorderResponse scheduleWorkorderResponse = new ScheduleWorkorderResponse();
		log.error("Exception occur workOrderServiceExceptionHandler#handleOrionException -- start",
				scheduleWorkOrderException.getErrorMessage());
		String trackingId = MDC.get(TRACKINGID);
		if (scheduleWorkOrderException.getScheduleWorkorderResponse() != null) {
			scheduleWorkorderResponse = scheduleWorkOrderException.getScheduleWorkorderResponse();
		} else {
			List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.scheduleWorkOrder.Error errormsg = new com.comcast.orion.workorder.domain.scheduleWorkOrder.Error();
			errormsg.setCode(scheduleWorkOrderException.getErrorCode());
			errormsg.setMessage(scheduleWorkOrderException.getErrorMessage());
			listerror.add(errormsg);
			scheduleWorkorderResponse.setErrors(listerror);
			scheduleWorkorderResponse.setStatus(FAILURE);
			scheduleWorkorderResponse.setWorkorderNumber(scheduleWorkOrderException.getWorkOrderNumber());
		}
		return ResponseEntity.status(scheduleWorkOrderException.getHttpStatus()).header(TRACKINGID, trackingId)
				.body(scheduleWorkorderResponse);
	}

	@ExceptionHandler(RescheduleWorkOrderException.class)
	@ResponseBody
	public ResponseEntity<RescheduleWorkorderResponse> handleReScheduleWorkOrderException(
			RescheduleWorkOrderException reScheduleWorkOrderException) {
		RescheduleWorkorderResponse reScheduleWorkorderResponse = new RescheduleWorkorderResponse();
		log.error("Exception occur workOrderServiceExceptionHandler#handleOrionException -- start", reScheduleWorkOrderException.getErrorMessage());
		String trackingId = MDC.get(TRACKINGID);
		if(reScheduleWorkOrderException.getRescheduleWorkorderResponse() != null) {
			reScheduleWorkorderResponse = reScheduleWorkOrderException.getRescheduleWorkorderResponse();
		}else {
			List<com.comcast.orion.workorder.domain.reschedule.response.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.reschedule.response.Error errormsg = new com.comcast.orion.workorder.domain.reschedule.response.Error();
			errormsg.setCode(reScheduleWorkOrderException.getErrorCode());
			errormsg.setMessage(reScheduleWorkOrderException.getErrorMessage());
			listerror.add(errormsg);
			reScheduleWorkorderResponse.setErrors(listerror);
			if(reScheduleWorkOrderException.getStatus()!=null) {
				reScheduleWorkorderResponse.setStatus(reScheduleWorkOrderException.getStatus());
			}else
				reScheduleWorkorderResponse.setStatus(FAILURE);
			if(reScheduleWorkOrderException.getNewWorkOrderNumber()!=null)
				reScheduleWorkorderResponse.setNewWorkOrderNumber(reScheduleWorkOrderException.getNewWorkOrderNumber());
			reScheduleWorkorderResponse.setWorkOrderNumber(reScheduleWorkOrderException.getWorkOrderNumber());
		}
		return ResponseEntity.status(reScheduleWorkOrderException.getHttpStatus()).header(TRACKINGID,trackingId)
				.body(reScheduleWorkorderResponse);
	}
    @ResponseBody
     @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object>  exceptionHandler(ConstraintViolationException e) {
    //	Set<ConstraintViolation<?>> set = e.getCause();
    	 ResponseEntity<Object> object=null;
		log.error("Exception occur workOrderServiceExceptionHandler#handleException -- start {}", e.getMessage());
		String trackingId = MDC.get(TRACKINGID);
		String operationName = MDC.get("operationName");
		if(operationName.equals(WorkOrderConstants.CANCEL_WORK_ORDER.getValue())||
				operationName.equals(WorkOrderConstants.SCHEDULE_WORK_ORDER.getValue())){
			object= handleScheduleWorkOrderException(operationName, object,e);
		}
		else {
			ErrorMessage errorMessage = new ErrorMessage();
			List<Error> errors = new ArrayList<>();
			Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();
			for (ConstraintViolation<?> violation : violationSet) {
				Error error = new Error();
				error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				error.setMessage(violation.getPropertyPath() + "-" + violation.getMessage());
				errors.add(error);
			}
			errorMessage.setErrors(errors);
			errorMessage.setStatus(FAILURE);
			object = ResponseEntity.status(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getHttpStatus())
					.header(TRACKINGID, trackingId).body(errorMessage);
		
		}
		return object;
		
    }
    
    public  ResponseEntity<Object> handleScheduleWorkOrderException(String operationName, ResponseEntity<Object> object,ConstraintViolationException e) {
    	String trackingId = MDC.get(TRACKINGID);
    	if(operationName.equals(WorkOrderConstants.CANCEL_WORK_ORDER.getValue())){
			CancelWorkorderResponse cancelWorkorderResponse = new CancelWorkorderResponse();
			List<com.comcast.orion.workorder.domain.cancelworkorder.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.cancelworkorder.Error errormsg = new com.comcast.orion.workorder.domain.cancelworkorder.Error();			
			Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();
			for (ConstraintViolation<?> violation : violationSet) {		
				errormsg.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				errormsg.setMessage(violation.getPropertyPath()+"-"+violation.getMessage());
				listerror.add(errormsg);
			}
			cancelWorkorderResponse.setErrors(listerror);
			cancelWorkorderResponse.setStatus(FAILURE);
			object = ResponseEntity.status(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getHttpStatus()).header(TRACKINGID,trackingId)
					.body(cancelWorkorderResponse);
			
		} else if(operationName.equals(WorkOrderConstants.SCHEDULE_WORK_ORDER.getValue())) {
			ScheduleWorkorderResponse scheduleWorkorderResponse = new ScheduleWorkorderResponse();
			List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.scheduleWorkOrder.Error errormsg = new com.comcast.orion.workorder.domain.scheduleWorkOrder.Error();
			Set<ConstraintViolation<?>> violationSet = e.getConstraintViolations();
			for (ConstraintViolation<?> violation : violationSet) {		
				errormsg.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				errormsg.setMessage(violation.getPropertyPath()+"-"+violation.getMessage());
				listerror.add(errormsg);
			}
			scheduleWorkorderResponse.setErrors(listerror);
			scheduleWorkorderResponse.setStatus(FAILURE);
			object = ResponseEntity.status(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getHttpStatus()).header(TRACKINGID,trackingId)
					.body(scheduleWorkorderResponse);
		}
    	return object;
    }
	/**
	 * @param ex
	 * @return ErrorMessage
	 */
	   //This method handles Exception
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ErrorMessage> handleException(Exception ex) {
		log.error("Exception occur workOrderServiceExceptionHandler#handleException -- start {}", ex);
		if(ex.getCause() instanceof OrionMiddlewareServiceException){
			return handleOrionException((OrionMiddlewareServiceException) ex.getCause());
		}
		String trackingId = MDC.get(TRACKINGID);
		ErrorMessage errorMessage = new ErrorMessage();
		List<Error> listerror = new ArrayList<>();
		Error errormsg = new Error();
		errormsg.setCode(OrionErrorCode.TECHNICAL_ERROR.getErrorCode());
		errormsg.setMessage(OrionErrorCode.TECHNICAL_ERROR.getErrorDescription() );
		listerror.add(errormsg);
		errorMessage.setErrors(listerror);
		errorMessage.setStatus(FAILURE);
		return ResponseEntity.status(OrionErrorCode.TECHNICAL_ERROR.getHttpStatus()).header(TRACKINGID,trackingId)
				.body(errorMessage);		
	}
	
	
	
	/**
	 * @param ex
	 * @return ErrorMessage
	 * 
	 */
	  //This method Handle rest client exception
	
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<ErrorMessage> handleRestClientException(RestClientException ex) {
		log.error("workOrderServiceExceptionHandler {}", ex);
		ErrorMessage errorResponse = new ErrorMessage();
		Error error = new Error();
		List<Error> errors = new ArrayList<>();
		error.setCode(OrionErrorCode.CONNECTIVITY_ERROR.getErrorCode());		
		error.setMessage(OrionErrorCode.CONNECTIVITY_ERROR.getErrorDescription());
		errors.add(error);
		errorResponse.setErrors(errors);
		errorResponse.setStatus(FAILURE);
		return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(OrionErrorCode.CONNECTIVITY_ERROR.getHttpStatus()));

	}

	

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	
	// This method handles MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage errorMessage = new ErrorMessage();
		String trackingId = MDC.get(TRACKINGID);
		ResponseEntity<Object> object=null;
		log.error("WorkOrderServiceExceptionHandler:handleException:handleMethodArgumentNotValid Validation exption",
				ex);	
		String operationName = MDC.get("operationName");
		if(operationName.equals(WorkOrderConstants.CANCEL_WORK_ORDER.getValue())){
			CancelWorkorderResponse cancelWorkorderResponse = new CancelWorkorderResponse();
			List<com.comcast.orion.workorder.domain.cancelworkorder.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.cancelworkorder.Error errormsg = new com.comcast.orion.workorder.domain.cancelworkorder.Error();			
			List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();			
			for (FieldError fieldError : fieldErrors) {
				errormsg.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				errormsg.setMessage(fieldError.getField() + " : " + fieldError.getDefaultMessage());
				listerror.add(errormsg);
			}
			cancelWorkorderResponse.setErrors(listerror);
			cancelWorkorderResponse.setStatus(FAILURE);
			object = ResponseEntity.status(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getHttpStatus()).header(TRACKINGID,trackingId)
					.body(cancelWorkorderResponse);
			
		} else if(operationName.equals(WorkOrderConstants.SCHEDULE_WORK_ORDER.getValue())) {
			ScheduleWorkorderResponse scheduleWorkorderResponse = new ScheduleWorkorderResponse();
			List<com.comcast.orion.workorder.domain.scheduleWorkOrder.Error> listerror = new ArrayList<>();
			com.comcast.orion.workorder.domain.scheduleWorkOrder.Error errormsg = new com.comcast.orion.workorder.domain.scheduleWorkOrder.Error();
			List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();			
			for (FieldError fieldError : fieldErrors) {
				errormsg.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				errormsg.setMessage(fieldError.getField() + " : " + fieldError.getDefaultMessage());
				listerror.add(errormsg);
			}
			scheduleWorkorderResponse.setErrors(listerror);
			scheduleWorkorderResponse.setStatus(FAILURE);
			object = ResponseEntity.status(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getHttpStatus()).header(TRACKINGID,trackingId)
					.body(scheduleWorkorderResponse);
		} else {		
			List<Error> listerror = new ArrayList<>();
			List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
			for (FieldError fieldError : fieldErrors) {
				Error errormsg = new Error();
				errormsg.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
				errormsg.setMessage(fieldError.getField() + " : " + fieldError.getDefaultMessage());
				listerror.add(errormsg);
			}		
			errorMessage.setErrors(listerror);
			errorMessage.setStatus(FAILURE);
			object = ResponseEntity.status(HttpStatus.BAD_REQUEST).header(TRACKINGID, trackingId)
					.body(errorMessage);
			}
		return object;
	}
	
	/**
	 * @param ex
	 * @return ErrorMessage
	 */
	  // This method handles ValidationException
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorMessage> handleValidationException(ValidationException ex) {
		log.error("workOrderServiceExceptionHandler {}", ex);
		ErrorMessage errorMessage = new ErrorMessage();
		String trackingId = MDC.get(TRACKINGID);
		errorMessage.setErrors(ex.getErrors());
		errorMessage.setStatus(FAILURE);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(TRACKINGID, trackingId)
				.body(errorMessage);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleHttpMessageNotReadable(org.springframework.http.converter.HttpMessageNotReadableException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	
	  // This method handles HttpMessageNotReadableException
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("$$$$$$$$$$$$$$$$$$$$$$$$$$$$ WorkOrderServiceExceptionHandler:handleHttpMessageNotReadable enum validation exception", ex);
		Throwable throwable = ex.getCause();
		JsonMappingException jsonMappingException = ((JsonMappingException) throwable);
		String trackingId = MDC.get(TRACKINGID);
		ErrorMessage errorMessage = getErrorMessage("Invalid Input format. "+jsonMappingException.getOriginalMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(TRACKINGID, trackingId)
				.body(errorMessage);
	}

	/**
	 * @param message
	 * @return
	 */
	private ErrorMessage getErrorMessage(String message) {
		ErrorMessage errorMessage = new ErrorMessage();
		List<Error> errors = new ArrayList<>();
		Error error = new Error();
		error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
		error.setMessage(message);
		errors.add(error);
		errorMessage.setErrors(errors);
		errorMessage.setStatus(FAILURE);
		return errorMessage;
	}
	

	/**
	 * @param cancelWorkOrderException
	 * @return
	 */
	@ExceptionHandler(CancelWorkOrderException.class)
	@ResponseBody
	public ResponseEntity<CancelWorkorderResponse> handleScheduleWorkOrderException(
			CancelWorkOrderException cancelWorkOrderException) {
		CancelWorkorderResponse cancelWorkorderResponse = new CancelWorkorderResponse();
		log.error("Exception occur workOrderServiceExceptionHandler#handleOrionException -- start", cancelWorkOrderException.getErrorMessage());
		String trackingId = MDC.get(TRACKINGID);
		List<com.comcast.orion.workorder.domain.cancelworkorder.Error> listerror = new ArrayList<>();
		com.comcast.orion.workorder.domain.cancelworkorder.Error errormsg = new com.comcast.orion.workorder.domain.cancelworkorder.Error();
		errormsg.setCode(cancelWorkOrderException.getErrorCode());
		errormsg.setMessage(cancelWorkOrderException.getErrorMessage());
		listerror.add(errormsg);
		cancelWorkorderResponse.setErrors(listerror);
		cancelWorkorderResponse.setStatus(cancelWorkOrderException.getStatus());
		return ResponseEntity.status(cancelWorkOrderException.getHttpStatus()).header(TRACKINGID,trackingId)
				.body(cancelWorkorderResponse);
	}
	
	 /* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMissingServletRequestParameter(org.springframework.web.bind.MissingServletRequestParameterException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	   protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers,
	     HttpStatus status, WebRequest request) {
	    String trackingId = MDC.get(TRACKINGID);
		ErrorMessage errorMessage = getErrorMessage(ex.getParameterName() + " parameter may not be null");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).header(TRACKINGID, trackingId)
				.body(errorMessage);
	   }
	
}
