package com.example.intentapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

Button bt1;

@Override
    protected void onCreate(Bundle savedInstanceState) {
	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.button1);
        bt1.setOnClickListener(this);
        
        
}
@Override
public void onClick(View arg0) {
//	Toast.makeText(MainActivity.this, "found" ,1).show();
	Intent i=new Intent(MainActivity.this,SecondActivity.class);
	startActivity(i);
}
}
