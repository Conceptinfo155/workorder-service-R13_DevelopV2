
package com.comcast.orion.workorder.domain.getorderdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "customerAccountContacts",
    "customerIndustry",
    "customerAccountStatus",
    "customerRelationshipOwner",
    "customerSpecialPopulation",
    "customerSubIndustry",
    "customerSubtype",
    "customerType",
    "customerLegalName",
    "customerName",
    "blendedCustomer",
    "requestTaxExemption",
    "customerAddress",
    "customerSiteCount",
    "customerSegmentation",
    "creditCheck",
    "customerStatus",
    "customerActivationDate",
    "customerLastDisconnectDate",
    "collectionIndicator",
    "errors"
})
public class CustomerAccountResponse {

    @JsonProperty("customerAccountContacts")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 12, value = "", example = "")
    @Valid
    private List<CustomerAccountContact> customerAccountContacts = new ArrayList<CustomerAccountContact>();
    @JsonProperty("customerIndustry")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 6, value = "", example = "")
    private CustomerIndustry customerIndustry;
    /**
     * The status of the customer - Pending, Active, Tentative, Inactive
     * 
     */
    @JsonProperty("customerAccountStatus")
    @JsonPropertyDescription("The status of the customer - Pending, Active, Tentative, Inactive")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "The status of the customer - Pending, Active, Tentative, Inactive", example = "string")
    private String customerAccountStatus;
    @JsonProperty("customerRelationshipOwner")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 9, value = "", example = "")
    private CustomerRelationshipOwner customerRelationshipOwner;
    @JsonProperty("customerSpecialPopulation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 8, value = "", example = "")
    private CustomerSpecialPopulation customerSpecialPopulation;
    @JsonProperty("customerSubIndustry")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 7, value = "", example = "")
    private CustomerSubIndustry customerSubIndustry;
    @JsonProperty("customerSubtype")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 5, value = "", example = "")
    private CustomerSubtype customerSubtype;
    @JsonProperty("customerType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 4, value = "", example = "")
    private CustomerType customerType;
    /**
     * The legal name of the customer
     * 
     */
    @JsonProperty("customerLegalName")
    @JsonPropertyDescription("The legal name of the customer")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "The legal name of the customer", example = "Stark Industries")
    private String customerLegalName;
    /**
     * The name of the customer
     * 
     */
    @JsonProperty("customerName")
    @JsonPropertyDescription("The name of the customer")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "The name of the customer", example = "Stark Industries")
    private String customerName;
    /**
     * Blended Customer
     * 
     */
    @JsonProperty("blendedCustomer")
    @JsonPropertyDescription("Blended Customer")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "Blended Customer", example = "true")
    private Boolean blendedCustomer;
    /**
     * Yes means customer has requested for tax exemption. No means customer has not requested for tax exemption 
     * 
     */
    @JsonProperty("requestTaxExemption")
    @JsonPropertyDescription("Yes means customer has requested for tax exemption. No means customer has not requested for tax exemption ")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Yes means customer has requested for tax exemption. No means customer has not requested for tax exemption ", example = "Yes")
    private String requestTaxExemption;
    @JsonProperty("customerAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 10, value = "", example = "")
    @Valid
    private CustomerAddress customerAddress;
    @JsonProperty("customerSiteCount")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 13, value = "", example = "")
    @Valid
    private CustomerSiteCount customerSiteCount;
    /**
     * Segmentation of the Customer
     * 
     */
    @JsonProperty("customerSegmentation")
    @JsonPropertyDescription("Segmentation of the Customer")
    @ApiModelProperty(required = false, dataType = "string", position = 14, value = "Segmentation of the Customer", example = "MM")
    private String customerSegmentation;
    /**
     * Credit Check of the Customer
     * 
     */
    @JsonProperty("creditCheck")
    @JsonPropertyDescription("Credit Check of the Customer")
    @ApiModelProperty(required = false, dataType = "object", position = 15, value = "Credit Check of the Customer", example = "Unit 1")
    @Valid
    private CreditCheck creditCheck;
    /**
     * Customer Status(New/Active/Disconnect)
     * 
     */
    @JsonProperty("customerStatus")
    @JsonPropertyDescription("Customer Status(New/Active/Disconnect)")
    @ApiModelProperty(required = false, dataType = "string", position = 16, value = "Customer Status(New/Active/Disconnect)", example = "Unit 1")
    private String customerStatus;
    /**
     * Customers Activation Date
     * 
     */
    @JsonProperty("customerActivationDate")
    @JsonPropertyDescription("Customers Activation Date")
    @ApiModelProperty(required = false, dataType = "string", position = 17, value = "Customers Activation Date", example = "06/14/2019")
    private String customerActivationDate;
    /**
     * Customers Last Disconnected Date
     * 
     */
    @JsonProperty("customerLastDisconnectDate")
    @JsonPropertyDescription("Customers Last Disconnected Date")
    @ApiModelProperty(required = false, dataType = "string", position = 18, value = "Customers Last Disconnected Date", example = "06/12/2019")
    private String customerLastDisconnectDate;
    /**
     * Collection Indicator
     * 
     */
    @JsonProperty("collectionIndicator")
    @JsonPropertyDescription("Collection Indicator")
    @ApiModelProperty(required = false, dataType = "boolean", position = 19, value = "Collection Indicator", example = "true")
    private Boolean collectionIndicator;
    /**
     * BillCycle Frequency
     * 
     */
   
    @JsonProperty("errors")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Error> errors = new ArrayList<Error>();

    @JsonProperty("customerAccountContacts")
    public List<CustomerAccountContact> getCustomerAccountContacts() {
        return customerAccountContacts;
    }

    @JsonProperty("customerAccountContacts")
    public void setCustomerAccountContacts(List<CustomerAccountContact> customerAccountContacts) {
        this.customerAccountContacts = customerAccountContacts;
    }

    public CustomerAccountResponse withCustomerAccountContacts(List<CustomerAccountContact> customerAccountContacts) {
        this.customerAccountContacts = customerAccountContacts;
        return this;
    }

    @JsonProperty("customerIndustry")
    public CustomerIndustry getCustomerIndustry() {
        return customerIndustry;
    }

    @JsonProperty("customerIndustry")
    public void setCustomerIndustry(CustomerIndustry customerIndustry) {
        this.customerIndustry = customerIndustry;
    }

    public CustomerAccountResponse withCustomerIndustry(CustomerIndustry customerIndustry) {
        this.customerIndustry = customerIndustry;
        return this;
    }

    /**
     * The status of the customer - Pending, Active, Tentative, Inactive
     * 
     */
    @JsonProperty("customerAccountStatus")
    public String getCustomerAccountStatus() {
        return customerAccountStatus;
    }

    /**
     * The status of the customer - Pending, Active, Tentative, Inactive
     * 
     */
    @JsonProperty("customerAccountStatus")
    public void setCustomerAccountStatus(String customerAccountStatus) {
        this.customerAccountStatus = customerAccountStatus;
    }

    public CustomerAccountResponse withCustomerAccountStatus(String customerAccountStatus) {
        this.customerAccountStatus = customerAccountStatus;
        return this;
    }

    @JsonProperty("customerRelationshipOwner")
    public CustomerRelationshipOwner getCustomerRelationshipOwner() {
        return customerRelationshipOwner;
    }

    @JsonProperty("customerRelationshipOwner")
    public void setCustomerRelationshipOwner(CustomerRelationshipOwner customerRelationshipOwner) {
        this.customerRelationshipOwner = customerRelationshipOwner;
    }

    public CustomerAccountResponse withCustomerRelationshipOwner(CustomerRelationshipOwner customerRelationshipOwner) {
        this.customerRelationshipOwner = customerRelationshipOwner;
        return this;
    }

    @JsonProperty("customerSpecialPopulation")
    public CustomerSpecialPopulation getCustomerSpecialPopulation() {
        return customerSpecialPopulation;
    }

    @JsonProperty("customerSpecialPopulation")
    public void setCustomerSpecialPopulation(CustomerSpecialPopulation customerSpecialPopulation) {
        this.customerSpecialPopulation = customerSpecialPopulation;
    }

    public CustomerAccountResponse withCustomerSpecialPopulation(CustomerSpecialPopulation customerSpecialPopulation) {
        this.customerSpecialPopulation = customerSpecialPopulation;
        return this;
    }

    @JsonProperty("customerSubIndustry")
    public CustomerSubIndustry getCustomerSubIndustry() {
        return customerSubIndustry;
    }

    @JsonProperty("customerSubIndustry")
    public void setCustomerSubIndustry(CustomerSubIndustry customerSubIndustry) {
        this.customerSubIndustry = customerSubIndustry;
    }

    public CustomerAccountResponse withCustomerSubIndustry(CustomerSubIndustry customerSubIndustry) {
        this.customerSubIndustry = customerSubIndustry;
        return this;
    }

    @JsonProperty("customerSubtype")
    public CustomerSubtype getCustomerSubtype() {
        return customerSubtype;
    }

    @JsonProperty("customerSubtype")
    public void setCustomerSubtype(CustomerSubtype customerSubtype) {
        this.customerSubtype = customerSubtype;
    }

    public CustomerAccountResponse withCustomerSubtype(CustomerSubtype customerSubtype) {
        this.customerSubtype = customerSubtype;
        return this;
    }

    @JsonProperty("customerType")
    public CustomerType getCustomerType() {
        return customerType;
    }

    @JsonProperty("customerType")
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerAccountResponse withCustomerType(CustomerType customerType) {
        this.customerType = customerType;
        return this;
    }

    /**
     * The legal name of the customer
     * 
     */
    @JsonProperty("customerLegalName")
    public String getCustomerLegalName() {
        return customerLegalName;
    }

    /**
     * The legal name of the customer
     * 
     */
    @JsonProperty("customerLegalName")
    public void setCustomerLegalName(String customerLegalName) {
        this.customerLegalName = customerLegalName;
    }

    public CustomerAccountResponse withCustomerLegalName(String customerLegalName) {
        this.customerLegalName = customerLegalName;
        return this;
    }

    /**
     * The name of the customer
     * 
     */
    @JsonProperty("customerName")
    public String getCustomerName() {
        return customerName;
    }

    /**
     * The name of the customer
     * 
     */
    @JsonProperty("customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerAccountResponse withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    /**
     * Blended Customer
     * 
     */
    @JsonProperty("blendedCustomer")
    public Boolean getBlendedCustomer() {
        return blendedCustomer;
    }

    /**
     * Blended Customer
     * 
     */
    @JsonProperty("blendedCustomer")
    public void setBlendedCustomer(Boolean blendedCustomer) {
        this.blendedCustomer = blendedCustomer;
    }

    public CustomerAccountResponse withBlendedCustomer(Boolean blendedCustomer) {
        this.blendedCustomer = blendedCustomer;
        return this;
    }

    /**
     * Yes means customer has requested for tax exemption. No means customer has not requested for tax exemption 
     * 
     */
    @JsonProperty("requestTaxExemption")
    public String getRequestTaxExemption() {
        return requestTaxExemption;
    }

    /**
     * Yes means customer has requested for tax exemption. No means customer has not requested for tax exemption 
     * 
     */
    @JsonProperty("requestTaxExemption")
    public void setRequestTaxExemption(String requestTaxExemption) {
        this.requestTaxExemption = requestTaxExemption;
    }

    public CustomerAccountResponse withRequestTaxExemption(String requestTaxExemption) {
        this.requestTaxExemption = requestTaxExemption;
        return this;
    }

    @JsonProperty("customerAddress")
    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    @JsonProperty("customerAddress")
    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerAccountResponse withCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
        return this;
    }

    @JsonProperty("customerSiteCount")
    public CustomerSiteCount getCustomerSiteCount() {
        return customerSiteCount;
    }

    @JsonProperty("customerSiteCount")
    public void setCustomerSiteCount(CustomerSiteCount customerSiteCount) {
        this.customerSiteCount = customerSiteCount;
    }

    public CustomerAccountResponse withCustomerSiteCount(CustomerSiteCount customerSiteCount) {
        this.customerSiteCount = customerSiteCount;
        return this;
    }

    /**
     * Segmentation of the Customer
     * 
     */
    @JsonProperty("customerSegmentation")
    public String getCustomerSegmentation() {
        return customerSegmentation;
    }

    /**
     * Segmentation of the Customer
     * 
     */
    @JsonProperty("customerSegmentation")
    public void setCustomerSegmentation(String customerSegmentation) {
        this.customerSegmentation = customerSegmentation;
    }

    public CustomerAccountResponse withCustomerSegmentation(String customerSegmentation) {
        this.customerSegmentation = customerSegmentation;
        return this;
    }

    /**
     * Credit Check of the Customer
     * 
     */
    @JsonProperty("creditCheck")
    public CreditCheck getCreditCheck() {
        return creditCheck;
    }

    /**
     * Credit Check of the Customer
     * 
     */
    @JsonProperty("creditCheck")
    public void setCreditCheck(CreditCheck creditCheck) {
        this.creditCheck = creditCheck;
    }

    public CustomerAccountResponse withCreditCheck(CreditCheck creditCheck) {
        this.creditCheck = creditCheck;
        return this;
    }

    /**
     * Customer Status(New/Active/Disconnect)
     * 
     */
    @JsonProperty("customerStatus")
    public String getCustomerStatus() {
        return customerStatus;
    }

    /**
     * Customer Status(New/Active/Disconnect)
     * 
     */
    @JsonProperty("customerStatus")
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerAccountResponse withCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
        return this;
    }

    /**
     * Customers Activation Date
     * 
     */
    @JsonProperty("customerActivationDate")
    public String getCustomerActivationDate() {
        return customerActivationDate;
    }

    /**
     * Customers Activation Date
     * 
     */
    @JsonProperty("customerActivationDate")
    public void setCustomerActivationDate(String customerActivationDate) {
        this.customerActivationDate = customerActivationDate;
    }

    public CustomerAccountResponse withCustomerActivationDate(String customerActivationDate) {
        this.customerActivationDate = customerActivationDate;
        return this;
    }

    /**
     * Customers Last Disconnected Date
     * 
     */
    @JsonProperty("customerLastDisconnectDate")
    public String getCustomerLastDisconnectDate() {
        return customerLastDisconnectDate;
    }

    /**
     * Customers Last Disconnected Date
     * 
     */
    @JsonProperty("customerLastDisconnectDate")
    public void setCustomerLastDisconnectDate(String customerLastDisconnectDate) {
        this.customerLastDisconnectDate = customerLastDisconnectDate;
    }

    public CustomerAccountResponse withCustomerLastDisconnectDate(String customerLastDisconnectDate) {
        this.customerLastDisconnectDate = customerLastDisconnectDate;
        return this;
    }

    /**
     * Collection Indicator
     * 
     */
    @JsonProperty("collectionIndicator")
    public Boolean getCollectionIndicator() {
        return collectionIndicator;
    }

    /**
     * Collection Indicator
     * 
     */
    @JsonProperty("collectionIndicator")
    public void setCollectionIndicator(Boolean collectionIndicator) {
        this.collectionIndicator = collectionIndicator;
    }

    public CustomerAccountResponse withCollectionIndicator(Boolean collectionIndicator) {
        this.collectionIndicator = collectionIndicator;
        return this;
    }

    /**
     * BillCycle Frequency
     * 
     */
   

    
  

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public CustomerAccountResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerAccountContacts).append(customerIndustry).append(customerAccountStatus).append(customerRelationshipOwner).append(customerSpecialPopulation).append(customerSubIndustry).append(customerSubtype).append(customerType).append(customerLegalName).append(customerName).append(blendedCustomer).append(requestTaxExemption).append(customerAddress).append(customerSiteCount).append(customerSegmentation).append(creditCheck).append(customerStatus).append(customerActivationDate).append(customerLastDisconnectDate).append(collectionIndicator).append(errors).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAccountResponse) == false) {
            return false;
        }
        CustomerAccountResponse rhs = ((CustomerAccountResponse) other);
        return new EqualsBuilder().append(customerAccountContacts, rhs.customerAccountContacts).append(customerIndustry, rhs.customerIndustry).append(customerAccountStatus, rhs.customerAccountStatus).append(customerRelationshipOwner, rhs.customerRelationshipOwner).append(customerSpecialPopulation, rhs.customerSpecialPopulation).append(customerSubIndustry, rhs.customerSubIndustry).append(customerSubtype, rhs.customerSubtype).append(customerType, rhs.customerType).append(customerLegalName, rhs.customerLegalName).append(customerName, rhs.customerName).append(blendedCustomer, rhs.blendedCustomer).append(requestTaxExemption, rhs.requestTaxExemption).append(customerAddress, rhs.customerAddress).append(customerSiteCount, rhs.customerSiteCount).append(customerSegmentation, rhs.customerSegmentation).append(creditCheck, rhs.creditCheck).append(customerStatus, rhs.customerStatus).append(customerActivationDate, rhs.customerActivationDate).append(customerLastDisconnectDate, rhs.customerLastDisconnectDate).append(collectionIndicator, rhs.collectionIndicator).append(errors, rhs.errors).isEquals();
    }

}
