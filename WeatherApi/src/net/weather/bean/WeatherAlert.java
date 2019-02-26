package net.weather.bean;

public class WeatherAlert {
	
	private String description = "";
	private String message = "";
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Description: " + this.description + "\n");
		sb.append("Message: " + this.message + "\n");

	
		return sb.toString();
	}
}
