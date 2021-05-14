
package com.comcast.orion.workorder.domain.getorderdetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * Credit Check of the Customer
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "decisionAction",
    "expDate"
})
public class CreditCheck {

    /**
     * Decision Action of Credit Check
     * 
     */
    @JsonProperty("decisionAction")
    @JsonPropertyDescription("Decision Action of Credit Check")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Decision Action of Credit Check", example = "N")
    private String decisionAction;
    /**
     * Expiration Date
     * 
     */
    @JsonProperty("expDate")
    @JsonPropertyDescription("Expiration Date")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "Expiration Date", example = "06/21/2019")
    private String expDate;

    /**
     * Decision Action of Credit Check
     * 
     */
    @JsonProperty("decisionAction")
    public String getDecisionAction() {
        return decisionAction;
    }

    /**
     * Decision Action of Credit Check
     * 
     */
    @JsonProperty("decisionAction")
    public void setDecisionAction(String decisionAction) {
        this.decisionAction = decisionAction;
    }

    public CreditCheck withDecisionAction(String decisionAction) {
        this.decisionAction = decisionAction;
        return this;
    }

    /**
     * Expiration Date
     * 
     */
    @JsonProperty("expDate")
    public String getExpDate() {
        return expDate;
    }

    /**
     * Expiration Date
     * 
     */
    @JsonProperty("expDate")
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public CreditCheck withExpDate(String expDate) {
        this.expDate = expDate;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(decisionAction).append(expDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCheck) == false) {
            return false;
        }
        CreditCheck rhs = ((CreditCheck) other);
        return new EqualsBuilder().append(decisionAction, rhs.decisionAction).append(expDate, rhs.expDate).isEquals();
    }

}
