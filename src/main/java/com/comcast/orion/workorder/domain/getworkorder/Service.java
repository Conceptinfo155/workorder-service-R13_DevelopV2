
package com.comcast.orion.workorder.domain.getworkorder;

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

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "action", "serviceId", "armObjectName", "equipmentDesignId", "serviceType", "displayServiceType",
		"name", "staticIp", "characteristics", "dependentServices" })
public class Service {

	@JsonProperty("action")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String action;
	@JsonProperty("serviceId")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String serviceId;
	@JsonProperty("armObjectName")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String armObjectName;
	@JsonProperty("equipmentDesignId")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String equipmentDesignId;
	@JsonProperty("serviceType")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String serviceType;
	@JsonProperty("displayServiceType")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String displayServiceType;
	@JsonProperty("name")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String name;
	@JsonProperty("staticIp")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
	@Valid
	private List<StaticIP> staticIP = new ArrayList<StaticIP>();
	@JsonProperty("characteristics")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
	@Valid
	private List<Characteristic> characteristics = new ArrayList<Characteristic>();
	@JsonProperty("dependentServices")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
	@Valid
	private List<DependentService> dependentServices = new ArrayList<DependentService>();

	@JsonProperty("action")
	public String getAction() {
		return action;
	}

	@JsonProperty("action")
	public void setAction(String action) {
		this.action = action;
	}

	public Service withAction(String action) {
		this.action = action;
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

	@JsonProperty("armObjectName")
	public String getArmObjectName() {
		return armObjectName;
	}

	@JsonProperty("armObjectName")
	public void setArmObjectName(String armObjectName) {
		this.armObjectName = armObjectName;
	}

	public Service withArmObjectName(String armObjectName) {
		this.armObjectName = armObjectName;
		return this;
	}

	@JsonProperty("equipmentDesignId")
	public String getEquipmentDesignId() {
		return equipmentDesignId;
	}

	@JsonProperty("equipmentDesignId")
	public void setEquipmentDesignId(String equipmentDesignId) {
		this.equipmentDesignId = equipmentDesignId;
	}

	public Service withEquipmentDesignId(String equipmentDesignId) {
		this.equipmentDesignId = equipmentDesignId;
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

	@JsonProperty("displayServiceType")
	public String getDisplayServiceType() {
		return displayServiceType;
	}

	@JsonProperty("displayServiceType")
	public void setDisplayServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
	}

	public Service withDisplayServiceType(String displayServiceType) {
		this.displayServiceType = displayServiceType;
		return this;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public Service withName(String name) {
		this.name = name;
		return this;
	}

	@JsonProperty("staticIp")
	public List<StaticIP> getStaticIP() {
		return staticIP;
	}

	@JsonProperty("staticIp")
	public void setStaticIP(List<StaticIP> staticIP) {
		this.staticIP = staticIP;
	}

	public Service withStaticIP(List<StaticIP> staticIP) {
		this.staticIP = staticIP;
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

	@JsonProperty("dependentServices")
	public List<DependentService> getDependentServices() {
		return dependentServices;
	}

	@JsonProperty("dependentServices")
	public void setDependentServices(List<DependentService> dependentServices) {
		this.dependentServices = dependentServices;
	}

	public Service withDependentServices(List<DependentService> dependentServices) {
		this.dependentServices = dependentServices;
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(action).append(serviceId).append(armObjectName).append(equipmentDesignId)
				.append(serviceType).append(displayServiceType).append(name).append(staticIP).append(characteristics).append(dependentServices)
				.toHashCode();
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
		return new EqualsBuilder().append(action, rhs.action).append(serviceId, rhs.serviceId)
				.append(armObjectName, rhs.armObjectName).append(equipmentDesignId, rhs.equipmentDesignId)
				.append(serviceType, rhs.serviceType).append(displayServiceType, rhs.displayServiceType).append(name, rhs.name).append(staticIP, rhs.staticIP)
				.append(characteristics, rhs.characteristics).append(dependentServices, rhs.dependentServices)
				.isEquals();
	}

}
