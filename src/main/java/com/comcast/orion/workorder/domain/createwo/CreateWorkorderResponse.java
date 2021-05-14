
package com.comcast.orion.workorder.domain.createwo;

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
    "workOrderNum",
    "response"
})
public class CreateWorkorderResponse {

    @JsonProperty("workOrderNum")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String workOrderNum;
    @JsonProperty("response")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String response;

    @JsonProperty("workOrderNum")
    public String getWorkOrderNum() {
        return workOrderNum;
    }

    @JsonProperty("workOrderNum")
    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public CreateWorkorderResponse withWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
        return this;
    }

    @JsonProperty("response")
    public String getResponse() {
        return response;
    }

    @JsonProperty("response")
    public void setResponse(String response) {
        this.response = response;
    }

    public CreateWorkorderResponse withResponse(String response) {
        this.response = response;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderNum).append(response).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreateWorkorderResponse) == false) {
            return false;
        }
        CreateWorkorderResponse rhs = ((CreateWorkorderResponse) other);
        return new EqualsBuilder().append(workOrderNum, rhs.workOrderNum).append(response, rhs.response).isEquals();
    }

}
