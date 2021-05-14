
package com.comcast.orion.workorder.domain.installbase.tnFeature;

import java.util.ArrayList;
import java.util.List;
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
    "TNS"
})
public class TNFeaturesResponse {

    @JsonProperty("TNS")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<TN> tNS = new ArrayList<TN>();

    @JsonProperty("TNS")
    public List<TN> getTNS() {
        return tNS;
    }

    @JsonProperty("TNS")
    public void setTNS(List<TN> tNS) {
        this.tNS = tNS;
    }

    public TNFeaturesResponse withTNS(List<TN> tNS) {
        this.tNS = tNS;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tNS).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TNFeaturesResponse) == false) {
            return false;
        }
        TNFeaturesResponse rhs = ((TNFeaturesResponse) other);
        return new EqualsBuilder().append(tNS, rhs.tNS).isEquals();
    }

}
