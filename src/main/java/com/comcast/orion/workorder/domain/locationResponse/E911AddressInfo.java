
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
    "unitTypes",
    "zipCode"
})
public class E911AddressInfo {

    @JsonProperty("unitTypes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private UnitTypes unitTypes;
    @JsonProperty("zipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ZipCode zipCode;

    @JsonProperty("unitTypes")
    public UnitTypes getUnitTypes() {
        return unitTypes;
    }

    @JsonProperty("unitTypes")
    public void setUnitTypes(UnitTypes unitTypes) {
        this.unitTypes = unitTypes;
    }

    public E911AddressInfo withUnitTypes(UnitTypes unitTypes) {
        this.unitTypes = unitTypes;
        return this;
    }

    @JsonProperty("zipCode")
    public ZipCode getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    public E911AddressInfo withZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unitTypes).append(zipCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof E911AddressInfo) == false) {
            return false;
        }
        E911AddressInfo rhs = ((E911AddressInfo) other);
        return new EqualsBuilder().append(unitTypes, rhs.unitTypes).append(zipCode, rhs.zipCode).isEquals();
    }

}
