
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
    "CancelAppointmentRequest"
})
public class CancelApmtRequest {

    @JsonProperty("CancelAppointmentRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CancelAppointmentRequest cancelAppointmentRequest;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CancelAppointmentRequest")
    public CancelAppointmentRequest getCancelAppointmentRequest() {
        return cancelAppointmentRequest;
    }

    @JsonProperty("CancelAppointmentRequest")
    public void setCancelAppointmentRequest(CancelAppointmentRequest cancelAppointmentRequest) {
        this.cancelAppointmentRequest = cancelAppointmentRequest;
    }

    public CancelApmtRequest withCancelAppointmentRequest(CancelAppointmentRequest cancelAppointmentRequest) {
        this.cancelAppointmentRequest = cancelAppointmentRequest;
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

    public CancelApmtRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cancelAppointmentRequest).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancelApmtRequest) == false) {
            return false;
        }
        CancelApmtRequest rhs = ((CancelApmtRequest) other);
        return new EqualsBuilder().append(cancelAppointmentRequest, rhs.cancelAppointmentRequest).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
