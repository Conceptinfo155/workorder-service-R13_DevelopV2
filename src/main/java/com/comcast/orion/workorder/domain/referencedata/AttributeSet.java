
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
    "attributeSetValue",
    "attributeSetKey",
    "attributeSubSets"
})
public class AttributeSet {

    /**
     * The Attributesetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSetValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String attributeSetValue = "";
    /**
     * The Attributesetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSetKey")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    private String attributeSetKey = "";
    /**
     * The Attributesubsets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSets")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<AttributeSubSet> attributeSubSets = new ArrayList<AttributeSubSet>();

    /**
     * The Attributesetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSetValue")
    public String getAttributeSetValue() {
        return attributeSetValue;
    }

    /**
     * The Attributesetvalue Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSetValue")
    public void setAttributeSetValue(String attributeSetValue) {
        this.attributeSetValue = attributeSetValue;
    }

    public AttributeSet withAttributeSetValue(String attributeSetValue) {
        this.attributeSetValue = attributeSetValue;
        return this;
    }

    /**
     * The Attributesetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSetKey")
    public String getAttributeSetKey() {
        return attributeSetKey;
    }

    /**
     * The Attributesetkey Schema
     * <p>
     * 
     * 
     */
    @JsonProperty("attributeSetKey")
    public void setAttributeSetKey(String attributeSetKey) {
        this.attributeSetKey = attributeSetKey;
    }

    public AttributeSet withAttributeSetKey(String attributeSetKey) {
        this.attributeSetKey = attributeSetKey;
        return this;
    }

    /**
     * The Attributesubsets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSets")
    public List<AttributeSubSet> getAttributeSubSets() {
        return attributeSubSets;
    }

    /**
     * The Attributesubsets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSubSets")
    public void setAttributeSubSets(List<AttributeSubSet> attributeSubSets) {
        this.attributeSubSets = attributeSubSets;
    }

    public AttributeSet withAttributeSubSets(List<AttributeSubSet> attributeSubSets) {
        this.attributeSubSets = attributeSubSets;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributeSetValue).append(attributeSetKey).append(attributeSubSets).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AttributeSet) == false) {
            return false;
        }
        AttributeSet rhs = ((AttributeSet) other);
        return new EqualsBuilder().append(attributeSetValue, rhs.attributeSetValue).append(attributeSetKey, rhs.attributeSetKey).append(attributeSubSets, rhs.attributeSubSets).isEquals();
    }

}
