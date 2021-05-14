
package com.comcast.orion.workorder.domain.createwo;

import javax.validation.constraints.Size;
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
    "zipCode",
    "routeCriteria"
})
public class Address {

    /**
     * Amdocs AddrLine1 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("addrLine1")
    @JsonPropertyDescription("Amdocs AddrLine1 passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Amdocs AddrLine1 passed by Amdocs - WFX", example = "1354 E Boot Road")
    @Size(min = 0, max = 100)
    private String addrLine1;
    /**
     * Amdocs AddrLine2 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("addrLine2")
    @JsonPropertyDescription("Amdocs AddrLine2 passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Amdocs AddrLine2 passed by Amdocs - WFX", example = "Apt A")
    @Size(min = 0, max = 100)
    private String addrLine2;
    /**
     * Amdocs City passed by Amdocs - WFX
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("Amdocs City passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "Amdocs City passed by Amdocs - WFX", example = "West Chester")
    @Size(min = 0, max = 30)
    private String city;
    /**
     * Amdocs State passed by Amdocs - WFX
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("Amdocs State passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "Amdocs State passed by Amdocs - WFX", example = "PA")
    @Size(min = 0, max = 2)
    private String state;
    /**
     * Amdocs ZipCode passed by Amdocs - WFX
     * 
     */
    @JsonProperty("zipCode")
    @JsonPropertyDescription("Amdocs ZipCode passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 5, value = "Amdocs ZipCode passed by Amdocs - WFX", example = "19380")
    @Size(min = 0, max = 10)
    private String zipCode;
    /**
     * Flow from Location Service - RouteCriteria passed by Location - WFX
     * 
     */
    @JsonProperty("routeCriteria")
    @JsonPropertyDescription("Flow from Location Service - RouteCriteria passed by Location - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 6, value = "Flow from Location Service - RouteCriteria passed by Location - WFX", example = "B1")
    @Size(min = 0, max = 15)
    private String routeCriteria;

    /**
     * Amdocs AddrLine1 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("addrLine1")
    public String getAddrLine1() {
        return addrLine1;
    }

    /**
     * Amdocs AddrLine1 passed by Amdocs - WFX
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
     * Amdocs AddrLine2 passed by Amdocs - WFX
     * 
     */
    @JsonProperty("addrLine2")
    public String getAddrLine2() {
        return addrLine2;
    }

    /**
     * Amdocs AddrLine2 passed by Amdocs - WFX
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
     * Amdocs City passed by Amdocs - WFX
     * 
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * Amdocs City passed by Amdocs - WFX
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
     * Amdocs State passed by Amdocs - WFX
     * 
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * Amdocs State passed by Amdocs - WFX
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
     * Amdocs ZipCode passed by Amdocs - WFX
     * 
     */
    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Amdocs ZipCode passed by Amdocs - WFX
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

    /**
     * Flow from Location Service - RouteCriteria passed by Location - WFX
     * 
     */
    @JsonProperty("routeCriteria")
    public String getRouteCriteria() {
        return routeCriteria;
    }

    /**
     * Flow from Location Service - RouteCriteria passed by Location - WFX
     * 
     */
    @JsonProperty("routeCriteria")
    public void setRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
    }

    public Address withRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(addrLine1).append(addrLine2).append(city).append(state).append(zipCode).append(routeCriteria).toHashCode();
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
        return new EqualsBuilder().append(addrLine1, rhs.addrLine1).append(addrLine2, rhs.addrLine2).append(city, rhs.city).append(state, rhs.state).append(zipCode, rhs.zipCode).append(routeCriteria, rhs.routeCriteria).isEquals();
    }

}
