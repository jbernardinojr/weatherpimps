package br.com.weatherpimps;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WeatherMainActivity extends Activity {
	
	private static final String WEATHER_API = "api.openweathermap.org/data/2.5/weather?q=";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather_main, menu);
        return true;
    }
    
}
