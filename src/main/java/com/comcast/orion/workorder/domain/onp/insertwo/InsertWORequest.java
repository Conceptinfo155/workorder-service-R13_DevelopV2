
package com.comcast.orion.workorder.domain.onp.insertwo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "workOrderRequest"
})
public class InsertWORequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderRequest")
    private WorkOrderRequest workOrderRequest;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderRequest")
    public WorkOrderRequest getWorkOrderRequest() {
        return workOrderRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderRequest")
    public void setWorkOrderRequest(WorkOrderRequest workOrderRequest) {
        this.workOrderRequest = workOrderRequest;
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
        return new ToStringBuilder(this).append("workOrderRequest", workOrderRequest).append("additionalProperties", additionalProperties).toString();
    }

}
