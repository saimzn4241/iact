package com.example.contactsdemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity {
EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.editText1);
        et.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
			startActivityForResult(i,0);
			}
		});
        
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Uri uri=data.getData();
		Cursor cur=getContentResolver().query(uri,null,null,null, null);
		while (cur.moveToNext()) {
			if(Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)))>0)
			{
		Cursor c=getContentResolver().query(Phone.CONTENT_URI,null,
		Phone.CONTACT_ID+"=?", new String[]{
	cur.getString(cur.getColumnIndex(
			ContactsContract.Contacts._ID))},null);
			
				while(c.moveToNext()) {
					String ss;
					ss=c.getString(c.getColumnIndex(Phone.NUMBER));
					et.setText(""+ss);
				}
			}
		}

	}   
}
