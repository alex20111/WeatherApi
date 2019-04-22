
package net.weather.darksky;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags {

    @SerializedName("sources")
    @Expose
    private List<String> sources = new ArrayList<String>();
    @SerializedName("nearest-station")
    @Expose
    private Double nearestStation;
    @SerializedName("darksky-unavailable")
    @Expose
    private String darkskyUnavailable;
    @SerializedName("units")
    @Expose
    private String units;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public Double getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(Double nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getDarkskyUnavailable() {
        return darkskyUnavailable;
    }

    public void setDarkskyUnavailable(String darkskyUnavailable) {
        this.darkskyUnavailable = darkskyUnavailable;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Flags.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sources");
        sb.append('=');
        sb.append(((this.sources == null)?"<null>":this.sources));
        sb.append(',');
        sb.append("nearestStation");
        sb.append('=');
        sb.append(((this.nearestStation == null)?"<null>":this.nearestStation));
        sb.append(',');
        sb.append("darkskyUnavailable");
        sb.append('=');
        sb.append(((this.darkskyUnavailable == null)?"<null>":this.darkskyUnavailable));
        sb.append(',');
        sb.append("units");
        sb.append('=');
        sb.append(((this.units == null)?"<null>":this.units));
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
        result = ((result* 31)+((this.darkskyUnavailable == null)? 0 :this.darkskyUnavailable.hashCode()));
        result = ((result* 31)+((this.units == null)? 0 :this.units.hashCode()));
        result = ((result* 31)+((this.sources == null)? 0 :this.sources.hashCode()));
        result = ((result* 31)+((this.nearestStation == null)? 0 :this.nearestStation.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flags) == false) {
            return false;
        }
        Flags rhs = ((Flags) other);
        return (((((this.darkskyUnavailable == rhs.darkskyUnavailable)||((this.darkskyUnavailable!= null)&&this.darkskyUnavailable.equals(rhs.darkskyUnavailable)))&&((this.units == rhs.units)||((this.units!= null)&&this.units.equals(rhs.units))))&&((this.sources == rhs.sources)||((this.sources!= null)&&this.sources.equals(rhs.sources))))&&((this.nearestStation == rhs.nearestStation)||((this.nearestStation!= null)&&this.nearestStation.equals(rhs.nearestStation))));
    }

}
