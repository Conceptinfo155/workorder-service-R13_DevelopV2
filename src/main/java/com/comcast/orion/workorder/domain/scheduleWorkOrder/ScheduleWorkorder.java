
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

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
    "ScheduleWorkorderRequest"
})
public class ScheduleWorkorder {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("ScheduleWorkorderRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ScheduleWorkorderRequest scheduleWorkorderRequest;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleWorkorderRequest")
    public ScheduleWorkorderRequest getScheduleWorkorderRequest() {
        return scheduleWorkorderRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ScheduleWorkorderRequest")
    public void setScheduleWorkorderRequest(ScheduleWorkorderRequest scheduleWorkorderRequest) {
        this.scheduleWorkorderRequest = scheduleWorkorderRequest;
    }

    public ScheduleWorkorder withScheduleWorkorderRequest(ScheduleWorkorderRequest scheduleWorkorderRequest) {
        this.scheduleWorkorderRequest = scheduleWorkorderRequest;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(scheduleWorkorderRequest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScheduleWorkorder) == false) {
            return false;
        }
        ScheduleWorkorder rhs = ((ScheduleWorkorder) other);
        return new EqualsBuilder().append(scheduleWorkorderRequest, rhs.scheduleWorkorderRequest).isEquals();
    }

}
