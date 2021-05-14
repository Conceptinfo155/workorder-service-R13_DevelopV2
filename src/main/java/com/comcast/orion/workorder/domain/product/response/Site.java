
package com.comcast.orion.workorder.domain.product.response;

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
    "siteCLLI",
    "latitude",
    "longitude",
    "siteAddress",
    "address1",
    "address2",
    "city",
    "state",
    "zip",
    "siteName",
    "siteCRMSystem",
    "crmSiteId",
    "customerSiteName",
    "customerUNQID",
    "characteristics",
    "service",
    "port",
    "connectivityDetails"
})
public class Site {

    @JsonProperty("siteCLLI")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteCLLI;
    @JsonProperty("latitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String latitude;
    @JsonProperty("longitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String longitude;
    @JsonProperty("siteAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteAddress;
    @JsonProperty("address1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String address1;
    @JsonProperty("address2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String address2;
    @JsonProperty("city")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String city;
    @JsonProperty("state")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String state;
    @JsonProperty("zip")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zip;
    @JsonProperty("siteName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteName;
    @JsonProperty("siteCRMSystem")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String siteCRMSystem;
    @JsonProperty("crmSiteId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String crmSiteId;
    @JsonProperty("customerSiteName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerSiteName;
    @JsonProperty("customerUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerUNQID;
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic> characteristics = new ArrayList<Characteristic>();
    @JsonProperty("service")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Service> service = new ArrayList<Service>();
    @JsonProperty("port")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Port> port = new ArrayList<Port>();
    @JsonProperty("connectivityDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<ConnectivityDetail> connectivityDetails = new ArrayList<ConnectivityDetail>();

    @JsonProperty("siteCLLI")
    public String getSiteCLLI() {
        return siteCLLI;
    }

    @JsonProperty("siteCLLI")
    public void setSiteCLLI(String siteCLLI) {
        this.siteCLLI = siteCLLI;
    }

    public Site withSiteCLLI(String siteCLLI) {
        this.siteCLLI = siteCLLI;
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

    public Site withLatitude(String latitude) {
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

    public Site withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("siteAddress")
    public String getSiteAddress() {
        return siteAddress;
    }

    @JsonProperty("siteAddress")
    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public Site withSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
        return this;
    }

    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public Site withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    @JsonProperty("address2")
    public String getAddress2() {
        return address2;
    }

    @JsonProperty("address2")
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Site withAddress2(String address2) {
        this.address2 = address2;
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

    public Site withCity(String city) {
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

    public Site withState(String state) {
        this.state = state;
        return this;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    public Site withZip(String zip) {
        this.zip = zip;
        return this;
    }

    @JsonProperty("siteName")
    public String getSiteName() {
        return siteName;
    }

    @JsonProperty("siteName")
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Site withSiteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    @JsonProperty("siteCRMSystem")
    public String getSiteCRMSystem() {
        return siteCRMSystem;
    }

    @JsonProperty("siteCRMSystem")
    public void setSiteCRMSystem(String siteCRMSystem) {
        this.siteCRMSystem = siteCRMSystem;
    }

    public Site withSiteCRMSystem(String siteCRMSystem) {
        this.siteCRMSystem = siteCRMSystem;
        return this;
    }

    @JsonProperty("crmSiteId")
    public String getCrmSiteId() {
        return crmSiteId;
    }

    @JsonProperty("crmSiteId")
    public void setCrmSiteId(String crmSiteId) {
        this.crmSiteId = crmSiteId;
    }

    public Site withCrmSiteId(String crmSiteId) {
        this.crmSiteId = crmSiteId;
        return this;
    }

    @JsonProperty("customerSiteName")
    public String getCustomerSiteName() {
        return customerSiteName;
    }

    @JsonProperty("customerSiteName")
    public void setCustomerSiteName(String customerSiteName) {
        this.customerSiteName = customerSiteName;
    }

    public Site withCustomerSiteName(String customerSiteName) {
        this.customerSiteName = customerSiteName;
        return this;
    }

    @JsonProperty("customerUNQID")
    public String getCustomerUNQID() {
        return customerUNQID;
    }

    @JsonProperty("customerUNQID")
    public void setCustomerUNQID(String customerUNQID) {
        this.customerUNQID = customerUNQID;
    }

    public Site withCustomerUNQID(String customerUNQID) {
        this.customerUNQID = customerUNQID;
        return this;
    }

    @JsonProperty("characteristics")
    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    @JsonProperty("characteristics")
    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public Site withCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @JsonProperty("service")
    public List<Service> getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(List<Service> service) {
        this.service = service;
    }

    public Site withService(List<Service> service) {
        this.service = service;
        return this;
    }

    @JsonProperty("port")
    public List<Port> getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(List<Port> port) {
        this.port = port;
    }

    public Site withPort(List<Port> port) {
        this.port = port;
        return this;
    }

    @JsonProperty("connectivityDetails")
    public List<ConnectivityDetail> getConnectivityDetails() {
        return connectivityDetails;
    }

    @JsonProperty("connectivityDetails")
    public void setConnectivityDetails(List<ConnectivityDetail> connectivityDetails) {
        this.connectivityDetails = connectivityDetails;
    }

    public Site withConnectivityDetails(List<ConnectivityDetail> connectivityDetails) {
        this.connectivityDetails = connectivityDetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(siteCLLI).append(latitude).append(longitude).append(siteAddress).append(address1).append(address2).append(city).append(state).append(zip).append(siteName).append(siteCRMSystem).append(crmSiteId).append(customerSiteName).append(customerUNQID).append(characteristics).append(service).append(port).append(connectivityDetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Site) == false) {
            return false;
        }
        Site rhs = ((Site) other);
        return new EqualsBuilder().append(siteCLLI, rhs.siteCLLI).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(siteAddress, rhs.siteAddress).append(address1, rhs.address1).append(address2, rhs.address2).append(city, rhs.city).append(state, rhs.state).append(zip, rhs.zip).append(siteName, rhs.siteName).append(siteCRMSystem, rhs.siteCRMSystem).append(crmSiteId, rhs.crmSiteId).append(customerSiteName, rhs.customerSiteName).append(customerUNQID, rhs.customerUNQID).append(characteristics, rhs.characteristics).append(service, rhs.service).append(port, rhs.port).append(connectivityDetails, rhs.connectivityDetails).isEquals();
    }

}
