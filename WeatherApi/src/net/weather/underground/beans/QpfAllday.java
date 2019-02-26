
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class QpfAllday {

    @SerializedName("in")
    @Expose
    private Double in;
    @SerializedName("mm")
    @Expose
    private Integer mm;

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
     *     The mm
     */
    public Integer getMm() {
        return mm;
    }

    /**
     * 
     * @param mm
     *     The mm
     */
    public void setMm(Integer mm) {
        this.mm = mm;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(in).append(mm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof QpfAllday) == false) {
            return false;
        }
        QpfAllday rhs = ((QpfAllday) other);
        return new EqualsBuilder().append(in, rhs.in).append(mm, rhs.mm).isEquals();
    }

}
