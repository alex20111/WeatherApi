package net.weather.enums;

public enum WeatherLang {
	english("e", "en"), french("f", "fr");
	
	private String lang = "";
	private String darkSkyLang;
	
	private WeatherLang(String lang, String dsLang){
		this.lang = lang;
		this.darkSkyLang = dsLang;
	}
	
	public String getLang(){
		return this.lang;
	}
	
	public String getDarkSkyLang() {
		return darkSkyLang;
	}
	
}
