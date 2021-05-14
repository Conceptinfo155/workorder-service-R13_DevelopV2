
package com.comcast.orion.workorder.domain.updatewo;

import javax.validation.Valid;
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
    "UpdateWorkorderRequest"
})
public class UpdateWORequest {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("UpdateWorkorderRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private UpdateWorkorderRequest updateWorkorderRequest;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("UpdateWorkorderRequest")
    public UpdateWorkorderRequest getUpdateWorkorderRequest() {
        return updateWorkorderRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("UpdateWorkorderRequest")
    public void setUpdateWorkorderRequest(UpdateWorkorderRequest updateWorkorderRequest) {
        this.updateWorkorderRequest = updateWorkorderRequest;
    }

    public UpdateWORequest withUpdateWorkorderRequest(UpdateWorkorderRequest updateWorkorderRequest) {
        this.updateWorkorderRequest = updateWorkorderRequest;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(updateWorkorderRequest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UpdateWORequest) == false) {
            return false;
        }
        UpdateWORequest rhs = ((UpdateWORequest) other);
        return new EqualsBuilder().append(updateWorkorderRequest, rhs.updateWorkorderRequest).isEquals();
    }

}
