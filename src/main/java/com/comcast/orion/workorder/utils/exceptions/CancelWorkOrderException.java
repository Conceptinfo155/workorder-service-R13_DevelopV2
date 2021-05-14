package com.comcast.orion.workorder.utils.exceptions;

/**
 * The Class PostInstallNotificationAdapterException.
 */
public class CancelWorkOrderException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The error code. */
	private String errorCode;

	/** The error message. */
	private String errorMessage;

	/** The http status. */
	private int httpStatus;
	
	private String status;

	/**
	 * Instantiates a new post install notification adapter exception.
	 *
	 * @param errorCode
	 *            the error code
	 */
	public CancelWorkOrderException(OrionErrorCode errorCode) {
		super(errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}
	
	public CancelWorkOrderException(OrionErrorCode errorCode, String status) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
		this.status=status;
	}
	
	public CancelWorkOrderException(OrionErrorCode errorCode, Throwable e) {
		super("Fallback " + errorCode.getErrorCode() + errorCode.getErrorDescription(), e);
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
		this.status="FAILURE";
	}

	public CancelWorkOrderException(OrionErrorCode errorCode, String errorMessage, String status) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription() + errorMessage;
		this.httpStatus = errorCode.getHttpStatus();
		this.status=status;
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

	public String getStatus() {
		return status;
	}


}
