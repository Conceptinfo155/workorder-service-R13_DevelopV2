
package com.comcast.orion.workorder.domain.getorderdetails;

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
    "scrubbedError",
    "scrubbedSite",
    "totalSites",
    "unscrubbedSite"
})
public class CustomerSiteCount {

    /**
     * The total number of scrubbed errors
     * 
     */
    @JsonProperty("scrubbedError")
    @JsonPropertyDescription("The total number of scrubbed errors")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "The total number of scrubbed errors", example = "2")
    private Integer scrubbedError;
    /**
     * The total number of scrubbed sites
     * 
     */
    @JsonProperty("scrubbedSite")
    @JsonPropertyDescription("The total number of scrubbed sites")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "The total number of scrubbed sites", example = "8")
    private Integer scrubbedSite;
    /**
     * The total number of customer sites
     * 
     */
    @JsonProperty("totalSites")
    @JsonPropertyDescription("The total number of customer sites")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "The total number of customer sites", example = "12")
    private Integer totalSites;
    /**
     * The total number of unscrubbed sites
     * 
     */
    @JsonProperty("unscrubbedSite")
    @JsonPropertyDescription("The total number of unscrubbed sites")
    @ApiModelProperty(required = false, dataType = "integer", position = 0, value = "The total number of unscrubbed sites", example = "4")
    private Integer unscrubbedSite;

    /**
     * The total number of scrubbed errors
     * 
     */
    @JsonProperty("scrubbedError")
    public Integer getScrubbedError() {
        return scrubbedError;
    }

    /**
     * The total number of scrubbed errors
     * 
     */
    @JsonProperty("scrubbedError")
    public void setScrubbedError(Integer scrubbedError) {
        this.scrubbedError = scrubbedError;
    }

    public CustomerSiteCount withScrubbedError(Integer scrubbedError) {
        this.scrubbedError = scrubbedError;
        return this;
    }

    /**
     * The total number of scrubbed sites
     * 
     */
    @JsonProperty("scrubbedSite")
    public Integer getScrubbedSite() {
        return scrubbedSite;
    }

    /**
     * The total number of scrubbed sites
     * 
     */
    @JsonProperty("scrubbedSite")
    public void setScrubbedSite(Integer scrubbedSite) {
        this.scrubbedSite = scrubbedSite;
    }

    public CustomerSiteCount withScrubbedSite(Integer scrubbedSite) {
        this.scrubbedSite = scrubbedSite;
        return this;
    }

    /**
     * The total number of customer sites
     * 
     */
    @JsonProperty("totalSites")
    public Integer getTotalSites() {
        return totalSites;
    }

    /**
     * The total number of customer sites
     * 
     */
    @JsonProperty("totalSites")
    public void setTotalSites(Integer totalSites) {
        this.totalSites = totalSites;
    }

    public CustomerSiteCount withTotalSites(Integer totalSites) {
        this.totalSites = totalSites;
        return this;
    }

    /**
     * The total number of unscrubbed sites
     * 
     */
    @JsonProperty("unscrubbedSite")
    public Integer getUnscrubbedSite() {
        return unscrubbedSite;
    }

    /**
     * The total number of unscrubbed sites
     * 
     */
    @JsonProperty("unscrubbedSite")
    public void setUnscrubbedSite(Integer unscrubbedSite) {
        this.unscrubbedSite = unscrubbedSite;
    }

    public CustomerSiteCount withUnscrubbedSite(Integer unscrubbedSite) {
        this.unscrubbedSite = unscrubbedSite;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(scrubbedError).append(scrubbedSite).append(totalSites).append(unscrubbedSite).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerSiteCount) == false) {
            return false;
        }
        CustomerSiteCount rhs = ((CustomerSiteCount) other);
        return new EqualsBuilder().append(scrubbedError, rhs.scrubbedError).append(scrubbedSite, rhs.scrubbedSite).append(totalSites, rhs.totalSites).append(unscrubbedSite, rhs.unscrubbedSite).isEquals();
    }

}
