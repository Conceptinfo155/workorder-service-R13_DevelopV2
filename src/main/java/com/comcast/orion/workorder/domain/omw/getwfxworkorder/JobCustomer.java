
package com.comcast.orion.workorder.domain.omw.getwfxworkorder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Details of the customer
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "customerId",
    "siteId",
    "lastName",
    "firstName",
    "homePhoneNum",
    "workPhoneNum",
    "emailAddr"
})
public class JobCustomer {

    /**
     * Customer ID
     * 
     */
    @JsonProperty("customerId")
    @JsonPropertyDescription("Customer ID")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Customer ID", example = "30370000001")
    private String customerId;
    /**
     * Site ID
     * 
     */
    @JsonProperty("siteId")
    @JsonPropertyDescription("Site ID")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Site ID", example = "456456")
    private String siteId;
    /**
     * First Name
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("First Name")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "First Name", example = "Doe")
    private String lastName;
    /**
     * First name
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("First name")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "First name", example = "john")
    private String firstName;
    /**
     * Home Phone Number
     * 
     */
    @JsonProperty("homePhoneNum")
    @JsonPropertyDescription("Home Phone Number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Home Phone Number", example = "7897987")
    private String homePhoneNum;
    /**
     * Work Phone Number
     * 
     */
    @JsonProperty("workPhoneNum")
    @JsonPropertyDescription("Work Phone Number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Work Phone Number", example = "7897987")
    private String workPhoneNum;
    /**
     * Email Address
     * 
     */
    @JsonProperty("emailAddr")
    @JsonPropertyDescription("Email Address")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Email Address", example = "abc@abc.com")
    private String emailAddr;

    /**
     * Customer ID
     * 
     */
    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Customer ID
     * 
     */
    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public JobCustomer withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Site ID
     * 
     */
    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    /**
     * Site ID
     * 
     */
    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public JobCustomer withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    /**
     * First Name
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * First Name
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JobCustomer withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * First name
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public JobCustomer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Home Phone Number
     * 
     */
    @JsonProperty("homePhoneNum")
    public String getHomePhoneNum() {
        return homePhoneNum;
    }

    /**
     * Home Phone Number
     * 
     */
    @JsonProperty("homePhoneNum")
    public void setHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public JobCustomer withHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
        return this;
    }

    /**
     * Work Phone Number
     * 
     */
    @JsonProperty("workPhoneNum")
    public String getWorkPhoneNum() {
        return workPhoneNum;
    }

    /**
     * Work Phone Number
     * 
     */
    @JsonProperty("workPhoneNum")
    public void setWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
    }

    public JobCustomer withWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
        return this;
    }

    /**
     * Email Address
     * 
     */
    @JsonProperty("emailAddr")
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * Email Address
     * 
     */
    @JsonProperty("emailAddr")
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public JobCustomer withEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerId).append(siteId).append(lastName).append(firstName).append(homePhoneNum).append(workPhoneNum).append(emailAddr).toHashCode();
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
        return new EqualsBuilder().append(customerId, rhs.customerId).append(siteId, rhs.siteId).append(lastName, rhs.lastName).append(firstName, rhs.firstName).append(homePhoneNum, rhs.homePhoneNum).append(workPhoneNum, rhs.workPhoneNum).append(emailAddr, rhs.emailAddr).isEquals();
    }

}
