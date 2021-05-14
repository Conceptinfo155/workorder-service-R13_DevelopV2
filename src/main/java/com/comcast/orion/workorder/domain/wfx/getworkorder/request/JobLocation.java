
package com.comcast.orion.workorder.domain.wfx.getworkorder.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * The Joblocation Schema
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "ServiceArea",
    "Address",
    "LocationDropTags",
    "HouseMisc",
    "DropLocationCd",
    "PowerSupply",
    "BldgTypeCd",
    "HouseComment",
    "RouteCriteria",
    "HookupType",
    "HeadendCd",
    "ManagementArea",
    "Amplifier",
    "HouseStatus",
    "MapCd",
    "DropType",
    "LocationCustomFields",
    "CensusCd",
    "BridgerAddress",
    "PoleNum",
    "TapStatusCd",
    "Node"
})
public class JobLocation {

    /**
     * The Servicearea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ServiceArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object serviceArea = null;
    /**
     * The Address Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Address")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private Address address;
    /**
     * The Locationdroptags Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationDropTags")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private LocationDropTags locationDropTags;
    /**
     * The Housemisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseMisc")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object houseMisc = null;
    /**
     * The Droplocationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropLocationCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object dropLocationCd = null;
    /**
     * The Powersupply Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PowerSupply")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object powerSupply = null;
    /**
     * The Bldgtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BldgTypeCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object bldgTypeCd = null;
    /**
     * The Housecomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseComment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object houseComment = null;
    /**
     * The Routecriteria Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RouteCriteria")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    @Pattern(regexp = "^(.*)$")
    @NotNull
    private String routeCriteria = "";
    /**
     * The Hookuptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HookupType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object hookupType = null;
    /**
     * The Headendcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HeadendCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object headendCd = null;
    /**
     * The Managementarea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ManagementArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object managementArea = null;
    /**
     * The Amplifier Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Amplifier")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object amplifier = null;
    /**
     * The Housestatus Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object houseStatus = null;
    /**
     * The Mapcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("MapCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object mapCd = null;
    /**
     * The Droptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object dropType = null;
    /**
     * The Locationcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationCustomFields")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    @NotNull
    private LocationCustomFields locationCustomFields;
    /**
     * The Censuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CensusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object censusCd = null;
    /**
     * The Bridgeraddress Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BridgerAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object bridgerAddress = null;
    /**
     * The Polenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PoleNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object poleNum = null;
    /**
     * The Tapstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TapStatusCd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object tapStatusCd = null;
    /**
     * The Node Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Node")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object node = null;

    /**
     * The Servicearea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ServiceArea")
    public Object getServiceArea() {
        return serviceArea;
    }

    /**
     * The Servicearea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ServiceArea")
    public void setServiceArea(Object serviceArea) {
        this.serviceArea = serviceArea;
    }

    public JobLocation withServiceArea(Object serviceArea) {
        this.serviceArea = serviceArea;
        return this;
    }

    /**
     * The Address Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Address")
    public Address getAddress() {
        return address;
    }

    /**
     * The Address Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Address")
    public void setAddress(Address address) {
        this.address = address;
    }

    public JobLocation withAddress(Address address) {
        this.address = address;
        return this;
    }

    /**
     * The Locationdroptags Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationDropTags")
    public LocationDropTags getLocationDropTags() {
        return locationDropTags;
    }

    /**
     * The Locationdroptags Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationDropTags")
    public void setLocationDropTags(LocationDropTags locationDropTags) {
        this.locationDropTags = locationDropTags;
    }

    public JobLocation withLocationDropTags(LocationDropTags locationDropTags) {
        this.locationDropTags = locationDropTags;
        return this;
    }

    /**
     * The Housemisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseMisc")
    public Object getHouseMisc() {
        return houseMisc;
    }

    /**
     * The Housemisc Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseMisc")
    public void setHouseMisc(Object houseMisc) {
        this.houseMisc = houseMisc;
    }

    public JobLocation withHouseMisc(Object houseMisc) {
        this.houseMisc = houseMisc;
        return this;
    }

    /**
     * The Droplocationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropLocationCd")
    public Object getDropLocationCd() {
        return dropLocationCd;
    }

    /**
     * The Droplocationcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropLocationCd")
    public void setDropLocationCd(Object dropLocationCd) {
        this.dropLocationCd = dropLocationCd;
    }

    public JobLocation withDropLocationCd(Object dropLocationCd) {
        this.dropLocationCd = dropLocationCd;
        return this;
    }

    /**
     * The Powersupply Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PowerSupply")
    public Object getPowerSupply() {
        return powerSupply;
    }

    /**
     * The Powersupply Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PowerSupply")
    public void setPowerSupply(Object powerSupply) {
        this.powerSupply = powerSupply;
    }

    public JobLocation withPowerSupply(Object powerSupply) {
        this.powerSupply = powerSupply;
        return this;
    }

    /**
     * The Bldgtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BldgTypeCd")
    public Object getBldgTypeCd() {
        return bldgTypeCd;
    }

    /**
     * The Bldgtypecd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BldgTypeCd")
    public void setBldgTypeCd(Object bldgTypeCd) {
        this.bldgTypeCd = bldgTypeCd;
    }

    public JobLocation withBldgTypeCd(Object bldgTypeCd) {
        this.bldgTypeCd = bldgTypeCd;
        return this;
    }

    /**
     * The Housecomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseComment")
    public Object getHouseComment() {
        return houseComment;
    }

    /**
     * The Housecomment Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseComment")
    public void setHouseComment(Object houseComment) {
        this.houseComment = houseComment;
    }

    public JobLocation withHouseComment(Object houseComment) {
        this.houseComment = houseComment;
        return this;
    }

    /**
     * The Routecriteria Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RouteCriteria")
    public String getRouteCriteria() {
        return routeCriteria;
    }

    /**
     * The Routecriteria Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("RouteCriteria")
    public void setRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
    }

    public JobLocation withRouteCriteria(String routeCriteria) {
        this.routeCriteria = routeCriteria;
        return this;
    }

    /**
     * The Hookuptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HookupType")
    public Object getHookupType() {
        return hookupType;
    }

    /**
     * The Hookuptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HookupType")
    public void setHookupType(Object hookupType) {
        this.hookupType = hookupType;
    }

    public JobLocation withHookupType(Object hookupType) {
        this.hookupType = hookupType;
        return this;
    }

    /**
     * The Headendcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HeadendCd")
    public Object getHeadendCd() {
        return headendCd;
    }

    /**
     * The Headendcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HeadendCd")
    public void setHeadendCd(Object headendCd) {
        this.headendCd = headendCd;
    }

    public JobLocation withHeadendCd(Object headendCd) {
        this.headendCd = headendCd;
        return this;
    }

    /**
     * The Managementarea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ManagementArea")
    public Object getManagementArea() {
        return managementArea;
    }

    /**
     * The Managementarea Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("ManagementArea")
    public void setManagementArea(Object managementArea) {
        this.managementArea = managementArea;
    }

    public JobLocation withManagementArea(Object managementArea) {
        this.managementArea = managementArea;
        return this;
    }

    /**
     * The Amplifier Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Amplifier")
    public Object getAmplifier() {
        return amplifier;
    }

    /**
     * The Amplifier Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Amplifier")
    public void setAmplifier(Object amplifier) {
        this.amplifier = amplifier;
    }

    public JobLocation withAmplifier(Object amplifier) {
        this.amplifier = amplifier;
        return this;
    }

    /**
     * The Housestatus Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseStatus")
    public Object getHouseStatus() {
        return houseStatus;
    }

    /**
     * The Housestatus Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("HouseStatus")
    public void setHouseStatus(Object houseStatus) {
        this.houseStatus = houseStatus;
    }

    public JobLocation withHouseStatus(Object houseStatus) {
        this.houseStatus = houseStatus;
        return this;
    }

    /**
     * The Mapcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("MapCd")
    public Object getMapCd() {
        return mapCd;
    }

    /**
     * The Mapcd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("MapCd")
    public void setMapCd(Object mapCd) {
        this.mapCd = mapCd;
    }

    public JobLocation withMapCd(Object mapCd) {
        this.mapCd = mapCd;
        return this;
    }

    /**
     * The Droptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropType")
    public Object getDropType() {
        return dropType;
    }

    /**
     * The Droptype Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropType")
    public void setDropType(Object dropType) {
        this.dropType = dropType;
    }

    public JobLocation withDropType(Object dropType) {
        this.dropType = dropType;
        return this;
    }

    /**
     * The Locationcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationCustomFields")
    public LocationCustomFields getLocationCustomFields() {
        return locationCustomFields;
    }

    /**
     * The Locationcustomfields Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("LocationCustomFields")
    public void setLocationCustomFields(LocationCustomFields locationCustomFields) {
        this.locationCustomFields = locationCustomFields;
    }

    public JobLocation withLocationCustomFields(LocationCustomFields locationCustomFields) {
        this.locationCustomFields = locationCustomFields;
        return this;
    }

    /**
     * The Censuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CensusCd")
    public Object getCensusCd() {
        return censusCd;
    }

    /**
     * The Censuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("CensusCd")
    public void setCensusCd(Object censusCd) {
        this.censusCd = censusCd;
    }

    public JobLocation withCensusCd(Object censusCd) {
        this.censusCd = censusCd;
        return this;
    }

    /**
     * The Bridgeraddress Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BridgerAddress")
    public Object getBridgerAddress() {
        return bridgerAddress;
    }

    /**
     * The Bridgeraddress Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("BridgerAddress")
    public void setBridgerAddress(Object bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
    }

    public JobLocation withBridgerAddress(Object bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
        return this;
    }

    /**
     * The Polenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PoleNum")
    public Object getPoleNum() {
        return poleNum;
    }

    /**
     * The Polenum Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("PoleNum")
    public void setPoleNum(Object poleNum) {
        this.poleNum = poleNum;
    }

    public JobLocation withPoleNum(Object poleNum) {
        this.poleNum = poleNum;
        return this;
    }

    /**
     * The Tapstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TapStatusCd")
    public Object getTapStatusCd() {
        return tapStatusCd;
    }

    /**
     * The Tapstatuscd Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("TapStatusCd")
    public void setTapStatusCd(Object tapStatusCd) {
        this.tapStatusCd = tapStatusCd;
    }

    public JobLocation withTapStatusCd(Object tapStatusCd) {
        this.tapStatusCd = tapStatusCd;
        return this;
    }

    /**
     * The Node Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Node")
    public Object getNode() {
        return node;
    }

    /**
     * The Node Schema
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("Node")
    public void setNode(Object node) {
        this.node = node;
    }

    public JobLocation withNode(Object node) {
        this.node = node;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(serviceArea).append(address).append(locationDropTags).append(houseMisc).append(dropLocationCd).append(powerSupply).append(bldgTypeCd).append(houseComment).append(routeCriteria).append(hookupType).append(headendCd).append(managementArea).append(amplifier).append(houseStatus).append(mapCd).append(dropType).append(locationCustomFields).append(censusCd).append(bridgerAddress).append(poleNum).append(tapStatusCd).append(node).toHashCode();
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
        return new EqualsBuilder().append(serviceArea, rhs.serviceArea).append(address, rhs.address).append(locationDropTags, rhs.locationDropTags).append(houseMisc, rhs.houseMisc).append(dropLocationCd, rhs.dropLocationCd).append(powerSupply, rhs.powerSupply).append(bldgTypeCd, rhs.bldgTypeCd).append(houseComment, rhs.houseComment).append(routeCriteria, rhs.routeCriteria).append(hookupType, rhs.hookupType).append(headendCd, rhs.headendCd).append(managementArea, rhs.managementArea).append(amplifier, rhs.amplifier).append(houseStatus, rhs.houseStatus).append(mapCd, rhs.mapCd).append(dropType, rhs.dropType).append(locationCustomFields, rhs.locationCustomFields).append(censusCd, rhs.censusCd).append(bridgerAddress, rhs.bridgerAddress).append(poleNum, rhs.poleNum).append(tapStatusCd, rhs.tapStatusCd).append(node, rhs.node).isEquals();
    }

}
