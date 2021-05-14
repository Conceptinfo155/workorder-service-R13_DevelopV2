
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
    "connectivityUNQID",
    "connectivityName",
    "connectivityType",
    "connectivityDIMObject",
    "aendDeviceUNQID",
    "aendPortUNQID",
    "zendDeviceUNQID",
    "zendPortUNQID",
    "serviceUNQID"
})
public class ConnectivityDetail {

    /**
     * The connectivityUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String connectivityUNQID = "0";
    /**
     * The connectivityName Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String connectivityName = "";
    /**
     * The connectivityType Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String connectivityType = "";
    /**
     * The connectivityDIMObject Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityDIMObject")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String connectivityDIMObject = "";
    /**
     * The aendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendDeviceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String aendDeviceUNQID = "";
    /**
     * The aendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendPortUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String aendPortUNQID = "";
    /**
     * The zendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendDeviceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zendDeviceUNQID = "";
    /**
     * The zendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendPortUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zendPortUNQID = "0";
    /**
     * The serviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("serviceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceUNQID = "0";

    /**
     * The connectivityUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityUNQID")
    public String getConnectivityUNQID() {
        return connectivityUNQID;
    }

    /**
     * The connectivityUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityUNQID")
    public void setConnectivityUNQID(String connectivityUNQID) {
        this.connectivityUNQID = connectivityUNQID;
    }

    public ConnectivityDetail withConnectivityUNQID(String connectivityUNQID) {
        this.connectivityUNQID = connectivityUNQID;
        return this;
    }

    /**
     * The connectivityName Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityName")
    public String getConnectivityName() {
        return connectivityName;
    }

    /**
     * The connectivityName Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityName")
    public void setConnectivityName(String connectivityName) {
        this.connectivityName = connectivityName;
    }

    public ConnectivityDetail withConnectivityName(String connectivityName) {
        this.connectivityName = connectivityName;
        return this;
    }

    /**
     * The connectivityType Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityType")
    public String getConnectivityType() {
        return connectivityType;
    }

    /**
     * The connectivityType Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityType")
    public void setConnectivityType(String connectivityType) {
        this.connectivityType = connectivityType;
    }

    public ConnectivityDetail withConnectivityType(String connectivityType) {
        this.connectivityType = connectivityType;
        return this;
    }

    /**
     * The connectivityDIMObject Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityDIMObject")
    public String getConnectivityDIMObject() {
        return connectivityDIMObject;
    }

    /**
     * The connectivityDIMObject Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("connectivityDIMObject")
    public void setConnectivityDIMObject(String connectivityDIMObject) {
        this.connectivityDIMObject = connectivityDIMObject;
    }

    public ConnectivityDetail withConnectivityDIMObject(String connectivityDIMObject) {
        this.connectivityDIMObject = connectivityDIMObject;
        return this;
    }

    /**
     * The aendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendDeviceUNQID")
    public String getAendDeviceUNQID() {
        return aendDeviceUNQID;
    }

    /**
     * The aendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendDeviceUNQID")
    public void setAendDeviceUNQID(String aendDeviceUNQID) {
        this.aendDeviceUNQID = aendDeviceUNQID;
    }

    public ConnectivityDetail withAendDeviceUNQID(String aendDeviceUNQID) {
        this.aendDeviceUNQID = aendDeviceUNQID;
        return this;
    }

    /**
     * The aendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendPortUNQID")
    public String getAendPortUNQID() {
        return aendPortUNQID;
    }

    /**
     * The aendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("aendPortUNQID")
    public void setAendPortUNQID(String aendPortUNQID) {
        this.aendPortUNQID = aendPortUNQID;
    }

    public ConnectivityDetail withAendPortUNQID(String aendPortUNQID) {
        this.aendPortUNQID = aendPortUNQID;
        return this;
    }

    /**
     * The zendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendDeviceUNQID")
    public String getZendDeviceUNQID() {
        return zendDeviceUNQID;
    }

    /**
     * The zendDeviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendDeviceUNQID")
    public void setZendDeviceUNQID(String zendDeviceUNQID) {
        this.zendDeviceUNQID = zendDeviceUNQID;
    }

    public ConnectivityDetail withZendDeviceUNQID(String zendDeviceUNQID) {
        this.zendDeviceUNQID = zendDeviceUNQID;
        return this;
    }

    /**
     * The zendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendPortUNQID")
    public String getZendPortUNQID() {
        return zendPortUNQID;
    }

    /**
     * The zendPortUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("zendPortUNQID")
    public void setZendPortUNQID(String zendPortUNQID) {
        this.zendPortUNQID = zendPortUNQID;
    }

    public ConnectivityDetail withZendPortUNQID(String zendPortUNQID) {
        this.zendPortUNQID = zendPortUNQID;
        return this;
    }

    /**
     * The serviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("serviceUNQID")
    public String getServiceUNQID() {
        return serviceUNQID;
    }

    /**
     * The serviceUNQID Schema 
     * <p>
     * 
     * 
     */
    @JsonProperty("serviceUNQID")
    public void setServiceUNQID(String serviceUNQID) {
        this.serviceUNQID = serviceUNQID;
    }

    public ConnectivityDetail withServiceUNQID(String serviceUNQID) {
        this.serviceUNQID = serviceUNQID;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(connectivityUNQID).append(connectivityName).append(connectivityType).append(connectivityDIMObject).append(aendDeviceUNQID).append(aendPortUNQID).append(zendDeviceUNQID).append(zendPortUNQID).append(serviceUNQID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConnectivityDetail) == false) {
            return false;
        }
        ConnectivityDetail rhs = ((ConnectivityDetail) other);
        return new EqualsBuilder().append(connectivityUNQID, rhs.connectivityUNQID).append(connectivityName, rhs.connectivityName).append(connectivityType, rhs.connectivityType).append(connectivityDIMObject, rhs.connectivityDIMObject).append(aendDeviceUNQID, rhs.aendDeviceUNQID).append(aendPortUNQID, rhs.aendPortUNQID).append(zendDeviceUNQID, rhs.zendDeviceUNQID).append(zendPortUNQID, rhs.zendPortUNQID).append(serviceUNQID, rhs.serviceUNQID).isEquals();
    }

}
