package com.example.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

Button bt1;
EditText et1;
EditText et2;

int a,b,c;
@Override
    protected void onCreate(Bundle savedInstanceState) {
	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1=(Button)findViewById(R.id.button1);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        bt1.setOnClickListener(this);
        
        
}
@Override
public void onClick(View arg0) {
	// TODO Auto-generated method stub
	a=Integer.parseInt(et1.getText().toString());
	b=Integer.parseInt(et2.getText().toString());
	c=a+b;
	Toast.makeText(MainActivity.this, "sum of two nos . is= " +c,5 ).show();
}

    
    
    
}
