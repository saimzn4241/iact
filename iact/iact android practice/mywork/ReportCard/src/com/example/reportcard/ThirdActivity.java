package com.example.reportcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	
	TextView t1;
	TextView t2;
	TextView t3;
	TextView t4;
	TextView t5;
	TextView t6;
	double overall, coa, ids , dbms ,oops, sum ;
	
	Bundle b;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_third);
	t1=(TextView)findViewById(R.id.textView7);
	t2=(TextView)findViewById(R.id.textView8);
	t3=(TextView)findViewById(R.id.textView9);
	t4=(TextView)findViewById(R.id.textView10);
	t5=(TextView)findViewById(R.id.textView11);
	t6=(TextView)findViewById(R.id.textView12);
	b=getIntent().getExtras();
	
	coa=b.getDouble("coa");
	oops=b.getDouble("oops");
	dbms=b.getDouble("dbms");
	ids=b.getDouble("ids");
	
	//t1.setText(""+b.getString("coa").toString());
	t1.setText(String.valueOf(coa));
	t2.setText(String.valueOf(oops));
	t3.setText(String.valueOf((dbms*100)/70));
	t4.setText(String.valueOf((ids*100)/50));
	
	sum=coa+oops+dbms+ids;
	t5.setText(String.valueOf(sum));
	t6.setText(String.valueOf((sum*100)/320));
	
	
	
	}
	

}
