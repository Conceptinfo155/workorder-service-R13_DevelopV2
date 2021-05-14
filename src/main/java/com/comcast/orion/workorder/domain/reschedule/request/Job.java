
package com.comcast.orion.workorder.domain.reschedule.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "scheduleDate",
    "timeSlotCd",
    "callFirstPhoneNum",
    "troubleCallIndicator",
    "jobComment",
    "orderComment",
    "jobReasonCode",
    "reasonCodes",
    "technicianNum"
})
public class Job {

    @JsonProperty("scheduleDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "2015-10-23")
    @Size(max = 10)
    private String scheduleDate;
    @JsonProperty("timeSlotCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "2")
    @Size(max = 3)
    private String timeSlotCd;
    @JsonProperty("callFirstPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "4136500222")
    @Size(min = 1, max = 20)
    private String callFirstPhoneNum;
    @JsonProperty("troubleCallIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "R")
    private Job.TroubleCallIndicator troubleCallIndicator;
    @JsonProperty("jobComment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "Job Comments")
    @Size(min = 1, max = 240)
    private String jobComment;
    @JsonProperty("orderComment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "Order Comments")
    @Size(min = 1, max = 500)
    private String orderComment;
    @JsonProperty("jobReasonCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "D0")
    @Size(min = 1, max = 10)
    private String jobReasonCode;
    /**
     * 
     * (Required)
     * 
     */

    @JsonProperty("reasonCodes")
    @JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")

    private List<String> reasonCodes = new ArrayList<String>();
    @JsonProperty("technicianNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "0101")
    private String technicianNum;

    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    @JsonProperty("scheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Job withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    @JsonProperty("timeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    @JsonProperty("timeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    public Job withTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
        return this;
    }

    @JsonProperty("callFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    @JsonProperty("callFirstPhoneNum")
    public void setCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
    }

    public Job withCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
        return this;
    }

    @JsonProperty("troubleCallIndicator")
    public Job.TroubleCallIndicator getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    @JsonProperty("troubleCallIndicator")
    public void setTroubleCallIndicator(Job.TroubleCallIndicator troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
    }

    public Job withTroubleCallIndicator(Job.TroubleCallIndicator troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
        return this;
    }

    @JsonProperty("jobComment")
    public String getJobComment() {
        return jobComment;
    }

    @JsonProperty("jobComment")
    public void setJobComment(String jobComment) {
        this.jobComment = jobComment;
    }

    public Job withJobComment(String jobComment) {
        this.jobComment = jobComment;
        return this;
    }

    @JsonProperty("orderComment")
    public String getOrderComment() {
        return orderComment;
    }

    @JsonProperty("orderComment")
    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public Job withOrderComment(String orderComment) {
        this.orderComment = orderComment;
        return this;
    }

    @JsonProperty("jobReasonCode")
    public String getJobReasonCode() {
        return jobReasonCode;
    }

    @JsonProperty("jobReasonCode")
    public void setJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
    }

    public Job withJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reasonCodes")
    public List<String> getReasonCodes() {
        return reasonCodes;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reasonCodes")
    public void setReasonCodes(List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
    }

    public Job withReasonCodes(List<String> reasonCodes) {
        this.reasonCodes = reasonCodes;
        return this;
    }

    @JsonProperty("technicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

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
        return new HashCodeBuilder().append(scheduleDate).append(timeSlotCd).append(callFirstPhoneNum).append(troubleCallIndicator).append(jobComment).append(orderComment).append(jobReasonCode).append(reasonCodes).append(technicianNum).toHashCode();
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
        return new EqualsBuilder().append(scheduleDate, rhs.scheduleDate).append(timeSlotCd, rhs.timeSlotCd).append(callFirstPhoneNum, rhs.callFirstPhoneNum).append(troubleCallIndicator, rhs.troubleCallIndicator).append(jobComment, rhs.jobComment).append(orderComment, rhs.orderComment).append(jobReasonCode, rhs.jobReasonCode).append(reasonCodes, rhs.reasonCodes).append(technicianNum, rhs.technicianNum).isEquals();
    }

    public enum TroubleCallIndicator {

        R("R"),
        Q("Q"),
        B("B");
        private final String value;
        private final static Map<String, Job.TroubleCallIndicator> CONSTANTS = new HashMap<String, Job.TroubleCallIndicator>();

        static {
            for (Job.TroubleCallIndicator c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private TroubleCallIndicator(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Job.TroubleCallIndicator fromValue(String value) {
            Job.TroubleCallIndicator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
