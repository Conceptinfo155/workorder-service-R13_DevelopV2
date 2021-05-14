
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "AddrId",
    "AddrLine2",
    "City",
    "AddrLine1",
    "State"
})
public class Address {

    @JsonProperty("ZipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zipCode;
    @JsonProperty("AddrId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addrId;
    @JsonProperty("AddrLine2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object addrLine2;
    @JsonProperty("City")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String city;
    @JsonProperty("AddrLine1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addrLine1;
    @JsonProperty("State")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;

    @JsonProperty("ZipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("ZipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @JsonProperty("AddrId")
    public String getAddrId() {
        return addrId;
    }

    @JsonProperty("AddrId")
    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public Address withAddrId(String addrId) {
        this.addrId = addrId;
        return this;
    }

    @JsonProperty("AddrLine2")
    public Object getAddrLine2() {
        return addrLine2;
    }

    @JsonProperty("AddrLine2")
    public void setAddrLine2(Object addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public Address withAddrLine2(Object addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("AddrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    @JsonProperty("AddrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public Address withAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    @JsonProperty("State")
    public String getState() {
        return state;
    }

    @JsonProperty("State")
    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(zipCode).append(addrId).append(addrLine2).append(city).append(addrLine1).append(state).toHashCode();
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
        return new EqualsBuilder().append(zipCode, rhs.zipCode).append(addrId, rhs.addrId).append(addrLine2, rhs.addrLine2).append(city, rhs.city).append(addrLine1, rhs.addrLine1).append(state, rhs.state).isEquals();
    }

}
