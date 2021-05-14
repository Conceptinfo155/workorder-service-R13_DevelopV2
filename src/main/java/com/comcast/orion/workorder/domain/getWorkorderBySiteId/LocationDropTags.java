
package com.comcast.orion.workorder.domain.getWorkorderBySiteId;

import javax.validation.constraints.NotNull;
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
    "DropTag1",
    "DropTag2",
    "DropTag3"
})
public class LocationDropTags {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag1")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object dropTag1;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag2")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object dropTag2;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag3")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "null", position = 0, value = "", example = "")
    @NotNull
    private Object dropTag3;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag1")
    public Object getDropTag1() {
        return dropTag1;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag1")
    public void setDropTag1(Object dropTag1) {
        this.dropTag1 = dropTag1;
    }

    public LocationDropTags withDropTag1(Object dropTag1) {
        this.dropTag1 = dropTag1;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag2")
    public Object getDropTag2() {
        return dropTag2;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag2")
    public void setDropTag2(Object dropTag2) {
        this.dropTag2 = dropTag2;
    }

    public LocationDropTags withDropTag2(Object dropTag2) {
        this.dropTag2 = dropTag2;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag3")
    public Object getDropTag3() {
        return dropTag3;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("DropTag3")
    public void setDropTag3(Object dropTag3) {
        this.dropTag3 = dropTag3;
    }

    public LocationDropTags withDropTag3(Object dropTag3) {
        this.dropTag3 = dropTag3;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dropTag1).append(dropTag2).append(dropTag3).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LocationDropTags) == false) {
            return false;
        }
        LocationDropTags rhs = ((LocationDropTags) other);
        return new EqualsBuilder().append(dropTag1, rhs.dropTag1).append(dropTag2, rhs.dropTag2).append(dropTag3, rhs.dropTag3).isEquals();
    }

}
