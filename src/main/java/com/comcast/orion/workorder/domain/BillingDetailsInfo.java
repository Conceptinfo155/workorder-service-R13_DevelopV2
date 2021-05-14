
package com.comcast.orion.workorder.domain;

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
    "csgDetails"
})
public class BillingDetailsInfo {

    @JsonProperty("csgDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CsgDetails csgDetails;

    @JsonProperty("csgDetails")
    public CsgDetails getCsgDetails() {
        return csgDetails;
    }

    @JsonProperty("csgDetails")
    public void setCsgDetails(CsgDetails csgDetails) {
        this.csgDetails = csgDetails;
    }

    public BillingDetailsInfo withCsgDetails(CsgDetails csgDetails) {
        this.csgDetails = csgDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(csgDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BillingDetailsInfo) == false) {
            return false;
        }
        BillingDetailsInfo rhs = ((BillingDetailsInfo) other);
        return new EqualsBuilder().append(csgDetails, rhs.csgDetails).isEquals();
    }

}
