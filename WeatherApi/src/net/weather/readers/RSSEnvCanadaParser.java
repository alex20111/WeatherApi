package net.weather.readers;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import net.weather.bean.Message;
import net.weather.bean.WeatherAlert;
import net.weather.bean.WeatherCurrentModel;
import net.weather.bean.WeatherForecastModel;
import net.weather.bean.WeatherGenericModel;
import net.weather.bean.WeatherHourlyModel;
import net.weather.enums.WeatherLang;
import net.weather.enums.Host;
import net.weather.utils.MessageHandl;
import net.weather.utils.Utilities;

public class RSSEnvCanadaParser 
{	
	//JsoupDoc
	private String iconsContent = "";

	private Document hourlyCond = null;
	private String sunrise = "";
	private String sunset  = "";
	
	private Map<Integer, iconsData> iconMap = new HashMap<Integer, iconsData>();
	private int iconIdx = 0;
	
	//info	
	private List<Message> messages = new ArrayList<Message>();

	private boolean getIcons = false;	

	//category
	static final String CURRENT = "Current Conditions";
	static final String FORECAST = "Weather Forecasts";
	static final String ALERT = "Warnings and Watches";
	
	static final String CURRENT_FR = "Conditions actuelles";
	static final String FORECAST_FR = "Prévisions météo";
	static final String ALERT_FR = "Veilles et avertissements";

	private final InputStream feedContent;

	public RSSEnvCanadaParser(InputStream feedContent, String iconsLink, String hourlyCond) throws IOException
	{	   
		this.feedContent = feedContent;	
		
		//build only the icons if we have a icon link
		if (iconsLink != null && iconsLink.length() > 0)
		{
			getIcons = true;			
			try {

				iconsContent  = Utilities.readUrl(new URL(iconsLink));
			} catch (Exception e) {
				Message msg = new Message(Message.ERROR, "Icon Data", "Error in getting icon data. Exception : " + Utilities.getStackTrace(e));
				addMessage(msg);
			}
			
		}
		
		if(hourlyCond != null && hourlyCond.length() > 0)
		{
			this.hourlyCond = Jsoup.parse(hourlyCond);
		}
	}

	/**
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * @throws FeedException
	 * @throws IOException
	 */
	public WeatherGenericModel readFeed(WeatherLang lang) throws Exception
	{	
        SyndFeedInput input = new SyndFeedInput();

        SyndFeed feed = input.build(new XmlReader(feedContent));
        
        WeatherGenericModel wgm = null;
        
        if (feed.getEntries().size() > 0)
        {
        	wgm = new WeatherGenericModel();
        	
        	wgm.setLocation(feed.getTitle());
        	
        	List<WeatherForecastModel> forecast = new ArrayList<WeatherForecastModel>();
        	
        	//1st populate icon file name and name.
        	if (getIcons)
        	{
        		populateIconsSunRiseSetValues();
        	}
        	else
        	{
        		//send information that the icons are deactivated
        		Message msg = new Message(Message.INFO, "Icon Data Off", "No icons will be retrieved. Please set boolean to true to get the icons. ");
				addMessage(msg);        		
        	}     	        	
        	
        	
        	for (Object ent : feed.getEntries())
        	{
        		String categories = "";

        		SyndEntryImpl entry = (SyndEntryImpl)ent;

        		for(Object cat : entry.getCategories())
        		{
        			SyndCategoryImpl catg = (SyndCategoryImpl)cat;
        			categories = catg.getName();
        		}

        		if (categories.equalsIgnoreCase(CURRENT) || categories.equalsIgnoreCase(CURRENT_FR))
        		{
        			WeatherCurrentModel wcm = setWeatherCurrentModelInfo(entry.getTitle(),entry.getPublishedDate(), entry.getDescription().getValue() );
        			if (wcm != null)
        			{
        				wgm.setWeatherCurrentModel(wcm);
        			}
        		}
        		else if(categories.equalsIgnoreCase(FORECAST) || categories.equalsIgnoreCase(FORECAST_FR))
        		{
        			WeatherForecastModel wfm = null;
        			
        			if (lang == WeatherLang.french )
        			{
        				wfm = setWthForecastFr(entry.getTitle(),entry.getPublishedDate(), entry.getDescription().getValue() );
        			}
        			else
        			{
        				wfm = setWthForecast(entry.getTitle(),entry.getPublishedDate(), entry.getDescription().getValue() );
        			}        			
        			
        			if (wfm != null)
        			{
        				forecast.add(wfm);
        			}
        		}
        		else if ( ( categories.equals(ALERT) && !"No watches or warnings in effect.".equals(entry.getDescription().getValue()) )  ||
        				  ( categories.equals(ALERT_FR) && !"Aucune veille ou alerte en vigueur.".equals(entry.getDescription().getValue()) ) )
				{							
					WeatherAlert wAlert = new WeatherAlert();
					wAlert.setDescription(entry.getTitle());					
					wAlert.setMessage(setAlert(entry.getLink(), lang));
					wgm.setWeatherAlert(wAlert);
        		}        		
        	}
        	wgm.setWForecastModel(forecast);
        	
        	//build the hourly forecast.
        	if (hourlyCond != null)
        	{
        		wgm.setWeatherHourlyModel(weatherHourly());
        	}
        	else
        	{
        		Message msg = new Message(Message.INFO, "Hourly condition link empty", "No hourly condition information will be returned." +
        										" Please set boolean to true to get the hourly condition. ");
				addMessage(msg);  
        	
        	}
        	
        	MessageHandl messageHandler = new MessageHandl(messages);
        	wgm.setMessages(messageHandler);
        }
        return wgm;
	}
	
