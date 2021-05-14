
package com.comcast.orion.workorder.domain.scheduleDomain;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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
    "BookAppointmentRequest"
})
public class BookApmtRequest {

    @JsonProperty("BookAppointmentRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BookAppointmentRequest bookAppointmentRequest;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BookAppointmentRequest")
    public BookAppointmentRequest getBookAppointmentRequest() {
        return bookAppointmentRequest;
    }

    @JsonProperty("BookAppointmentRequest")
    public void setBookAppointmentRequest(BookAppointmentRequest bookAppointmentRequest) {
        this.bookAppointmentRequest = bookAppointmentRequest;
    }

    public BookApmtRequest withBookAppointmentRequest(BookAppointmentRequest bookAppointmentRequest) {
        this.bookAppointmentRequest = bookAppointmentRequest;
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

    public BookApmtRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bookAppointmentRequest).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BookApmtRequest) == false) {
            return false;
        }
        BookApmtRequest rhs = ((BookApmtRequest) other);
        return new EqualsBuilder().append(bookAppointmentRequest, rhs.bookAppointmentRequest).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
