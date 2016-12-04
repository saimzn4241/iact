package com.example.autocompletedemo;

import android.R.color;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {

	AutoCompleteTextView actv;
	String ar[]={"c", "c++", "java", "jaa", "cobol", "pascal"};
    ArrayAdapter<String> aa;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actv=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        aa=new ArrayAdapter<String>(MainActivity.this, android.R.layout.select_dialog_item,ar);
        actv.setAdapter(aa);
        actv.setThreshold(2);
        actv.setTextColor(Color.RED);
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