	/**
	 * build the weather current model.
	 * @param title
	 * @param updated
	 * @param summary
	 * @return
	 */
	private WeatherCurrentModel setWeatherCurrentModelInfo(String title, Date updated, String summary)
	{
		WeatherCurrentModel wcm = null;

		if (summary.length() > 0)
		{
			
			wcm = new WeatherCurrentModel();
			wcm.setObservationTime(updated.toString());

			String summa = summary.replaceAll("<br/>"," ");

			//break down summary
			String[] summ = summa.split("<b>");

			for (String s: summ)
			{
				if (s.indexOf(">") > 0)
				{
					if (s.startsWith("Condition"))
					{
						wcm.setSummary(s.substring(s.indexOf(">") + 2).trim());
						
						//only set icons when we have them
						if (getIcons)
						{							
							if (iconMap.containsKey(iconIdx))	{									
								wcm.setIconName(iconMap.get(iconIdx).icon);
								wcm.setIconUrl(iconMap.get(iconIdx).iconUrl);
								iconIdx++;
							}
						}
					}
					else if (s.startsWith("Temperature") || s.startsWith("Température"))
					{
						String tmpStr = s.substring(s.indexOf(">") + 2);
						String temp  = tmpStr.substring(0,tmpStr.indexOf("&"));
						String tempFinal = "";
						
						if (temp.contains(","))
						{
							tempFinal = temp.replace(",",".");
						}
						else
						{
							tempFinal = temp;	
						}
						
						try
						{							
							float tempFloat = Float.valueOf(tempFinal);

							wcm.setCurrTemp(tempFloat);
						}
						catch(NumberFormatException nfx)
						{		
							wcm.setCurrTemp(0f);
						}
					}
					else if(s.startsWith("Pressure") || s.startsWith("Pression"))
					{
						wcm.setPressureMb(s.substring(s.indexOf(">") + 2).trim());
					}
					else if(s.startsWith("Visibility") || s.startsWith("Visibilité"))
					{
						wcm.setVisibility(s.substring(s.indexOf(">") + 2).trim());
					}
					else if(s.startsWith("Humidity") || s.startsWith("Humidité"))
					{
						wcm.setHumidity(s.substring(s.indexOf(">") + 2).trim());
					}
					else if(s.startsWith("Dewpoint") || s.startsWith("Point de rosée"))
					{
						String dewTmp = s.substring(s.indexOf(">") + 2).trim();
						String dewPoint  = dewTmp.substring(0,dewTmp.indexOf("&"));
						wcm.setDewPointC(dewPoint);
					}
					else if (s.startsWith("Wind Chill") || s.startsWith("Refroidissement éolien"))
					{
						wcm.setWindChill(s.substring(s.indexOf(">") + 2).trim());
					}
					else if(s.startsWith("Wind") || s.startsWith("Vent"))
					{
						wcm.setWindDirectionText(s.substring(s.indexOf(">") + 2).trim());
					}					
					else if (s.startsWith("Humidex"))
					{
						wcm.setFeelsLike(s.substring(s.indexOf(">") + 2).trim());
					}
				}
			}	
			
			if (sunrise.length() > 0 && sunset.length() > 0)
			{
				wcm.setSunRise(sunrise);
				wcm.setSunSet(sunset );
			}
		}
		return wcm;
	}
	
	
	/**
	 * Get the long day forecast for english
	 * 
	 * @param title
	 * @param updated
	 * @param summary
	 * @return
	 */
	private WeatherForecastModel setWthForecast(String title, Date updated, String summary)
	{
		WeatherForecastModel wfm = null;

		if (title != null)
		{
			wfm = new WeatherForecastModel();
			wfm.setDayOfWeek(title.substring(0 , title.indexOf(":") ));

			if (wfm.getDayOfWeek().contains("night"))
			{
				wfm.setNight(true);
			}
			else
			{
				wfm.setDay(true);
			}

			wfm.setForcastIssued(updated);

			if (title.contains("High"))
			{
				if (title.contains("High plus"))
				{					
					wfm.setHighTemp(title.substring(title.indexOf("High") + "high plus".length() + 1, title.lastIndexOf(".")));
				}
				else if (title.contains("High minus"))
				{					
					wfm.setHighTemp(title.substring(title.indexOf("High") + "high minus".length() + 1, title.lastIndexOf(".")));
				}
				else
				{			
					wfm.setHighTemp(title.substring(title.indexOf("High") + "high".length() + 1, title.lastIndexOf(".")));
				}
			}
			if (title.contains("Temperature falling to"))
			{
				String high = title.substring(title.indexOf("Temperature") + 23);
				wfm.setHighTemp(high.substring(0,2));
			}

			if (title.contains("Low"))
			{
				String lowTemp = title.substring(title.indexOf("Low") + "low".length() + 1);

				if(lowTemp.startsWith("plus") )
				{
					lowTemp = lowTemp.substring(lowTemp.indexOf("plus") + "plus".length() + 1, lowTemp.indexOf(".")) ;
				}
				else if (lowTemp.contains("minus"))
				{
					lowTemp = "-" + lowTemp.substring(lowTemp.indexOf("minus") + "minus".length() + 1, lowTemp.indexOf(".")) ;

				}
				else if (lowTemp.contains("zero"))
				{
					lowTemp = "0";
				}
				else
				{
					lowTemp = lowTemp.substring(0,lowTemp.indexOf(".")) ;
				}

			
				wfm.setLowTemp(lowTemp);
			}

			if (title.contains("POP"))
			{
				wfm.setProbOfRain(title.substring(title.indexOf("POP") + "pop".length() + 1, title.lastIndexOf("%")+1));
			}

			if (summary.contains("UV index"))
			{
				wfm.setUvIndex(summary.substring(summary.indexOf("UV index") + 9, summary.indexOf("UV index") + 11).trim());
			}

			wfm.setForecast(summary.substring(0, summary.indexOf("Forecast")));	
			wfm.setWeatherOutlook(title.substring(title.indexOf(":") + ":".length(), title.indexOf(".")));
			
			//only set icons when we have them
			if (getIcons)
			{
				if (iconMap.containsKey(iconIdx))		{
					wfm.setIconName(iconMap.get(iconIdx).icon);
					wfm.setIconUrl(iconMap.get(iconIdx).iconUrl);
					iconIdx++;
				}
			}
			
			
		}
		return wfm;
	}
	
