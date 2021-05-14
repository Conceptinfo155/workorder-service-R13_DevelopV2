
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

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
 * The Jobcustomfields Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "JobCustom5",
    "JobCustom10",
    "JobCustom9",
    "JobCustom8",
    "JobCustom6",
    "JobCustom4",
    "JobCustom1",
    "JobCustom3",
    "JobCustom2",
    "JobCustom11",
    "JobCustom7",
    "JobCustom12"
})
public class JobCustomFields {

    /**
     * The Jobcustom5 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom5")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom5 = null;
    /**
     * The Jobcustom10 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom10")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom10 = null;
    /**
     * The Jobcustom9 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom9")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom9 = null;
    /**
     * The Jobcustom8 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom8")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom8 = null;
    /**
     * The Jobcustom6 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom6")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom6 = null;
    /**
     * The Jobcustom4 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom4")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom4 = null;
    /**
     * The Jobcustom1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom1 = null;
    /**
     * The Jobcustom3 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom3")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom3 = null;
    /**
     * The Jobcustom2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom2 = null;
    /**
     * The Jobcustom11 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom11")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom11 = null;
    /**
     * The Jobcustom7 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom7")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom7 = null;
    /**
     * The Jobcustom12 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom12")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object jobCustom12 = null;

    /**
     * The Jobcustom5 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom5")
    public Object getJobCustom5() {
        return jobCustom5;
    }

    /**
     * The Jobcustom5 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom5")
    public void setJobCustom5(Object jobCustom5) {
        this.jobCustom5 = jobCustom5;
    }

    public JobCustomFields withJobCustom5(Object jobCustom5) {
        this.jobCustom5 = jobCustom5;
        return this;
    }

    /**
     * The Jobcustom10 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom10")
    public Object getJobCustom10() {
        return jobCustom10;
    }

    /**
     * The Jobcustom10 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom10")
    public void setJobCustom10(Object jobCustom10) {
        this.jobCustom10 = jobCustom10;
    }

    public JobCustomFields withJobCustom10(Object jobCustom10) {
        this.jobCustom10 = jobCustom10;
        return this;
    }

    /**
     * The Jobcustom9 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom9")
    public Object getJobCustom9() {
        return jobCustom9;
    }

    /**
     * The Jobcustom9 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom9")
    public void setJobCustom9(Object jobCustom9) {
        this.jobCustom9 = jobCustom9;
    }

    public JobCustomFields withJobCustom9(Object jobCustom9) {
        this.jobCustom9 = jobCustom9;
        return this;
    }

    /**
     * The Jobcustom8 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom8")
    public Object getJobCustom8() {
        return jobCustom8;
    }

    /**
     * The Jobcustom8 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom8")
    public void setJobCustom8(Object jobCustom8) {
        this.jobCustom8 = jobCustom8;
    }

    public JobCustomFields withJobCustom8(Object jobCustom8) {
        this.jobCustom8 = jobCustom8;
        return this;
    }

    /**
     * The Jobcustom6 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom6")
    public Object getJobCustom6() {
        return jobCustom6;
    }

    /**
     * The Jobcustom6 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom6")
    public void setJobCustom6(Object jobCustom6) {
        this.jobCustom6 = jobCustom6;
    }

    public JobCustomFields withJobCustom6(Object jobCustom6) {
        this.jobCustom6 = jobCustom6;
        return this;
    }

    /**
     * The Jobcustom4 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom4")
    public Object getJobCustom4() {
        return jobCustom4;
    }

    /**
     * The Jobcustom4 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom4")
    public void setJobCustom4(Object jobCustom4) {
        this.jobCustom4 = jobCustom4;
    }

    public JobCustomFields withJobCustom4(Object jobCustom4) {
        this.jobCustom4 = jobCustom4;
        return this;
    }

    /**
     * The Jobcustom1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom1")
    public Object getJobCustom1() {
        return jobCustom1;
    }

    /**
     * The Jobcustom1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom1")
    public void setJobCustom1(Object jobCustom1) {
        this.jobCustom1 = jobCustom1;
    }

    public JobCustomFields withJobCustom1(Object jobCustom1) {
        this.jobCustom1 = jobCustom1;
        return this;
    }

    /**
     * The Jobcustom3 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom3")
    public Object getJobCustom3() {
        return jobCustom3;
    }

    /**
     * The Jobcustom3 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom3")
    public void setJobCustom3(Object jobCustom3) {
        this.jobCustom3 = jobCustom3;
    }

    public JobCustomFields withJobCustom3(Object jobCustom3) {
        this.jobCustom3 = jobCustom3;
        return this;
    }

    /**
     * The Jobcustom2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom2")
    public Object getJobCustom2() {
        return jobCustom2;
    }

    /**
     * The Jobcustom2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom2")
    public void setJobCustom2(Object jobCustom2) {
        this.jobCustom2 = jobCustom2;
    }

    public JobCustomFields withJobCustom2(Object jobCustom2) {
        this.jobCustom2 = jobCustom2;
        return this;
    }

    /**
     * The Jobcustom11 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom11")
    public Object getJobCustom11() {
        return jobCustom11;
    }

    /**
     * The Jobcustom11 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom11")
    public void setJobCustom11(Object jobCustom11) {
        this.jobCustom11 = jobCustom11;
    }

    public JobCustomFields withJobCustom11(Object jobCustom11) {
        this.jobCustom11 = jobCustom11;
        return this;
    }

    /**
     * The Jobcustom7 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom7")
    public Object getJobCustom7() {
        return jobCustom7;
    }

    /**
     * The Jobcustom7 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom7")
    public void setJobCustom7(Object jobCustom7) {
        this.jobCustom7 = jobCustom7;
    }

    public JobCustomFields withJobCustom7(Object jobCustom7) {
        this.jobCustom7 = jobCustom7;
        return this;
    }

    /**
     * The Jobcustom12 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom12")
    public Object getJobCustom12() {
        return jobCustom12;
    }

    /**
     * The Jobcustom12 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCustom12")
    public void setJobCustom12(Object jobCustom12) {
        this.jobCustom12 = jobCustom12;
    }

    public JobCustomFields withJobCustom12(Object jobCustom12) {
        this.jobCustom12 = jobCustom12;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobCustom5).append(jobCustom10).append(jobCustom9).append(jobCustom8).append(jobCustom6).append(jobCustom4).append(jobCustom1).append(jobCustom3).append(jobCustom2).append(jobCustom11).append(jobCustom7).append(jobCustom12).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobCustomFields) == false) {
            return false;
        }
        JobCustomFields rhs = ((JobCustomFields) other);
        return new EqualsBuilder().append(jobCustom5, rhs.jobCustom5).append(jobCustom10, rhs.jobCustom10).append(jobCustom9, rhs.jobCustom9).append(jobCustom8, rhs.jobCustom8).append(jobCustom6, rhs.jobCustom6).append(jobCustom4, rhs.jobCustom4).append(jobCustom1, rhs.jobCustom1).append(jobCustom3, rhs.jobCustom3).append(jobCustom2, rhs.jobCustom2).append(jobCustom11, rhs.jobCustom11).append(jobCustom7, rhs.jobCustom7).append(jobCustom12, rhs.jobCustom12).isEquals();
    }

}
