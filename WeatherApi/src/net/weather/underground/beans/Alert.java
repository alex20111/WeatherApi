
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
public class Alert {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_epoch")
    @Expose
    private String dateEpoch;
    @SerializedName("expires")
    @Expose
    private String expires;
    @SerializedName("expires_epoch")
    @Expose
    private String expiresEpoch;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("phenomena")
    @Expose
    private String phenomena;
    @SerializedName("significance")
    @Expose
    private String significance;
    @SerializedName("ZONES")
    @Expose
    private List<ZONE> ZONES = new ArrayList<ZONE>();
    @SerializedName("StormBased")
    @Expose
    private StormBased StormBased;

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The dateEpoch
     */
    public String getDateEpoch() {
        return dateEpoch;
    }

    /**
     * 
     * @param dateEpoch
     *     The date_epoch
     */
    public void setDateEpoch(String dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    /**
     * 
     * @return
     *     The expires
     */
    public String getExpires() {
        return expires;
    }

    /**
     * 
     * @param expires
     *     The expires
     */
    public void setExpires(String expires) {
        this.expires = expires;
    }

    /**
     * 
     * @return
     *     The expiresEpoch
     */
    public String getExpiresEpoch() {
        return expiresEpoch;
    }

    /**
     * 
     * @param expiresEpoch
     *     The expires_epoch
     */
    public void setExpiresEpoch(String expiresEpoch) {
        this.expiresEpoch = expiresEpoch;
    }

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The phenomena
     */
    public String getPhenomena() {
        return phenomena;
    }

    /**
     * 
     * @param phenomena
     *     The phenomena
     */
    public void setPhenomena(String phenomena) {
        this.phenomena = phenomena;
    }

    /**
     * 
     * @return
     *     The significance
     */
    public String getSignificance() {
        return significance;
    }

    /**
     * 
     * @param significance
     *     The significance
     */
    public void setSignificance(String significance) {
        this.significance = significance;
    }

    /**
     * 
     * @return
     *     The ZONES
     */
    public List<ZONE> getZONES() {
        return ZONES;
    }

    /**
     * 
     * @param ZONES
     *     The ZONES
     */
    public void setZONES(List<ZONE> ZONES) {
        this.ZONES = ZONES;
    }

    /**
     * 
     * @return
     *     The StormBased
     */
    public net.weather.underground.beans.StormBased getStormBased() {
        return StormBased;
    }

    /**
     * 
     * @param StormBased
     *     The StormBased
     */
    public void setStormBased(net.weather.underground.beans.StormBased StormBased) {
        this.StormBased = StormBased;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(type).append(description).append(date).append(dateEpoch).append(expires).append(expiresEpoch).append(message).append(phenomena).append(significance).append(ZONES).append(StormBased).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Alert) == false) {
            return false;
        }
        Alert rhs = ((Alert) other);
        return new EqualsBuilder().append(type, rhs.type).append(description, rhs.description).append(date, rhs.date).append(dateEpoch, rhs.dateEpoch).append(expires, rhs.expires).append(expiresEpoch, rhs.expiresEpoch).append(message, rhs.message).append(phenomena, rhs.phenomena).append(significance, rhs.significance).append(ZONES, rhs.ZONES).append(StormBased, rhs.StormBased).isEquals();
    }

}
