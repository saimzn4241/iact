package com.example.audiovideorecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.button1 :
			Intent i=new Intent(android.provider.MediaStore.ACTION_VIDEO_CAPTURE);
			startActivityForResult(i,0);
			
		break;
		case R.id.button2 :
			Intent ii=new Intent(android.provider.MediaStore.Audio.Media.RECORD_SOUND_ACTION);
			startActivityForResult(ii,0);
			
		break;
		default:
			break;
		
		}
	}
    
}
