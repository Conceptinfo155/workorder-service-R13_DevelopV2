
package com.comcast.orion.workorder.domain.poi;

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
    "type",
    "categories",
    "customer",
    "site",
    "contact",
    "attributes",
    "required"
})
public class POIRequest {

    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("categories")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String categories;
    @JsonProperty("customer")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Customer customer;
    @JsonProperty("site")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Site site;
    @JsonProperty("contact")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Contact contact;
    @JsonProperty("attributes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Attribute> attributes = new ArrayList<Attribute>();
    @JsonProperty("required")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "", position = 0, value = "", example = "")
    private Object required;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public POIRequest withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("categories")
    public String getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(String categories) {
        this.categories = categories;
    }

    public POIRequest withCategories(String categories) {
        this.categories = categories;
        return this;
    }

    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public POIRequest withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @JsonProperty("site")
    public Site getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(Site site) {
        this.site = site;
    }

    public POIRequest withSite(Site site) {
        this.site = site;
        return this;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public POIRequest withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public POIRequest withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    @JsonProperty("required")
    public Object getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Object required) {
        this.required = required;
    }

    public POIRequest withRequired(Object required) {
        this.required = required;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(categories).append(customer).append(site).append(contact).append(attributes).append(required).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof POIRequest) == false) {
            return false;
        }
        POIRequest rhs = ((POIRequest) other);
        return new EqualsBuilder().append(type, rhs.type).append(categories, rhs.categories).append(customer, rhs.customer).append(site, rhs.site).append(contact, rhs.contact).append(attributes, rhs.attributes).append(required, rhs.required).isEquals();
    }

}
