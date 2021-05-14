
package com.comcast.orion.workorder.domain.getorderdetails;

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
    "customerRelationshipOwnerRefId",
    "customerRelationshipOwnerTitle"
})
public class CustomerRelationshipOwner {

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerRelationshipOwnerRefId")
    @JsonPropertyDescription("Provides the Ref ID of CustomerIndustry.")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Provides the Ref ID of CustomerIndustry.", example = "EAM/ EAE")
    private String customerRelationshipOwnerRefId;
    /**
     * Provides the title of CustomerIndustry
     * 
     */
    @JsonProperty("customerRelationshipOwnerTitle")
    @JsonPropertyDescription("Provides the title of CustomerIndustry")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Provides the title of CustomerIndustry", example = "EAM/ EAE")
    private String customerRelationshipOwnerTitle;

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerRelationshipOwnerRefId")
    public String getCustomerRelationshipOwnerRefId() {
        return customerRelationshipOwnerRefId;
    }

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerRelationshipOwnerRefId")
    public void setCustomerRelationshipOwnerRefId(String customerRelationshipOwnerRefId) {
        this.customerRelationshipOwnerRefId = customerRelationshipOwnerRefId;
    }

    public CustomerRelationshipOwner withCustomerRelationshipOwnerRefId(String customerRelationshipOwnerRefId) {
        this.customerRelationshipOwnerRefId = customerRelationshipOwnerRefId;
        return this;
    }

    /**
     * Provides the title of CustomerIndustry
     * 
     */
    @JsonProperty("customerRelationshipOwnerTitle")
    public String getCustomerRelationshipOwnerTitle() {
        return customerRelationshipOwnerTitle;
    }

    /**
     * Provides the title of CustomerIndustry
     * 
     */
    @JsonProperty("customerRelationshipOwnerTitle")
    public void setCustomerRelationshipOwnerTitle(String customerRelationshipOwnerTitle) {
        this.customerRelationshipOwnerTitle = customerRelationshipOwnerTitle;
    }

    public CustomerRelationshipOwner withCustomerRelationshipOwnerTitle(String customerRelationshipOwnerTitle) {
        this.customerRelationshipOwnerTitle = customerRelationshipOwnerTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerRelationshipOwnerRefId).append(customerRelationshipOwnerTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerRelationshipOwner) == false) {
            return false;
        }
        CustomerRelationshipOwner rhs = ((CustomerRelationshipOwner) other);
        return new EqualsBuilder().append(customerRelationshipOwnerRefId, rhs.customerRelationshipOwnerRefId).append(customerRelationshipOwnerTitle, rhs.customerRelationshipOwnerTitle).isEquals();
    }

}
