
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

import javax.validation.Valid;
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
    "jobCustomer",
    "jobLocation"
})
public class CreateWorkOrder {

    @JsonProperty("job")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Job job;
    @JsonProperty("jobCustomer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobCustomer jobCustomer;
    @JsonProperty("jobLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobLocation jobLocation;

    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    @JsonProperty("job")
    public void setJob(Job job) {
        this.job = job;
    }

    public CreateWorkOrder withJob(Job job) {
        this.job = job;
        return this;
    }

    @JsonProperty("jobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

    @JsonProperty("jobCustomer")
    public void setJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
    }

    public CreateWorkOrder withJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
        return this;
    }

    @JsonProperty("jobLocation")
    public JobLocation getJobLocation() {
        return jobLocation;
    }

    @JsonProperty("jobLocation")
    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public CreateWorkOrder withJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(job).append(jobCustomer).append(jobLocation).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateWorkOrder) == false) {
            return false;
        }
        CreateWorkOrder rhs = ((CreateWorkOrder) other);
        return new EqualsBuilder().append(job, rhs.job).append(jobCustomer, rhs.jobCustomer).append(jobLocation, rhs.jobLocation).isEquals();
    }

}
