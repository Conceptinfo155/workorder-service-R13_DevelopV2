
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
    "uploadSpeed",
    "downloadSpeed",
    "serviceName",
    "serviceId",
    "solutionId",
    "serviceInstanceId",
    "transportType",
    "tierName",
    "serviceType",
    "serviceTopologyName",
    "underlayIndicator",
    "serviceStatus",
    "customerUNQID",
    "associtedServiceUNQID",
    "characteristics",
    "device",
    "ipBlock"
})
public class Service {

    @JsonProperty("uploadSpeed")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String uploadSpeed;
    @JsonProperty("downloadSpeed")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String downloadSpeed;
    @JsonProperty("serviceName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceName;
    @JsonProperty("serviceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceId;
    @JsonProperty("solutionId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String solutionId;
    @JsonProperty("serviceInstanceId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceInstanceId;
    @JsonProperty("transportType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String transportType;
    @JsonProperty("tierName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tierName;
    @JsonProperty("serviceType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceType;
    @JsonProperty("serviceTopologyName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceTopologyName;
    @JsonProperty("underlayIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String underlayIndicator;
    @JsonProperty("serviceStatus")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceStatus;
    @JsonProperty("customerUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String customerUNQID;
    @JsonProperty("associtedServiceUNQID")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<String> associtedServiceUNQID = new ArrayList<String>();
    @JsonProperty("characteristics")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Characteristic> characteristics = new ArrayList<Characteristic>();
    @JsonProperty("device")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Device> device = new ArrayList<Device>();
    @JsonProperty("ipBlock")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<IpBlock> ipBlock = new ArrayList<IpBlock>();

    @JsonProperty("uploadSpeed")
    public String getUploadSpeed() {
        return uploadSpeed;
    }

    @JsonProperty("uploadSpeed")
    public void setUploadSpeed(String uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public Service withUploadSpeed(String uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
        return this;
    }

    @JsonProperty("downloadSpeed")
    public String getDownloadSpeed() {
        return downloadSpeed;
    }

    @JsonProperty("downloadSpeed")
    public void setDownloadSpeed(String downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public Service withDownloadSpeed(String downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
        return this;
    }

    @JsonProperty("serviceName")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("serviceName")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Service withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    @JsonProperty("serviceId")
    public String getServiceId() {
        return serviceId;
    }

    @JsonProperty("serviceId")
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Service withServiceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    @JsonProperty("solutionId")
    public String getSolutionId() {
        return solutionId;
    }

    @JsonProperty("solutionId")
    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public Service withSolutionId(String solutionId) {
        this.solutionId = solutionId;
        return this;
    }

    @JsonProperty("serviceInstanceId")
    public String getServiceInstanceId() {
        return serviceInstanceId;
    }

    @JsonProperty("serviceInstanceId")
    public void setServiceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
    }

    public Service withServiceInstanceId(String serviceInstanceId) {
        this.serviceInstanceId = serviceInstanceId;
        return this;
    }

    @JsonProperty("transportType")
    public String getTransportType() {
        return transportType;
    }

    @JsonProperty("transportType")
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Service withTransportType(String transportType) {
        this.transportType = transportType;
        return this;
    }

    @JsonProperty("tierName")
    public String getTierName() {
        return tierName;
    }

    @JsonProperty("tierName")
    public void setTierName(String tierName) {
        this.tierName = tierName;
    }

    public Service withTierName(String tierName) {
        this.tierName = tierName;
        return this;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Service withServiceType(String serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    @JsonProperty("serviceTopologyName")
    public String getServiceTopologyName() {
        return serviceTopologyName;
    }

    @JsonProperty("serviceTopologyName")
    public void setServiceTopologyName(String serviceTopologyName) {
        this.serviceTopologyName = serviceTopologyName;
    }

    public Service withServiceTopologyName(String serviceTopologyName) {
        this.serviceTopologyName = serviceTopologyName;
        return this;
    }

    @JsonProperty("underlayIndicator")
    public String getUnderlayIndicator() {
        return underlayIndicator;
    }

    @JsonProperty("underlayIndicator")
    public void setUnderlayIndicator(String underlayIndicator) {
        this.underlayIndicator = underlayIndicator;
    }

    public Service withUnderlayIndicator(String underlayIndicator) {
        this.underlayIndicator = underlayIndicator;
        return this;
    }

    @JsonProperty("serviceStatus")
    public String getServiceStatus() {
        return serviceStatus;
    }

    @JsonProperty("serviceStatus")
    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Service withServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
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

    public Service withCustomerUNQID(String customerUNQID) {
        this.customerUNQID = customerUNQID;
        return this;
    }

    @JsonProperty("associtedServiceUNQID")
    public List<String> getAssocitedServiceUNQID() {
        return associtedServiceUNQID;
    }

    @JsonProperty("associtedServiceUNQID")
    public void setAssocitedServiceUNQID(List<String> associtedServiceUNQID) {
        this.associtedServiceUNQID = associtedServiceUNQID;
    }

    public Service withAssocitedServiceUNQID(List<String> associtedServiceUNQID) {
        this.associtedServiceUNQID = associtedServiceUNQID;
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

    public Service withCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
        return this;
    }

    @JsonProperty("device")
    public List<Device> getDevice() {
        return device;
    }

    @JsonProperty("device")
    public void setDevice(List<Device> device) {
        this.device = device;
    }

    public Service withDevice(List<Device> device) {
        this.device = device;
        return this;
    }

    @JsonProperty("ipBlock")
    public List<IpBlock> getIpBlock() {
        return ipBlock;
    }

    @JsonProperty("ipBlock")
    public void setIpBlock(List<IpBlock> ipBlock) {
        this.ipBlock = ipBlock;
    }

    public Service withIpBlock(List<IpBlock> ipBlock) {
        this.ipBlock = ipBlock;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(uploadSpeed).append(downloadSpeed).append(serviceName).append(serviceId).append(solutionId).append(serviceInstanceId).append(transportType).append(tierName).append(serviceType).append(serviceTopologyName).append(underlayIndicator).append(serviceStatus).append(customerUNQID).append(associtedServiceUNQID).append(characteristics).append(device).append(ipBlock).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Service) == false) {
            return false;
        }
        Service rhs = ((Service) other);
        return new EqualsBuilder().append(uploadSpeed, rhs.uploadSpeed).append(downloadSpeed, rhs.downloadSpeed).append(serviceName, rhs.serviceName).append(serviceId, rhs.serviceId).append(solutionId, rhs.solutionId).append(serviceInstanceId, rhs.serviceInstanceId).append(transportType, rhs.transportType).append(tierName, rhs.tierName).append(serviceType, rhs.serviceType).append(serviceTopologyName, rhs.serviceTopologyName).append(underlayIndicator, rhs.underlayIndicator).append(serviceStatus, rhs.serviceStatus).append(customerUNQID, rhs.customerUNQID).append(associtedServiceUNQID, rhs.associtedServiceUNQID).append(characteristics, rhs.characteristics).append(device, rhs.device).append(ipBlock, rhs.ipBlock).isEquals();
    }

}
