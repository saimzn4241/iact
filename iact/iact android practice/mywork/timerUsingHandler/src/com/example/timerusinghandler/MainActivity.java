package com.example.timerusinghandler;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv;
	Handler h;
	int i=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView) findViewById(R.id.textView1);
        h=new Handler();
        h.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				myLoop();
			}

			private void myLoop() {
				// TODO Auto-generated method stub
				i++;
				tv.setText(""+i);
				h.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						myLoop();
					}
				}, 2000);
			}
		}, 2000);
    }

}
