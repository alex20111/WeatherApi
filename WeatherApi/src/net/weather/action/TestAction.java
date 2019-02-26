package net.weather.action;

//import java.net.MalformedURLException;
import java.net.URL;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.weather.bean.City;
import net.weather.bean.WeatherGenericModel;
import net.weather.enums.EnvCanLang;
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
		List<City> cities =  WeatherAction.getEnvCanLocationByCityName("ottawa", false);
		System.out.println(cities);
		
			WeatherGenericModel wgm =  WeatherAction.getEnvironmentCanadaRSSWeather("qc-126", EnvCanLang.english, true, true);
//		 WeatherGenericModel wgm =  WeatherAction.getWeatherByCity("5af84b428c068844", "canada", "ottawa");//ByAirportCode("5af84b428c068844", "YOW"); WEATHER UNDERGROUND
		//WeatherGenericModel wgm =  WeatherAction.getWeatherByAirportCode("yow");
			System.out.println(wgm);
			
//			System.out.println(new SimpleDateFormat("EEE MMM d hh:mm:ss z yyyy").parse(wgm.getWeatherCurrentModel().getObservationTime()));		
//			Date d = new SimpleDateFormat("EEE MMM d hh:mm:ss z yyyy").parse(wgm.getWeatherCurrentModel().getObservationTime());
			
//			System.out.println("Format: " + new SimpleDateFormat("yyyy-MM-dd").format(d));
		//	testJsoup();
//
//			
//			
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		
			
//			
//		Utilities.proxy = proxy;
////		 //String content = Utilities.readUrl(new URL("http://weather.gc.ca/rss/city/on-118_f.xml"));
//		String content = Utilities.readUrl(new URL("http://api.wunderground.com/api/5af84b428c068844/forecast10day/alerts/conditions/astronomy/q/yow.json"));
////			//	http://api.wunderground.com/api/5af84b428c068844/forecast10day/alerts/conditions/astronomy/q/"+ code + ".json";
////		
////		FileHandlingUtils.writeTextToDisk("c:\\jboss\\test.txt", content);
//		// System.out.println(content);
//			
////			String content = FileHandlingUtils.readFileToString("c:\\jboss\\test.txt");
//			JSONReader jsReader = new JSONReader();
////
//			WeatherGenericModel wgm = jsReader.readWeatherUndergroundJson(content);	
//			System.out.println(wgm);
			
			
			
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
	
//	private static void testJsoup()
//	
//	{
//		String link = "http://weather.gc.ca/city/pages/on-118_metric_e.html";
//		
//		try {
//			String content = 			Utilities.readUrl(new URL(link));
//			
//			Document d = Jsoup.parse(content);
//													   
//			String t =  d.getElementsByAttributeValue("class", "dl-horizontal wxo-dl mrgn-tp-sm mrgn-bttm-0").get(2).text();
//			System.out.println(t);
//			
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

	
}
