
package com.comcast.orion.workorder.domain.onp.insertwo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customerId",
    "siteId"
})
public class JobCustomer {

    /**
     * Amdocs CustomerId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("customerId")
    @JsonPropertyDescription("Amdocs CustomerId passed by Amdocs - WFX")
    private String customerId;
    /**
     * Site Id passed by Amdocs - WFX
     * 
     */
    @JsonProperty("siteId")
    @JsonPropertyDescription("Site Id passed by Amdocs - WFX")
    private String siteId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Amdocs CustomerId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Amdocs CustomerId passed by Amdocs - WFX
     * (Required)
     * 
     */
    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Site Id passed by Amdocs - WFX
     * 
     */
    @JsonProperty("siteId")
    public String getSiteId() {
        return siteId;
    }

    /**
     * Site Id passed by Amdocs - WFX
     * 
     */
    @JsonProperty("siteId")
    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("customerId", customerId).append("siteId", siteId).append("additionalProperties", additionalProperties).toString();
    }

}
