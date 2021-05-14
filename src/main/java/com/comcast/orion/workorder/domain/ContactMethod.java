
package com.comcast.orion.workorder.domain;

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
    "contactMethodType",
    "emailAddress",
    "extension",
    "number"
})
public class ContactMethod {

    /**
     * Contact medium type: Email, Fax, Mobile
     * 
     */
    @JsonProperty("contactMethodType")
    @JsonPropertyDescription("Contact medium type: Email, Fax, Mobile")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Contact medium type: Email, Fax, Mobile", example = "Email")
    private String contactMethodType;
    /**
     * Email id
     * 
     */
    @JsonProperty("emailAddress")
    @JsonPropertyDescription("Email id")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Email id", example = "emailid@email.com")
    private String emailAddress;
    /**
     * Phone or fax extension number
     * 
     */
    @JsonProperty("extension")
    @JsonPropertyDescription("Phone or fax extension number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Phone or fax extension number", example = "1223")
    private String extension;
    /**
     * Phone or fax number
     * 
     */
    @JsonProperty("number")
    @JsonPropertyDescription("Phone or fax number")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Phone or fax number", example = "9789982312")
    private String number;

    /**
     * Contact medium type: Email, Fax, Mobile
     * 
     */
    @JsonProperty("contactMethodType")
    public String getContactMethodType() {
        return contactMethodType;
    }

    /**
     * Contact medium type: Email, Fax, Mobile
     * 
     */
    @JsonProperty("contactMethodType")
    public void setContactMethodType(String contactMethodType) {
        this.contactMethodType = contactMethodType;
    }

    public ContactMethod withContactMethodType(String contactMethodType) {
        this.contactMethodType = contactMethodType;
        return this;
    }

    /**
     * Email id
     * 
     */
    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Email id
     * 
     */
    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ContactMethod withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Phone or fax extension number
     * 
     */
    @JsonProperty("extension")
    public String getExtension() {
        return extension;
    }

    /**
     * Phone or fax extension number
     * 
     */
    @JsonProperty("extension")
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public ContactMethod withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * Phone or fax number
     * 
     */
    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    /**
     * Phone or fax number
     * 
     */
    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
    }

    public ContactMethod withNumber(String number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactMethodType).append(emailAddress).append(extension).append(number).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContactMethod) == false) {
            return false;
        }
        ContactMethod rhs = ((ContactMethod) other);
        return new EqualsBuilder().append(contactMethodType, rhs.contactMethodType).append(emailAddress, rhs.emailAddress).append(extension, rhs.extension).append(number, rhs.number).isEquals();
    }

}
