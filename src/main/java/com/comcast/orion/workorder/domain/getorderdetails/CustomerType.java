
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
    "customerTypeRefId",
    "customerTypeTitle"
})
public class CustomerType {

    /**
     * Reference ID of Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeRefId")
    @JsonPropertyDescription("Reference ID of Customer type per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Reference ID of Customer type per CRM PBT", example = "M")
    private String customerTypeRefId;
    /**
     * Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeTitle")
    @JsonPropertyDescription("Customer type per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Customer type per CRM PBT", example = "Midmarket")
    private String customerTypeTitle;

    /**
     * Reference ID of Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeRefId")
    public String getCustomerTypeRefId() {
        return customerTypeRefId;
    }

    /**
     * Reference ID of Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeRefId")
    public void setCustomerTypeRefId(String customerTypeRefId) {
        this.customerTypeRefId = customerTypeRefId;
    }

    public CustomerType withCustomerTypeRefId(String customerTypeRefId) {
        this.customerTypeRefId = customerTypeRefId;
        return this;
    }

    /**
     * Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeTitle")
    public String getCustomerTypeTitle() {
        return customerTypeTitle;
    }

    /**
     * Customer type per CRM PBT
     * 
     */
    @JsonProperty("customerTypeTitle")
    public void setCustomerTypeTitle(String customerTypeTitle) {
        this.customerTypeTitle = customerTypeTitle;
    }

    public CustomerType withCustomerTypeTitle(String customerTypeTitle) {
        this.customerTypeTitle = customerTypeTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerTypeRefId).append(customerTypeTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerType) == false) {
            return false;
        }
        CustomerType rhs = ((CustomerType) other);
        return new EqualsBuilder().append(customerTypeRefId, rhs.customerTypeRefId).append(customerTypeTitle, rhs.customerTypeTitle).isEquals();
    }

}
