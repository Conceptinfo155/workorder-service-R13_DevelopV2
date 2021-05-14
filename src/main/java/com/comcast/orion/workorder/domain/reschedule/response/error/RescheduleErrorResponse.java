
package com.comcast.orion.workorder.domain.reschedule.response.error;

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


/**
 * The Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "workOrderNumber",
    "newWorkOrderNumber",
    "errors",
    "status"
})
public class RescheduleErrorResponse {

    /**
     * The Workordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String workOrderNumber = "";
    /**
     * The Newworkordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newWorkOrderNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String newWorkOrderNumber = "";
    /**
     * The Errors Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("errors")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Error> errors = new ArrayList<Error>();
    /**
     * The Status Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String status = "";

    /**
     * The Workordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderNumber")
    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    /**
     * The Workordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("workOrderNumber")
    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public RescheduleErrorResponse withWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
        return this;
    }

    /**
     * The Newworkordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newWorkOrderNumber")
    public String getNewWorkOrderNumber() {
        return newWorkOrderNumber;
    }

    /**
     * The Newworkordernumber Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newWorkOrderNumber")
    public void setNewWorkOrderNumber(String newWorkOrderNumber) {
        this.newWorkOrderNumber = newWorkOrderNumber;
    }

    public RescheduleErrorResponse withNewWorkOrderNumber(String newWorkOrderNumber) {
        this.newWorkOrderNumber = newWorkOrderNumber;
        return this;
    }

    /**
     * The Errors Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * The Errors Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public RescheduleErrorResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    /**
     * The Status Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * The Status Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public RescheduleErrorResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderNumber).append(newWorkOrderNumber).append(errors).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RescheduleErrorResponse) == false) {
            return false;
        }
        RescheduleErrorResponse rhs = ((RescheduleErrorResponse) other);
        return new EqualsBuilder().append(workOrderNumber, rhs.workOrderNumber).append(newWorkOrderNumber, rhs.newWorkOrderNumber).append(errors, rhs.errors).append(status, rhs.status).isEquals();
    }

}
