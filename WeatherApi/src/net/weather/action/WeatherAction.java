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
import net.weather.darksky.DarkSky;
import net.weather.enums.WeatherLang;
import net.weather.enums.DarkSkyExclude;
import net.weather.enums.DarkSkyUnits;
import net.weather.enums.Host;
import net.weather.readers.DarkSkyReader;
import net.weather.readers.RSSEnvCanadaParser;
import net.weather.utils.Utilities;
//5af84b428c068844
/**
 * Class that perform the weather actions.. Ex get forecast.. get sunrise sunset.
 * @author Alex
 *
 */
public class WeatherAction {
	private static String ENV_CAN_CITIES_LINK = "https://weather.gc.ca/gps/js/cityLatLon.js";

	//https://api.darksky.net/forecast/[key]/[latitude],[longitude]     //3a35ddf8a53ed69c8860e568c4f0a4f9
	public static WeatherGenericModel getDarkSkyForecast(long latitude, long longitude, List<DarkSkyExclude> exclude, DarkSkyUnits units, WeatherLang lang) throws Exception {

		City city = new City();
		city.setLat(String.valueOf(latitude));
		city.setLon(String.valueOf(longitude));
		return getDarkSkyForecast(city, units,exclude, lang);
	}

	public static WeatherGenericModel getDarkSkyForecast(City city, DarkSkyUnits units,List<DarkSkyExclude> exclude, WeatherLang lang) throws Exception {
		String apiKey = "3a35ddf8a53ed69c8860e568c4f0a4f9";
		String link = "https://" + Host.DARKSKY.getHost() + "/forecast/" + apiKey + "/" +city.lat + "," + city.lon;

		if (units != null || exclude != null && exclude.size() > 0) {

			link += "?";
			if (units != null) {
				link += "units="+units.name().toLowerCase();
			}
			if (exclude != null && exclude.size() > 0) {
				if (units != null) {
					link += "&";
				}
				boolean first = true;
				for(DarkSkyExclude ex : exclude) {
					if (first) {
						link += "exclude="+ex.name().toLowerCase() ;
						first = false;
					}else {
						link += "," + ex.name().toLowerCase();
					}
				}

			}

			if (lang != null ) {
				if (units != null || exclude != null && exclude.size() > 0) {
					link += "&";
				}
				link += "lang=" + lang.getDarkSkyLang();
			}
		}

		System.out.println("Link : " + link);

		URL url = new URL(link);

		String content = Utilities.readUrl(url);

		System.out.println("Content: " + content);
		
		 DarkSkyReader reader = new DarkSkyReader();
		 WeatherGenericModel wgm = reader.generateModel(content);

		return wgm;
	}


	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(City city, WeatherLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
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
	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(String city, WeatherLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
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
	public static WeatherGenericModel getEnvironmentCanadaRSSWeather(String city, Proxy proxy, WeatherLang lang, boolean getHourlyContent, boolean getIcons) throws Exception
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
	/**
	 * Load all cities close to the lat , long provided.
	 * @param latitude
	 * @param longitude
	 * @param fromFile
	 * @return
	 * @throws MalformedURLException
	 * @throws Exception
	 */
	public static List<City> getEnvCanLocationByLatLong(double latitude, double longitude, boolean fromFile) throws MalformedURLException, Exception{
		return getEnvCanLocationByLatLong(latitude, longitude, null,  fromFile);

	}
	public static List<City> getEnvCanLocationByLatLong(double latitude, double longitude, Proxy proxy, boolean fromFile) throws MalformedURLException, Exception{

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


			for(City city : cityList){

				double cityLat = Double.parseDouble(city.lat);
				double cityLon = Double.parseDouble(city.lon);				

				double km = Utilities.findClosestCities(latitude, longitude, cityLat, cityLon);

				if (km < 60){
					city.dist = km;
					finalCities.add(city);
				}
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
