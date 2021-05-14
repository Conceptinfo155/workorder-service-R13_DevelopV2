
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
    "customerSubtypeRefId",
    "customerSubtypeTitle"
})
public class CustomerSubtype {

    /**
     * Reference ID of Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeRefId")
    @JsonPropertyDescription("Reference ID of Customer sub-type per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Reference ID of Customer sub-type per CRM PBT", example = "MAJR")
    private String customerSubtypeRefId;
    /**
     * Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeTitle")
    @JsonPropertyDescription("Customer sub-type per CRM PBT")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Customer sub-type per CRM PBT", example = "Major")
    private String customerSubtypeTitle;

    /**
     * Reference ID of Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeRefId")
    public String getCustomerSubtypeRefId() {
        return customerSubtypeRefId;
    }

    /**
     * Reference ID of Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeRefId")
    public void setCustomerSubtypeRefId(String customerSubtypeRefId) {
        this.customerSubtypeRefId = customerSubtypeRefId;
    }

    public CustomerSubtype withCustomerSubtypeRefId(String customerSubtypeRefId) {
        this.customerSubtypeRefId = customerSubtypeRefId;
        return this;
    }

    /**
     * Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeTitle")
    public String getCustomerSubtypeTitle() {
        return customerSubtypeTitle;
    }

    /**
     * Customer sub-type per CRM PBT
     * 
     */
    @JsonProperty("customerSubtypeTitle")
    public void setCustomerSubtypeTitle(String customerSubtypeTitle) {
        this.customerSubtypeTitle = customerSubtypeTitle;
    }

    public CustomerSubtype withCustomerSubtypeTitle(String customerSubtypeTitle) {
        this.customerSubtypeTitle = customerSubtypeTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerSubtypeRefId).append(customerSubtypeTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerSubtype) == false) {
            return false;
        }
        CustomerSubtype rhs = ((CustomerSubtype) other);
        return new EqualsBuilder().append(customerSubtypeRefId, rhs.customerSubtypeRefId).append(customerSubtypeTitle, rhs.customerSubtypeTitle).isEquals();
    }

}
