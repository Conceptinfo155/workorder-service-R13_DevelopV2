
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
    "unitSequence",
    "unitType",
    "unitValue"
})
public class UnitTypes_ {

    @JsonProperty("unitSequence")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String unitSequence;
    @JsonProperty("unitType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String unitType;
    @JsonProperty("unitValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String unitValue;

    @JsonProperty("unitSequence")
    public String getUnitSequence() {
        return unitSequence;
    }

    @JsonProperty("unitSequence")
    public void setUnitSequence(String unitSequence) {
        this.unitSequence = unitSequence;
    }

    public UnitTypes_ withUnitSequence(String unitSequence) {
        this.unitSequence = unitSequence;
        return this;
    }

    @JsonProperty("unitType")
    public String getUnitType() {
        return unitType;
    }

    @JsonProperty("unitType")
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public UnitTypes_ withUnitType(String unitType) {
        this.unitType = unitType;
        return this;
    }

    @JsonProperty("unitValue")
    public String getUnitValue() {
        return unitValue;
    }

    @JsonProperty("unitValue")
    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public UnitTypes_ withUnitValue(String unitValue) {
        this.unitValue = unitValue;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unitSequence).append(unitType).append(unitValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnitTypes_) == false) {
            return false;
        }
        UnitTypes_ rhs = ((UnitTypes_) other);
        return new EqualsBuilder().append(unitSequence, rhs.unitSequence).append(unitType, rhs.unitType).append(unitValue, rhs.unitValue).isEquals();
    }

}
