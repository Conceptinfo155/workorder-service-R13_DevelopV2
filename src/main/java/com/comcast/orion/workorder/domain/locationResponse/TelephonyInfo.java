
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
    "I2",
    "ilecName",
    "lata",
    "lataName",
    "psapAgency",
    "psapId",
    "rateCenterCertification",
    "rateCenterName",
    "rateCenterServiceable",
    "tnOrderPool",
    "wireCenter"
})
public class TelephonyInfo {

    @JsonProperty("I2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String i2;
    @JsonProperty("ilecName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String ilecName;
    @JsonProperty("lata")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lata;
    @JsonProperty("lataName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String lataName;
    @JsonProperty("psapAgency")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String psapAgency;
    @JsonProperty("psapId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String psapId;
    @JsonProperty("rateCenterCertification")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String rateCenterCertification;
    @JsonProperty("rateCenterName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String rateCenterName;
    @JsonProperty("rateCenterServiceable")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private RateCenterServiceable rateCenterServiceable;
    @JsonProperty("tnOrderPool")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tnOrderPool;
    @JsonProperty("wireCenter")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String wireCenter;

    @JsonProperty("I2")
    public String getI2() {
        return i2;
    }

    @JsonProperty("I2")
    public void setI2(String i2) {
        this.i2 = i2;
    }

    public TelephonyInfo withI2(String i2) {
        this.i2 = i2;
        return this;
    }

    @JsonProperty("ilecName")
    public String getIlecName() {
        return ilecName;
    }

    @JsonProperty("ilecName")
    public void setIlecName(String ilecName) {
        this.ilecName = ilecName;
    }

    public TelephonyInfo withIlecName(String ilecName) {
        this.ilecName = ilecName;
        return this;
    }

    @JsonProperty("lata")
    public String getLata() {
        return lata;
    }

    @JsonProperty("lata")
    public void setLata(String lata) {
        this.lata = lata;
    }

    public TelephonyInfo withLata(String lata) {
        this.lata = lata;
        return this;
    }

    @JsonProperty("lataName")
    public String getLataName() {
        return lataName;
    }

    @JsonProperty("lataName")
    public void setLataName(String lataName) {
        this.lataName = lataName;
    }

    public TelephonyInfo withLataName(String lataName) {
        this.lataName = lataName;
        return this;
    }

    @JsonProperty("psapAgency")
    public String getPsapAgency() {
        return psapAgency;
    }

    @JsonProperty("psapAgency")
    public void setPsapAgency(String psapAgency) {
        this.psapAgency = psapAgency;
    }

    public TelephonyInfo withPsapAgency(String psapAgency) {
        this.psapAgency = psapAgency;
        return this;
    }

    @JsonProperty("psapId")
    public String getPsapId() {
        return psapId;
    }

    @JsonProperty("psapId")
    public void setPsapId(String psapId) {
        this.psapId = psapId;
    }

    public TelephonyInfo withPsapId(String psapId) {
        this.psapId = psapId;
        return this;
    }

    @JsonProperty("rateCenterCertification")
    public String getRateCenterCertification() {
        return rateCenterCertification;
    }

    @JsonProperty("rateCenterCertification")
    public void setRateCenterCertification(String rateCenterCertification) {
        this.rateCenterCertification = rateCenterCertification;
    }

    public TelephonyInfo withRateCenterCertification(String rateCenterCertification) {
        this.rateCenterCertification = rateCenterCertification;
        return this;
    }

    @JsonProperty("rateCenterName")
    public String getRateCenterName() {
        return rateCenterName;
    }

    @JsonProperty("rateCenterName")
    public void setRateCenterName(String rateCenterName) {
        this.rateCenterName = rateCenterName;
    }

    public TelephonyInfo withRateCenterName(String rateCenterName) {
        this.rateCenterName = rateCenterName;
        return this;
    }

    @JsonProperty("rateCenterServiceable")
    public RateCenterServiceable getRateCenterServiceable() {
        return rateCenterServiceable;
    }

    @JsonProperty("rateCenterServiceable")
    public void setRateCenterServiceable(RateCenterServiceable rateCenterServiceable) {
        this.rateCenterServiceable = rateCenterServiceable;
    }

    public TelephonyInfo withRateCenterServiceable(RateCenterServiceable rateCenterServiceable) {
        this.rateCenterServiceable = rateCenterServiceable;
        return this;
    }

    @JsonProperty("tnOrderPool")
    public String getTnOrderPool() {
        return tnOrderPool;
    }

    @JsonProperty("tnOrderPool")
    public void setTnOrderPool(String tnOrderPool) {
        this.tnOrderPool = tnOrderPool;
    }

    public TelephonyInfo withTnOrderPool(String tnOrderPool) {
        this.tnOrderPool = tnOrderPool;
        return this;
    }

    @JsonProperty("wireCenter")
    public String getWireCenter() {
        return wireCenter;
    }

    @JsonProperty("wireCenter")
    public void setWireCenter(String wireCenter) {
        this.wireCenter = wireCenter;
    }

    public TelephonyInfo withWireCenter(String wireCenter) {
        this.wireCenter = wireCenter;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(i2).append(ilecName).append(lata).append(lataName).append(psapAgency).append(psapId).append(rateCenterCertification).append(rateCenterName).append(rateCenterServiceable).append(tnOrderPool).append(wireCenter).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TelephonyInfo) == false) {
            return false;
        }
        TelephonyInfo rhs = ((TelephonyInfo) other);
        return new EqualsBuilder().append(i2, rhs.i2).append(ilecName, rhs.ilecName).append(lata, rhs.lata).append(lataName, rhs.lataName).append(psapAgency, rhs.psapAgency).append(psapId, rhs.psapId).append(rateCenterCertification, rhs.rateCenterCertification).append(rateCenterName, rhs.rateCenterName).append(rateCenterServiceable, rhs.rateCenterServiceable).append(tnOrderPool, rhs.tnOrderPool).append(wireCenter, rhs.wireCenter).isEquals();
    }

}
