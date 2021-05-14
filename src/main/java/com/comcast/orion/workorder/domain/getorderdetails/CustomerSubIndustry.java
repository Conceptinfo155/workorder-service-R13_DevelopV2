
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
    "customerSubIndustryRefId",
    "customerSubIndustryTitle"
})
public class CustomerSubIndustry {

    /**
     * Reference ID of Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryRefId")
    @JsonPropertyDescription("Reference ID of Customer sub-industry per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Reference ID of Customer sub-industry per CRM PBT", example = "94")
    private String customerSubIndustryRefId;
    /**
     * Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryTitle")
    @JsonPropertyDescription("Customer sub-industry per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Customer sub-industry per CRM PBT", example = "Administration Of Educational Programs")
    private String customerSubIndustryTitle;

    /**
     * Reference ID of Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryRefId")
    public String getCustomerSubIndustryRefId() {
        return customerSubIndustryRefId;
    }

    /**
     * Reference ID of Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryRefId")
    public void setCustomerSubIndustryRefId(String customerSubIndustryRefId) {
        this.customerSubIndustryRefId = customerSubIndustryRefId;
    }

    public CustomerSubIndustry withCustomerSubIndustryRefId(String customerSubIndustryRefId) {
        this.customerSubIndustryRefId = customerSubIndustryRefId;
        return this;
    }

    /**
     * Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryTitle")
    public String getCustomerSubIndustryTitle() {
        return customerSubIndustryTitle;
    }

    /**
     * Customer sub-industry per CRM PBT
     * 
     */
    @JsonProperty("customerSubIndustryTitle")
    public void setCustomerSubIndustryTitle(String customerSubIndustryTitle) {
        this.customerSubIndustryTitle = customerSubIndustryTitle;
    }

    public CustomerSubIndustry withCustomerSubIndustryTitle(String customerSubIndustryTitle) {
        this.customerSubIndustryTitle = customerSubIndustryTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerSubIndustryRefId).append(customerSubIndustryTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerSubIndustry) == false) {
            return false;
        }
        CustomerSubIndustry rhs = ((CustomerSubIndustry) other);
        return new EqualsBuilder().append(customerSubIndustryRefId, rhs.customerSubIndustryRefId).append(customerSubIndustryTitle, rhs.customerSubIndustryTitle).isEquals();
    }

}
