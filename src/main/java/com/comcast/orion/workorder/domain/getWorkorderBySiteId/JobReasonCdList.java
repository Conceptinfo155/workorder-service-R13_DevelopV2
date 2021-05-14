
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
    "JobReasonCd"
})
public class JobReasonCdList {

    @JsonProperty("JobReasonCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobReasonCd;

    @JsonProperty("JobReasonCd")
    public String getJobReasonCd() {
        return jobReasonCd;
    }

    @JsonProperty("JobReasonCd")
    public void setJobReasonCd(String jobReasonCd) {
        this.jobReasonCd = jobReasonCd;
    }

    public JobReasonCdList withJobReasonCd(String jobReasonCd) {
        this.jobReasonCd = jobReasonCd;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jobReasonCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobReasonCdList) == false) {
            return false;
        }
        JobReasonCdList rhs = ((JobReasonCdList) other);
        return new EqualsBuilder().append(jobReasonCd, rhs.jobReasonCd).isEquals();
    }

}
