package com.toddlercolors.model;

import com.toddlercolors.main.Prefs;

import android.content.Context;
import android.media.MediaPlayer;

public class Music {
	
	private static MediaPlayer mp = null;
	
	public static void play(Context con,int res){
		stop(con);
		
		if(Prefs.getMusic(con)){
		mp = MediaPlayer.create(con, res);
		mp.setLooping(true);
		mp.start();}
		
	}
	
	public static void stop(Context con)
	{
		if(mp!=null)
		{
			mp.stop();
			mp.release();
			mp=null;
		}
	}
	
	

}
