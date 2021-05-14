
package com.comcast.orion.workorder.domain.ods.customer;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
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
    "source",
    "recordStatus",
    "contactId",
    "athenaId",
    "odsLanguageId",
    "salutation",
    "firstName",
    "middleName",
    "lastName",
    "legalName",
    "professionalTitle",
    "birthDate",
    "gender",
    "maritalStatus",
    "preferredName",
    "preferredContactTime",
    "preferredContactMethod",
    "primaryContactInd",
    "comcastContactId",
    "contactMethod"
})
public class Contact_ {

    @JsonProperty("source")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String source;
    @JsonProperty("recordStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String recordStatus;
    @JsonProperty("contactId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String contactId;
    @JsonProperty("athenaId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String athenaId;
    @JsonProperty("odsLanguageId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsLanguageId;
    @JsonProperty("salutation")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String salutation;
    @JsonProperty("firstName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String firstName;
    @JsonProperty("middleName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String middleName;
    @JsonProperty("lastName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lastName;
    @JsonProperty("legalName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String legalName;
    @JsonProperty("professionalTitle")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String professionalTitle;
    @JsonProperty("birthDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String birthDate;
    @JsonProperty("gender")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String gender;
    @JsonProperty("maritalStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String maritalStatus;
    @JsonProperty("preferredName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String preferredName;
    @JsonProperty("preferredContactTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String preferredContactTime;
    @JsonProperty("preferredContactMethod")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String preferredContactMethod;
    @JsonProperty("primaryContactInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String primaryContactInd;
    @JsonProperty("comcastContactId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String comcastContactId;
    @JsonProperty("contactMethod")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Size(min = 1)
    @Valid
    private List<ContactMethod> contactMethod = new ArrayList<ContactMethod>();

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public Contact_ withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("recordStatus")
    public String getRecordStatus() {
        return recordStatus;
    }

    @JsonProperty("recordStatus")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Contact_ withRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
        return this;
    }

    @JsonProperty("contactId")
    public String getContactId() {
        return contactId;
    }

    @JsonProperty("contactId")
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public Contact_ withContactId(String contactId) {
        this.contactId = contactId;
        return this;
    }

    @JsonProperty("athenaId")
    public String getAthenaId() {
        return athenaId;
    }

    @JsonProperty("athenaId")
    public void setAthenaId(String athenaId) {
        this.athenaId = athenaId;
    }

    public Contact_ withAthenaId(String athenaId) {
        this.athenaId = athenaId;
        return this;
    }

    @JsonProperty("odsLanguageId")
    public String getOdsLanguageId() {
        return odsLanguageId;
    }

    @JsonProperty("odsLanguageId")
    public void setOdsLanguageId(String odsLanguageId) {
        this.odsLanguageId = odsLanguageId;
    }

    public Contact_ withOdsLanguageId(String odsLanguageId) {
        this.odsLanguageId = odsLanguageId;
        return this;
    }

    @JsonProperty("salutation")
    public String getSalutation() {
        return salutation;
    }

    @JsonProperty("salutation")
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public Contact_ withSalutation(String salutation) {
        this.salutation = salutation;
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

    public Contact_ withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Contact_ withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact_ withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @JsonProperty("legalName")
    public String getLegalName() {
        return legalName;
    }

    @JsonProperty("legalName")
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Contact_ withLegalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    @JsonProperty("professionalTitle")
    public String getProfessionalTitle() {
        return professionalTitle;
    }

    @JsonProperty("professionalTitle")
    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    public Contact_ withProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
        return this;
    }

    @JsonProperty("birthDate")
    public String getBirthDate() {
        return birthDate;
    }

    @JsonProperty("birthDate")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Contact_ withBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact_ withGender(String gender) {
        this.gender = gender;
        return this;
    }

    @JsonProperty("maritalStatus")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("maritalStatus")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Contact_ withMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    @JsonProperty("preferredName")
    public String getPreferredName() {
        return preferredName;
    }

    @JsonProperty("preferredName")
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public Contact_ withPreferredName(String preferredName) {
        this.preferredName = preferredName;
        return this;
    }

    @JsonProperty("preferredContactTime")
    public String getPreferredContactTime() {
        return preferredContactTime;
    }

    @JsonProperty("preferredContactTime")
    public void setPreferredContactTime(String preferredContactTime) {
        this.preferredContactTime = preferredContactTime;
    }

    public Contact_ withPreferredContactTime(String preferredContactTime) {
        this.preferredContactTime = preferredContactTime;
        return this;
    }

    @JsonProperty("preferredContactMethod")
    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    @JsonProperty("preferredContactMethod")
    public void setPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
    }

    public Contact_ withPreferredContactMethod(String preferredContactMethod) {
        this.preferredContactMethod = preferredContactMethod;
        return this;
    }

    @JsonProperty("primaryContactInd")
    public String getPrimaryContactInd() {
        return primaryContactInd;
    }

    @JsonProperty("primaryContactInd")
    public void setPrimaryContactInd(String primaryContactInd) {
        this.primaryContactInd = primaryContactInd;
    }

    public Contact_ withPrimaryContactInd(String primaryContactInd) {
        this.primaryContactInd = primaryContactInd;
        return this;
    }

    @JsonProperty("comcastContactId")
    public String getComcastContactId() {
        return comcastContactId;
    }

    @JsonProperty("comcastContactId")
    public void setComcastContactId(String comcastContactId) {
        this.comcastContactId = comcastContactId;
    }

    public Contact_ withComcastContactId(String comcastContactId) {
        this.comcastContactId = comcastContactId;
        return this;
    }

    @JsonProperty("contactMethod")
    public List<ContactMethod> getContactMethod() {
        return contactMethod;
    }

    @JsonProperty("contactMethod")
    public void setContactMethod(List<ContactMethod> contactMethod) {
        this.contactMethod = contactMethod;
    }

    public Contact_ withContactMethod(List<ContactMethod> contactMethod) {
        this.contactMethod = contactMethod;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(recordStatus).append(contactId).append(athenaId).append(odsLanguageId).append(salutation).append(firstName).append(middleName).append(lastName).append(legalName).append(professionalTitle).append(birthDate).append(gender).append(maritalStatus).append(preferredName).append(preferredContactTime).append(preferredContactMethod).append(primaryContactInd).append(comcastContactId).append(contactMethod).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Contact_) == false) {
            return false;
        }
        Contact_ rhs = ((Contact_) other);
        return new EqualsBuilder().append(source, rhs.source).append(recordStatus, rhs.recordStatus).append(contactId, rhs.contactId).append(athenaId, rhs.athenaId).append(odsLanguageId, rhs.odsLanguageId).append(salutation, rhs.salutation).append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(legalName, rhs.legalName).append(professionalTitle, rhs.professionalTitle).append(birthDate, rhs.birthDate).append(gender, rhs.gender).append(maritalStatus, rhs.maritalStatus).append(preferredName, rhs.preferredName).append(preferredContactTime, rhs.preferredContactTime).append(preferredContactMethod, rhs.preferredContactMethod).append(primaryContactInd, rhs.primaryContactInd).append(comcastContactId, rhs.comcastContactId).append(contactMethod, rhs.contactMethod).isEquals();
    }

}
