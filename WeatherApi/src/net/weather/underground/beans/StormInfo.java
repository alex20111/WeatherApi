
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class StormInfo {

    @SerializedName("time_epoch")
    @Expose
    private Integer timeEpoch;
    @SerializedName("Motion_deg")
    @Expose
    private Integer MotionDeg;
    @SerializedName("Motion_spd")
    @Expose
    private Integer MotionSpd;
    @SerializedName("position_lat")
    @Expose
    private Double positionLat;
    @SerializedName("position_lon")
    @Expose
    private Double positionLon;

    /**
     * 
     * @return
     *     The timeEpoch
     */
    public Integer getTimeEpoch() {
        return timeEpoch;
    }

    /**
     * 
     * @param timeEpoch
     *     The time_epoch
     */
    public void setTimeEpoch(Integer timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    /**
     * 
     * @return
     *     The MotionDeg
     */
    public Integer getMotionDeg() {
        return MotionDeg;
    }

    /**
     * 
     * @param MotionDeg
     *     The Motion_deg
     */
    public void setMotionDeg(Integer MotionDeg) {
        this.MotionDeg = MotionDeg;
    }

    /**
     * 
     * @return
     *     The MotionSpd
     */
    public Integer getMotionSpd() {
        return MotionSpd;
    }

    /**
     * 
     * @param MotionSpd
     *     The Motion_spd
     */
    public void setMotionSpd(Integer MotionSpd) {
        this.MotionSpd = MotionSpd;
    }

    /**
     * 
     * @return
     *     The positionLat
     */
    public Double getPositionLat() {
        return positionLat;
    }

    /**
     * 
     * @param positionLat
     *     The position_lat
     */
    public void setPositionLat(Double positionLat) {
        this.positionLat = positionLat;
    }

    /**
     * 
     * @return
     *     The positionLon
     */
    public Double getPositionLon() {
        return positionLon;
    }

    /**
     * 
     * @param positionLon
     *     The position_lon
     */
    public void setPositionLon(Double positionLon) {
        this.positionLon = positionLon;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timeEpoch).append(MotionDeg).append(MotionSpd).append(positionLat).append(positionLon).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof StormInfo) == false) {
            return false;
        }
        StormInfo rhs = ((StormInfo) other);
        return new EqualsBuilder().append(timeEpoch, rhs.timeEpoch).append(MotionDeg, rhs.MotionDeg).append(MotionSpd, rhs.MotionSpd).append(positionLat, rhs.positionLat).append(positionLon, rhs.positionLon).isEquals();
    }

}
