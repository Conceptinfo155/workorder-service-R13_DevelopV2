
package com.comcast.orion.workorder.domain.createwo;

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
    "CreateWorkorderRequest"
})
public class CreateWORequest {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("CreateWorkorderRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CreateWorkorderRequest createWorkorderRequest;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CreateWorkorderRequest")
    public CreateWorkorderRequest getCreateWorkorderRequest() {
        return createWorkorderRequest;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("CreateWorkorderRequest")
    public void setCreateWorkorderRequest(CreateWorkorderRequest createWorkorderRequest) {
        this.createWorkorderRequest = createWorkorderRequest;
    }

    public CreateWORequest withCreateWorkorderRequest(CreateWorkorderRequest createWorkorderRequest) {
        this.createWorkorderRequest = createWorkorderRequest;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createWorkorderRequest).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateWORequest) == false) {
            return false;
        }
        CreateWORequest rhs = ((CreateWORequest) other);
        return new EqualsBuilder().append(createWorkorderRequest, rhs.createWorkorderRequest).isEquals();
    }

}
