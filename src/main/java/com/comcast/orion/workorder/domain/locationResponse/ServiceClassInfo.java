
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
    "serviceClassInfoType"
})
public class ServiceClassInfo {

    @JsonProperty("serviceClassInfoType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<ServiceClassInfoType> serviceClassInfoType = new ArrayList<ServiceClassInfoType>();

    @JsonProperty("serviceClassInfoType")
    public List<ServiceClassInfoType> getServiceClassInfoType() {
        return serviceClassInfoType;
    }

    @JsonProperty("serviceClassInfoType")
    public void setServiceClassInfoType(List<ServiceClassInfoType> serviceClassInfoType) {
        this.serviceClassInfoType = serviceClassInfoType;
    }

    public ServiceClassInfo withServiceClassInfoType(List<ServiceClassInfoType> serviceClassInfoType) {
        this.serviceClassInfoType = serviceClassInfoType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceClassInfoType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceClassInfo) == false) {
            return false;
        }
        ServiceClassInfo rhs = ((ServiceClassInfo) other);
        return new EqualsBuilder().append(serviceClassInfoType, rhs.serviceClassInfoType).isEquals();
    }

}
