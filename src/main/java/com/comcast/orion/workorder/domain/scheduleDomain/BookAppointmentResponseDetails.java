
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
    "BookAppointmentResponse"
})
public class BookAppointmentResponseDetails {

    @JsonProperty("BookAppointmentResponse")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private BookAppointmentResponse bookAppointmentResponse;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("BookAppointmentResponse")
    public BookAppointmentResponse getBookAppointmentResponse() {
        return bookAppointmentResponse;
    }

    @JsonProperty("BookAppointmentResponse")
    public void setBookAppointmentResponse(BookAppointmentResponse bookAppointmentResponse) {
        this.bookAppointmentResponse = bookAppointmentResponse;
    }

    public BookAppointmentResponseDetails withBookAppointmentResponse(BookAppointmentResponse bookAppointmentResponse) {
        this.bookAppointmentResponse = bookAppointmentResponse;
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

    public BookAppointmentResponseDetails withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bookAppointmentResponse).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BookAppointmentResponseDetails) == false) {
            return false;
        }
        BookAppointmentResponseDetails rhs = ((BookAppointmentResponseDetails) other);
        return new EqualsBuilder().append(bookAppointmentResponse, rhs.bookAppointmentResponse).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
