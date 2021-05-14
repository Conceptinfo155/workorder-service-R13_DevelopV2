
package com.comcast.orion.workorder.domain;

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
    "siteId",
    "siteName",
    "siteType",
    "customerGroupId",
    "numberOfEmployees",
    "sitePhoneNumber",
    "siteAddress",
    "siteContacts",
    "market",
    "submarket",
    "region",
    "division",
    "areaType",
    "timeZoneInfo",
    "marketInfo",
    "billingDetailsInfo",
    "locationIdentifierInfo",
    "errors"
})
public class SiteResponse {

    /**
     * The Amdocs Site ID
     * 
     */
    @JsonProperty("siteId")
    @JsonPropertyDescription("The Amdocs Site ID")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "The Amdocs Site ID", example = "Site_1246_1")
    private String siteId;
    /**
     * The name of the site.
     * 
     */
    @JsonProperty("siteName")
    @JsonPropertyDescription("The name of the site.")
    @ApiModelProperty(required = false, dataType = "string", position = 2, value = "The name of the site.", example = "sit1")
    private String siteName;
    /**
     * The site type - (ST,MT,MC,CT,CS,CH,DC,CST,CMT,TW,MSC,ML,OT) (Single Tenant, Multi-Tenant, Mobile Switching Center, Cell Tower, Cell Site, Carrier Hotel, Data Center, Commercial Single Tenant, Commercial Multi-tenant, Teleworker, MSC/HUB, Multi-Level, Other )
     * 
     */
    @JsonProperty("siteType")
    @JsonPropertyDescription("The site type - (ST,MT,MC,CT,CS,CH,DC,CST,CMT,TW,MSC,ML,OT) (Single Tenant, Multi-Tenant, Mobile Switching Center, Cell Tower, Cell Site, Carrier Hotel, Data Center, Commercial Single Tenant, Commercial Multi-tenant, Teleworker, MSC/HUB, Multi-Level, Other )")
    @ApiModelProperty(required = false, dataType = "string", position = 3, value = "The site type - (ST,MT,MC,CT,CS,CH,DC,CST,CMT,TW,MSC,ML,OT) (Single Tenant, Multi-Tenant, Mobile Switching Center, Cell Tower, Cell Site, Carrier Hotel, Data Center, Commercial Single Tenant, Commercial Multi-tenant, Teleworker, MSC/HUB, Multi-Level, Other )", example = "ST")
    private String siteType;
    /**
     * Customer group Id
     * 
     */
    @JsonProperty("customerGroupId")
    @JsonPropertyDescription("Customer group Id")
    @ApiModelProperty(required = false, dataType = "string", position = 4, value = "Customer group Id", example = "???")
    private String customerGroupId;
    /**
     * The number of employees at this site
     * 
     */
    @JsonProperty("numberOfEmployees")
    @JsonPropertyDescription("The number of employees at this site")
    @ApiModelProperty(required = false, dataType = "integer", position = 5, value = "The number of employees at this site", example = "11")
    private Integer numberOfEmployees;
    /**
     * The phone Number of the site
     * 
     */
    @JsonProperty("sitePhoneNumber")
    @JsonPropertyDescription("The phone Number of the site")
    @ApiModelProperty(required = false, dataType = "string", position = 6, value = "The phone Number of the site", example = "???")
    private String sitePhoneNumber;
    @JsonProperty("siteAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 7, value = "", example = "")
    @Valid
    private SiteAddress siteAddress;
    @JsonProperty("siteContacts")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 8, value = "", example = "")
    @Valid
    private List<SiteContact> siteContacts = new ArrayList<SiteContact>();
    /**
     * The market of the site
     * 
     */
    @JsonProperty("market")
    @JsonPropertyDescription("The market of the site")
    @ApiModelProperty(required = false, dataType = "string", position = 9, value = "The market of the site", example = "???")
    private String market;
    /**
     * The site sub-market
     * 
     */
    @JsonProperty("submarket")
    @JsonPropertyDescription("The site sub-market")
    @ApiModelProperty(required = false, dataType = "string", position = 10, value = "The site sub-market", example = "???")
    private String submarket;
    /**
     * The region of the site
     * 
     */
    @JsonProperty("region")
    @JsonPropertyDescription("The region of the site")
    @ApiModelProperty(required = false, dataType = "string", position = 11, value = "The region of the site", example = "???")
    private String region;
    /**
     * The division of the site
     * 
     */
    @JsonProperty("division")
    @JsonPropertyDescription("The division of the site")
    @ApiModelProperty(required = false, dataType = "string", position = 12, value = "The division of the site", example = "???")
    private String division;
    /**
     * The area type
     * 
     */
    @JsonProperty("areaType")
    @JsonPropertyDescription("The area type")
    @ApiModelProperty(required = false, dataType = "string", position = 13, value = "The area type", example = "Please Specify")
    private String areaType;
    @JsonProperty("timeZoneInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private TimeZoneInfo timeZoneInfo;
    @JsonProperty("marketInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private MarketInfo marketInfo;
    @JsonProperty("billingDetailsInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BillingDetailsInfo billingDetailsInfo;
    @JsonProperty("locationIdentifierInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private LocationIdentifierInfo locationIdentifierInfo;
    @JsonProperty("errors")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Error> errors = new ArrayList<Error>();

    /**
     * The Amdocs Site ID
     * 
     */
    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    /**
     * The Amdocs Site ID
     * 
     */
    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public SiteResponse withSiteId(String siteId) {
        this.siteId = siteId;
        return this;
    }

    /**
     * The name of the site.
     * 
     */
    @JsonProperty("siteName")
    public String getSiteName() {
        return siteName;
    }

    /**
     * The name of the site.
     * 
     */
    @JsonProperty("siteName")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public SiteResponse withSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    /**
     * The site type - (ST,MT,MC,CT,CS,CH,DC,CST,CMT,TW,MSC,ML,OT) (Single Tenant, Multi-Tenant, Mobile Switching Center, Cell Tower, Cell Site, Carrier Hotel, Data Center, Commercial Single Tenant, Commercial Multi-tenant, Teleworker, MSC/HUB, Multi-Level, Other )
     * 
     */
    @JsonProperty("siteType")
    public String getSiteType() {
        return siteType;
    }

    /**
     * The site type - (ST,MT,MC,CT,CS,CH,DC,CST,CMT,TW,MSC,ML,OT) (Single Tenant, Multi-Tenant, Mobile Switching Center, Cell Tower, Cell Site, Carrier Hotel, Data Center, Commercial Single Tenant, Commercial Multi-tenant, Teleworker, MSC/HUB, Multi-Level, Other )
     * 
     */
    @JsonProperty("siteType")
    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public SiteResponse withSiteType(String siteType) {
        this.siteType = siteType;
        return this;
    }

    /**
     * Customer group Id
     * 
     */
    @JsonProperty("customerGroupId")
    public String getCustomerGroupId() {
        return customerGroupId;
    }

    /**
     * Customer group Id
     * 
     */
    @JsonProperty("customerGroupId")
    public void setCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public SiteResponse withCustomerGroupId(String customerGroupId) {
        this.customerGroupId = customerGroupId;
        return this;
    }

    /**
     * The number of employees at this site
     * 
     */
    @JsonProperty("numberOfEmployees")
    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * The number of employees at this site
     * 
     */
    @JsonProperty("numberOfEmployees")
    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public SiteResponse withNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
        return this;
    }

    /**
     * The phone Number of the site
     * 
     */
    @JsonProperty("sitePhoneNumber")
    public String getSitePhoneNumber() {
        return sitePhoneNumber;
    }

    /**
     * The phone Number of the site
     * 
     */
    @JsonProperty("sitePhoneNumber")
    public void setSitePhoneNumber(String sitePhoneNumber) {
        this.sitePhoneNumber = sitePhoneNumber;
    }

    public SiteResponse withSitePhoneNumber(String sitePhoneNumber) {
        this.sitePhoneNumber = sitePhoneNumber;
        return this;
    }

    @JsonProperty("siteAddress")
    public SiteAddress getSiteAddress() {
        return siteAddress;
    }

    @JsonProperty("siteAddress")
    public void setSiteAddress(SiteAddress siteAddress) {
        this.siteAddress = siteAddress;
    }

    public SiteResponse withSiteAddress(SiteAddress siteAddress) {
        this.siteAddress = siteAddress;
        return this;
    }

    @JsonProperty("siteContacts")
    public List<SiteContact> getSiteContacts() {
        return siteContacts;
    }

    @JsonProperty("siteContacts")
    public void setSiteContacts(List<SiteContact> siteContacts) {
        this.siteContacts = siteContacts;
    }

    public SiteResponse withSiteContacts(List<SiteContact> siteContacts) {
        this.siteContacts = siteContacts;
        return this;
    }

    /**
     * The market of the site
     * 
     */
    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    /**
     * The market of the site
     * 
     */
    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    public SiteResponse withMarket(String market) {
        this.market = market;
        return this;
    }

    /**
     * The site sub-market
     * 
     */
    @JsonProperty("submarket")
    public String getSubmarket() {
        return submarket;
    }

    /**
     * The site sub-market
     * 
     */
    @JsonProperty("submarket")
    public void setSubmarket(String submarket) {
        this.submarket = submarket;
    }

    public SiteResponse withSubmarket(String submarket) {
        this.submarket = submarket;
        return this;
    }

    /**
     * The region of the site
     * 
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * The region of the site
     * 
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public SiteResponse withRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * The division of the site
     * 
     */
    @JsonProperty("division")
    public String getDivision() {
        return division;
    }

    /**
     * The division of the site
     * 
     */
    @JsonProperty("division")
    public void setDivision(String division) {
        this.division = division;
    }

    public SiteResponse withDivision(String division) {
        this.division = division;
        return this;
    }

    /**
     * The area type
     * 
     */
    @JsonProperty("areaType")
    public String getAreaType() {
        return areaType;
    }

    /**
     * The area type
     * 
     */
    @JsonProperty("areaType")
    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public SiteResponse withAreaType(String areaType) {
        this.areaType = areaType;
        return this;
    }

    @JsonProperty("timeZoneInfo")
    public TimeZoneInfo getTimeZoneInfo() {
        return timeZoneInfo;
    }

    @JsonProperty("timeZoneInfo")
    public void setTimeZoneInfo(TimeZoneInfo timeZoneInfo) {
        this.timeZoneInfo = timeZoneInfo;
    }

    public SiteResponse withTimeZoneInfo(TimeZoneInfo timeZoneInfo) {
        this.timeZoneInfo = timeZoneInfo;
        return this;
    }

    @JsonProperty("marketInfo")
    public MarketInfo getMarketInfo() {
        return marketInfo;
    }

    @JsonProperty("marketInfo")
    public void setMarketInfo(MarketInfo marketInfo) {
        this.marketInfo = marketInfo;
    }

    public SiteResponse withMarketInfo(MarketInfo marketInfo) {
        this.marketInfo = marketInfo;
        return this;
    }

    @JsonProperty("billingDetailsInfo")
    public BillingDetailsInfo getBillingDetailsInfo() {
        return billingDetailsInfo;
    }

    @JsonProperty("billingDetailsInfo")
    public void setBillingDetailsInfo(BillingDetailsInfo billingDetailsInfo) {
        this.billingDetailsInfo = billingDetailsInfo;
    }

    public SiteResponse withBillingDetailsInfo(BillingDetailsInfo billingDetailsInfo) {
        this.billingDetailsInfo = billingDetailsInfo;
        return this;
    }

    @JsonProperty("locationIdentifierInfo")
    public LocationIdentifierInfo getLocationIdentifierInfo() {
        return locationIdentifierInfo;
    }

    @JsonProperty("locationIdentifierInfo")
    public void setLocationIdentifierInfo(LocationIdentifierInfo locationIdentifierInfo) {
        this.locationIdentifierInfo = locationIdentifierInfo;
    }

    public SiteResponse withLocationIdentifierInfo(LocationIdentifierInfo locationIdentifierInfo) {
        this.locationIdentifierInfo = locationIdentifierInfo;
        return this;
    }

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public SiteResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(siteId).append(siteName).append(siteType).append(customerGroupId).append(numberOfEmployees).append(sitePhoneNumber).append(siteAddress).append(siteContacts).append(market).append(submarket).append(region).append(division).append(areaType).append(timeZoneInfo).append(marketInfo).append(billingDetailsInfo).append(locationIdentifierInfo).append(errors).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SiteResponse) == false) {
            return false;
        }
        SiteResponse rhs = ((SiteResponse) other);
        return new EqualsBuilder().append(siteId, rhs.siteId).append(siteName, rhs.siteName).append(siteType, rhs.siteType).append(customerGroupId, rhs.customerGroupId).append(numberOfEmployees, rhs.numberOfEmployees).append(sitePhoneNumber, rhs.sitePhoneNumber).append(siteAddress, rhs.siteAddress).append(siteContacts, rhs.siteContacts).append(market, rhs.market).append(submarket, rhs.submarket).append(region, rhs.region).append(division, rhs.division).append(areaType, rhs.areaType).append(timeZoneInfo, rhs.timeZoneInfo).append(marketInfo, rhs.marketInfo).append(billingDetailsInfo, rhs.billingDetailsInfo).append(locationIdentifierInfo, rhs.locationIdentifierInfo).append(errors, rhs.errors).isEquals();
    }

}
