package com.toddlercolors.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.toddlercolors.R;
import com.toddlercolors.model.Question;


/** A list of questions. 
 * @param <Question>*/
public class Questions<Question> {
 

    private List<Question> ques = new ArrayList<Question>();
    private final List<Question> safeQues = Collections.unmodifiableList(ques);
    private Context mcontext;
    private int currentindex = -1;


    public Questions() {
		// TODO Auto-generated constructor stub
	}

	public List<Question> getQuestions() { return safeQues; }
    
    public int getCurrentIndex(){return currentindex;}
    
    public void setCurrentIndex(int index){currentindex = index ;}
    
    public void moveNext()
    {//System.out.println("mveNext");
    	
    	if((ques.size()>0) && (ques.listIterator().hasNext()) && (currentindex <(ques.size()-1)))
    	{
    		Log.i("moveNext","index"+currentindex);
    		currentindex= currentindex + 1;
    		Log.i("moveNextafter","index"+currentindex);
    		//ques.listIterator().next();
    		//System.out.println("iterator"+ques.listIterator().next());
    		//Log.i("moveNextquestion",(ques.listIterator().next().toString()));
    	}
    	else
    		{
    		
    		Log.i("could not move next","index"+currentindex);
    		
    		}
    	
    }
    
    public com.toddlercolors.model.Question getcurrentQuestion()
    {
    	
    	return (com.toddlercolors.model.Question)ques.get(currentindex);
    }


   // @SuppressWarnings("unchecked")
	/*public void addQuestion(String q1,String a1,String o1,String o2,String o3,Bitmap im) 
    {
    	Question qa1 = (Question) new com.toddlercolors.model.Question(q1,a1,o1,o2,o3,im);
 //R.string.question1,R.string.qans1,R.string.qans1,R.string.qans2,R.string.qans3,R.drawable.apple
    	
    	ques.add(qa1);
    }*/
    
   public void addGame1Questions()
    {
    	/*Question qa1 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
    				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
    				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());
    
    	Question qa2 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.tomato)).getBitmap());
    	
    	Question qa3 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());
    	
    	Question qa4 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.tomato)).getBitmap());
    	
    	Question qa5 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());	
   */ 	Question qa1 = (Question) new com.toddlercolors.model.Question(R.string.question1,R.string.qans1,R.string.qans3,R.string.qans2,R.string.qans1,R.drawable.apple);
    	Question qa2 = (Question) new com.toddlercolors.model.Question(R.string.question2,R.string.qans4,R.string.qans4,R.string.qans3,R.string.qans1,R.drawable.banana);
    	Question qa3 = (Question) new com.toddlercolors.model.Question(R.string.question3,R.string.qans2,R.string.qans1,R.string.qans2,R.string.qans3,R.drawable.grapes);
    	Question qa4 = (Question) new com.toddlercolors.model.Question(R.string.question4,R.string.qans3,R.string.qans3,R.string.qans1,R.string.qans2,R.drawable.kiwi);
    	Question qa5 = (Question) new com.toddlercolors.model.Question(R.string.question5,R.string.qans5,R.string.qans1,R.string.qans5,R.string.qans3,R.drawable.orange);
    	
    	ques.add(qa1);
    	ques.add(qa2);
    	ques.add(qa3);
    	ques.add(qa4);
    	ques.add(qa5);
    }
   
   public void addGame2Questions()
   {
   	/*Question qa1 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
   				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
   				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());
   
   	Question qa2 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.tomato)).getBitmap());
   	
   	Question qa3 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());
   	
   	Question qa4 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.tomato)).getBitmap());
   	
   	Question qa5 = (Question) new com.toddlercolors.model.Question(mcontext.getString(R.string.question1),mcontext.getString(R.string.qans1),mcontext.getString(R.string.qans1),
				mcontext.getString(R.string.qans2),mcontext.getString(R.string.qans3),
				((BitmapDrawable) mcontext.getResources().getDrawable(R.drawable.apple)).getBitmap());	
  */ 	Question qa1 = (Question) new com.toddlercolors.model.Question(R.string.question11,R.string.qans1,R.string.qans3,R.string.qans2,R.string.qans1,R.drawable.tomato);
   	Question qa2 = (Question) new com.toddlercolors.model.Question(R.string.question12,R.string.qans4,R.string.qans4,R.string.qans3,R.string.qans1,R.drawable.lemon);
   	Question qa3 = (Question) new com.toddlercolors.model.Question(R.string.question13,R.string.qans2,R.string.qans1,R.string.qans2,R.string.qans3,R.drawable.eggplant);
   	Question qa4 = (Question) new com.toddlercolors.model.Question(R.string.question14,R.string.qans3,R.string.qans3,R.string.qans1,R.string.qans2,R.drawable.broccoli);
   	Question qa5 = (Question) new com.toddlercolors.model.Question(R.string.question15,R.string.qans5,R.string.qans1,R.string.qans5,R.string.qans3,R.drawable.carrot);
   	
   	ques.add(qa1);
   	ques.add(qa2);
   	ques.add(qa3);
   	ques.add(qa4);
   	ques.add(qa5);
   }

   public void clearQuestions() {
        ques.clear();
    }

}
