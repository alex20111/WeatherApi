
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class MoonPhase {

    @SerializedName("percentIlluminated")
    @Expose
    private String percentIlluminated;
    @SerializedName("ageOfMoon")
    @Expose
    private String ageOfMoon;
    @SerializedName("phaseofMoon")
    @Expose
    private String phaseofMoon;
    @SerializedName("hemisphere")
    @Expose
    private String hemisphere;
    @SerializedName("current_time")
    @Expose
    private CurrentTime currentTime;
    @SerializedName("sunrise")
    @Expose
    private Sunrise sunrise;
    @SerializedName("sunset")
    @Expose
    private Sunset sunset;

    /**
     * 
     * @return
     *     The percentIlluminated
     */
    public String getPercentIlluminated() {
        return percentIlluminated;
    }

    /**
     * 
     * @param percentIlluminated
     *     The percentIlluminated
     */
    public void setPercentIlluminated(String percentIlluminated) {
        this.percentIlluminated = percentIlluminated;
    }

    /**
     * 
     * @return
     *     The ageOfMoon
     */
    public String getAgeOfMoon() {
        return ageOfMoon;
    }

    /**
     * 
     * @param ageOfMoon
     *     The ageOfMoon
     */
    public void setAgeOfMoon(String ageOfMoon) {
        this.ageOfMoon = ageOfMoon;
    }

    /**
     * 
     * @return
     *     The phaseofMoon
     */
    public String getPhaseofMoon() {
        return phaseofMoon;
    }

    /**
     * 
     * @param phaseofMoon
     *     The phaseofMoon
     */
    public void setPhaseofMoon(String phaseofMoon) {
        this.phaseofMoon = phaseofMoon;
    }

    /**
     * 
     * @return
     *     The hemisphere
     */
    public String getHemisphere() {
        return hemisphere;
    }

    /**
     * 
     * @param hemisphere
     *     The hemisphere
     */
    public void setHemisphere(String hemisphere) {
        this.hemisphere = hemisphere;
    }

    /**
     * 
     * @return
     *     The currentTime
     */
    public CurrentTime getCurrentTime() {
        return currentTime;
    }

    /**
     * 
     * @param currentTime
     *     The current_time
     */
    public void setCurrentTime(CurrentTime currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * 
     * @return
     *     The sunrise
     */
    public Sunrise getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @param sunrise
     *     The sunrise
     */
    public void setSunrise(Sunrise sunrise) {
        this.sunrise = sunrise;
    }

    /**
     * 
     * @return
     *     The sunset
     */
    public Sunset getSunset() {
        return sunset;
    }

    /**
     * 
     * @param sunset
     *     The sunset
     */
    public void setSunset(Sunset sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(percentIlluminated).append(ageOfMoon).append(phaseofMoon).append(hemisphere).append(currentTime).append(sunrise).append(sunset).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MoonPhase) == false) {
            return false;
        }
        MoonPhase rhs = ((MoonPhase) other);
        return new EqualsBuilder().append(percentIlluminated, rhs.percentIlluminated).append(ageOfMoon, rhs.ageOfMoon).append(phaseofMoon, rhs.phaseofMoon).append(hemisphere, rhs.hemisphere).append(currentTime, rhs.currentTime).append(sunrise, rhs.sunrise).append(sunset, rhs.sunset).isEquals();
    }

}
