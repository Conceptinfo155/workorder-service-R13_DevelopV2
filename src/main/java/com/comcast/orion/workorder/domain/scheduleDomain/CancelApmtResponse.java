
package com.comcast.orion.workorder.domain.scheduleDomain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
    "CancelAppointmentResponseDetails"
})
public class CancelApmtResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CancelAppointmentResponseDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private CancelAppointmentResponseDetails cancelAppointmentResponseDetails;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CancelAppointmentResponseDetails")
    public CancelAppointmentResponseDetails getCancelAppointmentResponseDetails() {
        return cancelAppointmentResponseDetails;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CancelAppointmentResponseDetails")
    public void setCancelAppointmentResponseDetails(CancelAppointmentResponseDetails cancelAppointmentResponseDetails) {
        this.cancelAppointmentResponseDetails = cancelAppointmentResponseDetails;
    }

    public CancelApmtResponse withCancelAppointmentResponseDetails(CancelAppointmentResponseDetails cancelAppointmentResponseDetails) {
        this.cancelAppointmentResponseDetails = cancelAppointmentResponseDetails;
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

    public CancelApmtResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cancelAppointmentResponseDetails).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CancelApmtResponse) == false) {
            return false;
        }
        CancelApmtResponse rhs = ((CancelApmtResponse) other);
        return new EqualsBuilder().append(cancelAppointmentResponseDetails, rhs.cancelAppointmentResponseDetails).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
