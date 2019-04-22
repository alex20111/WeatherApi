package net.weather.bean;

public class WeatherCurrentModel
{	

	private String observationTime 	= "";
	private String summary 			= "";
	private float  currTemp 		= 0;
	private String humidity			= "";
	private String windDirectionText = "";
	private String windGusting 		= "";
	private String windSpeed		= "";
	private String feelsLike 		= ""; //heat index
	private String precipIntensity	= "";
	private String precipProbability	= "";
	private String iconUrl			= "";
	private String iconName			= "";
	private String visibility 		= "";
	private String pressureMb 		= "";
	private String dewPointC 		= "";
	private String windChill 		= "";
	private String moonRise 		= "";
	private String moonSet 			= "";
	private String sunRise 			= "";
	private String sunSet 			= "";
	private String uvIndex 			= "";
	private String nearestStormDistance = "";
	private String nearestStormBearing = "";
	/**
	 * @return the observationTime
	 */
	public String getObservationTime() {
		return observationTime;
	}

	public float getCurrTemp() {
		return currTemp;
	}

	public void setCurrTemp(float currTemp) {
		this.currTemp = currTemp;
	}

	public void setObservationTime(String observationTime) {
		this.observationTime = observationTime;
	}
	/**
	 * @return the weather
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param weather the weather to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the humidity
	 */
	public String getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the windDirectionText
	 */
	public String getWindDirectionText() {
		return windDirectionText;
	}
	/**
	 * @param windDirectionText the windDirectionText to set
	 */
	public void setWindDirectionText(String windDirectionText) {
		this.windDirectionText = windDirectionText;
	}
	/**
	 * @return the feelsLike
	 */
	public String getFeelsLike() {
		return feelsLike;
	}
	/**
	 * @param feelsLike the feelsLike to set
	 */
	public void setFeelsLike(String feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getPrecipIntensity() {
		return precipIntensity;
	}

	public void setPrecipIntensity(String precipIntensity) {
		this.precipIntensity = precipIntensity;
	}

	public String getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(String precipProbability) {
		this.precipProbability = precipProbability;
	}

	/**
	 * @return the windGusting
	 */
	public String getWindGusting() {
		return windGusting;
	}
	/**
	 * @param windGusting the windGusting to set
	 */
	public void setWindGusting(String windGusting) {
		this.windGusting = windGusting;
	}

	/**
	 * @return the icon
	 */
	public String getIconName() {
		return iconName;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	/**
	 * @return the visibility
	 */
	public String getVisibility() {
		return visibility;
	}
	/**
	 * @param visibility the visibility to set
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	/**
	 * @return the pressure
	 */
	public String getPressureMb() {
		return pressureMb;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressureMb(String pressureMb) {
		this.pressureMb = pressureMb;
	}
	/**
	 * @return the dewPointC
	 */
	public String getDewPointC() {
		return dewPointC;
	}
	public String getNearestStormDistance() {
		return nearestStormDistance;
	}

	public void setNearestStormDistance(String nearestStormDistance) {
		this.nearestStormDistance = nearestStormDistance;
	}

	public String getNearestStormBearing() {
		return nearestStormBearing;
	}

	public void setNearestStormBearing(String nearestStormBearing) {
		this.nearestStormBearing = nearestStormBearing;
	}

	/**
	 * @param dewPointC the dewPointC to set
	 */
	public void setDewPointC(String dewPointC) {
		this.dewPointC = dewPointC;
	}
	/**
	 * @return the windChill
	 */
	public String getWindChill() {
		return windChill;
	}
	/**
	 * @param windChill the windChill to set
	 */
	public void setWindChill(String windChill) {
		this.windChill = windChill;
	}
	/**
	 * @return the moonRise
	 */
	public String getMoonRise() {
		return moonRise;
	}
	/**
	 * @param moonRise the moonRise to set
	 */
	public void setMoonRise(String moonRise) {
		this.moonRise = moonRise;
	}
	/**
	 * @return the moonSet
	 */
	public String getMoonSet() {
		return moonSet;
	}
	/**
	 * @param moonSet the moonSet to set
	 */
	public void setMoonSet(String moonSet) {
		this.moonSet = moonSet;
	}
	/**
	 * @return the sunRise
	 */
	public String getSunRise() {
		return sunRise;
	}
	/**
	 * @param sunRise the sunRise to set
	 */
	public void setSunRise(String sunRise) {
		this.sunRise = sunRise;
	}
	/**
	 * @return the sunSet
	 */
	public String getSunSet() {
		return sunSet;
	}
	/**
	 * @param sunSet the sunSet to set
	 */
	public void setSunSet(String sunSet) {
		this.sunSet = sunSet;
	}
	public String getUvIndex() {
		return uvIndex;
	}

	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.observationTime + "\n");
		sb.append("Weather    : " + this.summary + "\n");
		sb.append("Temperature: " + this.currTemp + "\n");
		sb.append("humidity   : " + this.humidity + "\n");
		sb.append("Wind Direction: " + this.windDirectionText + "\n");
		sb.append("Wind Gusting: " + this.windGusting + "\n");
		sb.append("Wind speed: " + this.windSpeed + "\n");
		sb.append("Pressure  : " + this.pressureMb + "\n");
		sb.append("Visibility: " + this.visibility + "\n");
		sb.append("Dew Point : " + this.dewPointC + "\n");
		sb.append("Wind Chill: " + this.windChill + "\n");
		sb.append("precipIntensity: " + this.precipIntensity + "\n");
		sb.append("precipProbability: " + this.precipProbability + "\n");
		sb.append("icon    : " + this.iconName + "\n");
		sb.append("iconHttp    : " + this.iconUrl + "\n");
		sb.append("moonRise: " + this.moonRise + "\n");
		sb.append("moonSet : " + this.moonSet + "\n");
		sb.append("sunRise : " + this.sunRise + "\n");
		sb.append("sunSet  : " + this.sunSet + "\n");
		sb.append("feelsLike   : " + this.feelsLike + "\n");
		sb.append("uvIndex   : " + this.uvIndex + "\n");
		sb.append("nearestStormBearing   : " + this.nearestStormBearing + "\n");
		sb.append("nearestStormDistance   : " + this.nearestStormDistance + "\n");
	
		return sb.toString();
	}
	
}
