
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
    "customerSpecialPopulationRefId",
    "customerSpecialPopulationTitle"
})
public class CustomerSpecialPopulation {

    /**
     * Reference ID of Customer special population per CRM PBT.Defines the type of customer.
     * 
     */
    @JsonProperty("customerSpecialPopulationRefId")
    @JsonPropertyDescription("Reference ID of Customer special population per CRM PBT.Defines the type of customer.")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Reference ID of Customer special population per CRM PBT.Defines the type of customer.", example = "none")
    private String customerSpecialPopulationRefId;
    /**
     * Customer special population per CRM PBT.Defines the type of customer.For example: E-Rate, Internet Essentials, VIP/Internal, Special Events
     * 
     */
    @JsonProperty("customerSpecialPopulationTitle")
    @JsonPropertyDescription("Customer special population per CRM PBT.Defines the type of customer.For example: E-Rate, Internet Essentials, VIP/Internal, Special Events")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Customer special population per CRM PBT.Defines the type of customer.For example: E-Rate, Internet Essentials, VIP/Internal, Special Events", example = "none")
    private String customerSpecialPopulationTitle;

    /**
     * Reference ID of Customer special population per CRM PBT.Defines the type of customer.
     * 
     */
    @JsonProperty("customerSpecialPopulationRefId")
    public String getCustomerSpecialPopulationRefId() {
        return customerSpecialPopulationRefId;
    }

    /**
     * Reference ID of Customer special population per CRM PBT.Defines the type of customer.
     * 
     */
    @JsonProperty("customerSpecialPopulationRefId")
    public void setCustomerSpecialPopulationRefId(String customerSpecialPopulationRefId) {
        this.customerSpecialPopulationRefId = customerSpecialPopulationRefId;
    }

    public CustomerSpecialPopulation withCustomerSpecialPopulationRefId(String customerSpecialPopulationRefId) {
        this.customerSpecialPopulationRefId = customerSpecialPopulationRefId;
        return this;
    }

    /**
     * Customer special population per CRM PBT.Defines the type of customer.For example: E-Rate, Internet Essentials, VIP/Internal, Special Events
     * 
     */
    @JsonProperty("customerSpecialPopulationTitle")
    public String getCustomerSpecialPopulationTitle() {
        return customerSpecialPopulationTitle;
    }

    /**
     * Customer special population per CRM PBT.Defines the type of customer.For example: E-Rate, Internet Essentials, VIP/Internal, Special Events
     * 
     */
    @JsonProperty("customerSpecialPopulationTitle")
    public void setCustomerSpecialPopulationTitle(String customerSpecialPopulationTitle) {
        this.customerSpecialPopulationTitle = customerSpecialPopulationTitle;
    }

    public CustomerSpecialPopulation withCustomerSpecialPopulationTitle(String customerSpecialPopulationTitle) {
        this.customerSpecialPopulationTitle = customerSpecialPopulationTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerSpecialPopulationRefId).append(customerSpecialPopulationTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerSpecialPopulation) == false) {
            return false;
        }
        CustomerSpecialPopulation rhs = ((CustomerSpecialPopulation) other);
        return new EqualsBuilder().append(customerSpecialPopulationRefId, rhs.customerSpecialPopulationRefId).append(customerSpecialPopulationTitle, rhs.customerSpecialPopulationTitle).isEquals();
    }

}
