
package com.comcast.orion.workorder.domain.scheduleDomain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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
    "CancelAppointmentResponse"
})
public class CancelAppointmentResponseDetails {

    @JsonProperty("CancelAppointmentResponse")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CancelAppointmentResponse cancelAppointmentResponse;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CancelAppointmentResponse")
    public CancelAppointmentResponse getCancelAppointmentResponse() {
        return cancelAppointmentResponse;
    }

    @JsonProperty("CancelAppointmentResponse")
    public void setCancelAppointmentResponse(CancelAppointmentResponse cancelAppointmentResponse) {
        this.cancelAppointmentResponse = cancelAppointmentResponse;
    }

    public CancelAppointmentResponseDetails withCancelAppointmentResponse(CancelAppointmentResponse cancelAppointmentResponse) {
        this.cancelAppointmentResponse = cancelAppointmentResponse;
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

    public CancelAppointmentResponseDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cancelAppointmentResponse).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancelAppointmentResponseDetails) == false) {
            return false;
        }
        CancelAppointmentResponseDetails rhs = ((CancelAppointmentResponseDetails) other);
        return new EqualsBuilder().append(cancelAppointmentResponse, rhs.cancelAppointmentResponse).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
