
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "job",
    "jobCustomer"
})
public class CreateWorkOrder {

    @JsonProperty("job")
    @NotNull
    @Valid
    private Job job;
    @JsonProperty("jobCustomer")
    @NotNull
    @Valid
    private JobCustomer jobCustomer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(Job job) {
        this.job = job;
    }

    @JsonProperty("jobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

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

}
