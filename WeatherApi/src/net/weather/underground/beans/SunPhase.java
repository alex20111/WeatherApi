
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class SunPhase {

    @SerializedName("sunrise")
    @Expose
    private Sunrise_ sunrise;
    @SerializedName("sunset")
    @Expose
    private Sunset_ sunset;

    /**
     * 
     * @return
     *     The sunrise
     */
    public Sunrise_ getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @param sunrise
     *     The sunrise
     */
    public void setSunrise(Sunrise_ sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * 
     * @return
     *     The sunset
     */
    public Sunset_ getSunset() {
        return sunset;
    }

    /**
     * 
     * @param sunset
     *     The sunset
     */
    public void setSunset(Sunset_ sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sunrise).append(sunset).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SunPhase) == false) {
            return false;
        }
        SunPhase rhs = ((SunPhase) other);
        return new EqualsBuilder().append(sunrise, rhs.sunrise).append(sunset, rhs.sunset).isEquals();
    }

}
