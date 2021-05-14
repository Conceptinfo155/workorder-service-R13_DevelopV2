package com.comcast.orion.workorder.utils.exceptions;

import org.springframework.http.HttpStatus;

/**
 * The Enum ErrorCode.
 */
public enum ErrorCode {
	
	CONTRACT_VALIDATION_ERROR("CONTRACT_VALIDATION_ERROR", "",
			HttpStatus.BAD_REQUEST.value()),
	CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to ESL",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	CONNECTIVITY_ERROR_CSP("CONNECTIVITY_ERROR", "Not able to connect to CSP",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	UNAUTHORIZED("UNAUTHORIZED", "Invalid_Token",HttpStatus.UNAUTHORIZED.value()),
	TECHNICAL_ERROR("TECHNICAL_ERROR",
			"Unable to process request.",
			HttpStatus.INTERNAL_SERVER_ERROR.value()),

	ADDRESS_BUILD_NOT_ALLOWED("ADDRESS_BUILD_NOT_ALLOWED","Address build not allowed for this division",409),
	ADDRESS_BUILD_ERROR("ADDRESS_BUILD_ERROR","Address build error",590),
	BUSINESS_ERROR_ESL("BUSINESS_ERROR_ESL","Unable to process response from ESL",590),
	BUSINESS_ERROR_CSP("BUSINESS_ERROR_CSP"," Unable to determine Serviceability for this address",590),
	BUSINESS_ERROR_100("BUSINESS_ERROR_100", "Unable to process the operation. ",
					HttpStatus.INTERNAL_SERVER_ERROR.value());



	/** The error code. */
	private String errorCode;

	/** The error description. */
	private String errorDescription;

	/** The http status. */
	private int httpStatus;

	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	public int getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Instantiates a new orion error code.
	 *
	 * @param errorCode
	 *            the error code
	 * @param errorDescription
	 *            the error description
	 * @param httpStatus
	 *            the http status
	 */
	ErrorCode(String errorCode, String errorDescription, int httpStatus) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.httpStatus = httpStatus;
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
	 * Gets the error description.
	 *
	 * @return the error description
	 */
	public String getErrorDescription() {
		return errorDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return "OrionErrorCode{" + "errorCode=" + errorCode + ", errorDescription='" + errorDescription + '\''
				+ ", httpStatus='" + httpStatus + '\'' + '}';
	}

}
