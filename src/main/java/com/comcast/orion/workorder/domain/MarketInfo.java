
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
    "DSTMarketID"
})
public class MarketInfo {

    @JsonProperty("DSTMarketID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private DSTMarketID dSTMarketID;

    @JsonProperty("DSTMarketID")
    public DSTMarketID getDSTMarketID() {
        return dSTMarketID;
    }

    @JsonProperty("DSTMarketID")
    public void setDSTMarketID(DSTMarketID dSTMarketID) {
        this.dSTMarketID = dSTMarketID;
    }

    public MarketInfo withDSTMarketID(DSTMarketID dSTMarketID) {
        this.dSTMarketID = dSTMarketID;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dSTMarketID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarketInfo) == false) {
            return false;
        }
        MarketInfo rhs = ((MarketInfo) other);
        return new EqualsBuilder().append(dSTMarketID, rhs.dSTMarketID).isEquals();
    }

}
