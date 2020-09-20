package net.weather.enums;

public enum EnvCanAlertLvl {
	
	WARNING("Warnings"), WATCH("Watch"), STATEMENT("Statements"), NOT_FOUND("N/A");

	private String Level = "";
	
	private EnvCanAlertLvl(String level) {
		this.Level = level;
	}
	
	public String getLevelText() {
		return this.Level;
	}
	
	public static EnvCanAlertLvl getLevel(String text) {
		if (text.equalsIgnoreCase(WARNING.Level)) {
			return WARNING;
		}else if (text.equalsIgnoreCase(WATCH.Level)) {
			return WATCH;
		}else if (text.equalsIgnoreCase(STATEMENT.Level)) {
			return STATEMENT;
		}
		
		return NOT_FOUND;
	}
}
