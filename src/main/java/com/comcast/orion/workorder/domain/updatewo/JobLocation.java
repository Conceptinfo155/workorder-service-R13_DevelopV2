
package com.comcast.orion.workorder.domain.updatewo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "address",
    "addrId"
})
public class JobLocation {

    @JsonProperty("address")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Address address;
    /**
     * Amdocs AddrId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("addrId")
    @JsonPropertyDescription("Amdocs AddrId passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 1, value = "Amdocs AddrId passed by Amdocs - WFX", example = "205192378")
    @Size(min = 1, max = 14)
    private String addrId;

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

    /**
     * Amdocs AddrId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("addrId")
    public String getAddrId() {
        return addrId;
    }

    /**
     * Amdocs AddrId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("addrId")
    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public JobLocation withAddrId(String addrId) {
        this.addrId = addrId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(address).append(addrId).toHashCode();
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
        return new EqualsBuilder().append(address, rhs.address).append(addrId, rhs.addrId).isEquals();
    }

}
