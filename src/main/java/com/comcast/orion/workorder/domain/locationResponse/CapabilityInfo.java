
package com.comcast.orion.workorder.domain.locationResponse;

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
    "locationCapabilities",
    "locationCapabilityExceptions"
})
public class CapabilityInfo {

    @JsonProperty("locationCapabilities")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LocationCapabilities locationCapabilities;
    @JsonProperty("locationCapabilityExceptions")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LocationCapabilityExceptions locationCapabilityExceptions;

    @JsonProperty("locationCapabilities")
    public LocationCapabilities getLocationCapabilities() {
        return locationCapabilities;
    }

    @JsonProperty("locationCapabilities")
    public void setLocationCapabilities(LocationCapabilities locationCapabilities) {
        this.locationCapabilities = locationCapabilities;
    }

    public CapabilityInfo withLocationCapabilities(LocationCapabilities locationCapabilities) {
        this.locationCapabilities = locationCapabilities;
        return this;
    }

    @JsonProperty("locationCapabilityExceptions")
    public LocationCapabilityExceptions getLocationCapabilityExceptions() {
        return locationCapabilityExceptions;
    }

    @JsonProperty("locationCapabilityExceptions")
    public void setLocationCapabilityExceptions(LocationCapabilityExceptions locationCapabilityExceptions) {
        this.locationCapabilityExceptions = locationCapabilityExceptions;
    }

    public CapabilityInfo withLocationCapabilityExceptions(LocationCapabilityExceptions locationCapabilityExceptions) {
        this.locationCapabilityExceptions = locationCapabilityExceptions;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(locationCapabilities).append(locationCapabilityExceptions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CapabilityInfo) == false) {
            return false;
        }
        CapabilityInfo rhs = ((CapabilityInfo) other);
        return new EqualsBuilder().append(locationCapabilities, rhs.locationCapabilities).append(locationCapabilityExceptions, rhs.locationCapabilityExceptions).isEquals();
    }

}
