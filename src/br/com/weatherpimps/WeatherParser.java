package br.com.weatherpimps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

public class WeatherParser extends AsyncTask<URI, Void, Void> {
	 
	 protected Void doInBackground(URI... urls) {
		 DefaultHttpClient  httpclient = new DefaultHttpClient();
		 HttpGet httpGet = new HttpGet(urls[0]);
		 StringBuilder builder = new StringBuilder();
		 try {
			HttpResponse response = httpclient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                    HttpEntity entity = response.getEntity();
                    InputStream content = entity.getContent();
                    BufferedReader reader = new BufferedReader(
                                    new InputStreamReader(content));
                    String line;
                    while ((line = reader.readLine()) != null) {
                            builder.append(line);
                    }
                    Log.v("Getter", "Your data: " + builder.toString()); //response data
            } else {
                    Log.e("Getter", "Failed to download file");
            }
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	 }
}
