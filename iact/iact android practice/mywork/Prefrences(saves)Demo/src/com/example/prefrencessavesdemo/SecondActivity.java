package com.example.prefrencessavesdemo;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class SecondActivity extends PreferenceActivity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
	
	}

}
