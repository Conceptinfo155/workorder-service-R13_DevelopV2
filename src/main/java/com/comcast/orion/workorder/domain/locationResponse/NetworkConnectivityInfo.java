
package com.comcast.orion.workorder.domain.locationResponse;

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
    "CMTS_FQDN",
    "CRAN",
    "dropLocation",
    "fiberNodeName",
    "headendID",
    "headendNetworkAddress",
    "headendType"
})
public class NetworkConnectivityInfo {

    @JsonProperty("CMTS_FQDN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cMTSFQDN;
    @JsonProperty("CRAN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cRAN;
    @JsonProperty("dropLocation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String dropLocation;
    @JsonProperty("fiberNodeName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String fiberNodeName;
    @JsonProperty("headendID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headendID;
    @JsonProperty("headendNetworkAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headendNetworkAddress;
    @JsonProperty("headendType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headendType;

    @JsonProperty("CMTS_FQDN")
    public String getCMTSFQDN() {
        return cMTSFQDN;
    }

    @JsonProperty("CMTS_FQDN")
    public void setCMTSFQDN(String cMTSFQDN) {
        this.cMTSFQDN = cMTSFQDN;
    }

    public NetworkConnectivityInfo withCMTSFQDN(String cMTSFQDN) {
        this.cMTSFQDN = cMTSFQDN;
        return this;
    }

    @JsonProperty("CRAN")
    public String getCRAN() {
        return cRAN;
    }

    @JsonProperty("CRAN")
    public void setCRAN(String cRAN) {
        this.cRAN = cRAN;
    }

    public NetworkConnectivityInfo withCRAN(String cRAN) {
        this.cRAN = cRAN;
        return this;
    }

    @JsonProperty("dropLocation")
    public String getDropLocation() {
        return dropLocation;
    }

    @JsonProperty("dropLocation")
    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public NetworkConnectivityInfo withDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
        return this;
    }

    @JsonProperty("fiberNodeName")
    public String getFiberNodeName() {
        return fiberNodeName;
    }

    @JsonProperty("fiberNodeName")
    public void setFiberNodeName(String fiberNodeName) {
        this.fiberNodeName = fiberNodeName;
    }

    public NetworkConnectivityInfo withFiberNodeName(String fiberNodeName) {
        this.fiberNodeName = fiberNodeName;
        return this;
    }

    @JsonProperty("headendID")
    public String getHeadendID() {
        return headendID;
    }

    @JsonProperty("headendID")
    public void setHeadendID(String headendID) {
        this.headendID = headendID;
    }

    public NetworkConnectivityInfo withHeadendID(String headendID) {
        this.headendID = headendID;
        return this;
    }

    @JsonProperty("headendNetworkAddress")
    public String getHeadendNetworkAddress() {
        return headendNetworkAddress;
    }

    @JsonProperty("headendNetworkAddress")
    public void setHeadendNetworkAddress(String headendNetworkAddress) {
        this.headendNetworkAddress = headendNetworkAddress;
    }

    public NetworkConnectivityInfo withHeadendNetworkAddress(String headendNetworkAddress) {
        this.headendNetworkAddress = headendNetworkAddress;
        return this;
    }

    @JsonProperty("headendType")
    public String getHeadendType() {
        return headendType;
    }

    @JsonProperty("headendType")
    public void setHeadendType(String headendType) {
        this.headendType = headendType;
    }

    public NetworkConnectivityInfo withHeadendType(String headendType) {
        this.headendType = headendType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cMTSFQDN).append(cRAN).append(dropLocation).append(fiberNodeName).append(headendID).append(headendNetworkAddress).append(headendType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NetworkConnectivityInfo) == false) {
            return false;
        }
        NetworkConnectivityInfo rhs = ((NetworkConnectivityInfo) other);
        return new EqualsBuilder().append(cMTSFQDN, rhs.cMTSFQDN).append(cRAN, rhs.cRAN).append(dropLocation, rhs.dropLocation).append(fiberNodeName, rhs.fiberNodeName).append(headendID, rhs.headendID).append(headendNetworkAddress, rhs.headendNetworkAddress).append(headendType, rhs.headendType).isEquals();
    }

}
