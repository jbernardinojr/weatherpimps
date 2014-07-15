package br.com.weatherpimps;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class WeatherParser {
	 private static final String WEATHER_API = "api.openweathermap.org/data/2.5/weather?q=";
	 
	 private StringBuilder sb;
	 
	 public WeatherParser (String sCountry, String sCity) {
		 sb = sb.append(WEATHER_API);
		 sb = sb.append(sCity + ",");
		 sb = sb.append(sCountry);
	 }
	 public void getTemparature() {
		 DefaultHttpClient  httpclient = new DefaultHttpClient();
		 HttpPost httppost = new HttpPost(sb.toString());
		 
		 try {
			HttpResponse response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
