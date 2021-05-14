
package com.comcast.orion.workorder.domain.ods.customer;

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


/**
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "source",
    "recordStatus",
    "customerId",
    "customerLegalName",
    "state",
    "admBusOrgId",
    "athenaId",
    "businessRelationship",
    "businessTaxId",
    "classification",
    "cmCustomerSourceId",
    "customerAcquisitionDate",
    "customerName",
    "customerStatus",
    "disconnectDate",
    "extId",
    "franchisingIndicator",
    "migratedDate",
    "migratedIndicator",
    "odsEmployeeId",
    "relationshipOwner",
    "subClassification",
    "svCustomerBan",
    "svRootBan",
    "tsp",
    "parentCustomerId",
    "odsCustomerTypeId",
    "odsCustomerTypeDesc",
    "odsCustomerSubTypeId",
    "odsCustomerSubTypeDesc",
    "odsIndustryTypeId",
    "odsIndustryTypeDesc",
    "odsSubIndustryTypeId",
    "odsSubIndustryTypeDesc",
    "odsCurrencyCodeId",
    "odsCurrencyCodeName",
    "odsBillCycleId",
    "odsBillCycleDesc",
    "specialPopulationId",
    "specialPopulationDesc",
    "totalSites",
    "customerServiceError",
    "addresses",
    "addressServiceError",
    "contacts",
    "contactServiceError"
})
public class ODSCustomerResponse {

    @JsonProperty("source")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String source;
    @JsonProperty("recordStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String recordStatus;
    @JsonProperty("customerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerId;
    @JsonProperty("customerLegalName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerLegalName;
    @JsonProperty("state")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;
    @JsonProperty("admBusOrgId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String admBusOrgId;
    @JsonProperty("athenaId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String athenaId;
    @JsonProperty("businessRelationship")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String businessRelationship;
    @JsonProperty("businessTaxId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String businessTaxId;
    @JsonProperty("classification")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String classification;
    @JsonProperty("cmCustomerSourceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cmCustomerSourceId;
    @JsonProperty("customerAcquisitionDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerAcquisitionDate;
    @JsonProperty("customerName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerName;
    @JsonProperty("customerStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerStatus;
    @JsonProperty("disconnectDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String disconnectDate;
    @JsonProperty("extId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String extId;
    @JsonProperty("franchisingIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String franchisingIndicator;
    @JsonProperty("migratedDate")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String migratedDate;
    @JsonProperty("migratedIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String migratedIndicator;
    @JsonProperty("odsEmployeeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsEmployeeId;
    @JsonProperty("relationshipOwner")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String relationshipOwner;
    @JsonProperty("subClassification")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String subClassification;
    @JsonProperty("svCustomerBan")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String svCustomerBan;
    @JsonProperty("svRootBan")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String svRootBan;
    @JsonProperty("tsp")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tsp;
    @JsonProperty("parentCustomerId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String parentCustomerId;
    @JsonProperty("odsCustomerTypeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCustomerTypeId;
    @JsonProperty("odsCustomerTypeDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCustomerTypeDesc;
    @JsonProperty("odsCustomerSubTypeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCustomerSubTypeId;
    @JsonProperty("odsCustomerSubTypeDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCustomerSubTypeDesc;
    @JsonProperty("odsIndustryTypeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsIndustryTypeId;
    @JsonProperty("odsIndustryTypeDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsIndustryTypeDesc;
    @JsonProperty("odsSubIndustryTypeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsSubIndustryTypeId;
    @JsonProperty("odsSubIndustryTypeDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsSubIndustryTypeDesc;
    @JsonProperty("odsCurrencyCodeId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCurrencyCodeId;
    @JsonProperty("odsCurrencyCodeName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsCurrencyCodeName;
    @JsonProperty("odsBillCycleId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsBillCycleId;
    @JsonProperty("odsBillCycleDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String odsBillCycleDesc;
    @JsonProperty("specialPopulationId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String specialPopulationId;
    @JsonProperty("specialPopulationDesc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String specialPopulationDesc;
    @JsonProperty("totalSites")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String totalSites;
    @JsonProperty("customerServiceError")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CustomerServiceError customerServiceError;
    @JsonProperty("addresses")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Size(min = 1)
    @Valid
    private List<Address> addresses = new ArrayList<Address>();
    @JsonProperty("addressServiceError")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private AddressServiceError addressServiceError;
    @JsonProperty("contacts")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Size(min = 1)
    @Valid
    private List<Contact> contacts = new ArrayList<Contact>();
    @JsonProperty("contactServiceError")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ContactServiceError contactServiceError;

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public ODSCustomerResponse withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("recordStatus")
    public String getRecordStatus() {
        return recordStatus;
    }

    @JsonProperty("recordStatus")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public ODSCustomerResponse withRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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

    public ODSCustomerResponse withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    @JsonProperty("customerLegalName")
    public String getCustomerLegalName() {
        return customerLegalName;
    }

    @JsonProperty("customerLegalName")
    public void setCustomerLegalName(String customerLegalName) {
        this.customerLegalName = customerLegalName;
    }

    public ODSCustomerResponse withCustomerLegalName(String customerLegalName) {
        this.customerLegalName = customerLegalName;
        return this;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    public ODSCustomerResponse withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("admBusOrgId")
    public String getAdmBusOrgId() {
        return admBusOrgId;
    }

    @JsonProperty("admBusOrgId")
    public void setAdmBusOrgId(String admBusOrgId) {
        this.admBusOrgId = admBusOrgId;
    }

    public ODSCustomerResponse withAdmBusOrgId(String admBusOrgId) {
        this.admBusOrgId = admBusOrgId;
        return this;
    }

    @JsonProperty("athenaId")
    public String getAthenaId() {
        return athenaId;
    }

    @JsonProperty("athenaId")
    public void setAthenaId(String athenaId) {
        this.athenaId = athenaId;
    }

    public ODSCustomerResponse withAthenaId(String athenaId) {
        this.athenaId = athenaId;
        return this;
    }

    @JsonProperty("businessRelationship")
    public String getBusinessRelationship() {
        return businessRelationship;
    }

    @JsonProperty("businessRelationship")
    public void setBusinessRelationship(String businessRelationship) {
        this.businessRelationship = businessRelationship;
    }

    public ODSCustomerResponse withBusinessRelationship(String businessRelationship) {
        this.businessRelationship = businessRelationship;
        return this;
    }

    @JsonProperty("businessTaxId")
    public String getBusinessTaxId() {
        return businessTaxId;
    }

    @JsonProperty("businessTaxId")
    public void setBusinessTaxId(String businessTaxId) {
        this.businessTaxId = businessTaxId;
    }

    public ODSCustomerResponse withBusinessTaxId(String businessTaxId) {
        this.businessTaxId = businessTaxId;
        return this;
    }

    @JsonProperty("classification")
    public String getClassification() {
        return classification;
    }

    @JsonProperty("classification")
    public void setClassification(String classification) {
        this.classification = classification;
    }

    public ODSCustomerResponse withClassification(String classification) {
        this.classification = classification;
        return this;
    }

    @JsonProperty("cmCustomerSourceId")
    public String getCmCustomerSourceId() {
        return cmCustomerSourceId;
    }

    @JsonProperty("cmCustomerSourceId")
    public void setCmCustomerSourceId(String cmCustomerSourceId) {
        this.cmCustomerSourceId = cmCustomerSourceId;
    }

    public ODSCustomerResponse withCmCustomerSourceId(String cmCustomerSourceId) {
        this.cmCustomerSourceId = cmCustomerSourceId;
        return this;
    }

    @JsonProperty("customerAcquisitionDate")
    public String getCustomerAcquisitionDate() {
        return customerAcquisitionDate;
    }

    @JsonProperty("customerAcquisitionDate")
    public void setCustomerAcquisitionDate(String customerAcquisitionDate) {
        this.customerAcquisitionDate = customerAcquisitionDate;
    }

    public ODSCustomerResponse withCustomerAcquisitionDate(String customerAcquisitionDate) {
        this.customerAcquisitionDate = customerAcquisitionDate;
        return this;
    }

    @JsonProperty("customerName")
    public String getCustomerName() {
        return customerName;
    }

    @JsonProperty("customerName")
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ODSCustomerResponse withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    @JsonProperty("customerStatus")
    public String getCustomerStatus() {
        return customerStatus;
    }

    @JsonProperty("customerStatus")
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public ODSCustomerResponse withCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
        return this;
    }

    @JsonProperty("disconnectDate")
    public String getDisconnectDate() {
        return disconnectDate;
    }

    @JsonProperty("disconnectDate")
    public void setDisconnectDate(String disconnectDate) {
        this.disconnectDate = disconnectDate;
    }

    public ODSCustomerResponse withDisconnectDate(String disconnectDate) {
        this.disconnectDate = disconnectDate;
        return this;
    }

    @JsonProperty("extId")
    public String getExtId() {
        return extId;
    }

    @JsonProperty("extId")
    public void setExtId(String extId) {
        this.extId = extId;
    }

    public ODSCustomerResponse withExtId(String extId) {
        this.extId = extId;
        return this;
    }

    @JsonProperty("franchisingIndicator")
    public String getFranchisingIndicator() {
        return franchisingIndicator;
    }

    @JsonProperty("franchisingIndicator")
    public void setFranchisingIndicator(String franchisingIndicator) {
        this.franchisingIndicator = franchisingIndicator;
    }

    public ODSCustomerResponse withFranchisingIndicator(String franchisingIndicator) {
        this.franchisingIndicator = franchisingIndicator;
        return this;
    }

    @JsonProperty("migratedDate")
    public String getMigratedDate() {
        return migratedDate;
    }

    @JsonProperty("migratedDate")
    public void setMigratedDate(String migratedDate) {
        this.migratedDate = migratedDate;
    }

    public ODSCustomerResponse withMigratedDate(String migratedDate) {
        this.migratedDate = migratedDate;
        return this;
    }

    @JsonProperty("migratedIndicator")
    public String getMigratedIndicator() {
        return migratedIndicator;
    }

    @JsonProperty("migratedIndicator")
    public void setMigratedIndicator(String migratedIndicator) {
        this.migratedIndicator = migratedIndicator;
    }

    public ODSCustomerResponse withMigratedIndicator(String migratedIndicator) {
        this.migratedIndicator = migratedIndicator;
        return this;
    }

    @JsonProperty("odsEmployeeId")
    public String getOdsEmployeeId() {
        return odsEmployeeId;
    }

    @JsonProperty("odsEmployeeId")
    public void setOdsEmployeeId(String odsEmployeeId) {
        this.odsEmployeeId = odsEmployeeId;
    }

    public ODSCustomerResponse withOdsEmployeeId(String odsEmployeeId) {
        this.odsEmployeeId = odsEmployeeId;
        return this;
    }

    @JsonProperty("relationshipOwner")
    public String getRelationshipOwner() {
        return relationshipOwner;
    }

    @JsonProperty("relationshipOwner")
    public void setRelationshipOwner(String relationshipOwner) {
        this.relationshipOwner = relationshipOwner;
    }

    public ODSCustomerResponse withRelationshipOwner(String relationshipOwner) {
        this.relationshipOwner = relationshipOwner;
        return this;
    }

    @JsonProperty("subClassification")
    public String getSubClassification() {
        return subClassification;
    }

    @JsonProperty("subClassification")
    public void setSubClassification(String subClassification) {
        this.subClassification = subClassification;
    }

    public ODSCustomerResponse withSubClassification(String subClassification) {
        this.subClassification = subClassification;
        return this;
    }

    @JsonProperty("svCustomerBan")
    public String getSvCustomerBan() {
        return svCustomerBan;
    }

    @JsonProperty("svCustomerBan")
    public void setSvCustomerBan(String svCustomerBan) {
        this.svCustomerBan = svCustomerBan;
    }

    public ODSCustomerResponse withSvCustomerBan(String svCustomerBan) {
        this.svCustomerBan = svCustomerBan;
        return this;
    }

    @JsonProperty("svRootBan")
    public String getSvRootBan() {
        return svRootBan;
    }

    @JsonProperty("svRootBan")
    public void setSvRootBan(String svRootBan) {
        this.svRootBan = svRootBan;
    }

    public ODSCustomerResponse withSvRootBan(String svRootBan) {
        this.svRootBan = svRootBan;
        return this;
    }

    @JsonProperty("tsp")
    public String getTsp() {
        return tsp;
    }

    @JsonProperty("tsp")
    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public ODSCustomerResponse withTsp(String tsp) {
        this.tsp = tsp;
        return this;
    }

    @JsonProperty("parentCustomerId")
    public String getParentCustomerId() {
        return parentCustomerId;
    }

    @JsonProperty("parentCustomerId")
    public void setParentCustomerId(String parentCustomerId) {
        this.parentCustomerId = parentCustomerId;
    }

    public ODSCustomerResponse withParentCustomerId(String parentCustomerId) {
        this.parentCustomerId = parentCustomerId;
        return this;
    }

    @JsonProperty("odsCustomerTypeId")
    public String getOdsCustomerTypeId() {
        return odsCustomerTypeId;
    }

    @JsonProperty("odsCustomerTypeId")
    public void setOdsCustomerTypeId(String odsCustomerTypeId) {
        this.odsCustomerTypeId = odsCustomerTypeId;
    }

    public ODSCustomerResponse withOdsCustomerTypeId(String odsCustomerTypeId) {
        this.odsCustomerTypeId = odsCustomerTypeId;
        return this;
    }

    @JsonProperty("odsCustomerTypeDesc")
    public String getOdsCustomerTypeDesc() {
        return odsCustomerTypeDesc;
    }

    @JsonProperty("odsCustomerTypeDesc")
    public void setOdsCustomerTypeDesc(String odsCustomerTypeDesc) {
        this.odsCustomerTypeDesc = odsCustomerTypeDesc;
    }

    public ODSCustomerResponse withOdsCustomerTypeDesc(String odsCustomerTypeDesc) {
        this.odsCustomerTypeDesc = odsCustomerTypeDesc;
        return this;
    }

    @JsonProperty("odsCustomerSubTypeId")
    public String getOdsCustomerSubTypeId() {
        return odsCustomerSubTypeId;
    }

    @JsonProperty("odsCustomerSubTypeId")
    public void setOdsCustomerSubTypeId(String odsCustomerSubTypeId) {
        this.odsCustomerSubTypeId = odsCustomerSubTypeId;
    }

    public ODSCustomerResponse withOdsCustomerSubTypeId(String odsCustomerSubTypeId) {
        this.odsCustomerSubTypeId = odsCustomerSubTypeId;
        return this;
    }

    @JsonProperty("odsCustomerSubTypeDesc")
    public String getOdsCustomerSubTypeDesc() {
        return odsCustomerSubTypeDesc;
    }

    @JsonProperty("odsCustomerSubTypeDesc")
    public void setOdsCustomerSubTypeDesc(String odsCustomerSubTypeDesc) {
        this.odsCustomerSubTypeDesc = odsCustomerSubTypeDesc;
    }

    public ODSCustomerResponse withOdsCustomerSubTypeDesc(String odsCustomerSubTypeDesc) {
        this.odsCustomerSubTypeDesc = odsCustomerSubTypeDesc;
        return this;
    }

    @JsonProperty("odsIndustryTypeId")
    public String getOdsIndustryTypeId() {
        return odsIndustryTypeId;
    }

    @JsonProperty("odsIndustryTypeId")
    public void setOdsIndustryTypeId(String odsIndustryTypeId) {
        this.odsIndustryTypeId = odsIndustryTypeId;
    }

    public ODSCustomerResponse withOdsIndustryTypeId(String odsIndustryTypeId) {
        this.odsIndustryTypeId = odsIndustryTypeId;
        return this;
    }

    @JsonProperty("odsIndustryTypeDesc")
    public String getOdsIndustryTypeDesc() {
        return odsIndustryTypeDesc;
    }

    @JsonProperty("odsIndustryTypeDesc")
    public void setOdsIndustryTypeDesc(String odsIndustryTypeDesc) {
        this.odsIndustryTypeDesc = odsIndustryTypeDesc;
    }

    public ODSCustomerResponse withOdsIndustryTypeDesc(String odsIndustryTypeDesc) {
        this.odsIndustryTypeDesc = odsIndustryTypeDesc;
        return this;
    }

    @JsonProperty("odsSubIndustryTypeId")
    public String getOdsSubIndustryTypeId() {
        return odsSubIndustryTypeId;
    }

    @JsonProperty("odsSubIndustryTypeId")
    public void setOdsSubIndustryTypeId(String odsSubIndustryTypeId) {
        this.odsSubIndustryTypeId = odsSubIndustryTypeId;
    }

    public ODSCustomerResponse withOdsSubIndustryTypeId(String odsSubIndustryTypeId) {
        this.odsSubIndustryTypeId = odsSubIndustryTypeId;
        return this;
    }

    @JsonProperty("odsSubIndustryTypeDesc")
    public String getOdsSubIndustryTypeDesc() {
        return odsSubIndustryTypeDesc;
    }

    @JsonProperty("odsSubIndustryTypeDesc")
    public void setOdsSubIndustryTypeDesc(String odsSubIndustryTypeDesc) {
        this.odsSubIndustryTypeDesc = odsSubIndustryTypeDesc;
    }

    public ODSCustomerResponse withOdsSubIndustryTypeDesc(String odsSubIndustryTypeDesc) {
        this.odsSubIndustryTypeDesc = odsSubIndustryTypeDesc;
        return this;
    }

    @JsonProperty("odsCurrencyCodeId")
    public String getOdsCurrencyCodeId() {
        return odsCurrencyCodeId;
    }

    @JsonProperty("odsCurrencyCodeId")
    public void setOdsCurrencyCodeId(String odsCurrencyCodeId) {
        this.odsCurrencyCodeId = odsCurrencyCodeId;
    }

    public ODSCustomerResponse withOdsCurrencyCodeId(String odsCurrencyCodeId) {
        this.odsCurrencyCodeId = odsCurrencyCodeId;
        return this;
    }

    @JsonProperty("odsCurrencyCodeName")
    public String getOdsCurrencyCodeName() {
        return odsCurrencyCodeName;
    }

    @JsonProperty("odsCurrencyCodeName")
    public void setOdsCurrencyCodeName(String odsCurrencyCodeName) {
        this.odsCurrencyCodeName = odsCurrencyCodeName;
    }

    public ODSCustomerResponse withOdsCurrencyCodeName(String odsCurrencyCodeName) {
        this.odsCurrencyCodeName = odsCurrencyCodeName;
        return this;
    }

    @JsonProperty("odsBillCycleId")
    public String getOdsBillCycleId() {
        return odsBillCycleId;
    }

    @JsonProperty("odsBillCycleId")
    public void setOdsBillCycleId(String odsBillCycleId) {
        this.odsBillCycleId = odsBillCycleId;
    }

    public ODSCustomerResponse withOdsBillCycleId(String odsBillCycleId) {
        this.odsBillCycleId = odsBillCycleId;
        return this;
    }

    @JsonProperty("odsBillCycleDesc")
    public String getOdsBillCycleDesc() {
        return odsBillCycleDesc;
    }

    @JsonProperty("odsBillCycleDesc")
    public void setOdsBillCycleDesc(String odsBillCycleDesc) {
        this.odsBillCycleDesc = odsBillCycleDesc;
    }

    public ODSCustomerResponse withOdsBillCycleDesc(String odsBillCycleDesc) {
        this.odsBillCycleDesc = odsBillCycleDesc;
        return this;
    }

    @JsonProperty("specialPopulationId")
    public String getSpecialPopulationId() {
        return specialPopulationId;
    }

    @JsonProperty("specialPopulationId")
    public void setSpecialPopulationId(String specialPopulationId) {
        this.specialPopulationId = specialPopulationId;
    }

    public ODSCustomerResponse withSpecialPopulationId(String specialPopulationId) {
        this.specialPopulationId = specialPopulationId;
        return this;
    }

    @JsonProperty("specialPopulationDesc")
    public String getSpecialPopulationDesc() {
        return specialPopulationDesc;
    }

    @JsonProperty("specialPopulationDesc")
    public void setSpecialPopulationDesc(String specialPopulationDesc) {
        this.specialPopulationDesc = specialPopulationDesc;
    }

    public ODSCustomerResponse withSpecialPopulationDesc(String specialPopulationDesc) {
        this.specialPopulationDesc = specialPopulationDesc;
        return this;
    }

    @JsonProperty("totalSites")
    public String getTotalSites() {
        return totalSites;
    }

    @JsonProperty("totalSites")
    public void setTotalSites(String totalSites) {
        this.totalSites = totalSites;
    }

    public ODSCustomerResponse withTotalSites(String totalSites) {
        this.totalSites = totalSites;
        return this;
    }

    @JsonProperty("customerServiceError")
    public CustomerServiceError getCustomerServiceError() {
        return customerServiceError;
    }

    @JsonProperty("customerServiceError")
    public void setCustomerServiceError(CustomerServiceError customerServiceError) {
        this.customerServiceError = customerServiceError;
    }

    public ODSCustomerResponse withCustomerServiceError(CustomerServiceError customerServiceError) {
        this.customerServiceError = customerServiceError;
        return this;
    }

    @JsonProperty("addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    @JsonProperty("addresses")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public ODSCustomerResponse withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    @JsonProperty("addressServiceError")
    public AddressServiceError getAddressServiceError() {
        return addressServiceError;
    }

    @JsonProperty("addressServiceError")
    public void setAddressServiceError(AddressServiceError addressServiceError) {
        this.addressServiceError = addressServiceError;
    }

    public ODSCustomerResponse withAddressServiceError(AddressServiceError addressServiceError) {
        this.addressServiceError = addressServiceError;
        return this;
    }

    @JsonProperty("contacts")
    public List<Contact> getContacts() {
        return contacts;
    }

    @JsonProperty("contacts")
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public ODSCustomerResponse withContacts(List<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    @JsonProperty("contactServiceError")
    public ContactServiceError getContactServiceError() {
        return contactServiceError;
    }

    @JsonProperty("contactServiceError")
    public void setContactServiceError(ContactServiceError contactServiceError) {
        this.contactServiceError = contactServiceError;
    }

    public ODSCustomerResponse withContactServiceError(ContactServiceError contactServiceError) {
        this.contactServiceError = contactServiceError;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(recordStatus).append(customerId).append(customerLegalName).append(state).append(admBusOrgId).append(athenaId).append(businessRelationship).append(businessTaxId).append(classification).append(cmCustomerSourceId).append(customerAcquisitionDate).append(customerName).append(customerStatus).append(disconnectDate).append(extId).append(franchisingIndicator).append(migratedDate).append(migratedIndicator).append(odsEmployeeId).append(relationshipOwner).append(subClassification).append(svCustomerBan).append(svRootBan).append(tsp).append(parentCustomerId).append(odsCustomerTypeId).append(odsCustomerTypeDesc).append(odsCustomerSubTypeId).append(odsCustomerSubTypeDesc).append(odsIndustryTypeId).append(odsIndustryTypeDesc).append(odsSubIndustryTypeId).append(odsSubIndustryTypeDesc).append(odsCurrencyCodeId).append(odsCurrencyCodeName).append(odsBillCycleId).append(odsBillCycleDesc).append(specialPopulationId).append(specialPopulationDesc).append(totalSites).append(customerServiceError).append(addresses).append(addressServiceError).append(contacts).append(contactServiceError).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ODSCustomerResponse) == false) {
            return false;
        }
        ODSCustomerResponse rhs = ((ODSCustomerResponse) other);
        return new EqualsBuilder().append(source, rhs.source).append(recordStatus, rhs.recordStatus).append(customerId, rhs.customerId).append(customerLegalName, rhs.customerLegalName).append(state, rhs.state).append(admBusOrgId, rhs.admBusOrgId).append(athenaId, rhs.athenaId).append(businessRelationship, rhs.businessRelationship).append(businessTaxId, rhs.businessTaxId).append(classification, rhs.classification).append(cmCustomerSourceId, rhs.cmCustomerSourceId).append(customerAcquisitionDate, rhs.customerAcquisitionDate).append(customerName, rhs.customerName).append(customerStatus, rhs.customerStatus).append(disconnectDate, rhs.disconnectDate).append(extId, rhs.extId).append(franchisingIndicator, rhs.franchisingIndicator).append(migratedDate, rhs.migratedDate).append(migratedIndicator, rhs.migratedIndicator).append(odsEmployeeId, rhs.odsEmployeeId).append(relationshipOwner, rhs.relationshipOwner).append(subClassification, rhs.subClassification).append(svCustomerBan, rhs.svCustomerBan).append(svRootBan, rhs.svRootBan).append(tsp, rhs.tsp).append(parentCustomerId, rhs.parentCustomerId).append(odsCustomerTypeId, rhs.odsCustomerTypeId).append(odsCustomerTypeDesc, rhs.odsCustomerTypeDesc).append(odsCustomerSubTypeId, rhs.odsCustomerSubTypeId).append(odsCustomerSubTypeDesc, rhs.odsCustomerSubTypeDesc).append(odsIndustryTypeId, rhs.odsIndustryTypeId).append(odsIndustryTypeDesc, rhs.odsIndustryTypeDesc).append(odsSubIndustryTypeId, rhs.odsSubIndustryTypeId).append(odsSubIndustryTypeDesc, rhs.odsSubIndustryTypeDesc).append(odsCurrencyCodeId, rhs.odsCurrencyCodeId).append(odsCurrencyCodeName, rhs.odsCurrencyCodeName).append(odsBillCycleId, rhs.odsBillCycleId).append(odsBillCycleDesc, rhs.odsBillCycleDesc).append(specialPopulationId, rhs.specialPopulationId).append(specialPopulationDesc, rhs.specialPopulationDesc).append(totalSites, rhs.totalSites).append(customerServiceError, rhs.customerServiceError).append(addresses, rhs.addresses).append(addressServiceError, rhs.addressServiceError).append(contacts, rhs.contacts).append(contactServiceError, rhs.contactServiceError).isEquals();
    }

}
