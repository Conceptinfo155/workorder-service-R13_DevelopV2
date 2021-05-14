
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
    "serviceClassInfo"
})
public class SpeedTierInfo {

    @JsonProperty("serviceClassInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ServiceClassInfo serviceClassInfo;

    @JsonProperty("serviceClassInfo")
    public ServiceClassInfo getServiceClassInfo() {
        return serviceClassInfo;
    }

    @JsonProperty("serviceClassInfo")
    public void setServiceClassInfo(ServiceClassInfo serviceClassInfo) {
        this.serviceClassInfo = serviceClassInfo;
    }

    public SpeedTierInfo withServiceClassInfo(ServiceClassInfo serviceClassInfo) {
        this.serviceClassInfo = serviceClassInfo;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceClassInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SpeedTierInfo) == false) {
            return false;
        }
        SpeedTierInfo rhs = ((SpeedTierInfo) other);
        return new EqualsBuilder().append(serviceClassInfo, rhs.serviceClassInfo).isEquals();
    }

}
