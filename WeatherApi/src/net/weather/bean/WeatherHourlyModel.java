package net.weather.bean;

import java.util.Date;

public class WeatherHourlyModel 
{
	//probability of rain or snow in % for env canada
	public static final String popNil = "0%";
	public static final String popLow = "40%";
	public static final String popMed = "60% or 70%";
	public static final String popHigh = "> 70% ";
	
	private Date date;
	private String abbrDate		= "";
	private String temp 		= "";
	private String weatherCond 	= "";
	private String pop 			= "";
	private String wind 		= "";
	private String humidex		= "";
	private String windChill 	= "";
	private String uvIndex 		= "";
	private String humidity		= "";
	
	private String icon			= "";
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the tempC
	 */
	public String getTemp() {
		return temp;
	}
	/**
	 * @param tempC the tempC to set
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}
	/**
	 * @return the weatherCond
	 */
	public String getWeatherCond() {
		return weatherCond;
	}
	/**
	 * @param weatherCond the weatherCond to set
	 */
	public void setWeatherCond(String weatherCond) {
		this.weatherCond = weatherCond;
	}
	/**
	 * @return the pop
	 */
	public String getPop() {
		return pop;
	}
	/**
	 * @param pop the pop to set
	 */
	public void setPop(String pop) {
		this.pop = pop;
	}
	/**
	 * @return the wind
	 */
	public String getWind() {
		return wind;
	}
	/**
	 * @param wind the wind to set
	 */
	public void setWind(String wind) {
		this.wind = wind;
	}
	/**
	 * @return the humidex
	 */
	public String getHumidex() {
		return humidex;
	}
	/**
	 * @param humidex the humidex to set
	 */
	public void setHumidex(String humidex) {
		this.humidex = humidex;
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
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the abbrDate
	 */
	public String getAbbrDate() {
		return abbrDate;
	}
	/**
	 * @param abbrDate the abbrDate to set
	 */
	public void setAbbrDate(String abbrDate) {
		this.abbrDate = abbrDate;
	}
	public String getUvIndex() {
		return uvIndex;
	}
	public void setUvIndex(String uvIndex) {
		this.uvIndex = uvIndex;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	@Override
	public String toString() 
	{			
		StringBuilder sb = new StringBuilder();
		sb.append("Date						  	: " + this.date + "\n");
		sb.append("abbrDate						: " + this.abbrDate + "\n");
		sb.append("tempC					  	: " + this.temp + "\n");
		sb.append("Weather condition		  	: " + this.weatherCond + "\n");
		sb.append("Probability of precipitation: " + this.pop + "\n");
		sb.append("wind						  	: " + this.wind + "\n");
		sb.append("humidex						: " + this.humidex + "\n");
		sb.append("windChill					: " + this.windChill + "\n");
		sb.append("Icon							: " + this.icon + "\n");
		
		return sb.toString();
	}
	
	
}
