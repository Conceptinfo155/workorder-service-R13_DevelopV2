
package com.comcast.orion.workorder.domain.reschedule.request;

import java.util.ArrayList;
import java.util.List;
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
    "solutionDetails",
    "appointment",
    "workOrder"
})
public class RescheduleRequest {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("solutionDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("appointment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Appointment appointment;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("workOrder")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private WorkOrder workOrder;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionDetails")
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetails;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionDetails")
    public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
    }

    public RescheduleRequest withSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("appointment")
    public Appointment getAppointment() {
        return appointment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("appointment")
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public RescheduleRequest withAppointment(Appointment appointment) {
        this.appointment = appointment;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrder")
    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrder")
    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public RescheduleRequest withWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(solutionDetails).append(appointment).append(workOrder).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RescheduleRequest) == false) {
            return false;
        }
        RescheduleRequest rhs = ((RescheduleRequest) other);
        return new EqualsBuilder().append(solutionDetails, rhs.solutionDetails).append(appointment, rhs.appointment).append(workOrder, rhs.workOrder).isEquals();
    }

}
