
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
    "franchiseTaxArea"
})
public class DSTMarketID {

    @JsonProperty("franchiseTaxArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String franchiseTaxArea;

    @JsonProperty("franchiseTaxArea")
    public String getFranchiseTaxArea() {
        return franchiseTaxArea;
    }

    @JsonProperty("franchiseTaxArea")
    public void setFranchiseTaxArea(String franchiseTaxArea) {
        this.franchiseTaxArea = franchiseTaxArea;
    }

    public DSTMarketID withFranchiseTaxArea(String franchiseTaxArea) {
        this.franchiseTaxArea = franchiseTaxArea;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(franchiseTaxArea).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DSTMarketID) == false) {
            return false;
        }
        DSTMarketID rhs = ((DSTMarketID) other);
        return new EqualsBuilder().append(franchiseTaxArea, rhs.franchiseTaxArea).isEquals();
    }

}
