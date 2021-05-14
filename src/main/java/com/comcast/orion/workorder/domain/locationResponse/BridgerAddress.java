
package com.comcast.orion.workorder.domain.locationResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bridgerBidirectional",
    "bridgerGateControl",
    "bridgerPrivate"
})
public class BridgerAddress {

    @JsonProperty("bridgerBidirectional")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bridgerBidirectional;
    @JsonProperty("bridgerGateControl")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bridgerGateControl;
    @JsonProperty("bridgerPrivate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bridgerPrivate;

    @JsonProperty("bridgerBidirectional")
    public String getBridgerBidirectional() {
        return bridgerBidirectional;
    }

    @JsonProperty("bridgerBidirectional")
    public void setBridgerBidirectional(String bridgerBidirectional) {
        this.bridgerBidirectional = bridgerBidirectional;
    }

    public BridgerAddress withBridgerBidirectional(String bridgerBidirectional) {
        this.bridgerBidirectional = bridgerBidirectional;
        return this;
    }

    @JsonProperty("bridgerGateControl")
    public String getBridgerGateControl() {
        return bridgerGateControl;
    }

    @JsonProperty("bridgerGateControl")
    public void setBridgerGateControl(String bridgerGateControl) {
        this.bridgerGateControl = bridgerGateControl;
    }

    public BridgerAddress withBridgerGateControl(String bridgerGateControl) {
        this.bridgerGateControl = bridgerGateControl;
        return this;
    }

    @JsonProperty("bridgerPrivate")
    public String getBridgerPrivate() {
        return bridgerPrivate;
    }

    @JsonProperty("bridgerPrivate")
    public void setBridgerPrivate(String bridgerPrivate) {
        this.bridgerPrivate = bridgerPrivate;
    }

    public BridgerAddress withBridgerPrivate(String bridgerPrivate) {
        this.bridgerPrivate = bridgerPrivate;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bridgerBidirectional).append(bridgerGateControl).append(bridgerPrivate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BridgerAddress) == false) {
            return false;
        }
        BridgerAddress rhs = ((BridgerAddress) other);
        return new EqualsBuilder().append(bridgerBidirectional, rhs.bridgerBidirectional).append(bridgerGateControl, rhs.bridgerGateControl).append(bridgerPrivate, rhs.bridgerPrivate).isEquals();
    }

}
