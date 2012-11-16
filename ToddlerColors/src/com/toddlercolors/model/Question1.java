package com.toddlercolors.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Question1 {
	
	private String question;
	private String answer;
	private String option1;
	private String option2;
	private String option3;
	private Bitmap drawable;
	
	public Question1(String question,String answer,String option1,String option2,String option3,Bitmap bitmap)
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
	public String getQuestion() {
		return question;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @return the option1
	 */
	public String getOption1() {
		return option1;
	}

	/**
	 * @return the option2
	 */
	public String getOption2() {
		return option2;
	}

	/**
	 * @return the option3
	 */
	public String getOption3() {
		return option3;
	}

	/**
	 * @return the image
	 */
	public Bitmap getImage() {
		return drawable;
	}


}
