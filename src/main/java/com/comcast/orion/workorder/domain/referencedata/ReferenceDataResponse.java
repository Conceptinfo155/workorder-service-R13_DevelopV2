
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
 * The Root Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "referenceTemplateId",
    "referenceTemplateName",
    "attributeSets"
})
public class ReferenceDataResponse {

    /**
     * The Referencetemplateid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String referenceTemplateId = "";
    /**
     * The Referencetemplatename Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String referenceTemplateName = "";
    /**
     * The Attributesets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSets")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();

    /**
     * The Referencetemplateid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateId")
    public String getReferenceTemplateId() {
        return referenceTemplateId;
    }

    /**
     * The Referencetemplateid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateId")
    public void setReferenceTemplateId(String referenceTemplateId) {
        this.referenceTemplateId = referenceTemplateId;
    }

    public ReferenceDataResponse withReferenceTemplateId(String referenceTemplateId) {
        this.referenceTemplateId = referenceTemplateId;
        return this;
    }

    /**
     * The Referencetemplatename Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateName")
    public String getReferenceTemplateName() {
        return referenceTemplateName;
    }

    /**
     * The Referencetemplatename Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("referenceTemplateName")
    public void setReferenceTemplateName(String referenceTemplateName) {
        this.referenceTemplateName = referenceTemplateName;
    }

    public ReferenceDataResponse withReferenceTemplateName(String referenceTemplateName) {
        this.referenceTemplateName = referenceTemplateName;
        return this;
    }

    /**
     * The Attributesets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSets")
    public List<AttributeSet> getAttributeSets() {
        return attributeSets;
    }

    /**
     * The Attributesets Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeSets")
    public void setAttributeSets(List<AttributeSet> attributeSets) {
        this.attributeSets = attributeSets;
    }

    public ReferenceDataResponse withAttributeSets(List<AttributeSet> attributeSets) {
        this.attributeSets = attributeSets;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(referenceTemplateId).append(referenceTemplateName).append(attributeSets).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReferenceDataResponse) == false) {
            return false;
        }
        ReferenceDataResponse rhs = ((ReferenceDataResponse) other);
        return new EqualsBuilder().append(referenceTemplateId, rhs.referenceTemplateId).append(referenceTemplateName, rhs.referenceTemplateName).append(attributeSets, rhs.attributeSets).isEquals();
    }

}
