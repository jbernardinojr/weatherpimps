package br.com.weatherpimps;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import br.com.weatherpimps.fragments.MyFragmentPagerAdapter;

public class WeatherMainActivity extends FragmentActivity {
	
	private static final String WEATHER_API = "api.openweathermap.org/data/2.5/weather?q=";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);
        /** Getting a reference to the ViewPager defined the layout file */
		ViewPager pager = (ViewPager) findViewById(R.id.pager);

		/** Getting fragment manager */
		FragmentManager fm = getSupportFragmentManager();

		/** Instantiating FragmentPagerAdapter */
		MyFragmentPagerAdapter pagerAdapter = new MyFragmentPagerAdapter(fm);
		//pager.setPageTransformer(true, new ZoomOutPageTransformer());
		/** Setting the pagerAdapter to the pager object */
		pager.setOffscreenPageLimit(2);
		pager.setAdapter(pagerAdapter);
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.weather_main, menu);
        return true;
    }
    
}
