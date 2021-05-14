
package com.comcast.orion.workorder.domain.getfutureworkorder;

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
    "characteristicName",
    "characteristicValue"
})
public class Characteristic_ {

    @JsonProperty("characteristicName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String characteristicName;
    @JsonProperty("characteristicValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String characteristicValue;

    @JsonProperty("characteristicName")
    public String getCharacteristicName() {
        return characteristicName;
    }

    @JsonProperty("characteristicName")
    public void setCharacteristicName(String characteristicName) {
        this.characteristicName = characteristicName;
    }

    public Characteristic_ withCharacteristicName(String characteristicName) {
        this.characteristicName = characteristicName;
        return this;
    }

    @JsonProperty("characteristicValue")
    public String getCharacteristicValue() {
        return characteristicValue;
    }

    @JsonProperty("characteristicValue")
    public void setCharacteristicValue(String characteristicValue) {
        this.characteristicValue = characteristicValue;
    }

    public Characteristic_ withCharacteristicValue(String characteristicValue) {
        this.characteristicValue = characteristicValue;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(characteristicName).append(characteristicValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Characteristic_) == false) {
            return false;
        }
        Characteristic_ rhs = ((Characteristic_) other);
        return new EqualsBuilder().append(characteristicName, rhs.characteristicName).append(characteristicValue, rhs.characteristicValue).isEquals();
    }

}
