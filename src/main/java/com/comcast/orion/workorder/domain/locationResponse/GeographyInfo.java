
package com.comcast.orion.workorder.domain.locationResponse;

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
    "censusBlock",
    "censusTract",
    "countyName",
    "fipsCode",
    "latitude",
    "longitude",
    "minorCivilDivision",
    "placeName",
    "urbanization",
    "vertexGeoCode"
})
public class GeographyInfo {

    @JsonProperty("censusBlock")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String censusBlock;
    @JsonProperty("censusTract")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String censusTract;
    @JsonProperty("countyName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String countyName;
    @JsonProperty("fipsCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String fipsCode;
    @JsonProperty("latitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String latitude;
    @JsonProperty("longitude")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String longitude;
    @JsonProperty("minorCivilDivision")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String minorCivilDivision;
    @JsonProperty("placeName")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String placeName;
    @JsonProperty("urbanization")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String urbanization;
    @JsonProperty("vertexGeoCode")
    @JsonPropertyDescription("")
    @ApiModelProperty(required = false, dataType = "string", position = 0, value = "", example = "")
    private String vertexGeoCode;

    @JsonProperty("censusBlock")
    public String getCensusBlock() {
        return censusBlock;
    }

    @JsonProperty("censusBlock")
    public void setCensusBlock(String censusBlock) {
        this.censusBlock = censusBlock;
    }

    public GeographyInfo withCensusBlock(String censusBlock) {
        this.censusBlock = censusBlock;
        return this;
    }

    @JsonProperty("censusTract")
    public String getCensusTract() {
        return censusTract;
    }

    @JsonProperty("censusTract")
    public void setCensusTract(String censusTract) {
        this.censusTract = censusTract;
    }

    public GeographyInfo withCensusTract(String censusTract) {
        this.censusTract = censusTract;
        return this;
    }

    @JsonProperty("countyName")
    public String getCountyName() {
        return countyName;
    }

    @JsonProperty("countyName")
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public GeographyInfo withCountyName(String countyName) {
        this.countyName = countyName;
        return this;
    }

    @JsonProperty("fipsCode")
    public String getFipsCode() {
        return fipsCode;
    }

    @JsonProperty("fipsCode")
    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }

    public GeographyInfo withFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
        return this;
    }

    @JsonProperty("latitude")
    public String getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public GeographyInfo withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    @JsonProperty("longitude")
    public String getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public GeographyInfo withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    @JsonProperty("minorCivilDivision")
    public String getMinorCivilDivision() {
        return minorCivilDivision;
    }

    @JsonProperty("minorCivilDivision")
    public void setMinorCivilDivision(String minorCivilDivision) {
        this.minorCivilDivision = minorCivilDivision;
    }

    public GeographyInfo withMinorCivilDivision(String minorCivilDivision) {
        this.minorCivilDivision = minorCivilDivision;
        return this;
    }

    @JsonProperty("placeName")
    public String getPlaceName() {
        return placeName;
    }

    @JsonProperty("placeName")
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public GeographyInfo withPlaceName(String placeName) {
        this.placeName = placeName;
        return this;
    }

    @JsonProperty("urbanization")
    public String getUrbanization() {
        return urbanization;
    }

    @JsonProperty("urbanization")
    public void setUrbanization(String urbanization) {
        this.urbanization = urbanization;
    }

    public GeographyInfo withUrbanization(String urbanization) {
        this.urbanization = urbanization;
        return this;
    }

    @JsonProperty("vertexGeoCode")
    public String getVertexGeoCode() {
        return vertexGeoCode;
    }

    @JsonProperty("vertexGeoCode")
    public void setVertexGeoCode(String vertexGeoCode) {
        this.vertexGeoCode = vertexGeoCode;
    }

    public GeographyInfo withVertexGeoCode(String vertexGeoCode) {
        this.vertexGeoCode = vertexGeoCode;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(censusBlock).append(censusTract).append(countyName).append(fipsCode).append(latitude).append(longitude).append(minorCivilDivision).append(placeName).append(urbanization).append(vertexGeoCode).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof GeographyInfo) == false) {
            return false;
        }
        GeographyInfo rhs = ((GeographyInfo) other);
        return new EqualsBuilder().append(censusBlock, rhs.censusBlock).append(censusTract, rhs.censusTract).append(countyName, rhs.countyName).append(fipsCode, rhs.fipsCode).append(latitude, rhs.latitude).append(longitude, rhs.longitude).append(minorCivilDivision, rhs.minorCivilDivision).append(placeName, rhs.placeName).append(urbanization, rhs.urbanization).append(vertexGeoCode, rhs.vertexGeoCode).isEquals();
    }

}
