
package com.comcast.orion.workorder.domain.ods.customer;

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
    "source",
    "referenceId",
    "addressId",
    "role",
    "type",
    "address"
})
public class Address {

    @JsonProperty("source")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String source;
    @JsonProperty("referenceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String referenceId;
    @JsonProperty("addressId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressId;
    @JsonProperty("role")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String role;
    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("address")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Address_ address;

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public Address withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("referenceId")
    public String getReferenceId() {
        return referenceId;
    }

    @JsonProperty("referenceId")
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Address withReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    @JsonProperty("addressId")
    public String getAddressId() {
        return addressId;
    }

    @JsonProperty("addressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Address withAddressId(String addressId) {
        this.addressId = addressId;
        return this;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    public Address withRole(String role) {
        this.role = role;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Address withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("address")
    public Address_ getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address_ address) {
        this.address = address;
    }

    public Address withAddress(Address_ address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(referenceId).append(addressId).append(role).append(type).append(address).toHashCode();
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
        return new EqualsBuilder().append(source, rhs.source).append(referenceId, rhs.referenceId).append(addressId, rhs.addressId).append(role, rhs.role).append(type, rhs.type).append(address, rhs.address).isEquals();
    }

}
