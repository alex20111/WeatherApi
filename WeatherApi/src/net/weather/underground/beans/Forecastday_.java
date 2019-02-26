
package net.weather.underground.beans;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Forecastday_ {

    @SerializedName("date")
    @Expose
    private Date date;
    @SerializedName("period")
    @Expose
    private Integer period;
    @SerializedName("high")
    @Expose
    private High high;
    @SerializedName("low")
    @Expose
    private Low low;
    @SerializedName("conditions")
    @Expose
    private String conditions;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;
    @SerializedName("skyicon")
    @Expose
    private String skyicon;
    @SerializedName("pop")
    @Expose
    private Integer pop;
    @SerializedName("qpf_allday")
    @Expose
    private QpfAllday qpfAllday;
    @SerializedName("qpf_day")
    @Expose
    private QpfDay qpfDay;
    @SerializedName("qpf_night")
    @Expose
    private QpfNight qpfNight;
    @SerializedName("snow_allday")
    @Expose
    private SnowAllday snowAllday;
    @SerializedName("snow_day")
    @Expose
    private SnowDay snowDay;
    @SerializedName("snow_night")
    @Expose
    private SnowNight snowNight;
    @SerializedName("maxwind")
    @Expose
    private Maxwind maxwind;
    @SerializedName("avewind")
    @Expose
    private Avewind avewind;
    @SerializedName("avehumidity")
    @Expose
    private Integer avehumidity;
    @SerializedName("maxhumidity")
    @Expose
    private Integer maxhumidity;
    @SerializedName("minhumidity")
    @Expose
    private Integer minhumidity;

    /**
     * 
     * @return
     *     The date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 
     * @param period
     *     The period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 
     * @return
     *     The high
     */
    public High getHigh() {
        return high;
    }

    /**
     * 
     * @param high
     *     The high
     */
    public void setHigh(High high) {
        this.high = high;
    }

    /**
     * 
     * @return
     *     The low
     */
    public Low getLow() {
        return low;
    }

    /**
     * 
     * @param low
     *     The low
     */
    public void setLow(Low low) {
        this.low = low;
    }

    /**
     * 
     * @return
     *     The conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 
     * @param conditions
     *     The conditions
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * 
     * @return
     *     The icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon
     *     The icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 
     * @param iconUrl
     *     The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 
     * @return
     *     The skyicon
     */
    public String getSkyicon() {
        return skyicon;
    }

    /**
     * 
     * @param skyicon
     *     The skyicon
     */
    public void setSkyicon(String skyicon) {
        this.skyicon = skyicon;
    }

    /**
     * 
     * @return
     *     The pop
     */
    public Integer getPop() {
        return pop;
    }

    /**
     * 
     * @param pop
     *     The pop
     */
    public void setPop(Integer pop) {
        this.pop = pop;
    }

    /**
     * 
     * @return
     *     The qpfAllday
     */
    public QpfAllday getQpfAllday() {
        return qpfAllday;
    }

    /**
     * 
     * @param qpfAllday
     *     The qpf_allday
     */
    public void setQpfAllday(QpfAllday qpfAllday) {
        this.qpfAllday = qpfAllday;
    }

    /**
     * 
     * @return
     *     The qpfDay
     */
    public QpfDay getQpfDay() {
        return qpfDay;
    }

    /**
     * 
     * @param qpfDay
     *     The qpf_day
     */
    public void setQpfDay(QpfDay qpfDay) {
        this.qpfDay = qpfDay;
    }

    /**
     * 
     * @return
     *     The qpfNight
     */
    public QpfNight getQpfNight() {
        return qpfNight;
    }

    /**
     * 
     * @param qpfNight
     *     The qpf_night
     */
    public void setQpfNight(QpfNight qpfNight) {
        this.qpfNight = qpfNight;
    }

    /**
     * 
     * @return
     *     The snowAllday
     */
    public SnowAllday getSnowAllday() {
        return snowAllday;
    }

    /**
     * 
     * @param snowAllday
     *     The snow_allday
     */
    public void setSnowAllday(SnowAllday snowAllday) {
        this.snowAllday = snowAllday;
    }

    /**
     * 
     * @return
     *     The snowDay
     */
    public SnowDay getSnowDay() {
        return snowDay;
    }

    /**
     * 
     * @param snowDay
     *     The snow_day
     */
    public void setSnowDay(SnowDay snowDay) {
        this.snowDay = snowDay;
    }

    /**
     * 
     * @return
     *     The snowNight
     */
    public SnowNight getSnowNight() {
        return snowNight;
    }

    /**
     * 
     * @param snowNight
     *     The snow_night
     */
    public void setSnowNight(SnowNight snowNight) {
        this.snowNight = snowNight;
    }

    /**
     * 
     * @return
     *     The maxwind
     */
    public Maxwind getMaxwind() {
        return maxwind;
    }

    /**
     * 
     * @param maxwind
     *     The maxwind
     */
    public void setMaxwind(Maxwind maxwind) {
        this.maxwind = maxwind;
    }

    /**
     * 
     * @return
     *     The avewind
     */
    public Avewind getAvewind() {
        return avewind;
    }

    /**
     * 
     * @param avewind
     *     The avewind
     */
    public void setAvewind(Avewind avewind) {
        this.avewind = avewind;
    }

    /**
     * 
     * @return
     *     The avehumidity
     */
    public Integer getAvehumidity() {
        return avehumidity;
    }

    /**
     * 
     * @param avehumidity
     *     The avehumidity
     */
    public void setAvehumidity(Integer avehumidity) {
        this.avehumidity = avehumidity;
    }

    /**
     * 
     * @return
     *     The maxhumidity
     */
    public Integer getMaxhumidity() {
        return maxhumidity;
    }

    /**
     * 
     * @param maxhumidity
     *     The maxhumidity
     */
    public void setMaxhumidity(Integer maxhumidity) {
        this.maxhumidity = maxhumidity;
    }

    /**
     * 
     * @return
     *     The minhumidity
     */
    public Integer getMinhumidity() {
        return minhumidity;
    }

    /**
     * 
     * @param minhumidity
     *     The minhumidity
     */
    public void setMinhumidity(Integer minhumidity) {
        this.minhumidity = minhumidity;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(date).append(period).append(high).append(low).append(conditions).append(icon).append(iconUrl).append(skyicon).append(pop).append(qpfAllday).append(qpfDay).append(qpfNight).append(snowAllday).append(snowDay).append(snowNight).append(maxwind).append(avewind).append(avehumidity).append(maxhumidity).append(minhumidity).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Forecastday_) == false) {
            return false;
        }
        Forecastday_ rhs = ((Forecastday_) other);
        return new EqualsBuilder().append(date, rhs.date).append(period, rhs.period).append(high, rhs.high).append(low, rhs.low).append(conditions, rhs.conditions).append(icon, rhs.icon).append(iconUrl, rhs.iconUrl).append(skyicon, rhs.skyicon).append(pop, rhs.pop).append(qpfAllday, rhs.qpfAllday).append(qpfDay, rhs.qpfDay).append(qpfNight, rhs.qpfNight).append(snowAllday, rhs.snowAllday).append(snowDay, rhs.snowDay).append(snowNight, rhs.snowNight).append(maxwind, rhs.maxwind).append(avewind, rhs.avewind).append(avehumidity, rhs.avehumidity).append(maxhumidity, rhs.maxhumidity).append(minhumidity, rhs.minhumidity).isEquals();
    }

}
