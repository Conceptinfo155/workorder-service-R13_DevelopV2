
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

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

    @JsonProperty("addrLine1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addrLine1;
    @JsonProperty("addrLine2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addrLine2;
    @JsonProperty("city")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String city;
    @JsonProperty("state")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;
    @JsonProperty("zipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zipCode;

    @JsonProperty("addrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    @JsonProperty("addrLine1")
    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public Address withAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    @JsonProperty("addrLine2")
    public String getAddrLine2() {
        return addrLine2;
    }

    @JsonProperty("addrLine2")
    public void setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
    }

    public Address withAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

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
