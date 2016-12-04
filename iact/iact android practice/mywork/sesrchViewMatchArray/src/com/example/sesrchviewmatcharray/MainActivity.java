package com.example.sesrchviewmatcharray;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity {
SearchView sv;
String ar[]={"delhi", "mumbai", "kolkata", "pune","panaji"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sv=(SearchView) findViewById(R.id.searchView1);
        sv.setQueryHint("***search*****");
        sv.setOnQueryTextListener(new OnQueryTextListener() {
			
			int flag=0;
			public boolean onQueryTextSubmit(String a) {
				for(int i=0;i<ar.length;i++)
				{
					flag=0;
					if(ar[i].equals(a))
					{
						Toast.makeText(MainActivity.this, "found",1).show();
						Toast.makeText(MainActivity.this, ""+a.toUpperCase(),1).show();
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
					Toast.makeText(MainActivity.this, "not found",1).show();
					
				}
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String arg0) {
				// TODO Auto-generated method stub
				return false;
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
