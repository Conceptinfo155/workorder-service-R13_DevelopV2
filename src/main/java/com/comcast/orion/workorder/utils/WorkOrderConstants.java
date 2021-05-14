package com.comcast.orion.workorder.utils;

import java.io.Serializable;

/**
 * WorkOrderConstants
 *
 */

public enum  WorkOrderConstants implements Serializable {
	
	
	OPERATION("operation"),
	
	ORDER_NUMBER ("orderNumber"),
	
	CREATE_WORKORDER("createWorkOrder"),
	
	UPDATE_WORKORDER("updateWorkOrder"),
	
	GET_WORKORDER("getworkorder"),
	
	FIELD_WFXTECH_LOGIN("WFXTechLogin"),
	
	FIELD_ORDERMGMT_SYSTEM("OrderMgtSystem"),
	
	FIELD_ADDR_ID("AddrId"),
	
	FIELD_JOB_NO("JobNum"),
	
	TRACKING_ID("trackingId"),

	SOURCE("source"),

	EVENT_NAME_HEADER_KEY("eventName"),
	
	FIELD_SCHEDULE_DATE("ScheduleDate"),
	
	FIELD_TIMESLOT_CD("TimeSlotCd"),
	
	FIELD_JOB_UNITS("JobUnits"),
	
	FIELD_CUSTOMER_ID("CustomerId"),
	
	FIELD_LAST_NAME("LastName"),
	
	FIELD_JOBTYPECODE("JobTypeCd"),
	
	FIELD_DISPATCHSTATUS_CD("DispatcherStatusCd"),
	
	FIELD_WORKPHONE_NO("WorkPhoneNum"),
	
	FIELD_DATE("Date"),
	
	FIELD_SPA("SPA"),
	
	FIELD_WORKORDERNOTFOUND("Update packet work order not in WFX DB"),
	
	SCHEDULE_WORK_ORDER("scheduleworkorder"),
	
	CANCEL_WORK_ORDER("cancelworkorder"),
	
	RESCHEDULE_APPOINTMENT("reScheduleAppointment"),
	
	GET_WFX_WORKORDER("getWFXWorkorder"),
	
	INVOKE_SERVICE("INVOKE_SERVICE"),
	
	WORKORDER("workorder"),
	
	INVOKE_INSTALL_BASE_SERVICE("INVOKE_INSTALL_BASE_SERVICE"),
	
	PRODUCT("PRODUCT"),
	
	SITE_ID("SITE_ID"),
	
	INSTALL_BASE("installbase"),
	
	FIELD_EMAIL_ADDR("EmailAddr"),

	JOB_REASON_CODE("JOB_REASON_CODE"),

	ODS("ODS"),
	
    INVOKE_VMS_SERVICE("INVOKE_VMS_SERVICE"),
	
	CANCEL_POINT_OF_INTEREST("cancelPointofInterest"),
	
	ODO_WO_DETAILS("ODOWorkOrderDetails"),

	
	VMS("vms"),
	
	SITE("site"),
	
	LOCATION("location"),

	ACCOUNT("account"),

	DATA("data"),

	INBOUND_REQUEST("inboundRequest");
	
	/**
	 * Authorization
	 */
	public static final String AUTHORIZATION = "Authorization";
	
	/**
	 * INVALIDFORMAT
	 */
	public static final String INVALIDFORMAT = "Invalid data provided for the field ";
	
	/**
	 * CREATEWORKORDER
	 */
	public static final String CREATEWORKORDER = "createWorkOrder";
	/**
	 * GETWORKORDER
	 */
	public static final String GETWORKORDER = "getWorkOrder";
	
	public static final String SOLUTION_TYPE = "SOLUTION_TYPE";
	
	public static final String TRANSPORT_TYPE = "TRANSPORT_TYPE";
	
	public static final String ORDER_TYPE = "ORDER_TYPE";
	
	public static final String ORDER_TYPE_TC = "TC";
	
	public static final String JOB_TYPE_CODE = "JOB_TYPE_CODE";
	
	public static final String QUOTA_POINTS = "QUOTA_POINTS";
	
	public static final String TC_NA = "NA";
	/**
	 * CLIENT_ID
	 */
	public static final String CLIENT_ID="client_id";
	
	/**
	 * CLIENT_SECRET
	 */
	public static final String CLIENT_SECRET="client_secret";
	
	/**
	 * GRANT_TYPE
	 */
	public static final String GRANT_TYPE="grant_type";
	
	/**
	 * SCOPE
	 */
	public static final String SCOPE="scope";
	
	/**
	 * JOB_TYPE_M5
	 */
	public static final String JOB_TYPE_M5="M5";
	
	/**
	 * JOB_TYPE_V7
	 */
	public static final String JOB_TYPE_V7="V7";

	public static final String ORDER_TYPE_PREWIRE = "PREWIRE";

	public static final String ORDER_TYPE_SRO = "SRO";

	public static final String ORDER_TYPE_CHANGE = "Change";

	public static final String ORDER_TYPE_DISCONNECT = "Disconnect";

	public static final String ORDER_TYPE_NEW = "New";
	
	public static final String BUSINESS_ERROR_OT = "BUSINESS_ERROR_OT";
	
	public static final String SUCCESS = "SUCCESS";
	
	public static final String FAILURE = "FAILURE";
	
	public static final String OK = "OK";
	
	public static final String SDWAN = "SD-WAN";
	
	public static final String ECPM_CUSTOMER = "ECPM_CUSTOMER";
	
	public static final String ENTERPRISE = "Enterprise";
	
	public static final String MIDMARKET = "Midmarket";
	
    public static final String USERNAME = "username";
	
	public static final String PASSWORD = "password";
	
	public static final String ENDPOINT = "endpoint";
	
	private String property = null;
	
	WorkOrderConstants(String property){
        this.property = property;
    }

    /**
     * @param value
     * @return
     */
    public static WorkOrderConstants fromValue(String value){
        return valueOf(value);
    }

    public String getValue(){
        return property;
    }

}
