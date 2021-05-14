
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Description of the job
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "workOrderNumber",
    "scheduleDate",
    "jobReasonCode",
    "technicianNum",
    "technicianId",
    "timeSlotStartDateTime",
    "timeSlotEndDateTime",
    "timeSlotCd",
    "timeslotDescription",
    "timeZoneOffset",
    "callFirstPhoneNum",
    "troubleCallIndicator",
    "jobComment",
    "orderComment",
    "jobClassCd",
    "jobTypeDesc",
    "SysPrinAgent",
    "dispatcherStatusCd",
    "jobUnits",
    "jobTypeCd",
    "jobNum",
    "fulfillmentCenter",
    "JobCustomFields"
})
public class Job {

    /**
     * Work order Number
     * 
     */
    @JsonProperty("workOrderNumber")
    @JsonPropertyDescription("Work order Number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Work order Number", example = "ORION-098098")
    private String workOrderNumber;
    /**
     * The scheduled date
     * 
     */
    @JsonProperty("scheduleDate")
    @JsonPropertyDescription("The scheduled date")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The scheduled date", example = "2018-12-11")
    private String scheduleDate;
    /**
     * The scheduled date
     * 
     */
    @JsonProperty("jobReasonCode")
    @JsonPropertyDescription("The scheduled date")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The scheduled date", example = "2018-12-11")
    private String jobReasonCode;
    /**
     * The scheduled date
     * 
     */
    @JsonProperty("technicianNum")
    @JsonPropertyDescription("The scheduled date")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The scheduled date", example = "2018-12-11")
    private String technicianNum;
    /**
     * The assigned technician ID
     * 
     */
    @JsonProperty("technicianId")
    @JsonPropertyDescription("The assigned technician ID")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The assigned technician ID", example = "2018-12-11")
    private String technicianId;
    /**
     * Start date of the time slot
     * 
     */
    @JsonProperty("timeSlotStartDateTime")
    @JsonPropertyDescription("Start date of the time slot")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Start date of the time slot", example = "2018-12-11T12:00:00-08:00")
    private String timeSlotStartDateTime;
    /**
     * End date of the time slot
     * 
     */
    @JsonProperty("timeSlotEndDateTime")
    @JsonPropertyDescription("End date of the time slot")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "End date of the time slot", example = "2018-12-11T14:00:00-08:00")
    private String timeSlotEndDateTime;
    /**
     * Time slot code
     * 
     */
    @JsonProperty("timeSlotCd")
    @JsonPropertyDescription("Time slot code")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Time slot code", example = "0")
    private String timeSlotCd;
    /**
     * Description of the time slot in local time
     * 
     */
    @JsonProperty("timeslotDescription")
    @JsonPropertyDescription("Description of the time slot in local time")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Description of the time slot in local time", example = "1200-1400")
    private String timeslotDescription;
    /**
     * Time zone offset
     * 
     */
    @JsonProperty("timeZoneOffset")
    @JsonPropertyDescription("Time zone offset")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Time zone offset", example = "480")
    private String timeZoneOffset;
    /**
     * the phone number to call first
     * 
     */
    @JsonProperty("callFirstPhoneNum")
    @JsonPropertyDescription("the phone number to call first")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "the phone number to call first", example = "55674567")
    private String callFirstPhoneNum;
    /**
     * Indicator to say if its a trouble call
     * 
     */
    @JsonProperty("troubleCallIndicator")
    @JsonPropertyDescription("Indicator to say if its a trouble call")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Indicator to say if its a trouble call", example = "Y")
    private String troubleCallIndicator;
    /**
     * Job comment added
     * 
     */
    @JsonProperty("jobComment")
    @JsonPropertyDescription("Job comment added")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Job comment added", example = "TEST")
    private String jobComment;
    /**
     * Order Comment
     * 
     */
    @JsonProperty("orderComment")
    @JsonPropertyDescription("Order Comment")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Order Comment", example = "test test")
    private String orderComment;
    /**
     * Job Class Code
     * 
     */
    @JsonProperty("jobClassCd")
    @JsonPropertyDescription("Job Class Code")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Job Class Code", example = "S")
    private String jobClassCd;
    /**
     * Description of the Job type
     * 
     */
    @JsonProperty("jobTypeDesc")
    @JsonPropertyDescription("Description of the Job type")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Description of the Job type", example = "UP BC SIP FIBER")
    private String jobTypeDesc;
    /**
     * The SPA of the location
     * 
     */
    @JsonProperty("SysPrinAgent")
    @JsonPropertyDescription("The SPA of the location")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The SPA of the location", example = "821010000200")
    private String sysPrinAgent;
    /**
     * Dispatcher status code
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    @JsonPropertyDescription("Dispatcher status code")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Dispatcher status code", example = "R")
    private String dispatcherStatusCd;
    /**
     * the effort required to complete the job
     * 
     */
    @JsonProperty("jobUnits")
    @JsonPropertyDescription("the effort required to complete the job")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "the effort required to complete the job", example = "5")
    private String jobUnits;
    /**
     * JOb Type code
     * 
     */
    @JsonProperty("jobTypeCd")
    @JsonPropertyDescription("JOb Type code")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "JOb Type code", example = "6E")
    private String jobTypeCd;
    /**
     * Job Number
     * 
     */
    @JsonProperty("jobNum")
    @JsonPropertyDescription("Job Number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Job Number", example = "000068")
    private String jobNum;
    /**
     * Fulfillment Center
     * 
     */
    @JsonProperty("fulfillmentCenter")
    @JsonPropertyDescription("Fulfillment Center")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Fulfillment Center", example = "182101001")
    private String fulfillmentCenter;
    @JsonProperty("JobCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobCustomFields jobCustomFields;

    /**
     * Work order Number
     * 
     */
    @JsonProperty("workOrderNumber")
    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    /**
     * Work order Number
     * 
     */
    @JsonProperty("workOrderNumber")
    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public Job withWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
        return this;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("scheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Job withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("jobReasonCode")
    public String getJobReasonCode() {
        return jobReasonCode;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("jobReasonCode")
    public void setJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
    }

    public Job withJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
        return this;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("technicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

    /**
     * The scheduled date
     * 
     */
    @JsonProperty("technicianNum")
    public void setTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
    }

    public Job withTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
        return this;
    }

    /**
     * The assigned technician ID
     * 
     */
    @JsonProperty("technicianId")
    public String getTechnicianId() {
        return technicianId;
    }

    /**
     * The assigned technician ID
     * 
     */
    @JsonProperty("technicianId")
    public void setTechnicianId(String technicianId) {
        this.technicianId = technicianId;
    }

    public Job withTechnicianId(String technicianId) {
        this.technicianId = technicianId;
        return this;
    }

    /**
     * Start date of the time slot
     * 
     */
    @JsonProperty("timeSlotStartDateTime")
    public String getTimeSlotStartDateTime() {
        return timeSlotStartDateTime;
    }

    /**
     * Start date of the time slot
     * 
     */
    @JsonProperty("timeSlotStartDateTime")
    public void setTimeSlotStartDateTime(String timeSlotStartDateTime) {
        this.timeSlotStartDateTime = timeSlotStartDateTime;
    }

    public Job withTimeSlotStartDateTime(String timeSlotStartDateTime) {
        this.timeSlotStartDateTime = timeSlotStartDateTime;
        return this;
    }

    /**
     * End date of the time slot
     * 
     */
    @JsonProperty("timeSlotEndDateTime")
    public String getTimeSlotEndDateTime() {
        return timeSlotEndDateTime;
    }

    /**
     * End date of the time slot
     * 
     */
    @JsonProperty("timeSlotEndDateTime")
    public void setTimeSlotEndDateTime(String timeSlotEndDateTime) {
        this.timeSlotEndDateTime = timeSlotEndDateTime;
    }

    public Job withTimeSlotEndDateTime(String timeSlotEndDateTime) {
        this.timeSlotEndDateTime = timeSlotEndDateTime;
        return this;
    }

    /**
     * Time slot code
     * 
     */
    @JsonProperty("timeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    /**
     * Time slot code
     * 
     */
    @JsonProperty("timeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    public Job withTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
        return this;
    }

    /**
     * Description of the time slot in local time
     * 
     */
    @JsonProperty("timeslotDescription")
    public String getTimeslotDescription() {
        return timeslotDescription;
    }

    /**
     * Description of the time slot in local time
     * 
     */
    @JsonProperty("timeslotDescription")
    public void setTimeslotDescription(String timeslotDescription) {
        this.timeslotDescription = timeslotDescription;
    }

    public Job withTimeslotDescription(String timeslotDescription) {
        this.timeslotDescription = timeslotDescription;
        return this;
    }

    /**
     * Time zone offset
     * 
     */
    @JsonProperty("timeZoneOffset")
    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    /**
     * Time zone offset
     * 
     */
    @JsonProperty("timeZoneOffset")
    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public Job withTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }

    /**
     * the phone number to call first
     * 
     */
    @JsonProperty("callFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    /**
     * the phone number to call first
     * 
     */
    @JsonProperty("callFirstPhoneNum")
    public void setCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
    }

    public Job withCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
        return this;
    }

    /**
     * Indicator to say if its a trouble call
     * 
     */
    @JsonProperty("troubleCallIndicator")
    public String getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    /**
     * Indicator to say if its a trouble call
     * 
     */
    @JsonProperty("troubleCallIndicator")
    public void setTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
    }

    public Job withTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
        return this;
    }

    /**
     * Job comment added
     * 
     */
    @JsonProperty("jobComment")
    public String getJobComment() {
        return jobComment;
    }

    /**
     * Job comment added
     * 
     */
    @JsonProperty("jobComment")
    public void setJobComment(String jobComment) {
        this.jobComment = jobComment;
    }

    public Job withJobComment(String jobComment) {
        this.jobComment = jobComment;
        return this;
    }

    /**
     * Order Comment
     * 
     */
    @JsonProperty("orderComment")
    public String getOrderComment() {
        return orderComment;
    }

    /**
     * Order Comment
     * 
     */
    @JsonProperty("orderComment")
    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public Job withOrderComment(String orderComment) {
        this.orderComment = orderComment;
        return this;
    }

    /**
     * Job Class Code
     * 
     */
    @JsonProperty("jobClassCd")
    public String getJobClassCd() {
        return jobClassCd;
    }

    /**
     * Job Class Code
     * 
     */
    @JsonProperty("jobClassCd")
    public void setJobClassCd(String jobClassCd) {
        this.jobClassCd = jobClassCd;
    }

    public Job withJobClassCd(String jobClassCd) {
        this.jobClassCd = jobClassCd;
        return this;
    }

    /**
     * Description of the Job type
     * 
     */
    @JsonProperty("jobTypeDesc")
    public String getJobTypeDesc() {
        return jobTypeDesc;
    }

    /**
     * Description of the Job type
     * 
     */
    @JsonProperty("jobTypeDesc")
    public void setJobTypeDesc(String jobTypeDesc) {
        this.jobTypeDesc = jobTypeDesc;
    }

    public Job withJobTypeDesc(String jobTypeDesc) {
        this.jobTypeDesc = jobTypeDesc;
        return this;
    }

    /**
     * The SPA of the location
     * 
     */
    @JsonProperty("SysPrinAgent")
    public String getSysPrinAgent() {
        return sysPrinAgent;
    }

    /**
     * The SPA of the location
     * 
     */
    @JsonProperty("SysPrinAgent")
    public void setSysPrinAgent(String sysPrinAgent) {
        this.sysPrinAgent = sysPrinAgent;
    }

    public Job withSysPrinAgent(String sysPrinAgent) {
        this.sysPrinAgent = sysPrinAgent;
        return this;
    }

    /**
     * Dispatcher status code
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    public String getDispatcherStatusCd() {
        return dispatcherStatusCd;
    }

    /**
     * Dispatcher status code
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    public void setDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
    }

    public Job withDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
        return this;
    }

    /**
     * the effort required to complete the job
     * 
     */
    @JsonProperty("jobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    /**
     * the effort required to complete the job
     * 
     */
    @JsonProperty("jobUnits")
    public void setJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
    }

    public Job withJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
        return this;
    }

    /**
     * JOb Type code
     * 
     */
    @JsonProperty("jobTypeCd")
    public String getJobTypeCd() {
        return jobTypeCd;
    }

    /**
     * JOb Type code
     * 
     */
    @JsonProperty("jobTypeCd")
    public void setJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
    }

    public Job withJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
        return this;
    }

    /**
     * Job Number
     * 
     */
    @JsonProperty("jobNum")
    public String getJobNum() {
        return jobNum;
    }

    /**
     * Job Number
     * 
     */
    @JsonProperty("jobNum")
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Job withJobNum(String jobNum) {
        this.jobNum = jobNum;
        return this;
    }

    /**
     * Fulfillment Center
     * 
     */
    @JsonProperty("fulfillmentCenter")
    public String getFulfillmentCenter() {
        return fulfillmentCenter;
    }

    /**
     * Fulfillment Center
     * 
     */
    @JsonProperty("fulfillmentCenter")
    public void setFulfillmentCenter(String fulfillmentCenter) {
        this.fulfillmentCenter = fulfillmentCenter;
    }

    public Job withFulfillmentCenter(String fulfillmentCenter) {
        this.fulfillmentCenter = fulfillmentCenter;
        return this;
    }

    @JsonProperty("JobCustomFields")
    public JobCustomFields getJobCustomFields() {
        return jobCustomFields;
    }

    @JsonProperty("JobCustomFields")
    public void setJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
    }

    public Job withJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderNumber).append(scheduleDate).append(jobReasonCode).append(technicianNum).append(technicianId).append(timeSlotStartDateTime).append(timeSlotEndDateTime).append(timeSlotCd).append(timeslotDescription).append(timeZoneOffset).append(callFirstPhoneNum).append(troubleCallIndicator).append(jobComment).append(orderComment).append(jobClassCd).append(jobTypeDesc).append(sysPrinAgent).append(dispatcherStatusCd).append(jobUnits).append(jobTypeCd).append(jobNum).append(fulfillmentCenter).append(jobCustomFields).toHashCode();
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
        return new EqualsBuilder().append(workOrderNumber, rhs.workOrderNumber).append(scheduleDate, rhs.scheduleDate).append(jobReasonCode, rhs.jobReasonCode).append(technicianNum, rhs.technicianNum).append(technicianId, rhs.technicianId).append(timeSlotStartDateTime, rhs.timeSlotStartDateTime).append(timeSlotEndDateTime, rhs.timeSlotEndDateTime).append(timeSlotCd, rhs.timeSlotCd).append(timeslotDescription, rhs.timeslotDescription).append(timeZoneOffset, rhs.timeZoneOffset).append(callFirstPhoneNum, rhs.callFirstPhoneNum).append(troubleCallIndicator, rhs.troubleCallIndicator).append(jobComment, rhs.jobComment).append(orderComment, rhs.orderComment).append(jobClassCd, rhs.jobClassCd).append(jobTypeDesc, rhs.jobTypeDesc).append(sysPrinAgent, rhs.sysPrinAgent).append(dispatcherStatusCd, rhs.dispatcherStatusCd).append(jobUnits, rhs.jobUnits).append(jobTypeCd, rhs.jobTypeCd).append(jobNum, rhs.jobNum).append(fulfillmentCenter, rhs.fulfillmentCenter).append(jobCustomFields, rhs.jobCustomFields).isEquals();
    }

}
