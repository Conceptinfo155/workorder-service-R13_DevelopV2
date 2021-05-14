
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ScheduleWorkorderRequest"
})
public class SQOScheduleWO {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleWorkorderRequest")
    private ScheduleWorkorderRequest scheduleWorkorderRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleWorkorderRequest")
    public ScheduleWorkorderRequest getScheduleWorkorderRequest() {
        return scheduleWorkorderRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleWorkorderRequest")
    public void setScheduleWorkorderRequest(ScheduleWorkorderRequest scheduleWorkorderRequest) {
        this.scheduleWorkorderRequest = scheduleWorkorderRequest;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
