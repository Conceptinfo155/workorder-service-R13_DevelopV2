
package com.comcast.orion.workorder.domain.reschedule.request;

import javax.validation.constraints.Size;
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
    "optionId",
    "forceBookInd",
    "reservationId",
    "noScheduleIndicator",
    "scheduleANoScheduleIndicator"
})
public class Appointment {

    @JsonProperty("optionId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "09876")
    @Size(max = 20)
    private String optionId;
    @JsonProperty("forceBookInd")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "", example = "true")
    private Boolean forceBookInd;
    @JsonProperty("reservationId")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "09876")
    @Size(max = 19)
    private String reservationId;
    @JsonProperty("noScheduleIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "", example = "false")
    private Boolean noScheduleIndicator;
    @JsonProperty("scheduleANoScheduleIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "", example = "false")
    private Boolean scheduleANoScheduleIndicator;

    @JsonProperty("optionId")
    public String getOptionId() {
        return optionId;
    }

    @JsonProperty("optionId")
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public Appointment withOptionId(String optionId) {
        this.optionId = optionId;
        return this;
    }

    @JsonProperty("forceBookInd")
    public Boolean getForceBookInd() {
        return forceBookInd;
    }

    @JsonProperty("forceBookInd")
    public void setForceBookInd(Boolean forceBookInd) {
        this.forceBookInd = forceBookInd;
    }

    public Appointment withForceBookInd(Boolean forceBookInd) {
        this.forceBookInd = forceBookInd;
        return this;
    }

    @JsonProperty("reservationId")
    public String getReservationId() {
        return reservationId;
    }

    @JsonProperty("reservationId")
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Appointment withReservationId(String reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    @JsonProperty("noScheduleIndicator")
    public Boolean getNoScheduleIndicator() {
        return noScheduleIndicator;
    }

    @JsonProperty("noScheduleIndicator")
    public void setNoScheduleIndicator(Boolean noScheduleIndicator) {
        this.noScheduleIndicator = noScheduleIndicator;
    }

    public Appointment withNoScheduleIndicator(Boolean noScheduleIndicator) {
        this.noScheduleIndicator = noScheduleIndicator;
        return this;
    }

    @JsonProperty("scheduleANoScheduleIndicator")
    public Boolean getScheduleANoScheduleIndicator() {
        return scheduleANoScheduleIndicator;
    }

    @JsonProperty("scheduleANoScheduleIndicator")
    public void setScheduleANoScheduleIndicator(Boolean scheduleANoScheduleIndicator) {
        this.scheduleANoScheduleIndicator = scheduleANoScheduleIndicator;
    }

    public Appointment withScheduleANoScheduleIndicator(Boolean scheduleANoScheduleIndicator) {
        this.scheduleANoScheduleIndicator = scheduleANoScheduleIndicator;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(optionId).append(forceBookInd).append(reservationId).append(noScheduleIndicator).append(scheduleANoScheduleIndicator).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Appointment) == false) {
            return false;
        }
        Appointment rhs = ((Appointment) other);
        return new EqualsBuilder().append(optionId, rhs.optionId).append(forceBookInd, rhs.forceBookInd).append(reservationId, rhs.reservationId).append(noScheduleIndicator, rhs.noScheduleIndicator).append(scheduleANoScheduleIndicator, rhs.scheduleANoScheduleIndicator).isEquals();
    }

}
