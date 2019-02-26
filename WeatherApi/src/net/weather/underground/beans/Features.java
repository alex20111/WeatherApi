
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Features {

    @SerializedName("forecast10day")
    @Expose
    private Integer forecast10day;
    @SerializedName("alerts")
    @Expose
    private Integer alerts;
    @SerializedName("conditions")
    @Expose
    private Integer conditions;
    @SerializedName("astronomy")
    @Expose
    private Integer astronomy;
    @SerializedName("geolookup")
    @Expose
    private Integer geolookup;

    /**
     * 
     * @return
     *     The forecast10day
     */
    public Integer getForecast10day() {
        return forecast10day;
    }

    /**
     * 
     * @param forecast10day
     *     The forecast10day
     */
    public void setForecast10day(Integer forecast10day) {
        this.forecast10day = forecast10day;
    }

    /**
     * 
     * @return
     *     The alerts
     */
    public Integer getAlerts() {
        return alerts;
    }

    /**
     * 
     * @param alerts
     *     The alerts
     */
    public void setAlerts(Integer alerts) {
        this.alerts = alerts;
    }

    /**
     * 
     * @return
     *     The conditions
     */
    public Integer getConditions() {
        return conditions;
    }

    /**
     * 
     * @param conditions
     *     The conditions
     */
    public void setConditions(Integer conditions) {
        this.conditions = conditions;
    }

    /**
     * 
     * @return
     *     The astronomy
     */
    public Integer getAstronomy() {
        return astronomy;
    }

    /**
     * 
     * @param astronomy
     *     The astronomy
     */
    public void setAstronomy(Integer astronomy) {
        this.astronomy = astronomy;
    }

    public Integer getGeolookup() {
		return geolookup;
	}

	public void setGeolookup(Integer geolookup) {
		this.geolookup = geolookup;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(forecast10day).append(alerts).append(conditions).append(astronomy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Features) == false) {
            return false;
        }
        Features rhs = ((Features) other);
        return new EqualsBuilder().append(forecast10day, rhs.forecast10day).append(alerts, rhs.alerts).append(conditions, rhs.conditions).append(astronomy, rhs.astronomy).isEquals();
    }

}
