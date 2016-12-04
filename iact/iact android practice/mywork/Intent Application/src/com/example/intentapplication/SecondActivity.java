package com.example.intentapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class SecondActivity extends Activity implements OnClickListener {

Button bt1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		bt1=(Button)findViewById(R.id.button1);
        bt1.setOnClickListener(this);
        
	}

	@Override
	public void onClick(View arg0) {
		
		Intent i=new Intent(SecondActivity.this,ThirdActivity.class);
		startActivity(i);
	}
}
