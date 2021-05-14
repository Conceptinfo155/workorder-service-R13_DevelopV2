
package com.comcast.orion.workorder.domain.product.response;

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
    "deviceName",
    "ownedBy",
    "serialNumber",
    "isWifiDevice",
    "deviceFQDN",
    "deviceCLLI",
    "deviceIP",
    "macAddress",
    "deviceOperationalRole",
    "deviceType",
    "make",
    "model",
    "deviceManufacturer",
    "deviceMarket",
    "serviceID",
    "status",
    "deviceFunctionalStatus",
    "siteUNQID",
    "portUNQID",
    "deviceAction",
    "characteristics"
})
public class Device {

    @JsonProperty("deviceName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceName;
    @JsonProperty("ownedBy")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ownedBy;
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serialNumber;
    @JsonProperty("isWifiDevice")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String isWifiDevice;
    @JsonProperty("deviceFQDN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceFQDN;
    @JsonProperty("deviceCLLI")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceCLLI;
    @JsonProperty("deviceIP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceIP;
    @JsonProperty("macAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String macAddress;
    @JsonProperty("deviceOperationalRole")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceOperationalRole;
    @JsonProperty("deviceType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceType;
    @JsonProperty("make")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String make;
    @JsonProperty("model")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String model;
    @JsonProperty("deviceManufacturer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceManufacturer;
    @JsonProperty("deviceMarket")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceMarket;
    @JsonProperty("serviceID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceID;
    @JsonProperty("status")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String status;
    @JsonProperty("deviceFunctionalStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceFunctionalStatus;
    @JsonProperty("siteUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteUNQID;
    @JsonProperty("portUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String portUNQID;
    @JsonProperty("deviceAction")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceAction;
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic> characteristics = new ArrayList<Characteristic>();

    @JsonProperty("deviceName")
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("deviceName")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Device withDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public Device withOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
        return this;
    }

    @JsonProperty("serialNumber")
    public String getSerialNumber() {
        return serialNumber;
    }

    @JsonProperty("serialNumber")
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Device withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    @JsonProperty("isWifiDevice")
    public String getIsWifiDevice() {
        return isWifiDevice;
    }

    @JsonProperty("isWifiDevice")
    public void setIsWifiDevice(String isWifiDevice) {
        this.isWifiDevice = isWifiDevice;
    }

    public Device withIsWifiDevice(String isWifiDevice) {
        this.isWifiDevice = isWifiDevice;
        return this;
    }

    @JsonProperty("deviceFQDN")
    public String getDeviceFQDN() {
        return deviceFQDN;
    }

    @JsonProperty("deviceFQDN")
    public void setDeviceFQDN(String deviceFQDN) {
        this.deviceFQDN = deviceFQDN;
    }

    public Device withDeviceFQDN(String deviceFQDN) {
        this.deviceFQDN = deviceFQDN;
        return this;
    }

    @JsonProperty("deviceCLLI")
    public String getDeviceCLLI() {
        return deviceCLLI;
    }

    @JsonProperty("deviceCLLI")
    public void setDeviceCLLI(String deviceCLLI) {
        this.deviceCLLI = deviceCLLI;
    }

    public Device withDeviceCLLI(String deviceCLLI) {
        this.deviceCLLI = deviceCLLI;
        return this;
    }

    @JsonProperty("deviceIP")
    public String getDeviceIP() {
        return deviceIP;
    }

    @JsonProperty("deviceIP")
    public void setDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
    }

    public Device withDeviceIP(String deviceIP) {
        this.deviceIP = deviceIP;
        return this;
    }

    @JsonProperty("macAddress")
    public String getMacAddress() {
        return macAddress;
    }

    @JsonProperty("macAddress")
    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Device withMacAddress(String macAddress) {
        this.macAddress = macAddress;
        return this;
    }

    @JsonProperty("deviceOperationalRole")
    public String getDeviceOperationalRole() {
        return deviceOperationalRole;
    }

    @JsonProperty("deviceOperationalRole")
    public void setDeviceOperationalRole(String deviceOperationalRole) {
        this.deviceOperationalRole = deviceOperationalRole;
    }

    public Device withDeviceOperationalRole(String deviceOperationalRole) {
        this.deviceOperationalRole = deviceOperationalRole;
        return this;
    }

    @JsonProperty("deviceType")
    public String getDeviceType() {
        return deviceType;
    }

    @JsonProperty("deviceType")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Device withDeviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    @JsonProperty("make")
    public String getMake() {
        return make;
    }

    @JsonProperty("make")
    public void setMake(String make) {
        this.make = make;
    }

    public Device withMake(String make) {
        this.make = make;
        return this;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    public Device withModel(String model) {
        this.model = model;
        return this;
    }

    @JsonProperty("deviceManufacturer")
    public String getDeviceManufacturer() {
        return deviceManufacturer;
    }

    @JsonProperty("deviceManufacturer")
    public void setDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
    }

    public Device withDeviceManufacturer(String deviceManufacturer) {
        this.deviceManufacturer = deviceManufacturer;
        return this;
    }

    @JsonProperty("deviceMarket")
    public String getDeviceMarket() {
        return deviceMarket;
    }

    @JsonProperty("deviceMarket")
    public void setDeviceMarket(String deviceMarket) {
        this.deviceMarket = deviceMarket;
    }

    public Device withDeviceMarket(String deviceMarket) {
        this.deviceMarket = deviceMarket;
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

    public Device withServiceID(String serviceID) {
        this.serviceID = serviceID;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Device withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("deviceFunctionalStatus")
    public String getDeviceFunctionalStatus() {
        return deviceFunctionalStatus;
    }

    @JsonProperty("deviceFunctionalStatus")
    public void setDeviceFunctionalStatus(String deviceFunctionalStatus) {
        this.deviceFunctionalStatus = deviceFunctionalStatus;
    }

    public Device withDeviceFunctionalStatus(String deviceFunctionalStatus) {
        this.deviceFunctionalStatus = deviceFunctionalStatus;
        return this;
    }

    @JsonProperty("siteUNQID")
    public String getSiteUNQID() {
        return siteUNQID;
    }

    @JsonProperty("siteUNQID")
    public void setSiteUNQID(String siteUNQID) {
        this.siteUNQID = siteUNQID;
    }

    public Device withSiteUNQID(String siteUNQID) {
        this.siteUNQID = siteUNQID;
        return this;
    }

    @JsonProperty("portUNQID")
    public String getPortUNQID() {
        return portUNQID;
    }

    @JsonProperty("portUNQID")
    public void setPortUNQID(String portUNQID) {
        this.portUNQID = portUNQID;
    }

    public Device withPortUNQID(String portUNQID) {
        this.portUNQID = portUNQID;
        return this;
    }

    @JsonProperty("deviceAction")
    public String getDeviceAction() {
        return deviceAction;
    }

    @JsonProperty("deviceAction")
    public void setDeviceAction(String deviceAction) {
        this.deviceAction = deviceAction;
    }

    public Device withDeviceAction(String deviceAction) {
        this.deviceAction = deviceAction;
        return this;
    }

    @JsonProperty("characteristics")
    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("characteristics")
    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Device withCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceName).append(ownedBy).append(serialNumber).append(isWifiDevice).append(deviceFQDN).append(deviceCLLI).append(deviceIP).append(macAddress).append(deviceOperationalRole).append(deviceType).append(make).append(model).append(deviceManufacturer).append(deviceMarket).append(serviceID).append(status).append(deviceFunctionalStatus).append(siteUNQID).append(portUNQID).append(deviceAction).append(characteristics).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Device) == false) {
            return false;
        }
        Device rhs = ((Device) other);
        return new EqualsBuilder().append(deviceName, rhs.deviceName).append(ownedBy, rhs.ownedBy).append(serialNumber, rhs.serialNumber).append(isWifiDevice, rhs.isWifiDevice).append(deviceFQDN, rhs.deviceFQDN).append(deviceCLLI, rhs.deviceCLLI).append(deviceIP, rhs.deviceIP).append(macAddress, rhs.macAddress).append(deviceOperationalRole, rhs.deviceOperationalRole).append(deviceType, rhs.deviceType).append(make, rhs.make).append(model, rhs.model).append(deviceManufacturer, rhs.deviceManufacturer).append(deviceMarket, rhs.deviceMarket).append(serviceID, rhs.serviceID).append(status, rhs.status).append(deviceFunctionalStatus, rhs.deviceFunctionalStatus).append(siteUNQID, rhs.siteUNQID).append(portUNQID, rhs.portUNQID).append(deviceAction, rhs.deviceAction).append(characteristics, rhs.characteristics).isEquals();
    }

}
