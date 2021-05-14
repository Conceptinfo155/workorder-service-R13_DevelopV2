
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

import javax.validation.constraints.NotNull;
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
    "emailAddr",
    "siteSignageName"
})
public class JobCustomer {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("customerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "4136500222")
    @Size(min = 1, max = 10)
    private String customerId;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("siteId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "Site_0981098")
    @Size(min = 1, max = 20)
    private String siteId;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("lastName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "Venkata")
    @Size(min = 1, max = 50)
    private String lastName;
    @JsonProperty("firstName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "Harish")
    @Size(min = 1, max = 50)
    private String firstName;
    @JsonProperty("homePhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "4136500222")
    @Size(min = 1, max = 20)
    private String homePhoneNum;
    @JsonProperty("workPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "4136500222")
    @Size(min = 1, max = 20)
    private String workPhoneNum;
    @JsonProperty("emailAddr")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "admin@abc.com")
    @Size(min = 1, max = 320)
    private String emailAddr;
    @JsonProperty("siteSignageName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "site signage name")
    @Size(min = 0, max = 80)
    private String siteSignageName;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 
     * (Required)
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    /**
     * 
     * (Required)
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * (Required)
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

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public JobCustomer withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("homePhoneNum")
    public String getHomePhoneNum() {
        return homePhoneNum;
    }

    @JsonProperty("homePhoneNum")
    public void setHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
    }

    public JobCustomer withHomePhoneNum(String homePhoneNum) {
        this.homePhoneNum = homePhoneNum;
        return this;
    }

    @JsonProperty("workPhoneNum")
    public String getWorkPhoneNum() {
        return workPhoneNum;
    }

    @JsonProperty("workPhoneNum")
    public void setWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
    }

    public JobCustomer withWorkPhoneNum(String workPhoneNum) {
        this.workPhoneNum = workPhoneNum;
        return this;
    }

    @JsonProperty("emailAddr")
    public String getEmailAddr() {
        return emailAddr;
    }

    @JsonProperty("emailAddr")
    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public JobCustomer withEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
        return this;
    }

    @JsonProperty("siteSignageName")
    public String getSiteSignageName() {
        return siteSignageName;
    }

    @JsonProperty("siteSignageName")
    public void setSiteSignageName(String siteSignageName) {
        this.siteSignageName = siteSignageName;
    }

    public JobCustomer withSiteSignageName(String siteSignageName) {
        this.siteSignageName = siteSignageName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerId).append(siteId).append(lastName).append(firstName).append(homePhoneNum).append(workPhoneNum).append(emailAddr).append(siteSignageName).toHashCode();
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
        return new EqualsBuilder().append(customerId, rhs.customerId).append(siteId, rhs.siteId).append(lastName, rhs.lastName).append(firstName, rhs.firstName).append(homePhoneNum, rhs.homePhoneNum).append(workPhoneNum, rhs.workPhoneNum).append(siteSignageName, rhs.siteSignageName).isEquals();
    }

}
