
package com.comcast.orion.workorder.domain.reschedule.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "job",
    "jobCustomer"
})
public class WorkOrder {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("job")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Job job;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("jobCustomer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobCustomer jobCustomer;

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

    public WorkOrder withJob(Job job) {
        this.job = job;
        return this;
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

    public WorkOrder withJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(job).append(jobCustomer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkOrder) == false) {
            return false;
        }
        WorkOrder rhs = ((WorkOrder) other);
        return new EqualsBuilder().append(job, rhs.job).append(jobCustomer, rhs.jobCustomer).isEquals();
    }

}
