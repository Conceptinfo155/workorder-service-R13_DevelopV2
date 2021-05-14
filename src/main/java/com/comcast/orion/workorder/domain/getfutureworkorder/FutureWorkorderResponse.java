
package com.comcast.orion.workorder.domain.getfutureworkorder;

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
    "workOrderDetails"
})
public class FutureWorkorderResponse {

    @JsonProperty("workOrderDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<WorkOrderDetail> workOrderDetails = new ArrayList<WorkOrderDetail>();

    @JsonProperty("workOrderDetails")
    public List<WorkOrderDetail> getWorkOrderDetails() {
        return workOrderDetails;
    }

    @JsonProperty("workOrderDetails")
    public void setWorkOrderDetails(List<WorkOrderDetail> workOrderDetails) {
        this.workOrderDetails = workOrderDetails;
    }

    public FutureWorkorderResponse withWorkOrderDetails(List<WorkOrderDetail> workOrderDetails) {
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
        if ((other instanceof FutureWorkorderResponse) == false) {
            return false;
        }
        FutureWorkorderResponse rhs = ((FutureWorkorderResponse) other);
        return new EqualsBuilder().append(workOrderDetails, rhs.workOrderDetails).isEquals();
    }

}
