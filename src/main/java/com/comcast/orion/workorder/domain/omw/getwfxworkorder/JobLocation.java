
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

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
    "eLocId",
    "address"
})
public class JobLocation {

    /**
     * eLOC ID of the location
     * 
     */
    @JsonProperty("eLocId")
    @JsonPropertyDescription("eLOC ID of the location")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "eLOC ID of the location", example = "205469942")
    private String eLocId;
    @JsonProperty("address")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Address address;

    /**
     * eLOC ID of the location
     * 
     */
    @JsonProperty("eLocId")
    public String getELocId() {
        return eLocId;
    }

    /**
     * eLOC ID of the location
     * 
     */
    @JsonProperty("eLocId")
    public void setELocId(String eLocId) {
        this.eLocId = eLocId;
    }

    public JobLocation withELocId(String eLocId) {
        this.eLocId = eLocId;
        return this;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public JobLocation withAddress(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eLocId).append(address).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobLocation) == false) {
            return false;
        }
        JobLocation rhs = ((JobLocation) other);
        return new EqualsBuilder().append(eLocId, rhs.eLocId).append(address, rhs.address).isEquals();
    }

}
