
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

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
    "workOrder"
})
public class GetWorkorderOMWResponseNew {

    /**
     * Work Order details
     * 
     */
    @JsonProperty("workOrder")
    @JsonPropertyDescription("Work Order details")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "Work Order details", example = "")
    @Valid
    private WorkOrder workOrder;

    /**
     * Work Order details
     * 
     */
    @JsonProperty("workOrder")
    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    /**
     * Work Order details
     * 
     */
    @JsonProperty("workOrder")
    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public GetWorkorderOMWResponseNew withWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrder).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GetWorkorderOMWResponseNew) == false) {
            return false;
        }
        GetWorkorderOMWResponseNew rhs = ((GetWorkorderOMWResponseNew) other);
        return new EqualsBuilder().append(workOrder, rhs.workOrder).isEquals();
    }

}
