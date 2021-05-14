
package com.comcast.orion.workorder.domain.createwo;

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
    "CreateWorkorderResponse"
})
public class CreateWOResponse {

    @JsonProperty("CreateWorkorderResponse")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CreateWorkorderResponse createWorkorderResponse;

    @JsonProperty("CreateWorkorderResponse")
    public CreateWorkorderResponse getCreateWorkorderResponse() {
        return createWorkorderResponse;
    }

    @JsonProperty("CreateWorkorderResponse")
    public void setCreateWorkorderResponse(CreateWorkorderResponse createWorkorderResponse) {
        this.createWorkorderResponse = createWorkorderResponse;
    }

    public CreateWOResponse withCreateWorkorderResponse(CreateWorkorderResponse createWorkorderResponse) {
        this.createWorkorderResponse = createWorkorderResponse;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createWorkorderResponse).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateWOResponse) == false) {
            return false;
        }
        CreateWOResponse rhs = ((CreateWOResponse) other);
        return new EqualsBuilder().append(createWorkorderResponse, rhs.createWorkorderResponse).isEquals();
    }

}
