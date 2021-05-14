
package com.comcast.orion.workorder.domain.getorderdetails;

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
    "latitude",
    "longitude",
    "zipCode",
    "state",
    "addressLine1",
    "addressLine2"
})
public class CustomerAddress {

    /**
     * The city of the address
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("The city of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "The city of the address", example = "Philadelphia")
    private String city;
    /**
     * The country code of the address
     * 
     */
    @JsonProperty("country")
    @JsonPropertyDescription("The country code of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 5, value = "The country code of the address", example = "US")
    private String country;
    /**
     * The latitude in decimal degrees of the address
     * 
     */
    @JsonProperty("latitude")
    @JsonPropertyDescription("The latitude in decimal degrees of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 7, value = "The latitude in decimal degrees of the address", example = "91.09")
    private String latitude;
    /**
     * The longitude in decimal degrees of the address
     * 
     */
    @JsonProperty("longitude")
    @JsonPropertyDescription("The longitude in decimal degrees of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 8, value = "The longitude in decimal degrees of the address", example = "98.10")
    private String longitude;
    /**
     * The postal code of the address
     * 
     */
    @JsonProperty("zipCode")
    @JsonPropertyDescription("The postal code of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 6, value = "The postal code of the address", example = "19355")
    private String zipCode;
    /**
     * The state or province of the address
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("The state or province of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "The state or province of the address", example = "PA")
    private String state;
    /**
     * The street first line
     * 
     */
    @JsonProperty("addressLine1")
    @JsonPropertyDescription("The street first line")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "The street first line", example = "300 E Main Street")
    private String addressLine1;
    /**
     * The street second line
     * 
     */
    @JsonProperty("addressLine2")
    @JsonPropertyDescription("The street second line")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "The street second line", example = "Unit 1")
    private String addressLine2;

    /**
     * The city of the address
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * The city of the address
     * 
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public CustomerAddress withCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * The country code of the address
     * 
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     * The country code of the address
     * 
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public CustomerAddress withCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * The latitude in decimal degrees of the address
     * 
     */
    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    /**
     * The latitude in decimal degrees of the address
     * 
     */
    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public CustomerAddress withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * The longitude in decimal degrees of the address
     * 
     */
    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    /**
     * The longitude in decimal degrees of the address
     * 
     */
    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public CustomerAddress withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * The postal code of the address
     * 
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * The postal code of the address
     * 
     */
    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public CustomerAddress withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    /**
     * The state or province of the address
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * The state or province of the address
     * 
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public CustomerAddress withState(String state) {
        this.state = state;
        return this;
    }

    /**
     * The street first line
     * 
     */
    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * The street first line
     * 
     */
    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public CustomerAddress withAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * The street second line
     * 
     */
    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * The street second line
     * 
     */
    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public CustomerAddress withAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(city).append(country).append(latitude).append(longitude).append(zipCode).append(state).append(addressLine1).append(addressLine2).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAddress) == false) {
            return false;
        }
        CustomerAddress rhs = ((CustomerAddress) other);
        return new EqualsBuilder().append(city, rhs.city).append(country, rhs.country).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(zipCode, rhs.zipCode).append(state, rhs.state).append(addressLine1, rhs.addressLine1).append(addressLine2, rhs.addressLine2).isEquals();
    }

}