	/**
	 * Get the long day forecast for english
	 * 
	 * @param title
	 * @param updated
	 * @param summary
	 * @return
	 */
	private WeatherForecastModel setWthForecastFr(String title, Date updated, String summary)
	{
		WeatherForecastModel wfm = null;

		if (title != null)
		{
			wfm = new WeatherForecastModel();
			wfm.setDayOfWeek(title.substring(0 , title.indexOf(":") ));

			if (wfm.getDayOfWeek().contains("nuit"))
			{
				wfm.setNight(true);
			}
			else
			{
				wfm.setDay(true);
			}

			wfm.setForcastIssued(updated);

			if (title.contains("Maximum"))
			{
				wfm.setHighTemp(title.substring(title.indexOf("Maximum") + "Maximum".length() + 1, title.lastIndexOf(".")));
			}
			if (title.contains("Temperature falling to"))
			{
				String high = title.substring(title.indexOf("Temperature") + 23);
				wfm.setHighTemp(high.substring(0,2));
			}

			if (title.contains("Minimum"))
			{
				String lowTemp = title.substring(title.indexOf("Minimum") + "Minimum".length() + 1);

				if(lowTemp.contains("plus"))
				{
					lowTemp = lowTemp.substring(lowTemp.indexOf("plus") + "plus".length() + 1, lowTemp.indexOf(".")) ;
				}
				else if (lowTemp.contains("moins"))
				{
					lowTemp = "-" + lowTemp.substring(lowTemp.indexOf("Minimum") + "Minimum".length() + 1, lowTemp.indexOf(".")) ;

				}
				else if (lowTemp.contains("zéro"))
				{
					lowTemp = "0";
				}
				else
				{
					lowTemp = lowTemp.substring(0,lowTemp.indexOf(".")) ;
				}

		
				wfm.setLowTemp(lowTemp);
			}

			if (title.contains("PdP"))
			{
				wfm.setProbOfRain(title.substring(title.indexOf("PdP") + "PdP".length() + 1, title.lastIndexOf("%")+1));
			}

			if (summary.contains("Indice UV"))
			{
				wfm.setUvIndex(summary.substring(summary.indexOf("Indice UV de") + 12, summary.indexOf("Indice UV") + 14).trim());
			}

			wfm.setForecast(summary.substring(0, summary.indexOf("Prévisions")));	
			wfm.setWeatherOutlook(title.substring(title.indexOf(":") + ":".length(), title.indexOf(".")));
		}
		return wfm;
	}
	
