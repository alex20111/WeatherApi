package net.weather.bean;

public class City {
	
	public String key = "";
	public String nameEn = "";
	public String nameFr = "";
	public String lat = "";
	public String lon = "";
	public double dist = 0.0;
	
	public boolean airportLoc = false;
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	public String getNameFr() {
		return nameFr;
	}
	public void setNameFr(String nameFr) {
		this.nameFr = nameFr;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public double getDist() {
		return dist;
	}
	public void setDist(double dist) {
		this.dist = dist;
	}
	public boolean isAirportLoc() {
		return airportLoc;
	}
	public void setAirportLoc(boolean airportLoc) {
		this.airportLoc = airportLoc;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [key=");
		builder.append(key);
		builder.append(", nameEn=");
		builder.append(nameEn);
		builder.append(", nameFr=");
		builder.append(nameFr);
		builder.append(", lat=");
		builder.append(lat);
		builder.append(", lon=");
		builder.append(lon);
		builder.append(", dist=");
		builder.append(dist);
		builder.append("]");
		return builder.toString();
	}
}
