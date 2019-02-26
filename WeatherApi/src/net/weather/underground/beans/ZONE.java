
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class ZONE {

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("ZONE")
    @Expose
    private String ZONE;

    /**
     * 
     * @return
     *     The state
     */
    public String getState() {
        return state;
    }

    /**
     * 
     * @param state
     *     The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 
     * @return
     *     The ZONE
     */
    public String getZONE() {
        return ZONE;
    }

    /**
     * 
     * @param ZONE
     *     The ZONE
     */
    public void setZONE(String ZONE) {
        this.ZONE = ZONE;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(state).append(ZONE).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ZONE) == false) {
            return false;
        }
        ZONE rhs = ((ZONE) other);
        return new EqualsBuilder().append(state, rhs.state).append(ZONE, rhs.ZONE).isEquals();
    }

}
