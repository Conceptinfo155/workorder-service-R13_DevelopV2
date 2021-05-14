
package com.comcast.orion.workorder.domain.saveNotes;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    "createdBy",
    "noteType",
    "fieldsList"
})
public class SaveNoteRequest {

    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("createdBy")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "Sudeep Subhedar")
    @Size(min = 1, max = 100)
    private String createdBy;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("noteType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "Technician Note")
    private String noteType;
    @JsonProperty("fieldsList")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private FieldsList fieldsList;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public SaveNoteRequest withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("noteType")
    public String getNoteType() {
        return noteType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("noteType")
    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }

    public SaveNoteRequest withNoteType(String noteType) {
        this.noteType = noteType;
        return this;
    }

    @JsonProperty("fieldsList")
    public FieldsList getFieldsList() {
        return fieldsList;
    }

    @JsonProperty("fieldsList")
    public void setFieldsList(FieldsList fieldsList) {
        this.fieldsList = fieldsList;
    }

    public SaveNoteRequest withFieldsList(FieldsList fieldsList) {
        this.fieldsList = fieldsList;
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

    public SaveNoteRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(createdBy).append(noteType).append(fieldsList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SaveNoteRequest) == false) {
            return false;
        }
        SaveNoteRequest rhs = ((SaveNoteRequest) other);
        return new EqualsBuilder().append(createdBy, rhs.createdBy).append(noteType, rhs.noteType).append(fieldsList, rhs.fieldsList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
