
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
    "source",
    "workOrderId",
    "job",
    "jobCustomer"
})
public class WorkOrderRequest {

    /**
     * Source System ID
     * (Required)
     * 
     */
    @JsonProperty("source")
    @JsonPropertyDescription("Source System ID")
    private String source;
    /**
     * WFX Work Order ID
     * (Required)
     * 
     */
    @JsonProperty("workOrderId")
    @JsonPropertyDescription("WFX Work Order ID")
    private String workOrderId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("job")
    private Job job;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobCustomer")
    private JobCustomer jobCustomer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Source System ID
     * (Required)
     * 
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * Source System ID
     * (Required)
     * 
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * WFX Work Order ID
     * (Required)
     * 
     */
    @JsonProperty("workOrderId")
    public String getWorkOrderId() {
        return workOrderId;
    }

    /**
     * WFX Work Order ID
     * (Required)
     * 
     */
    @JsonProperty("workOrderId")
    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("job")
    public void setJob(Job job) {
        this.job = job;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobCustomer")
    public void setJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
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
        return new ToStringBuilder(this).append("source", source).append("workOrderId", workOrderId).append("job", job).append("jobCustomer", jobCustomer).append("additionalProperties", additionalProperties).toString();
    }

}
