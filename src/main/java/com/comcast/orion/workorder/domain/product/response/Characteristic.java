
package com.comcast.orion.workorder.domain.product.response;

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
    "attributeName",
    "attributeValue"
})
public class Characteristic {

    @JsonProperty("attributeName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String attributeName;
    @JsonProperty("attributeValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String attributeValue;

    @JsonProperty("attributeName")
    public String getAttributeName() {
        return attributeName;
    }

    @JsonProperty("attributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Characteristic withAttributeName(String attributeName) {
        this.attributeName = attributeName;
        return this;
    }

    @JsonProperty("attributeValue")
    public String getAttributeValue() {
        return attributeValue;
    }

    @JsonProperty("attributeValue")
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Characteristic withAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributeName).append(attributeValue).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Characteristic) == false) {
            return false;
        }
        Characteristic rhs = ((Characteristic) other);
        return new EqualsBuilder().append(attributeName, rhs.attributeName).append(attributeValue, rhs.attributeValue).isEquals();
    }

}
