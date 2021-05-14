
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
    "workOrderNumber",
    "ticketNumber",
    "requestType",
    "noCrTicketIndicator",
    "noScheduleIndicator",
    "solutionDetails",
    "bookAppointment",
    "createWorkOrder"
})
public class ScheduleWorkorderRequest {

    @JsonProperty("workOrderNumber")
    @Size(min = 1, max = 20)
    private String workOrderNumber;
    @JsonProperty("ticketNumber")
    @Size(max = 14)
    private String ticketNumber;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("requestType")
    private RequestType requestType;
    @JsonProperty("noCrTicketIndicator")
    private Boolean noCrTicketIndicator;
    @JsonProperty("noScheduleIndicator")
    private Boolean noScheduleIndicator;
    @JsonProperty("solutionDetails")
    @Valid
    @NotNull
    @Size(min = 1)
    private List<SolutionDetail> solutionDetails;
    @JsonProperty("bookAppointment")
    @NotNull
    @Valid
    private BookAppointment bookAppointment;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createWorkOrder")
    @Valid
    @NotNull
    private CreateWorkOrder createWorkOrder;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("workOrderNumber")
    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    @JsonProperty("workOrderNumber")
    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    @JsonProperty("ticketNumber")
    public String getTicketNumber() {
        return ticketNumber;
    }

    @JsonProperty("ticketNumber")
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestType")
    public RequestType getRequestType() {
        return requestType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestType")
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @JsonProperty("noCrTicketIndicator")
    public Boolean getNoCrTicketIndicator() {
        return noCrTicketIndicator;
    }

    @JsonProperty("noCrTicketIndicator")
    public void setNoCrTicketIndicator(Boolean noCrTicketIndicator) {
        this.noCrTicketIndicator = noCrTicketIndicator;
    }

    @JsonProperty("noScheduleIndicator")
    public Boolean getNoScheduleIndicator() {
        return noScheduleIndicator;
    }

    @JsonProperty("noScheduleIndicator")
    public void setNoScheduleIndicator(Boolean noScheduleIndicator) {
        this.noScheduleIndicator = noScheduleIndicator;
    }

    @JsonProperty("solutionDetails")
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetails;
    }

    @JsonProperty("solutionDetails")
    public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
    }

    @JsonProperty("bookAppointment")
    public BookAppointment getBookAppointment() {
        return bookAppointment;
    }

    @JsonProperty("bookAppointment")
    public void setBookAppointment(BookAppointment bookAppointment) {
        this.bookAppointment = bookAppointment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createWorkOrder")
    public CreateWorkOrder getCreateWorkOrder() {
        return createWorkOrder;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createWorkOrder")
    public void setCreateWorkOrder(CreateWorkOrder createWorkOrder) {
        this.createWorkOrder = createWorkOrder;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum RequestType {

        NEW_REQUEST("NEW_REQUEST"),
        RETRY_WORKORDER("RETRY_WORKORDER");
        private final String value;
        private final static Map<String, RequestType> CONSTANTS = new HashMap<String, RequestType>();

        static {
            for (RequestType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private RequestType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static RequestType fromValue(String value) {
            RequestType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
