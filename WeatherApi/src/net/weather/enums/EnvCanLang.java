package net.weather.enums;

public enum EnvCanLang {
	english("e"), french("f");
	
	private String lang = "";
	
	private EnvCanLang(String lang){
		this.lang = lang;
	}
	
	public String getLang(){
		return this.lang;
	}
	
}
