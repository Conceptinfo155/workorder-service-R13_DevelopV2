
package com.comcast.orion.workorder.domain.vms;

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
    "type",
    "designID",
    "serviceID",
    "service"
})
public class Service {

    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("designID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String designID;
    @JsonProperty("serviceID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceID;
    @JsonProperty("service")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Service_> service = new ArrayList<Service_>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Service withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("designID")
    public String getDesignID() {
        return designID;
    }

    @JsonProperty("designID")
    public void setDesignID(String designID) {
        this.designID = designID;
    }

    public Service withDesignID(String designID) {
        this.designID = designID;
        return this;
    }

    @JsonProperty("serviceID")
    public String getServiceID() {
        return serviceID;
    }

    @JsonProperty("serviceID")
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public Service withServiceID(String serviceID) {
        this.serviceID = serviceID;
        return this;
    }

    @JsonProperty("service")
    public List<Service_> getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(List<Service_> service) {
        this.service = service;
    }

    public Service withService(List<Service_> service) {
        this.service = service;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(designID).append(serviceID).append(service).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Service) == false) {
            return false;
        }
        Service rhs = ((Service) other);
        return new EqualsBuilder().append(type, rhs.type).append(designID, rhs.designID).append(serviceID, rhs.serviceID).append(service, rhs.service).isEquals();
    }

}
