package com.example.prefrencessavesdemo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
Button b1,b2;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        tv=(TextView) findViewById(R.id.textView1);
        b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this, SecondActivity.class);
				startActivity(i);
			}
		});
        b2.setOnClickListener(new  OnClickListener() {
			
			public void onClick(View v) {
				showprefinfo();
			}

			private void showprefinfo() {
				SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
				String username=sp.getString("username", "your username is:");
				String pass=sp.getString("password","your password is:");
				boolean checkbox=sp.getBoolean("checkbox",false);
				String listprefs=sp.getString("list1","your language is:");
				StringBuilder sb=new StringBuilder();
				sb.append("username: "+username+"\n");
				sb.append("password: "+pass+"\n");
				sb.append("keep me logged in :"+String.valueOf(checkbox)+"\n");
				sb.append("list prefrences  :"+listprefs);
				tv.setText(sb.toString());
				
			}
		});
    }
   
}
