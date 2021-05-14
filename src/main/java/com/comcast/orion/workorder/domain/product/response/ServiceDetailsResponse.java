
package com.comcast.orion.workorder.domain.product.response;

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
    "servicedetails"
})
public class ServiceDetailsResponse {

    @JsonProperty("servicedetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private Servicedetails servicedetails;

    @JsonProperty("servicedetails")
    public Servicedetails getServicedetails() {
        return servicedetails;
    }

    @JsonProperty("servicedetails")
    public void setServicedetails(Servicedetails servicedetails) {
        this.servicedetails = servicedetails;
    }

    public ServiceDetailsResponse withServicedetails(Servicedetails servicedetails) {
        this.servicedetails = servicedetails;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(servicedetails).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceDetailsResponse) == false) {
            return false;
        }
        ServiceDetailsResponse rhs = ((ServiceDetailsResponse) other);
        return new EqualsBuilder().append(servicedetails, rhs.servicedetails).isEquals();
    }

}
