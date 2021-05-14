
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
    "code",
    "message"
})
public class BookAppointmentResponse {

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "")
    @Size(min = 1, max = 15)
    @NotNull
    private String code;
    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "")
    @Size(min = 1, max = 100)
    @NotNull
    private String message;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public BookAppointmentResponse withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * 
     * (Required)
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public BookAppointmentResponse withMessage(String message) {
        this.message = message;
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

    public BookAppointmentResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(code).append(message).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BookAppointmentResponse) == false) {
            return false;
        }
        BookAppointmentResponse rhs = ((BookAppointmentResponse) other);
        return new EqualsBuilder().append(code, rhs.code).append(message, rhs.message).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
