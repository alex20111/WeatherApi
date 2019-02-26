package net.weather.readers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.weather.bean.WeatherAlert;
import net.weather.bean.WeatherCurrentModel;
import net.weather.bean.WeatherForecastModel;
import net.weather.bean.WeatherGenericModel;
import net.weather.bean.WeatherLocation;
import net.weather.underground.beans.Forecastday;
import net.weather.underground.beans.Forecastday_;
import net.weather.underground.beans.Station;
import net.weather.underground.beans.Station_;
import net.weather.underground.mains.CompleteForecast;
import net.weather.underground.mains.FindLocation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class WeatherUndergrdReader
{

	
	/**
	 * 
	 * @param json
	 * @return
	 */
//	public WeatherGenericModel readWeatherUndergroundJson(String json) throws Exception
//	{
//		WeatherGenericModel wg = new WeatherGenericModel();
//		WeatherCurrentModel wc = new WeatherCurrentModel();
//
//		WeatherAlert	    wa = null;		
//
//		JsonParser parser = new JsonParser();
//
//		JsonObject obj = (JsonObject)parser.parse(json);
//		
//		JsonObject respObj = obj.getAsJsonObject("response");
//
//		if (respObj.getAsJsonObject("error") != null)
//		{
//			JsonObject errorObj = respObj.getAsJsonObject("error");
//			throw new Exception("Error while retreiving data: " + " Description: " +  errorObj.get("description").getAsString());			
//		}	
//		
//		//current observation object
//		JsonObject currObsObj = obj.getAsJsonObject("current_observation");
//
//		//get location 
//		JsonObject locationObj = currObsObj.getAsJsonObject("display_location");
//		wg.setLatitude(locationObj.get("latitude").getAsString());
//		wg.setLongitude(locationObj.get("longitude").getAsString());
//		wg.setLocation(locationObj.get("full").getAsString());
//
//		//get current observation\
//		wc.setCurrectTempC(currObsObj.get("temp_c").getAsFloat());
//		wc.setFeelsLike(currObsObj.get("feelslike_c").getAsString());
//		wc.setHumidity(currObsObj.get("relative_humidity").getAsString());
//		wc.setObservationTime(currObsObj.get("observation_time").getAsString());
//		if(currObsObj.get("precip_1hr_metric") != null)
//		{
//			wc.setPrecipLastHour(currObsObj.get("precip_1hr_metric").getAsString());
//		}
//		if(currObsObj.get("precip_today_metric")  != null)
//		{
//			wc.setPrecipToday(currObsObj.get("precip_today_metric").getAsString());
//		}
//		
//		wc.setWeather(currObsObj.get("weather").getAsString());
//		wc.setWindDirectionText(currObsObj.get("wind_dir").getAsString() + " " + currObsObj.get("wind_kph").getAsString() + " Km/h");
//		wc.setWindGusting(currObsObj.get("wind_gust_kph").getAsString());
//		wc.setIconName(currObsObj.get("icon").getAsString());
//		wc.setVisibilityKm(currObsObj.get("visibility_km").getAsString());
//		wc.setPressureMb(currObsObj.get("pressure_mb").getAsString());
//		wc.setDewPointC(currObsObj.get("dewpoint_c").getAsString());
//		wc.setWindChill(currObsObj.get("windchill_c").getAsString());
//
//		//////////////// get moon phase //////////////////////
//		JsonObject moonPhaseObj = obj.getAsJsonObject("moon_phase");
//		JsonObject moonRise = moonPhaseObj.getAsJsonObject("sunrise");
//		JsonObject moonSet= moonPhaseObj.getAsJsonObject("sunset");
//		wc.setMoonRise(moonRise.get("hour").getAsString() + ":" + moonRise.get("minute").getAsString());
//		wc.setMoonSet(moonSet.get("hour").getAsString() + ":" + moonSet.get("minute").getAsString());
//		
//		//	//////////////get sun phase //////////////////////
//		JsonObject sunPhaseObj = obj.getAsJsonObject("sun_phase");
//		JsonObject sunRise = sunPhaseObj.getAsJsonObject("sunrise");
//		JsonObject sunSet= sunPhaseObj.getAsJsonObject("sunset");
//		wc.setSunRise(sunRise.get("hour").getAsString() + ":" + sunRise.get("minute").getAsString());
//		wc.setSunSet(sunSet.get("hour").getAsString() + ":" + sunSet.get("minute").getAsString());		
//		
//		//////////////////////////////Forecast long text ////////////////////////////////
//
//		//get the forecast text for today the current and for the week.
//		JsonObject forecastObj = obj.getAsJsonObject("forecast");
//
//		//get the text predictions for the forecast
//		JsonObject txtForecastObj = forecastObj.getAsJsonObject("txt_forecast");
//
//	//	wg.setForcastDate(new SimpleDateFormat("MMM dd ").format(new Date()) + " " + txtForecastObj.get("date").getAsString());
//		wg.setForcastDate(txtForecastObj.get("date").getAsString());
//
//		//get the array
//		JsonArray forecastdayArr = txtForecastObj.getAsJsonArray("forecastday");
//		boolean day = true;
//
//		//forecast for 10 days
//		List<WeatherForecastModel> wfList = new ArrayList<WeatherForecastModel>();
//		WeatherForecastModel wfFor = null;
//		for (int i = 0 ; i < forecastdayArr.size() ; i ++ )				
//		{
//			JsonObject forecastTxtObj = forecastdayArr.get(i).getAsJsonObject();
//
//			wfFor = new WeatherForecastModel();
//			
//			if (day)
//			{			
//				wfFor.setDay(true);
//				day = false;				
//			}
//			else
//			{
//				day = true;
//				wfFor.setNight(true);	
//			}
//			
//			wfFor.setForecast(forecastTxtObj.get("fcttext_metric").getAsString());
//			wfFor.setProbOfRain(forecastTxtObj.get("pop").getAsString());
//			wfFor.setDayOfWeek(forecastTxtObj.get("title").getAsString());
//			wfFor.setIconName(forecastTxtObj.get("icon").getAsString());
//			wfList.add(wfFor);
//			
//		}
//
//		///////////////////////////// forecast simpleforecast /////////////////////////////////////
//
//		//simple forcast for the week , this is where you get the high and lows.
//		JsonObject simpleForecastObj = forecastObj.getAsJsonObject("simpleforecast");
//		JsonArray forecastdaySimpleArr = simpleForecastObj.getAsJsonArray("forecastday");
//		int indx = 0;
//
//		//since the simple forcast is 10 occurence and the forcast long text is 20. Loop through the flt and assoicate it to the simple forecast through the idx.			
//		for (int j = 0 ; j < wfList.size() ; j ++)
//		{	
//			WeatherForecastModel wfForSimp = wfList.get(j);
//			
//			JsonObject forecastDayObj = forecastdaySimpleArr.get(indx).getAsJsonObject();			
//			
//			JsonObject date = forecastDayObj.getAsJsonObject("date");
//			JsonObject rainTotal = forecastDayObj.getAsJsonObject("qpf_allday");
//			JsonObject snowTot = forecastDayObj.getAsJsonObject("snow_allday");	
//			JsonObject maxWind = forecastDayObj.getAsJsonObject("maxwind");
//			JsonObject avgWind = forecastDayObj.getAsJsonObject("avewind");
//
//			//since the forecast is for both night and day, split between night and day.
//			//one for the day forecast	
//			wfForSimp.setDayNumberForWeek(date.get("day").getAsString());
//			wfForSimp.setMonth(date.get("monthname").getAsString());
//			wfForSimp.setMaxWind(maxWind.get("kph").getAsInt());
//			wfForSimp.setAvgWind(avgWind.get("kph").getAsInt());
//			wfForSimp.setWindDir(maxWind.get("dir").getAsString());
//			
//			if (wfForSimp.isDay())
//			{
//				JsonObject rainDay = forecastDayObj.getAsJsonObject("qpf_day");			
//				JsonObject snowDay = forecastDayObj.getAsJsonObject("snow_day");
//				JsonObject highTemp = forecastDayObj.getAsJsonObject("high");
//				
//				wfForSimp.setHighTemp(highTemp.get("celsius").getAsString());
//				
//				wfForSimp.setRain(rainDay.get("mm").isJsonNull() ? (short) 0 : rainDay.get("mm").getAsShort());
//				wfForSimp.setRainTotal(rainTotal.get("mm").getAsShort());
//				wfForSimp.setSnow(snowDay.get("cm").isJsonNull() ? (float) 0 : snowDay.get("cm").getAsFloat());
//				wfForSimp.setSnowTotal(snowTot.get("cm").getAsFloat());
//			}
//			else if (wfForSimp.isNight())
//			{
//				//one for the night forecast
//				JsonObject lowTemp = forecastDayObj.getAsJsonObject("low");
//				JsonObject rainNight = forecastDayObj.getAsJsonObject("qpf_night");
//				JsonObject snowNight = forecastDayObj.getAsJsonObject("snow_night");
//				
//				wfForSimp.setLowTemp(lowTemp.get("celsius").getAsString());
//				wfForSimp.setRain(rainNight.get("mm").getAsShort());
//				wfForSimp.setRainTotal(rainTotal.get("mm").getAsShort());
//				wfForSimp.setSnow(snowNight.get("cm").getAsFloat());
//				wfForSimp.setSnowTotal(snowTot.get("cm").getAsFloat());
//				indx ++;
//			}			
//		}
//
//		//get the alerts
//		JsonArray alertsArray = obj.getAsJsonArray("alerts");
//
//		if (alertsArray != null && alertsArray.size() > 0)
//		{
//			wa = new WeatherAlert();
//			JsonObject alertsObj = obj.getAsJsonArray("alerts").get(0).getAsJsonObject();
//			wa.setDescription(alertsObj.get("description").getAsString());
//			wa.setMessage(alertsObj.get("message").getAsString());
//		}
//
//		//complete the model
//		wg.setWeatherCurrentModel(wc);
//		wg.setWeatherAlert(wa);
//		wg.setWForecastModel(wfList);
//
//		return wg;
//	}
	
//	public List<WeatherLocation> getWeatherLocations(String weatherJson) throws Exception
//	{
//		List<WeatherLocation> wetLocArray = new ArrayList<WeatherLocation>();
//		
//		JsonParser parser = new JsonParser();
//
//		JsonObject jsonObj = (JsonObject)parser.parse(weatherJson);
//		
//		//verify errors 1st
//		JsonObject respObj = jsonObj.getAsJsonObject("response");
//
//		if (respObj.getAsJsonObject("error") != null)
//		{
//			System.out.println("Here");
//			JsonObject errorObj = respObj.getAsJsonObject("error");
//			throw new Exception("Error while retreiving data: " + " Description: " +  errorObj.get("description").getAsString());
//			
//		}		
//		
//		//current location object
//		JsonObject locationObj = jsonObj.getAsJsonObject("location");
//		
//		if (locationObj != null)
//		{
//			//current location object
//			JsonObject nearWetStaObj = locationObj.getAsJsonObject("nearby_weather_stations");
//
//			//
//			//Airport station information
//			//
//
//			JsonObject airportObj = nearWetStaObj.getAsJsonObject("airport");		
//			JsonArray airportArray = airportObj.getAsJsonArray("station");
//
//			for(int i = 0 ; i < airportArray.size() ; i++)
//			{
//				JsonObject airportTxt = airportArray.get(i).getAsJsonObject();
//				WeatherLocation wl = new WeatherLocation();
//				wl.setAirport(true);
//				wl.setCity(airportTxt.get("city").getAsString());
//				wl.setCountry(airportTxt.get("country").getAsString());
//				wl.setLat(airportTxt.get("lat").getAsString());
//				wl.setLon(airportTxt.get("lon").getAsString());
//				wl.setState(airportTxt.get("state").getAsString());
//				wl.setStationId(airportTxt.get("icao").getAsString());
//				wl.setIcao(airportTxt.get("icao").getAsString());
//
//				wetLocArray.add(wl);
//			}
//
//			//
//			//pws information
//			//
//
//			JsonObject pwsObj = nearWetStaObj.getAsJsonObject("pws");		
//			JsonArray pwsArray = pwsObj.getAsJsonArray("station");
//
//			for(int i = 0 ; i < pwsArray.size() ; i++)
//			{
//				JsonObject pwsTxt = pwsArray.get(i).getAsJsonObject();
//				WeatherLocation wl = new WeatherLocation();
//				wl.setAirport(false);
//				wl.setCity(pwsTxt.get("city").getAsString());
//				wl.setCountry(pwsTxt.get("country").getAsString());
//				wl.setLat(pwsTxt.get("lat").getAsString());
//				wl.setLon(pwsTxt.get("lon").getAsString());
//				wl.setNeighborhood(pwsTxt.get("neighborhood").getAsString());
//				wl.setState(pwsTxt.get("state").getAsString());
//				wl.setStationId(pwsTxt.get("id").getAsString());
//
//				wetLocArray.add(wl);
//			}
//		}
//		else
//		{
//			JsonArray resultsArray = respObj.getAsJsonArray("results");
//
//			if (resultsArray != null)
//			{
//				for(int i = 0; i < resultsArray.size() ; i++)
//				{
//					JsonObject locTxt = resultsArray.get(i).getAsJsonObject();
//					WeatherLocation wl = new WeatherLocation();
//					wl.setAirport(false);
////					wl.setOtherLoc(true);
//					wl.setCity(locTxt.get("city").getAsString());
//					wl.setCountry(locTxt.get("country").getAsString());
//					wl.setState(locTxt.get("state").getAsString());
//					wl.setStationId(locTxt.get("zmw").getAsString());
//					wl.setZmw("zmw:"  + locTxt.get("zmw").getAsString());
//					wetLocArray.add(wl);
//				}
//			}
//		}
//		return wetLocArray;
//	}
	/**
	 * New model !!!!!!!!!!
	 * @param forecastJson
	 * @return
	 * @throws JsonSyntaxException
	 */
	public WeatherGenericModel getCompleteForecast(String forecastJson) throws JsonSyntaxException{
		
		WeatherGenericModel wgm = null;
		Gson gson = new Gson();	
		
		CompleteForecast forecast = gson.fromJson(forecastJson,CompleteForecast.class);	
		
		if (forecast != null && forecast.getCurrentObservation() != null && forecast.getForecast() != null){
			wgm = new WeatherGenericModel();
			wgm.setForcastDate(new Date().toString());
			wgm.setLatitude(forecast.getCurrentObservation().getDisplayLocation().getLatitude());
			wgm.setLongitude(forecast.getCurrentObservation().getDisplayLocation().getLongitude());
			wgm.setLocation(forecast.getCurrentObservation().getDisplayLocation().getFull());
			
			
			WeatherCurrentModel wcm = new WeatherCurrentModel();
			wcm.setCurrectTempC((forecast.getCurrentObservation().getTempC() != null ? forecast.getCurrentObservation().getTempC().floatValue() : 0.0f) );
			wcm.setDewPointC(String.valueOf(forecast.getCurrentObservation().getDewpointC()));
			wcm.setFeelsLike(forecast.getCurrentObservation().getFeelslikeC());
			wcm.setHumidity(forecast.getCurrentObservation().getRelativeHumidity());
			wcm.setIconName(forecast.getCurrentObservation().getIcon());
			wcm.setIconUrl(forecast.getCurrentObservation().getIconUrl());
			wcm.setMoonRise(forecast.getMoonPhase().getSunrise().getHour() + ":" + forecast.getMoonPhase().getSunrise().getMinute());
			wcm.setMoonSet(forecast.getMoonPhase().getSunset().getHour() + ":" + forecast.getMoonPhase().getSunset().getMinute());
			wcm.setObservationTime(forecast.getCurrentObservation().getObservationTime());
			wcm.setPrecipLastHour(forecast.getCurrentObservation().getPrecip1hrMetric());
			wcm.setPrecipToday(forecast.getCurrentObservation().getPrecipTodayMetric());
			wcm.setPressureMb(forecast.getCurrentObservation().getPressureMb());
			wcm.setSunRise(forecast.getSunPhase().getSunrise().getHour() + ":"+ forecast.getSunPhase().getSunrise().getMinute());
			wcm.setSunSet(forecast.getSunPhase().getSunset().getHour() + ":"+ forecast.getSunPhase().getSunset().getMinute());
			wcm.setVisibilityKm(forecast.getCurrentObservation().getVisibilityKm());
			wcm.setWeather(forecast.getCurrentObservation().getWeather());
			wcm.setWindChill(forecast.getCurrentObservation().getWindchillC());
			wcm.setWindDirectionText(forecast.getCurrentObservation().getWindDir() + " " + forecast.getCurrentObservation().getWindKph() + " Km/h");
			wcm.setWindGusting(String.valueOf(forecast.getCurrentObservation().getWindGustKph()));
			wcm.setUvIndex(forecast.getCurrentObservation().getUV());
			
			
			List<WeatherForecastModel> wfms = new ArrayList<WeatherForecastModel>();
			boolean next = true;
			int indx = 0;
			Forecastday_ simpFd = null;
			for(int i = 0 ; i <  forecast.getForecast().getTxtForecast().getForecastday().size() ; i ++)
			{
//				System.out.println("1-next : " + next + " loop : " + i);
				Forecastday txtFd = forecast.getForecast().getTxtForecast().getForecastday().get(i);
				
				if (next){
					simpFd = forecast.getForecast().getSimpleforecast().getForecastday().get(indx);
					next = false;
					indx ++;
				}else if (!next){
					next = true;
				}
				WeatherForecastModel wfm = new WeatherForecastModel();
				wfm.setAvgWind(simpFd.getAvewind().getKph());
				wfm.setWindDir(simpFd.getMaxwind().getDir());
				wfm.setDay( (!next ? true : false) );
				wfm.setNight( (next ? true : false) );
				wfm.setDayNumberForWeek(String.valueOf(simpFd.getDate().getDay()));
				wfm.setDayOfWeek(txtFd.getTitle());
			//	wfm.setForcastIssued(forecast.)
				wfm.setForecast(txtFd.getFcttextMetric());
				wfm.setHighTemp(simpFd.getHigh().getCelsius());
				wfm.setIconName(txtFd.getIcon());
				wfm.setIconUrl(txtFd.getIconUrl());
				wfm.setLowTemp(simpFd.getLow().getCelsius());
				wfm.setMaxWind(simpFd.getMaxwind().getKph());
				wfm.setMonth(String.valueOf(simpFd.getDate().getMonth()));				
				wfm.setProbOfRain(txtFd.getPop());
				wfm.setRain(simpFd.getQpfAllday().getMm().shortValue());
				wfm.setRainTotal(simpFd.getQpfAllday().getMm().shortValue());
				if (simpFd.getSnowDay() != null){
					wfm.setSnow( (simpFd.getSnowDay().getCm() != null ? simpFd.getSnowDay().getCm().floatValue() : 0.0f));
				}
				wfm.setSnowTotal(simpFd.getSnowAllday().getCm().floatValue());
			//	wfm.setUvIndex(uvIndex)
				wfm.setWeatherOutlook(simpFd.getConditions());
			//	wfm.setWind(wind)
				
				wfms.add(wfm);
				
			}
			
			wgm.setWeatherCurrentModel(wcm);
			wgm.setWForecastModel(wfms);
			
			if (forecast.getAlerts() != null && forecast.getAlerts() .size() > 0)
			{
			
				WeatherAlert wa = new WeatherAlert();				
				
				wa.setDescription(forecast.getAlerts().get(0).getDescription());
				wa.setMessage(forecast.getAlerts().get(0).getMessage());
			
				wgm.setWeatherAlert(wa);
			}
		}
			
		return wgm;
	}
	
	public List<WeatherLocation> getLocations(String jsonString){

		List<WeatherLocation> wetLocArray = new ArrayList<WeatherLocation>();

		Gson gson = new Gson();	

		FindLocation loc = gson.fromJson(jsonString,FindLocation.class);	

		if (loc != null)
		{
			//
			//Airport station information
			//			
			for(int i = 0 ; i < loc.getLocation().getNearbyWeatherStations().getAirport().getStation().size() ; i++)
			{
				Station st = loc.getLocation().getNearbyWeatherStations().getAirport().getStation().get(i);

				WeatherLocation wl = new WeatherLocation();
				wl.setAirport(true);
				wl.setCity(st.getCity());
				wl.setCountry(st.getCountry());
				wl.setLat(st.getLat());
				wl.setLon(st.getLon());
				wl.setState(st.getState());
				wl.setStationId(st.getIcao());
				wl.setIcao(st.getIcao());

				wetLocArray.add(wl);
			}

			//
			//pws information
			//

			for(int i = 0 ; i < loc.getLocation().getNearbyWeatherStations().getPws().getStation().size() ; i++)
			{				
				WeatherLocation wl = new WeatherLocation();
				Station_ st = loc.getLocation().getNearbyWeatherStations().getPws().getStation().get(i);

				wl.setAirport(false);
				wl.setCity(st.getCity());
				wl.setCountry(st.getCountry());
				wl.setLat(String.valueOf(st.getLat()));
				wl.setLon(String.valueOf(st.getLon()));
				wl.setNeighborhood(st.getNeighborhood());
				wl.setState(st.getState());
				wl.setStationId(st.getId());

				wetLocArray.add(wl);
			}
		}
		//		else
		//		{
		//			JsonArray resultsArray = respObj.getAsJsonArray("results");
		//
		//			if (resultsArray != null)
		//			{
		//				for(int i = 0; i < resultsArray.size() ; i++)
		//				{
		//					JsonObject locTxt = resultsArray.get(i).getAsJsonObject();
		//					WeatherLocation wl = new WeatherLocation();
		//					wl.setAirport(false);
		//					wl.setOtherLoc(true);
		//					wl.setCity(locTxt.get("city").getAsString());
		//					wl.setCountry(locTxt.get("country").getAsString());
		//					wl.setState(locTxt.get("state").getAsString());
		//					wl.setStationId(locTxt.get("zmw").getAsString());
		//					wl.setZmw("zmw:"  + locTxt.get("zmw").getAsString());
		//					wetLocArray.add(wl);
		//				}
		//			}
		//		}
		return wetLocArray;
	}
}
