
package com.comcast.orion.workorder.domain.referencedata;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
    "attributeSubSetValue",
    "attributeSubSetKey",
    "attributes"
})
public class AttributeSubSet {

    /**
     * The Attributesubsetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSetValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String attributeSubSetValue = "";
    /**
     * The Attributesubsetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSubSetKey")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    private String attributeSubSetKey = "";
    /**
     * The Attributes Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<Attribute> attributes = new ArrayList<Attribute>();

    /**
     * The Attributesubsetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSetValue")
    public String getAttributeSubSetValue() {
        return attributeSubSetValue;
    }

    /**
     * The Attributesubsetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSetValue")
    public void setAttributeSubSetValue(String attributeSubSetValue) {
        this.attributeSubSetValue = attributeSubSetValue;
    }

    public AttributeSubSet withAttributeSubSetValue(String attributeSubSetValue) {
        this.attributeSubSetValue = attributeSubSetValue;
        return this;
    }

    /**
     * The Attributesubsetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSubSetKey")
    public String getAttributeSubSetKey() {
        return attributeSubSetKey;
    }

    /**
     * The Attributesubsetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSubSetKey")
    public void setAttributeSubSetKey(String attributeSubSetKey) {
        this.attributeSubSetKey = attributeSubSetKey;
    }

    public AttributeSubSet withAttributeSubSetKey(String attributeSubSetKey) {
        this.attributeSubSetKey = attributeSubSetKey;
        return this;
    }

    /**
     * The Attributes Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * The Attributes Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public AttributeSubSet withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributeSubSetValue).append(attributeSubSetKey).append(attributes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AttributeSubSet) == false) {
            return false;
        }
        AttributeSubSet rhs = ((AttributeSubSet) other);
        return new EqualsBuilder().append(attributeSubSetValue, rhs.attributeSubSetValue).append(attributeSubSetKey, rhs.attributeSubSetKey).append(attributes, rhs.attributes).isEquals();
    }

}
