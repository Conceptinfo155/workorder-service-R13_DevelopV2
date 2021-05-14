
package com.comcast.orion.workorder.domain.updatewo;

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
    "UpdateWorkorderResponse"
})
public class UpdateWOResponse {

    @JsonProperty("UpdateWorkorderResponse")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private UpdateWorkorderResponse updateWorkorderResponse;

    @JsonProperty("UpdateWorkorderResponse")
    public UpdateWorkorderResponse getUpdateWorkorderResponse() {
        return updateWorkorderResponse;
    }

    @JsonProperty("UpdateWorkorderResponse")
    public void setUpdateWorkorderResponse(UpdateWorkorderResponse updateWorkorderResponse) {
        this.updateWorkorderResponse = updateWorkorderResponse;
    }

    public UpdateWOResponse withUpdateWorkorderResponse(UpdateWorkorderResponse updateWorkorderResponse) {
        this.updateWorkorderResponse = updateWorkorderResponse;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(updateWorkorderResponse).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateWOResponse) == false) {
            return false;
        }
        UpdateWOResponse rhs = ((UpdateWOResponse) other);
        return new EqualsBuilder().append(updateWorkorderResponse, rhs.updateWorkorderResponse).isEquals();
    }

}
