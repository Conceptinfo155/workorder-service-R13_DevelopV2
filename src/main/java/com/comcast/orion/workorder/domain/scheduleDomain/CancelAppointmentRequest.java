
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
    "appointmentId"
})
public class CancelAppointmentRequest {

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("appointmentId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 1, value = "", example = "909090661222")
    @Size(min = 1, max = 20)
    @NotNull
    private String appointmentId;
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

    public CancelAppointmentRequest withAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
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

    public CancelAppointmentRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(appointmentId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancelAppointmentRequest) == false) {
            return false;
        }
        CancelAppointmentRequest rhs = ((CancelAppointmentRequest) other);
        return new EqualsBuilder().append(appointmentId, rhs.appointmentId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
