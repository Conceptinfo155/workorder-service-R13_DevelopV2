
package com.comcast.orion.workorder.domain.locationResponse;

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
    "technicianArea",
    "houseKey"
})
public class CSGDetailsType {

    @JsonProperty("technicianArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String technicianArea;
    @JsonProperty("houseKey")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String houseKey;

    @JsonProperty("technicianArea")
    public String getTechnicianArea() {
        return technicianArea;
    }

    @JsonProperty("technicianArea")
    public void setTechnicianArea(String technicianArea) {
        this.technicianArea = technicianArea;
    }

    public CSGDetailsType withTechnicianArea(String technicianArea) {
        this.technicianArea = technicianArea;
        return this;
    }

    @JsonProperty("houseKey")
    public String getHouseKey() {
        return houseKey;
    }

    @JsonProperty("houseKey")
    public void setHouseKey(String houseKey) {
        this.houseKey = houseKey;
    }

    public CSGDetailsType withHouseKey(String houseKey) {
        this.houseKey = houseKey;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(technicianArea).append(houseKey).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CSGDetailsType) == false) {
            return false;
        }
        CSGDetailsType rhs = ((CSGDetailsType) other);
        return new EqualsBuilder().append(technicianArea, rhs.technicianArea).append(houseKey, rhs.houseKey).isEquals();
    }

}
