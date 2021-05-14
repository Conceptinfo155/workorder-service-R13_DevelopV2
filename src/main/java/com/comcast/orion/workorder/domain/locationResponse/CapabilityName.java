
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
    "capability"
})
public class CapabilityName {

    @JsonProperty("capability")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<String> capability = new ArrayList<String>();

    @JsonProperty("capability")
    public List<String> getCapability() {
        return capability;
    }

    @JsonProperty("capability")
    public void setCapability(List<String> capability) {
        this.capability = capability;
    }

    public CapabilityName withCapability(List<String> capability) {
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
        if ((other instanceof CapabilityName) == false) {
            return false;
        }
        CapabilityName rhs = ((CapabilityName) other);
        return new EqualsBuilder().append(capability, rhs.capability).isEquals();
    }

}
