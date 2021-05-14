
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
    "SaveNoteRequest"
})
public class SaveRequest {

    @JsonProperty("SaveNoteRequest")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private SaveNoteRequest saveNoteRequest;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SaveNoteRequest")
    public SaveNoteRequest getSaveNoteRequest() {
        return saveNoteRequest;
    }

    @JsonProperty("SaveNoteRequest")
    public void setSaveNoteRequest(SaveNoteRequest saveNoteRequest) {
        this.saveNoteRequest = saveNoteRequest;
    }

    public SaveRequest withSaveNoteRequest(SaveNoteRequest saveNoteRequest) {
        this.saveNoteRequest = saveNoteRequest;
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

    public SaveRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(saveNoteRequest).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SaveRequest) == false) {
            return false;
        }
        SaveRequest rhs = ((SaveRequest) other);
        return new EqualsBuilder().append(saveNoteRequest, rhs.saveNoteRequest).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
