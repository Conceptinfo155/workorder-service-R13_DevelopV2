
package com.comcast.orion.workorder.domain.locationResponse;

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
    "city",
    "country",
    "dwellingCode",
    "houseNumber",
    "houseNumberPrefix",
    "houseNumberSuffix",
    "state",
    "streetName",
    "streetPostDirection",
    "streetPreDirection",
    "streetSuffix",
    "unitTypes",
    "zipCode"
})
public class PostalAddress {

    @JsonProperty("city")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String city;
    @JsonProperty("country")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String country;
    @JsonProperty("dwellingCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String dwellingCode;
    @JsonProperty("houseNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String houseNumber;
    @JsonProperty("houseNumberPrefix")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String houseNumberPrefix;
    @JsonProperty("houseNumberSuffix")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String houseNumberSuffix;
    @JsonProperty("state")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;
    @JsonProperty("streetName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String streetName;
    @JsonProperty("streetPostDirection")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String streetPostDirection;
    @JsonProperty("streetPreDirection")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String streetPreDirection;
    @JsonProperty("streetSuffix")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String streetSuffix;
    @JsonProperty("unitTypes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private UnitTypes_ unitTypes;
    @JsonProperty("zipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ZipCode_ zipCode;

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public PostalAddress withCity(String city) {
        this.city = city;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public PostalAddress withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("dwellingCode")
    public String getDwellingCode() {
        return dwellingCode;
    }

    @JsonProperty("dwellingCode")
    public void setDwellingCode(String dwellingCode) {
        this.dwellingCode = dwellingCode;
    }

    public PostalAddress withDwellingCode(String dwellingCode) {
        this.dwellingCode = dwellingCode;
        return this;
    }

    @JsonProperty("houseNumber")
    public String getHouseNumber() {
        return houseNumber;
    }

    @JsonProperty("houseNumber")
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public PostalAddress withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    @JsonProperty("houseNumberPrefix")
    public String getHouseNumberPrefix() {
        return houseNumberPrefix;
    }

    @JsonProperty("houseNumberPrefix")
    public void setHouseNumberPrefix(String houseNumberPrefix) {
        this.houseNumberPrefix = houseNumberPrefix;
    }

    public PostalAddress withHouseNumberPrefix(String houseNumberPrefix) {
        this.houseNumberPrefix = houseNumberPrefix;
        return this;
    }

    @JsonProperty("houseNumberSuffix")
    public String getHouseNumberSuffix() {
        return houseNumberSuffix;
    }

    @JsonProperty("houseNumberSuffix")
    public void setHouseNumberSuffix(String houseNumberSuffix) {
        this.houseNumberSuffix = houseNumberSuffix;
    }

    public PostalAddress withHouseNumberSuffix(String houseNumberSuffix) {
        this.houseNumberSuffix = houseNumberSuffix;
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

    public PostalAddress withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("streetName")
    public String getStreetName() {
        return streetName;
    }

    @JsonProperty("streetName")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public PostalAddress withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    @JsonProperty("streetPostDirection")
    public String getStreetPostDirection() {
        return streetPostDirection;
    }

    @JsonProperty("streetPostDirection")
    public void setStreetPostDirection(String streetPostDirection) {
        this.streetPostDirection = streetPostDirection;
    }

    public PostalAddress withStreetPostDirection(String streetPostDirection) {
        this.streetPostDirection = streetPostDirection;
        return this;
    }

    @JsonProperty("streetPreDirection")
    public String getStreetPreDirection() {
        return streetPreDirection;
    }

    @JsonProperty("streetPreDirection")
    public void setStreetPreDirection(String streetPreDirection) {
        this.streetPreDirection = streetPreDirection;
    }

    public PostalAddress withStreetPreDirection(String streetPreDirection) {
        this.streetPreDirection = streetPreDirection;
        return this;
    }

    @JsonProperty("streetSuffix")
    public String getStreetSuffix() {
        return streetSuffix;
    }

    @JsonProperty("streetSuffix")
    public void setStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
    }

    public PostalAddress withStreetSuffix(String streetSuffix) {
        this.streetSuffix = streetSuffix;
        return this;
    }

    @JsonProperty("unitTypes")
    public UnitTypes_ getUnitTypes() {
        return unitTypes;
    }

    @JsonProperty("unitTypes")
    public void setUnitTypes(UnitTypes_ unitTypes) {
        this.unitTypes = unitTypes;
    }

    public PostalAddress withUnitTypes(UnitTypes_ unitTypes) {
        this.unitTypes = unitTypes;
        return this;
    }

    @JsonProperty("zipCode")
    public ZipCode_ getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(ZipCode_ zipCode) {
        this.zipCode = zipCode;
    }

    public PostalAddress withZipCode(ZipCode_ zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(city).append(country).append(dwellingCode).append(houseNumber).append(houseNumberPrefix).append(houseNumberSuffix).append(state).append(streetName).append(streetPostDirection).append(streetPreDirection).append(streetSuffix).append(unitTypes).append(zipCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PostalAddress) == false) {
            return false;
        }
        PostalAddress rhs = ((PostalAddress) other);
        return new EqualsBuilder().append(city, rhs.city).append(country, rhs.country).append(dwellingCode, rhs.dwellingCode).append(houseNumber, rhs.houseNumber).append(houseNumberPrefix, rhs.houseNumberPrefix).append(houseNumberSuffix, rhs.houseNumberSuffix).append(state, rhs.state).append(streetName, rhs.streetName).append(streetPostDirection, rhs.streetPostDirection).append(streetPreDirection, rhs.streetPreDirection).append(streetSuffix, rhs.streetSuffix).append(unitTypes, rhs.unitTypes).append(zipCode, rhs.zipCode).isEquals();
    }

}
