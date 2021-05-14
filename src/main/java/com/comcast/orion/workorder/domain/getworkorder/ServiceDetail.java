
package com.comcast.orion.workorder.domain.getworkorder;

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
    "serviceId",
    "serviceType",
    "resources"
})
public class ServiceDetail {

    @JsonProperty("serviceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceId;
    @JsonProperty("serviceType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceType;
    @JsonProperty("resources")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Resource> resources = new ArrayList<Resource>();

    @JsonProperty("serviceId")
    public String getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceDetail withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public ServiceDetail withServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    @JsonProperty("resources")
    public List<Resource> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public ServiceDetail withResources(List<Resource> resources) {
        this.resources = resources;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceId).append(serviceType).append(resources).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceDetail) == false) {
            return false;
        }
        ServiceDetail rhs = ((ServiceDetail) other);
        return new EqualsBuilder().append(serviceId, rhs.serviceId).append(serviceType, rhs.serviceType).append(resources, rhs.resources).isEquals();
    }

}
