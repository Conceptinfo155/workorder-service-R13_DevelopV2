
package com.comcast.orion.workorder.domain.vms;

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
    "type",
    "action",
    "tnNo",
    "tnType",
    "isPrimary",
    "features"
})
public class Service_ {

    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("action")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String action;
    @JsonProperty("tnNo")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tnNo;
    @JsonProperty("tnType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String tnType;
    @JsonProperty("isPrimary")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String isPrimary;
    @JsonProperty("features")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Feature> features = new ArrayList<Feature>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Service_ withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    public Service_ withAction(String action) {
        this.action = action;
        return this;
    }

    @JsonProperty("tnNo")
    public String getTnNo() {
        return tnNo;
    }

    @JsonProperty("tnNo")
    public void setTnNo(String tnNo) {
        this.tnNo = tnNo;
    }

    public Service_ withTnNo(String tnNo) {
        this.tnNo = tnNo;
        return this;
    }

    @JsonProperty("tnType")
    public String getTnType() {
        return tnType;
    }

    @JsonProperty("tnType")
    public void setTnType(String tnType) {
        this.tnType = tnType;
    }

    public Service_ withTnType(String tnType) {
        this.tnType = tnType;
        return this;
    }

    @JsonProperty("isPrimary")
    public String getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("isPrimary")
    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Service_ withIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }

    @JsonProperty("features")
    public List<Feature> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Service_ withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(action).append(tnNo).append(tnType).append(isPrimary).append(features).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Service_) == false) {
            return false;
        }
        Service_ rhs = ((Service_) other);
        return new EqualsBuilder().append(type, rhs.type).append(action, rhs.action).append(tnNo, rhs.tnNo).append(tnType, rhs.tnType).append(isPrimary, rhs.isPrimary).append(features, rhs.features).isEquals();
    }

}
