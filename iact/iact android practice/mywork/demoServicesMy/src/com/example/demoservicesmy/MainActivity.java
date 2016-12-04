package com.example.demoservicesmy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

Button b1,b2 ,b3;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
	        b1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					startService(new Intent(MainActivity.this, MyService.class));
					
				}
			});
		
	
	    b2.setOnClickListener(new OnClickListener() {
			
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					stopService(new Intent(MainActivity.this, MyService.class));
				}
			});
		
			b3.setOnClickListener(new OnClickListener() {
				
					@Override
					public void onClick(View arg0) {
						startActivity(new Intent(MainActivity.this, SecondActivity.class));
					}
				});
			}


    
}
