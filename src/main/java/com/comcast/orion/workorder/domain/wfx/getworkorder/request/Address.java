
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The Address Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "AddrLine1",
    "ZipCode",
    "AddrId",
    "State",
    "City",
    "AddrLine2"
})
public class Address {

    /**
     * The Addrline1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String addrLine1 = "";
    /**
     * The Zipcode Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String zipCode = "";
    /**
     * The Addrid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String addrId = "";
    /**
     * The State Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String state = "";
    /**
     * The City Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String city = "";
    /**
     * The Addrline2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String addrLine2 = "";

    /**
     * The Addrline1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    /**
     * The Addrline1 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public Address withAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    /**
     * The Zipcode Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * The Zipcode Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    /**
     * The Addrid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrId")
    public String getAddrId() {
        return addrId;
    }

    /**
     * The Addrid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrId")
    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public Address withAddrId(String addrId) {
        this.addrId = addrId;
        return this;
    }

    /**
     * The State Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    public String getState() {
        return state;
    }

    /**
     * The State Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * The City Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    /**
     * The City Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * The Addrline2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    public String getAddrLine2() {
        return addrLine2;
    }

    /**
     * The Addrline2 Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AddrLine2")
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public Address withAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addrLine1).append(zipCode).append(addrId).append(state).append(city).append(addrLine2).toHashCode();
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
        return new EqualsBuilder().append(addrLine1, rhs.addrLine1).append(zipCode, rhs.zipCode).append(addrId, rhs.addrId).append(state, rhs.state).append(city, rhs.city).append(addrLine2, rhs.addrLine2).isEquals();
    }

}
