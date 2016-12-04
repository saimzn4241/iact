package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et1,et2;
	Button b1,b2;
	String username,password;
	Bundle b;
	SQLiteDatabase sq;
	TextView t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t3=(TextView) findViewById(R.id.textView3);
        t3.setText("");
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);
        sq=openOrCreateDatabase("logindb", Context.MODE_PRIVATE, null);
		String q1="create table if not exists mytable (username varchar , password varchar, email varchar);";
		sq.execSQL(q1);
		
        sq=openOrCreateDatabase("logindb", Context.MODE_PRIVATE,null);
        if(getIntent().getExtras()!=null){
        b=getIntent().getExtras();
    	
        if( b.getInt("key")==1){
        	Toast.makeText(MainActivity.this, "signup successful", 1).show();
        	t3.setText("signup Successful");
        	}
        }
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
			username=et1.getText().toString();
			password=et2.getText().toString();
			if(username.equals("")|| password.equals(""))
			{
				Toast.makeText(MainActivity.this, "input is required",1).show();	
			}
			else{
			String q="Select * from mytable where username='"+username+"' and password='"+password+"' ;";
			Cursor c=sq.rawQuery(q,null);
			if(c.moveToNext()){
				Intent i=new Intent(MainActivity.this, SecondActivity.class);
				startActivity(i);
			
			}
			else{
				Toast.makeText(MainActivity.this, "invalid username or password",1).show();			
			}
			
			
			}}
		});
        b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
		Intent i=new Intent(MainActivity.this,ThirdActivity.class );
		startActivity(i);
			}
		});
    }


}
