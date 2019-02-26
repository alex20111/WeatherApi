
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Maxwind {

    @SerializedName("mph")
    @Expose
    private Integer mph;
    @SerializedName("kph")
    @Expose
    private Integer kph;
    @SerializedName("dir")
    @Expose
    private String dir;
    @SerializedName("degrees")
    @Expose
    private Integer degrees;

    /**
     * 
     * @return
     *     The mph
     */
    public Integer getMph() {
        return mph;
    }

    /**
     * 
     * @param mph
     *     The mph
     */
    public void setMph(Integer mph) {
        this.mph = mph;
    }

    /**
     * 
     * @return
     *     The kph
     */
    public Integer getKph() {
        return kph;
    }

    /**
     * 
     * @param kph
     *     The kph
     */
    public void setKph(Integer kph) {
        this.kph = kph;
    }

    /**
     * 
     * @return
     *     The dir
     */
    public String getDir() {
        return dir;
    }

    /**
     * 
     * @param dir
     *     The dir
     */
    public void setDir(String dir) {
        this.dir = dir;
    }

    /**
     * 
     * @return
     *     The degrees
     */
    public Integer getDegrees() {
        return degrees;
    }

    /**
     * 
     * @param degrees
     *     The degrees
     */
    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mph).append(kph).append(dir).append(degrees).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Maxwind) == false) {
            return false;
        }
        Maxwind rhs = ((Maxwind) other);
        return new EqualsBuilder().append(mph, rhs.mph).append(kph, rhs.kph).append(dir, rhs.dir).append(degrees, rhs.degrees).isEquals();
    }

}
