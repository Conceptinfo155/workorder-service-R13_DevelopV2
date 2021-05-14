
package com.comcast.orion.workorder.domain.ods.customer;

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
    "contactMethodId",
    "source",
    "recordStatus",
    "odsContactId",
    "contactType",
    "contactSubType",
    "primaryContactMethod",
    "contactValue"
})
public class ContactMethod {

    @JsonProperty("contactMethodId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String contactMethodId;
    @JsonProperty("source")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String source;
    @JsonProperty("recordStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String recordStatus;
    @JsonProperty("odsContactId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsContactId;
    @JsonProperty("contactType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String contactType;
    @JsonProperty("contactSubType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String contactSubType;
    @JsonProperty("primaryContactMethod")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String primaryContactMethod;
    @JsonProperty("contactValue")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String contactValue;

    @JsonProperty("contactMethodId")
    public String getContactMethodId() {
        return contactMethodId;
    }

    @JsonProperty("contactMethodId")
    public void setContactMethodId(String contactMethodId) {
        this.contactMethodId = contactMethodId;
    }

    public ContactMethod withContactMethodId(String contactMethodId) {
        this.contactMethodId = contactMethodId;
        return this;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public ContactMethod withSource(String source) {
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

    public ContactMethod withRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
        return this;
    }

    @JsonProperty("odsContactId")
    public String getOdsContactId() {
        return odsContactId;
    }

    @JsonProperty("odsContactId")
    public void setOdsContactId(String odsContactId) {
        this.odsContactId = odsContactId;
    }

    public ContactMethod withOdsContactId(String odsContactId) {
        this.odsContactId = odsContactId;
        return this;
    }

    @JsonProperty("contactType")
    public String getContactType() {
        return contactType;
    }

    @JsonProperty("contactType")
    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public ContactMethod withContactType(String contactType) {
        this.contactType = contactType;
        return this;
    }

    @JsonProperty("contactSubType")
    public String getContactSubType() {
        return contactSubType;
    }

    @JsonProperty("contactSubType")
    public void setContactSubType(String contactSubType) {
        this.contactSubType = contactSubType;
    }

    public ContactMethod withContactSubType(String contactSubType) {
        this.contactSubType = contactSubType;
        return this;
    }

    @JsonProperty("primaryContactMethod")
    public String getPrimaryContactMethod() {
        return primaryContactMethod;
    }

    @JsonProperty("primaryContactMethod")
    public void setPrimaryContactMethod(String primaryContactMethod) {
        this.primaryContactMethod = primaryContactMethod;
    }

    public ContactMethod withPrimaryContactMethod(String primaryContactMethod) {
        this.primaryContactMethod = primaryContactMethod;
        return this;
    }

    @JsonProperty("contactValue")
    public String getContactValue() {
        return contactValue;
    }

    @JsonProperty("contactValue")
    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public ContactMethod withContactValue(String contactValue) {
        this.contactValue = contactValue;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactMethodId).append(source).append(recordStatus).append(odsContactId).append(contactType).append(contactSubType).append(primaryContactMethod).append(contactValue).toHashCode();
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
        return new EqualsBuilder().append(contactMethodId, rhs.contactMethodId).append(source, rhs.source).append(recordStatus, rhs.recordStatus).append(odsContactId, rhs.odsContactId).append(contactType, rhs.contactType).append(contactSubType, rhs.contactSubType).append(primaryContactMethod, rhs.primaryContactMethod).append(contactValue, rhs.contactValue).isEquals();
    }

}
