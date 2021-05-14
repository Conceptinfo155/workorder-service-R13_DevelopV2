
package com.comcast.orion.workorder.domain.createwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
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
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("actionCd")
    @JsonPropertyDescription("Action Cd passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "Action Cd passed by Amdocs - WFX", example = "ADD")
    private JobProductList.ActionCd actionCd;
    /**
     * Product Cd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("parentProductCd")
    @JsonPropertyDescription("Product Cd passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "Product Cd passed by Amdocs - WFX", example = "HSCAP")
    @Size(min = 1, max = 5)
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
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("productLOB")
    @JsonPropertyDescription("Product LOB passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "Product LOB passed by Amdocs - WFX", example = "I")
    private JobProductList.ProductLOB productLOB;
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
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Port No passed by Amdocs - WFX", example = "23")
    @Size(min = 0, max = 5)
    private String voipPortNum;
    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    @JsonPropertyDescription("Voice Port No passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Port No passed by Amdocs - WFX", example = "outlet")
    @Size(min = 0, max = 20)
    private String outlet;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("quantity")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "integer", position = 0, value = "", example = "0")
    @DecimalMin("0")
    @DecimalMax("9")
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
     * (Required)
     * 
     */
    @JsonProperty("actionCd")
    public JobProductList.ActionCd getActionCd() {
        return actionCd;
    }

    /**
     * Action Cd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(JobProductList.ActionCd actionCd) {
        this.actionCd = actionCd;
    }

    public JobProductList withActionCd(JobProductList.ActionCd actionCd) {
        this.actionCd = actionCd;
        return this;
    }

    /**
     * Product Cd passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("parentProductCd")
    public String getParentProductCd() {
        return parentProductCd;
    }

    /**
     * Product Cd passed by Amdocs - WFX
     * (Required)
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
     * (Required)
     * 
     */
    @JsonProperty("productLOB")
    public JobProductList.ProductLOB getProductLOB() {
        return productLOB;
    }

    /**
     * Product LOB passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("productLOB")
    public void setProductLOB(JobProductList.ProductLOB productLOB) {
        this.productLOB = productLOB;
    }

    public JobProductList withProductLOB(JobProductList.ProductLOB productLOB) {
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

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 
     * (Required)
     * 
     */
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

    public enum ActionCd {

        NONE("NONE"),
        ADD("ADD"),
        REMOVE("REMOVE");
        private final String value;
        private final static Map<String, JobProductList.ActionCd> CONSTANTS = new HashMap<String, JobProductList.ActionCd>();

        static {
            for (JobProductList.ActionCd c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ActionCd(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static JobProductList.ActionCd fromValue(String value) {
            JobProductList.ActionCd constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum ProductLOB {

        C("C"),
        I("I"),
        T("T"),
        Z("Z"),
        N("N"),
        S("S"),
        F("F");
        private final String value;
        private final static Map<String, JobProductList.ProductLOB> CONSTANTS = new HashMap<String, JobProductList.ProductLOB>();

        static {
            for (JobProductList.ProductLOB c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ProductLOB(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static JobProductList.ProductLOB fromValue(String value) {
            JobProductList.ProductLOB constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
