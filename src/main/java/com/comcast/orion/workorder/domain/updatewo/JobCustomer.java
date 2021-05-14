
package com.comcast.orion.workorder.domain.updatewo;

import javax.validation.constraints.Size;
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
     * Amdocs CustomerId passed by Amdocs - WFX
     * 
     */
    @JsonProperty("customerId")
    @JsonPropertyDescription("Amdocs CustomerId passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "Amdocs CustomerId passed by Amdocs - WFX", example = "30370000001")
    @Size(min = 1, max = 25)
    private String customerId;
    /**
     * Site Id passed by Amdocs - WFX
     * 
     */
    @JsonProperty("siteId")
    @JsonPropertyDescription("Site Id passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Site Id passed by Amdocs - WFX", example = "8562631979")
    @Size(min = 0, max = 20)
    private String siteId;
    /**
     * Amdocs LastName passed by Amdocs - WFX
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("Amdocs LastName passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "Amdocs LastName passed by Amdocs - WFX", example = "TR")
    @Size(min = 1, max = 50)
    private String lastName;
    /**
     * Amdocs FirstName passed by Amdocs - WFX
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("Amdocs FirstName passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "Amdocs FirstName passed by Amdocs - WFX", example = "Karthik")
    @Size(min = 0, max = 50)
    private String firstName;
    /**
     * Amdocs HomePhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("homePhoneNum")
    @JsonPropertyDescription("Amdocs HomePhoneNum passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 6, value = "Amdocs HomePhoneNum passed by Amdocs - WFX", example = "8562631979")
    @Size(min = 0, max = 20)
    private String homePhoneNum;
    /**
     * Amdocs WorkPhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("workPhoneNum")
    @JsonPropertyDescription("Amdocs WorkPhoneNum passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "Amdocs WorkPhoneNum passed by Amdocs - WFX", example = "8562631979")
    @Size(min = 0, max = 20)
    private String workPhoneNum;
    /**
     * Amdocs EmailAddr passed by Amdocs - WFX
     * 
     */
    @JsonProperty("emailAddr")
    @JsonPropertyDescription("Amdocs EmailAddr passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 5, value = "Amdocs EmailAddr passed by Amdocs - WFX", example = "abc@abc.com")
    @Size(min = 0, max = 320)
    private String emailAddr;

    /**
     * Amdocs CustomerId passed by Amdocs - WFX
     * 
     */
    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Amdocs CustomerId passed by Amdocs - WFX
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
     * Site Id passed by Amdocs - WFX
     * 
     */
    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    /**
     * Site Id passed by Amdocs - WFX
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
     * Amdocs LastName passed by Amdocs - WFX
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * Amdocs LastName passed by Amdocs - WFX
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
     * Amdocs FirstName passed by Amdocs - WFX
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Amdocs FirstName passed by Amdocs - WFX
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
     * Amdocs HomePhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("homePhoneNum")
    public String getHomePhoneNum() {
        return homePhoneNum;
    }

    /**
     * Amdocs HomePhoneNum passed by Amdocs - WFX
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
     * Amdocs WorkPhoneNum passed by Amdocs - WFX
     * 
     */
    @JsonProperty("workPhoneNum")
    public String getWorkPhoneNum() {
        return workPhoneNum;
    }

    /**
     * Amdocs WorkPhoneNum passed by Amdocs - WFX
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
     * Amdocs EmailAddr passed by Amdocs - WFX
     * 
     */
    @JsonProperty("emailAddr")
    public String getEmailAddr() {
        return emailAddr;
    }

    /**
     * Amdocs EmailAddr passed by Amdocs - WFX
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
