
package net.weather.darksky;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currently {

    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("nearestStormDistance")
    @Expose
    private Integer nearestStormDistance;
    @SerializedName("nearestStormBearing")
    @Expose
    private Integer nearestStormBearing;
    @SerializedName("precipIntensity")
    @Expose
    private Double precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    private Double precipProbability;
    @SerializedName("precipType")
    @Expose
    private String precipType;
    @SerializedName("temperature")
    @Expose
    private Double temperature;
    @SerializedName("apparentTemperature")
    @Expose
    private Double apparentTemperature;
    @SerializedName("dewPoint")
    @Expose
    private Double dewPoint;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("windSpeed")
    @Expose
    private Double windSpeed;
    @SerializedName("windGust")
    @Expose
    private Double windGust;
    @SerializedName("windBearing")
    @Expose
    private Integer windBearing;
    @SerializedName("cloudCover")
    @Expose
    private Double cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private Integer uvIndex;
    @SerializedName("visibility")
    @Expose
    private Double visibility;
    @SerializedName("ozone")
    @Expose
    private Double ozone;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(Integer nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }
    public Integer getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(Integer nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Integer getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Currently.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null)?"<null>":this.summary));
        sb.append(',');
        sb.append("icon");
        sb.append('=');
        sb.append(((this.icon == null)?"<null>":this.icon));
        sb.append(',');
        sb.append("nearestStormDistance");
        sb.append('=');
        sb.append(((this.nearestStormDistance == null)?"<null>":this.nearestStormDistance));
        sb.append(',');
        
        sb.append("nearestStormBearing");
        sb.append('=');
        sb.append(((this.nearestStormBearing == null)?"<null>":this.nearestStormBearing));
        sb.append(',');
        
        sb.append("precipIntensity");
        sb.append('=');
        sb.append(((this.precipIntensity == null)?"<null>":this.precipIntensity));
        sb.append(',');
        sb.append("precipProbability");
        sb.append('=');
        sb.append(((this.precipProbability == null)?"<null>":this.precipProbability));
        sb.append(',');
        sb.append("precipType");
        sb.append('=');
        sb.append(((this.precipType == null)?"<null>":this.precipType));
        sb.append(',');
        sb.append("temperature");
        sb.append('=');
        sb.append(((this.temperature == null)?"<null>":this.temperature));
        sb.append(',');
        sb.append("apparentTemperature");
        sb.append('=');
        sb.append(((this.apparentTemperature == null)?"<null>":this.apparentTemperature));
        sb.append(',');
        sb.append("dewPoint");
        sb.append('=');
        sb.append(((this.dewPoint == null)?"<null>":this.dewPoint));
        sb.append(',');
        sb.append("humidity");
        sb.append('=');
        sb.append(((this.humidity == null)?"<null>":this.humidity));
        sb.append(',');
        sb.append("pressure");
        sb.append('=');
        sb.append(((this.pressure == null)?"<null>":this.pressure));
        sb.append(',');
        sb.append("windSpeed");
        sb.append('=');
        sb.append(((this.windSpeed == null)?"<null>":this.windSpeed));
        sb.append(',');
        sb.append("windGust");
        sb.append('=');
        sb.append(((this.windGust == null)?"<null>":this.windGust));
        sb.append(',');
        sb.append("windBearing");
        sb.append('=');
        sb.append(((this.windBearing == null)?"<null>":this.windBearing));
        sb.append(',');
        sb.append("cloudCover");
        sb.append('=');
        sb.append(((this.cloudCover == null)?"<null>":this.cloudCover));
        sb.append(',');
        sb.append("uvIndex");
        sb.append('=');
        sb.append(((this.uvIndex == null)?"<null>":this.uvIndex));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("ozone");
        sb.append('=');
        sb.append(((this.ozone == null)?"<null>":this.ozone));
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
        result = ((result* 31)+((this.summary == null)? 0 :this.summary.hashCode()));
        result = ((result* 31)+((this.precipProbability == null)? 0 :this.precipProbability.hashCode()));
        result = ((result* 31)+((this.visibility == null)? 0 :this.visibility.hashCode()));
        result = ((result* 31)+((this.windGust == null)? 0 :this.windGust.hashCode()));
        result = ((result* 31)+((this.precipIntensity == null)? 0 :this.precipIntensity.hashCode()));
        result = ((result* 31)+((this.icon == null)? 0 :this.icon.hashCode()));
        result = ((result* 31)+((this.cloudCover == null)? 0 :this.cloudCover.hashCode()));
        result = ((result* 31)+((this.windBearing == null)? 0 :this.windBearing.hashCode()));
        result = ((result* 31)+((this.apparentTemperature == null)? 0 :this.apparentTemperature.hashCode()));
        result = ((result* 31)+((this.pressure == null)? 0 :this.pressure.hashCode()));
        result = ((result* 31)+((this.dewPoint == null)? 0 :this.dewPoint.hashCode()));
        result = ((result* 31)+((this.ozone == null)? 0 :this.ozone.hashCode()));
        result = ((result* 31)+((this.nearestStormDistance == null)? 0 :this.nearestStormDistance.hashCode()));
        result = ((result* 31)+((this.nearestStormBearing == null)? 0 :this.nearestStormBearing.hashCode()));
        result = ((result* 31)+((this.precipType == null)? 0 :this.precipType.hashCode()));
        result = ((result* 31)+((this.temperature == null)? 0 :this.temperature.hashCode()));
        result = ((result* 31)+((this.humidity == null)? 0 :this.humidity.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        result = ((result* 31)+((this.windSpeed == null)? 0 :this.windSpeed.hashCode()));
        result = ((result* 31)+((this.uvIndex == null)? 0 :this.uvIndex.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Currently) == false) {
            return false;
        }
        Currently rhs = ((Currently) other);
        return ((((((((((((((((((((this.summary == rhs.summary)||((this.summary!= null)&&this.summary.equals(rhs.summary)))&&((this.precipProbability == rhs.precipProbability)||((this.precipProbability!= null)&&this.precipProbability.equals(rhs.precipProbability))))&&((this.visibility == rhs.visibility)||((this.visibility!= null)&&this.visibility.equals(rhs.visibility))))&&((this.windGust == rhs.windGust)||((this.windGust!= null)&&this.windGust.equals(rhs.windGust))))&&((this.precipIntensity == rhs.precipIntensity)||((this.precipIntensity!= null)&&this.precipIntensity.equals(rhs.precipIntensity))))&&((this.icon == rhs.icon)||((this.icon!= null)&&this.icon.equals(rhs.icon))))&&((this.cloudCover == rhs.cloudCover)||((this.cloudCover!= null)&&this.cloudCover.equals(rhs.cloudCover))))&&((this.windBearing == rhs.windBearing)||((this.windBearing!= null)&&this.windBearing.equals(rhs.windBearing))))&&((this.apparentTemperature == rhs.apparentTemperature)||((this.apparentTemperature!= null)&&this.apparentTemperature.equals(rhs.apparentTemperature))))&&((this.pressure == rhs.pressure)||((this.pressure!= null)&&this.pressure.equals(rhs.pressure))))&&((this.dewPoint == rhs.dewPoint)||((this.dewPoint!= null)&&this.dewPoint.equals(rhs.dewPoint))))&&((this.ozone == rhs.ozone)||((this.ozone!= null)&&this.ozone.equals(rhs.ozone))))&&((this.nearestStormDistance == rhs.nearestStormDistance)||((this.nearestStormDistance!= null)&&this.nearestStormDistance.equals(rhs.nearestStormDistance))))&&((this.precipType == rhs.precipType)||((this.precipType!= null)&&this.precipType.equals(rhs.precipType))))&&((this.temperature == rhs.temperature)||((this.temperature!= null)&&this.temperature.equals(rhs.temperature))))&&((this.humidity == rhs.humidity)||((this.humidity!= null)&&this.humidity.equals(rhs.humidity))))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))))&&((this.windSpeed == rhs.windSpeed)||((this.windSpeed!= null)&&this.windSpeed.equals(rhs.windSpeed))))&&((this.uvIndex == rhs.uvIndex)||((this.uvIndex!= null)&&this.uvIndex.equals(rhs.uvIndex))));
    }

}
