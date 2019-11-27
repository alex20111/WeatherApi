package net.weather.readers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import net.weather.bean.WeatherAlert;
import net.weather.bean.WeatherCurrentModel;
import net.weather.bean.WeatherForecastModel;
import net.weather.bean.WeatherGenericModel;
import net.weather.darksky.Alert;
import net.weather.darksky.Currently;
import net.weather.darksky.Daily;
import net.weather.darksky.DarkSky;
import net.weather.darksky.Datum__2;

public class DarkSkyReader {

	public WeatherGenericModel generateModel(String content) {
		Gson g = new Gson();
		DarkSky p = g.fromJson(content, DarkSky.class);
		
		ZoneId timeZone =  ZoneId.of(p.getTimezone());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm.ss");
	
		WeatherGenericModel wgm = new WeatherGenericModel();
		wgm.setForcastDate(LocalDateTime.now().format(formatter));
		wgm.setTimezone(p.getTimezone());
		
		
		Currently curr = p.getCurrently();
		WeatherCurrentModel wcm = new WeatherCurrentModel();
		wcm.setCurrTemp(curr.getTemperature() != null? curr.getTemperature().floatValue(): 0.0f);
		wcm.setUvIndex(curr.getUvIndex() != null ? String.valueOf(curr.getUvIndex()) : "0");
		LocalDateTime currObs = LocalDateTime.ofInstant(Instant.ofEpochSecond(p.getCurrently().getTime() ),timeZone);		
		wcm.setObservationTime(currObs.format(formatter));
		wcm.setSummary(curr.getSummary());
		wcm.setHumidity(curr.getHumidity() != null ? String.valueOf(curr.getHumidity()) : "0");
		wcm.setDewPointC(String.valueOf(curr.getDewPoint()));
		wcm.setIconName(curr.getIcon());;
		wcm.setFeelsLike(curr.getApparentTemperature() != null ? String.valueOf(curr.getApparentTemperature()) : "N/A");
		wcm.setWindDirectionText(curr.getWindBearing() != null ? String.valueOf(curr.getWindBearing()) : "N/A");
		wcm.setWindGusting(curr.getWindGust() != null ? String.valueOf(curr.getWindGust()) : "N/A");
		wcm.setPrecipIntensity(String.valueOf(curr.getPrecipIntensity()));
		wcm.setPrecipProbability(String.valueOf(curr.getPrecipProbability()));
		wcm.setPressureMb(String.valueOf(curr.getPressure()));
		wcm.setVisibility(String.valueOf(curr.getVisibility()));
		wcm.setNearestStormDistance(String.valueOf(curr.getNearestStormDistance()));
		wcm.setWindSpeed(String.valueOf(curr.getWindSpeed()));
		wcm.setNearestStormBearing(String.valueOf(curr.getNearestStormBearing()));
		
		Daily daily = p.getDaily();
		
		List<WeatherForecastModel> wfms = new ArrayList<WeatherForecastModel>();
		
		
		
		for (Datum__2 f: daily.getData()) {
			WeatherForecastModel wfm = new WeatherForecastModel();
			LocalDateTime forecastTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(f.getTime() ),timeZone);
			
			wfm.setHighTemp(String.valueOf(f.getTemperatureHigh()));
			wfm.setForecast(f.getSummary());
			wfm.setLowTemp(String.valueOf(f.getTemperatureLow()));
			String dayOfWeek = forecastTime.getDayOfWeek().name().toLowerCase();
			wfm.setDayOfWeek(dayOfWeek.substring(0,1).toUpperCase() + dayOfWeek.substring(1));
			wfm.setIconName(f.getIcon());
			
			wfms.add(wfm);
			
		}
		
		wgm.setWForecastModel(wfms);
		
		
		//TODO re-do alerts
		if (p.getAlerts() != null && p.getAlerts().size() > 0) {
			WeatherAlert alerts = new WeatherAlert();
			for(Alert al : p.getAlerts()) {
				alerts.setMessage("allo");
				alerts.setDescription(al.getDescription());
			}
		}
		
		
		wgm.setWeatherCurrentModel(wcm);
		
		return wgm;
	}
}
