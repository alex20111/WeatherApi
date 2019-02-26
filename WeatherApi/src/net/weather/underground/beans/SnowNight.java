
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class SnowNight {

    @SerializedName("in")
    @Expose
    private Double in;
    @SerializedName("cm")
    @Expose
    private Double cm;

    /**
     * 
     * @return
     *     The in
     */
    public Double getIn() {
        return in;
    }

    /**
     * 
     * @param in
     *     The in
     */
    public void setIn(Double in) {
        this.in = in;
    }

    /**
     * 
     * @return
     *     The cm
     */
    public Double getCm() {
        return cm;
    }

    /**
     * 
     * @param cm
     *     The cm
     */
    public void setCm(Double cm) {
        this.cm = cm;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(in).append(cm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SnowNight) == false) {
            return false;
        }
        SnowNight rhs = ((SnowNight) other);
        return new EqualsBuilder().append(in, rhs.in).append(cm, rhs.cm).isEquals();
    }

}
