
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Work Order details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "solutionDetails",
    "job",
    "jobCustomer",
    "jobLocation"
})
public class WorkOrder {

    @JsonProperty("solutionDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
    /**
     * Description of the job
     * 
     */
    @JsonProperty("job")
    @JsonPropertyDescription("Description of the job")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "Description of the job", example = "")
    @Valid
    private Job job;
    /**
     * Details of the customer
     * 
     */
    @JsonProperty("jobCustomer")
    @JsonPropertyDescription("Details of the customer")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "Details of the customer", example = "")
    @Valid
    private JobCustomer jobCustomer;
    @JsonProperty("jobLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobLocation jobLocation;

    @JsonProperty("solutionDetails")
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetails;
    }

    @JsonProperty("solutionDetails")
    public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
    }

    public WorkOrder withSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
        return this;
    }

    /**
     * Description of the job
     * 
     */
    @JsonProperty("job")
    public Job getJob() {
        return job;
    }

    /**
     * Description of the job
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
     * Details of the customer
     * 
     */
    @JsonProperty("jobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

    /**
     * Details of the customer
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

    @JsonProperty("jobLocation")
    public JobLocation getJobLocation() {
        return jobLocation;
    }

    @JsonProperty("jobLocation")
    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public WorkOrder withJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(solutionDetails).append(job).append(jobCustomer).append(jobLocation).toHashCode();
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
        return new EqualsBuilder().append(solutionDetails, rhs.solutionDetails).append(job, rhs.job).append(jobCustomer, rhs.jobCustomer).append(jobLocation, rhs.jobLocation).isEquals();
    }

}
