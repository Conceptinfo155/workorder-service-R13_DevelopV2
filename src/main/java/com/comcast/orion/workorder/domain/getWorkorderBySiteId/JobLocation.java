
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "ManagementArea",
    "HeadendCd",
    "HookupType",
    "DropLocationType",
    "Amplifier",
    "RouteCriteria",
    "DropLocationCd",
    "BldgTypeCd",
    "LocationCustomFields",
    "CensusCd",
    "Node",
    "AddrId",
    "LocationDropTags",
    "HouseMisc",
    "PoleNum",
    "ServiceArea",
    "HouseStatus",
    "PowerSupply",
    "Address",
    "TapStatusCd",
    "MapCode",
    "BridgerAddress"
})
public class JobLocation {

    @JsonProperty("ManagementArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String managementArea;
    @JsonProperty("HeadendCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String headendCd;
    @JsonProperty("HookupType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String hookupType;
    @JsonProperty("DropLocationType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object dropLocationType;
    @JsonProperty("Amplifier")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object amplifier;
    @JsonProperty("RouteCriteria")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String routeCriteria;
    @JsonProperty("DropLocationCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String dropLocationCd;
    @JsonProperty("BldgTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bldgTypeCd;
    @JsonProperty("LocationCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LocationCustomFields locationCustomFields;
    @JsonProperty("CensusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String censusCd;
    @JsonProperty("Node")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String node;
    @JsonProperty("AddrId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String addrId;
    @JsonProperty("LocationDropTags")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LocationDropTags locationDropTags;
    @JsonProperty("HouseMisc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object houseMisc;
    @JsonProperty("PoleNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String poleNum;
    @JsonProperty("ServiceArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object serviceArea;
    @JsonProperty("HouseStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String houseStatus;
    @JsonProperty("PowerSupply")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object powerSupply;
    @JsonProperty("Address")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Address address;
    @JsonProperty("TapStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tapStatusCd;
    @JsonProperty("MapCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    private Object mapCode;
    @JsonProperty("BridgerAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String bridgerAddress;

    @JsonProperty("ManagementArea")
    public String getManagementArea() {
        return managementArea;
    }

    @JsonProperty("ManagementArea")
    public void setManagementArea(String managementArea) {
        this.managementArea = managementArea;
    }

    public JobLocation withManagementArea(String managementArea) {
        this.managementArea = managementArea;
        return this;
    }

    @JsonProperty("HeadendCd")
    public String getHeadendCd() {
        return headendCd;
    }

    @JsonProperty("HeadendCd")
    public void setHeadendCd(String headendCd) {
        this.headendCd = headendCd;
    }

    public JobLocation withHeadendCd(String headendCd) {
        this.headendCd = headendCd;
        return this;
    }

    @JsonProperty("HookupType")
    public String getHookupType() {
        return hookupType;
    }

    @JsonProperty("HookupType")
    public void setHookupType(String hookupType) {
        this.hookupType = hookupType;
    }

    public JobLocation withHookupType(String hookupType) {
        this.hookupType = hookupType;
        return this;
    }

    @JsonProperty("DropLocationType")
    public Object getDropLocationType() {
        return dropLocationType;
    }

    @JsonProperty("DropLocationType")
    public void setDropLocationType(Object dropLocationType) {
        this.dropLocationType = dropLocationType;
    }

    public JobLocation withDropLocationType(Object dropLocationType) {
        this.dropLocationType = dropLocationType;
        return this;
    }

    @JsonProperty("Amplifier")
    public Object getAmplifier() {
        return amplifier;
    }

    @JsonProperty("Amplifier")
    public void setAmplifier(Object amplifier) {
        this.amplifier = amplifier;
    }

    public JobLocation withAmplifier(Object amplifier) {
        this.amplifier = amplifier;
        return this;
    }

    @JsonProperty("RouteCriteria")
    public String getRouteCriteria() {
        return routeCriteria;
    }

    @JsonProperty("RouteCriteria")
    public void setRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
    }

    public JobLocation withRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
        return this;
    }

    @JsonProperty("DropLocationCd")
    public String getDropLocationCd() {
        return dropLocationCd;
    }

    @JsonProperty("DropLocationCd")
    public void setDropLocationCd(String dropLocationCd) {
        this.dropLocationCd = dropLocationCd;
    }

    public JobLocation withDropLocationCd(String dropLocationCd) {
        this.dropLocationCd = dropLocationCd;
        return this;
    }

    @JsonProperty("BldgTypeCd")
    public String getBldgTypeCd() {
        return bldgTypeCd;
    }

    @JsonProperty("BldgTypeCd")
    public void setBldgTypeCd(String bldgTypeCd) {
        this.bldgTypeCd = bldgTypeCd;
    }

    public JobLocation withBldgTypeCd(String bldgTypeCd) {
        this.bldgTypeCd = bldgTypeCd;
        return this;
    }

    @JsonProperty("LocationCustomFields")
    public LocationCustomFields getLocationCustomFields() {
        return locationCustomFields;
    }

    @JsonProperty("LocationCustomFields")
    public void setLocationCustomFields(LocationCustomFields locationCustomFields) {
        this.locationCustomFields = locationCustomFields;
    }

    public JobLocation withLocationCustomFields(LocationCustomFields locationCustomFields) {
        this.locationCustomFields = locationCustomFields;
        return this;
    }

    @JsonProperty("CensusCd")
    public String getCensusCd() {
        return censusCd;
    }

    @JsonProperty("CensusCd")
    public void setCensusCd(String censusCd) {
        this.censusCd = censusCd;
    }

    public JobLocation withCensusCd(String censusCd) {
        this.censusCd = censusCd;
        return this;
    }

    @JsonProperty("Node")
    public String getNode() {
        return node;
    }

    @JsonProperty("Node")
    public void setNode(String node) {
        this.node = node;
    }

    public JobLocation withNode(String node) {
        this.node = node;
        return this;
    }

    @JsonProperty("AddrId")
    public String getAddrId() {
        return addrId;
    }

    @JsonProperty("AddrId")
    public void setAddrId(String addrId) {
        this.addrId = addrId;
    }

    public JobLocation withAddrId(String addrId) {
        this.addrId = addrId;
        return this;
    }

    @JsonProperty("LocationDropTags")
    public LocationDropTags getLocationDropTags() {
        return locationDropTags;
    }

    @JsonProperty("LocationDropTags")
    public void setLocationDropTags(LocationDropTags locationDropTags) {
        this.locationDropTags = locationDropTags;
    }

    public JobLocation withLocationDropTags(LocationDropTags locationDropTags) {
        this.locationDropTags = locationDropTags;
        return this;
    }

    @JsonProperty("HouseMisc")
    public Object getHouseMisc() {
        return houseMisc;
    }

    @JsonProperty("HouseMisc")
    public void setHouseMisc(Object houseMisc) {
        this.houseMisc = houseMisc;
    }

    public JobLocation withHouseMisc(Object houseMisc) {
        this.houseMisc = houseMisc;
        return this;
    }

    @JsonProperty("PoleNum")
    public String getPoleNum() {
        return poleNum;
    }

    @JsonProperty("PoleNum")
    public void setPoleNum(String poleNum) {
        this.poleNum = poleNum;
    }

    public JobLocation withPoleNum(String poleNum) {
        this.poleNum = poleNum;
        return this;
    }

    @JsonProperty("ServiceArea")
    public Object getServiceArea() {
        return serviceArea;
    }

    @JsonProperty("ServiceArea")
    public void setServiceArea(Object serviceArea) {
        this.serviceArea = serviceArea;
    }

    public JobLocation withServiceArea(Object serviceArea) {
        this.serviceArea = serviceArea;
        return this;
    }

    @JsonProperty("HouseStatus")
    public String getHouseStatus() {
        return houseStatus;
    }

    @JsonProperty("HouseStatus")
    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public JobLocation withHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
        return this;
    }

    @JsonProperty("PowerSupply")
    public Object getPowerSupply() {
        return powerSupply;
    }

    @JsonProperty("PowerSupply")
    public void setPowerSupply(Object powerSupply) {
        this.powerSupply = powerSupply;
    }

    public JobLocation withPowerSupply(Object powerSupply) {
        this.powerSupply = powerSupply;
        return this;
    }

    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public JobLocation withAddress(Address address) {
        this.address = address;
        return this;
    }

    @JsonProperty("TapStatusCd")
    public String getTapStatusCd() {
        return tapStatusCd;
    }

    @JsonProperty("TapStatusCd")
    public void setTapStatusCd(String tapStatusCd) {
        this.tapStatusCd = tapStatusCd;
    }

    public JobLocation withTapStatusCd(String tapStatusCd) {
        this.tapStatusCd = tapStatusCd;
        return this;
    }

    @JsonProperty("MapCode")
    public Object getMapCode() {
        return mapCode;
    }

    @JsonProperty("MapCode")
    public void setMapCode(Object mapCode) {
        this.mapCode = mapCode;
    }

    public JobLocation withMapCode(Object mapCode) {
        this.mapCode = mapCode;
        return this;
    }

    @JsonProperty("BridgerAddress")
    public String getBridgerAddress() {
        return bridgerAddress;
    }

    @JsonProperty("BridgerAddress")
    public void setBridgerAddress(String bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
    }

    public JobLocation withBridgerAddress(String bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(managementArea).append(headendCd).append(hookupType).append(dropLocationType).append(amplifier).append(routeCriteria).append(dropLocationCd).append(bldgTypeCd).append(locationCustomFields).append(censusCd).append(node).append(addrId).append(locationDropTags).append(houseMisc).append(poleNum).append(serviceArea).append(houseStatus).append(powerSupply).append(address).append(tapStatusCd).append(mapCode).append(bridgerAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobLocation) == false) {
            return false;
        }
        JobLocation rhs = ((JobLocation) other);
        return new EqualsBuilder().append(managementArea, rhs.managementArea).append(headendCd, rhs.headendCd).append(hookupType, rhs.hookupType).append(dropLocationType, rhs.dropLocationType).append(amplifier, rhs.amplifier).append(routeCriteria, rhs.routeCriteria).append(dropLocationCd, rhs.dropLocationCd).append(bldgTypeCd, rhs.bldgTypeCd).append(locationCustomFields, rhs.locationCustomFields).append(censusCd, rhs.censusCd).append(node, rhs.node).append(addrId, rhs.addrId).append(locationDropTags, rhs.locationDropTags).append(houseMisc, rhs.houseMisc).append(poleNum, rhs.poleNum).append(serviceArea, rhs.serviceArea).append(houseStatus, rhs.houseStatus).append(powerSupply, rhs.powerSupply).append(address, rhs.address).append(tapStatusCd, rhs.tapStatusCd).append(mapCode, rhs.mapCode).append(bridgerAddress, rhs.bridgerAddress).isEquals();
    }

}
