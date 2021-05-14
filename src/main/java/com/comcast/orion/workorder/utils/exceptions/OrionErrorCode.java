package com.comcast.orion.workorder.utils.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public enum  OrionErrorCode  implements Serializable {
	
	SCHEDULE_SERVICE_UPDATE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to schedule service to update appointment",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	SCHEDULE_SERVICE_CANCEL_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to schedule service to cancel appointment",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	SCHEDULE_SERVICE_CANCEL_BUSINESS_ERROR("BUSINESS_ERROR", "Not able to cancel appointment",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	SCHEDULE_SERVICE_UPDATE_BUSINESS_ERROR("BUSINESS_ERROR", "Not able to update appointment",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	UPDATE_WORKORDER_FAILED ("UPDATE_WORKORDER_FAILED","", 590),
	NEW_WO_CREATION("UPDATE_WORKORDER_FAILED_NEW_WORKORDER_CREATED","107 - Failure to update workorder",591),
	CREATE_CANCEL_FAILURE("UPDATE_WORKORDER_FAILED_NEW_WORKORDER_CREATED_OLD_WORKORDER_CANCEL_FAILED","107 - Failure to update workorder",591),
	CONTRACT_VALIDATION_ERROR("CONTRACT_VALIDATION_ERROR", "",
			HttpStatus.BAD_REQUEST.value()),
	BUSINESS_ERROR_WFX("BUSINESS_ERROR_WFX", "", 590),
	LOCATION_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to Location service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	PRODUCT_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to Product service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	INSTALLBASE_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to InstallBase service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	ACCOUNT_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to Account service.",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	DATA_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to Data service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	VMS_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to VMS",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	VMS_CONNECTIVITY_ERR("CONNECTIVITY_ERROR", "",
			HttpStatus.SERVICE_UNAVAILABLE.value()),

	OTT_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to OfficeTrack",503),
	BUSINESS_ERROR_ACCOUNT("BUSINESS_ERROR_ACCOUNT", "Account service error.", 590),
	BUSINESS_ERROR_DATA("BUSINESS_ERROR_DATA", "Data service error.", 590),
	BUSINESS_ERROR_OTT("BUSINESS_ERROR_OTT", "", 590),

	SCHEDULE_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to schedule service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	SITE_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to site service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	GETWO_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to AMIL",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to WFX",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	REFERENCEDATA_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to ReferenceData service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	PAGE_NOT_FOUND("PAGE_NOT_FOUND_ERROR", "Requested page not found", 
			HttpStatus.NOT_FOUND.value()),
	
	NO_RECORD_FOUND("NO_RECORD_FOUND", "Future work order not available in this site",
			404),
	GETWFXWO_NO_RECORD_FOUND("NO_RECORD_FOUND", "Workorder not found. ",
			HttpStatus.NOT_FOUND.value()),
	TECHNICAL_ERROR("TECHNICAL_ERROR",
			"Unable to process request.",
			HttpStatus.INTERNAL_SERVER_ERROR.value()),
	BUSINESS_ERROR_WFAINVALIDWO("BUSINESS_ERROR_WFA", "Unable to find details of the work Order Number provided", 590),
	BUSINESS_ERROR_WFA_INVALID_SITEID("BUSINESS_ERROR_WFA", "Unable to find details of the site id provided", 590),
	BUSINESS_ERROR_WFA("BUSINESS_ERROR_WFA", "", 590),
	BUSINESS_ERROR_PRODUCT_INVALID_ID("BUSINESS_ERROR_PRODUCT", "Unable to find service details of the customer id, site id provided", 590),
	BUSINESS_ERROR_INSTALLBASE_INVALID_ID("BUSINESS_ERROR_INSTALLBASE", "Invalid ServiceID", 590),
	BUSINESS_ERROR_PRODUCT("BUSINESS_ERROR_PRODUCT", "", 590),
	BUSINESS_ERROR_INSTALLBASE("BUSINESS_ERROR_INSTALLBASE", "", 590),
	BUSINESS_ERROR_VMS("BUSINESS_ERROR_VMS", "", 590),
	BUSINESS_ERROR_VMS_ERR("BUSINESS_ERROR_VMS", "Unable to process request in VMS", 590),
	BUSINESS_ERROR_SITE("BUSINESS_ERROR_SITE","Site service error.", 590),
	CONTRACT_HEADER_VALIDATION("CONTRACT_VALIDATION_ERROR", "Mandatory Field is missing in the request",
			HttpStatus.BAD_REQUEST.value()),
	BUS_AMIL_ERR("BUS_AMIL_ERR", "ERR003?workOrderId not found",
			590),
	GETWFXWO_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to WFA",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	CANCEL_WORKORDER_FAILED("CANCEL_WORKORDER_FAILED","",590),
	SITE_CONNECTIVITY_ERROR("CANCEL_WORKORDER_FAILED", "Not able to connect to site service",HttpStatus.SERVICE_UNAVAILABLE.value()),
	SCHEDULE_CONNECTIVITY_ERROR("CANCEL_APPOINTMENT_FAILED", "Not able to connect to schedule service",HttpStatus.SERVICE_UNAVAILABLE.value()),
	CANCEL_APPOINTMENT_FAILED("CANCEL_APPOINTMENT_FAILED","",591),
	APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED("APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED","", 591),
	APPOINTMENT_WORKORDER_NOT_SCHEDULED("APPOINTMENT_WORKORDER_NOT_SCHEDULED","",590),
	TECH_AMIL_ERR("TECH_AMIL_ERR", "AMIL Could not Connect to Target System - [HTTPAdaptor] "
			+ "Can not connect to HTTP Server[iillin4591-22500], Message[java.net.UnknownHostException- iillin4591]  Generic", 590),
	UPDATE_APPOINTMENT_SUCCESS_WORKORDER_UPDATE_FAILED("UPDATE_APPOINTMENT_SUCCESS_WORKORDER_UPDATE_FAILED", "",591),
	NOTES_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to Notes service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	
	RESPONSE_PROCESS_ERROR("BUSINESS_ERROR_WFA", "Unable to to process the response from WFA", 590),
	APPOINTMENT_SCHEDULED_WORKORDER_NOT_UPDATED("APPOINTMENT_SCHEDULED_WORKORDER_NOT_UPDATED", "", 591),
	BUSINESS_ERROR_100("BUSINESS_ERROR_100", "Unable to process the operation. ",
			HttpStatus.INTERNAL_SERVER_ERROR.value()),
	ODS_SERVICE_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to ODS service",
			HttpStatus.SERVICE_UNAVAILABLE.value()),
	BUSINESS_ERROR_OT("BUSINESS_ERROR_OT","", 590),
	TECHNICAL_ERROR_OFFICETRACK("TECHNICAL_ERROR_OFFICETRACK",
					"Unable to process request.",
					HttpStatus.INTERNAL_SERVER_ERROR.value()),
	ONP_CONNECTIVITY_ERROR("CONNECTIVITY_ERROR", "Not able to connect to ONP",503),;

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
	OrionErrorCode(String errorCode, String errorDescription, int httpStatus) {
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
