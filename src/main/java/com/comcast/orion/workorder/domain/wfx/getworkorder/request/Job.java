
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The Job Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "CallFirstPhoneNum",
    "CreateDateTime",
    "TimeSlotDesc",
    "StartDateTime",
    "WorkOrderNum",
    "LastChangeOper",
    "EndDateTime",
    "TroubleCallIndicator",
    "DaylightSavingsObserved",
    "EnRouteRequestInd",
    "InitialStartDateTime",
    "OnTimeGuaranteeInd",
    "TimeSlotEndDateTime",
    "AdjDurationMins",
    "ETADateTime",
    "JobReasonCdList",
    "JobClassCd",
    "JobCustomFields",
    "TimeSlotStartDateTime",
    "JobTypeDesc",
    "JobResolutionCdList",
    "TimeZoneOffset",
    "SkillPriorityOverride",
    "ESTTime",
    "OrderNum",
    "BusinessUnit",
    "CodAmount",
    "ScheduleDate",
    "SalesmanNum",
    "TechnicianNum",
    "OrderMgmtSystem",
    "InstallerType",
    "SourceId",
    "TimeSlotCd",
    "DispatcherStatusCd",
    "JobUnits",
    "TechId",
    "JobTypeCd",
    "JobCommentTypeCdList",
    "JobNum",
    "FulfillmentCenter"
})
public class Job {

