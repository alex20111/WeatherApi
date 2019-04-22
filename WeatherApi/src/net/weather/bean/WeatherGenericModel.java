package net.weather.bean;

import java.util.ArrayList;
import java.util.List;

import net.weather.utils.MessageHandl;

public class WeatherGenericModel 
{
	
	
	private String longitude 	= "";
	private String latitude 	= "";
	private String location 	= "";	
	private String forcastDate 	= "";	
	private String timezone = "";
	private WeatherCurrentModel weatherCurrentModel;
	private List<WeatherForecastModel> wForecastModel;
	private List<WeatherHourlyModel> weatherHourlyModel;
	private WeatherAlert weatherAlert;
	
	private MessageHandl messages;

	
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the forcastDate
	 */
	public String getForcastDate() {
		return forcastDate;
	}
	/**
	 * @param forcastDate the forcastDate to set
	 */
	public void setForcastDate(String forcastDate) {
		this.forcastDate = forcastDate;
	}
	/**
	 * @return the weatherCurrentModel
	 */
	public WeatherCurrentModel getWeatherCurrentModel() {
		return weatherCurrentModel;
	}
	/**
	 * @param weatherCurrentModel the weatherCurrentModel to set
	 */
	public void setWeatherCurrentModel(WeatherCurrentModel weatherCurrentModel) {
		this.weatherCurrentModel = weatherCurrentModel;
	}
	/**
	 * @return the wForecastModel
	 */
	public List<WeatherForecastModel> getWForecastModel() {
		return wForecastModel;
	}
	/**
	 * @param forecastModel the wForecastModel to set
	 */
	public void setWForecastModel(List<WeatherForecastModel> forecastModel) {
		wForecastModel = forecastModel;
	}
	/**
	 * @return the weatherAlert
	 */
	public WeatherAlert getWeatherAlert() {
		return weatherAlert;
	}
	/**
	 * @param weatherAlert the weatherAlert to set
	 */
	public void setWeatherAlert(WeatherAlert weatherAlert) {
		this.weatherAlert = weatherAlert;
	}
	/**
	 * @return the wwatherHourlyModel
	 */
	public List<WeatherHourlyModel> getWeatherHourlyModel() {
		return weatherHourlyModel;
	}
	/**
	 * @param wwatherHourlyModel the wwatherHourlyModel to set
	 */
	public void setWeatherHourlyModel(List<WeatherHourlyModel> weatherHourlyModel) {
		this.weatherHourlyModel = weatherHourlyModel;
	}
	public void setMessages(MessageHandl messages) {
		this.messages = messages;
	}
	public MessageHandl getMessages() {
		return messages;
	}
	public void addMessage(String title, String message, int type) {
		List<Message> msgs = new ArrayList<Message>();
		Message msg = new Message(type, title, message);
		if (messages == null) {
			msgs.add(msg);
			messages = new MessageHandl(msgs);
		}else {
			msgs = messages.getAllMessages();
			msgs.add(msg);
			messages.setAllMessages(msgs);
		}
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		
		
		sb.append("Location: " + this.location + "\n");
		sb.append("Longitude: " + this.longitude + "\n");
		sb.append("Latitude: " + this.latitude + "\n");		
		
		if (this.weatherCurrentModel != null)
		{
			sb.append("\n--- Current weather --- \n");
			sb.append(this.weatherCurrentModel);
		}
		if (this.weatherAlert != null)
		{
			sb.append("\n------- Alerts!!!!-------- \n");
			sb.append(this.weatherAlert);
		}
		if (this.wForecastModel != null)
		{
			sb.append("\n---------Forecast---------- \n");
			for (WeatherForecastModel wf : this.wForecastModel)
			{
				sb.append(wf);
			}
		}
		if (this.weatherHourlyModel != null && weatherHourlyModel.size() > 0)
		{
			sb.append("\n");
			sb.append("---Hourly forecast--- \n");
			for (WeatherHourlyModel whm : this.weatherHourlyModel)
			{
				sb.append(whm);
				sb.append("\n");
			}
		}
		
		if (this.messages != null && this.messages.messageCount() > 0){
			if (messages.infoCount() > 0){
				sb.append("\n---------------- INFO from WG ------------------\n");
				for(Message m : messages.returnAllInfos()){
					sb.append(" -- start --\n");
					sb.append("SUBJECT: " + m.getTitle() + "\n");
					sb.append("DESCRIPTION: " + m.getMessage() + "\n");
					sb.append("REc date : " + m.getRecDate()+ "\n");
					sb.append(" -- end -- \n");
				}
				sb.append("\n---------------- END OF INFO from WG ------------------\n");
			}
			
			if (messages.errorCount() > 0){
				sb.append("\n---------------- ERRORS from WG ------------------\n");
				for(Message m : messages.returnAllErrors()){
					sb.append(" -- start --\n");
					sb.append("SUBJECT: " + m.getTitle() + "\n");
					sb.append("DESCRIPTION: " + m.getMessage() + "\n");
					sb.append("REc date : " + m.getRecDate()+ "\n");
					sb.append(" -- end -- \n");
				}
				sb.append("\n---------------- END OF ERRORS from WG ------------------\n");
			}
		}
		
	
		return sb.toString();
	}
	
	public String formatMessage()
	{
		StringBuilder sb = new StringBuilder();
		
		if (this.weatherAlert != null)
		{
			sb.append("!!!!!!!!! ALERT - see bottom of email !!!!!!!!! \n");
		}		

		sb.append("<a href=" + "http://maps.google.com/?q=" + this.latitude + "," + this.longitude  + ">" + this.location +  " </a> ");
		
		if (this.weatherCurrentModel != null)
		{	
			sb.append("- " +  this.weatherCurrentModel.getObservationTime() + "\n");
			sb.append("\n");
			sb.append("---Current Conditions --- \n");
			
			sb.append(this.weatherCurrentModel);			
		}
		if (this.wForecastModel != null)
		{
			sb.append("\n");
			sb.append("---Forecast--- \n");
			for (WeatherForecastModel wf : this.wForecastModel)
			{
				sb.append(wf);
			}
		}		
		
		if (this.weatherHourlyModel != null && weatherHourlyModel.size() > 0)
		{
			sb.append("\n");
			sb.append("---Hourly forecast--- \n");
			for (WeatherHourlyModel whm : this.weatherHourlyModel)
			{
				sb.append(whm);
			}
		}
		
		if (this.weatherAlert != null)		
		{ 
			sb.append("\n");
			sb.append("!!!!Alerts!!!! \n");
			sb.append(this.weatherAlert);
		}
		return sb.toString();
	}
}
