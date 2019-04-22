
package net.weather.darksky;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("precipIntensity")
    @Expose
    private Double precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    private Double precipProbability;
    @SerializedName("precipIntensityError")
    @Expose
    private Double precipIntensityError;
    @SerializedName("precipType")
    @Expose
    private String precipType;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
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

    public Double getPrecipIntensityError() {
        return precipIntensityError;
    }

    public void setPrecipIntensityError(Double precipIntensityError) {
        this.precipIntensityError = precipIntensityError;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Datum.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("time");
        sb.append('=');
        sb.append(((this.time == null)?"<null>":this.time));
        sb.append(',');
        sb.append("precipIntensity");
        sb.append('=');
        sb.append(((this.precipIntensity == null)?"<null>":this.precipIntensity));
        sb.append(',');
        sb.append("precipProbability");
        sb.append('=');
        sb.append(((this.precipProbability == null)?"<null>":this.precipProbability));
        sb.append(',');
        sb.append("precipIntensityError");
        sb.append('=');
        sb.append(((this.precipIntensityError == null)?"<null>":this.precipIntensityError));
        sb.append(',');
        sb.append("precipType");
        sb.append('=');
        sb.append(((this.precipType == null)?"<null>":this.precipType));
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
        result = ((result* 31)+((this.precipType == null)? 0 :this.precipType.hashCode()));
        result = ((result* 31)+((this.precipProbability == null)? 0 :this.precipProbability.hashCode()));
        result = ((result* 31)+((this.time == null)? 0 :this.time.hashCode()));
        result = ((result* 31)+((this.precipIntensity == null)? 0 :this.precipIntensity.hashCode()));
        result = ((result* 31)+((this.precipIntensityError == null)? 0 :this.precipIntensityError.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Datum) == false) {
            return false;
        }
        Datum rhs = ((Datum) other);
        return ((((((this.precipType == rhs.precipType)||((this.precipType!= null)&&this.precipType.equals(rhs.precipType)))&&((this.precipProbability == rhs.precipProbability)||((this.precipProbability!= null)&&this.precipProbability.equals(rhs.precipProbability))))&&((this.time == rhs.time)||((this.time!= null)&&this.time.equals(rhs.time))))&&((this.precipIntensity == rhs.precipIntensity)||((this.precipIntensity!= null)&&this.precipIntensity.equals(rhs.precipIntensity))))&&((this.precipIntensityError == rhs.precipIntensityError)||((this.precipIntensityError!= null)&&this.precipIntensityError.equals(rhs.precipIntensityError))));
    }

}
