
package com.comcast.orion.workorder.domain;

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
    "timeZone",
    "utc",
    "dst",
    "zip5"
})
public class TimeZoneInfo {

    /**
     * The TimeZone
     * 
     */
    @JsonProperty("timeZone")
    @JsonPropertyDescription("The TimeZone")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The TimeZone", example = "Central Daylight Time")
    private String timeZone;
    /**
     * The UTC Time Zone
     * 
     */
    @JsonProperty("utc")
    @JsonPropertyDescription("The UTC Time Zone")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "The UTC Time Zone", example = "-5")
    private Integer utc;
    /**
     * The Elocmsagsourcename Schema 
     * 
     */
    @JsonProperty("dst")
    @JsonPropertyDescription("The Elocmsagsourcename Schema ")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "The Elocmsagsourcename Schema ", example = "true")
    private Boolean dst;
    /**
     * The Zip 5 of the address
     * 
     */
    @JsonProperty("zip5")
    @JsonPropertyDescription("The Zip 5 of the address")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "The Zip 5 of the address", example = "60616")
    private String zip5;

    /**
     * The TimeZone
     * 
     */
    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * The TimeZone
     * 
     */
    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public TimeZoneInfo withTimeZone(String timeZone) {
        this.timeZone = timeZone;
        return this;
    }

    /**
     * The UTC Time Zone
     * 
     */
    @JsonProperty("utc")
    public Integer getUtc() {
        return utc;
    }

    /**
     * The UTC Time Zone
     * 
     */
    @JsonProperty("utc")
    public void setUtc(Integer utc) {
        this.utc = utc;
    }

    public TimeZoneInfo withUtc(Integer utc) {
        this.utc = utc;
        return this;
    }

    /**
     * The Elocmsagsourcename Schema 
     * 
     */
    @JsonProperty("dst")
    public Boolean getDst() {
        return dst;
    }

    /**
     * The Elocmsagsourcename Schema 
     * 
     */
    @JsonProperty("dst")
    public void setDst(Boolean dst) {
        this.dst = dst;
    }

    public TimeZoneInfo withDst(Boolean dst) {
        this.dst = dst;
        return this;
    }

    /**
     * The Zip 5 of the address
     * 
     */
    @JsonProperty("zip5")
    public String getZip5() {
        return zip5;
    }

    /**
     * The Zip 5 of the address
     * 
     */
    @JsonProperty("zip5")
    public void setZip5(String zip5) {
        this.zip5 = zip5;
    }

    public TimeZoneInfo withZip5(String zip5) {
        this.zip5 = zip5;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timeZone).append(utc).append(dst).append(zip5).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TimeZoneInfo) == false) {
            return false;
        }
        TimeZoneInfo rhs = ((TimeZoneInfo) other);
        return new EqualsBuilder().append(timeZone, rhs.timeZone).append(utc, rhs.utc).append(dst, rhs.dst).append(zip5, rhs.zip5).isEquals();
    }

}
