
package com.comcast.orion.workorder.domain.product.response;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
    "customerName",
    "customerType",
    "customerAccountNumber",
    "lineOfBusiness",
    "crmCustomerId",
    "customerCRMSystem",
    "characteristics",
    "site"
})
public class Customer {

    @JsonProperty("customerName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerName;
    @JsonProperty("customerType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerType;
    @JsonProperty("customerAccountNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerAccountNumber;
    @JsonProperty("lineOfBusiness")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lineOfBusiness;
    @JsonProperty("crmCustomerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String crmCustomerId;
    @JsonProperty("customerCRMSystem")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerCRMSystem;
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic> characteristics = new ArrayList<Characteristic>();
    @JsonProperty("site")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Site> site = new ArrayList<Site>();

    @JsonProperty("customerName")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty("customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Customer withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    @JsonProperty("customerType")
    public String getCustomerType() {
        return customerType;
    }

    @JsonProperty("customerType")
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Customer withCustomerType(String customerType) {
        this.customerType = customerType;
        return this;
    }

    @JsonProperty("customerAccountNumber")
    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    @JsonProperty("customerAccountNumber")
    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public Customer withCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
        return this;
    }

    @JsonProperty("lineOfBusiness")
    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    @JsonProperty("lineOfBusiness")
    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public Customer withLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
        return this;
    }

    @JsonProperty("crmCustomerId")
    public String getCrmCustomerId() {
        return crmCustomerId;
    }

    @JsonProperty("crmCustomerId")
    public void setCrmCustomerId(String crmCustomerId) {
        this.crmCustomerId = crmCustomerId;
    }

    public Customer withCrmCustomerId(String crmCustomerId) {
        this.crmCustomerId = crmCustomerId;
        return this;
    }

    @JsonProperty("customerCRMSystem")
    public String getCustomerCRMSystem() {
        return customerCRMSystem;
    }

    @JsonProperty("customerCRMSystem")
    public void setCustomerCRMSystem(String customerCRMSystem) {
        this.customerCRMSystem = customerCRMSystem;
    }

    public Customer withCustomerCRMSystem(String customerCRMSystem) {
        this.customerCRMSystem = customerCRMSystem;
        return this;
    }

    @JsonProperty("characteristics")
    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("characteristics")
    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Customer withCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @JsonProperty("site")
    public List<Site> getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(List<Site> site) {
        this.site = site;
    }

    public Customer withSite(List<Site> site) {
        this.site = site;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerName).append(customerType).append(customerAccountNumber).append(lineOfBusiness).append(crmCustomerId).append(customerCRMSystem).append(characteristics).append(site).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(customerName, rhs.customerName).append(customerType, rhs.customerType).append(customerAccountNumber, rhs.customerAccountNumber).append(lineOfBusiness, rhs.lineOfBusiness).append(crmCustomerId, rhs.crmCustomerId).append(customerCRMSystem, rhs.customerCRMSystem).append(characteristics, rhs.characteristics).append(site, rhs.site).isEquals();
    }

}
