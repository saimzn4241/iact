package com.example.sliderdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;

public class SecondSlider extends Activity {
	float x1,x2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second_slider);
	}
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
	switch (event.getAction()) {
	case MotionEvent.ACTION_DOWN:
	{
		x1=event.getX();
	}
		break;
	case MotionEvent.ACTION_UP:
	{
		x2=event.getX();
		if(x1<x2)
		{
			Intent i=new Intent(SecondSlider.this,MySlider.class);
			startActivity(i);
		}
		if(x1>x2)
		{
		}
	}
	break;
	default:
		break;
	}
		return super.onTouchEvent(event);
	
	}
}