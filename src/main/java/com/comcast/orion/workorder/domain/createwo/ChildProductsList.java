
package com.comcast.orion.workorder.domain.createwo;

import java.util.HashMap;
import java.util.Map;
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
    "actionCd",
    "childProductDesc",
    "siteId",
    "childProductCd",
    "productLOB",
    "voicePhoneNum",
    "voipPortNum",
    "outlet",
    "quantity"
})
public class ChildProductsList {

    /**
     * Action Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("actionCd")
    @JsonPropertyDescription("Action Code passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "Action Code passed by Amdocs - WFX", example = "ADD")
    private ChildProductsList.ActionCd actionCd;
    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("childProductDesc")
    @JsonPropertyDescription("Product Description passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Product Description passed by Amdocs - WFX", example = "childProductDesc")
    @Size(min = 0, max = 60)
    private String childProductDesc;
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
     * Product Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("childProductCd")
    @JsonPropertyDescription("Product Code passed by Amdocs - WFX")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "Product Code passed by Amdocs - WFX", example = "HSCEC")
    @Size(min = 1, max = 5)
    private String childProductCd;
    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    @JsonPropertyDescription("Product LOB passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Product LOB passed by Amdocs - WFX", example = "I")
    private ChildProductsList.ProductLOB productLOB;
    /**
     * Voice Phone No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    @JsonPropertyDescription("Voice Phone No passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Phone No passed by Amdocs - WFX", example = "902-987-2345")
    @Size(min = 0, max = 20)
    private String voicePhoneNum;
    /**
     * Voice Port No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voipPortNum")
    @JsonPropertyDescription("Voice Port No passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Voice Port No passed by Amdocs - WFX", example = "10")
    @Size(min = 0, max = 5)
    private String voipPortNum;
    /**
     * Outlet passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    @JsonPropertyDescription("Outlet passed by Amdocs - WFX")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Outlet passed by Amdocs - WFX", example = "outlet")
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
    @ApiModelProperty(required = true, dataType = "integer", position = 0, value = "", example = "4")
    @DecimalMin("0")
    @DecimalMax("9")
    private Integer quantity;

    /**
     * Action Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("actionCd")
    public ChildProductsList.ActionCd getActionCd() {
        return actionCd;
    }

    /**
     * Action Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("actionCd")
    public void setActionCd(ChildProductsList.ActionCd actionCd) {
        this.actionCd = actionCd;
    }

    public ChildProductsList withActionCd(ChildProductsList.ActionCd actionCd) {
        this.actionCd = actionCd;
        return this;
    }

    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("childProductDesc")
    public String getChildProductDesc() {
        return childProductDesc;
    }

    /**
     * Product Description passed by Amdocs - WFX
     * 
     */
    @JsonProperty("childProductDesc")
    public void setChildProductDesc(String childProductDesc) {
        this.childProductDesc = childProductDesc;
    }

    public ChildProductsList withChildProductDesc(String childProductDesc) {
        this.childProductDesc = childProductDesc;
        return this;
    }

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

    public ChildProductsList withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    /**
     * Product Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("childProductCd")
    public String getChildProductCd() {
        return childProductCd;
    }

    /**
     * Product Code passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("childProductCd")
    public void setChildProductCd(String childProductCd) {
        this.childProductCd = childProductCd;
    }

    public ChildProductsList withChildProductCd(String childProductCd) {
        this.childProductCd = childProductCd;
        return this;
    }

    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    public ChildProductsList.ProductLOB getProductLOB() {
        return productLOB;
    }

    /**
     * Product LOB passed by Amdocs - WFX
     * 
     */
    @JsonProperty("productLOB")
    public void setProductLOB(ChildProductsList.ProductLOB productLOB) {
        this.productLOB = productLOB;
    }

    public ChildProductsList withProductLOB(ChildProductsList.ProductLOB productLOB) {
        this.productLOB = productLOB;
        return this;
    }

    /**
     * Voice Phone No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    public String getVoicePhoneNum() {
        return voicePhoneNum;
    }

    /**
     * Voice Phone No passed by Amdocs - WFX
     * 
     */
    @JsonProperty("voicePhoneNum")
    public void setVoicePhoneNum(String voicePhoneNum) {
        this.voicePhoneNum = voicePhoneNum;
    }

    public ChildProductsList withVoicePhoneNum(String voicePhoneNum) {
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

    public ChildProductsList withVoipPortNum(String voipPortNum) {
        this.voipPortNum = voipPortNum;
        return this;
    }

    /**
     * Outlet passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    public String getOutlet() {
        return outlet;
    }

    /**
     * Outlet passed by Amdocs - WFX
     * 
     */
    @JsonProperty("outlet")
    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public ChildProductsList withOutlet(String outlet) {
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

    public ChildProductsList withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(actionCd).append(childProductDesc).append(siteId).append(childProductCd).append(productLOB).append(voicePhoneNum).append(voipPortNum).append(outlet).append(quantity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ChildProductsList) == false) {
            return false;
        }
        ChildProductsList rhs = ((ChildProductsList) other);
        return new EqualsBuilder().append(actionCd, rhs.actionCd).append(childProductDesc, rhs.childProductDesc).append(siteId, rhs.siteId).append(childProductCd, rhs.childProductCd).append(productLOB, rhs.productLOB).append(voicePhoneNum, rhs.voicePhoneNum).append(voipPortNum, rhs.voipPortNum).append(outlet, rhs.outlet).append(quantity, rhs.quantity).isEquals();
    }

    public enum ActionCd {

        NONE("NONE"),
        ADD("ADD"),
        REMOVE("REMOVE");
        private final String value;
        private final static Map<String, ChildProductsList.ActionCd> CONSTANTS = new HashMap<String, ChildProductsList.ActionCd>();

        static {
            for (ChildProductsList.ActionCd c: values()) {
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
        public static ChildProductsList.ActionCd fromValue(String value) {
            ChildProductsList.ActionCd constant = CONSTANTS.get(value);
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
        private final static Map<String, ChildProductsList.ProductLOB> CONSTANTS = new HashMap<String, ChildProductsList.ProductLOB>();

        static {
            for (ChildProductsList.ProductLOB c: values()) {
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
        public static ChildProductsList.ProductLOB fromValue(String value) {
            ChildProductsList.ProductLOB constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
