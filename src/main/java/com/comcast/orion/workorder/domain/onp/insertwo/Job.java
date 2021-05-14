
package com.comcast.orion.workorder.domain.onp.insertwo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dispatcherStatusCd",
    "jobNum",
    "scheduleDate",
    "timeSlotCd",
    "jobTypeCd",
    "jobUnits",
    "jobClassCd",
    "troubleCallIndicator"
})
public class Job {

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    @JsonPropertyDescription("Amdocs DispatcherStatusCd passed by Amdocs - WFX")
    private String dispatcherStatusCd;
    /**
     * Amdocs JobNum passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobNum")
    @JsonPropertyDescription("Amdocs JobNum passed by Amdocs - WFX")
    private String jobNum;
    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("scheduleDate")
    @JsonPropertyDescription("Amdocs ScheduleDate passed by Amdocs - WFX")
    private String scheduleDate;
    /**
     * Amdocs TimeSlotCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("timeSlotCd")
    @JsonPropertyDescription("Amdocs TimeSlotCd passed by Amdocs - WFX")
    private String timeSlotCd;
    /**
     * Amdocs JobTypeCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobTypeCd")
    @JsonPropertyDescription("Amdocs JobTypeCd passed by Amdocs - WFX")
    private String jobTypeCd;
    /**
     * Amdocs JobUnits passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobUnits")
    @JsonPropertyDescription("Amdocs JobUnits passed by Amdocs - WFX")
    private String jobUnits;
    /**
     * Amdocs JobClassCd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("jobClassCd")
    @JsonPropertyDescription("Amdocs JobClassCd passed by Amdocs - WFX")
    private String jobClassCd;
    /**
     * Amdocs TroubleCallIndicator passed by Amdocs - WFX
     * 
     */
    @JsonProperty("troubleCallIndicator")
    @JsonPropertyDescription("Amdocs TroubleCallIndicator passed by Amdocs - WFX")
    private String troubleCallIndicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    public String getDispatcherStatusCd() {
        return dispatcherStatusCd;
    }

    /**
     * Amdocs DispatcherStatusCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("dispatcherStatusCd")
    public void setDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
    }

    /**
     * Amdocs JobNum passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobNum")
    public String getJobNum() {
        return jobNum;
    }

    /**
     * Amdocs JobNum passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobNum")
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Amdocs ScheduleDate passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("scheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    /**
     * Amdocs TimeSlotCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("timeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    /**
     * Amdocs TimeSlotCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("timeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    /**
     * Amdocs JobTypeCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobTypeCd")
    public String getJobTypeCd() {
        return jobTypeCd;
    }

    /**
     * Amdocs JobTypeCd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobTypeCd")
    public void setJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
    }

    /**
     * Amdocs JobUnits passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    /**
     * Amdocs JobUnits passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("jobUnits")
    public void setJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dispatcherStatusCd", dispatcherStatusCd).append("jobNum", jobNum).append("scheduleDate", scheduleDate).append("timeSlotCd", timeSlotCd).append("jobTypeCd", jobTypeCd).append("jobUnits", jobUnits).append("jobClassCd", jobClassCd).append("troubleCallIndicator", troubleCallIndicator).append("additionalProperties", additionalProperties).toString();
    }

}
