
package com.comcast.orion.workorder.domain.updateappointment.response;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    "errors",
    "status"
})
public class UpdateAppointmentResponse {

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
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String status = "";

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

    public UpdateAppointmentResponse withErrors(List<Error> errors) {
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

    public UpdateAppointmentResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errors).append(status).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateAppointmentResponse) == false) {
            return false;
        }
        UpdateAppointmentResponse rhs = ((UpdateAppointmentResponse) other);
        return new EqualsBuilder().append(errors, rhs.errors).append(status, rhs.status).isEquals();
    }

}
