
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "solutionDetails",
    "JobCustomer",
    "JobLocation",
    "Job",
    "JobEquipmentList",
    "JobProductList"
})
public class GetWorkorderBySiteIdResponse {

    @JsonProperty("solutionDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
    @JsonProperty("JobCustomer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobCustomer jobCustomer;
    @JsonProperty("JobLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobLocation jobLocation;
    @JsonProperty("Job")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Job job;
    @JsonProperty("JobEquipmentList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobEquipmentList> jobEquipmentList = new ArrayList<JobEquipmentList>();
    @JsonProperty("JobProductList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobProductList> jobProductList = new ArrayList<JobProductList>();

    @JsonProperty("solutionDetails")
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetails;
    }

    @JsonProperty("solutionDetails")
    public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
    }

    public GetWorkorderBySiteIdResponse withSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
        return this;
    }

    @JsonProperty("JobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

    @JsonProperty("JobCustomer")
    public void setJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
    }

    public GetWorkorderBySiteIdResponse withJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
        return this;
    }

    @JsonProperty("JobLocation")
    public JobLocation getJobLocation() {
        return jobLocation;
    }

    @JsonProperty("JobLocation")
    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public GetWorkorderBySiteIdResponse withJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    @JsonProperty("Job")
    public Job getJob() {
        return job;
    }

    @JsonProperty("Job")
    public void setJob(Job job) {
        this.job = job;
    }

    public GetWorkorderBySiteIdResponse withJob(Job job) {
        this.job = job;
        return this;
    }

    @JsonProperty("JobEquipmentList")
    public List<JobEquipmentList> getJobEquipmentList() {
        return jobEquipmentList;
    }

    @JsonProperty("JobEquipmentList")
    public void setJobEquipmentList(List<JobEquipmentList> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
    }

    public GetWorkorderBySiteIdResponse withJobEquipmentList(List<JobEquipmentList> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
        return this;
    }

    @JsonProperty("JobProductList")
    public List<JobProductList> getJobProductList() {
        return jobProductList;
    }

    @JsonProperty("JobProductList")
    public void setJobProductList(List<JobProductList> jobProductList) {
        this.jobProductList = jobProductList;
    }

    public GetWorkorderBySiteIdResponse withJobProductList(List<JobProductList> jobProductList) {
        this.jobProductList = jobProductList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(solutionDetails).append(jobCustomer).append(jobLocation).append(job).append(jobEquipmentList).append(jobProductList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetWorkorderBySiteIdResponse) == false) {
            return false;
        }
        GetWorkorderBySiteIdResponse rhs = ((GetWorkorderBySiteIdResponse) other);
        return new EqualsBuilder().append(solutionDetails, rhs.solutionDetails).append(jobCustomer, rhs.jobCustomer).append(jobLocation, rhs.jobLocation).append(job, rhs.job).append(jobEquipmentList, rhs.jobEquipmentList).append(jobProductList, rhs.jobProductList).isEquals();
    }

}
