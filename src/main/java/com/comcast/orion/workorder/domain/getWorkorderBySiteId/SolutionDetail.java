
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

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
    "solutionType",
    "orderType",
    "transportType"
})
public class SolutionDetail {

    @JsonProperty("solutionType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "ETHERNET")
    private String solutionType;
    @JsonProperty("orderType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "TC")
    private String orderType;
    @JsonProperty("transportType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "Coax")
    private String transportType;

    @JsonProperty("solutionType")
    public String getSolutionType() {
        return solutionType;
    }

    @JsonProperty("solutionType")
    public void setSolutionType(String solutionType) {
        this.solutionType = solutionType;
    }

    public SolutionDetail withSolutionType(String solutionType) {
        this.solutionType = solutionType;
        return this;
    }

    @JsonProperty("orderType")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("orderType")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public SolutionDetail withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    @JsonProperty("transportType")
    public String getTransportType() {
        return transportType;
    }

    @JsonProperty("transportType")
    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public SolutionDetail withTransportType(String transportType) {
        this.transportType = transportType;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(solutionType).append(orderType).append(transportType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SolutionDetail) == false) {
            return false;
        }
        SolutionDetail rhs = ((SolutionDetail) other);
        return new EqualsBuilder().append(solutionType, rhs.solutionType).append(orderType, rhs.orderType).append(transportType, rhs.transportType).isEquals();
    }

}
