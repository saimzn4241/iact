package com.example.gpsdemo1;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn;
	TextView tv,tv2;
	LocationManager lm;
	Location loc,loc2;
	double lat,lon,lat2,lon2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button1);
        tv=(TextView) findViewById(R.id.textView1);
        tv2=(TextView) findViewById(R.id.textView2);
        lm=(LocationManager) getSystemService(LOCATION_SERVICE);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				loc=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				loc2=lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				if(loc!=null){
					lat=loc.getLatitude();
					lon=loc.getLongitude();
					tv.setText("gps:\n Latitude:" +lat+ "\n longitute="+lon );
					
				}
				else{
					tv.setText("gps  no gps found");
				}
				
				
				if(loc2!=null){
					lat=loc2.getLatitude();
					lon=loc2.getLongitude();
					tv2.setText("gps:\n Latitude:" +lat+ "\n longitute="+lon );
					
				}
				else{
					tv2.setText("network no gps found");
				}
				
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
