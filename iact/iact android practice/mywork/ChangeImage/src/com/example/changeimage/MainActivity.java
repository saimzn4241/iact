package com.example.changeimage;

import java.io.IOException;
import java.lang.reflect.Field;

import android.app.Activity;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {
	 Button b1, b2;
	 Handler h;
 int i=0;
//int str[]={R.drawable.aa,R.drawable.bb,R.drawable.cc,
	//	   R.drawable.dd,R.drawable.ee,R.drawable.ff};
	 
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.activity_main);
	       h=new Handler();
	       Button b1 = (Button)findViewById(R.id.button1);
	      final Button b2 = (Button)findViewById(R.id.button2);
	      Field[] Id_Fields=R.drawable.class.getFields(); 
	     final int []str=new int[Id_Fields.length];
	      try{
	      for(i=0;i<Id_Fields.length;i++)
	    	  str[i]=Id_Fields[i].getInt(null);
	      }
	      catch(Exception e){
	    	  e.printStackTrace();
	    	  
	      }
	      
	      b1.setOnClickListener(new Button.OnClickListener(){

	   @Override
	   public void onClick(View arg0) {
	    // TODO Auto-generated method stub
	    final WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
	    	h.postDelayed(new  Runnable() {
				public void run() {
					try {
						myLoop();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				private void myLoop() throws IOException {
					// TODO Auto-generated method stub
					 b2.setOnClickListener(new Button.OnClickListener(){

						   @Override
						   public void onClick(View arg0) {
							   
							   MainActivity.this.finish();
							   System.exit(0);
						   }
						   
						       });
					if(i==str.length)
					{
						i=0;
					}
					myWallpaperManager.setResource(str[i]);
					i++;
					h.postDelayed(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								myLoop();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}, 2000);
				}
			}, 2000);
	    
	    
	    
	    
	   }
	   });

	      
	   
	   
	   
	   }
	}