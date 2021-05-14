
package com.comcast.orion.workorder.domain.createwo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({ "address", "addrId", "RouteCriteria", "Node", "DropType", "DropTag1", "DropTag2", "DropTag3",
		"BridgerAddress", "ManagementArea", "HookupType" })
public class JobLocation {

	@JsonProperty("address")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
	@Valid
	private Address address;
	/**
	 * Amdocs AddrId passed by Amdocs - WFX (Required)
	 * 
	 */
	@NotNull
	@JsonProperty("addrId")
	@JsonPropertyDescription("Amdocs AddrId passed by Amdocs - WFX")
	@ApiModelProperty(required = true, dataType = "string", position = 1, value = "Amdocs AddrId passed by Amdocs - WFX", example = "205192378")
	@Size(min = 1, max = 14)
	private String addrId;

	@JsonProperty("RouteCriteria")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String routeCriteria;
	@JsonProperty("Node")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String node;
	@JsonProperty("DropType")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String dropType;
	@JsonProperty("DropTag1")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String dropTag1;
	@JsonProperty("DropTag2")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String dropTag2;
	@JsonProperty("DropTag3")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String dropTag3;
	@JsonProperty("BridgerAddress")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String bridgerAddress;
	@JsonProperty("ManagementArea")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String managementArea;
	@JsonProperty("HookupType")
	@JsonPropertyDescription("")
	@ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
	private String hookupType;

	@JsonProperty("address")
	public Address getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(Address address) {
		this.address = address;
	}

	public JobLocation withAddress(Address address) {
		this.address = address;
		return this;
	}

	/**
	 * Amdocs AddrId passed by Amdocs - WFX (Required)
	 * 
	 */
	@JsonProperty("addrId")
	public String getAddrId() {
		return addrId;
	}

	/**
	 * Amdocs AddrId passed by Amdocs - WFX (Required)
	 * 
	 */
	@JsonProperty("addrId")
	public void setAddrId(String addrId) {
		this.addrId = addrId;
	}

	public JobLocation withAddrId(String addrId) {
		this.addrId = addrId;
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

	@JsonProperty("DropType")
	public String getDropType() {
		return dropType;
	}

	@JsonProperty("DropType")
	public void setDropType(String dropType) {
		this.dropType = dropType;
	}

	public JobLocation withDropType(String dropType) {
		this.dropType = dropType;
		return this;
	}

	@JsonProperty("DropTag1")
	public String getDropTag1() {
		return dropTag1;
	}

	@JsonProperty("DropTag1")
	public void setDropTag1(String dropTag1) {
		this.dropTag1 = dropTag1;
	}

	public JobLocation withDropTag1(String dropTag1) {
		this.dropTag1 = dropTag1;
		return this;
	}

	@JsonProperty("DropTag2")
	public String getDropTag2() {
		return dropTag2;
	}

	@JsonProperty("DropTag2")
	public void setDropTag2(String dropTag2) {
		this.dropTag2 = dropTag2;
	}

	public JobLocation withDropTag2(String dropTag2) {
		this.dropTag2 = dropTag2;
		return this;
	}

	@JsonProperty("DropTag3")
	public String getDropTag3() {
		return dropTag3;
	}

	@JsonProperty("DropTag3")
	public void setDropTag3(String dropTag3) {
		this.dropTag3 = dropTag3;
	}

	public JobLocation withDropTag3(String dropTag3) {
		this.dropTag3 = dropTag3;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addrId == null) ? 0 : addrId.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((bridgerAddress == null) ? 0 : bridgerAddress.hashCode());
		result = prime * result + ((dropTag1 == null) ? 0 : dropTag1.hashCode());
		result = prime * result + ((dropTag2 == null) ? 0 : dropTag2.hashCode());
		result = prime * result + ((dropTag3 == null) ? 0 : dropTag3.hashCode());
		result = prime * result + ((dropType == null) ? 0 : dropType.hashCode());
		result = prime * result + ((hookupType == null) ? 0 : hookupType.hashCode());
		result = prime * result + ((managementArea == null) ? 0 : managementArea.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + ((routeCriteria == null) ? 0 : routeCriteria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobLocation other = (JobLocation) obj;
		if (addrId == null) {
			if (other.addrId != null)
				return false;
		} else if (!addrId.equals(other.addrId))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bridgerAddress == null) {
			if (other.bridgerAddress != null)
				return false;
		} else if (!bridgerAddress.equals(other.bridgerAddress))
			return false;
		if (dropTag1 == null) {
			if (other.dropTag1 != null)
				return false;
		} else if (!dropTag1.equals(other.dropTag1))
			return false;
		if (dropTag2 == null) {
			if (other.dropTag2 != null)
				return false;
		} else if (!dropTag2.equals(other.dropTag2))
			return false;
		if (dropTag3 == null) {
			if (other.dropTag3 != null)
				return false;
		} else if (!dropTag3.equals(other.dropTag3))
			return false;
		if (dropType == null) {
			if (other.dropType != null)
				return false;
		} else if (!dropType.equals(other.dropType))
			return false;
		if (hookupType == null) {
			if (other.hookupType != null)
				return false;
		} else if (!hookupType.equals(other.hookupType))
			return false;
		if (managementArea == null) {
			if (other.managementArea != null)
				return false;
		} else if (!managementArea.equals(other.managementArea))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (routeCriteria == null) {
			if (other.routeCriteria != null)
				return false;
		} else if (!routeCriteria.equals(other.routeCriteria))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JobLocation [address=" + address + ", addrId=" + addrId + ", routeCriteria=" + routeCriteria + ", node="
				+ node + ", dropType=" + dropType + ", dropTag1=" + dropTag1 + ", dropTag2=" + dropTag2 + ", dropTag3="
				+ dropTag3 + ", bridgerAddress=" + bridgerAddress + ", managementArea=" + managementArea
				+ ", hookupType=" + hookupType + "]";
	}

}
