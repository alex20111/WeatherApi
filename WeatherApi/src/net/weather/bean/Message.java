package net.weather.bean;

import java.util.Date;

public class Message {
	
	public static final int ERROR 	= 1;
	public static final int INFO 	= 2;
	
	
	private int type 		= -1;
	private String title	= "";
	private String message 	= "";
	private Date recDate	= null;
	
	/**
	 * Create a message or error for the weather api module
	 * @param type - Type of message
	 * @param title - Title of the message
	 * @param message - Message
	 */
	public Message(int type, String title, String message){
		this.type = type;
		this.title = title;
		this.message = message;	
		recDate = new Date();
	}
	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getRecDate() {
		return recDate;
	}
	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}
	
	

}
