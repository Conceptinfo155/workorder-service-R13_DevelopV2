
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "scheduleDate",
    "timeSlotCd",
    "callFirstPhoneNum",
    "troubleCallIndicator",
    "jobComment",
    "orderComment",
    "jobReasonCode",
    "technicianNum"
})
public class Job {

    @JsonProperty("scheduleDate")
    @Size(min = 1, max = 10)
    private String scheduleDate;
    @JsonProperty("timeSlotCd")
    @Size(min = 1, max = 3)
    private String timeSlotCd;
    @JsonProperty("callFirstPhoneNum")
    @Size(max = 20)
    private String callFirstPhoneNum;
    @JsonProperty("troubleCallIndicator")
    private TroubleCallIndicator troubleCallIndicator;
    @Size(max = 4000)
    @JsonProperty("jobComment")
    private String jobComment;
    @JsonProperty("orderComment")
    private String orderComment;
    @Size(max = 500)
    @JsonProperty("jobReasonCode")
    private String jobReasonCode;
    @Size(max = 20)
    @JsonProperty("technicianNum")
    private String technicianNum;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    @JsonProperty("scheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    @JsonProperty("timeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    @JsonProperty("timeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    @JsonProperty("callFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    @JsonProperty("callFirstPhoneNum")
    public void setCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
    }

    @JsonProperty("troubleCallIndicator")
    public TroubleCallIndicator getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    @JsonProperty("troubleCallIndicator")
    public void setTroubleCallIndicator(TroubleCallIndicator troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
    }

    @JsonProperty("jobComment")
    public String getJobComment() {
        return jobComment;
    }

    @JsonProperty("jobComment")
    public void setJobComment(String jobComment) {
        this.jobComment = jobComment;
    }

    @JsonProperty("orderComment")
    public String getOrderComment() {
        return orderComment;
    }

    @JsonProperty("orderComment")
    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    @JsonProperty("jobReasonCode")
    public String getJobReasonCode() {
        return jobReasonCode;
    }

    @JsonProperty("jobReasonCode")
    public void setJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
    }

    @JsonProperty("technicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

    @JsonProperty("technicianNum")
    public void setTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum TroubleCallIndicator {

        R("R"),
        Q("Q"),
        B("B");
        private final String value;
        private final static Map<String, TroubleCallIndicator> CONSTANTS = new HashMap<String, TroubleCallIndicator>();

        static {
            for (TroubleCallIndicator c: values()) {
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
        public static TroubleCallIndicator fromValue(String value) {
            TroubleCallIndicator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
