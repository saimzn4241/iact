package com.example.animationtextclocwiserotatecanvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class MainActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GraphicsView(this));
	}

    public class GraphicsView extends View {
String s="my animation ..this is animation..";
RotateAnimation ra;


		public GraphicsView(Context context) {
			super(context);
			}
		private void createAnimation(Canvas c) {
			// TODO Auto-generated method stub
			ra=new RotateAnimation(-180,180,c.getWidth()/2,c.getHeight()/2);
			ra.setRepeatCount(Animation.INFINITE);
			ra.setDuration(2000L);
			startAnimation(ra);
			
		}
		@Override
				protected void onDraw(Canvas canvas) {
					// TODO Auto-generated method stub
					if(ra==null){
						createAnimation(canvas);
					}
					Path p=new Path();
					int x=canvas.getWidth()/2;
					int y=canvas.getHeight()/2;
					int radius=Math.min(x,y);
					p.addCircle(x, y, radius,Direction.CW);
					//cw clock-wise
					Paint color = new Paint();
					color.setTextSize(40);
					color.setColor(Color.BLUE);
					canvas.drawTextOnPath(s, p, 0,60, color);
					super.onDraw(canvas);
		}
		
		

	}    }
    

    

