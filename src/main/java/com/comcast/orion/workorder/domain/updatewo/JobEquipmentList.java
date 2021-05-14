
package com.comcast.orion.workorder.domain.updatewo;

import javax.validation.constraints.Size;
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
    "serialNum",
    "equipTypeCd",
    "equipStatusCd",
    "ownerCd",
    "actionCd",
    "equipMake",
    "equipModelCd",
    "deviceAddress",
    "deviceAddress2"
})
public class JobEquipmentList {

    /**
     * Serial Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("serialNum")
    @JsonPropertyDescription("Serial Number passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Serial Number passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 25)
    private String serialNum;
    /**
     * Equipment Type Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipTypeCd")
    @JsonPropertyDescription("Equipment Type Code passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Equipment Type Code passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 5)
    private String equipTypeCd;
    /**
     * Equipment Status Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipStatusCd")
    @JsonPropertyDescription("Equipment Status Code passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Equipment Status Code passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 1)
    private String equipStatusCd;
    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("ownerCd")
    @JsonPropertyDescription("Owner Code passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Owner Code passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 1)
    private String ownerCd;
    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    @JsonPropertyDescription("Owner Code passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Owner Code passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 8)
    private String actionCd;
    /**
     * Equipment Make passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipMake")
    @JsonPropertyDescription("Equipment Make passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Equipment Make passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 25)
    private String equipMake;
    /**
     * Equipment Model Code by Amdocs - WFX
     * 
     */
    @JsonProperty("equipModelCd")
    @JsonPropertyDescription("Equipment Model Code by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Equipment Model Code by Amdocs - WFX", example = "")
    @Size(min = 0, max = 30)
    private String equipModelCd;
    /**
     * Device Address passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress")
    @JsonPropertyDescription("Device Address passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Device Address passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 20)
    private String deviceAddress;
    /**
     * Device Address2 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress2")
    @JsonPropertyDescription("Device Address2 passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Device Address2 passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 20)
    private String deviceAddress2;

    /**
     * Serial Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("serialNum")
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * Serial Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("serialNum")
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public JobEquipmentList withSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    /**
     * Equipment Type Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipTypeCd")
    public String getEquipTypeCd() {
        return equipTypeCd;
    }

    /**
     * Equipment Type Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipTypeCd")
    public void setEquipTypeCd(String equipTypeCd) {
        this.equipTypeCd = equipTypeCd;
    }

    public JobEquipmentList withEquipTypeCd(String equipTypeCd) {
        this.equipTypeCd = equipTypeCd;
        return this;
    }

    /**
     * Equipment Status Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipStatusCd")
    public String getEquipStatusCd() {
        return equipStatusCd;
    }

    /**
     * Equipment Status Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipStatusCd")
    public void setEquipStatusCd(String equipStatusCd) {
        this.equipStatusCd = equipStatusCd;
    }

    public JobEquipmentList withEquipStatusCd(String equipStatusCd) {
        this.equipStatusCd = equipStatusCd;
        return this;
    }

    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("ownerCd")
    public String getOwnerCd() {
        return ownerCd;
    }

    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("ownerCd")
    public void setOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
    }

    public JobEquipmentList withOwnerCd(String ownerCd) {
        this.ownerCd = ownerCd;
        return this;
    }

    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    public String getActionCd() {
        return actionCd;
    }

    /**
     * Owner Code passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
    }

    public JobEquipmentList withActionCd(String actionCd) {
        this.actionCd = actionCd;
        return this;
    }

    /**
     * Equipment Make passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipMake")
    public String getEquipMake() {
        return equipMake;
    }

    /**
     * Equipment Make passed by Amdocs - WFX
     * 
     */
    @JsonProperty("equipMake")
    public void setEquipMake(String equipMake) {
        this.equipMake = equipMake;
    }

    public JobEquipmentList withEquipMake(String equipMake) {
        this.equipMake = equipMake;
        return this;
    }

    /**
     * Equipment Model Code by Amdocs - WFX
     * 
     */
    @JsonProperty("equipModelCd")
    public String getEquipModelCd() {
        return equipModelCd;
    }

    /**
     * Equipment Model Code by Amdocs - WFX
     * 
     */
    @JsonProperty("equipModelCd")
    public void setEquipModelCd(String equipModelCd) {
        this.equipModelCd = equipModelCd;
    }

    public JobEquipmentList withEquipModelCd(String equipModelCd) {
        this.equipModelCd = equipModelCd;
        return this;
    }

    /**
     * Device Address passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress")
    public String getDeviceAddress() {
        return deviceAddress;
    }

    /**
     * Device Address passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress")
    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public JobEquipmentList withDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
        return this;
    }

    /**
     * Device Address2 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress2")
    public String getDeviceAddress2() {
        return deviceAddress2;
    }

    /**
     * Device Address2 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("deviceAddress2")
    public void setDeviceAddress2(String deviceAddress2) {
        this.deviceAddress2 = deviceAddress2;
    }

    public JobEquipmentList withDeviceAddress2(String deviceAddress2) {
        this.deviceAddress2 = deviceAddress2;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serialNum).append(equipTypeCd).append(equipStatusCd).append(ownerCd).append(actionCd).append(equipMake).append(equipModelCd).append(deviceAddress).append(deviceAddress2).toHashCode();
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
        return new EqualsBuilder().append(serialNum, rhs.serialNum).append(equipTypeCd, rhs.equipTypeCd).append(equipStatusCd, rhs.equipStatusCd).append(ownerCd, rhs.ownerCd).append(actionCd, rhs.actionCd).append(equipMake, rhs.equipMake).append(equipModelCd, rhs.equipModelCd).append(deviceAddress, rhs.deviceAddress).append(deviceAddress2, rhs.deviceAddress2).isEquals();
    }

}
