package net.weather.enums;

public enum Host {
	envCanada("weather.gc.ca", "Env Canada"), weatherUnderground("api.wunderground.com","Weather Underground");
	
	private String host = "";
	private String name = "";
	
	private Host(String host, String name){
		this.host = host;
		this.name = name;
	}
	
	public String getHost(){
		return this.host;
	}
	public String getName() {
		return this.name;
	}
}