	/**
	 * set Weather alerts.
	 * @return
	 */
	private String setAlert(String link, WeatherLang lang)
	{
		StringBuilder alertVal = new StringBuilder();
		try {		
			
			if (!link.startsWith("https")){
				link = "https" +  link.substring(4, link.length());
			}

			URL url = new URL(link);
			String content = Utilities.readUrl(url);

			Document doc = Jsoup.parse(content);		

			Elements description = doc.getElementsByAttributeValueContaining("class", "col-xs-12");

			Document doc2 = Jsoup.parse(description.html());

			Elements h2 = doc2.getElementsByTag("h2");
			Elements issued = doc2.getElementsByTag("span");
			Elements title = doc2.getElementsByTag("strong");
			Elements ul = doc2.getElementsByTag("ul");
			Elements pppp = doc2.getElementsByTag("p");		

			alertVal.append("<html> <strong>" + title.text() + "</strong><br/>");	
			alertVal.append(ul.get(0));
			//alert.add(ul.get(0).select("li").html());

			for (int i = 1; i < pppp.size() ; i++)
			{
				alertVal.append(pppp.get(i));
			}
			alertVal.append("<br/> " + h2.text() + " Issued: " + issued.text() + "</html>");

		} catch (MalformedURLException e)
		{
			alertVal.append("Error forming the URL");			
		} 
		catch (Exception e)
		{		
			e.printStackTrace();
			alertVal.append("Error Retreiving Alert web info " + e.getStackTrace()[0].getLineNumber() + " " + e.getMessage());
		}

		return alertVal.toString();
	}
	/**
	 * populate the filename of the icons names
	 * 
	 */
	private void populateIconsSunRiseSetValues()
	{	
		if (iconsContent.length() > 0){
			try{

				Document docPicLink = Jsoup.parse(iconsContent);

				//current and forecast pics
				Elements imgs = docPicLink.select("img.center-block");

				
				int idx = 0;
				for(int i = 0 ; i < imgs.size();i++){
					
					Element e = imgs.get(i);
					String icon = e.attr("src");
					
					if( i == 2){
						//current icon is 0 - 1 - 2
						
						iconsData ic = new iconsData(icon.substring(icon.lastIndexOf("/")+1, icon.length()), "http://" + Host.envCanada.getHost() + icon );
						iconMap.put(idx, ic);

						idx++;
					}else if (i > 2){
						//forecast icon is 3 to 14
						iconsData ic = new iconsData(icon.substring(icon.lastIndexOf("/")+1, icon.length()), "http://" + Host.envCanada.getHost() + icon );
						iconMap.put(idx, ic);
						idx++;
					}
				}

				//get sunrise set also		
				Elements sun = docPicLink.getElementsByAttributeValue("class", "table wxo-normals");	
				for(Element e : sun){
					String data =  e.text();			

					sunrise = data.substring(data.indexOf("Sunrise") + 8, data.indexOf("Sunset")) ;
					sunset =  data.substring(data.indexOf("Sunset") + 7, data.length()) ;
				}
			}
			catch(Exception ex){
				Message msg = new Message(Message.ERROR, "Icon Data Retreival", "Error in populateIconsSunRiseSetValues . Exception : " + Utilities.getStackTrace(ex));
				addMessage(msg);
			}

		}
	}
	
