
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
    "glCode",
    "legacyMarketInfo",
    "legacyMarketType",
    "marketCapabilities",
    "marketID",
    "marketName",
    "parentMarketID",
    "cuid"
})
public class MarketInfo {

    @JsonProperty("glCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String glCode;
    @JsonProperty("legacyMarketInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LegacyMarketInfo legacyMarketInfo;
    @JsonProperty("legacyMarketType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String legacyMarketType;
    @JsonProperty("marketCapabilities")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private MarketCapabilities marketCapabilities;
    @JsonProperty("marketID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String marketID;
    @JsonProperty("marketName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String marketName;
    @JsonProperty("parentMarketID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String parentMarketID;
    @JsonProperty("cuid")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cuid;

    @JsonProperty("glCode")
    public String getGlCode() {
        return glCode;
    }

    @JsonProperty("glCode")
    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }

    public MarketInfo withGlCode(String glCode) {
        this.glCode = glCode;
        return this;
    }

    @JsonProperty("legacyMarketInfo")
    public LegacyMarketInfo getLegacyMarketInfo() {
        return legacyMarketInfo;
    }

    @JsonProperty("legacyMarketInfo")
    public void setLegacyMarketInfo(LegacyMarketInfo legacyMarketInfo) {
        this.legacyMarketInfo = legacyMarketInfo;
    }

    public MarketInfo withLegacyMarketInfo(LegacyMarketInfo legacyMarketInfo) {
        this.legacyMarketInfo = legacyMarketInfo;
        return this;
    }

    @JsonProperty("legacyMarketType")
    public String getLegacyMarketType() {
        return legacyMarketType;
    }

    @JsonProperty("legacyMarketType")
    public void setLegacyMarketType(String legacyMarketType) {
        this.legacyMarketType = legacyMarketType;
    }

    public MarketInfo withLegacyMarketType(String legacyMarketType) {
        this.legacyMarketType = legacyMarketType;
        return this;
    }

    @JsonProperty("marketCapabilities")
    public MarketCapabilities getMarketCapabilities() {
        return marketCapabilities;
    }

    @JsonProperty("marketCapabilities")
    public void setMarketCapabilities(MarketCapabilities marketCapabilities) {
        this.marketCapabilities = marketCapabilities;
    }

    public MarketInfo withMarketCapabilities(MarketCapabilities marketCapabilities) {
        this.marketCapabilities = marketCapabilities;
        return this;
    }

    @JsonProperty("marketID")
    public String getMarketID() {
        return marketID;
    }

    @JsonProperty("marketID")
    public void setMarketID(String marketID) {
        this.marketID = marketID;
    }

    public MarketInfo withMarketID(String marketID) {
        this.marketID = marketID;
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

    public MarketInfo withMarketName(String marketName) {
        this.marketName = marketName;
        return this;
    }

    @JsonProperty("parentMarketID")
    public String getParentMarketID() {
        return parentMarketID;
    }

    @JsonProperty("parentMarketID")
    public void setParentMarketID(String parentMarketID) {
        this.parentMarketID = parentMarketID;
    }

    public MarketInfo withParentMarketID(String parentMarketID) {
        this.parentMarketID = parentMarketID;
        return this;
    }

    @JsonProperty("cuid")
    public String getCuid() {
        return cuid;
    }

    @JsonProperty("cuid")
    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public MarketInfo withCuid(String cuid) {
        this.cuid = cuid;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(glCode).append(legacyMarketInfo).append(legacyMarketType).append(marketCapabilities).append(marketID).append(marketName).append(parentMarketID).append(cuid).toHashCode();
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
        return new EqualsBuilder().append(glCode, rhs.glCode).append(legacyMarketInfo, rhs.legacyMarketInfo).append(legacyMarketType, rhs.legacyMarketType).append(marketCapabilities, rhs.marketCapabilities).append(marketID, rhs.marketID).append(marketName, rhs.marketName).append(parentMarketID, rhs.parentMarketID).append(cuid, rhs.cuid).isEquals();
    }

}
