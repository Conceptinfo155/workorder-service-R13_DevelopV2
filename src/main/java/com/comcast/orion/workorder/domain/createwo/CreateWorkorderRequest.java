
package com.comcast.orion.workorder.domain.createwo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    "wfxDispatchLogin",
    "businessUnit",
    "routeCriteria",
    "createDateTime",
    "job",
    "jobCustomer",
    "jobLocation",
    "jobProductList",
    "jobEquipmentList"
})
public class CreateWorkorderRequest {

    /**
     * Amdocs WFXTechLogin passed by Amdocs - WFX
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("wfxDispatchLogin")
    @JsonPropertyDescription("Amdocs WFXTechLogin passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 1, value = "Amdocs WFXTechLogin passed by Amdocs - WFX", example = "ORION")
    @Size(min = 1, max = 10)
    private String wfxDispatchLogin;
    @JsonProperty("businessUnit")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String businessUnit;
    @JsonProperty("routeCriteria")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String routeCriteria;
    @JsonProperty("createDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String createDateTime;
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
    @NotNull
    @JsonProperty("jobLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobLocation jobLocation;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("jobProductList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobProductList> jobProductList = new ArrayList<JobProductList>();
    @JsonProperty("jobEquipmentList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobEquipmentList> jobEquipmentList = new ArrayList<JobEquipmentList>();

    /**
     * Amdocs WFXTechLogin passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("wfxDispatchLogin")
    public String getWfxDispatchLogin() {
        return wfxDispatchLogin;
    }

    /**
     * Amdocs WFXTechLogin passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("wfxDispatchLogin")
    public void setWfxDispatchLogin(String wfxDispatchLogin) {
        this.wfxDispatchLogin = wfxDispatchLogin;
    }

    public CreateWorkorderRequest withWfxDispatchLogin(String wfxDispatchLogin) {
        this.wfxDispatchLogin = wfxDispatchLogin;
        return this;
    }

    @JsonProperty("businessUnit")
    public String getBusinessUnit() {
        return businessUnit;
    }

    @JsonProperty("businessUnit")
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public CreateWorkorderRequest withBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
        return this;
    }

    @JsonProperty("routeCriteria")
    public String getRouteCriteria() {
        return routeCriteria;
    }

    @JsonProperty("routeCriteria")
    public void setRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
    }

    public CreateWorkorderRequest withRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
        return this;
    }

    @JsonProperty("createDateTime")
    public String getCreateDateTime() {
        return createDateTime;
    }

    @JsonProperty("createDateTime")
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public CreateWorkorderRequest withCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
        return this;
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

    public CreateWorkorderRequest withJob(Job job) {
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

    public CreateWorkorderRequest withJobCustomer(JobCustomer jobCustomer) {
        this.jobCustomer = jobCustomer;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobLocation")
    public JobLocation getJobLocation() {
        return jobLocation;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobLocation")
    public void setJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
    }

    public CreateWorkorderRequest withJobLocation(JobLocation jobLocation) {
        this.jobLocation = jobLocation;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobProductList")
    public List<JobProductList> getJobProductList() {
        return jobProductList;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("jobProductList")
    public void setJobProductList(List<JobProductList> jobProductList) {
        this.jobProductList = jobProductList;
    }

    public CreateWorkorderRequest withJobProductList(List<JobProductList> jobProductList) {
        this.jobProductList = jobProductList;
        return this;
    }

    @JsonProperty("jobEquipmentList")
    public List<JobEquipmentList> getJobEquipmentList() {
        return jobEquipmentList;
    }

    @JsonProperty("jobEquipmentList")
    public void setJobEquipmentList(List<JobEquipmentList> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
    }

    public CreateWorkorderRequest withJobEquipmentList(List<JobEquipmentList> jobEquipmentList) {
        this.jobEquipmentList = jobEquipmentList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(wfxDispatchLogin).append(businessUnit).append(routeCriteria).append(createDateTime).append(job).append(jobCustomer).append(jobLocation).append(jobProductList).append(jobEquipmentList).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateWorkorderRequest) == false) {
            return false;
        }
        CreateWorkorderRequest rhs = ((CreateWorkorderRequest) other);
        return new EqualsBuilder().append(wfxDispatchLogin, rhs.wfxDispatchLogin).append(businessUnit, rhs.businessUnit).append(routeCriteria, rhs.routeCriteria).append(createDateTime, rhs.createDateTime).append(job, rhs.job).append(jobCustomer, rhs.jobCustomer).append(jobLocation, rhs.jobLocation).append(jobProductList, rhs.jobProductList).append(jobEquipmentList, rhs.jobEquipmentList).isEquals();
    }

}
