
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
    "maxTrafficRateDOWN",
    "maxTrafficRateUP",
    "maxTrafficRealRateDOWN",
    "maxTrafficRealRateUP",
    "overProvisionMaxRateDOWN",
    "overProvisionMaxRateUP"
})
public class RateInfo {

    @JsonProperty("maxTrafficRateDOWN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String maxTrafficRateDOWN;
    @JsonProperty("maxTrafficRateUP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String maxTrafficRateUP;
    @JsonProperty("maxTrafficRealRateDOWN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String maxTrafficRealRateDOWN;
    @JsonProperty("maxTrafficRealRateUP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String maxTrafficRealRateUP;
    @JsonProperty("overProvisionMaxRateDOWN")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String overProvisionMaxRateDOWN;
    @JsonProperty("overProvisionMaxRateUP")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String overProvisionMaxRateUP;

    @JsonProperty("maxTrafficRateDOWN")
    public String getMaxTrafficRateDOWN() {
        return maxTrafficRateDOWN;
    }

    @JsonProperty("maxTrafficRateDOWN")
    public void setMaxTrafficRateDOWN(String maxTrafficRateDOWN) {
        this.maxTrafficRateDOWN = maxTrafficRateDOWN;
    }

    public RateInfo withMaxTrafficRateDOWN(String maxTrafficRateDOWN) {
        this.maxTrafficRateDOWN = maxTrafficRateDOWN;
        return this;
    }

    @JsonProperty("maxTrafficRateUP")
    public String getMaxTrafficRateUP() {
        return maxTrafficRateUP;
    }

    @JsonProperty("maxTrafficRateUP")
    public void setMaxTrafficRateUP(String maxTrafficRateUP) {
        this.maxTrafficRateUP = maxTrafficRateUP;
    }

    public RateInfo withMaxTrafficRateUP(String maxTrafficRateUP) {
        this.maxTrafficRateUP = maxTrafficRateUP;
        return this;
    }

    @JsonProperty("maxTrafficRealRateDOWN")
    public String getMaxTrafficRealRateDOWN() {
        return maxTrafficRealRateDOWN;
    }

    @JsonProperty("maxTrafficRealRateDOWN")
    public void setMaxTrafficRealRateDOWN(String maxTrafficRealRateDOWN) {
        this.maxTrafficRealRateDOWN = maxTrafficRealRateDOWN;
    }

    public RateInfo withMaxTrafficRealRateDOWN(String maxTrafficRealRateDOWN) {
        this.maxTrafficRealRateDOWN = maxTrafficRealRateDOWN;
        return this;
    }

    @JsonProperty("maxTrafficRealRateUP")
    public String getMaxTrafficRealRateUP() {
        return maxTrafficRealRateUP;
    }

    @JsonProperty("maxTrafficRealRateUP")
    public void setMaxTrafficRealRateUP(String maxTrafficRealRateUP) {
        this.maxTrafficRealRateUP = maxTrafficRealRateUP;
    }

    public RateInfo withMaxTrafficRealRateUP(String maxTrafficRealRateUP) {
        this.maxTrafficRealRateUP = maxTrafficRealRateUP;
        return this;
    }

    @JsonProperty("overProvisionMaxRateDOWN")
    public String getOverProvisionMaxRateDOWN() {
        return overProvisionMaxRateDOWN;
    }

    @JsonProperty("overProvisionMaxRateDOWN")
    public void setOverProvisionMaxRateDOWN(String overProvisionMaxRateDOWN) {
        this.overProvisionMaxRateDOWN = overProvisionMaxRateDOWN;
    }

    public RateInfo withOverProvisionMaxRateDOWN(String overProvisionMaxRateDOWN) {
        this.overProvisionMaxRateDOWN = overProvisionMaxRateDOWN;
        return this;
    }

    @JsonProperty("overProvisionMaxRateUP")
    public String getOverProvisionMaxRateUP() {
        return overProvisionMaxRateUP;
    }

    @JsonProperty("overProvisionMaxRateUP")
    public void setOverProvisionMaxRateUP(String overProvisionMaxRateUP) {
        this.overProvisionMaxRateUP = overProvisionMaxRateUP;
    }

    public RateInfo withOverProvisionMaxRateUP(String overProvisionMaxRateUP) {
        this.overProvisionMaxRateUP = overProvisionMaxRateUP;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(maxTrafficRateDOWN).append(maxTrafficRateUP).append(maxTrafficRealRateDOWN).append(maxTrafficRealRateUP).append(overProvisionMaxRateDOWN).append(overProvisionMaxRateUP).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RateInfo) == false) {
            return false;
        }
        RateInfo rhs = ((RateInfo) other);
        return new EqualsBuilder().append(maxTrafficRateDOWN, rhs.maxTrafficRateDOWN).append(maxTrafficRateUP, rhs.maxTrafficRateUP).append(maxTrafficRealRateDOWN, rhs.maxTrafficRealRateDOWN).append(maxTrafficRealRateUP, rhs.maxTrafficRealRateUP).append(overProvisionMaxRateDOWN, rhs.overProvisionMaxRateDOWN).append(overProvisionMaxRateUP, rhs.overProvisionMaxRateUP).isEquals();
    }

}
