package net.weather.bean;

import java.io.Serializable;

public class WeatherLocation implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String stationId	= "";
	private String country 		= "";
	private String city 		= "";
	private String state 		= "";
	private String lat 			= "";
	private String lon 			= "";
	private String neighborhood = "";
	private String icao			= "";
	private String zmw			= "";
	private boolean airport		= false;
	private boolean prsWthStation		= false; //Personal Weather station

	
	
	/**
	 * @return the stationId
	 */
	public String getStationId() {
		return stationId;
	}
	/**
	 * @param stationId the stationId to set
	 */
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the lon
	 */
	public String getLon() {
		return lon;
	}
	/**
	 * @param lon the lon to set
	 */
	public void setLon(String lon) {
		this.lon = lon;
	}
	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}
	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	/**
	 * @return the airport
	 */
	public boolean isAirport() {
		return airport;
	}
	/**
	 * @param airport the airport to set
	 */
	public void setAirport(boolean airport) {
		this.airport = airport;
	}
	/**
	 * @return the icao
	 */
	public String getIcao() {
		return icao;
	}
	/**
	 * @param icao the icao to set
	 */
	public void setIcao(String icao) {
		this.icao = icao;
	}
	/**
	 * @return the zmw
	 */
	public String getZmw() {
		return zmw;
	}
	/**
	 * @param zmw the zmw to set
	 */
	public void setZmw(String zmw) {
		this.zmw = zmw;
	}
	/**
	 * Specify if the station comes from a personal weather station.
	 * @return
	 */
	public boolean isPrsWthStation() {
		return prsWthStation;
	}
	public void setPrsWthStation(boolean prsWthStation) {
		this.prsWthStation = prsWthStation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{	
		StringBuilder retVal = new StringBuilder();
		retVal.append("--------- Weather location ----------");

		if (airport)
		{		
			retVal.append("Airport: " + this.city + " - " + this.icao + " \n");
		}
		else
		{
			if (this.neighborhood == null || this.neighborhood.length() == 0)
			{
				if (this.city != null && this.city.length() > 0)
				{
					retVal.append(this.city + " , " + this.state + " \n");
				}
			}
			else
			{
				retVal.append(this.neighborhood + " , " + this.city + " , " + this.state + " \n");
			}
		}
		
		
		return retVal.toString();
	}

	public String display() 
	{	
		StringBuilder retVal = new StringBuilder();
		retVal.append("WeatherLocation: \n");
		retVal.append("stationId: " + this.stationId + "\n");
		retVal.append("country: " + this.country + "\n");
		retVal.append("state: " + this.state + "\n");
		retVal.append("city: " + this.city + "\n");
		retVal.append("lat: " + this.lat + "\n");
		retVal.append("lon: " + this.lon + "\n");
		retVal.append("neighborhood: " + this.neighborhood + "\n");
		retVal.append("airport Station : " + this.airport + "\n");
		
		return retVal.toString();
	}
}