	private List<WeatherHourlyModel> weatherHourly()
	{
		List<WeatherHourlyModel> whms = new ArrayList<WeatherHourlyModel>();
		
		Elements hours = hourlyCond.getElementsByAttributeValue("headers", "header1"); // time
		Elements temp = hourlyCond.getElementsByAttributeValue("headers", "header2"); // temp
		Elements wthCond = hourlyCond.getElementsByAttributeValue("headers", "header3"); //forecast
		Elements pop = hourlyCond.getElementsByAttributeValue("headers", "header4"); //pop
		Elements wind = hourlyCond.getElementsByAttributeValue("headers", "header5"); //wind
		Elements humidex = hourlyCond.getElementsByAttributeValue("headers", "header6"); // header 6 is humidex 
		Elements windChill = hourlyCond.getElementsByAttributeValue("headers", "header7"); // header 7 is wind chill
		
		Calendar cal = Calendar.getInstance(); // creates calendar
	    cal.setTime(new Date()); // sets calendar time/date
	    cal.set(Calendar.MINUTE,0);
	    cal.set(Calendar.MILLISECOND,0);
	    cal.set(Calendar.SECOND,0);
		
		for (int i = 0 ; i < hours.size() ; i++)
		{
			WeatherHourlyModel whm = new WeatherHourlyModel();
			
			cal.add(Calendar.HOUR_OF_DAY, 1);
			
			whm.setDate(cal.getTime());
			whm.setAbbrDate(hours.get(i).text());
			whm.setTemp(temp.get(i).text());
			whm.setPop(pop.get(i).text());
			whm.setWeatherCond(wthCond.get(i).text());
			whm.setWind(wind.get(i).text().replace("Â", ""));
			if (humidex != null && humidex.size() > 0)
			{
				whm.setHumidex(humidex.get(i).text());
			}
			if(windChill != null && windChill.size() > 0)
			{
				whm.setWindChill(windChill.get(i).text());
			}
			
			whms.add(whm);		
		}
		
		return whms;
		
	}
	
	private void addMessage(Message msg){
		messages.add(msg);
	}
	
	class iconsData{
				
		public String icon = "";
		public String iconUrl = "";
		
		public iconsData(String icon, String iconUrl){
			this.icon = icon;
			this.iconUrl = iconUrl;
		}
	}
} 
