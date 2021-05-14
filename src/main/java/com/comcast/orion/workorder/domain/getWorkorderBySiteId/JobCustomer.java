
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "DelinquencyStatusCd",
    "CustomerCustomFields",
    "AccountNum",
    "EmailAddr",
    "VipCd",
    "WorkPhoneNum",
    "CustMisc",
    "CurrentBalance",
    "FirstName",
    "HomePhoneNum",
    "BillingAddress",
    "RegistrationCd",
    "DelinquentAmount",
    "LanguageCd",
    "LastName",
    "NumDayDelinquent",
    "CustomerId"
})
public class JobCustomer {

    @JsonProperty("DelinquencyStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object delinquencyStatusCd;
    @JsonProperty("CustomerCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CustomerCustomFields customerCustomFields;
    @JsonProperty("AccountNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String accountNum;
    @JsonProperty("EmailAddr")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String emailAddr;
    @JsonProperty("VipCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object vipCd;
    @JsonProperty("WorkPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object workPhoneNum;
    @JsonProperty("CustMisc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object custMisc;
    @JsonProperty("CurrentBalance")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String currentBalance;
    @JsonProperty("FirstName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String firstName;
    @JsonProperty("HomePhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String homePhoneNum;
    @JsonProperty("BillingAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BillingAddress billingAddress;
    @JsonProperty("RegistrationCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String registrationCd;
    @JsonProperty("DelinquentAmount")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String delinquentAmount;
    @JsonProperty("LanguageCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String languageCd;
    @JsonProperty("LastName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lastName;
    @JsonProperty("NumDayDelinquent")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String numDayDelinquent;
    @JsonProperty("CustomerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerId;

    @JsonProperty("DelinquencyStatusCd")
    public Object getDelinquencyStatusCd() {
        return delinquencyStatusCd;
    }

    @JsonProperty("DelinquencyStatusCd")
    public void setDelinquencyStatusCd(Object delinquencyStatusCd) {
        this.delinquencyStatusCd = delinquencyStatusCd;
    }

    public JobCustomer withDelinquencyStatusCd(Object delinquencyStatusCd) {
        this.delinquencyStatusCd = delinquencyStatusCd;
        return this;
    }

    @JsonProperty("CustomerCustomFields")
    public CustomerCustomFields getCustomerCustomFields() {
        return customerCustomFields;
    }

    @JsonProperty("CustomerCustomFields")
    public void setCustomerCustomFields(CustomerCustomFields customerCustomFields) {
        this.customerCustomFields = customerCustomFields;
    }

    public JobCustomer withCustomerCustomFields(CustomerCustomFields customerCustomFields) {
        this.customerCustomFields = customerCustomFields;
        return this;
    }

    @JsonProperty("AccountNum")
    public String getAccountNum() {
        return accountNum;
    }

    @JsonProperty("AccountNum")
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public JobCustomer withAccountNum(String accountNum) {
        this.accountNum = accountNum;
        return this;
    }

    @JsonProperty("EmailAddr")
    public String getEmailAddr() {
        return emailAddr;
    }

    @JsonProperty("EmailAddr")
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public JobCustomer withEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
        return this;
    }

    @JsonProperty("VipCd")
    public Object getVipCd() {
        return vipCd;
    }

    @JsonProperty("VipCd")
    public void setVipCd(Object vipCd) {
        this.vipCd = vipCd;
    }

    public JobCustomer withVipCd(Object vipCd) {
        this.vipCd = vipCd;
        return this;
    }

    @JsonProperty("WorkPhoneNum")
    public Object getWorkPhoneNum() {
        return workPhoneNum;
    }

    @JsonProperty("WorkPhoneNum")
    public void setWorkPhoneNum(Object workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
    }

    public JobCustomer withWorkPhoneNum(Object workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
        return this;
    }

    @JsonProperty("CustMisc")
    public Object getCustMisc() {
        return custMisc;
    }

    @JsonProperty("CustMisc")
    public void setCustMisc(Object custMisc) {
        this.custMisc = custMisc;
    }

    public JobCustomer withCustMisc(Object custMisc) {
        this.custMisc = custMisc;
        return this;
    }

    @JsonProperty("CurrentBalance")
    public String getCurrentBalance() {
        return currentBalance;
    }

    @JsonProperty("CurrentBalance")
    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public JobCustomer withCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
        return this;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public JobCustomer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("HomePhoneNum")
    public String getHomePhoneNum() {
        return homePhoneNum;
    }

    @JsonProperty("HomePhoneNum")
    public void setHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public JobCustomer withHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
        return this;
    }

    @JsonProperty("BillingAddress")
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    @JsonProperty("BillingAddress")
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public JobCustomer withBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    @JsonProperty("RegistrationCd")
    public String getRegistrationCd() {
        return registrationCd;
    }

    @JsonProperty("RegistrationCd")
    public void setRegistrationCd(String registrationCd) {
        this.registrationCd = registrationCd;
    }

    public JobCustomer withRegistrationCd(String registrationCd) {
        this.registrationCd = registrationCd;
        return this;
    }

    @JsonProperty("DelinquentAmount")
    public String getDelinquentAmount() {
        return delinquentAmount;
    }

    @JsonProperty("DelinquentAmount")
    public void setDelinquentAmount(String delinquentAmount) {
        this.delinquentAmount = delinquentAmount;
    }

    public JobCustomer withDelinquentAmount(String delinquentAmount) {
        this.delinquentAmount = delinquentAmount;
        return this;
    }

    @JsonProperty("LanguageCd")
    public String getLanguageCd() {
        return languageCd;
    }

    @JsonProperty("LanguageCd")
    public void setLanguageCd(String languageCd) {
        this.languageCd = languageCd;
    }

    public JobCustomer withLanguageCd(String languageCd) {
        this.languageCd = languageCd;
        return this;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JobCustomer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("NumDayDelinquent")
    public String getNumDayDelinquent() {
        return numDayDelinquent;
    }

    @JsonProperty("NumDayDelinquent")
    public void setNumDayDelinquent(String numDayDelinquent) {
        this.numDayDelinquent = numDayDelinquent;
    }

    public JobCustomer withNumDayDelinquent(String numDayDelinquent) {
        this.numDayDelinquent = numDayDelinquent;
        return this;
    }

    @JsonProperty("CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("CustomerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public JobCustomer withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(delinquencyStatusCd).append(customerCustomFields).append(accountNum).append(emailAddr).append(vipCd).append(workPhoneNum).append(custMisc).append(currentBalance).append(firstName).append(homePhoneNum).append(billingAddress).append(registrationCd).append(delinquentAmount).append(languageCd).append(lastName).append(numDayDelinquent).append(customerId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobCustomer) == false) {
            return false;
        }
        JobCustomer rhs = ((JobCustomer) other);
        return new EqualsBuilder().append(delinquencyStatusCd, rhs.delinquencyStatusCd).append(customerCustomFields, rhs.customerCustomFields).append(accountNum, rhs.accountNum).append(emailAddr, rhs.emailAddr).append(vipCd, rhs.vipCd).append(workPhoneNum, rhs.workPhoneNum).append(custMisc, rhs.custMisc).append(currentBalance, rhs.currentBalance).append(firstName, rhs.firstName).append(homePhoneNum, rhs.homePhoneNum).append(billingAddress, rhs.billingAddress).append(registrationCd, rhs.registrationCd).append(delinquentAmount, rhs.delinquentAmount).append(languageCd, rhs.languageCd).append(lastName, rhs.lastName).append(numDayDelinquent, rhs.numDayDelinquent).append(customerId, rhs.customerId).isEquals();
    }

}
