
package com.comcast.orion.workorder.domain.locationResponse;

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
    "Agent",
    "CSGSystem",
    "Principle"
})
public class CSGMarketInfo {

    @JsonProperty("Agent")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String agent;
    @JsonProperty("CSGSystem")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String cSGSystem;
    @JsonProperty("Principle")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String principle;

    @JsonProperty("Agent")
    public String getAgent() {
        return agent;
    }

    @JsonProperty("Agent")
    public void setAgent(String agent) {
        this.agent = agent;
    }

    public CSGMarketInfo withAgent(String agent) {
        this.agent = agent;
        return this;
    }

    @JsonProperty("CSGSystem")
    public String getCSGSystem() {
        return cSGSystem;
    }

    @JsonProperty("CSGSystem")
    public void setCSGSystem(String cSGSystem) {
        this.cSGSystem = cSGSystem;
    }

    public CSGMarketInfo withCSGSystem(String cSGSystem) {
        this.cSGSystem = cSGSystem;
        return this;
    }

    @JsonProperty("Principle")
    public String getPrinciple() {
        return principle;
    }

    @JsonProperty("Principle")
    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public CSGMarketInfo withPrinciple(String principle) {
        this.principle = principle;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agent).append(cSGSystem).append(principle).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CSGMarketInfo) == false) {
            return false;
        }
        CSGMarketInfo rhs = ((CSGMarketInfo) other);
        return new EqualsBuilder().append(agent, rhs.agent).append(cSGSystem, rhs.cSGSystem).append(principle, rhs.principle).isEquals();
    }

}
