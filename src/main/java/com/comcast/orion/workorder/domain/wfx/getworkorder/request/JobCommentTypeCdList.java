
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The Items Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "JobComment",
    "JobCommentTypeCd"
})
public class JobCommentTypeCdList {

    /**
     * The Jobcomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobComment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobComment = "";
    /**
     * The Jobcommenttypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String jobCommentTypeCd = "";

    /**
     * The Jobcomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobComment")
    public String getJobComment() {
        return jobComment;
    }

    /**
     * The Jobcomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobComment")
    public void setJobComment(String jobComment) {
        this.jobComment = jobComment;
    }

    public JobCommentTypeCdList withJobComment(String jobComment) {
        this.jobComment = jobComment;
        return this;
    }

    /**
     * The Jobcommenttypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCd")
    public String getJobCommentTypeCd() {
        return jobCommentTypeCd;
    }

    /**
     * The Jobcommenttypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("JobCommentTypeCd")
    public void setJobCommentTypeCd(String jobCommentTypeCd) {
        this.jobCommentTypeCd = jobCommentTypeCd;
    }

    public JobCommentTypeCdList withJobCommentTypeCd(String jobCommentTypeCd) {
        this.jobCommentTypeCd = jobCommentTypeCd;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobComment).append(jobCommentTypeCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobCommentTypeCdList) == false) {
            return false;
        }
        JobCommentTypeCdList rhs = ((JobCommentTypeCdList) other);
        return new EqualsBuilder().append(jobComment, rhs.jobComment).append(jobCommentTypeCd, rhs.jobCommentTypeCd).isEquals();
    }

}
