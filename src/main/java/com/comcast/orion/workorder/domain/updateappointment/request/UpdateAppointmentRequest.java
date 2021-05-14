
package com.comcast.orion.workorder.domain.updateappointment.request;

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
    "newAppointmentId"
})
public class UpdateAppointmentRequest {

    /**
     * The Newappointmentid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newAppointmentId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String newAppointmentId = "";

    /**
     * The Newappointmentid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newAppointmentId")
    public String getNewAppointmentId() {
        return newAppointmentId;
    }

    /**
     * The Newappointmentid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("newAppointmentId")
    public void setNewAppointmentId(String newAppointmentId) {
        this.newAppointmentId = newAppointmentId;
    }

    public UpdateAppointmentRequest withNewAppointmentId(String newAppointmentId) {
        this.newAppointmentId = newAppointmentId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(newAppointmentId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateAppointmentRequest) == false) {
            return false;
        }
        UpdateAppointmentRequest rhs = ((UpdateAppointmentRequest) other);
        return new EqualsBuilder().append(newAppointmentId, rhs.newAppointmentId).isEquals();
    }

}
