
package com.comcast.orion.workorder.domain.locationResponse;

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
    "capabilityInfo",
    "e911AddressInfo",
    "geographyInfo",
    "marketHierarchy",
    "marketInfo",
    "networkConnectivityInfo",
    "postalAddress",
    "speedTierInfo",
    "billingDetailsInfo",
    "telephonyInfo"
})
public class ResponseItems {

    @JsonProperty("capabilityInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CapabilityInfo capabilityInfo;
    @JsonProperty("e911AddressInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private E911AddressInfo e911AddressInfo;
    @JsonProperty("geographyInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private GeographyInfo geographyInfo;
    @JsonProperty("marketHierarchy")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<MarketHierarchy> marketHierarchy = new ArrayList<MarketHierarchy>();
    @JsonProperty("marketInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private MarketInfo marketInfo;
    @JsonProperty("networkConnectivityInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private NetworkConnectivityInfo networkConnectivityInfo;
    @JsonProperty("postalAddress")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private PostalAddress postalAddress;
    @JsonProperty("speedTierInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private SpeedTierInfo speedTierInfo;
    @JsonProperty("billingDetailsInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BillingDetailsInfo billingDetailsInfo;
    @JsonProperty("telephonyInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private TelephonyInfo telephonyInfo;

    @JsonProperty("capabilityInfo")
    public CapabilityInfo getCapabilityInfo() {
        return capabilityInfo;
    }

    @JsonProperty("capabilityInfo")
    public void setCapabilityInfo(CapabilityInfo capabilityInfo) {
        this.capabilityInfo = capabilityInfo;
    }

    public ResponseItems withCapabilityInfo(CapabilityInfo capabilityInfo) {
        this.capabilityInfo = capabilityInfo;
        return this;
    }

    @JsonProperty("e911AddressInfo")
    public E911AddressInfo getE911AddressInfo() {
        return e911AddressInfo;
    }

    @JsonProperty("e911AddressInfo")
    public void setE911AddressInfo(E911AddressInfo e911AddressInfo) {
        this.e911AddressInfo = e911AddressInfo;
    }

    public ResponseItems withE911AddressInfo(E911AddressInfo e911AddressInfo) {
        this.e911AddressInfo = e911AddressInfo;
        return this;
    }

    @JsonProperty("geographyInfo")
    public GeographyInfo getGeographyInfo() {
        return geographyInfo;
    }

    @JsonProperty("geographyInfo")
    public void setGeographyInfo(GeographyInfo geographyInfo) {
        this.geographyInfo = geographyInfo;
    }

    public ResponseItems withGeographyInfo(GeographyInfo geographyInfo) {
        this.geographyInfo = geographyInfo;
        return this;
    }

    @JsonProperty("marketHierarchy")
    public List<MarketHierarchy> getMarketHierarchy() {
        return marketHierarchy;
    }

    @JsonProperty("marketHierarchy")
    public void setMarketHierarchy(List<MarketHierarchy> marketHierarchy) {
        this.marketHierarchy = marketHierarchy;
    }

    public ResponseItems withMarketHierarchy(List<MarketHierarchy> marketHierarchy) {
        this.marketHierarchy = marketHierarchy;
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

    public ResponseItems withMarketInfo(MarketInfo marketInfo) {
        this.marketInfo = marketInfo;
        return this;
    }

    @JsonProperty("networkConnectivityInfo")
    public NetworkConnectivityInfo getNetworkConnectivityInfo() {
        return networkConnectivityInfo;
    }

    @JsonProperty("networkConnectivityInfo")
    public void setNetworkConnectivityInfo(NetworkConnectivityInfo networkConnectivityInfo) {
        this.networkConnectivityInfo = networkConnectivityInfo;
    }

    public ResponseItems withNetworkConnectivityInfo(NetworkConnectivityInfo networkConnectivityInfo) {
        this.networkConnectivityInfo = networkConnectivityInfo;
        return this;
    }

    @JsonProperty("postalAddress")
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    @JsonProperty("postalAddress")
    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public ResponseItems withPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
        return this;
    }

    @JsonProperty("speedTierInfo")
    public SpeedTierInfo getSpeedTierInfo() {
        return speedTierInfo;
    }

    @JsonProperty("speedTierInfo")
    public void setSpeedTierInfo(SpeedTierInfo speedTierInfo) {
        this.speedTierInfo = speedTierInfo;
    }

    public ResponseItems withSpeedTierInfo(SpeedTierInfo speedTierInfo) {
        this.speedTierInfo = speedTierInfo;
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

    public ResponseItems withBillingDetailsInfo(BillingDetailsInfo billingDetailsInfo) {
        this.billingDetailsInfo = billingDetailsInfo;
        return this;
    }

    @JsonProperty("telephonyInfo")
    public TelephonyInfo getTelephonyInfo() {
        return telephonyInfo;
    }

    @JsonProperty("telephonyInfo")
    public void setTelephonyInfo(TelephonyInfo telephonyInfo) {
        this.telephonyInfo = telephonyInfo;
    }

    public ResponseItems withTelephonyInfo(TelephonyInfo telephonyInfo) {
        this.telephonyInfo = telephonyInfo;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(capabilityInfo).append(e911AddressInfo).append(geographyInfo).append(marketHierarchy).append(marketInfo).append(networkConnectivityInfo).append(postalAddress).append(speedTierInfo).append(billingDetailsInfo).append(telephonyInfo).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResponseItems) == false) {
            return false;
        }
        ResponseItems rhs = ((ResponseItems) other);
        return new EqualsBuilder().append(capabilityInfo, rhs.capabilityInfo).append(e911AddressInfo, rhs.e911AddressInfo).append(geographyInfo, rhs.geographyInfo).append(marketHierarchy, rhs.marketHierarchy).append(marketInfo, rhs.marketInfo).append(networkConnectivityInfo, rhs.networkConnectivityInfo).append(postalAddress, rhs.postalAddress).append(speedTierInfo, rhs.speedTierInfo).append(billingDetailsInfo, rhs.billingDetailsInfo).append(telephonyInfo, rhs.telephonyInfo).isEquals();
    }

}
