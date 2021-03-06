package com.example.sendsms;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText et1,et2;
TextView tv1,tv2;
Button b1;
String number,message;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View arg0) {
				try{
				number=et1.getText().toString();
				message=et2.getText().toString();
			SmsManager sm=SmsManager.getDefault();
			sm.sendTextMessage(number, null, message, null, null);
				Toast.makeText(MainActivity.this,"sms sent..",1).show();
			}
			catch(Exception e){
					e.printStackTrace();
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
