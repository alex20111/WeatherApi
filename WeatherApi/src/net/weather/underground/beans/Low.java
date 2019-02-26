
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Low {

    @SerializedName("fahrenheit")
    @Expose
    private String fahrenheit;
    @SerializedName("celsius")
    @Expose
    private String celsius;

    /**
     * 
     * @return
     *     The fahrenheit
     */
    public String getFahrenheit() {
        return fahrenheit;
    }

    /**
     * 
     * @param fahrenheit
     *     The fahrenheit
     */
    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    /**
     * 
     * @return
     *     The celsius
     */
    public String getCelsius() {
        return celsius;
    }

    /**
     * 
     * @param celsius
     *     The celsius
     */
    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fahrenheit).append(celsius).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Low) == false) {
            return false;
        }
        Low rhs = ((Low) other);
        return new EqualsBuilder().append(fahrenheit, rhs.fahrenheit).append(celsius, rhs.celsius).isEquals();
    }

}
