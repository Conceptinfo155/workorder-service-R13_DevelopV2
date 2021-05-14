
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
    "capability"
})
public class LocationCapabilities {

    @JsonProperty("capability")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Capability capability;

    @JsonProperty("capability")
    public Capability getCapability() {
        return capability;
    }

    @JsonProperty("capability")
    public void setCapability(Capability capability) {
        this.capability = capability;
    }

    public LocationCapabilities withCapability(Capability capability) {
        this.capability = capability;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(capability).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationCapabilities) == false) {
            return false;
        }
        LocationCapabilities rhs = ((LocationCapabilities) other);
        return new EqualsBuilder().append(capability, rhs.capability).isEquals();
    }

}
