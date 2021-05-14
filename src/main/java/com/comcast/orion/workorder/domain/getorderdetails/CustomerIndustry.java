
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
    "customerIndustryRefId",
    "customerIndustryTitle"
})
public class CustomerIndustry {

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryRefId")
    @JsonPropertyDescription("Provides the Ref ID of CustomerIndustry.")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Provides the Ref ID of CustomerIndustry.", example = "96")
    private String customerIndustryRefId;
    /**
     * Provides the title of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryTitle")
    @JsonPropertyDescription("Provides the title of CustomerIndustry.")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Provides the title of CustomerIndustry.", example = "Administration of Economic Programs")
    private String customerIndustryTitle;

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryRefId")
    public String getCustomerIndustryRefId() {
        return customerIndustryRefId;
    }

    /**
     * Provides the Ref ID of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryRefId")
    public void setCustomerIndustryRefId(String customerIndustryRefId) {
        this.customerIndustryRefId = customerIndustryRefId;
    }

    public CustomerIndustry withCustomerIndustryRefId(String customerIndustryRefId) {
        this.customerIndustryRefId = customerIndustryRefId;
        return this;
    }

    /**
     * Provides the title of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryTitle")
    public String getCustomerIndustryTitle() {
        return customerIndustryTitle;
    }

    /**
     * Provides the title of CustomerIndustry.
     * 
     */
    @JsonProperty("customerIndustryTitle")
    public void setCustomerIndustryTitle(String customerIndustryTitle) {
        this.customerIndustryTitle = customerIndustryTitle;
    }

    public CustomerIndustry withCustomerIndustryTitle(String customerIndustryTitle) {
        this.customerIndustryTitle = customerIndustryTitle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerIndustryRefId).append(customerIndustryTitle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerIndustry) == false) {
            return false;
        }
        CustomerIndustry rhs = ((CustomerIndustry) other);
        return new EqualsBuilder().append(customerIndustryRefId, rhs.customerIndustryRefId).append(customerIndustryTitle, rhs.customerIndustryTitle).isEquals();
    }

}
