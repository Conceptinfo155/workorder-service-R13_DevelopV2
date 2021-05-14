
package com.comcast.orion.workorder.domain;

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
    "technicianArea"
})
public class CsgDetails {

    @JsonProperty("technicianArea")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String technicianArea;

    @JsonProperty("technicianArea")
    public String getTechnicianArea() {
        return technicianArea;
    }

    @JsonProperty("technicianArea")
    public void setTechnicianArea(String technicianArea) {
        this.technicianArea = technicianArea;
    }

    public CsgDetails withTechnicianArea(String technicianArea) {
        this.technicianArea = technicianArea;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(technicianArea).toHashCode();
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
        return new EqualsBuilder().append(technicianArea, rhs.technicianArea).isEquals();
    }

}
