package com.toddlercolors.main;

import com.example.toddlercolors.R;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Prefs extends PreferenceActivity{
	
	private static final String OPT_MUSIC="music";
	private static final boolean OPT_MUSIC_DEF=true;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
	public static boolean getMusic(Context con)
	{
		return PreferenceManager.getDefaultSharedPreferences(con).getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
	}

}
