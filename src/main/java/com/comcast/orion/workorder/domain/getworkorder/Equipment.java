
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
    "equipmentType",
    "ownedBy",
    "services"
})
public class Equipment {

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
    @JsonProperty("equipmentType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String equipmentType;
    @JsonProperty("ownedBy")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ownedBy;
    @JsonProperty("services")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Service> services = new ArrayList<Service>();

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    public Equipment withAction(String action) {
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

    public Equipment withServiceId(String serviceId) {
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

    public Equipment withArmObjectName(String armObjectName) {
        this.armObjectName = armObjectName;
        return this;
    }

    @JsonProperty("equipmentType")
    public String getEquipmentType() {
        return equipmentType;
    }

    @JsonProperty("equipmentType")
    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Equipment withEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
        return this;
    }
    
    @JsonProperty("ownedBy")
    public String getOwnedBy() {
        return ownedBy;
    }

    @JsonProperty("ownedBy")
    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    public Equipment withOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
        return this;
    }

    @JsonProperty("services")
    public List<Service> getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Equipment withServices(List<Service> services) {
        this.services = services;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(action).append(serviceId).append(armObjectName).append(equipmentType).append(ownedBy).append(services).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Equipment) == false) {
            return false;
        }
        Equipment rhs = ((Equipment) other);
        return new EqualsBuilder().append(action, rhs.action).append(serviceId, rhs.serviceId).append(armObjectName, rhs.armObjectName).append(equipmentType, rhs.equipmentType).append(ownedBy, rhs.ownedBy).append(services, rhs.services).isEquals();
    }

}
