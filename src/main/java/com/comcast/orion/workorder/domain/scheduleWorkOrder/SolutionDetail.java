
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
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

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("solutionType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "ENS")
    private String solutionType;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("orderType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "TC")
    private String orderType;
    
    @JsonProperty("transportType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "OTT")
    private String transportType;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionType")
    public String getSolutionType() {
        return solutionType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionType")
    public void setSolutionType(String solutionType) {
        this.solutionType = solutionType;
    }

    public SolutionDetail withSolutionType(String solutionType) {
        this.solutionType = solutionType;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("orderType")
    public String getOrderType() {
        return orderType;
    }

    /**
     * 
     * (Required)
     * 
     */
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

    /**
     * 
     * (Required)
     * 
     */
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

    public enum OrderType {

        TC("TC"),
        SRO("SRO");
        private final String value;
        private final static Map<String, SolutionDetail.OrderType> CONSTANTS = new HashMap<String, SolutionDetail.OrderType>();

        static {
            for (SolutionDetail.OrderType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private OrderType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static SolutionDetail.OrderType fromValue(String value) {
            SolutionDetail.OrderType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
