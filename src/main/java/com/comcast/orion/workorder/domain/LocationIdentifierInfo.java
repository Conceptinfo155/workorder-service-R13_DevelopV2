
package com.comcast.orion.workorder.domain;

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
    "naxId"
})
public class LocationIdentifierInfo {

    @JsonProperty("eLocId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String eLocId;
    @JsonProperty("naxId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String naxId;

    @JsonProperty("eLocId")
    public String getELocId() {
        return eLocId;
    }

    @JsonProperty("eLocId")
    public void setELocId(String eLocId) {
        this.eLocId = eLocId;
    }

    public LocationIdentifierInfo withELocId(String eLocId) {
        this.eLocId = eLocId;
        return this;
    }

    @JsonProperty("naxId")
    public String getNaxId() {
        return naxId;
    }

    @JsonProperty("naxId")
    public void setNaxId(String naxId) {
        this.naxId = naxId;
    }

    public LocationIdentifierInfo withNaxId(String naxId) {
        this.naxId = naxId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(eLocId).append(naxId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationIdentifierInfo) == false) {
            return false;
        }
        LocationIdentifierInfo rhs = ((LocationIdentifierInfo) other);
        return new EqualsBuilder().append(eLocId, rhs.eLocId).append(naxId, rhs.naxId).isEquals();
    }

}
