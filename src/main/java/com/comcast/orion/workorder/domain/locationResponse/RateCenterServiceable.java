
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
    "serviceable"
})
public class RateCenterServiceable {

    @JsonProperty("serviceable")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<String> serviceable = new ArrayList<String>();

    @JsonProperty("serviceable")
    public List<String> getServiceable() {
        return serviceable;
    }

    @JsonProperty("serviceable")
    public void setServiceable(List<String> serviceable) {
        this.serviceable = serviceable;
    }

    public RateCenterServiceable withServiceable(List<String> serviceable) {
        this.serviceable = serviceable;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceable).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RateCenterServiceable) == false) {
            return false;
        }
        RateCenterServiceable rhs = ((RateCenterServiceable) other);
        return new EqualsBuilder().append(serviceable, rhs.serviceable).isEquals();
    }

}
