
package com.comcast.orion.workorder.domain.locationResponse;

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
    "responseItems"
})
public class LocationServiceResponse {

    @JsonProperty("responseItems")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private ResponseItems responseItems;

    @JsonProperty("responseItems")
    public ResponseItems getResponseItems() {
        return responseItems;
    }

    @JsonProperty("responseItems")
    public void setResponseItems(ResponseItems responseItems) {
        this.responseItems = responseItems;
    }

    public LocationServiceResponse withResponseItems(ResponseItems responseItems) {
        this.responseItems = responseItems;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(responseItems).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationServiceResponse) == false) {
            return false;
        }
        LocationServiceResponse rhs = ((LocationServiceResponse) other);
        return new EqualsBuilder().append(responseItems, rhs.responseItems).isEquals();
    }

}
