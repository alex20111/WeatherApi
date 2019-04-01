package net.weather.action;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.weather.bean.City;
import net.weather.bean.WeatherGenericModel;
import net.weather.bean.WeatherLocation;
import net.weather.enums.EnvCanLang;
import net.weather.enums.Host;
import net.weather.readers.WeatherUndergrdReader;
import net.weather.readers.RSSEnvCanadaParser;
import net.weather.utils.Utilities;
//5af84b428c068844
/**
 * Class that perform the weather actions.. Ex get forecast.. get sunrise sunset.
 * @author Alex
 *
 */
public class WeatherAction 
{
	private static String ENV_CAN_CITIES_LINK = "https://weather.gc.ca/gps/js/cityLatLon.js";
	/**
	 *  get weather by City code
	 *  
	 * @param country
	 * @param city
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByCity(String apiKey,String country, String city) throws Exception
	{
		return getWeatherByCity(apiKey,country, city, null);
	}
	
	/**
	 *  get weather by City code
	 *  
	 * @param country - Country code - CA
	 * @param city - City code - Ottawa
	 * @param proxy - if proxy required
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByCity(String apiKey,String country, String city, Proxy proxy) throws Exception
	{
		String obser = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/forecast10day/alerts/conditions/astronomy/q/"+country+"/"+city+".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(obser ));
		
		System.out.println("content: " + content);

		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		WeatherGenericModel wgm = jsReader.getCompleteForecast(content);		
		
		return wgm;
	}
	/**
	 * get weather by airport location
	 * @param code - ex: yow
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByAirportCode(String apiKey,String code) throws Exception
	{
		return getWeatherByAirportCode(apiKey,code, null);
	}
	/**
	 * get weather by airport location
	 * 
	 * @param code - ex: yow
	 * @param proxy - If proxy required
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByAirportCode(String apiKey,String code, Proxy proxy) throws Exception
	{
		String obser = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/forecast10day/alerts/conditions/astronomy/q/"+ code + ".json";
	
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(obser ));

		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		WeatherGenericModel wgm = jsReader.getCompleteForecast(content);
		
		return wgm;
	}
	/**
	 * get weather by  Latitude longitude
	 * 
	 * @param lat - Latitude
	 * @param lon - Longitude
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByLatLong(String apiKey,String lat, String lon) throws Exception
	{
		return getWeatherByLatLong(apiKey,lat, lon);
	}
	/**
	 * get weather by  Latitude longitude
	 * 
	 * @param lat - Latitude
	 * @param lon - Longitude
	 * @param proxy - If required
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getWeatherByLatLong(String apiKey,String lat, String lon, Proxy proxy) throws Exception
	{
		String latLong = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/forecast10day/alerts/conditions/astronomy/q/" + lat + "," + lon + ".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(latLong ));
		
		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		WeatherGenericModel wgm =jsReader.getCompleteForecast(content);
		
		return wgm;
	}
	public static WeatherGenericModel getWeatherByPWS(String apiKey,String pws, Proxy proxy) throws Exception
	{
		String latLong = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/forecast10day/alerts/conditions/astronomy/q/pws:" + pws + ".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(latLong ));
		
		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		WeatherGenericModel wgm = jsReader.getCompleteForecast(content);
		
		return wgm;
	}	
	
	
	/**
	 * get weather by postal code
	 * 
	 * @param postalCode - Ex: j9a3e8	
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByPostalCode(String apiKey,String postalCode) throws Exception
	{
		return getWeatherStationLocByPostalCode(apiKey,postalCode, null);
	}
	/**
	 * get weather by postal code
	 * 
	 * @param postalCode - Ex: j9a3e8
	 * @param proxy - if required
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByPostalCode(String apiKey,String postalCode, Proxy proxy) throws Exception
	{

		String obser = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/geolookup/q/"+postalCode+".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(obser ));

		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		List<WeatherLocation> wls = jsReader.getLocations(content);		

		return wls;

	}
	/**
	 * Get weather station by city and country
	 * 
	 * @param country - Ex : CA
	 * @param city		- EX: hull
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByCity(String apiKey,String country, String city ) throws Exception
	{
		return getWeatherStationLocByCity(apiKey,country, city, null);
	}
	/**
	 * Get weather station by city and country
	 * 
	 * @param country - Ex : CA
	 * @param city		- EX: hull
	 * @param proxy  - if required
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByCity(String apiKey,String country, String city , Proxy proxy) throws Exception
	{

		String obser = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/geolookup/q/"+country+"/"+city+".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(obser ));

		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		List<WeatherLocation> wls = jsReader.getLocations(content);	

		return wls;

	}
	/**
	 * Get weather station by city and country
	 * 
	 * @param country - Ex : CA
	 * @param city		- EX: hull
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByLatLong(String apiKey,String lat, String longitude ) throws Exception
	{
		return getWeatherStationLocByLatLong(apiKey,lat, longitude, null);
	}
	/**
	 * Get weather station by city and country
	 * 
	 * @param country - Ex : CA
	 * @param city		- EX: hull
	 * @param proxy  - if required
	 * @return
	 * @throws Exception
	 */
	public static List<WeatherLocation> getWeatherStationLocByLatLong(String apiKey,String lat, String longitude , Proxy proxy) throws Exception
	{

		String obser = "http://" + Host.weatherUnderground.getHost() + "/api/"+apiKey+"/geolookup/q/"+lat+","+longitude+".json";
		
		Utilities.proxy = proxy;
		
		String content = Utilities.readUrl(new URL(obser ));

		WeatherUndergrdReader jsReader = new WeatherUndergrdReader();

		List<WeatherLocation> wls = jsReader.getLocations(content);	

		return wls;

	}
	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(City city, EnvCanLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
	{
		return getEnvironmentCanadaRSSWeather(city.key, null, lang, getHourlyContent, getIcons);
	}
	/**
	 * Get the RSS for environment Canada by City.
	 * 
	 * @param city
	 * 			- The xml file for the city - EX: for Ottawa: on-118_e.xml
	 * @param lang
	 * 			- en = english, fr = french
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(String city, EnvCanLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
	{
		return getEnvironmentCanadaRSSWeather(city, null, lang, getHourlyContent, getIcons);
	}
	
	/**
	 * Get the RSS for environment Canada by City.
	 * 
	 * @param city
	 * 			- The xml file for the city - EX: for Ottawa: on-118_e.xml
	 * @param proxy
	 * 			- if behind a proxy
	 * @param lang
	 * 			- en = english, fr = french
	 * @return
	 * @throws Exception
	 */
	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(String city, Proxy proxy, EnvCanLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
	{
		//https://weather.gc.ca/rss/city/on-118_e.xml
		//Feed				http://weather.gc.ca/rss/city/on-118_e.xml
		String rssFeed = "https://" + Host.envCanada.getHost() + "/rss/city/" + city + "_" + lang.getLang() + ".xml";
		//Icon links
		String iconsLink = "";
		//hourly content
		String hourly = "https://" + Host.envCanada.getHost() + "/forecast/hourly/" + city + "_metric_" + lang.getLang() + ".html";

		//set the proxy 
		Utilities.proxy = proxy;		

		
		InputStream content = Utilities.readUrlAsStream(new URL(rssFeed));
		
		String hourlyContent  = "";
		
		if (getHourlyContent)
		{
			hourlyContent = Utilities.readUrl(new URL(hourly));
		}
		
		if (getIcons){
			iconsLink = "https://" + Host.envCanada.getHost() + "/city/pages/" + city + "_metric_" + lang.getLang() + ".html";
		}

		//parser
		RSSEnvCanadaParser rssParser = null;
		//weather model
		WeatherGenericModel wgm  = null;
		
		//if no empty content, parse it
		if(content!= null )
		{
			rssParser = new RSSEnvCanadaParser(content, iconsLink, hourlyContent); 
			
			//if everything is ok from the parser, send it back .
			if (rssParser != null)
			{
				wgm = rssParser.readFeed(lang);
			}
		}	

		return wgm;
	}	
	public static List<City> getEnvCanLocationByLatLong(double latitude, double longitude, Proxy proxy, boolean loadAllCities, boolean fromFile) throws MalformedURLException, Exception{

		//set the proxy 
		Utilities.proxy = proxy;

		List<City> finalCities = new ArrayList<City>();
		
		String citiesArray = ""; 
		if (fromFile) {
			citiesArray = loadCitiesFromFile();
		}else {
			citiesArray = Utilities.readUrl(new URL(ENV_CAN_CITIES_LINK));
		}

		//trim the array
		if (citiesArray != null && citiesArray.length() > 0){

			List<City> cityList = loadEnvCanEssCities(citiesArray);

			if (!loadAllCities){
				for(City city : cityList){

					double cityLat = Double.parseDouble(city.lat);
					double cityLon = Double.parseDouble(city.lon);				

					double km = Utilities.findClosestCities(latitude, longitude, cityLat, cityLon);

					if (km < 60){
						city.dist = km;
						finalCities.add(city);
					}
				}
			}else{
				finalCities.addAll(cityList);
			}
		}
		return finalCities;

	}
	
	public static List<City> getEnvCanLocationByCityName(String cityName, boolean fromFile) throws MalformedURLException, Exception{
		
		if (cityName == null || cityName.trim().length() == 0){
			throw new Exception("Please enter a city name");
		}
		
		
		Map<String, City> citiesMap = new HashMap<String, City>();
		List<City> finalCities = new ArrayList<City>();
		//envCanCity.txt
//		String citiesArray = FileHandlingUtils.readFileToString("c:\\temp\\envcancity.txt");
		String citiesArray = "";
		
		if (fromFile){
		
			    citiesArray = loadCitiesFromFile();
		}
		else
		{
			citiesArray = Utilities.readUrl(new URL(ENV_CAN_CITIES_LINK));
		}
			
		
		if (citiesArray != null && citiesArray.length() > 0 ){
			List<City> loadedCities =  loadEnvCanEssCities(citiesArray);
		
			String cityToSearch = cityName.trim().toLowerCase();
			Map<Double, Double> latLong = new HashMap<Double, Double>();
			for(City city : loadedCities)
			{
				String name = city.getNameEn() ;
				if (name != null && name.length() > 0 && name.toLowerCase().contains(cityToSearch)){
					latLong.put(Double.valueOf(city.lat), Double.valueOf(city.lon));				
					
					citiesMap.put(city.key, city);
				}
			}
			
			if (latLong.size() > 0){
				
				
					for(City city : loadedCities)
					{
						for(Map.Entry<Double, Double> latlng: latLong.entrySet()){

							double cityLat = Double.parseDouble(city.lat);
							double cityLon = Double.parseDouble(city.lon);				
				
							double km = Utilities.findClosestCities(latlng.getKey(), latlng.getValue(), cityLat, cityLon);
				
							if (km < 60 && km != 0){
								city.dist = km;
								citiesMap.put(city.key, city);
							}

						}
					}
			}
			
			for(Map.Entry<String, City> cityMap: citiesMap.entrySet()){
				finalCities.add(cityMap.getValue());
			}
			
			
			if (finalCities.size() == 0){
				City city = new City();
				city.setKey("none");
				city.setNameEn("Not Found");
				finalCities.add(city);
			}
						
		}else{
			City city = new City();
			city.setKey("none");
			city.setNameEn("Not Found");
			finalCities.add(city);
		}
		
		return finalCities;
	}
	
	public static List<City> loadAllEnvCanCities(boolean fromFile) throws MalformedURLException, Exception{
		if(fromFile) {
			return loadEnvCanEssCities(loadCitiesFromFile());
		}else {
			return  loadEnvCanEssCities(Utilities.readUrl(new URL(ENV_CAN_CITIES_LINK)));
		}
		
	}
	
	private static List<City> loadEnvCanEssCities(String citiesArray){
		
		List<City> cityList = new ArrayList<City>();

		String trimedArray = citiesArray.substring(citiesArray.indexOf("=") + 3, citiesArray.length() - 3);

		String[] splitArray = trimedArray.split("}");

		for(String s : splitArray){

			String[] splitCity = s.split(",");

			City city = new City();

			if (splitCity.length == 6){
				city.key = splitCity[0].substring(splitCity[0].indexOf(":") + 2 , splitCity[0].length() -1 ) ;
				city.nameEn = splitCity[1].substring(splitCity[1].indexOf(":") + 2 , splitCity[1].length() -1 ) ;
				city.nameFr = splitCity[2].substring(splitCity[2].indexOf(":") + 2 , splitCity[2].length() -1 ) ;
				city.lat = splitCity[3].substring(splitCity[3].indexOf(":") + 2 , splitCity[3].length() -1 ) ;
				city.lon = splitCity[4].substring(splitCity[4].indexOf(":") + 2 , splitCity[4].length() -1 ) ;

			}else{
				city.key = splitCity[1].substring(splitCity[1].indexOf(":") + 2 , splitCity[1].length() -1 ) ;
				city.nameEn = splitCity[2].substring(splitCity[2].indexOf(":") + 2 , splitCity[2].length() -1 ) ;
				city.nameFr = splitCity[3].substring(splitCity[3].indexOf(":") + 2 , splitCity[3].length() -1 ) ;
				city.lat = splitCity[4].substring(splitCity[4].indexOf(":") + 2 , splitCity[4].length() -1 ) ;
				city.lon = splitCity[5].substring(splitCity[5].indexOf(":") + 2 , splitCity[5].length() -1 ) ;

			}

			cityList.add(city);
		}
		
		return cityList;
	}
	private static String loadCitiesFromFile() throws IOException {
		InputStream in = WeatherAction.class.getResourceAsStream("envCanCity.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}
