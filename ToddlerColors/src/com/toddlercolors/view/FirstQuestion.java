/*import android.widget.ImageView;
import android.widget.TextView;

import com.example.toddlercolors.R;

package com.toddlercolors.view;

import com.toddlercolors.model.Question;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;


public class FirstQuestion extends View {

	Question q;
	
   
    public FirstQuestion(Context context) {
        super(context);
        //setFocusableInTouchMode(true);
    }

    public FirstQuestion(Context context, AttributeSet attrs) {
        super(context, attrs);
        //setFocusableInTouchMode(true);
    }


    public FirstQuestion(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
       // setFocusableInTouchMode(true);
    }


    public void init(String firstq) { 
    ((ImageView) findViewById(R.id.img1)).setImageResource();
	((TextView) findViewById(R.id.question)).setText(firstq);
	((TextView) findViewById(R.id.answer1)).setText();
	((TextView) findViewById(R.id.answer2)).setText();
	((TextView) findViewById(R.id.answer3)).setText();
    	/*this.q = firstq;
    	this.opt1 = opt1;
    	this.opt2 = opt2;
    	this.opt3 = opt3;
    	this.img = img;*/
    	//android:src="@drawable/apple"
    	//android:text="@string/question1"
    	// android:text="@string/qans1" 
    	// android:text="@string/qans2" 
    	//android:text="@string/qans3" 
  /*  	
    }

    }*/
