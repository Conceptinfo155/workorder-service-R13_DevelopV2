
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "AssocDeviceComponent",
    "EquipMake",
    "AssocDeviceSerialNum",
    "SerialNum",
    "SubType",
    "UsageReturnPath",
    "EquipStatusCd",
    "OwnerCd",
    "HostId",
    "AssocDeviceType",
    "EquipTypeCd",
    "EquipCategoryCd",
    "DeviceAddress",
    "EquipModelCd",
    "DeviceAddress2",
    "SecurityDataId",
    "ComponentCd"
})
public class JobEquipmentList {

    @JsonProperty("AssocDeviceComponent")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object assocDeviceComponent;
    @JsonProperty("EquipMake")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object equipMake;
    @JsonProperty("AssocDeviceSerialNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object assocDeviceSerialNum;
    @JsonProperty("SerialNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serialNum;
    @JsonProperty("SubType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object subType;
    @JsonProperty("UsageReturnPath")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object usageReturnPath;
    @JsonProperty("EquipStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String equipStatusCd;
    @JsonProperty("OwnerCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ownerCd;
    @JsonProperty("HostId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object hostId;
    @JsonProperty("AssocDeviceType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object assocDeviceType;
    @JsonProperty("EquipTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String equipTypeCd;
    @JsonProperty("EquipCategoryCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String equipCategoryCd;
    @JsonProperty("DeviceAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object deviceAddress;
    @JsonProperty("EquipModelCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object equipModelCd;
    @JsonProperty("DeviceAddress2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object deviceAddress2;
    @JsonProperty("SecurityDataId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object securityDataId;
    @JsonProperty("ComponentCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String componentCd;

    @JsonProperty("AssocDeviceComponent")
    public Object getAssocDeviceComponent() {
        return assocDeviceComponent;
    }

    @JsonProperty("AssocDeviceComponent")
    public void setAssocDeviceComponent(Object assocDeviceComponent) {
        this.assocDeviceComponent = assocDeviceComponent;
    }

    public JobEquipmentList withAssocDeviceComponent(Object assocDeviceComponent) {
        this.assocDeviceComponent = assocDeviceComponent;
        return this;
    }

    @JsonProperty("EquipMake")
    public Object getEquipMake() {
        return equipMake;
    }

    @JsonProperty("EquipMake")
    public void setEquipMake(Object equipMake) {
        this.equipMake = equipMake;
    }

    public JobEquipmentList withEquipMake(Object equipMake) {
        this.equipMake = equipMake;
        return this;
    }

    @JsonProperty("AssocDeviceSerialNum")
    public Object getAssocDeviceSerialNum() {
        return assocDeviceSerialNum;
    }

    @JsonProperty("AssocDeviceSerialNum")
    public void setAssocDeviceSerialNum(Object assocDeviceSerialNum) {
        this.assocDeviceSerialNum = assocDeviceSerialNum;
    }

    public JobEquipmentList withAssocDeviceSerialNum(Object assocDeviceSerialNum) {
        this.assocDeviceSerialNum = assocDeviceSerialNum;
        return this;
    }

    @JsonProperty("SerialNum")
    public String getSerialNum() {
        return serialNum;
    }

    @JsonProperty("SerialNum")
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public JobEquipmentList withSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    @JsonProperty("SubType")
    public Object getSubType() {
        return subType;
    }

    @JsonProperty("SubType")
    public void setSubType(Object subType) {
        this.subType = subType;
    }

    public JobEquipmentList withSubType(Object subType) {
        this.subType = subType;
        return this;
    }

    @JsonProperty("UsageReturnPath")
    public Object getUsageReturnPath() {
        return usageReturnPath;
    }

    @JsonProperty("UsageReturnPath")
    public void setUsageReturnPath(Object usageReturnPath) {
        this.usageReturnPath = usageReturnPath;
    }

    public JobEquipmentList withUsageReturnPath(Object usageReturnPath) {
        this.usageReturnPath = usageReturnPath;
        return this;
    }

    @JsonProperty("EquipStatusCd")
    public String getEquipStatusCd() {
        return equipStatusCd;
    }

    @JsonProperty("EquipStatusCd")
    public void setEquipStatusCd(String equipStatusCd) {
        this.equipStatusCd = equipStatusCd;
    }

    public JobEquipmentList withEquipStatusCd(String equipStatusCd) {
        this.equipStatusCd = equipStatusCd;
        return this;
    }

    @JsonProperty("OwnerCd")
    public String getOwnerCd() {
        return ownerCd;
    }

    @JsonProperty("OwnerCd")
    public void setOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
    }

    public JobEquipmentList withOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
        return this;
    }

    @JsonProperty("HostId")
    public Object getHostId() {
        return hostId;
    }

    @JsonProperty("HostId")
    public void setHostId(Object hostId) {
        this.hostId = hostId;
    }

    public JobEquipmentList withHostId(Object hostId) {
        this.hostId = hostId;
        return this;
    }

    @JsonProperty("AssocDeviceType")
    public Object getAssocDeviceType() {
        return assocDeviceType;
    }

    @JsonProperty("AssocDeviceType")
    public void setAssocDeviceType(Object assocDeviceType) {
        this.assocDeviceType = assocDeviceType;
    }

    public JobEquipmentList withAssocDeviceType(Object assocDeviceType) {
        this.assocDeviceType = assocDeviceType;
        return this;
    }

    @JsonProperty("EquipTypeCd")
    public String getEquipTypeCd() {
        return equipTypeCd;
    }

    @JsonProperty("EquipTypeCd")
    public void setEquipTypeCd(String equipTypeCd) {
        this.equipTypeCd = equipTypeCd;
    }

    public JobEquipmentList withEquipTypeCd(String equipTypeCd) {
        this.equipTypeCd = equipTypeCd;
        return this;
    }

    @JsonProperty("EquipCategoryCd")
    public String getEquipCategoryCd() {
        return equipCategoryCd;
    }

    @JsonProperty("EquipCategoryCd")
    public void setEquipCategoryCd(String equipCategoryCd) {
        this.equipCategoryCd = equipCategoryCd;
    }

    public JobEquipmentList withEquipCategoryCd(String equipCategoryCd) {
        this.equipCategoryCd = equipCategoryCd;
        return this;
    }

    @JsonProperty("DeviceAddress")
    public Object getDeviceAddress() {
        return deviceAddress;
    }

    @JsonProperty("DeviceAddress")
    public void setDeviceAddress(Object deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public JobEquipmentList withDeviceAddress(Object deviceAddress) {
        this.deviceAddress = deviceAddress;
        return this;
    }

    @JsonProperty("EquipModelCd")
    public Object getEquipModelCd() {
        return equipModelCd;
    }

    @JsonProperty("EquipModelCd")
    public void setEquipModelCd(Object equipModelCd) {
        this.equipModelCd = equipModelCd;
    }

    public JobEquipmentList withEquipModelCd(Object equipModelCd) {
        this.equipModelCd = equipModelCd;
        return this;
    }

    @JsonProperty("DeviceAddress2")
    public Object getDeviceAddress2() {
        return deviceAddress2;
    }

    @JsonProperty("DeviceAddress2")
    public void setDeviceAddress2(Object deviceAddress2) {
        this.deviceAddress2 = deviceAddress2;
    }

    public JobEquipmentList withDeviceAddress2(Object deviceAddress2) {
        this.deviceAddress2 = deviceAddress2;
        return this;
    }

    @JsonProperty("SecurityDataId")
    public Object getSecurityDataId() {
        return securityDataId;
    }

    @JsonProperty("SecurityDataId")
    public void setSecurityDataId(Object securityDataId) {
        this.securityDataId = securityDataId;
    }

    public JobEquipmentList withSecurityDataId(Object securityDataId) {
        this.securityDataId = securityDataId;
        return this;
    }

    @JsonProperty("ComponentCd")
    public String getComponentCd() {
        return componentCd;
    }

    @JsonProperty("ComponentCd")
    public void setComponentCd(String componentCd) {
        this.componentCd = componentCd;
    }

    public JobEquipmentList withComponentCd(String componentCd) {
        this.componentCd = componentCd;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(assocDeviceComponent).append(equipMake).append(assocDeviceSerialNum).append(serialNum).append(subType).append(usageReturnPath).append(equipStatusCd).append(ownerCd).append(hostId).append(assocDeviceType).append(equipTypeCd).append(equipCategoryCd).append(deviceAddress).append(equipModelCd).append(deviceAddress2).append(securityDataId).append(componentCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobEquipmentList) == false) {
            return false;
        }
        JobEquipmentList rhs = ((JobEquipmentList) other);
        return new EqualsBuilder().append(assocDeviceComponent, rhs.assocDeviceComponent).append(equipMake, rhs.equipMake).append(assocDeviceSerialNum, rhs.assocDeviceSerialNum).append(serialNum, rhs.serialNum).append(subType, rhs.subType).append(usageReturnPath, rhs.usageReturnPath).append(equipStatusCd, rhs.equipStatusCd).append(ownerCd, rhs.ownerCd).append(hostId, rhs.hostId).append(assocDeviceType, rhs.assocDeviceType).append(equipTypeCd, rhs.equipTypeCd).append(equipCategoryCd, rhs.equipCategoryCd).append(deviceAddress, rhs.deviceAddress).append(equipModelCd, rhs.equipModelCd).append(deviceAddress2, rhs.deviceAddress2).append(securityDataId, rhs.securityDataId).append(componentCd, rhs.componentCd).isEquals();
    }

}
