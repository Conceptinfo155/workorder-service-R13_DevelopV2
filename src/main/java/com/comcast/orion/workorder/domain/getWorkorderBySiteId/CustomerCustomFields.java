
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "CustomerCustom1",
    "CustomerCustom3",
    "CustomerCustom4",
    "CustomerCustom2",
    "CustomerCustom7",
    "CustomerCustom6",
    "CustomerCustom12",
    "CustomerCustom11",
    "CustomerCustom5",
    "CustomerCustom10",
    "CustomerCustom9",
    "CustomerCustom8"
})
public class CustomerCustomFields {

    @JsonProperty("CustomerCustom1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom1;
    @JsonProperty("CustomerCustom3")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom3;
    @JsonProperty("CustomerCustom4")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerCustom4;
    @JsonProperty("CustomerCustom2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom2;
    @JsonProperty("CustomerCustom7")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom7;
    @JsonProperty("CustomerCustom6")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom6;
    @JsonProperty("CustomerCustom12")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom12;
    @JsonProperty("CustomerCustom11")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom11;
    @JsonProperty("CustomerCustom5")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom5;
    @JsonProperty("CustomerCustom10")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom10;
    @JsonProperty("CustomerCustom9")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom9;
    @JsonProperty("CustomerCustom8")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object customerCustom8;

    @JsonProperty("CustomerCustom1")
    public Object getCustomerCustom1() {
        return customerCustom1;
    }

    @JsonProperty("CustomerCustom1")
    public void setCustomerCustom1(Object customerCustom1) {
        this.customerCustom1 = customerCustom1;
    }

    public CustomerCustomFields withCustomerCustom1(Object customerCustom1) {
        this.customerCustom1 = customerCustom1;
        return this;
    }

    @JsonProperty("CustomerCustom3")
    public Object getCustomerCustom3() {
        return customerCustom3;
    }

    @JsonProperty("CustomerCustom3")
    public void setCustomerCustom3(Object customerCustom3) {
        this.customerCustom3 = customerCustom3;
    }

    public CustomerCustomFields withCustomerCustom3(Object customerCustom3) {
        this.customerCustom3 = customerCustom3;
        return this;
    }

    @JsonProperty("CustomerCustom4")
    public String getCustomerCustom4() {
        return customerCustom4;
    }

    @JsonProperty("CustomerCustom4")
    public void setCustomerCustom4(String customerCustom4) {
        this.customerCustom4 = customerCustom4;
    }

    public CustomerCustomFields withCustomerCustom4(String customerCustom4) {
        this.customerCustom4 = customerCustom4;
        return this;
    }

    @JsonProperty("CustomerCustom2")
    public Object getCustomerCustom2() {
        return customerCustom2;
    }

    @JsonProperty("CustomerCustom2")
    public void setCustomerCustom2(Object customerCustom2) {
        this.customerCustom2 = customerCustom2;
    }

    public CustomerCustomFields withCustomerCustom2(Object customerCustom2) {
        this.customerCustom2 = customerCustom2;
        return this;
    }

    @JsonProperty("CustomerCustom7")
    public Object getCustomerCustom7() {
        return customerCustom7;
    }

    @JsonProperty("CustomerCustom7")
    public void setCustomerCustom7(Object customerCustom7) {
        this.customerCustom7 = customerCustom7;
    }

    public CustomerCustomFields withCustomerCustom7(Object customerCustom7) {
        this.customerCustom7 = customerCustom7;
        return this;
    }

    @JsonProperty("CustomerCustom6")
    public Object getCustomerCustom6() {
        return customerCustom6;
    }

    @JsonProperty("CustomerCustom6")
    public void setCustomerCustom6(Object customerCustom6) {
        this.customerCustom6 = customerCustom6;
    }

    public CustomerCustomFields withCustomerCustom6(Object customerCustom6) {
        this.customerCustom6 = customerCustom6;
        return this;
    }

    @JsonProperty("CustomerCustom12")
    public Object getCustomerCustom12() {
        return customerCustom12;
    }

    @JsonProperty("CustomerCustom12")
    public void setCustomerCustom12(Object customerCustom12) {
        this.customerCustom12 = customerCustom12;
    }

    public CustomerCustomFields withCustomerCustom12(Object customerCustom12) {
        this.customerCustom12 = customerCustom12;
        return this;
    }

    @JsonProperty("CustomerCustom11")
    public Object getCustomerCustom11() {
        return customerCustom11;
    }

    @JsonProperty("CustomerCustom11")
    public void setCustomerCustom11(Object customerCustom11) {
        this.customerCustom11 = customerCustom11;
    }

    public CustomerCustomFields withCustomerCustom11(Object customerCustom11) {
        this.customerCustom11 = customerCustom11;
        return this;
    }

    @JsonProperty("CustomerCustom5")
    public Object getCustomerCustom5() {
        return customerCustom5;
    }

    @JsonProperty("CustomerCustom5")
    public void setCustomerCustom5(Object customerCustom5) {
        this.customerCustom5 = customerCustom5;
    }

    public CustomerCustomFields withCustomerCustom5(Object customerCustom5) {
        this.customerCustom5 = customerCustom5;
        return this;
    }

    @JsonProperty("CustomerCustom10")
    public Object getCustomerCustom10() {
        return customerCustom10;
    }

    @JsonProperty("CustomerCustom10")
    public void setCustomerCustom10(Object customerCustom10) {
        this.customerCustom10 = customerCustom10;
    }

    public CustomerCustomFields withCustomerCustom10(Object customerCustom10) {
        this.customerCustom10 = customerCustom10;
        return this;
    }

    @JsonProperty("CustomerCustom9")
    public Object getCustomerCustom9() {
        return customerCustom9;
    }

    @JsonProperty("CustomerCustom9")
    public void setCustomerCustom9(Object customerCustom9) {
        this.customerCustom9 = customerCustom9;
    }

    public CustomerCustomFields withCustomerCustom9(Object customerCustom9) {
        this.customerCustom9 = customerCustom9;
        return this;
    }

    @JsonProperty("CustomerCustom8")
    public Object getCustomerCustom8() {
        return customerCustom8;
    }

    @JsonProperty("CustomerCustom8")
    public void setCustomerCustom8(Object customerCustom8) {
        this.customerCustom8 = customerCustom8;
    }

    public CustomerCustomFields withCustomerCustom8(Object customerCustom8) {
        this.customerCustom8 = customerCustom8;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerCustom1).append(customerCustom3).append(customerCustom4).append(customerCustom2).append(customerCustom7).append(customerCustom6).append(customerCustom12).append(customerCustom11).append(customerCustom5).append(customerCustom10).append(customerCustom9).append(customerCustom8).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerCustomFields) == false) {
            return false;
        }
        CustomerCustomFields rhs = ((CustomerCustomFields) other);
        return new EqualsBuilder().append(customerCustom1, rhs.customerCustom1).append(customerCustom3, rhs.customerCustom3).append(customerCustom4, rhs.customerCustom4).append(customerCustom2, rhs.customerCustom2).append(customerCustom7, rhs.customerCustom7).append(customerCustom6, rhs.customerCustom6).append(customerCustom12, rhs.customerCustom12).append(customerCustom11, rhs.customerCustom11).append(customerCustom5, rhs.customerCustom5).append(customerCustom10, rhs.customerCustom10).append(customerCustom9, rhs.customerCustom9).append(customerCustom8, rhs.customerCustom8).isEquals();
    }

}
