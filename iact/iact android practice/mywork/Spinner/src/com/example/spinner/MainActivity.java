package com.example.spinner;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	Spinner sp;
	String ar[]={"on", "two", "three", "four","....."};
    ArrayAdapter<String> aa;
    
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=(Spinner) findViewById(R.id.spinner1);
        aa=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,ar);
        sp.setAdapter(aa);
        
    
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
