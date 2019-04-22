package net.weather.action;

//import java.net.MalformedURLException;
import java.net.URL;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import net.weather.bean.City;
import net.weather.bean.WeatherGenericModel;
import net.weather.darksky.DarkSky;
import net.weather.enums.DarkSkyExclude;
import net.weather.enums.DarkSkyUnits;
import net.weather.enums.WeatherLang;
import net.weather.utils.FileHandlingUtils;
import net.weather.utils.Utilities;


public class TestAction {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		//alerts : http://www.weather.gc.ca/warnings/report_e.html?sk23  http://weather.gc.ca/rss/city/sk-38_e.xml
		//         http://weather.gc.ca/warnings/report_e.html?nt1   http://weather.gc.ca/rss/city/nt-23_e.xml
		
		
//		try {
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.omega.dce-eir.net", 8080));	
//			Utilities.proxy = proxy;
		//	convertUrlToFile();
			
////			//on-77 on-118 http://weather.gc.ca/rss/city/nb-29_e.xml
//		List<City> cities =  WeatherAction.getEnvCanLocationByCityName("ottawa", false);
//		System.out.println(cities);
//		
//			WeatherGenericModel wgm =  WeatherAction.getEnvironmentCanadaRSSWeather("on-118", EnvCanLang.english, true, true);
////		 WeatherGenericModel wgm =  WeatherAction.getWeatherByCity("5af84b428c068844", "canada", "ottawa");//ByAirportCode("5af84b428c068844", "YOW"); WEATHER UNDERGROUND
//		//WeatherGenericModel wgm =  WeatherAction.getWeatherByAirportCode("yow");
//			System.out.println(wgm);
			

//
//			
//			
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		
		
		
		List<City> cities = WeatherAction.getEnvCanLocationByCityName("ottawa",true);
		
		City city = cities.get(0);
		
		List<DarkSkyExclude> ex = new ArrayList<DarkSkyExclude>();
//		ex.add(DarkSkyExclude.HOURLY);
//		ex.add(DarkSkyExclude.MINUTELY);
		
		System.out.println("Getting from city: " + city);
		WeatherGenericModel wgm = WeatherAction.getDarkSkyForecast(city, DarkSkyUnits.SI, ex, WeatherLang.english);
		
		System.out.println(wgm);
		
//		readDarkSky();
			
	
			
			
	}
	private static void readDarkSky() throws Exception {  //C:\dev\jsonJava
		System.out.println("Read");
//		String darkSky = FileHandlingUtils.readFileToString("c:\\dev\\jsonJava\\darkSky.txt");
		//https://darksky.net/dev/docs
		String darkSky = Utilities.readUrl(new URL("https://api.darksky.net/forecast/3a35ddf8a53ed69c8860e568c4f0a4f9/37.8267,-122.4233?units=si"));
		
		Gson g = new Gson();
		DarkSky p = g.fromJson(darkSky, DarkSky.class);
	System.out.println("Finished");
		System.out.println("P: " + p.getTimezone());
		//				Read more: http://www.java67.com/2016/10/3-ways-to-convert-string-to-json-object-in-java.html#ixzz5lb9Wscfi
	}
	@SuppressWarnings("unused")
	private static void convertUrlToFile() throws Exception
	{
		String alert = "http://weather.gc.ca/warnings/report_e.html?nt1";
		String rss = "http://weather.gc.ca/rss/city/sk-38_e.xml";
		String hourly = "http://weather.gc.ca/forecast/hourly/nt-24_metric_e.html";
		
//		String rssContent = Utilities.readUrl(new URL(rss));
//		
//		FileHandlingUtils.writeTextToDisk("c:\\temp\\rss1.xml", rssContent);
		
//		String alertContent = Utilities.readUrl(new URL(alert));
//		
//		FileHandlingUtils.writeTextToDisk("c:\\temp\\alert2.html", alertContent);
		
		String hourlyContent = Utilities.readUrl(new URL(hourly));
//		
		FileHandlingUtils.writeTextToDisk("c:\\temp\\hourly.html", hourlyContent);
	}


	
}
