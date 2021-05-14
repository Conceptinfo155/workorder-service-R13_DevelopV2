package com.comcast.orion.workorder.utils.exceptions;

import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;

public class RescheduleWorkOrderException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	public String getNewWorkOrderNumber() {
		return newWorkOrderNumber;
	}
	public void setNewWorkOrderNumber(String newWorkOrderNumber) {
		this.newWorkOrderNumber = newWorkOrderNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/** The error message. */
	private String errorMessage;

	/** The http status. */
	private int httpStatus;
	private String workOrderNumber;
	private String newWorkOrderNumber;
	private RescheduleWorkorderResponse rescheduleWorkorderResponse;
	
	public RescheduleWorkOrderException(OrionErrorCode errorCode, Throwable e) {
		super("Fallback " + errorCode.getErrorCode() + errorCode.getErrorDescription(), e);
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}
	
	public RescheduleWorkOrderException(OrionErrorCode errorCode,String message) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = message;
		this.httpStatus = errorCode.getHttpStatus();
	}
	public RescheduleWorkOrderException(OrionErrorCode errorCode) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}
	public RescheduleWorkOrderException(OrionErrorCode errorCode, String message,String workOrderNumber) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = message;
		this.httpStatus = errorCode.getHttpStatus();
		this.workOrderNumber= workOrderNumber;
	}
	

	

	
	public RescheduleWorkOrderException(OrionErrorCode errorCode, String errorMessage, int rawStatusCode,String workOrderNumber) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription() + errorMessage;
		this.httpStatus = rawStatusCode;
		this.workOrderNumber= workOrderNumber;
	}
	public RescheduleWorkOrderException(OrionErrorCode errorCode, String workOrderNumber,String newWONumber, String status) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.status =status;
		if(newWONumber!=null&&newWONumber!="") {
			this.newWorkOrderNumber=newWONumber;
		}
		this.httpStatus = errorCode.getHttpStatus();
		this.workOrderNumber= workOrderNumber;
	}
	
	public RescheduleWorkOrderException(OrionErrorCode errorCode,String description, String workOrderNumber,String newWONumber, String status) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = description;
		this.status =status;
		if(newWONumber!=null&&newWONumber!="") {
			this.newWorkOrderNumber=newWONumber;
		}
		this.httpStatus = errorCode.getHttpStatus();
		this.workOrderNumber= workOrderNumber;
	}
	
	
	public RescheduleWorkorderResponse getRescheduleWorkorderResponse() {
		return rescheduleWorkorderResponse;
	}
	public void setRescheduleWorkorderResponse(RescheduleWorkorderResponse rescheduleWorkorderResponse) {
		this.rescheduleWorkorderResponse = rescheduleWorkorderResponse;
	}

	public RescheduleWorkOrderException(OrionErrorCode errorCode, RescheduleWorkorderResponse response) {
		this.errorCode = errorCode.getErrorCode();
		this.rescheduleWorkorderResponse = response;
		this.httpStatus = errorCode.getHttpStatus();
	}
}
