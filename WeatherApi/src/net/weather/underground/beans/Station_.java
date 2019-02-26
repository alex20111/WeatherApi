
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Station_ {

    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("distance_km")
    @Expose
    private Integer distanceKm;
    @SerializedName("distance_mi")
    @Expose
    private Integer distanceMi;

    /**
     * 
     * @return
     *     The neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * 
     * @param neighborhood
     *     The neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * 
     * @return
     *     The city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * @return
     *     The distanceKm
     */
    public Integer getDistanceKm() {
        return distanceKm;
    }

    /**
     * 
     * @param distanceKm
     *     The distance_km
     */
    public void setDistanceKm(Integer distanceKm) {
        this.distanceKm = distanceKm;
    }

    /**
     * 
     * @return
     *     The distanceMi
     */
    public Integer getDistanceMi() {
        return distanceMi;
    }

    /**
     * 
     * @param distanceMi
     *     The distance_mi
     */
    public void setDistanceMi(Integer distanceMi) {
        this.distanceMi = distanceMi;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(neighborhood).append(city).append(state).append(country).append(id).append(lat).append(lon).append(distanceKm).append(distanceMi).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Station_) == false) {
            return false;
        }
        Station_ rhs = ((Station_) other);
        return new EqualsBuilder().append(neighborhood, rhs.neighborhood).append(city, rhs.city).append(state, rhs.state).append(country, rhs.country).append(id, rhs.id).append(lat, rhs.lat).append(lon, rhs.lon).append(distanceKm, rhs.distanceKm).append(distanceMi, rhs.distanceMi).isEquals();
    }

}
