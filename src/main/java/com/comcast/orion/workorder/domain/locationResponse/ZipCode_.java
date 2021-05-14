
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
    "zip4",
    "zip5"
})
public class ZipCode_ {

    @JsonProperty("zip4")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zip4;
    @JsonProperty("zip5")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String zip5;

    @JsonProperty("zip4")
    public String getZip4() {
        return zip4;
    }

    @JsonProperty("zip4")
    public void setZip4(String zip4) {
        this.zip4 = zip4;
    }

    public ZipCode_ withZip4(String zip4) {
        this.zip4 = zip4;
        return this;
    }

    @JsonProperty("zip5")
    public String getZip5() {
        return zip5;
    }

    @JsonProperty("zip5")
    public void setZip5(String zip5) {
        this.zip5 = zip5;
    }

    public ZipCode_ withZip5(String zip5) {
        this.zip5 = zip5;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(zip4).append(zip5).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ZipCode_) == false) {
            return false;
        }
        ZipCode_ rhs = ((ZipCode_) other);
        return new EqualsBuilder().append(zip4, rhs.zip4).append(zip5, rhs.zip5).isEquals();
    }

}
