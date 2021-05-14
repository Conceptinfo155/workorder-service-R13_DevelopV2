
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

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
 * The Jobcustomer Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "HomePhoneNum",
    "CustomerId",
    "WorkPhoneNum",
    "AccountNum",
    "FirstName",
    "NumDayDelinquent",
    "CustomerCustomFields",
    "LastName",
    "CurrentBalance",
    "EmailAddr",
    "DelinquencyStatusCd",
    "DelinquentAmount",
    "VipCd",
    "CustMisc",
    "RegistrationCd",
    "LanguageCd"
})
public class JobCustomer {

    /**
     * The Homephonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HomePhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String homePhoneNum = "";
    /**
     * The Customerid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String customerId = "";
    /**
     * The Workphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String workPhoneNum = "";
    /**
     * The Accountnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String accountNum = "";
    /**
     * The Firstname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FirstName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String firstName = "";
    /**
     * The Numdaydelinquent Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("NumDayDelinquent")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object numDayDelinquent = null;
    /**
     * The Customercustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private CustomerCustomFields customerCustomFields;
    /**
     * The Lastname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String lastName = "";
    /**
     * The Currentbalance Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CurrentBalance")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object currentBalance = null;
    /**
     * The Emailaddr Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EmailAddr")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String emailAddr = "";
    /**
     * The Delinquencystatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquencyStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object delinquencyStatusCd = null;
    /**
     * The Delinquentamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquentAmount")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object delinquentAmount = null;
    /**
     * The Vipcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("VipCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object vipCd = null;
    /**
     * The Custmisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustMisc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object custMisc = null;
    /**
     * The Registrationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RegistrationCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object registrationCd = null;
    /**
     * The Languagecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LanguageCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object languageCd = null;

    /**
     * The Homephonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HomePhoneNum")
    public String getHomePhoneNum() {
        return homePhoneNum;
    }

    /**
     * The Homephonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HomePhoneNum")
    public void setHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public JobCustomer withHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
        return this;
    }

    /**
     * The Customerid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * The Customerid Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public JobCustomer withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * The Workphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkPhoneNum")
    public String getWorkPhoneNum() {
        return workPhoneNum;
    }

    /**
     * The Workphonenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("WorkPhoneNum")
    public void setWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
    }

    public JobCustomer withWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
        return this;
    }

    /**
     * The Accountnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNum")
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * The Accountnum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("AccountNum")
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public JobCustomer withAccountNum(String accountNum) {
        this.accountNum = accountNum;
        return this;
    }

    /**
     * The Firstname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The Firstname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public JobCustomer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The Numdaydelinquent Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("NumDayDelinquent")
    public Object getNumDayDelinquent() {
        return numDayDelinquent;
    }

    /**
     * The Numdaydelinquent Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("NumDayDelinquent")
    public void setNumDayDelinquent(Object numDayDelinquent) {
        this.numDayDelinquent = numDayDelinquent;
    }

    public JobCustomer withNumDayDelinquent(Object numDayDelinquent) {
        this.numDayDelinquent = numDayDelinquent;
        return this;
    }

    /**
     * The Customercustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerCustomFields")
    public CustomerCustomFields getCustomerCustomFields() {
        return customerCustomFields;
    }

    /**
     * The Customercustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustomerCustomFields")
    public void setCustomerCustomFields(CustomerCustomFields customerCustomFields) {
        this.customerCustomFields = customerCustomFields;
    }

    public JobCustomer withCustomerCustomFields(CustomerCustomFields customerCustomFields) {
        this.customerCustomFields = customerCustomFields;
        return this;
    }

    /**
     * The Lastname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * The Lastname Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JobCustomer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The Currentbalance Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CurrentBalance")
    public Object getCurrentBalance() {
        return currentBalance;
    }

    /**
     * The Currentbalance Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CurrentBalance")
    public void setCurrentBalance(Object currentBalance) {
        this.currentBalance = currentBalance;
    }

    public JobCustomer withCurrentBalance(Object currentBalance) {
        this.currentBalance = currentBalance;
        return this;
    }

    /**
     * The Emailaddr Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EmailAddr")
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * The Emailaddr Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("EmailAddr")
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public JobCustomer withEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
        return this;
    }

    /**
     * The Delinquencystatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquencyStatusCd")
    public Object getDelinquencyStatusCd() {
        return delinquencyStatusCd;
    }

    /**
     * The Delinquencystatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquencyStatusCd")
    public void setDelinquencyStatusCd(Object delinquencyStatusCd) {
        this.delinquencyStatusCd = delinquencyStatusCd;
    }

    public JobCustomer withDelinquencyStatusCd(Object delinquencyStatusCd) {
        this.delinquencyStatusCd = delinquencyStatusCd;
        return this;
    }

    /**
     * The Delinquentamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquentAmount")
    public Object getDelinquentAmount() {
        return delinquentAmount;
    }

    /**
     * The Delinquentamount Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DelinquentAmount")
    public void setDelinquentAmount(Object delinquentAmount) {
        this.delinquentAmount = delinquentAmount;
    }

    public JobCustomer withDelinquentAmount(Object delinquentAmount) {
        this.delinquentAmount = delinquentAmount;
        return this;
    }

    /**
     * The Vipcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("VipCd")
    public Object getVipCd() {
        return vipCd;
    }

    /**
     * The Vipcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("VipCd")
    public void setVipCd(Object vipCd) {
        this.vipCd = vipCd;
    }

    public JobCustomer withVipCd(Object vipCd) {
        this.vipCd = vipCd;
        return this;
    }

    /**
     * The Custmisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustMisc")
    public Object getCustMisc() {
        return custMisc;
    }

    /**
     * The Custmisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CustMisc")
    public void setCustMisc(Object custMisc) {
        this.custMisc = custMisc;
    }

    public JobCustomer withCustMisc(Object custMisc) {
        this.custMisc = custMisc;
        return this;
    }

    /**
     * The Registrationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RegistrationCd")
    public Object getRegistrationCd() {
        return registrationCd;
    }

    /**
     * The Registrationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RegistrationCd")
    public void setRegistrationCd(Object registrationCd) {
        this.registrationCd = registrationCd;
    }

    public JobCustomer withRegistrationCd(Object registrationCd) {
        this.registrationCd = registrationCd;
        return this;
    }

    /**
     * The Languagecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LanguageCd")
    public Object getLanguageCd() {
        return languageCd;
    }

    /**
     * The Languagecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LanguageCd")
    public void setLanguageCd(Object languageCd) {
        this.languageCd = languageCd;
    }

    public JobCustomer withLanguageCd(Object languageCd) {
        this.languageCd = languageCd;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(homePhoneNum).append(customerId).append(workPhoneNum).append(accountNum).append(firstName).append(numDayDelinquent).append(customerCustomFields).append(lastName).append(currentBalance).append(emailAddr).append(delinquencyStatusCd).append(delinquentAmount).append(vipCd).append(custMisc).append(registrationCd).append(languageCd).toHashCode();
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
        return new EqualsBuilder().append(homePhoneNum, rhs.homePhoneNum).append(customerId, rhs.customerId).append(workPhoneNum, rhs.workPhoneNum).append(accountNum, rhs.accountNum).append(firstName, rhs.firstName).append(numDayDelinquent, rhs.numDayDelinquent).append(customerCustomFields, rhs.customerCustomFields).append(lastName, rhs.lastName).append(currentBalance, rhs.currentBalance).append(emailAddr, rhs.emailAddr).append(delinquencyStatusCd, rhs.delinquencyStatusCd).append(delinquentAmount, rhs.delinquentAmount).append(vipCd, rhs.vipCd).append(custMisc, rhs.custMisc).append(registrationCd, rhs.registrationCd).append(languageCd, rhs.languageCd).isEquals();
    }

}
