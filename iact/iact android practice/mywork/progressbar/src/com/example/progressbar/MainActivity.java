package com.example.progressbar;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	ProgressDialog pd;
	int progress=0;
	int filesize=0;
	Button b1;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=(Button) findViewById(R.id.button1);
    b1.setOnClickListener(this);
    
    
    }



	@Override
	public void onClick(View a) {
		// TODO Auto-generated method stub
		if(a.getId()==R.id.button1)
		{
			pd=new ProgressDialog(MainActivity.this);
			pd.setTitle("iact edu");
			pd.setMessage("loading, please wait....");
			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd.show();
			
			//Thread t1=new Thread();
			
			new Thread(
			new Runnable()
			{
			
			
					
					
				public void run(){
					while(progress<100)
					{
						progress=doSomeTask();
						try{
							Thread.sleep(100);
							pd.setProgress(progress);pd.setProgress(progress);
							}
						catch(InterruptedException e)
						{
							e.printStackTrace();
							pd.setProgress(progress);
						}
					}
					pd.dismiss();
					
					
				}
			
				private int doSomeTask(){
					filesize++;
					return filesize;
				}
				
			}).start();
			
		}
		
	}
    
}
