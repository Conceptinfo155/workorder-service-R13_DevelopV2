
package com.comcast.orion.workorder.domain.getfutureworkorder;

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
    "techId",
    "jobNum",
    "jobUnits",
    "orderComments",
    "jobComments",
    "scheduleDate",
    "equipment"
})
public class WorkOrderDetail {

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
    @JsonProperty("techId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String techId;
    @JsonProperty("jobNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobNum;
    @JsonProperty("jobUnits")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobUnits;
    @JsonProperty("orderComments")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String orderComments;
    @JsonProperty("jobComments")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobComments;
    @JsonProperty("scheduleDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String scheduleDate;
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

    public WorkOrderDetail withWorkOrderId(String workOrderId) {
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

    public WorkOrderDetail withAgreementId(String agreementId) {
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

    public WorkOrderDetail withCustomerId(String customerId) {
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

    public WorkOrderDetail withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    @JsonProperty("techId")
    public String getTechId() {
        return techId;
    }

    @JsonProperty("techId")
    public void setTechId(String techId) {
        this.techId = techId;
    }

    public WorkOrderDetail withTechId(String techId) {
        this.techId = techId;
        return this;
    }

    @JsonProperty("jobNum")
    public String getJobNum() {
        return jobNum;
    }

    @JsonProperty("jobNum")
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public WorkOrderDetail withJobNum(String jobNum) {
        this.jobNum = jobNum;
        return this;
    }

    @JsonProperty("jobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    @JsonProperty("jobUnits")
    public void setJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
    }

    public WorkOrderDetail withJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
        return this;
    }

    @JsonProperty("orderComments")
    public String getOrderComments() {
        return orderComments;
    }

    @JsonProperty("orderComments")
    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    public WorkOrderDetail withOrderComments(String orderComments) {
        this.orderComments = orderComments;
        return this;
    }

    @JsonProperty("jobComments")
    public String getJobComments() {
        return jobComments;
    }

    @JsonProperty("jobComments")
    public void setJobComments(String jobComments) {
        this.jobComments = jobComments;
    }

    public WorkOrderDetail withJobComments(String jobComments) {
        this.jobComments = jobComments;
        return this;
    }

    @JsonProperty("scheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    @JsonProperty("scheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public WorkOrderDetail withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
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

    public WorkOrderDetail withEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderId).append(agreementId).append(customerId).append(siteId).append(techId).append(jobNum).append(jobUnits).append(orderComments).append(jobComments).append(scheduleDate).append(equipment).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WorkOrderDetail) == false) {
            return false;
        }
        WorkOrderDetail rhs = ((WorkOrderDetail) other);
        return new EqualsBuilder().append(workOrderId, rhs.workOrderId).append(agreementId, rhs.agreementId).append(customerId, rhs.customerId).append(siteId, rhs.siteId).append(techId, rhs.techId).append(jobNum, rhs.jobNum).append(jobUnits, rhs.jobUnits).append(orderComments, rhs.orderComments).append(jobComments, rhs.jobComments).append(scheduleDate, rhs.scheduleDate).append(equipment, rhs.equipment).isEquals();
    }

}
