
package net.weather.underground.mains;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.weather.underground.beans.Alert;
import net.weather.underground.beans.CurrentObservation;
import net.weather.underground.beans.Forecast;
import net.weather.underground.beans.MoonPhase;
import net.weather.underground.beans.Response;
import net.weather.underground.beans.SunPhase;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class CompleteForecast {

    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;
    @SerializedName("forecast")
    @Expose
    private Forecast forecast;
    @SerializedName("moon_phase")
    @Expose
    private MoonPhase moonPhase;
    @SerializedName("sun_phase")
    @Expose
    private SunPhase sunPhase;
    @SerializedName("query_zone")
    @Expose
    private String queryZone;
    @SerializedName("alerts")
    @Expose
    private List<Alert> alerts = new ArrayList<Alert>();

    /**
     * 
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     * 
     * @return
     *     The currentObservation
     */
    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    /**
     * 
     * @param currentObservation
     *     The current_observation
     */
    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    /**
     * 
     * @return
     *     The forecast
     */
    public Forecast getForecast() {
        return forecast;
    }

    /**
     * 
     * @param forecast
     *     The forecast
     */
    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    /**
     * 
     * @return
     *     The moonPhase
     */
    public MoonPhase getMoonPhase() {
        return moonPhase;
    }

    /**
     * 
     * @param moonPhase
     *     The moon_phase
     */
    public void setMoonPhase(MoonPhase moonPhase) {
        this.moonPhase = moonPhase;
    }

    /**
     * 
     * @return
     *     The sunPhase
     */
    public SunPhase getSunPhase() {
        return sunPhase;
    }

    /**
     * 
     * @param sunPhase
     *     The sun_phase
     */
    public void setSunPhase(SunPhase sunPhase) {
        this.sunPhase = sunPhase;
    }

    /**
     * 
     * @return
     *     The queryZone
     */
    public String getQueryZone() {
        return queryZone;
    }

    /**
     * 
     * @param queryZone
     *     The query_zone
     */
    public void setQueryZone(String queryZone) {
        this.queryZone = queryZone;
    }

    /**
     * 
     * @return
     *     The alerts
     */
    public List<Alert> getAlerts() {
        return alerts;
    }

    /**
     * 
     * @param alerts
     *     The alerts
     */
    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(response).append(currentObservation).append(forecast).append(moonPhase).append(sunPhase).append(queryZone).append(alerts).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CompleteForecast) == false) {
            return false;
        }
        CompleteForecast rhs = ((CompleteForecast) other);
        return new EqualsBuilder().append(response, rhs.response).append(currentObservation, rhs.currentObservation).append(forecast, rhs.forecast).append(moonPhase, rhs.moonPhase).append(sunPhase, rhs.sunPhase).append(queryZone, rhs.queryZone).append(alerts, rhs.alerts).isEquals();
    }

}
