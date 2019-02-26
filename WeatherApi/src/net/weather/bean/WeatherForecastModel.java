package net.weather.bean;

import java.util.Date;

public class WeatherForecastModel 
{
	private boolean day 	= false;
	private boolean night 	= false;	
	
	private String highTemp 	= "";
	private String lowTemp 		= "";
	private String forecast 	= "";
	private String probOfRain 	= "";
	private String dayOfWeek 	= "";
	private String dayNumberForWeek = "";
	private Short rain;
	private Float snow;
	private Short rainTotal;
	private Float snowTotal;
	private String month 		= "";	
	private String iconUrl		= "";
	private String iconName		= "";
	private Integer maxWind;
	private Integer avgWind;
	private String windDir 		= "";
	
	private String weatherOutlook = "";
	private String uvIndex		= "";
	
	private Date forcastIssued;
	
	/**
	 * @return the day
	 */
	public boolean isDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(boolean day) {
		this.day = day;
	}
	/**
	 * @return the night
	 */
	public boolean isNight() {
		return night;
	}
	/**
	 * @param night the night to set
	 */
	public void setNight(boolean night) {
		this.night = night;
	}
	/**
	 * @return the highTemp
	 */
	public String getHighTemp() {
		return highTemp;
	}
	/**
	 * @param highTemp the highTemp to set
	 */
	public void setHighTemp(String highTemp) {
		this.highTemp = highTemp;
	}
	/**
	 * @return the lowTemp
	 */
	public String getLowTemp() {
		return lowTemp;
	}
	/**
	 * @param lowTemp the lowTemp to set
	 */
	public void setLowTemp(String lowTemp) {
		this.lowTemp = lowTemp;
	}
		
	/**
	 * @return the dayOfWeek
	 */
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	/**
	 * @param dayOfWeek the dayOfWeek to set
	 */
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	/**
	 * @return the dayNumberOfWeek
	 */
	public String getDayNumberForWeek() {
		return dayNumberForWeek;
	}
	/**
	 * @param dayNumberOfWeek the dayNumberOfWeek to set
	 */
	public void setDayNumberForWeek(String dayNumberForWeek) {
		this.dayNumberForWeek = dayNumberForWeek;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the weatherOutlook
	 */
	public String getWeatherOutlook() {
		return weatherOutlook;
	}
	/**
	 * @param weatherOutlook the weatherOutlook to set
	 */
	public void setWeatherOutlook(String weatherOutlook) {
		this.weatherOutlook = weatherOutlook;
	}
	/**
	 * @return the uvIndex
	 */
	public String getUvIndex() {
		return uvIndex;
	}
	/**
	 * @param uvIndex the uvIndex to set
	 */
	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}
	public Date getForcastIssued() {
		return forcastIssued;
	}
	public void setForcastIssued(Date forcastIssued) {
		this.forcastIssued = forcastIssued;
	}
	/**
	 * @return the forecast
	 */
	public String getForecast() {
		return forecast;
	}
	/**
	 * @param forecast the forecast to set
	 */
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	/**
	 * @return the probOfRain
	 */
	public String getProbOfRain() {
		return probOfRain;
	}
	/**
	 * @param probOfRain the probOfRain to set
	 */
	public void setProbOfRain(String probOfRain) {
		this.probOfRain = probOfRain;
	}
	/**
	 * @return the rainFor
	 */
	public Short getRain() {
		return rain;
	}
	/**
	 * @param rainFor the rainFor to set
	 */
	public void setRain(Short rain) {
		this.rain = rain;
	}
	/**
	 * @return the snow
	 */
	public Float getSnow() {
		return snow;
	}
	/**
	 * @param snow the snow to set
	 */
	public void setSnow(Float snow) {
		this.snow = snow;
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
	 * @return the rainTotal
	 */
	public Short getRainTotal() {
		return rainTotal;
	}
	/**
	 * @param rainTotal the rainTotal to set
	 */
	public void setRainTotal(Short rainTotal) {
		this.rainTotal = rainTotal;
	}
	/**
	 * @return the snowTotal
	 */
	public Float getSnowTotal() {
		return snowTotal;
	}
	/**
	 * @param snowTotal the snowTotal to set
	 */
	public void setSnowTotal(Float snowTotal) {
		this.snowTotal = snowTotal;
	}
	/**
	 * @return the maxWind
	 */
	public Integer getMaxWind() {
		return maxWind;
	}
	/**
	 * @param maxWind the maxWind to set
	 */
	public void setMaxWind(Integer maxWind) {
		this.maxWind = maxWind;
	}
	/**
	 * @return the avgWind
	 */
	public Integer getAvgWind() {
		return avgWind;
	}
	/**
	 * @param avgWind the avgWind to set
	 */
	public void setAvgWind(Integer avgWind) {
		this.avgWind = avgWind;
	}
	/**
	 * @return the windDir
	 */
	public String getWindDir() {
		return windDir;
	}
	/**
	 * @param windDir the windDir to set
	 */
	public void setWindDir(String windDir) {
		this.windDir = windDir;
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
		
		if (this.dayOfWeek.length() > 0)
		{
			sb.append(this.dayOfWeek + " " + getDayNumberForWeek() + " \n" );
			
		}	
		if (isDay())
		{
			sb.append("Day Time\n");	
		}
		else if (isNight())
		{
			sb.append("Night Time\n");	
		}			
		sb.append("High : " + this.highTemp + "\n");
		sb.append("Low  : " + this.lowTemp + "\n");
		
		if (this.rain != null && this.rain.floatValue() > 0 )
		{
			sb.append("Total rain: " + this.rainTotal + "mm\n");
			if (isDay())
			{
				sb.append("Rain during the day : " + this.rain + "mm \n");
			}
			else
			{
				sb.append("Rain during the night: " + this.rain + "mm\n");
			}
		}
		if (this.snow != null && this.snow.floatValue() > 0 )
		{
			sb.append("Total Snow : " + this.snow + "cm\n");
			if (isDay())
			{
				sb.append("Snow during the day : " + this.snow + "cm\n");
			}
			else
			{
				sb.append("Snow during the night: " + this.snow + "cm\n");
			}
		}
		sb.append("Pop rain	: " + this.probOfRain + "\n");
		sb.append("Icon		: " + this.iconName + "\n");
		sb.append("IconUrl	: " + this.iconUrl + "\n");
		sb.append("Forecast	: " + this.forecast + "\n");
		sb.append("Month 	: " + this.month + "\n");
		sb.append("WeatherOutlook : " + this.weatherOutlook + "\n");
		sb.append("avg wind 	: " + this.avgWind + "\n");
		sb.append("max wind 	: " + this.maxWind + "\n");
		sb.append("uvIndex 	: " + this.uvIndex + "\n");
		sb.append("Win Dir 	: " + this.windDir + "\n");
		sb.append("snowTotal" + (this.snowTotal != null ? this.snowTotal : "0") + "\n");
		sb.append("forcastIssued : " + this.forcastIssued + "\n");
		sb.append("\n");
		
		return sb.toString();
	}
	
}
