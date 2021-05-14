package com.comcast.orion.workorder.utils.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.comcast.orion.workorder.domain.Error;

/**
 * ValidationException
 *
 */
public class ValidationException extends Exception{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @return HttpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return Error
	 */
	public List<Error> getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 */
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	/** The http status. */
	private HttpStatus httpStatus;
	
	/** The errors. */

	private transient List<Error> errors = new ArrayList<>();

	/**
	 * @param message
	 * @param errors
	 * @param httpStatus
	 */
	public ValidationException(String message, List<Error> errors, HttpStatus httpStatus) {
		super(message);
		this.errors = errors;
		this.httpStatus = httpStatus;
	}

}
