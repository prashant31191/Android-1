package com.toddlercolors.main;

import java.util.List;

import com.example.toddlercolors.R;
import com.toddlercolors.model.*;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class VeggiesAndColors extends Activity {
	
	private Context mcontext;
	private Questions quest = new Questions();
	//private RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
	final static String index="currentindex";
	final static String radio="radioButton";
	final static String nextV="nextVisibility";
	//private Button button = (Button) findViewById(R.id.next);
	


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quest.addGame2Questions();
        setContentView(R.layout.play_game1);
       //Log.i("savedinstance","i"+index);
       //Log.i("s","i"+savedInstanceState.getInt(index));
       if(savedInstanceState!= null)
       {//Log.i("s","i");
	       quest.setCurrentIndex(savedInstanceState.getInt(index));
	       setQuestion();
	       //RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
	    	//rgrp.check(savedInstanceState.getInt(radio));
	       setRadioButton(savedInstanceState);
	       setNextVisibility(savedInstanceState);
       }
       else
       {Button button = (Button) findViewById(R.id.next);
    	   nextClick(button);     
       }
       addListenerOnNextButton();
       checkAnswer();
       
    }
    
    public void setNextVisibility(Bundle savedInstanceState) {
    	Button button = (Button) findViewById(R.id.next);
    	button.setVisibility(savedInstanceState.getInt(nextV));
		
	}

	public void setRadioButton(Bundle savedInstanceState) {
		
    	RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
    	if(savedInstanceState.getInt(radio) != -1)
    		rgrp.check(savedInstanceState.getInt(radio));
	}

	/*public void setFinish() {
		
    	Button button = (Button) findViewById(R.id.next);
    	button.setText("Well played, finish game!");
	}*/

	@Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
    	//Log.i("i","in"+quest.getCurrentIndex());
		RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
		Button button = (Button) findViewById(R.id.next);
        savedInstanceState.putInt(index,quest.getCurrentIndex());
        savedInstanceState.putInt(radio,rgrp.getCheckedRadioButtonId());
        savedInstanceState.putInt(nextV,button.getVisibility());
        
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    
  /*  public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);
       Log.i("savedinstance","i"+savedInstanceState);
        // Restore state members from saved instance
        quest.setCurrentIndex(savedInstanceState.getInt(index));
        
    }*/
    

    public void checkAnswer()
    {
    	Log.i("onckec","listen");
       RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
        
    	rgrp.setOnCheckedChangeListener(new OnCheckedChangeListener() 
    	    {
    		

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					group = (RadioGroup) findViewById(R.id.group1);
					Button button = (Button) findViewById(R.id.next);
					checkedId = group.getCheckedRadioButtonId();
					Log.i("check","c1"+checkedId);
					if((checkedId != -1))
					{
						RadioButton radiobutton = (RadioButton)findViewById(checkedId);
						Log.i("check","c2"+checkedId);
						if (radiobutton.isChecked())//Bug 4875
						{
							// TODO Auto-generated method stub
							if(radiobutton.getText() ==  getString(quest.getcurrentQuestion().getAnswer()))
							{
								(Toast.makeText(getApplicationContext(), "Yippie! Your answer is correct!", Toast.LENGTH_SHORT)).show();
								if(quest.getCurrentIndex() == quest.getQuestions().size()-1)
									button.setVisibility(View.INVISIBLE);
								else
									button.setVisibility(View.VISIBLE);
							}
							else
							{
								(Toast.makeText(getApplicationContext(), "Oops! Try again,your answer is incorrect.", Toast.LENGTH_SHORT)).show();
								button.setVisibility(View.INVISIBLE);
							}
						}
						
					}
					
				}
    	    });
    }

    
	public void addListenerOnNextButton() {
 
		
		//Button buttonb = (Button) findViewById(R.id.back);
		Button button = (Button) findViewById(R.id.next);
		button.setOnClickListener(new OnClickListener() {
			
 
			@Override
			public void onClick(View arg0) {
				Log.i("listen","nxt");
				
				//if(quest.getCurrentIndex()!=quest.getQuestions().size())
				{
				
				nextClick(arg0);
				
				}
				
			}
		});
		
		/*buttonb.setOnClickListener(new OnClickListener() {
			 
			@Override
			public void onClick(View arg0) {
				backClick(arg0);
			}
		});*/
 
	}
	public void setQuestion()
	{		
	Question nextQues = quest.getcurrentQuestion();
	((ImageView) findViewById(R.id.img1)).setImageResource(nextQues.getImage());
	((TextView) findViewById(R.id.question)).setText(nextQues.getQuestion());
	((TextView) findViewById(R.id.answer1)).setText(nextQues.getOption1());
	((TextView) findViewById(R.id.answer2)).setText(nextQues.getOption2());
	((TextView) findViewById(R.id.answer3)).setText(nextQues.getOption3());
		
	}
	
	public void nextClick(View v)
	{//int size = quest.getCurrentIndex();
		
		
		Log.i("test","nextClick"+v);
		 RadioGroup rgrp = (RadioGroup) findViewById(R.id.group1);
		 Button button = (Button) findViewById(R.id.next);
		 /*if(button.getText() == "Well played,finish game!")
		 {
			 finish();
		 }*/
		 Log.i("test","grp");
		rgrp.clearCheck();
		Log.i("test","clear");
		button.setVisibility(View.INVISIBLE);
		quest.moveNext();
		/*if(quest.getCurrentIndex() == quest.getQuestions().size()-1)
	       {setFinish();}*/
		Log.i("test","movenext");
		setQuestion();
		
	}
	
	public void backClick(View v)
	{
	/*((Button) findViewById(R.id.back)).setVisibility(View.VISIBLE);
	((ImageView) findViewById(R.id.img1)).setImageResource(R.drawable.tomato);
	((TextView) findViewById(R.id.question)).setText(R.string.question2);
	((TextView) findViewById(R.id.answer1)).setText(R.string.qans2);
	((TextView) findViewById(R.id.answer2)).setText(R.string.qans3);
	((TextView) findViewById(R.id.answer3)).setText(R.string.qans1);*/
		
	}

}
