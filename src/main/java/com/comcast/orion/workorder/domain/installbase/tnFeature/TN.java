
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
    "type",
    "status",
    "attributes",
    "features"
})
public class TN {

    @JsonProperty("type")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String type;
    @JsonProperty("status")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String status;
    @JsonProperty("attributes")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<Attribute> attributes = new ArrayList<Attribute>();
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

    public TN withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public TN withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public TN withAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
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

    public TN withFeatures(List<Feature> features) {
        this.features = features;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(status).append(attributes).append(features).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TN) == false) {
            return false;
        }
        TN rhs = ((TN) other);
        return new EqualsBuilder().append(type, rhs.type).append(status, rhs.status).append(attributes, rhs.attributes).append(features, rhs.features).isEquals();
    }

}
