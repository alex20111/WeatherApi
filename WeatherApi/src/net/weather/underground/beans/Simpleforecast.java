
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
public class Simpleforecast {

    @SerializedName("forecastday")
    @Expose
    private List<Forecastday_> forecastday = new ArrayList<Forecastday_>();

    /**
     * 
     * @return
     *     The forecastday
     */
    public List<Forecastday_> getForecastday() {
        return forecastday;
    }

    /**
     * 
     * @param forecastday
     *     The forecastday
     */
    public void setForecastday(List<Forecastday_> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(forecastday).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Simpleforecast) == false) {
            return false;
        }
        Simpleforecast rhs = ((Simpleforecast) other);
        return new EqualsBuilder().append(forecastday, rhs.forecastday).isEquals();
    }

}
