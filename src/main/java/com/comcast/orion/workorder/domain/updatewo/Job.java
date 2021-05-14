
package com.comcast.orion.workorder.domain.updatewo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "dispatcherStatusCd",
    "jobNum",
    "reasonCodes",
    "scheduleDate",
    "timeSlotCd",
    "jobTypeCd",
    "jobUnits",
    "jobClassCd",
    "callFirstPhoneNum",
    "troubleCallIndicator",
    "jobComment",
    "orderComment",
    "orderMgtSystem",
    "technicianNum"
})
public class Job {

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    @JsonPropertyDescription("Amdocs DispatcherStatusCd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Amdocs DispatcherStatusCd passed by Amdocs - WFX", example = "O")
    @Size(min = 1, max = 5)
    private String dispatcherStatusCd;
    /**
     * Amdocs JobNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobNum")
    @JsonPropertyDescription("Amdocs JobNum passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Amdocs JobNum passed by Amdocs - WFX", example = "000068")
    @Size(min = 1, max = 6)
    private String jobNum;
    @JsonProperty("reasonCodes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<String> reasonCodes = new ArrayList<String>();
    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
     * 
     */
    @JsonProperty("scheduleDate")
    @JsonPropertyDescription("Amdocs ScheduleDate passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 6, value = "Amdocs ScheduleDate passed by Amdocs - WFX", example = "2017-07-14")
    @Size(min = 1, max = 10)
    private String scheduleDate;
    /**
     * Amdocs TimeSlotCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("timeSlotCd")
    @JsonPropertyDescription("Amdocs TimeSlotCd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 12, value = "Amdocs TimeSlotCd passed by Amdocs - WFX", example = "0")
    @Size(min = 1, max = 3)
    private String timeSlotCd;
    /**
     * Amdocs JobTypeCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobTypeCd")
    @JsonPropertyDescription("Amdocs JobTypeCd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "Amdocs JobTypeCd passed by Amdocs - WFX", example = "BD")
    @Size(min = 1, max = 5)
    private String jobTypeCd;
    /**
     * Amdocs JobUnits passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobUnits")
    @JsonPropertyDescription("Amdocs JobUnits passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 5, value = "Amdocs JobUnits passed by Amdocs - WFX", example = "5")
    @Size(min = 1, max = 4)
    private String jobUnits;
    /**
     * Amdocs JobClassCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobClassCd")
    @JsonPropertyDescription("Amdocs JobClassCd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "Amdocs JobClassCd passed by Amdocs - WFX", example = "C")
    @Size(min = 0, max = 1)
    private String jobClassCd;
    /**
     * Amdocs CallFirstPhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("callFirstPhoneNum")
    @JsonPropertyDescription("Amdocs CallFirstPhoneNum passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 8, value = "Amdocs CallFirstPhoneNum passed by Amdocs - WFX", example = "556745670")
    @Size(min = 0, max = 20)
    private String callFirstPhoneNum;
    /**
     * Amdocs TroubleCallIndicator passed by Amdocs - WFX
     * 
     */
    @JsonProperty("troubleCallIndicator")
    @JsonPropertyDescription("Amdocs TroubleCallIndicator passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 9, value = "Amdocs TroubleCallIndicator passed by Amdocs - WFX", example = "R")
    @Size(min = 0, max = 1)
    private String troubleCallIndicator;
    /**
     * Amdocs JobComment passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobComment")
    @JsonPropertyDescription("Amdocs JobComment passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 10, value = "Amdocs JobComment passed by Amdocs - WFX", example = "Job Comment")
    @Size(min = 0, max = 4000)
    private String jobComment;
    /**
     * Amdocs OrderComment passed by Amdocs - WFX
     * 
     */
    @JsonProperty("orderComment")
    @JsonPropertyDescription("Amdocs OrderComment passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 11, value = "Amdocs OrderComment passed by Amdocs - WFX", example = "Order Comment")
    @Size(min = 0, max = 500)
    private String orderComment;
    /**
     * Amdocs OrderMgtSystem passed by Amdocs - WFX
     * 
     */
    @JsonProperty("orderMgtSystem")
    @JsonPropertyDescription("Amdocs OrderMgtSystem passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 7, value = "Amdocs OrderMgtSystem passed by Amdocs - WFX", example = "ORION")
    @Size(min = 1, max = 15)
    private String orderMgtSystem;
    
    /**
     * Amdocs TechnicianNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("technicianNum")
    @JsonPropertyDescription("Amdocs TechnicianNum passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 13, value = "Amdocs TechnicianNum passed by Amdocs - WFX", example = "0101")
    private String technicianNum;

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    public String getDispatcherStatusCd() {
        return dispatcherStatusCd;
    }

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
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
     * Amdocs JobNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobNum")
    public String getJobNum() {
        return jobNum;
    }

    /**
     * Amdocs JobNum passed by Amdocs - WFX
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

    @JsonProperty("reasonCodes")
    public List<String> getReasonCodes() {
        return reasonCodes;
    }

    @JsonProperty("reasonCodes")
    public void setReasonCodes(List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
    }

    public Job withReasonCodes(List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
        return this;
    }

    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
     * 
     */
    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
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
     * Amdocs TimeSlotCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("timeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    /**
     * Amdocs TimeSlotCd passed by Amdocs - WFX
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
     * Amdocs JobTypeCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobTypeCd")
    public String getJobTypeCd() {
        return jobTypeCd;
    }

    /**
     * Amdocs JobTypeCd passed by Amdocs - WFX
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
     * Amdocs JobUnits passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    /**
     * Amdocs JobUnits passed by Amdocs - WFX
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
     * Amdocs JobClassCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobClassCd")
    public String getJobClassCd() {
        return jobClassCd;
    }

    /**
     * Amdocs JobClassCd passed by Amdocs - WFX
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
     * Amdocs CallFirstPhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("callFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    /**
     * Amdocs CallFirstPhoneNum passed by Amdocs - WFX
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
     * Amdocs TroubleCallIndicator passed by Amdocs - WFX
     * 
     */
    @JsonProperty("troubleCallIndicator")
    public String getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    /**
     * Amdocs TroubleCallIndicator passed by Amdocs - WFX
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
     * Amdocs JobComment passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobComment")
    public String getJobComment() {
        return jobComment;
    }

    /**
     * Amdocs JobComment passed by Amdocs - WFX
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
     * Amdocs OrderComment passed by Amdocs - WFX
     * 
     */
    @JsonProperty("orderComment")
    public String getOrderComment() {
        return orderComment;
    }

    /**
     * Amdocs OrderComment passed by Amdocs - WFX
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
     * Amdocs OrderMgtSystem passed by Amdocs - WFX
     * 
     */
    @JsonProperty("orderMgtSystem")
    public String getOrderMgtSystem() {
        return orderMgtSystem;
    }

    /**
     * Amdocs OrderMgtSystem passed by Amdocs - WFX
     * 
     */
    @JsonProperty("orderMgtSystem")
    public void setOrderMgtSystem(String orderMgtSystem) {
        this.orderMgtSystem = orderMgtSystem;
    }

    public Job withOrderMgtSystem(String orderMgtSystem) {
        this.orderMgtSystem = orderMgtSystem;
        return this;
    }
    
    /**
     * Amdocs TechnicianNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("technicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

    /**
     * Amdocs TechnicianNum passed by Amdocs - WFX
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dispatcherStatusCd).append(jobNum).append(reasonCodes).append(scheduleDate).append(timeSlotCd).append(jobTypeCd).append(jobUnits).append(jobClassCd).append(callFirstPhoneNum).append(troubleCallIndicator).append(jobComment).append(orderComment).append(orderMgtSystem).append(technicianNum).toHashCode();
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
        return new EqualsBuilder().append(dispatcherStatusCd, rhs.dispatcherStatusCd).append(jobNum, rhs.jobNum).append(reasonCodes, rhs.reasonCodes).append(scheduleDate, rhs.scheduleDate).append(timeSlotCd, rhs.timeSlotCd).append(jobTypeCd, rhs.jobTypeCd).append(jobUnits, rhs.jobUnits).append(jobClassCd, rhs.jobClassCd).append(callFirstPhoneNum, rhs.callFirstPhoneNum).append(troubleCallIndicator, rhs.troubleCallIndicator).append(jobComment, rhs.jobComment).append(orderComment, rhs.orderComment).append(orderMgtSystem, rhs.orderMgtSystem).append(technicianNum, rhs.technicianNum).isEquals();
    }

}
