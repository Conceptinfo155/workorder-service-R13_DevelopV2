
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "TimeSlotDesc",
    "WorkOrderNum",
    "CreateDateTime",
    "OrderMgmtSystem",
    "EnRouteRequestInd",
    "SourceId",
    "CallFirstPhoneNum",
    "TimeSlotCd",
    "JobUnits",
    "JobTypeCd",
    "TimeSlotEndTime",
    "bu_id",
    "JobResolutionCdList",
    "DaylightSavingsObserved",
    "DispatcherStatusCd",
    "TimeSlotStartTime",
    "InitialStartDateTime",
    "ScheduleDate",
    "JobNum",
    "OrderNum",
    "TechnicianNum",
    "InstallerType",
    "BusinessUnit",
    "LastChangeOper",
    "SalesmanNum",
    "JobCommentTypeCdList",
    "OnTimeGuaranteeInd",
    "CodAmount",
    "EndDateTime",
    "TroubleCallIndicator",
    "JobCustomFields",
    "JobReasonCdList",
    "TimeZoneOffset",
    "JobReasonCode"
})
public class Job {

    @JsonProperty("TimeSlotDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeSlotDesc;
    @JsonProperty("WorkOrderNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String workOrderNum;
    @JsonProperty("CreateDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String createDateTime;
    @JsonProperty("OrderMgmtSystem")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String orderMgmtSystem;
    @JsonProperty("EnRouteRequestInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object enRouteRequestInd;
    @JsonProperty("SourceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String sourceId;
    @JsonProperty("CallFirstPhoneNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String callFirstPhoneNum;
    @JsonProperty("TimeSlotCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeSlotCd;
    @JsonProperty("JobUnits")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobUnits;
    @JsonProperty("JobTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobTypeCd;
    @JsonProperty("TimeSlotEndTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeSlotEndTime;
    @JsonProperty("bu_id")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String buId;
    @JsonProperty("JobResolutionCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Object> jobResolutionCdList = new ArrayList<Object>();
    @JsonProperty("DaylightSavingsObserved")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String daylightSavingsObserved;
    @JsonProperty("DispatcherStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String dispatcherStatusCd;
    @JsonProperty("TimeSlotStartTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeSlotStartTime;
    @JsonProperty("InitialStartDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object initialStartDateTime;
    @JsonProperty("ScheduleDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String scheduleDate;
    @JsonProperty("JobNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobNum;
    @JsonProperty("OrderNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String orderNum;
    @JsonProperty("TechnicianNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String technicianNum;
    @JsonProperty("InstallerType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String installerType;
    @JsonProperty("BusinessUnit")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String businessUnit;
    @JsonProperty("LastChangeOper")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lastChangeOper;
    @JsonProperty("SalesmanNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String salesmanNum;
    @JsonProperty("JobCommentTypeCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobCommentTypeCdList> jobCommentTypeCdList = new ArrayList<JobCommentTypeCdList>();
    @JsonProperty("OnTimeGuaranteeInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object onTimeGuaranteeInd;
    @JsonProperty("CodAmount")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object codAmount;
    @JsonProperty("EndDateTime")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object endDateTime;
    @JsonProperty("TroubleCallIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String troubleCallIndicator;
    @JsonProperty("JobCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private JobCustomFields jobCustomFields;
    @JsonProperty("JobReasonCdList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<JobReasonCdList> jobReasonCdList = new ArrayList<JobReasonCdList>();
    @JsonProperty("TimeZoneOffset")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeZoneOffset;
    @JsonProperty("JobReasonCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String jobReasonCode;

    @JsonProperty("TimeSlotDesc")
    public String getTimeSlotDesc() {
        return timeSlotDesc;
    }

    @JsonProperty("TimeSlotDesc")
    public void setTimeSlotDesc(String timeSlotDesc) {
        this.timeSlotDesc = timeSlotDesc;
    }

    public Job withTimeSlotDesc(String timeSlotDesc) {
        this.timeSlotDesc = timeSlotDesc;
        return this;
    }

    @JsonProperty("WorkOrderNum")
    public String getWorkOrderNum() {
        return workOrderNum;
    }

    @JsonProperty("WorkOrderNum")
    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public Job withWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
        return this;
    }

    @JsonProperty("CreateDateTime")
    public String getCreateDateTime() {
        return createDateTime;
    }

    @JsonProperty("CreateDateTime")
    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Job withCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
        return this;
    }

    @JsonProperty("OrderMgmtSystem")
    public String getOrderMgmtSystem() {
        return orderMgmtSystem;
    }

    @JsonProperty("OrderMgmtSystem")
    public void setOrderMgmtSystem(String orderMgmtSystem) {
        this.orderMgmtSystem = orderMgmtSystem;
    }

    public Job withOrderMgmtSystem(String orderMgmtSystem) {
        this.orderMgmtSystem = orderMgmtSystem;
        return this;
    }

    @JsonProperty("EnRouteRequestInd")
    public Object getEnRouteRequestInd() {
        return enRouteRequestInd;
    }

    @JsonProperty("EnRouteRequestInd")
    public void setEnRouteRequestInd(Object enRouteRequestInd) {
        this.enRouteRequestInd = enRouteRequestInd;
    }

    public Job withEnRouteRequestInd(Object enRouteRequestInd) {
        this.enRouteRequestInd = enRouteRequestInd;
        return this;
    }

    @JsonProperty("SourceId")
    public String getSourceId() {
        return sourceId;
    }

    @JsonProperty("SourceId")
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Job withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    @JsonProperty("CallFirstPhoneNum")
    public String getCallFirstPhoneNum() {
        return callFirstPhoneNum;
    }

    @JsonProperty("CallFirstPhoneNum")
    public void setCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
    }

    public Job withCallFirstPhoneNum(String callFirstPhoneNum) {
        this.callFirstPhoneNum = callFirstPhoneNum;
        return this;
    }

    @JsonProperty("TimeSlotCd")
    public String getTimeSlotCd() {
        return timeSlotCd;
    }

    @JsonProperty("TimeSlotCd")
    public void setTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
    }

    public Job withTimeSlotCd(String timeSlotCd) {
        this.timeSlotCd = timeSlotCd;
        return this;
    }

    @JsonProperty("JobUnits")
    public String getJobUnits() {
        return jobUnits;
    }

    @JsonProperty("JobUnits")
    public void setJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
    }

    public Job withJobUnits(String jobUnits) {
        this.jobUnits = jobUnits;
        return this;
    }

    @JsonProperty("JobTypeCd")
    public String getJobTypeCd() {
        return jobTypeCd;
    }

    @JsonProperty("JobTypeCd")
    public void setJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
    }

    public Job withJobTypeCd(String jobTypeCd) {
        this.jobTypeCd = jobTypeCd;
        return this;
    }

    @JsonProperty("TimeSlotEndTime")
    public String getTimeSlotEndTime() {
        return timeSlotEndTime;
    }

    @JsonProperty("TimeSlotEndTime")
    public void setTimeSlotEndTime(String timeSlotEndTime) {
        this.timeSlotEndTime = timeSlotEndTime;
    }

    public Job withTimeSlotEndTime(String timeSlotEndTime) {
        this.timeSlotEndTime = timeSlotEndTime;
        return this;
    }

    @JsonProperty("bu_id")
    public String getBuId() {
        return buId;
    }

    @JsonProperty("bu_id")
    public void setBuId(String buId) {
        this.buId = buId;
    }

    public Job withBuId(String buId) {
        this.buId = buId;
        return this;
    }

    @JsonProperty("JobResolutionCdList")
    public List<Object> getJobResolutionCdList() {
        return jobResolutionCdList;
    }

    @JsonProperty("JobResolutionCdList")
    public void setJobResolutionCdList(List<Object> jobResolutionCdList) {
        this.jobResolutionCdList = jobResolutionCdList;
    }

    public Job withJobResolutionCdList(List<Object> jobResolutionCdList) {
        this.jobResolutionCdList = jobResolutionCdList;
        return this;
    }

    @JsonProperty("DaylightSavingsObserved")
    public String getDaylightSavingsObserved() {
        return daylightSavingsObserved;
    }

    @JsonProperty("DaylightSavingsObserved")
    public void setDaylightSavingsObserved(String daylightSavingsObserved) {
        this.daylightSavingsObserved = daylightSavingsObserved;
    }

    public Job withDaylightSavingsObserved(String daylightSavingsObserved) {
        this.daylightSavingsObserved = daylightSavingsObserved;
        return this;
    }

    @JsonProperty("DispatcherStatusCd")
    public String getDispatcherStatusCd() {
        return dispatcherStatusCd;
    }

    @JsonProperty("DispatcherStatusCd")
    public void setDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
    }

    public Job withDispatcherStatusCd(String dispatcherStatusCd) {
        this.dispatcherStatusCd = dispatcherStatusCd;
        return this;
    }

    @JsonProperty("TimeSlotStartTime")
    public String getTimeSlotStartTime() {
        return timeSlotStartTime;
    }

    @JsonProperty("TimeSlotStartTime")
    public void setTimeSlotStartTime(String timeSlotStartTime) {
        this.timeSlotStartTime = timeSlotStartTime;
    }

    public Job withTimeSlotStartTime(String timeSlotStartTime) {
        this.timeSlotStartTime = timeSlotStartTime;
        return this;
    }

    @JsonProperty("InitialStartDateTime")
    public Object getInitialStartDateTime() {
        return initialStartDateTime;
    }

    @JsonProperty("InitialStartDateTime")
    public void setInitialStartDateTime(Object initialStartDateTime) {
        this.initialStartDateTime = initialStartDateTime;
    }

    public Job withInitialStartDateTime(Object initialStartDateTime) {
        this.initialStartDateTime = initialStartDateTime;
        return this;
    }

    @JsonProperty("ScheduleDate")
    public String getScheduleDate() {
        return scheduleDate;
    }

    @JsonProperty("ScheduleDate")
    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Job withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    @JsonProperty("JobNum")
    public String getJobNum() {
        return jobNum;
    }

    @JsonProperty("JobNum")
    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Job withJobNum(String jobNum) {
        this.jobNum = jobNum;
        return this;
    }

    @JsonProperty("OrderNum")
    public String getOrderNum() {
        return orderNum;
    }

    @JsonProperty("OrderNum")
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Job withOrderNum(String orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    @JsonProperty("TechnicianNum")
    public String getTechnicianNum() {
        return technicianNum;
    }

    @JsonProperty("TechnicianNum")
    public void setTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
    }

    public Job withTechnicianNum(String technicianNum) {
        this.technicianNum = technicianNum;
        return this;
    }

    @JsonProperty("InstallerType")
    public String getInstallerType() {
        return installerType;
    }

    @JsonProperty("InstallerType")
    public void setInstallerType(String installerType) {
        this.installerType = installerType;
    }

    public Job withInstallerType(String installerType) {
        this.installerType = installerType;
        return this;
    }

    @JsonProperty("BusinessUnit")
    public String getBusinessUnit() {
        return businessUnit;
    }

    @JsonProperty("BusinessUnit")
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public Job withBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
        return this;
    }

    @JsonProperty("LastChangeOper")
    public String getLastChangeOper() {
        return lastChangeOper;
    }

    @JsonProperty("LastChangeOper")
    public void setLastChangeOper(String lastChangeOper) {
        this.lastChangeOper = lastChangeOper;
    }

    public Job withLastChangeOper(String lastChangeOper) {
        this.lastChangeOper = lastChangeOper;
        return this;
    }

    @JsonProperty("SalesmanNum")
    public String getSalesmanNum() {
        return salesmanNum;
    }

    @JsonProperty("SalesmanNum")
    public void setSalesmanNum(String salesmanNum) {
        this.salesmanNum = salesmanNum;
    }

    public Job withSalesmanNum(String salesmanNum) {
        this.salesmanNum = salesmanNum;
        return this;
    }

    @JsonProperty("JobCommentTypeCdList")
    public List<JobCommentTypeCdList> getJobCommentTypeCdList() {
        return jobCommentTypeCdList;
    }

    @JsonProperty("JobCommentTypeCdList")
    public void setJobCommentTypeCdList(List<JobCommentTypeCdList> jobCommentTypeCdList) {
        this.jobCommentTypeCdList = jobCommentTypeCdList;
    }

    public Job withJobCommentTypeCdList(List<JobCommentTypeCdList> jobCommentTypeCdList) {
        this.jobCommentTypeCdList = jobCommentTypeCdList;
        return this;
    }

    @JsonProperty("OnTimeGuaranteeInd")
    public Object getOnTimeGuaranteeInd() {
        return onTimeGuaranteeInd;
    }

    @JsonProperty("OnTimeGuaranteeInd")
    public void setOnTimeGuaranteeInd(Object onTimeGuaranteeInd) {
        this.onTimeGuaranteeInd = onTimeGuaranteeInd;
    }

    public Job withOnTimeGuaranteeInd(Object onTimeGuaranteeInd) {
        this.onTimeGuaranteeInd = onTimeGuaranteeInd;
        return this;
    }

    @JsonProperty("CodAmount")
    public Object getCodAmount() {
        return codAmount;
    }

    @JsonProperty("CodAmount")
    public void setCodAmount(Object codAmount) {
        this.codAmount = codAmount;
    }

    public Job withCodAmount(Object codAmount) {
        this.codAmount = codAmount;
        return this;
    }

    @JsonProperty("EndDateTime")
    public Object getEndDateTime() {
        return endDateTime;
    }

    @JsonProperty("EndDateTime")
    public void setEndDateTime(Object endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Job withEndDateTime(Object endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    @JsonProperty("TroubleCallIndicator")
    public String getTroubleCallIndicator() {
        return troubleCallIndicator;
    }

    @JsonProperty("TroubleCallIndicator")
    public void setTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
    }

    public Job withTroubleCallIndicator(String troubleCallIndicator) {
        this.troubleCallIndicator = troubleCallIndicator;
        return this;
    }

    @JsonProperty("JobCustomFields")
    public JobCustomFields getJobCustomFields() {
        return jobCustomFields;
    }

    @JsonProperty("JobCustomFields")
    public void setJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
    }

    public Job withJobCustomFields(JobCustomFields jobCustomFields) {
        this.jobCustomFields = jobCustomFields;
        return this;
    }

    @JsonProperty("JobReasonCdList")
    public List<JobReasonCdList> getJobReasonCdList() {
        return jobReasonCdList;
    }

    @JsonProperty("JobReasonCdList")
    public void setJobReasonCdList(List<JobReasonCdList> jobReasonCdList) {
        this.jobReasonCdList = jobReasonCdList;
    }

    public Job withJobReasonCdList(List<JobReasonCdList> jobReasonCdList) {
        this.jobReasonCdList = jobReasonCdList;
        return this;
    }

    @JsonProperty("TimeZoneOffset")
    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    @JsonProperty("TimeZoneOffset")
    public void setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public Job withTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }

    @JsonProperty("JobReasonCode")
    public String getJobReasonCode() {
        return jobReasonCode;
    }

    @JsonProperty("JobReasonCode")
    public void setJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
    }

    public Job withJobReasonCode(String jobReasonCode) {
        this.jobReasonCode = jobReasonCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timeSlotDesc).append(workOrderNum).append(createDateTime).append(orderMgmtSystem).append(enRouteRequestInd).append(sourceId).append(callFirstPhoneNum).append(timeSlotCd).append(jobUnits).append(jobTypeCd).append(timeSlotEndTime).append(buId).append(jobResolutionCdList).append(daylightSavingsObserved).append(dispatcherStatusCd).append(timeSlotStartTime).append(initialStartDateTime).append(scheduleDate).append(jobNum).append(orderNum).append(technicianNum).append(installerType).append(businessUnit).append(lastChangeOper).append(salesmanNum).append(jobCommentTypeCdList).append(onTimeGuaranteeInd).append(codAmount).append(endDateTime).append(troubleCallIndicator).append(jobCustomFields).append(jobReasonCdList).append(timeZoneOffset).append(jobReasonCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Job) == false) {
            return false;
        }
        Job rhs = ((Job) other);
        return new EqualsBuilder().append(timeSlotDesc, rhs.timeSlotDesc).append(workOrderNum, rhs.workOrderNum).append(createDateTime, rhs.createDateTime).append(orderMgmtSystem, rhs.orderMgmtSystem).append(enRouteRequestInd, rhs.enRouteRequestInd).append(sourceId, rhs.sourceId).append(callFirstPhoneNum, rhs.callFirstPhoneNum).append(timeSlotCd, rhs.timeSlotCd).append(jobUnits, rhs.jobUnits).append(jobTypeCd, rhs.jobTypeCd).append(timeSlotEndTime, rhs.timeSlotEndTime).append(buId, rhs.buId).append(jobResolutionCdList, rhs.jobResolutionCdList).append(daylightSavingsObserved, rhs.daylightSavingsObserved).append(dispatcherStatusCd, rhs.dispatcherStatusCd).append(timeSlotStartTime, rhs.timeSlotStartTime).append(initialStartDateTime, rhs.initialStartDateTime).append(scheduleDate, rhs.scheduleDate).append(jobNum, rhs.jobNum).append(orderNum, rhs.orderNum).append(technicianNum, rhs.technicianNum).append(installerType, rhs.installerType).append(businessUnit, rhs.businessUnit).append(lastChangeOper, rhs.lastChangeOper).append(salesmanNum, rhs.salesmanNum).append(jobCommentTypeCdList, rhs.jobCommentTypeCdList).append(onTimeGuaranteeInd, rhs.onTimeGuaranteeInd).append(codAmount, rhs.codAmount).append(endDateTime, rhs.endDateTime).append(troubleCallIndicator, rhs.troubleCallIndicator).append(jobCustomFields, rhs.jobCustomFields).append(jobReasonCdList, rhs.jobReasonCdList).append(timeZoneOffset, rhs.timeZoneOffset).append(jobReasonCode, rhs.jobReasonCode).isEquals();
    }

}
