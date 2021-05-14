
package com.comcast.orion.workorder.domain.locationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cSGDetailsType",
    "lineTagList",
    "hookupType",
    "dropType",
    "bridgerAddress"
})
public class CsgDetails {

    @JsonProperty("cSGDetailsType")
    private CSGDetailsType cSGDetailsType;
   
    @JsonProperty("lineTagList")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<LineTagList> lineTagList = new ArrayList<LineTagList>();
    @JsonProperty("hookupType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String hookupType;
    @JsonProperty("dropType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String dropType;
    @JsonProperty("bridgerAddress")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BridgerAddress bridgerAddress;
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cSGDetailsType")
    public CSGDetailsType getCSGDetailsType() {
        return cSGDetailsType;
    }

    @JsonProperty("cSGDetailsType")
    public void setCSGDetailsType(CSGDetailsType cSGDetailsType) {
        this.cSGDetailsType = cSGDetailsType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CsgDetails withCSGDetailsType(CSGDetailsType cSGDetailsType) {
        this.cSGDetailsType = cSGDetailsType;
        return this;
    }

    @JsonProperty("lineTagList")
    public List<LineTagList> getLineTagList() {
        return lineTagList;
    }

    @JsonProperty("lineTagList")
    public void setLineTagList(List<LineTagList> lineTagList) {
        this.lineTagList = lineTagList;
    }

    public CsgDetails withLineTagList(List<LineTagList> lineTagList) {
        this.lineTagList = lineTagList;
        return this;
    }

    @JsonProperty("hookupType")
    public String getHookupType() {
        return hookupType;
    }

    @JsonProperty("hookupType")
    public void setHookupType(String hookupType) {
        this.hookupType = hookupType;
    }

    public CsgDetails withHookupType(String hookupType) {
        this.hookupType = hookupType;
        return this;
    }

    @JsonProperty("dropType")
    public String getDropType() {
        return dropType;
    }

    @JsonProperty("dropType")
    public void setDropType(String dropType) {
        this.dropType = dropType;
    }

    public CsgDetails withDropType(String dropType) {
        this.dropType = dropType;
        return this;
    }

    @JsonProperty("bridgerAddress")
    public BridgerAddress getBridgerAddress() {
        return bridgerAddress;
    }

    @JsonProperty("bridgerAddress")
    public void setBridgerAddress(BridgerAddress bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
    }

    public CsgDetails withBridgerAddress(BridgerAddress bridgerAddress) {
        this.bridgerAddress = bridgerAddress;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cSGDetailsType).append(lineTagList).append(hookupType).append(dropType).append(bridgerAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CsgDetails) == false) {
            return false;
        }
        CsgDetails rhs = ((CsgDetails) other);
        return new EqualsBuilder().append(cSGDetailsType, rhs.cSGDetailsType).append(lineTagList, rhs.lineTagList).append(hookupType, rhs.hookupType).append(dropType, rhs.dropType).append(bridgerAddress, rhs.bridgerAddress).isEquals();
    }

}
