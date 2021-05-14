
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

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
    "addrLine1",
    "addrLine2",
    "city",
    "state",
    "zipCode"
})
public class Address {

    /**
     * address line 1
     * 
     */
    @JsonProperty("addrLine1")
    @JsonPropertyDescription("address line 1")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "address line 1", example = "1354 E Boot Road")
    private String addrLine1;
    /**
     * Address Line 2
     * 
     */
    @JsonProperty("addrLine2")
    @JsonPropertyDescription("Address Line 2")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Address Line 2", example = "WEST")
    private String addrLine2;
    /**
     * City
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("City")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "City", example = "WEST CHESTER")
    private String city;
    /**
     * State
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("State")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "State", example = "PA")
    private String state;
    /**
     * Zip Code
     * 
     */
    @JsonProperty("zipCode")
    @JsonPropertyDescription("Zip Code")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Zip Code", example = "19380")
    private String zipCode;

    /**
     * address line 1
     * 
     */
    @JsonProperty("addrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    /**
     * address line 1
     * 
     */
    @JsonProperty("addrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public Address withAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    /**
     * Address Line 2
     * 
     */
    @JsonProperty("addrLine2")
    public String getAddrLine2() {
        return addrLine2;
    }

    /**
     * Address Line 2
     * 
     */
    @JsonProperty("addrLine2")
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public Address withAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    /**
     * City
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * City
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * State
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * State
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Zip Code
     * 
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Zip Code
     * 
     */
    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addrLine1).append(addrLine2).append(city).append(state).append(zipCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(addrLine1, rhs.addrLine1).append(addrLine2, rhs.addrLine2).append(city, rhs.city).append(state, rhs.state).append(zipCode, rhs.zipCode).isEquals();
    }

}
