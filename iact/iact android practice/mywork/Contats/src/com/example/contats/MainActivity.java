package com.example.contats;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button b1;
	

String name[]={	"a", "b" , "c" ,"d" ,"e"};
String number[]={	"123", "234" , "345" ,"456" ,"567"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        
    }




	@Override
	public void onClick(View aa) {
		if(aa.getId()==R.id.button1){
			Intent ii=new Intent(MainActivity.this, SecondActivity.class);
			
			////////////
			

			for(int i=0;i<name.length;i++)
			{
				String x="number";
				String xx="name";
				
				x=x+i;
				xx=xx+i;
				//Toast.makeText(this, ""+xx, 1).show();
				ii.putExtra(x, number[i]);
				ii.putExtra(xx, name[i]);
				
			}
			ii.putExtra("length", name.length);
			startActivity(ii);
				
				
			
				
		}
			
	}
    
}
