package com.example.sqldatabase;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText et1, et2;
SQLiteDatabase sq;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);
        sq=openOrCreateDatabase("mydb", Context.MODE_PRIVATE,null);
        b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				try
				{
		
				int id;
				String name, q1,q2;
				id=Integer.parseInt(et2.getText().toString());
				name=et1.getText().toString();
				q1="create table if not exists mytable(id number , name varchar); ";
				q2="insert into mytable(id ,name) values('"+id+"','"+name+"');";
				
				sq.execSQL(q1);
				sq.execSQL(q2);
				Toast.makeText(MainActivity.this, "data saved", 2).show();
			}
				catch (Exception e) {
					// TODO: handle exception
				e.printStackTrace();
				}}
		});
        
    }
    
    
}
