
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "optionId",
    "forceBookInd",
    "reservationId"
})
public class BookAppointment {

    @JsonProperty("optionId")
    @NotNull
    private String optionId;
    @JsonProperty("forceBookInd")
    private Boolean forceBookInd;
    @JsonProperty("reservationId")
    @NotNull
    private String reservationId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("optionId")
    public String getOptionId() {
        return optionId;
    }

    @JsonProperty("optionId")
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    @JsonProperty("forceBookInd")
    public Boolean getForceBookInd() {
        return forceBookInd;
    }

    @JsonProperty("forceBookInd")
    public void setForceBookInd(Boolean forceBookInd) {
        this.forceBookInd = forceBookInd;
    }

    @JsonProperty("reservationId")
    public String getReservationId() {
        return reservationId;
    }

    @JsonProperty("reservationId")
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
