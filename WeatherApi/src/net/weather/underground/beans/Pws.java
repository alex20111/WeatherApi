
package net.weather.underground.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Pws {

    @SerializedName("station")
    @Expose
    private List<Station_> station = new ArrayList<Station_>();

    /**
     * 
     * @return
     *     The station
     */
    public List<Station_> getStation() {
        return station;
    }

    /**
     * 
     * @param station
     *     The station
     */
    public void setStation(List<Station_> station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(station).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Pws) == false) {
            return false;
        }
        Pws rhs = ((Pws) other);
        return new EqualsBuilder().append(station, rhs.station).isEquals();
    }

}
