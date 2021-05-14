
package com.comcast.orion.workorder.domain.scheduleDomain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({
    "OptionId"
})
public class AppointmentOption_ {

    /**
     * OptionId
     * (Required)
     * 
     */
    @JsonProperty("OptionId")
    @JsonPropertyDescription("OptionId")
    @ApiModelProperty(required = false, dataType = "string", position = 1, value = "OptionId", example = "797333")
    @Size(min = 1, max = 20)
    @NotNull
    private String optionId;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * OptionId
     * (Required)
     * 
     */
    @JsonProperty("OptionId")
    public String getOptionId() {
        return optionId;
    }

    /**
     * OptionId
     * (Required)
     * 
     */
    @JsonProperty("OptionId")
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public AppointmentOption_ withOptionId(String optionId) {
        this.optionId = optionId;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AppointmentOption_ withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(optionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppointmentOption_) == false) {
            return false;
        }
        AppointmentOption_ rhs = ((AppointmentOption_) other);
        return new EqualsBuilder().append(optionId, rhs.optionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