    /**
     * The Callfirstphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CallFirstPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String callFirstPhoneNum = "";
    /**
     * The Createdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CreateDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String createDateTime = "";
    /**
     * The Timeslotdesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String timeSlotDesc = "";
    /**
     * The Startdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("StartDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object startDateTime = null;
    /**
     * The Workordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkOrderNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String workOrderNum = "";
    /**
     * The Lastchangeoper Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastChangeOper")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String lastChangeOper = "";
    /**
     * The Enddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EndDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object endDateTime = null;
    /**
     * The Troublecallindicator Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TroubleCallIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String troubleCallIndicator = "";
    /**
     * The Daylightsavingsobserved Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DaylightSavingsObserved")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String daylightSavingsObserved = "";
    /**
     * The Enrouterequestind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EnRouteRequestInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object enRouteRequestInd = null;
    /**
     * The Initialstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InitialStartDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object initialStartDateTime = null;
    /**
     * The Ontimeguaranteeind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OnTimeGuaranteeInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object onTimeGuaranteeInd = null;
    /**
     * The Timeslotenddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotEndDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String timeSlotEndDateTime = "";
    /**
     * The Adjdurationmins Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AdjDurationMins")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object adjDurationMins = null;
    /**
     * The Etadatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ETADateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object eTADateTime = null;
    /**
     * The Jobreasoncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobReasonCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Object> jobReasonCdList = new ArrayList<Object>();
    /**
     * The Jobclasscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobClassCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobClassCd = "";
    /**
     * The Jobcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private JobCustomFields jobCustomFields;
    /**
     * The Timeslotstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotStartDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String timeSlotStartDateTime = "";
    /**
     * The Jobtypedesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobTypeDesc = "";
    /**
     * The Jobresolutioncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobResolutionCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Object> jobResolutionCdList = new ArrayList<Object>();
    /**
     * The Timezoneoffset Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeZoneOffset")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String timeZoneOffset = "";
    /**
     * The Skillpriorityoverride Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SkillPriorityOverride")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object skillPriorityOverride = null;
    /**
     * The Esttime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ESTTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String eSTTime = "";
    /**
     * The Ordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object orderNum = null;
    /**
     * The Businessunit Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BusinessUnit")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String businessUnit = "";
    /**
     * The Codamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CodAmount")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object codAmount = null;
    /**
     * The Scheduledate Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String scheduleDate = "";
    /**
     * The Salesmannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SalesmanNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object salesmanNum = null;
    /**
     * The Techniciannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechnicianNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String technicianNum = "";
    /**
     * The Ordermgmtsystem Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderMgmtSystem")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String orderMgmtSystem = "";
    /**
     * The Installertype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InstallerType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String installerType = "";
    /**
     * The Sourceid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SourceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String sourceId = "";
    /**
     * The Timeslotcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String timeSlotCd = "";
    /**
     * The Dispatcherstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DispatcherStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String dispatcherStatusCd = "";
    /**
     * The Jobunits Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobUnits")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobUnits = "";
    /**
     * The Techid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object techId = null;
    /**
     * The Jobtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobTypeCd = "";
    /**
     * The Jobcommenttypecdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<JobCommentTypeCdList> jobCommentTypeCdList = new ArrayList<JobCommentTypeCdList>();
    /**
     * The Jobnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobNum = "";
    /**
     * The Fulfillmentcenter Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FulfillmentCenter")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String fulfillmentCenter = "";
    /**
     * The Callfirstphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CallFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    /**
     * The Callfirstphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CallFirstPhoneNum")
    public void setCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
    }

    public Job withCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
        return this;
    }

    /**
     * The Createdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CreateDateTime")
    public String getCreateDateTime() {
        return createDateTime;
    }

    /**
     * The Createdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CreateDateTime")
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Job withCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
        return this;
    }

    /**
     * The Timeslotdesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotDesc")
    public String getTimeSlotDesc() {
        return timeSlotDesc;
    }

    /**
     * The Timeslotdesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotDesc")
    public void setTimeSlotDesc(String timeSlotDesc) {
        this.timeSlotDesc = timeSlotDesc;
    }

    public Job withTimeSlotDesc(String timeSlotDesc) {
        this.timeSlotDesc = timeSlotDesc;
        return this;
    }

    /**
     * The Startdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("StartDateTime")
    public Object getStartDateTime() {
        return startDateTime;
    }

    /**
     * The Startdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("StartDateTime")
    public void setStartDateTime(Object startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Job withStartDateTime(Object startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    /**
     * The Workordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkOrderNum")
    public String getWorkOrderNum() {
        return workOrderNum;
    }

    /**
     * The Workordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkOrderNum")
    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public Job withWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
        return this;
    }

    /**
     * The Lastchangeoper Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastChangeOper")
    public String getLastChangeOper() {
        return lastChangeOper;
    }

    /**
     * The Lastchangeoper Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastChangeOper")
    public void setLastChangeOper(String lastChangeOper) {
        this.lastChangeOper = lastChangeOper;
    }

    public Job withLastChangeOper(String lastChangeOper) {
        this.lastChangeOper = lastChangeOper;
        return this;
    }

    /**
     * The Enddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EndDateTime")
    public Object getEndDateTime() {
        return endDateTime;
    }

    /**
     * The Enddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EndDateTime")
    public void setEndDateTime(Object endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Job withEndDateTime(Object endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    /**
     * The Troublecallindicator Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TroubleCallIndicator")
    public String getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    /**
     * The Troublecallindicator Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TroubleCallIndicator")
    public void setTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
    }

    public Job withTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
        return this;
    }

    /**
     * The Daylightsavingsobserved Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DaylightSavingsObserved")
    public String getDaylightSavingsObserved() {
        return daylightSavingsObserved;
    }

    /**
     * The Daylightsavingsobserved Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DaylightSavingsObserved")
    public void setDaylightSavingsObserved(String daylightSavingsObserved) {
        this.daylightSavingsObserved = daylightSavingsObserved;
    }

    public Job withDaylightSavingsObserved(String daylightSavingsObserved) {
        this.daylightSavingsObserved = daylightSavingsObserved;
        return this;
    }

    /**
     * The Enrouterequestind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EnRouteRequestInd")
    public Object getEnRouteRequestInd() {
        return enRouteRequestInd;
    }

    /**
     * The Enrouterequestind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EnRouteRequestInd")
    public void setEnRouteRequestInd(Object enRouteRequestInd) {
        this.enRouteRequestInd = enRouteRequestInd;
    }

    public Job withEnRouteRequestInd(Object enRouteRequestInd) {
        this.enRouteRequestInd = enRouteRequestInd;
        return this;
    }

    /**
     * The Initialstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InitialStartDateTime")
    public Object getInitialStartDateTime() {
        return initialStartDateTime;
    }

    /**
     * The Initialstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InitialStartDateTime")
    public void setInitialStartDateTime(Object initialStartDateTime) {
        this.initialStartDateTime = initialStartDateTime;
    }

    public Job withInitialStartDateTime(Object initialStartDateTime) {
        this.initialStartDateTime = initialStartDateTime;
        return this;
    }

    /**
     * The Ontimeguaranteeind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OnTimeGuaranteeInd")
    public Object getOnTimeGuaranteeInd() {
        return onTimeGuaranteeInd;
    }

    /**
     * The Ontimeguaranteeind Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OnTimeGuaranteeInd")
    public void setOnTimeGuaranteeInd(Object onTimeGuaranteeInd) {
        this.onTimeGuaranteeInd = onTimeGuaranteeInd;
    }

    public Job withOnTimeGuaranteeInd(Object onTimeGuaranteeInd) {
        this.onTimeGuaranteeInd = onTimeGuaranteeInd;
        return this;
    }

    /**
     * The Timeslotenddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotEndDateTime")
    public String getTimeSlotEndDateTime() {
        return timeSlotEndDateTime;
    }

    /**
     * The Timeslotenddatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotEndDateTime")
    public void setTimeSlotEndDateTime(String timeSlotEndDateTime) {
        this.timeSlotEndDateTime = timeSlotEndDateTime;
    }

    public Job withTimeSlotEndDateTime(String timeSlotEndDateTime) {
        this.timeSlotEndDateTime = timeSlotEndDateTime;
        return this;
    }

    /**
     * The Adjdurationmins Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AdjDurationMins")
    public Object getAdjDurationMins() {
        return adjDurationMins;
    }

    /**
     * The Adjdurationmins Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AdjDurationMins")
    public void setAdjDurationMins(Object adjDurationMins) {
        this.adjDurationMins = adjDurationMins;
    }

    public Job withAdjDurationMins(Object adjDurationMins) {
        this.adjDurationMins = adjDurationMins;
        return this;
    }

    /**
     * The Etadatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ETADateTime")
    public Object getETADateTime() {
        return eTADateTime;
    }

    /**
     * The Etadatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ETADateTime")
    public void setETADateTime(Object eTADateTime) {
        this.eTADateTime = eTADateTime;
    }

    public Job withETADateTime(Object eTADateTime) {
        this.eTADateTime = eTADateTime;
        return this;
    }

    /**
     * The Jobreasoncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobReasonCdList")
    public List<Object> getJobReasonCdList() {
        return jobReasonCdList;
    }

    /**
     * The Jobreasoncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobReasonCdList")
    public void setJobReasonCdList(List<Object> jobReasonCdList) {
        this.jobReasonCdList = jobReasonCdList;
    }

    public Job withJobReasonCdList(List<Object> jobReasonCdList) {
        this.jobReasonCdList = jobReasonCdList;
        return this;
    }

    /**
     * The Jobclasscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobClassCd")
    public String getJobClassCd() {
        return jobClassCd;
    }

    /**
     * The Jobclasscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobClassCd")
    public void setJobClassCd(String jobClassCd) {
        this.jobClassCd = jobClassCd;
    }

    public Job withJobClassCd(String jobClassCd) {
        this.jobClassCd = jobClassCd;
        return this;
    }

    /**
     * The Jobcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomFields")
    public JobCustomFields getJobCustomFields() {
        return jobCustomFields;
    }

    /**
     * The Jobcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomFields")
    public void setJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
    }

    public Job withJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
        return this;
    }

    /**
     * The Timeslotstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotStartDateTime")
    public String getTimeSlotStartDateTime() {
        return timeSlotStartDateTime;
    }

    /**
     * The Timeslotstartdatetime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotStartDateTime")
    public void setTimeSlotStartDateTime(String timeSlotStartDateTime) {
        this.timeSlotStartDateTime = timeSlotStartDateTime;
    }

    public Job withTimeSlotStartDateTime(String timeSlotStartDateTime) {
        this.timeSlotStartDateTime = timeSlotStartDateTime;
        return this;
    }

    /**
     * The Jobtypedesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeDesc")
    public String getJobTypeDesc() {
        return jobTypeDesc;
    }

    /**
     * The Jobtypedesc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeDesc")
    public void setJobTypeDesc(String jobTypeDesc) {
        this.jobTypeDesc = jobTypeDesc;
    }

    public Job withJobTypeDesc(String jobTypeDesc) {
        this.jobTypeDesc = jobTypeDesc;
        return this;
    }

    /**
     * The Jobresolutioncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobResolutionCdList")
    public List<Object> getJobResolutionCdList() {
        return jobResolutionCdList;
    }

    /**
     * The Jobresolutioncdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobResolutionCdList")
    public void setJobResolutionCdList(List<Object> jobResolutionCdList) {
        this.jobResolutionCdList = jobResolutionCdList;
    }

    public Job withJobResolutionCdList(List<Object> jobResolutionCdList) {
        this.jobResolutionCdList = jobResolutionCdList;
        return this;
    }

    /**
     * The Timezoneoffset Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeZoneOffset")
    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    /**
     * The Timezoneoffset Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeZoneOffset")
    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public Job withTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }

    /**
     * The Skillpriorityoverride Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SkillPriorityOverride")
    public Object getSkillPriorityOverride() {
        return skillPriorityOverride;
    }

    /**
     * The Skillpriorityoverride Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SkillPriorityOverride")
    public void setSkillPriorityOverride(Object skillPriorityOverride) {
        this.skillPriorityOverride = skillPriorityOverride;
    }

    public Job withSkillPriorityOverride(Object skillPriorityOverride) {
        this.skillPriorityOverride = skillPriorityOverride;
        return this;
    }

    /**
     * The Esttime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ESTTime")
    public String getESTTime() {
        return eSTTime;
    }

    /**
     * The Esttime Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ESTTime")
    public void setESTTime(String eSTTime) {
        this.eSTTime = eSTTime;
    }

    public Job withESTTime(String eSTTime) {
        this.eSTTime = eSTTime;
        return this;
    }

    /**
     * The Ordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderNum")
    public Object getOrderNum() {
        return orderNum;
    }

    /**
     * The Ordernum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderNum")
    public void setOrderNum(Object orderNum) {
        this.orderNum = orderNum;
    }

    public Job withOrderNum(Object orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    /**
     * The Businessunit Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BusinessUnit")
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * The Businessunit Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BusinessUnit")
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Job withBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
        return this;
    }

    /**
     * The Codamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CodAmount")
    public Object getCodAmount() {
        return codAmount;
    }

    /**
     * The Codamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CodAmount")
    public void setCodAmount(Object codAmount) {
        this.codAmount = codAmount;
    }

    public Job withCodAmount(Object codAmount) {
        this.codAmount = codAmount;
        return this;
    }

    /**
     * The Scheduledate Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * The Scheduledate Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Job withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    /**
     * The Salesmannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SalesmanNum")
    public Object getSalesmanNum() {
        return salesmanNum;
    }

    /**
     * The Salesmannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SalesmanNum")
    public void setSalesmanNum(Object salesmanNum) {
        this.salesmanNum = salesmanNum;
    }

    public Job withSalesmanNum(Object salesmanNum) {
        this.salesmanNum = salesmanNum;
        return this;
    }

    /**
     * The Techniciannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechnicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

    /**
     * The Techniciannum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechnicianNum")
    public void setTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
    }

    public Job withTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
        return this;
    }

    /**
     * The Ordermgmtsystem Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderMgmtSystem")
    public String getOrderMgmtSystem() {
        return orderMgmtSystem;
    }

    /**
     * The Ordermgmtsystem Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("OrderMgmtSystem")
    public void setOrderMgmtSystem(String orderMgmtSystem) {
        this.orderMgmtSystem = orderMgmtSystem;
    }

    public Job withOrderMgmtSystem(String orderMgmtSystem) {
        this.orderMgmtSystem = orderMgmtSystem;
        return this;
    }

    /**
     * The Installertype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InstallerType")
    public String getInstallerType() {
        return installerType;
    }

    /**
     * The Installertype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("InstallerType")
    public void setInstallerType(String installerType) {
        this.installerType = installerType;
    }

    public Job withInstallerType(String installerType) {
        this.installerType = installerType;
        return this;
    }

    /**
     * The Sourceid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SourceId")
    public String getSourceId() {
        return sourceId;
    }

    /**
     * The Sourceid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("SourceId")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Job withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    /**
     * The Timeslotcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    /**
     * The Timeslotcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TimeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    public Job withTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
        return this;
    }

    /**
     * The Dispatcherstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DispatcherStatusCd")
    public String getDispatcherStatusCd() {
        return dispatcherStatusCd;
    }

    /**
     * The Dispatcherstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DispatcherStatusCd")
    public void setDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
    }

    public Job withDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
        return this;
    }

    /**
     * The Jobunits Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    /**
     * The Jobunits Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobUnits")
    public void setJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
    }

    public Job withJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
        return this;
    }

    /**
     * The Techid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechId")
    public Object getTechId() {
        return techId;
    }

    /**
     * The Techid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TechId")
    public void setTechId(Object techId) {
        this.techId = techId;
    }

    public Job withTechId(Object techId) {
        this.techId = techId;
        return this;
    }

    /**
     * The Jobtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeCd")
    public String getJobTypeCd() {
        return jobTypeCd;
    }

    /**
     * The Jobtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobTypeCd")
    public void setJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
    }

    public Job withJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
        return this;
    }

    /**
     * The Jobcommenttypecdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCdList")
    public List<JobCommentTypeCdList> getJobCommentTypeCdList() {
        return jobCommentTypeCdList;
    }

    /**
     * The Jobcommenttypecdlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCdList")
    public void setJobCommentTypeCdList(List<JobCommentTypeCdList> jobCommentTypeCdList) {
        this.jobCommentTypeCdList = jobCommentTypeCdList;
    }

    public Job withJobCommentTypeCdList(List<JobCommentTypeCdList> jobCommentTypeCdList) {
        this.jobCommentTypeCdList = jobCommentTypeCdList;
        return this;
    }

    /**
     * The Jobnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobNum")
    public String getJobNum() {
        return jobNum;
    }

    /**
     * The Jobnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobNum")
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Job withJobNum(String jobNum) {
        this.jobNum = jobNum;
        return this;
    }

    /**
     * The Fulfillmentcenter Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FulfillmentCenter")
    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }

    /**
     * The Fulfillmentcenter Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FulfillmentCenter")
    public void setFulfillmentCenter(String fulfillmentCenter) {
        this.fulfillmentCenter = fulfillmentCenter;
    }

    public Job withFulfillmentCenter(String fulfillmentCenter) {
        this.fulfillmentCenter = fulfillmentCenter;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(callFirstPhoneNum).append(createDateTime).append(timeSlotDesc).append(startDateTime).append(workOrderNum).append(lastChangeOper).append(endDateTime).append(troubleCallIndicator).append(daylightSavingsObserved).append(enRouteRequestInd).append(initialStartDateTime).append(onTimeGuaranteeInd).append(timeSlotEndDateTime).append(adjDurationMins).append(eTADateTime).append(jobReasonCdList).append(jobClassCd).append(jobCustomFields).append(timeSlotStartDateTime).append(jobTypeDesc).append(jobResolutionCdList).append(timeZoneOffset).append(skillPriorityOverride).append(eSTTime).append(orderNum).append(businessUnit).append(codAmount).append(scheduleDate).append(salesmanNum).append(technicianNum).append(orderMgmtSystem).append(installerType).append(sourceId).append(timeSlotCd).append(dispatcherStatusCd).append(jobUnits).append(techId).append(jobTypeCd).append(jobCommentTypeCdList).append(jobNum).append(fulfillmentCenter).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Job) == false) {
            return false;
        }
        Job rhs = ((Job) other);
        return new EqualsBuilder().append(callFirstPhoneNum, rhs.callFirstPhoneNum).append(createDateTime, rhs.createDateTime).append(timeSlotDesc, rhs.timeSlotDesc).append(startDateTime, rhs.startDateTime).append(workOrderNum, rhs.workOrderNum).append(lastChangeOper, rhs.lastChangeOper).append(endDateTime, rhs.endDateTime).append(troubleCallIndicator, rhs.troubleCallIndicator).append(daylightSavingsObserved, rhs.daylightSavingsObserved).append(enRouteRequestInd, rhs.enRouteRequestInd).append(initialStartDateTime, rhs.initialStartDateTime).append(onTimeGuaranteeInd, rhs.onTimeGuaranteeInd).append(timeSlotEndDateTime, rhs.timeSlotEndDateTime).append(adjDurationMins, rhs.adjDurationMins).append(eTADateTime, rhs.eTADateTime).append(jobReasonCdList, rhs.jobReasonCdList).append(jobClassCd, rhs.jobClassCd).append(jobCustomFields, rhs.jobCustomFields).append(timeSlotStartDateTime, rhs.timeSlotStartDateTime).append(jobTypeDesc, rhs.jobTypeDesc).append(jobResolutionCdList, rhs.jobResolutionCdList).append(timeZoneOffset, rhs.timeZoneOffset).append(skillPriorityOverride, rhs.skillPriorityOverride).append(eSTTime, rhs.eSTTime).append(orderNum, rhs.orderNum).append(businessUnit, rhs.businessUnit).append(codAmount, rhs.codAmount).append(scheduleDate, rhs.scheduleDate).append(salesmanNum, rhs.salesmanNum).append(technicianNum, rhs.technicianNum).append(orderMgmtSystem, rhs.orderMgmtSystem).append(installerType, rhs.installerType).append(sourceId, rhs.sourceId).append(timeSlotCd, rhs.timeSlotCd).append(dispatcherStatusCd, rhs.dispatcherStatusCd).append(jobUnits, rhs.jobUnits).append(techId, rhs.techId).append(jobTypeCd, rhs.jobTypeCd).append(jobCommentTypeCdList, rhs.jobCommentTypeCdList).append(jobNum, rhs.jobNum).append(fulfillmentCenter, rhs.fulfillmentCenter).isEquals();
    }

}
