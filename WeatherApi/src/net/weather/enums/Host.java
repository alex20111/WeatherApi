package net.weather.enums;

public enum Host {
	envCanada("weather.gc.ca"), weatherUnderground("api.wunderground.com");
	
	private String host = "";
	
	private Host(String host){
		this.host = host;
	}
	
	public String getHost(){
		return this.host;
	}
}
