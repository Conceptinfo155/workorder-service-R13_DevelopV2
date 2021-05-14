
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

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
    "errors",
    "status",
    "workorderNumber"
})
public class ScheduleWorkorderResponse {

    @JsonProperty("errors")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Error> errors = new ArrayList<Error>();
    @JsonProperty("status")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String status;
    @JsonProperty("workorderNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String workorderNumber;

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public ScheduleWorkorderResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public ScheduleWorkorderResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("workorderNumber")
    public String getWorkorderNumber() {
        return workorderNumber;
    }

    @JsonProperty("workorderNumber")
    public void setWorkorderNumber(String workorderNumber) {
        this.workorderNumber = workorderNumber;
    }

    public ScheduleWorkorderResponse withWorkorderNumber(String workorderNumber) {
        this.workorderNumber = workorderNumber;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errors).append(status).append(workorderNumber).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScheduleWorkorderResponse) == false) {
            return false;
        }
        ScheduleWorkorderResponse rhs = ((ScheduleWorkorderResponse) other);
        return new EqualsBuilder().append(errors, rhs.errors).append(status, rhs.status).append(workorderNumber, rhs.workorderNumber).isEquals();
    }

}
