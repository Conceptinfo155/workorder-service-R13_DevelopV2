
package com.comcast.orion.workorder.domain.updatewo;

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
    "siteId",
    "actionCd",
    "parentProductCd",
    "parentProductDesc",
    "productLOB",
    "voicePhoneNum",
    "voipPortNum",
    "outlet",
    "quantity",
    "childProductsList"
})
public class JobProductList {

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
     * Action Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    @JsonPropertyDescription("Action Cd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Action Cd passed by Amdocs - WFX", example = "ADD")
    @Size(min = 0, max = 8)
    private String actionCd;
    /**
     * Product Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductCd")
    @JsonPropertyDescription("Product Cd passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Product Cd passed by Amdocs - WFX", example = "HSCAP")
    @Size(min = 0, max = 5)
    private String parentProductCd;
    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductDesc")
    @JsonPropertyDescription("Product Description passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Product Description passed by Amdocs - WFX", example = "HSCAP")
    @Size(min = 0, max = 60)
    private String parentProductDesc;
    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    @JsonPropertyDescription("Product LOB passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Product LOB passed by Amdocs - WFX", example = "I")
    @Size(min = 0, max = 1)
    private String productLOB;
    /**
     * Voice Phone Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    @JsonPropertyDescription("Voice Phone Number passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Phone Number passed by Amdocs - WFX", example = "878-456-7890")
    @Size(min = 0, max = 20)
    private String voicePhoneNum;
    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voipPortNum")
    @JsonPropertyDescription("Voice Port No passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Port No passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 5)
    private String voipPortNum;
    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    @JsonPropertyDescription("Voice Port No passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Port No passed by Amdocs - WFX", example = "")
    @Size(min = 0, max = 20)
    private String outlet;
    @JsonProperty("quantity")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "", example = "")
    private Integer quantity;
    @JsonProperty("childProductsList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<ChildProductsList> childProductsList = new ArrayList<ChildProductsList>();

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

    public JobProductList withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    /**
     * Action Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    public String getActionCd() {
        return actionCd;
    }

    /**
     * Action Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(String actionCd) {
        this.actionCd = actionCd;
    }

    public JobProductList withActionCd(String actionCd) {
        this.actionCd = actionCd;
        return this;
    }

    /**
     * Product Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductCd")
    public String getParentProductCd() {
        return parentProductCd;
    }

    /**
     * Product Cd passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductCd")
    public void setParentProductCd(String parentProductCd) {
        this.parentProductCd = parentProductCd;
    }

    public JobProductList withParentProductCd(String parentProductCd) {
        this.parentProductCd = parentProductCd;
        return this;
    }

    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductDesc")
    public String getParentProductDesc() {
        return parentProductDesc;
    }

    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("parentProductDesc")
    public void setParentProductDesc(String parentProductDesc) {
        this.parentProductDesc = parentProductDesc;
    }

    public JobProductList withParentProductDesc(String parentProductDesc) {
        this.parentProductDesc = parentProductDesc;
        return this;
    }

    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    public String getProductLOB() {
        return productLOB;
    }

    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    public void setProductLOB(String productLOB) {
        this.productLOB = productLOB;
    }

    public JobProductList withProductLOB(String productLOB) {
        this.productLOB = productLOB;
        return this;
    }

    /**
     * Voice Phone Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    public String getVoicePhoneNum() {
        return voicePhoneNum;
    }

    /**
     * Voice Phone Number passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    public void setVoicePhoneNum(String voicePhoneNum) {
        this.voicePhoneNum = voicePhoneNum;
    }

    public JobProductList withVoicePhoneNum(String voicePhoneNum) {
        this.voicePhoneNum = voicePhoneNum;
        return this;
    }

    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voipPortNum")
    public String getVoipPortNum() {
        return voipPortNum;
    }

    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voipPortNum")
    public void setVoipPortNum(String voipPortNum) {
        this.voipPortNum = voipPortNum;
    }

    public JobProductList withVoipPortNum(String voipPortNum) {
        this.voipPortNum = voipPortNum;
        return this;
    }

    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    public String getOutlet() {
        return outlet;
    }

    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public JobProductList withOutlet(String outlet) {
        this.outlet = outlet;
        return this;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public JobProductList withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("childProductsList")
    public List<ChildProductsList> getChildProductsList() {
        return childProductsList;
    }

    @JsonProperty("childProductsList")
    public void setChildProductsList(List<ChildProductsList> childProductsList) {
        this.childProductsList = childProductsList;
    }

    public JobProductList withChildProductsList(List<ChildProductsList> childProductsList) {
        this.childProductsList = childProductsList;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(siteId).append(actionCd).append(parentProductCd).append(parentProductDesc).append(productLOB).append(voicePhoneNum).append(voipPortNum).append(outlet).append(quantity).append(childProductsList).toHashCode();
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
        return new EqualsBuilder().append(siteId, rhs.siteId).append(actionCd, rhs.actionCd).append(parentProductCd, rhs.parentProductCd).append(parentProductDesc, rhs.parentProductDesc).append(productLOB, rhs.productLOB).append(voicePhoneNum, rhs.voicePhoneNum).append(voipPortNum, rhs.voipPortNum).append(outlet, rhs.outlet).append(quantity, rhs.quantity).append(childProductsList, rhs.childProductsList).isEquals();
    }

}
