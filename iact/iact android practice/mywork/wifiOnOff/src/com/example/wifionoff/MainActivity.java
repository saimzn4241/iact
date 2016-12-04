package com.example.wifionoff;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Button b1, b2;
WifiManager wm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        wm=(WifiManager) getSystemService(WIFI_SERVICE);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				wm.setWifiEnabled(true);
				
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			
    			@Override
    			public void onClick(View arg0) {
    				wm.setWifiEnabled(false);
    				
    			}
    		});
            
    }


}
