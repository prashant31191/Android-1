package com.toddlercolors.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Question {
	
	private int question;
	private int answer;
	private int option1;
	private int option2;
	private int option3;
	private int drawable;
	
	public Question(int question,int answer,int option1,int option2,int option3,int bitmap)
	{
		this.question = question;
		this.answer = answer;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.drawable = bitmap;
	}
	
	/**
	 * @return the question
	 */
	public int getQuestion() {
		return question;
	}

	/**
	 * @return the answer
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * @return the option1
	 */
	public int getOption1() {
		return option1;
	}

	/**
	 * @return the option2
	 */
	public int getOption2() {
		return option2;
	}

	/**
	 * @return the option3
	 */
	public int getOption3() {
		return option3;
	}

	/**
	 * @return the image
	 */
	public int getImage() {
		return drawable;
	}


}
