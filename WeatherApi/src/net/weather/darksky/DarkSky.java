
package net.weather.darksky;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DarkSky {

    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("currently")
    @Expose
    private Currently currently;
    @SerializedName("minutely")
    @Expose
    private Minutely minutely;
    @SerializedName("hourly")
    @Expose
    private Hourly hourly;
    @SerializedName("daily")
    @Expose
    private Daily daily;
    @SerializedName("alerts")
    @Expose
    private List<Alert> alerts = new ArrayList<Alert>();
    @SerializedName("flags")
    @Expose
    private Flags flags;
    @SerializedName("offset")
    @Expose
    private Integer offset;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DarkSky.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("latitude");
        sb.append('=');
        sb.append(((this.latitude == null)?"<null>":this.latitude));
        sb.append(',');
        sb.append("longitude");
        sb.append('=');
        sb.append(((this.longitude == null)?"<null>":this.longitude));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null)?"<null>":this.timezone));
        sb.append(',');
        sb.append("currently");
        sb.append('=');
        sb.append(((this.currently == null)?"<null>":this.currently));
        sb.append(',');
        sb.append("minutely");
        sb.append('=');
        sb.append(((this.minutely == null)?"<null>":this.minutely));
        sb.append(',');
        sb.append("hourly");
        sb.append('=');
        sb.append(((this.hourly == null)?"<null>":this.hourly));
        sb.append(',');
        sb.append("daily");
        sb.append('=');
        sb.append(((this.daily == null)?"<null>":this.daily));
        sb.append(',');
        sb.append("alerts");
        sb.append('=');
        sb.append(((this.alerts == null)?"<null>":this.alerts));
        sb.append(',');
        sb.append("flags");
        sb.append('=');
        sb.append(((this.flags == null)?"<null>":this.flags));
        sb.append(',');
        sb.append("offset");
        sb.append('=');
        sb.append(((this.offset == null)?"<null>":this.offset));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.alerts == null)? 0 :this.alerts.hashCode()));
        result = ((result* 31)+((this.currently == null)? 0 :this.currently.hashCode()));
        result = ((result* 31)+((this.offset == null)? 0 :this.offset.hashCode()));
        result = ((result* 31)+((this.timezone == null)? 0 :this.timezone.hashCode()));
        result = ((result* 31)+((this.latitude == null)? 0 :this.latitude.hashCode()));
        result = ((result* 31)+((this.daily == null)? 0 :this.daily.hashCode()));
        result = ((result* 31)+((this.flags == null)? 0 :this.flags.hashCode()));
        result = ((result* 31)+((this.hourly == null)? 0 :this.hourly.hashCode()));
        result = ((result* 31)+((this.minutely == null)? 0 :this.minutely.hashCode()));
        result = ((result* 31)+((this.longitude == null)? 0 :this.longitude.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DarkSky) == false) {
            return false;
        }
        DarkSky rhs = ((DarkSky) other);
        return ((((((((((this.currently == rhs.currently)||((this.currently!= null)&&this.currently.equals(rhs.currently)))&&((this.offset == rhs.offset)||((this.offset!= null)&&this.offset.equals(rhs.offset))))&&((this.timezone == rhs.timezone)||((this.timezone!= null)&&this.timezone.equals(rhs.timezone))))&&((this.latitude == rhs.latitude)||((this.latitude!= null)&&this.latitude.equals(rhs.latitude))))&&((this.daily == rhs.daily)||((this.daily!= null)&&this.daily.equals(rhs.daily))))&&((this.flags == rhs.flags)||((this.flags!= null)&&this.flags.equals(rhs.flags))))&&((this.hourly == rhs.hourly)||((this.hourly!= null)&&this.hourly.equals(rhs.hourly))))&&((this.minutely == rhs.minutely)||((this.minutely!= null)&&this.minutely.equals(rhs.minutely))))&&((this.longitude == rhs.longitude)||((this.longitude!= null)&&this.longitude.equals(rhs.longitude))));
    }

}
