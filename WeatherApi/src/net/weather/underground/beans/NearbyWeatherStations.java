
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class NearbyWeatherStations {

    @SerializedName("airport")
    @Expose
    private Airport airport;
    @SerializedName("pws")
    @Expose
    private Pws pws;

    /**
     * 
     * @return
     *     The airport
     */
    public Airport getAirport() {
        return airport;
    }

    /**
     * 
     * @param airport
     *     The airport
     */
    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    /**
     * 
     * @return
     *     The pws
     */
    public Pws getPws() {
        return pws;
    }

    /**
     * 
     * @param pws
     *     The pws
     */
    public void setPws(Pws pws) {
        this.pws = pws;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(airport).append(pws).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NearbyWeatherStations) == false) {
            return false;
        }
        NearbyWeatherStations rhs = ((NearbyWeatherStations) other);
        return new EqualsBuilder().append(airport, rhs.airport).append(pws, rhs.pws).isEquals();
    }

}
