
package com.comcast.orion.workorder.domain.sqoschedulewo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productCatalogId",
    "productOfferInstanceId",
    "productOfferingName",
    "productName"
})
public class SolutionDetail {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productCatalogId")
    private String productCatalogId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productOfferInstanceId")
    private String productOfferInstanceId;
    @JsonProperty("productOfferingName")
    private String productOfferingName;
    @JsonProperty("productName")
    private String productName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productCatalogId")
    public String getProductCatalogId() {
        return productCatalogId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productCatalogId")
    public void setProductCatalogId(String productCatalogId) {
        this.productCatalogId = productCatalogId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productOfferInstanceId")
    public String getProductOfferInstanceId() {
        return productOfferInstanceId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("productOfferInstanceId")
    public void setProductOfferInstanceId(String productOfferInstanceId) {
        this.productOfferInstanceId = productOfferInstanceId;
    }

    @JsonProperty("productOfferingName")
    public String getProductOfferingName() {
        return productOfferingName;
    }

    @JsonProperty("productOfferingName")
    public void setProductOfferingName(String productOfferingName) {
        this.productOfferingName = productOfferingName;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
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
