
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
    "contactMethods",
    "contactId",
    "lastName",
    "firstName",
    "middleName",
    "displayName",
    "title",
    "preferredLanguage",
    "preferredContactMethod",
    "preferredContactPeriod",
    "preferredContactTime",
    "role"
})
public class CustomerAccountContact {

    @JsonProperty("contactMethods")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 13, value = "", example = "")
    @Valid
    private List<ContactMethod> contactMethods = new ArrayList<ContactMethod>();
    /**
     * The Amdocs Contact ID
     * 
     */
    @JsonProperty("contactId")
    @JsonPropertyDescription("The Amdocs Contact ID")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "The Amdocs Contact ID", example = "124378769")
    private String contactId;
    /**
     * The family (last) name of the individual
     * 
     */
    @JsonProperty("lastName")
    @JsonPropertyDescription("The family (last) name of the individual")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "The family (last) name of the individual", example = "Stark")
    private String lastName;
    /**
     * The first (given) name of the individual
     * 
     */
    @JsonProperty("firstName")
    @JsonPropertyDescription("The first (given) name of the individual")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "The first (given) name of the individual", example = "Sansa")
    private String firstName;
    /**
     * The middle name of the individual
     * 
     */
    @JsonProperty("middleName")
    @JsonPropertyDescription("The middle name of the individual")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "The middle name of the individual", example = "Eddard")
    private String middleName;
    /**
     * The formatted name of the Individual
     * 
     */
    @JsonProperty("displayName")
    @JsonPropertyDescription("The formatted name of the Individual")
    @ApiModelProperty(required = false, dataType = "string", position = 5, value = "The formatted name of the Individual", example = "Sansa Stark")
    private String displayName;
    /**
     * Title for individuals name. Eg. Mr. Dr. etc
     * 
     */
    @JsonProperty("title")
    @JsonPropertyDescription("Title for individuals name. Eg. Mr. Dr. etc")
    @ApiModelProperty(required = false, dataType = "string", position = 7, value = "Title for individuals name. Eg. Mr. Dr. etc", example = "Mr")
    private String title;
    /**
     * The preferred Language for the contact
     * 
     */
    @JsonProperty("preferredLanguage")
    @JsonPropertyDescription("The preferred Language for the contact")
    @ApiModelProperty(required = false, dataType = "string", position = 12, value = "The preferred Language for the contact", example = "English (United States)")
    private String preferredLanguage;
    /**
     * The preferred contact method of the individual - Email, Phone, Fax, Postal
     * 
     */
    @JsonProperty("preferredContactMethod")
    @JsonPropertyDescription("The preferred contact method of the individual - Email, Phone, Fax, Postal")
    @ApiModelProperty(required = false, dataType = "string", position = 9, value = "The preferred contact method of the individual - Email, Phone, Fax, Postal", example = "Email")
    private String preferredContactMethod;
    /**
     * The preferred contact period of the individual - For Example: Morning, Afternoon, Evening, Midday
     * 
     */
    @JsonProperty("preferredContactPeriod")
    @JsonPropertyDescription("The preferred contact period of the individual - For Example: Morning, Afternoon, Evening, Midday")
    @ApiModelProperty(required = false, dataType = "string", position = 10, value = "The preferred contact period of the individual - For Example: Morning, Afternoon, Evening, Midday", example = "Morning")
    private String preferredContactPeriod;
    /**
     * The preferred contact time of the individual - Morning, Evening, Afternoon
     * 
     */
    @JsonProperty("preferredContactTime")
    @JsonPropertyDescription("The preferred contact time of the individual - Morning, Evening, Afternoon")
    @ApiModelProperty(required = false, dataType = "string", position = 11, value = "The preferred contact time of the individual - Morning, Evening, Afternoon", example = "Morning")
    private String preferredContactTime;
    /**
     * The Role of the user. If Primary user - It would have value as Primary. 
     * 
     */
    @JsonProperty("role")
    @JsonPropertyDescription("The Role of the user. If Primary user - It would have value as Primary. ")
    @ApiModelProperty(required = false, dataType = "string", position = 8, value = "The Role of the user. If Primary user - It would have value as Primary. ", example = "Primary")
    private String role;

    @JsonProperty("contactMethods")
    public List<ContactMethod> getContactMethods() {
        return contactMethods;
    }

    @JsonProperty("contactMethods")
    public void setContactMethods(List<ContactMethod> contactMethods) {
        this.contactMethods = contactMethods;
    }

    public CustomerAccountContact withContactMethods(List<ContactMethod> contactMethods) {
        this.contactMethods = contactMethods;
        return this;
    }

    /**
     * The Amdocs Contact ID
     * 
     */
    @JsonProperty("contactId")
    public String getContactId() {
        return contactId;
    }

    /**
     * The Amdocs Contact ID
     * 
     */
    @JsonProperty("contactId")
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public CustomerAccountContact withContactId(String contactId) {
        this.contactId = contactId;
        return this;
    }

    /**
     * The family (last) name of the individual
     * 
     */
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    /**
     * The family (last) name of the individual
     * 
     */
    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CustomerAccountContact withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * The first (given) name of the individual
     * 
     */
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * The first (given) name of the individual
     * 
     */
    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public CustomerAccountContact withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * The middle name of the individual
     * 
     */
    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    /**
     * The middle name of the individual
     * 
     */
    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public CustomerAccountContact withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    /**
     * The formatted name of the Individual
     * 
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * The formatted name of the Individual
     * 
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public CustomerAccountContact withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Title for individuals name. Eg. Mr. Dr. etc
     * 
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * Title for individuals name. Eg. Mr. Dr. etc
     * 
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public CustomerAccountContact withTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * The preferred Language for the contact
     * 
     */
    @JsonProperty("preferredLanguage")
    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    /**
     * The preferred Language for the contact
     * 
     */
    @JsonProperty("preferredLanguage")
    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public CustomerAccountContact withPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
        return this;
    }

    /**
     * The preferred contact method of the individual - Email, Phone, Fax, Postal
     * 
     */
    @JsonProperty("preferredContactMethod")
    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    /**
     * The preferred contact method of the individual - Email, Phone, Fax, Postal
     * 
     */
    @JsonProperty("preferredContactMethod")
    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public CustomerAccountContact withPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
        return this;
    }

    /**
     * The preferred contact period of the individual - For Example: Morning, Afternoon, Evening, Midday
     * 
     */
    @JsonProperty("preferredContactPeriod")
    public String getPreferredContactPeriod() {
        return preferredContactPeriod;
    }

    /**
     * The preferred contact period of the individual - For Example: Morning, Afternoon, Evening, Midday
     * 
     */
    @JsonProperty("preferredContactPeriod")
    public void setPreferredContactPeriod(String preferredContactPeriod) {
        this.preferredContactPeriod = preferredContactPeriod;
    }

    public CustomerAccountContact withPreferredContactPeriod(String preferredContactPeriod) {
        this.preferredContactPeriod = preferredContactPeriod;
        return this;
    }

    /**
     * The preferred contact time of the individual - Morning, Evening, Afternoon
     * 
     */
    @JsonProperty("preferredContactTime")
    public String getPreferredContactTime() {
        return preferredContactTime;
    }

    /**
     * The preferred contact time of the individual - Morning, Evening, Afternoon
     * 
     */
    @JsonProperty("preferredContactTime")
    public void setPreferredContactTime(String preferredContactTime) {
        this.preferredContactTime = preferredContactTime;
    }

    public CustomerAccountContact withPreferredContactTime(String preferredContactTime) {
        this.preferredContactTime = preferredContactTime;
        return this;
    }

    /**
     * The Role of the user. If Primary user - It would have value as Primary. 
     * 
     */
    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    /**
     * The Role of the user. If Primary user - It would have value as Primary. 
     * 
     */
    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    public CustomerAccountContact withRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactMethods).append(contactId).append(lastName).append(firstName).append(middleName).append(displayName).append(title).append(preferredLanguage).append(preferredContactMethod).append(preferredContactPeriod).append(preferredContactTime).append(role).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAccountContact) == false) {
            return false;
        }
        CustomerAccountContact rhs = ((CustomerAccountContact) other);
        return new EqualsBuilder().append(contactMethods, rhs.contactMethods).append(contactId, rhs.contactId).append(lastName, rhs.lastName).append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(displayName, rhs.displayName).append(title, rhs.title).append(preferredLanguage, rhs.preferredLanguage).append(preferredContactMethod, rhs.preferredContactMethod).append(preferredContactPeriod, rhs.preferredContactPeriod).append(preferredContactTime, rhs.preferredContactTime).append(role, rhs.role).isEquals();
    }

}
