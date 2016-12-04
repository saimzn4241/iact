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
import android.widget.Toast;

public class ThirdActivity extends Activity {
EditText et1, et2, et3, et4;
SQLiteDatabase sq;
Button b1;
String password1="", password="" , username="", email="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		b1=(Button) findViewById(R.id.button1);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		et4=(EditText) findViewById(R.id.editText4);
		
		sq=openOrCreateDatabase("logindb", Context.MODE_PRIVATE, null);
		String q1="create table if not exists mytable (username varchar , password varchar, email varchar);";
		sq.execSQL(q1);
			
		b1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
		
				username=et1.getText().toString();
				password=et2.getText().toString();
				password1=et3.getText().toString();
				email=et4.getText().toString();
				
				if(username.equals("")||password.equals("")||email.equals("")||password1.equals("") ){
					Toast.makeText(ThirdActivity.this, "input is required",1).show();
					
				}
				else if(!password1.equals(password)){
					Toast.makeText(ThirdActivity.this, "re-enter ur password",1).show();
					
					
				}
				
				else{
					String q1,q2,q="Select * from mytable where username='"+username+"';";
					Cursor c=sq.rawQuery(q,null);
					if(c.moveToNext())
					{
						Toast.makeText(ThirdActivity.this, "username already exists.",1).show();
						
					}
					else{
					username=et1.getText().toString();
					password=et2.getText().toString();
					email=et4.getText().toString();
					q2="insert into mytable  values('"+username+"','"+password+"','"+email+"');";
					sq.execSQL(q2);
					
					Intent i=new Intent(ThirdActivity.this,MainActivity.class);
					i.putExtra("key", 1);
					startActivity(i);
				}}
			}
		});
		
	}


}
