
package com.comcast.orion.workorder.domain.ods.customer;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "errors"
})
public class CustomerServiceError {

    @JsonProperty("errors")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "array", position = 0, value = "", example = "")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    @Size(min = 1)
    @Valid
    private Set<Error> errors = new LinkedHashSet<Error>();

    @JsonProperty("errors")
    public Set<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(Set<Error> errors) {
        this.errors = errors;
    }

    public CustomerServiceError withErrors(Set<Error> errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(errors).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerServiceError) == false) {
            return false;
        }
        CustomerServiceError rhs = ((CustomerServiceError) other);
        return new EqualsBuilder().append(errors, rhs.errors).isEquals();
    }

}
