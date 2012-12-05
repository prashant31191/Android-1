package com.toddlercolors.main;

import java.util.List;

import com.example.toddlercolors.R;
import com.toddlercolors.model.*;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MatchColors extends Activity {

	public boolean checkValidMatch(Integer[] images)
	{int count=0;
		for(int k=0;k<images.length;k+=2)
		{Log.i("image","k"+k+" "+images[k]);
			switch (images[k])
			{
			case R.drawable.apple:if(images[k+1] == R.drawable.tomato){count++;}break;
			case R.drawable.banana:if(images[k+1] == R.drawable.lemon){count++;}break;
			case R.drawable.orange:if(images[k+1] == R.drawable.carrot){count++;}break;
			case R.drawable.kiwi:if(images[k+1] == R.drawable.broccoli){count++;}break;
			case R.drawable.grapes:if(images[k+1] == R.drawable.eggplant){count++;}break;
			case R.drawable.tomato:if(images[k+1] == R.drawable.apple){count++;}break;
			case R.drawable.lemon:if(images[k+1] == R.drawable.banana){count++;}break;
			case R.drawable.carrot:if(images[k+1] == R.drawable.orange){count++;}break;
			case R.drawable.broccoli:if(images[k+1] == R.drawable.kiwi){count++;}break;
			case R.drawable.eggplant:if(images[k+1] == R.drawable.grapes){count++;}break;
			}
		
		}
		Log.i("count","count"+count);
		if (count == 5)
			return true;
		else
			return false;

	}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        
 

        gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View v,   final int arg2, long arg3) {
							boolean res=false;
							ClipData clipData = ClipData.newPlainText("", "");
	                        View.DragShadowBuilder dsb = new View.DragShadowBuilder(v);
	                	      //final 
	                	    res = v.startDrag(clipData, dsb, v, 0);

	                	    v.setOnDragListener(new OnDragListener() {
	
	                      	  public boolean onDrag(View v, DragEvent event) {
	                      		  
	                      		   Position pos = new Position();
	                      		 

	                      	        // Defines a variable to store the action type for the incoming event
	                      	        final int action = event.getAction();
	      							//return false;

	                      	        // Handles each of the expected events
	                      	        switch(action) {

	                      	            case DragEvent.ACTION_DRAG_STARTED:
	                      	            	//Log.i("start","argument"+arg2);
	                      	            	pos.setPosition(arg2);
	                      	                    // returns true to indicate that the View can accept the dragged data.
	                      	                    return(true);
	                      	            case DragEvent.ACTION_DRAG_ENTERED: 
	                      	                // Applies a green tint to the View. Return true; the return value is ignored.
	                      	            	v.setBackgroundColor(Color.GREEN);
	                      	                // Invalidate the view to force a redraw in the new tint
	                      	                v.invalidate();
	                      	                return(true);
	                      	                case DragEvent.ACTION_DRAG_LOCATION:
	                      	                    return(true);
	                      	                case DragEvent.ACTION_DRAG_EXITED:
	                      	                    return(true);
	                      	                case DragEvent.ACTION_DRAG_ENDED:
	                      	                    return(true);
	                      	                case DragEvent.ACTION_DROP:
	                      	                  if (event.getLocalState() == v) {
	                                              return false;
	                                          } else {
	                                              View droped = (View) event.getLocalState();
	                                              GridView parent = (GridView) droped.getParent();
	                                              ImageAdapter adapter = (ImageAdapter) parent.getAdapter();
	               
	                                              
	                                            //  Log.i("arg","current"+arg2);
	                                              //Log.i("pos","start"+pos.getPosition());

	                                              Integer[] images =adapter.replaceItems(pos.getPosition(),arg2);
	                                             gridview.setAdapter(new ImageAdapter(MatchColors.this,adapter.getImages()));
	                                             if (checkValidMatch(adapter.getImages()) == true)
	                                            	 {Toast.makeText(MatchColors.this, "Yippie, it's a perfect match!", Toast.LENGTH_LONG).show();}
	
	                                              return true;
	                                              
	                                          }

	                      	                default:
	                      	                    Log.e("DragDrop","Unknown action type received by OnDragListener.");
	                      	                    return(false);
	                      	        }
	                      	   };

	              	
	                      });
	                	    return res;
					}
                });
                
                	

               
       
            }//}
            
        //}

    }
    


