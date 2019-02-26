package net.weather.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

public class Utilities 
{	
	public static Proxy proxy = null;

	public static String readUrl(URL url) throws Exception
	{	
		StringBuffer sb = new StringBuffer();

		HttpURLConnection conn = null;
		
		if (proxy != null)
		{
			conn = (HttpURLConnection)url.openConnection(proxy);
		}
		else
		{
			conn = (HttpURLConnection)url.openConnection();
		}
		
	
		conn.setRequestMethod("GET");
		conn.setUseCaches(false);
		
		if (conn.getResponseCode() == 200)
		{
			BufferedReader br =  new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ( (line = br.readLine() ) != null)
			{
				sb.append(line);
			}
		}
		return sb.toString();
	}

	/**
	 * Return the input stream of a url connection
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static InputStream readUrlAsStream(URL url) throws Exception
	{
		HttpURLConnection  yc = null;
	
		if (proxy != null)
		{
			yc = (HttpURLConnection )url.openConnection(proxy);			
		}
		else
		{
			yc = (HttpURLConnection )url.openConnection();
		}		

		InputStream is = null;
		
		yc.setUseCaches(false);
		
		if (yc.getResponseCode() == 200)
		{
			is = yc.getInputStream();
		}
				
		return is;
	}

	public static int celsiusToFahrenheit(int tempInCelsius)
	{
		return ((tempInCelsius * 9/5) + 32);
	}

	public static int celsiusToFahrenheit(String tempInCelsius)
	{		
		return celsiusToFahrenheit(Integer.parseInt( tempInCelsius )); 
	}

	public static int fahrenheitToCelsius(int tempInFahrenheit)
	{
		return ((tempInFahrenheit - 32) * 5/9);
	}

	public static int fahrenheitToCelsius(String tempInFahrenheit)
	{
		return fahrenheitToCelsius(Integer.parseInt(tempInFahrenheit));
	}
	
	public static String getAbbrMonth(int monthNumber)
	{
		String ret = "";
		switch (monthNumber){
		case 1:
			ret = "Jan";
			break;
		case 2:
			ret = "Feb";
			break;
		case 3:
			ret = "Mar";
			break;
		case 4:
			ret = "Apr";
			break;
		case 5:
			ret = "May";
			break;
		case 6:
			ret = "Jun";
			break;
		case 7:
			ret = "Jul";
			break;
		case 8:
			ret = "Aug";
			break;
		case 9:
			ret = "Sep";
			break;
		case 10:
			ret = "Oct";
			break;
		case 11:
			ret = "Nov";
			break;	
		case 12:
			ret = "Dec";
			break;
		}
		return ret;
	}
	public static void createAuthForProxy(final String user, final String pass)
	{
		Authenticator authenticator = new Authenticator() {

			public PasswordAuthentication getPasswordAuthentication() {
				return (new PasswordAuthentication(user,
						pass.toCharArray()));
			}
		};
		Authenticator.setDefault(authenticator);
	}
	
	public static String getStackTrace(Throwable tr){
		StringWriter sw = new StringWriter();
		tr.printStackTrace(new PrintWriter(sw));
		return sw.toString(); 		
		
	}
	
	public static double findClosestCities(double lat1, double lon1, double cityLat2,double cityLon2) {
		int R = 6371; // km (change this constant to get miles)
		double dLat = (cityLat2-lat1) * Math.PI / 180;
		double dLon = (cityLon2-lon1) * Math.PI / 180;
		double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
			Math.cos(lat1 * Math.PI / 180 ) * Math.cos(cityLat2 * Math.PI / 180 ) *
			Math.sin(dLon/2) * Math.sin(dLon/2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R * c;
		if (d>1) return Math.round(d);
		else if (d<=1) return Math.round(d*1000);
		return d; 
	}
	
	
	
}
