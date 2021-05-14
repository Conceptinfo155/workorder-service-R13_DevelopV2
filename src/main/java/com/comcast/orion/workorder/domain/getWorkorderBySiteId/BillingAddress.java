
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

import javax.validation.constraints.NotNull;
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
    "ZipCode",
    "AddrLine2",
    "City",
    "AddrLine1",
    "State"
})
public class BillingAddress {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String zipCode;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object addrLine2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String city;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String addrLine1;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @NotNull
    private String state;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BillingAddress withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    public Object getAddrLine2() {
        return addrLine2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    public void setAddrLine2(Object addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public BillingAddress withAddrLine2(Object addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public BillingAddress withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public BillingAddress withAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    public String getState() {
        return state;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    public BillingAddress withState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(zipCode).append(addrLine2).append(city).append(addrLine1).append(state).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BillingAddress) == false) {
            return false;
        }
        BillingAddress rhs = ((BillingAddress) other);
        return new EqualsBuilder().append(zipCode, rhs.zipCode).append(addrLine2, rhs.addrLine2).append(city, rhs.city).append(addrLine1, rhs.addrLine1).append(state, rhs.state).isEquals();
    }

}
