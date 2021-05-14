
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
    "capabilityName"
})
public class MarketCapabilities {

    @JsonProperty("capabilityName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CapabilityName capabilityName;

    @JsonProperty("capabilityName")
    public CapabilityName getCapabilityName() {
        return capabilityName;
    }

    @JsonProperty("capabilityName")
    public void setCapabilityName(CapabilityName capabilityName) {
        this.capabilityName = capabilityName;
    }

    public MarketCapabilities withCapabilityName(CapabilityName capabilityName) {
        this.capabilityName = capabilityName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(capabilityName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarketCapabilities) == false) {
            return false;
        }
        MarketCapabilities rhs = ((MarketCapabilities) other);
        return new EqualsBuilder().append(capabilityName, rhs.capabilityName).isEquals();
    }

}
