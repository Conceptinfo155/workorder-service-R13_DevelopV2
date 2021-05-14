
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

import java.util.ArrayList;
import java.util.List;
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


/**
 * The Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "JobEquipmentList",
    "JobCustomer",
    "Job",
    "JobLocation",
    "JobProductList"
})
public class GetWorkOrderWFXResponse {

    /**
     * The Jobequipmentlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobEquipmentList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Object> jobEquipmentList = new ArrayList<Object>();
    /**
     * The Jobcustomer Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private JobCustomer jobCustomer;
    /**
     * The Job Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Job")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private Job job;
    /**
     * The Joblocation Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private JobLocation jobLocation;
    /**
     * The Jobproductlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobProductList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Object> jobProductList = new ArrayList<Object>();

    /**
     * The Jobequipmentlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobEquipmentList")
    public List<Object> getJobEquipmentList() {
        return jobEquipmentList;
    }

    /**
     * The Jobequipmentlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobEquipmentList")
    public void setJobEquipmentList(List<Object> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
    }

    public GetWorkOrderWFXResponse withJobEquipmentList(List<Object> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
        return this;
    }

    /**
     * The Jobcustomer Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomer")
    public JobCustomer getJobCustomer() {
        return jobCustomer;
    }

    /**
     * The Jobcustomer Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustomer")
    public void setJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
    }

    public GetWorkOrderWFXResponse withJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
        return this;
    }

    /**
     * The Job Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Job")
    public Job getJob() {
        return job;
    }

    /**
     * The Job Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Job")
    public void setJob(Job job) {
        this.job = job;
    }

    public GetWorkOrderWFXResponse withJob(Job job) {
        this.job = job;
        return this;
    }

    /**
     * The Joblocation Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobLocation")
    public JobLocation getJobLocation() {
        return jobLocation;
    }

    /**
     * The Joblocation Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobLocation")
    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public GetWorkOrderWFXResponse withJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    /**
     * The Jobproductlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobProductList")
    public List<Object> getJobProductList() {
        return jobProductList;
    }

    /**
     * The Jobproductlist Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobProductList")
    public void setJobProductList(List<Object> jobProductList) {
        this.jobProductList = jobProductList;
    }

    public GetWorkOrderWFXResponse withJobProductList(List<Object> jobProductList) {
        this.jobProductList = jobProductList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobEquipmentList).append(jobCustomer).append(job).append(jobLocation).append(jobProductList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetWorkOrderWFXResponse) == false) {
            return false;
        }
        GetWorkOrderWFXResponse rhs = ((GetWorkOrderWFXResponse) other);
        return new EqualsBuilder().append(jobEquipmentList, rhs.jobEquipmentList).append(jobCustomer, rhs.jobCustomer).append(job, rhs.job).append(jobLocation, rhs.jobLocation).append(jobProductList, rhs.jobProductList).isEquals();
    }

}
