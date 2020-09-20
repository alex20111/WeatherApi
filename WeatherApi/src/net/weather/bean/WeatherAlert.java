package net.weather.bean;

public class WeatherAlert {
	
	private String description = "";
	private String message = "";
	private String level = ""; //specify the level of the alert.
	
	
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
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Description: " + this.description + "\n");
		sb.append("Message: " + this.message + "\n");
		sb.append("Level: " + this.level + "\n");

	
		return sb.toString();
	}
}
