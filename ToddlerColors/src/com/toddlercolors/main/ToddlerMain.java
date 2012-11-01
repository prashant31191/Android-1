package com.toddlercolors.main;


import com.example.toddlercolors.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ToddlerMain extends Activity {
	
    public void buttonClick(View v)
    {
    	switch(v.getId())
        {
        case R.id.about:
     	   Intent i = new Intent(ToddlerMain.this,AboutToddlerColors.class);
     	   startActivity(i);
     	   break;
     	   
        }
    }

    	@Override
    	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toddler_main);
        
     //Set up click listeners for all buttons
        Button color_game1 = (Button)findViewById(R.id.color_game1);
        Button color_game2 = (Button)findViewById(R.id.color_game2);
        Button color_game3 = (Button)findViewById(R.id.color_game3);
        Button about = (Button)findViewById(R.id.about);
        
        about.setOnClickListener( new View.OnClickListener() {       
        public void onClick(View v) {
            buttonClick(v); }  
        });
        
        color_game1.setOnClickListener( new View.OnClickListener() {       
            public void onClick(View v) {
                buttonClick(v); }  
            });
        
        color_game2.setOnClickListener( new View.OnClickListener() {       
            public void onClick(View v) {
                buttonClick(v); }  
            });
        
        color_game3.setOnClickListener( new View.OnClickListener() {       
            public void onClick(View v) {
                buttonClick(v); }  
            });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_toddler_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch(item.getItemId()){
    	case R.id.menu_settings:
    		startActivity(new Intent(this,Prefs.class));
    		return true;
    	}
    	return false;
    }
}
