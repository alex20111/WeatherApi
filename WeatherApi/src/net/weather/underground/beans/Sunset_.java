
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Sunset_ {

    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("minute")
    @Expose
    private String minute;

    /**
     * 
     * @return
     *     The hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * 
     * @param hour
     *     The hour
     */
    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * 
     * @return
     *     The minute
     */
    public String getMinute() {
        return minute;
    }

    /**
     * 
     * @param minute
     *     The minute
     */
    public void setMinute(String minute) {
        this.minute = minute;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(hour).append(minute).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Sunset_) == false) {
            return false;
        }
        Sunset_ rhs = ((Sunset_) other);
        return new EqualsBuilder().append(hour, rhs.hour).append(minute, rhs.minute).isEquals();
    }

}
