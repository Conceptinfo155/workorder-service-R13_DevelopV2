/*
 * 
 */
package com.comcast.orion.workorder.utils.exceptions;

import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.ErrorCode;
import com.comcast.orion.workorder.domain.ErrorMessage;

/**
 * The Class OrionMiddlewareServiceException.
 */
public class OrionMiddlewareServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	

	/** The error code. */
	private String errorCode;

	/** The error message. */
	private String errorMessage;

	/** The http status. */
	private int httpStatus;

	/**
	 * Instantiates a new orion middleware service exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the errorMessage
	 */
	public OrionMiddlewareServiceException(OrionErrorCode errorCode, String errorMessage) {
		super(errorCode.getErrorDescription() + errorMessage);
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription() + errorMessage;
		this.httpStatus = errorCode.getHttpStatus();
	}

	/**
	 * Instantiates a new orion middleware service exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the errorMessage
	 */
	public OrionMiddlewareServiceException(OrionErrorCode errorCode) {
		super(errorCode.getErrorCode() + errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}

	/**
	 * Instantiates a new orion middleware service exception.
	 *
	 * @param errorCode the error code
	 * @param e the e
	 */
	public OrionMiddlewareServiceException(OrionErrorCode errorCode, Throwable e) {
		super("Fallback " + errorCode.getErrorCode() + errorCode.getErrorDescription(), e);
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}

	public OrionMiddlewareServiceException(OrionErrorCode errorCode, String errorMessage, int rawStatusCode) {
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription() + errorMessage;
		this.httpStatus = rawStatusCode;
	}
	

/*	public OrionMiddlewareServiceException(OrionMiddlewareServiceException orionMiddlewareServiceException) {
		this.errorCode = orionMiddlewareServiceException.errorCode;
		this.errorMessage = orionMiddlewareServiceException.errorMessage;
		this.httpStatus = orionMiddlewareServiceException.getHttpStatus();
	}
	
	*//**
	 * Instantiates a new orion middleware service exception.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorMessage
	 *            the errorMessage
	 *//*
	public OrionMiddlewareServiceException(ErrorCode errorCode) {
		super(errorCode.getErrorCode() + errorCode.getErrorDescription());
		this.errorCode = errorCode.getErrorCode();
		this.errorMessage = errorCode.getErrorDescription();
		this.httpStatus = errorCode.getHttpStatus();
	}
*/	/**
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

}