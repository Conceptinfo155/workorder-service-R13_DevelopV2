
package com.comcast.orion.workorder.domain.amil.getworkorder;

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
    "workOrderDetails"
})
public class AMILWorkorderResponse {

    @JsonProperty("workOrderDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private WorkOrderDetails workOrderDetails;

    @JsonProperty("workOrderDetails")
    public WorkOrderDetails getWorkOrderDetails() {
        return workOrderDetails;
    }

    @JsonProperty("workOrderDetails")
    public void setWorkOrderDetails(WorkOrderDetails workOrderDetails) {
        this.workOrderDetails = workOrderDetails;
    }

    public AMILWorkorderResponse withWorkOrderDetails(WorkOrderDetails workOrderDetails) {
        this.workOrderDetails = workOrderDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AMILWorkorderResponse) == false) {
            return false;
        }
        AMILWorkorderResponse rhs = ((AMILWorkorderResponse) other);
        return new EqualsBuilder().append(workOrderDetails, rhs.workOrderDetails).isEquals();
    }

}
