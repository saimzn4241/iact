package com.example.notificationbar;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

 Notification n;
 NotificationManager nm;
 PendingIntent pi;
 Button b;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.button1);
        nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				n=new Notification(R.drawable.ic_launcher, "hi android",System.currentTimeMillis() );
				Intent i=new Intent();
				pi=PendingIntent.getActivity(MainActivity.this,0,i,0,null);
				
				n.setLatestEventInfo(MainActivity.this, "DUCAT" , "u hav new message", pi);
				nm.notify(1,n);
				finish();
			}
		});
	}
	


}
