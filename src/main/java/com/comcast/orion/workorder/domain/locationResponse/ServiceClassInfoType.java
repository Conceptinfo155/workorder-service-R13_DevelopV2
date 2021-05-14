
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
    "rateInfo",
    "serviceClassNameDOWN",
    "serviceClassNameUP"
})
public class ServiceClassInfoType {

    @JsonProperty("rateInfo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private RateInfo rateInfo;
    @JsonProperty("serviceClassNameDOWN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceClassNameDOWN;
    @JsonProperty("serviceClassNameUP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String serviceClassNameUP;

    @JsonProperty("rateInfo")
    public RateInfo getRateInfo() {
        return rateInfo;
    }

    @JsonProperty("rateInfo")
    public void setRateInfo(RateInfo rateInfo) {
        this.rateInfo = rateInfo;
    }

    public ServiceClassInfoType withRateInfo(RateInfo rateInfo) {
        this.rateInfo = rateInfo;
        return this;
    }

    @JsonProperty("serviceClassNameDOWN")
    public String getServiceClassNameDOWN() {
        return serviceClassNameDOWN;
    }

    @JsonProperty("serviceClassNameDOWN")
    public void setServiceClassNameDOWN(String serviceClassNameDOWN) {
        this.serviceClassNameDOWN = serviceClassNameDOWN;
    }

    public ServiceClassInfoType withServiceClassNameDOWN(String serviceClassNameDOWN) {
        this.serviceClassNameDOWN = serviceClassNameDOWN;
        return this;
    }

    @JsonProperty("serviceClassNameUP")
    public String getServiceClassNameUP() {
        return serviceClassNameUP;
    }

    @JsonProperty("serviceClassNameUP")
    public void setServiceClassNameUP(String serviceClassNameUP) {
        this.serviceClassNameUP = serviceClassNameUP;
    }

    public ServiceClassInfoType withServiceClassNameUP(String serviceClassNameUP) {
        this.serviceClassNameUP = serviceClassNameUP;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rateInfo).append(serviceClassNameDOWN).append(serviceClassNameUP).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServiceClassInfoType) == false) {
            return false;
        }
        ServiceClassInfoType rhs = ((ServiceClassInfoType) other);
        return new EqualsBuilder().append(rateInfo, rhs.rateInfo).append(serviceClassNameDOWN, rhs.serviceClassNameDOWN).append(serviceClassNameUP, rhs.serviceClassNameUP).isEquals();
    }

}
