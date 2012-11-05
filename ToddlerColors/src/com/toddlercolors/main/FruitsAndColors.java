package com.toddlercolors.main;

import com.example.toddlercolors.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitsAndColors extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game1);
        addListenerOnButton();
    }
    
	public void addListenerOnButton() {
 
		Button button = (Button) findViewById(R.id.next);
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
			((Button) findViewById(R.id.back)).setVisibility(View.VISIBLE);
			((ImageView) findViewById(R.id.img1)).setImageResource(R.drawable.tomato);
			((TextView) findViewById(R.id.question)).setText(R.string.question2);
			((TextView) findViewById(R.id.answer1)).setText(R.string.qans2);
			((TextView) findViewById(R.id.answer2)).setText(R.string.qans3);
			((TextView) findViewById(R.id.answer3)).setText(R.string.qans1);}
		});
 
	}

}
