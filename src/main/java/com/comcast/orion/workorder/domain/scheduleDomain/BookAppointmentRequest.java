
package com.comcast.orion.workorder.domain.scheduleDomain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({
    "appointmentId",
    "appointmentOption",
    "forceBookInd",
    "requesterId",
    "reservationId"
})
public class BookAppointmentRequest {

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("appointmentId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 1, value = "", example = "ORION-63434")
    @Size(min = 1, max = 20)
    @NotNull
    private String appointmentId;
    @JsonProperty("appointmentOption")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 2, value = "", example = "")
    @Valid
    private AppointmentOption_ appointmentOption;
    @JsonProperty("forceBookInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "true")
    @Size(min = 1, max = 5)
    private String forceBookInd;
    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("requesterId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "ORION")
    @Size(min = 1, max = 30)
    @NotNull
    private String requesterId;
    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "5778903")
    @Size(min = 1, max = 19)
    @NotNull
    private String reservationId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("appointmentId")
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("appointmentId")
    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BookAppointmentRequest withAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
        return this;
    }

    @JsonProperty("appointmentOption")
    public AppointmentOption_ getAppointmentOption() {
        return appointmentOption;
    }

    @JsonProperty("appointmentOption")
    public void setAppointmentOption(AppointmentOption_ appointmentOption) {
        this.appointmentOption = appointmentOption;
    }

    public BookAppointmentRequest withAppointmentOption(AppointmentOption_ appointmentOption) {
        this.appointmentOption = appointmentOption;
        return this;
    }

    @JsonProperty("forceBookInd")
    public String getForceBookInd() {
        return forceBookInd;
    }

    @JsonProperty("forceBookInd")
    public void setForceBookInd(String forceBookInd) {
        this.forceBookInd = forceBookInd;
    }

    public BookAppointmentRequest withForceBookInd(String forceBookInd) {
        this.forceBookInd = forceBookInd;
        return this;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("requesterId")
    public String getRequesterId() {
        return requesterId;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("requesterId")
    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public BookAppointmentRequest withRequesterId(String requesterId) {
        this.requesterId = requesterId;
        return this;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    public String getReservationId() {
        return reservationId;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public BookAppointmentRequest withReservationId(String reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public BookAppointmentRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(appointmentId).append(appointmentOption).append(forceBookInd).append(requesterId).append(reservationId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BookAppointmentRequest) == false) {
            return false;
        }
        BookAppointmentRequest rhs = ((BookAppointmentRequest) other);
        return new EqualsBuilder().append(appointmentId, rhs.appointmentId).append(appointmentOption, rhs.appointmentOption).append(forceBookInd, rhs.forceBookInd).append(requesterId, rhs.requesterId).append(reservationId, rhs.reservationId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
