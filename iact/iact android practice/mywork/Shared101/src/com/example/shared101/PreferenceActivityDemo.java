package com.example.shared101;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferenceActivityDemo extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefs);
	}

}