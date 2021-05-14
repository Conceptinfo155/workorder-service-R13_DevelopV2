
package com.comcast.orion.workorder.domain.scheduleWorkOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "SR0980970009898")
    @Size(min = 1, max = 20)
    private String workOrderNumber;
    @JsonProperty("ticketNumber")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "SR0980970009898")
    @Size(max = 14)
    private String ticketNumber;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("requestType")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "string", position = 0, value = "", example = "NEW_REQUEST")
    private ScheduleWorkorderRequest.RequestType requestType;
    @JsonProperty("noCrTicketIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "", example = "false")
    private Boolean noCrTicketIndicator;
    @JsonProperty("noScheduleIndicator")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "boolean", position = 0, value = "", example = "false")
    private Boolean noScheduleIndicator;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("solutionDetails")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "array", position = 0, value = "", example = "")
    @Valid
    private List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("bookAppointment")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "object", position = 0, value = "", example = "")
    private BookAppointment bookAppointment;
    /**
     * 
     * (Required)
     * 
     */
    @NotNull
    @JsonProperty("createWorkOrder")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = true, dataType = "object", position = 0, value = "", example = "")
    @Valid
    private CreateWorkOrder createWorkOrder;

    @JsonProperty("workOrderNumber")
    public String getWorkOrderNumber() {
        return workOrderNumber;
    }

    @JsonProperty("workOrderNumber")
    public void setWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
    }

    public ScheduleWorkorderRequest withWorkOrderNumber(String workOrderNumber) {
        this.workOrderNumber = workOrderNumber;
        return this;
    }

    @JsonProperty("ticketNumber")
    public String getTicketNumber() {
        return ticketNumber;
    }

    @JsonProperty("ticketNumber")
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public ScheduleWorkorderRequest withTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestType")
    public ScheduleWorkorderRequest.RequestType getRequestType() {
        return requestType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestType")
    public void setRequestType(ScheduleWorkorderRequest.RequestType requestType) {
        this.requestType = requestType;
    }

    public ScheduleWorkorderRequest withRequestType(ScheduleWorkorderRequest.RequestType requestType) {
        this.requestType = requestType;
        return this;
    }

    @JsonProperty("noCrTicketIndicator")
    public Boolean getNoCrTicketIndicator() {
        return noCrTicketIndicator;
    }

    @JsonProperty("noCrTicketIndicator")
    public void setNoCrTicketIndicator(Boolean noCrTicketIndicator) {
        this.noCrTicketIndicator = noCrTicketIndicator;
    }

    public ScheduleWorkorderRequest withNoCrTicketIndicator(Boolean noCrTicketIndicator) {
        this.noCrTicketIndicator = noCrTicketIndicator;
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

    public ScheduleWorkorderRequest withNoScheduleIndicator(Boolean noScheduleIndicator) {
        this.noScheduleIndicator = noScheduleIndicator;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionDetails")
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetails;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("solutionDetails")
    public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
    }

    public ScheduleWorkorderRequest withSolutionDetails(List<SolutionDetail> solutionDetails) {
        this.solutionDetails = solutionDetails;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("bookAppointment")
    public BookAppointment getBookAppointment() {
        return bookAppointment;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("bookAppointment")
    public void setBookAppointment(BookAppointment bookAppointment) {
        this.bookAppointment = bookAppointment;
    }

    public ScheduleWorkorderRequest withBookAppointment(BookAppointment bookAppointment) {
        this.bookAppointment = bookAppointment;
        return this;
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

    public ScheduleWorkorderRequest withCreateWorkOrder(CreateWorkOrder createWorkOrder) {
        this.createWorkOrder = createWorkOrder;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(workOrderNumber).append(ticketNumber).append(requestType).append(noCrTicketIndicator).append(noScheduleIndicator).append(solutionDetails).append(bookAppointment).append(createWorkOrder).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ScheduleWorkorderRequest) == false) {
            return false;
        }
        ScheduleWorkorderRequest rhs = ((ScheduleWorkorderRequest) other);
        return new EqualsBuilder().append(workOrderNumber, rhs.workOrderNumber).append(ticketNumber, rhs.ticketNumber).append(requestType, rhs.requestType).append(noCrTicketIndicator, rhs.noCrTicketIndicator).append(noScheduleIndicator, rhs.noScheduleIndicator).append(solutionDetails, rhs.solutionDetails).append(bookAppointment, rhs.bookAppointment).append(createWorkOrder, rhs.createWorkOrder).isEquals();
    }

    public enum RequestType {

        NEW_REQUEST("NEW_REQUEST"),
        RETRY_WORKORDER("RETRY_WORKORDER");
        private final String value;
        private final static Map<String, ScheduleWorkorderRequest.RequestType> CONSTANTS = new HashMap<String, ScheduleWorkorderRequest.RequestType>();

        static {
            for (ScheduleWorkorderRequest.RequestType c: values()) {
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
        public static ScheduleWorkorderRequest.RequestType fromValue(String value) {
            ScheduleWorkorderRequest.RequestType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
