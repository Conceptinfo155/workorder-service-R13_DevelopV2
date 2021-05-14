
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "JobCommentTypeCd",
    "JobComment"
})
public class JobCommentTypeCdList {

    @JsonProperty("JobCommentTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobCommentTypeCd;
    @JsonProperty("JobComment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobComment;

    @JsonProperty("JobCommentTypeCd")
    public String getJobCommentTypeCd() {
        return jobCommentTypeCd;
    }

    @JsonProperty("JobCommentTypeCd")
    public void setJobCommentTypeCd(String jobCommentTypeCd) {
        this.jobCommentTypeCd = jobCommentTypeCd;
    }

    public JobCommentTypeCdList withJobCommentTypeCd(String jobCommentTypeCd) {
        this.jobCommentTypeCd = jobCommentTypeCd;
        return this;
    }

    @JsonProperty("JobComment")
    public String getJobComment() {
        return jobComment;
    }

    @JsonProperty("JobComment")
    public void setJobComment(String jobComment) {
        this.jobComment = jobComment;
    }

    public JobCommentTypeCdList withJobComment(String jobComment) {
        this.jobComment = jobComment;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobCommentTypeCd).append(jobComment).toHashCode();
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
        return new EqualsBuilder().append(jobCommentTypeCd, rhs.jobCommentTypeCd).append(jobComment, rhs.jobComment).isEquals();
    }

}
