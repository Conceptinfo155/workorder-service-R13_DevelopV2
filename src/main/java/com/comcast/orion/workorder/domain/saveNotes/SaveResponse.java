
package com.comcast.orion.workorder.domain.saveNotes;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    "SaveNoteResponse"
})
public class SaveResponse {

    @JsonProperty("SaveNoteResponse")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private SaveNoteResponse saveNoteResponse;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SaveNoteResponse")
    public SaveNoteResponse getSaveNoteResponse() {
        return saveNoteResponse;
    }

    @JsonProperty("SaveNoteResponse")
    public void setSaveNoteResponse(SaveNoteResponse saveNoteResponse) {
        this.saveNoteResponse = saveNoteResponse;
    }

    public SaveResponse withSaveNoteResponse(SaveNoteResponse saveNoteResponse) {
        this.saveNoteResponse = saveNoteResponse;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public SaveResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(saveNoteResponse).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SaveResponse) == false) {
            return false;
        }
        SaveResponse rhs = ((SaveResponse) other);
        return new EqualsBuilder().append(saveNoteResponse, rhs.saveNoteResponse).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
