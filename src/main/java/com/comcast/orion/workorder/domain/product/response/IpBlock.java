
package com.comcast.orion.workorder.domain.product.response;

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
    "ipBlockUNQID",
    "ipBlockVersion",
    "ipBlockType",
    "ipBlockSize",
    "ipBlockUsableRange",
    "ipBlockSubnetMask",
    "ipBlockGatewayIP",
    "serviceUNQID",
    "portUNQID"
})
public class IpBlock {

    @JsonProperty("ipBlockUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockUNQID;
    @JsonProperty("ipBlockVersion")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockVersion;
    @JsonProperty("ipBlockType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockType;
    @JsonProperty("ipBlockSize")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockSize;
    @JsonProperty("ipBlockUsableRange")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockUsableRange;
    @JsonProperty("ipBlockSubnetMask")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockSubnetMask;
    @JsonProperty("ipBlockGatewayIP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ipBlockGatewayIP;
    @JsonProperty("serviceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceUNQID;
    @JsonProperty("portUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String portUNQID;

    @JsonProperty("ipBlockUNQID")
    public String getIpBlockUNQID() {
        return ipBlockUNQID;
    }

    @JsonProperty("ipBlockUNQID")
    public void setIpBlockUNQID(String ipBlockUNQID) {
        this.ipBlockUNQID = ipBlockUNQID;
    }

    public IpBlock withIpBlockUNQID(String ipBlockUNQID) {
        this.ipBlockUNQID = ipBlockUNQID;
        return this;
    }

    @JsonProperty("ipBlockVersion")
    public String getIpBlockVersion() {
        return ipBlockVersion;
    }

    @JsonProperty("ipBlockVersion")
    public void setIpBlockVersion(String ipBlockVersion) {
        this.ipBlockVersion = ipBlockVersion;
    }

    public IpBlock withIpBlockVersion(String ipBlockVersion) {
        this.ipBlockVersion = ipBlockVersion;
        return this;
    }

    @JsonProperty("ipBlockType")
    public String getIpBlockType() {
        return ipBlockType;
    }

    @JsonProperty("ipBlockType")
    public void setIpBlockType(String ipBlockType) {
        this.ipBlockType = ipBlockType;
    }

    public IpBlock withIpBlockType(String ipBlockType) {
        this.ipBlockType = ipBlockType;
        return this;
    }

    @JsonProperty("ipBlockSize")
    public String getIpBlockSize() {
        return ipBlockSize;
    }

    @JsonProperty("ipBlockSize")
    public void setIpBlockSize(String ipBlockSize) {
        this.ipBlockSize = ipBlockSize;
    }

    public IpBlock withIpBlockSize(String ipBlockSize) {
        this.ipBlockSize = ipBlockSize;
        return this;
    }

    @JsonProperty("ipBlockUsableRange")
    public String getIpBlockUsableRange() {
        return ipBlockUsableRange;
    }

    @JsonProperty("ipBlockUsableRange")
    public void setIpBlockUsableRange(String ipBlockUsableRange) {
        this.ipBlockUsableRange = ipBlockUsableRange;
    }

    public IpBlock withIpBlockUsableRange(String ipBlockUsableRange) {
        this.ipBlockUsableRange = ipBlockUsableRange;
        return this;
    }

    @JsonProperty("ipBlockSubnetMask")
    public String getIpBlockSubnetMask() {
        return ipBlockSubnetMask;
    }

    @JsonProperty("ipBlockSubnetMask")
    public void setIpBlockSubnetMask(String ipBlockSubnetMask) {
        this.ipBlockSubnetMask = ipBlockSubnetMask;
    }

    public IpBlock withIpBlockSubnetMask(String ipBlockSubnetMask) {
        this.ipBlockSubnetMask = ipBlockSubnetMask;
        return this;
    }

    @JsonProperty("ipBlockGatewayIP")
    public String getIpBlockGatewayIP() {
        return ipBlockGatewayIP;
    }

    @JsonProperty("ipBlockGatewayIP")
    public void setIpBlockGatewayIP(String ipBlockGatewayIP) {
        this.ipBlockGatewayIP = ipBlockGatewayIP;
    }

    public IpBlock withIpBlockGatewayIP(String ipBlockGatewayIP) {
        this.ipBlockGatewayIP = ipBlockGatewayIP;
        return this;
    }

    @JsonProperty("serviceUNQID")
    public String getServiceUNQID() {
        return serviceUNQID;
    }

    @JsonProperty("serviceUNQID")
    public void setServiceUNQID(String serviceUNQID) {
        this.serviceUNQID = serviceUNQID;
    }

    public IpBlock withServiceUNQID(String serviceUNQID) {
        this.serviceUNQID = serviceUNQID;
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

    public IpBlock withPortUNQID(String portUNQID) {
        this.portUNQID = portUNQID;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ipBlockUNQID).append(ipBlockVersion).append(ipBlockType).append(ipBlockSize).append(ipBlockUsableRange).append(ipBlockSubnetMask).append(ipBlockGatewayIP).append(serviceUNQID).append(portUNQID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IpBlock) == false) {
            return false;
        }
        IpBlock rhs = ((IpBlock) other);
        return new EqualsBuilder().append(ipBlockUNQID, rhs.ipBlockUNQID).append(ipBlockVersion, rhs.ipBlockVersion).append(ipBlockType, rhs.ipBlockType).append(ipBlockSize, rhs.ipBlockSize).append(ipBlockUsableRange, rhs.ipBlockUsableRange).append(ipBlockSubnetMask, rhs.ipBlockSubnetMask).append(ipBlockGatewayIP, rhs.ipBlockGatewayIP).append(serviceUNQID, rhs.serviceUNQID).append(portUNQID, rhs.portUNQID).isEquals();
    }

}
