package com.example.getaddressgps;

import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.ProgressDialog;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button btn;
	TextView tv1,tv2,tv3;
	ProgressDialog pd;
	Location loc1,loc2;
	LocationManager lm;
	Geocoder geocoder;
	double longitude,latitude;
	int i;
	String s="",x="",url;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			btn=(Button) findViewById(R.id.button1);
			tv1=(TextView) findViewById(R.id.textView1);
			tv2=(TextView) findViewById(R.id.textView3);
			tv3=(TextView) findViewById(R.id.textView2);
			lm=(LocationManager) getSystemService(LOCATION_SERVICE);
			loc1=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			loc2=lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		
			btn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					new MyClass().execute();
				}
			});
		}
		public class MyClass extends AsyncTask<String, String, String>
		{

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				if(loc1!=null)
				{
					longitude=loc1.getLongitude();
					latitude=loc1.getLatitude();
					s=getAddress(latitude,longitude);
				}
				if(loc2!=null)
				{
					longitude=loc2.getLongitude();
					latitude=loc2.getLatitude();
					x=getAddress(latitude,longitude);
				}
				return null;
			}

			private String getAddress(double latitude, double longitude) {
				// TODO Auto-generated method stub
			geocoder=new Geocoder(getApplicationContext(),Locale.ENGLISH);
			String ret="";
			try
			{
				List<Address> addresses=geocoder.getFromLocation(latitude, longitude,1);
				if(addresses!=null)
				{
					Address returnaddress=addresses.get(0);
					StringBuilder strreturnaddress=
					new StringBuilder("Address : \n");
					for(i=0;i<returnaddress.getMaxAddressLineIndex();
					i++)
					{
						strreturnaddress.append(returnaddress.
						getAddressLine(i)).append("\n");
					}
					ret=strreturnaddress.toString();
				}
				else
				{
					ret="no address found";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				ret="can't get address";
			}
				return ret;
			}

			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				pd.dismiss();
				tv1.setText(""+s);
				tv2.setText(""+x);
				tv3.setText("Latitude : "+latitude+"\n"+"Longitude : "+longitude);
				
				super.onPostExecute(result);
			}

			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
			pd=new ProgressDialog(MainActivity.this);
			pd.setMessage("PLEASE WAIT.....");
			pd.show();
				super.onPreExecute();
			}
			
		}
	}