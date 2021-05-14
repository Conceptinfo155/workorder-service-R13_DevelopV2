
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
    "action",
    "serviceId",
    "armObjectName",
    "serviceType",
    "name",
    "characteristics"
})
public class DependentService {

    @JsonProperty("action")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String action;
    @JsonProperty("serviceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceId;
    @JsonProperty("armObjectName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String armObjectName;
    @JsonProperty("serviceType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceType;
    @JsonProperty("name")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String name;
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic_> characteristics = new ArrayList<Characteristic_>();

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    public DependentService withAction(String action) {
        this.action = action;
        return this;
    }

    @JsonProperty("serviceId")
    public String getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public DependentService withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    @JsonProperty("armObjectName")
    public String getArmObjectName() {
        return armObjectName;
    }

    @JsonProperty("armObjectName")
    public void setArmObjectName(String armObjectName) {
        this.armObjectName = armObjectName;
    }

    public DependentService withArmObjectName(String armObjectName) {
        this.armObjectName = armObjectName;
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

    public DependentService withServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public DependentService withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("characteristics")
    public List<Characteristic_> getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("characteristics")
    public void setCharacteristics(List<Characteristic_> characteristics) {
        this.characteristics = characteristics;
    }

    public DependentService withCharacteristics(List<Characteristic_> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(action).append(serviceId).append(armObjectName).append(serviceType).append(name).append(characteristics).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DependentService) == false) {
            return false;
        }
        DependentService rhs = ((DependentService) other);
        return new EqualsBuilder().append(action, rhs.action).append(serviceId, rhs.serviceId).append(armObjectName, rhs.armObjectName).append(serviceType, rhs.serviceType).append(name, rhs.name).append(characteristics, rhs.characteristics).isEquals();
    }

}
