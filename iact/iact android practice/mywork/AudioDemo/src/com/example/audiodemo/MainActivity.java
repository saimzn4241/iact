package com.example.audiodemo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button b1,b2,b3;
	MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        mp=MediaPlayer.create(MainActivity.this, R.raw.aa);
        b1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				mp.start();
			}
		});
        
    
    b2.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				mp.pause();
			}
		});
        
    
b3.setOnClickListener(new OnClickListener() {
	
		@Override
		public void onClick(View arg0) {
			mp.stop();
			mp=MediaPlayer.create(MainActivity.this, R.raw.aa);
	        
		}
	});
    
    }
    
}
