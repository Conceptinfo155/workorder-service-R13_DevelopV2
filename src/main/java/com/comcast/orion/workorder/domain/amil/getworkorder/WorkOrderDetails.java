
package com.comcast.orion.workorder.domain.amil.getworkorder;

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
    "workOrderId",
    "agreementId",
    "customerId",
    "siteId",
    "equipment"
})
public class WorkOrderDetails {

    @JsonProperty("workOrderId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String workOrderId;
    @JsonProperty("agreementId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String agreementId;
    @JsonProperty("customerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerId;
    @JsonProperty("siteId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteId;
    @JsonProperty("equipment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Equipment> equipment = new ArrayList<Equipment>();

    @JsonProperty("workOrderId")
    public String getWorkOrderId() {
        return workOrderId;
    }

    @JsonProperty("workOrderId")
    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public WorkOrderDetails withWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
        return this;
    }

    @JsonProperty("agreementId")
    public String getAgreementId() {
        return agreementId;
    }

    @JsonProperty("agreementId")
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    public WorkOrderDetails withAgreementId(String agreementId) {
        this.agreementId = agreementId;
        return this;
    }

    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public WorkOrderDetails withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public WorkOrderDetails withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    @JsonProperty("equipment")
    public List<Equipment> getEquipment() {
        return equipment;
    }

    @JsonProperty("equipment")
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public WorkOrderDetails withEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderId).append(agreementId).append(customerId).append(siteId).append(equipment).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkOrderDetails) == false) {
            return false;
        }
        WorkOrderDetails rhs = ((WorkOrderDetails) other);
        return new EqualsBuilder().append(workOrderId, rhs.workOrderId).append(agreementId, rhs.agreementId).append(customerId, rhs.customerId).append(siteId, rhs.siteId).append(equipment, rhs.equipment).isEquals();
    }

}
