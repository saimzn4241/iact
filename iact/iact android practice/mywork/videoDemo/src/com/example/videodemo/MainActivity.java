package com.example.videodemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
VideoView vv;
//MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  //      mc = new MediaController(MainActivity.this);
    ///    vv.setMediaController(mc);

        vv=(VideoView) findViewById(R.id.videoView1);
       // vv.setMediaController(mc);
        vv.setVideoURI(Uri.parse("android.resourse://"+getPackageName()+"/"+R.raw.aa));
        vv.setMediaController(new MediaController(this));
        //vv.requestFocus();
        vv.start();
     

    }
    

    
}
