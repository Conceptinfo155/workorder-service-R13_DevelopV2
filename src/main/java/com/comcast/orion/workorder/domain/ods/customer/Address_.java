
package com.comcast.orion.workorder.domain.ods.customer;

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
    "source",
    "addressId",
    "recordStatus",
    "naxId",
    "elocId",
    "cuid",
    "referenceId",
    "type",
    "addressType",
    "unitType",
    "unitNumber",
    "addressLine1",
    "addressLine2",
    "addressLine3",
    "addressLine4",
    "city",
    "state",
    "county",
    "country",
    "stateCode",
    "countryCode",
    "zipCode",
    "zipExtension",
    "addressValidationInd",
    "latitude",
    "longitude",
    "timeZone",
    "daylightSavingTimeInd",
    "censusBlock",
    "greenFieldInd",
    "vertex",
    "cran",
    "headend",
    "headendCLLI",
    "fiberNodeName",
    "division",
    "region",
    "market",
    "subMarket",
    "busiUnit",
    "franchiseInd",
    "rateCenterCertification",
    "rateCenterName",
    "ilecName",
    "psapAgency",
    "psapId",
    "lata",
    "lataName"
})
public class Address_ {

    @JsonProperty("source")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String source;
    @JsonProperty("addressId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressId;
    @JsonProperty("recordStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String recordStatus;
    @JsonProperty("naxId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String naxId;
    @JsonProperty("elocId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String elocId;
    @JsonProperty("cuid")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cuid;
    @JsonProperty("referenceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String referenceId;
    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("addressType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressType;
    @JsonProperty("unitType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String unitType;
    @JsonProperty("unitNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String unitNumber;
    @JsonProperty("addressLine1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressLine1;
    @JsonProperty("addressLine2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressLine2;
    @JsonProperty("addressLine3")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressLine3;
    @JsonProperty("addressLine4")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressLine4;
    @JsonProperty("city")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String city;
    @JsonProperty("state")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;
    @JsonProperty("county")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String county;
    @JsonProperty("country")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String country;
    @JsonProperty("stateCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String stateCode;
    @JsonProperty("countryCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String countryCode;
    @JsonProperty("zipCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zipCode;
    @JsonProperty("zipExtension")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zipExtension;
    @JsonProperty("addressValidationInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addressValidationInd;
    @JsonProperty("latitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String latitude;
    @JsonProperty("longitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String longitude;
    @JsonProperty("timeZone")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String timeZone;
    @JsonProperty("daylightSavingTimeInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String daylightSavingTimeInd;
    @JsonProperty("censusBlock")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String censusBlock;
    @JsonProperty("greenFieldInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String greenFieldInd;
    @JsonProperty("vertex")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String vertex;
    @JsonProperty("cran")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cran;
    @JsonProperty("headend")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headend;
    @JsonProperty("headendCLLI")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headendCLLI;
    @JsonProperty("fiberNodeName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String fiberNodeName;
    @JsonProperty("division")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String division;
    @JsonProperty("region")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String region;
    @JsonProperty("market")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String market;
    @JsonProperty("subMarket")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String subMarket;
    @JsonProperty("busiUnit")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String busiUnit;
    @JsonProperty("franchiseInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String franchiseInd;
    @JsonProperty("rateCenterCertification")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String rateCenterCertification;
    @JsonProperty("rateCenterName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String rateCenterName;
    @JsonProperty("ilecName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ilecName;
    @JsonProperty("psapAgency")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String psapAgency;
    @JsonProperty("psapId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String psapId;
    @JsonProperty("lata")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lata;
    @JsonProperty("lataName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lataName;

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public Address_ withSource(String source) {
        this.source = source;
        return this;
    }

    @JsonProperty("addressId")
    public String getAddressId() {
        return addressId;
    }

    @JsonProperty("addressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Address_ withAddressId(String addressId) {
        this.addressId = addressId;
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

    public Address_ withRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
        return this;
    }

    @JsonProperty("naxId")
    public String getNaxId() {
        return naxId;
    }

    @JsonProperty("naxId")
    public void setNaxId(String naxId) {
        this.naxId = naxId;
    }

    public Address_ withNaxId(String naxId) {
        this.naxId = naxId;
        return this;
    }

    @JsonProperty("elocId")
    public String getElocId() {
        return elocId;
    }

    @JsonProperty("elocId")
    public void setElocId(String elocId) {
        this.elocId = elocId;
    }

    public Address_ withElocId(String elocId) {
        this.elocId = elocId;
        return this;
    }

    @JsonProperty("cuid")
    public String getCuid() {
        return cuid;
    }

    @JsonProperty("cuid")
    public void setCuid(String cuid) {
        this.cuid = cuid;
    }

    public Address_ withCuid(String cuid) {
        this.cuid = cuid;
        return this;
    }

    @JsonProperty("referenceId")
    public String getReferenceId() {
        return referenceId;
    }

    @JsonProperty("referenceId")
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Address_ withReferenceId(String referenceId) {
        this.referenceId = referenceId;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Address_ withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("addressType")
    public String getAddressType() {
        return addressType;
    }

    @JsonProperty("addressType")
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Address_ withAddressType(String addressType) {
        this.addressType = addressType;
        return this;
    }

    @JsonProperty("unitType")
    public String getUnitType() {
        return unitType;
    }

    @JsonProperty("unitType")
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Address_ withUnitType(String unitType) {
        this.unitType = unitType;
        return this;
    }

    @JsonProperty("unitNumber")
    public String getUnitNumber() {
        return unitNumber;
    }

    @JsonProperty("unitNumber")
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Address_ withUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
        return this;
    }

    @JsonProperty("addressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("addressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Address_ withAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    @JsonProperty("addressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    @JsonProperty("addressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Address_ withAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    @JsonProperty("addressLine3")
    public String getAddressLine3() {
        return addressLine3;
    }

    @JsonProperty("addressLine3")
    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public Address_ withAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    @JsonProperty("addressLine4")
    public String getAddressLine4() {
        return addressLine4;
    }

    @JsonProperty("addressLine4")
    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    public Address_ withAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
        return this;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    public Address_ withCity(String city) {
        this.city = city;
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

    public Address_ withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    public Address_ withCounty(String county) {
        this.county = county;
        return this;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    public Address_ withCountry(String country) {
        this.country = country;
        return this;
    }

    @JsonProperty("stateCode")
    public String getStateCode() {
        return stateCode;
    }

    @JsonProperty("stateCode")
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Address_ withStateCode(String stateCode) {
        this.stateCode = stateCode;
        return this;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Address_ withCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Address_ withZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @JsonProperty("zipExtension")
    public String getZipExtension() {
        return zipExtension;
    }

    @JsonProperty("zipExtension")
    public void setZipExtension(String zipExtension) {
        this.zipExtension = zipExtension;
    }

    public Address_ withZipExtension(String zipExtension) {
        this.zipExtension = zipExtension;
        return this;
    }

    @JsonProperty("addressValidationInd")
    public String getAddressValidationInd() {
        return addressValidationInd;
    }

    @JsonProperty("addressValidationInd")
    public void setAddressValidationInd(String addressValidationInd) {
        this.addressValidationInd = addressValidationInd;
    }

    public Address_ withAddressValidationInd(String addressValidationInd) {
        this.addressValidationInd = addressValidationInd;
        return this;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Address_ withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Address_ withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Address_ withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    @JsonProperty("daylightSavingTimeInd")
    public String getDaylightSavingTimeInd() {
        return daylightSavingTimeInd;
    }

    @JsonProperty("daylightSavingTimeInd")
    public void setDaylightSavingTimeInd(String daylightSavingTimeInd) {
        this.daylightSavingTimeInd = daylightSavingTimeInd;
    }

    public Address_ withDaylightSavingTimeInd(String daylightSavingTimeInd) {
        this.daylightSavingTimeInd = daylightSavingTimeInd;
        return this;
    }

    @JsonProperty("censusBlock")
    public String getCensusBlock() {
        return censusBlock;
    }

    @JsonProperty("censusBlock")
    public void setCensusBlock(String censusBlock) {
        this.censusBlock = censusBlock;
    }

    public Address_ withCensusBlock(String censusBlock) {
        this.censusBlock = censusBlock;
        return this;
    }

    @JsonProperty("greenFieldInd")
    public String getGreenFieldInd() {
        return greenFieldInd;
    }

    @JsonProperty("greenFieldInd")
    public void setGreenFieldInd(String greenFieldInd) {
        this.greenFieldInd = greenFieldInd;
    }

    public Address_ withGreenFieldInd(String greenFieldInd) {
        this.greenFieldInd = greenFieldInd;
        return this;
    }

    @JsonProperty("vertex")
    public String getVertex() {
        return vertex;
    }

    @JsonProperty("vertex")
    public void setVertex(String vertex) {
        this.vertex = vertex;
    }

    public Address_ withVertex(String vertex) {
        this.vertex = vertex;
        return this;
    }

    @JsonProperty("cran")
    public String getCran() {
        return cran;
    }

    @JsonProperty("cran")
    public void setCran(String cran) {
        this.cran = cran;
    }

    public Address_ withCran(String cran) {
        this.cran = cran;
        return this;
    }

    @JsonProperty("headend")
    public String getHeadend() {
        return headend;
    }

    @JsonProperty("headend")
    public void setHeadend(String headend) {
        this.headend = headend;
    }

    public Address_ withHeadend(String headend) {
        this.headend = headend;
        return this;
    }

    @JsonProperty("headendCLLI")
    public String getHeadendCLLI() {
        return headendCLLI;
    }

    @JsonProperty("headendCLLI")
    public void setHeadendCLLI(String headendCLLI) {
        this.headendCLLI = headendCLLI;
    }

    public Address_ withHeadendCLLI(String headendCLLI) {
        this.headendCLLI = headendCLLI;
        return this;
    }

    @JsonProperty("fiberNodeName")
    public String getFiberNodeName() {
        return fiberNodeName;
    }

    @JsonProperty("fiberNodeName")
    public void setFiberNodeName(String fiberNodeName) {
        this.fiberNodeName = fiberNodeName;
    }

    public Address_ withFiberNodeName(String fiberNodeName) {
        this.fiberNodeName = fiberNodeName;
        return this;
    }

    @JsonProperty("division")
    public String getDivision() {
        return division;
    }

    @JsonProperty("division")
    public void setDivision(String division) {
        this.division = division;
    }

    public Address_ withDivision(String division) {
        this.division = division;
        return this;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public Address_ withRegion(String region) {
        this.region = region;
        return this;
    }

    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    public Address_ withMarket(String market) {
        this.market = market;
        return this;
    }

    @JsonProperty("subMarket")
    public String getSubMarket() {
        return subMarket;
    }

    @JsonProperty("subMarket")
    public void setSubMarket(String subMarket) {
        this.subMarket = subMarket;
    }

    public Address_ withSubMarket(String subMarket) {
        this.subMarket = subMarket;
        return this;
    }

    @JsonProperty("busiUnit")
    public String getBusiUnit() {
        return busiUnit;
    }

    @JsonProperty("busiUnit")
    public void setBusiUnit(String busiUnit) {
        this.busiUnit = busiUnit;
    }

    public Address_ withBusiUnit(String busiUnit) {
        this.busiUnit = busiUnit;
        return this;
    }

    @JsonProperty("franchiseInd")
    public String getFranchiseInd() {
        return franchiseInd;
    }

    @JsonProperty("franchiseInd")
    public void setFranchiseInd(String franchiseInd) {
        this.franchiseInd = franchiseInd;
    }

    public Address_ withFranchiseInd(String franchiseInd) {
        this.franchiseInd = franchiseInd;
        return this;
    }

    @JsonProperty("rateCenterCertification")
    public String getRateCenterCertification() {
        return rateCenterCertification;
    }

    @JsonProperty("rateCenterCertification")
    public void setRateCenterCertification(String rateCenterCertification) {
        this.rateCenterCertification = rateCenterCertification;
    }

    public Address_ withRateCenterCertification(String rateCenterCertification) {
        this.rateCenterCertification = rateCenterCertification;
        return this;
    }

    @JsonProperty("rateCenterName")
    public String getRateCenterName() {
        return rateCenterName;
    }

    @JsonProperty("rateCenterName")
    public void setRateCenterName(String rateCenterName) {
        this.rateCenterName = rateCenterName;
    }

    public Address_ withRateCenterName(String rateCenterName) {
        this.rateCenterName = rateCenterName;
        return this;
    }

    @JsonProperty("ilecName")
    public String getIlecName() {
        return ilecName;
    }

    @JsonProperty("ilecName")
    public void setIlecName(String ilecName) {
        this.ilecName = ilecName;
    }

    public Address_ withIlecName(String ilecName) {
        this.ilecName = ilecName;
        return this;
    }

    @JsonProperty("psapAgency")
    public String getPsapAgency() {
        return psapAgency;
    }

    @JsonProperty("psapAgency")
    public void setPsapAgency(String psapAgency) {
        this.psapAgency = psapAgency;
    }

    public Address_ withPsapAgency(String psapAgency) {
        this.psapAgency = psapAgency;
        return this;
    }

    @JsonProperty("psapId")
    public String getPsapId() {
        return psapId;
    }

    @JsonProperty("psapId")
    public void setPsapId(String psapId) {
        this.psapId = psapId;
    }

    public Address_ withPsapId(String psapId) {
        this.psapId = psapId;
        return this;
    }

    @JsonProperty("lata")
    public String getLata() {
        return lata;
    }

    @JsonProperty("lata")
    public void setLata(String lata) {
        this.lata = lata;
    }

    public Address_ withLata(String lata) {
        this.lata = lata;
        return this;
    }

    @JsonProperty("lataName")
    public String getLataName() {
        return lataName;
    }

    @JsonProperty("lataName")
    public void setLataName(String lataName) {
        this.lataName = lataName;
    }

    public Address_ withLataName(String lataName) {
        this.lataName = lataName;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(addressId).append(recordStatus).append(naxId).append(elocId).append(cuid).append(referenceId).append(type).append(addressType).append(unitType).append(unitNumber).append(addressLine1).append(addressLine2).append(addressLine3).append(addressLine4).append(city).append(state).append(county).append(country).append(stateCode).append(countryCode).append(zipCode).append(zipExtension).append(addressValidationInd).append(latitude).append(longitude).append(timeZone).append(daylightSavingTimeInd).append(censusBlock).append(greenFieldInd).append(vertex).append(cran).append(headend).append(headendCLLI).append(fiberNodeName).append(division).append(region).append(market).append(subMarket).append(busiUnit).append(franchiseInd).append(rateCenterCertification).append(rateCenterName).append(ilecName).append(psapAgency).append(psapId).append(lata).append(lataName).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address_) == false) {
            return false;
        }
        Address_ rhs = ((Address_) other);
        return new EqualsBuilder().append(source, rhs.source).append(addressId, rhs.addressId).append(recordStatus, rhs.recordStatus).append(naxId, rhs.naxId).append(elocId, rhs.elocId).append(cuid, rhs.cuid).append(referenceId, rhs.referenceId).append(type, rhs.type).append(addressType, rhs.addressType).append(unitType, rhs.unitType).append(unitNumber, rhs.unitNumber).append(addressLine1, rhs.addressLine1).append(addressLine2, rhs.addressLine2).append(addressLine3, rhs.addressLine3).append(addressLine4, rhs.addressLine4).append(city, rhs.city).append(state, rhs.state).append(county, rhs.county).append(country, rhs.country).append(stateCode, rhs.stateCode).append(countryCode, rhs.countryCode).append(zipCode, rhs.zipCode).append(zipExtension, rhs.zipExtension).append(addressValidationInd, rhs.addressValidationInd).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(timeZone, rhs.timeZone).append(daylightSavingTimeInd, rhs.daylightSavingTimeInd).append(censusBlock, rhs.censusBlock).append(greenFieldInd, rhs.greenFieldInd).append(vertex, rhs.vertex).append(cran, rhs.cran).append(headend, rhs.headend).append(headendCLLI, rhs.headendCLLI).append(fiberNodeName, rhs.fiberNodeName).append(division, rhs.division).append(region, rhs.region).append(market, rhs.market).append(subMarket, rhs.subMarket).append(busiUnit, rhs.busiUnit).append(franchiseInd, rhs.franchiseInd).append(rateCenterCertification, rhs.rateCenterCertification).append(rateCenterName, rhs.rateCenterName).append(ilecName, rhs.ilecName).append(psapAgency, rhs.psapAgency).append(psapId, rhs.psapId).append(lata, rhs.lata).append(lataName, rhs.lataName).isEquals();
    }

}
