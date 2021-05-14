
package com.comcast.orion.workorder.domain.amil.getworkorder.request;

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
    "workOrderId"
})
public class WorkOrderDetailsRequest {

    @JsonProperty("workOrderId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String workOrderId;

    @JsonProperty("workOrderId")
    public String getWorkOrderId() {
        return workOrderId;
    }

    @JsonProperty("workOrderId")
    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public WorkOrderDetailsRequest withWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkOrderDetailsRequest) == false) {
            return false;
        }
        WorkOrderDetailsRequest rhs = ((WorkOrderDetailsRequest) other);
        return new EqualsBuilder().append(workOrderId, rhs.workOrderId).isEquals();
    }

}
