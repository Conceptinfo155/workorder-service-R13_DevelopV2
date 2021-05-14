
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
    "CSGMarketInfo",
    "DSTMarketID",
    "legacyMarketIDSource"
})
public class LegacyMarketInfo {

    @JsonProperty("CSGMarketInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CSGMarketInfo cSGMarketInfo;
    @JsonProperty("DSTMarketID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private DSTMarketID dSTMarketID;
    @JsonProperty("legacyMarketIDSource")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String legacyMarketIDSource;

    @JsonProperty("CSGMarketInfo")
    public CSGMarketInfo getCSGMarketInfo() {
        return cSGMarketInfo;
    }

    @JsonProperty("CSGMarketInfo")
    public void setCSGMarketInfo(CSGMarketInfo cSGMarketInfo) {
        this.cSGMarketInfo = cSGMarketInfo;
    }

    public LegacyMarketInfo withCSGMarketInfo(CSGMarketInfo cSGMarketInfo) {
        this.cSGMarketInfo = cSGMarketInfo;
        return this;
    }

    @JsonProperty("DSTMarketID")
    public DSTMarketID getDSTMarketID() {
        return dSTMarketID;
    }

    @JsonProperty("DSTMarketID")
    public void setDSTMarketID(DSTMarketID dSTMarketID) {
        this.dSTMarketID = dSTMarketID;
    }

    public LegacyMarketInfo withDSTMarketID(DSTMarketID dSTMarketID) {
        this.dSTMarketID = dSTMarketID;
        return this;
    }

    @JsonProperty("legacyMarketIDSource")
    public String getLegacyMarketIDSource() {
        return legacyMarketIDSource;
    }

    @JsonProperty("legacyMarketIDSource")
    public void setLegacyMarketIDSource(String legacyMarketIDSource) {
        this.legacyMarketIDSource = legacyMarketIDSource;
    }

    public LegacyMarketInfo withLegacyMarketIDSource(String legacyMarketIDSource) {
        this.legacyMarketIDSource = legacyMarketIDSource;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cSGMarketInfo).append(dSTMarketID).append(legacyMarketIDSource).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LegacyMarketInfo) == false) {
            return false;
        }
        LegacyMarketInfo rhs = ((LegacyMarketInfo) other);
        return new EqualsBuilder().append(cSGMarketInfo, rhs.cSGMarketInfo).append(dSTMarketID, rhs.dSTMarketID).append(legacyMarketIDSource, rhs.legacyMarketIDSource).isEquals();
    }

}
