
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
    "Quantity",
    "FulfillmentJobNum",
    "ProductTypeCd",
    "ActionCd",
    "ParentProductCd",
    "ProductLOB",
    "VoipPortNum",
    "VoicePhoneNum",
    "AccountNum"
})
public class JobProductList {

    @JsonProperty("Quantity")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String quantity;
    @JsonProperty("FulfillmentJobNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String fulfillmentJobNum;
    @JsonProperty("ProductTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String productTypeCd;
    @JsonProperty("ActionCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String actionCd;
    @JsonProperty("ParentProductCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String parentProductCd;
    @JsonProperty("ProductLOB")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String productLOB;
    @JsonProperty("VoipPortNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object voipPortNum;
    @JsonProperty("VoicePhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object voicePhoneNum;
    @JsonProperty("AccountNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String accountNum;

    @JsonProperty("Quantity")
    public String getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public JobProductList withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("FulfillmentJobNum")
    public String getFulfillmentJobNum() {
        return fulfillmentJobNum;
    }

    @JsonProperty("FulfillmentJobNum")
    public void setFulfillmentJobNum(String fulfillmentJobNum) {
        this.fulfillmentJobNum = fulfillmentJobNum;
    }

    public JobProductList withFulfillmentJobNum(String fulfillmentJobNum) {
        this.fulfillmentJobNum = fulfillmentJobNum;
        return this;
    }

    @JsonProperty("ProductTypeCd")
    public String getProductTypeCd() {
        return productTypeCd;
    }

    @JsonProperty("ProductTypeCd")
    public void setProductTypeCd(String productTypeCd) {
        this.productTypeCd = productTypeCd;
    }

    public JobProductList withProductTypeCd(String productTypeCd) {
        this.productTypeCd = productTypeCd;
        return this;
    }

    @JsonProperty("ActionCd")
    public String getActionCd() {
        return actionCd;
    }

    @JsonProperty("ActionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
    }

    public JobProductList withActionCd(String actionCd) {
        this.actionCd = actionCd;
        return this;
    }

    @JsonProperty("ParentProductCd")
    public String getParentProductCd() {
        return parentProductCd;
    }

    @JsonProperty("ParentProductCd")
    public void setParentProductCd(String parentProductCd) {
        this.parentProductCd = parentProductCd;
    }

    public JobProductList withParentProductCd(String parentProductCd) {
        this.parentProductCd = parentProductCd;
        return this;
    }

    @JsonProperty("ProductLOB")
    public String getProductLOB() {
        return productLOB;
    }

    @JsonProperty("ProductLOB")
    public void setProductLOB(String productLOB) {
        this.productLOB = productLOB;
    }

    public JobProductList withProductLOB(String productLOB) {
        this.productLOB = productLOB;
        return this;
    }

    @JsonProperty("VoipPortNum")
    public Object getVoipPortNum() {
        return voipPortNum;
    }

    @JsonProperty("VoipPortNum")
    public void setVoipPortNum(Object voipPortNum) {
        this.voipPortNum = voipPortNum;
    }

    public JobProductList withVoipPortNum(Object voipPortNum) {
        this.voipPortNum = voipPortNum;
        return this;
    }

    @JsonProperty("VoicePhoneNum")
    public Object getVoicePhoneNum() {
        return voicePhoneNum;
    }

    @JsonProperty("VoicePhoneNum")
    public void setVoicePhoneNum(Object voicePhoneNum) {
        this.voicePhoneNum = voicePhoneNum;
    }

    public JobProductList withVoicePhoneNum(Object voicePhoneNum) {
        this.voicePhoneNum = voicePhoneNum;
        return this;
    }

    @JsonProperty("AccountNum")
    public String getAccountNum() {
        return accountNum;
    }

    @JsonProperty("AccountNum")
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public JobProductList withAccountNum(String accountNum) {
        this.accountNum = accountNum;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(quantity).append(fulfillmentJobNum).append(productTypeCd).append(actionCd).append(parentProductCd).append(productLOB).append(voipPortNum).append(voicePhoneNum).append(accountNum).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobProductList) == false) {
            return false;
        }
        JobProductList rhs = ((JobProductList) other);
        return new EqualsBuilder().append(quantity, rhs.quantity).append(fulfillmentJobNum, rhs.fulfillmentJobNum).append(productTypeCd, rhs.productTypeCd).append(actionCd, rhs.actionCd).append(parentProductCd, rhs.parentProductCd).append(productLOB, rhs.productLOB).append(voipPortNum, rhs.voipPortNum).append(voicePhoneNum, rhs.voicePhoneNum).append(accountNum, rhs.accountNum).isEquals();
    }

}
