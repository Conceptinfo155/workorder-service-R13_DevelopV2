
package com.comcast.orion.workorder.domain.locationResponse;

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
    "level",
    "marketId",
    "marketName"
})
public class MarketHierarchy {

    @JsonProperty("level")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "", example = "")
    private Integer level;
    @JsonProperty("marketId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "", example = "")
    private Integer marketId;
    @JsonProperty("marketName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String marketName;

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    public MarketHierarchy withLevel(Integer level) {
        this.level = level;
        return this;
    }

    @JsonProperty("marketId")
    public Integer getMarketId() {
        return marketId;
    }

    @JsonProperty("marketId")
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    public MarketHierarchy withMarketId(Integer marketId) {
        this.marketId = marketId;
        return this;
    }

    @JsonProperty("marketName")
    public String getMarketName() {
        return marketName;
    }

    @JsonProperty("marketName")
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public MarketHierarchy withMarketName(String marketName) {
        this.marketName = marketName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(level).append(marketId).append(marketName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MarketHierarchy) == false) {
            return false;
        }
        MarketHierarchy rhs = ((MarketHierarchy) other);
        return new EqualsBuilder().append(level, rhs.level).append(marketId, rhs.marketId).append(marketName, rhs.marketName).isEquals();
    }

}
