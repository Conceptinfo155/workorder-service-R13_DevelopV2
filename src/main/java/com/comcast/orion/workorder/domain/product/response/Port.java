
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
    "portUNQID",
    "name",
    "type",
    "bandwidth",
    "MEFNIType",
    "cardTypName",
    "cardName",
    "cardSerialNumber",
    "provisionStatus",
    "deviceUNQID",
    "ipBlockUNQID",
    "characteristics"
})
public class Port {

    @JsonProperty("portUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String portUNQID;
    @JsonProperty("name")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String name;
    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("bandwidth")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bandwidth;
    @JsonProperty("MEFNIType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String mEFNIType;
    @JsonProperty("cardTypName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cardTypName;
    @JsonProperty("cardName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cardName;
    @JsonProperty("cardSerialNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cardSerialNumber;
    @JsonProperty("provisionStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String provisionStatus;
    @JsonProperty("deviceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String deviceUNQID;
    @JsonProperty("ipBlockUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockUNQID;
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic> characteristics = new ArrayList<Characteristic>();

    @JsonProperty("portUNQID")
    public String getPortUNQID() {
        return portUNQID;
    }

    @JsonProperty("portUNQID")
    public void setPortUNQID(String portUNQID) {
        this.portUNQID = portUNQID;
    }

    public Port withPortUNQID(String portUNQID) {
        this.portUNQID = portUNQID;
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

    public Port withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Port withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("bandwidth")
    public String getBandwidth() {
        return bandwidth;
    }

    @JsonProperty("bandwidth")
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public Port withBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
        return this;
    }

    @JsonProperty("MEFNIType")
    public String getMEFNIType() {
        return mEFNIType;
    }

    @JsonProperty("MEFNIType")
    public void setMEFNIType(String mEFNIType) {
        this.mEFNIType = mEFNIType;
    }

    public Port withMEFNIType(String mEFNIType) {
        this.mEFNIType = mEFNIType;
        return this;
    }

    @JsonProperty("cardTypName")
    public String getCardTypName() {
        return cardTypName;
    }

    @JsonProperty("cardTypName")
    public void setCardTypName(String cardTypName) {
        this.cardTypName = cardTypName;
    }

    public Port withCardTypName(String cardTypName) {
        this.cardTypName = cardTypName;
        return this;
    }

    @JsonProperty("cardName")
    public String getCardName() {
        return cardName;
    }

    @JsonProperty("cardName")
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Port withCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    @JsonProperty("cardSerialNumber")
    public String getCardSerialNumber() {
        return cardSerialNumber;
    }

    @JsonProperty("cardSerialNumber")
    public void setCardSerialNumber(String cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
    }

    public Port withCardSerialNumber(String cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
        return this;
    }

    @JsonProperty("provisionStatus")
    public String getProvisionStatus() {
        return provisionStatus;
    }

    @JsonProperty("provisionStatus")
    public void setProvisionStatus(String provisionStatus) {
        this.provisionStatus = provisionStatus;
    }

    public Port withProvisionStatus(String provisionStatus) {
        this.provisionStatus = provisionStatus;
        return this;
    }

    @JsonProperty("deviceUNQID")
    public String getDeviceUNQID() {
        return deviceUNQID;
    }

    @JsonProperty("deviceUNQID")
    public void setDeviceUNQID(String deviceUNQID) {
        this.deviceUNQID = deviceUNQID;
    }

    public Port withDeviceUNQID(String deviceUNQID) {
        this.deviceUNQID = deviceUNQID;
        return this;
    }

    @JsonProperty("ipBlockUNQID")
    public String getIpBlockUNQID() {
        return ipBlockUNQID;
    }

    @JsonProperty("ipBlockUNQID")
    public void setIpBlockUNQID(String ipBlockUNQID) {
        this.ipBlockUNQID = ipBlockUNQID;
    }

    public Port withIpBlockUNQID(String ipBlockUNQID) {
        this.ipBlockUNQID = ipBlockUNQID;
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

    public Port withCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(portUNQID).append(name).append(type).append(bandwidth).append(mEFNIType).append(cardTypName).append(cardName).append(cardSerialNumber).append(provisionStatus).append(deviceUNQID).append(ipBlockUNQID).append(characteristics).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Port) == false) {
            return false;
        }
        Port rhs = ((Port) other);
        return new EqualsBuilder().append(portUNQID, rhs.portUNQID).append(name, rhs.name).append(type, rhs.type).append(bandwidth, rhs.bandwidth).append(mEFNIType, rhs.mEFNIType).append(cardTypName, rhs.cardTypName).append(cardName, rhs.cardName).append(cardSerialNumber, rhs.cardSerialNumber).append(provisionStatus, rhs.provisionStatus).append(deviceUNQID, rhs.deviceUNQID).append(ipBlockUNQID, rhs.ipBlockUNQID).append(characteristics, rhs.characteristics).isEquals();
    }

}
