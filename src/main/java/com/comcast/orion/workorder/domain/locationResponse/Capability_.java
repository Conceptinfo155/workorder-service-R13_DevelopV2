
package com.comcast.orion.workorder.domain.locationResponse;

import java.util.ArrayList;
import java.util.List;
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
    "capabilityType"
})
public class Capability_ {

    @JsonProperty("capabilityType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Object> capabilityType = new ArrayList<Object>();

    @JsonProperty("capabilityType")
    public List<Object> getCapabilityType() {
        return capabilityType;
    }

    @JsonProperty("capabilityType")
    public void setCapabilityType(List<Object> capabilityType) {
        this.capabilityType = capabilityType;
    }

    public Capability_ withCapabilityType(List<Object> capabilityType) {
        this.capabilityType = capabilityType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(capabilityType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Capability_) == false) {
            return false;
        }
        Capability_ rhs = ((Capability_) other);
        return new EqualsBuilder().append(capabilityType, rhs.capabilityType).isEquals();
    }

}
