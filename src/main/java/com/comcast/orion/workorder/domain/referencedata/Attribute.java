
package com.comcast.orion.workorder.domain.referencedata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The Items Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "attributeValue",
    "attributeKey"
})
public class Attribute {

    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String attributeValue = "";
    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeKey")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String attributeKey = "";

    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeValue")
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeValue")
    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Attribute withAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
        return this;
    }

    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeKey")
    public String getAttributeKey() {
        return attributeKey;
    }

    /**
     * The Attributevalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeKey")
    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

    public Attribute withAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributeValue).append(attributeKey).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Attribute) == false) {
            return false;
        }
        Attribute rhs = ((Attribute) other);
        return new EqualsBuilder().append(attributeValue, rhs.attributeValue).append(attributeKey, rhs.attributeKey).isEquals();
    }

}
