package com.comcast.orion.workorder.utils.exceptions;

import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;

/**
 * The Class PostInstallNotificationAdapterException.
 */
public class ScheduleWorkOrderException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error code. */
	private String errorCode;

	/** The error message. */
	private String errorMessage;

	/** The http status. */
	private int httpStatus;
	private String workOrderNumber;
	private ScheduleWorkorderResponse scheduleWorkorderResponse;
	

	/**
	 * Instantiates a new post install notification adapter exception.
	 *
	 * @param errorCode
	 *            the error code
	 */
	public ScheduleWorkOrderException(OrionErrorCode errorCode) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}
	
	public ScheduleWorkOrderException(OrionErrorCode errorCode,String message) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = message;
		this.httpStatus = errorCode.getHttpStatus();
	}

	public ScheduleWorkOrderException(OrionErrorCode errorCode, String message,String workOrderNumber) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = message;
		this.httpStatus = errorCode.getHttpStatus();
		this.workOrderNumber= workOrderNumber;
	}
	

	
	public ScheduleWorkOrderException(OrionErrorCode errorCode, String errorMessage, int rawStatusCode,String workOrderNumber) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription() + errorMessage;
		this.httpStatus = rawStatusCode;
		this.workOrderNumber= workOrderNumber;
	}
	
	public ScheduleWorkOrderException(OrionErrorCode errorCode, Throwable e) {
		super("Fallback " + errorCode.getErrorCode() + errorCode.getErrorDescription(), e);
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}

	public ScheduleWorkOrderException(OrionErrorCode errorCode, ScheduleWorkorderResponse response) {
		this.errorCode = errorCode.getErrorCode();
		this.scheduleWorkorderResponse = response;
		this.httpStatus = errorCode.getHttpStatus();
	}
	
	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public int getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public ScheduleWorkorderResponse getScheduleWorkorderResponse() {
		return scheduleWorkorderResponse;
	}

	public void setScheduleWorkorderResponse(ScheduleWorkorderResponse scheduleWorkorderResponse) {
		this.scheduleWorkorderResponse = scheduleWorkorderResponse;
	}

}
