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
						  Log.i("start","curr"+arg2);
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
	                      	            	Log.i("actionstart","started");
	                      	            	Log.i("pos","beforepos"+pos.getPosition());
	                      	            	
	                      	            	Log.i("start","currarg"+arg2);
	                      	            	pos.setPosition(arg2);
	                      	            	Log.i("pos","pos"+pos.getPosition());
	
	                      	                   // v.setBackgroundColor(Color.BLUE);

	                      	                    // Invalidate the view to force a redraw in the new tint
	                      	                    //v.invalidate();

	                      	                    // returns true to indicate that the View can accept the dragged data.
	                      	                    return(true);

	                      	            case DragEvent.ACTION_DRAG_ENTERED: 

	                      	                // Applies a green tint to the View. Return true; the return value is ignored.

	                      	            	v.setBackgroundColor(Color.GREEN);

	                      	                // Invalidate the view to force a redraw in the new tint
	                      	                v.invalidate();

	                      	                return(true);

	                      	                case DragEvent.ACTION_DRAG_LOCATION:

	                      	                // Ignore the event
	                      	                    return(true);


	                      	                case DragEvent.ACTION_DRAG_EXITED:

	                      	                    // Re-sets the color tint to blue. Returns true; the return value is ignored.
	                      	                	//v.setBackgroundColor(Color.RED);

	                      	                    // Invalidate the view to force a redraw in the new tint
	                      	                    //v.invalidate();

	                      	                    return(true);

	                      	                case DragEvent.ACTION_DRAG_ENDED:

	                      	                    // Invalidates the view to force a redraw
	                      	                   // v.invalidate();

	                      	                    // Does a getResult(), and displays what happened.
	                      	                   /* if (event.getResult()) {
	                      	                        Toast.makeText(MatchColors.this, "The drop was handled.", Toast.LENGTH_LONG);

	                      	                    } else {
	                      	                        Toast.makeText(MatchColors.this, "The drop didn't work.", Toast.LENGTH_LONG);

	                      	                    };*/

	                      	                    // returns true; the value is ignored.
	                      	                    return(true);
	                      	                case DragEvent.ACTION_DROP:

	                      	                    // Gets the item containing the dragged data
	                      	                    //ClipData.Item item = event.getClipData().getItemAt(0);
	                      	                  if (event.getLocalState() == v) {
	                                              return false;
	                                          } else {
	                                              View droped = (View) event.getLocalState();
	                                              GridView parent = (GridView) droped.getParent();
	                                              ImageAdapter adapter = (ImageAdapter) parent.getAdapter();
	                                              //Log.i("po","pos"+gridview.pointToPosition((int)event.getX(), (int)event.getY()));
	                                              //int ItemPos = (int) adapter.getItemId(gridview.pointToPosition((int)event.getX(), (int)event.getY()));
	                                              //Log.i("position","poss"+ ItemPos);
	                                              
	                                              Log.i("arg","currdrp"+arg2);
	                                              Log.i("pos","pos"+pos.getPosition());
	                                             //gridview.getPositionForView(getCurrentFocus()));
	                                            // adapter.notifyDataSetChanged();
	                                              Integer[] images =adapter.replaceItems(pos.getPosition(),arg2);
	                                             for(int k=0;k<adapter.getImages().length;k++)
	                                            	 Log.i("arr","array"+k+images[k]);
	                                            // adapter.notifyDataSetChanged();
	                                             gridview.setAdapter(new ImageAdapter(MatchColors.this,adapter.getImages()));
	                                             
	                                             //gridview.invalidate();
	                                              //Log.i("dropview","drpview"+droped.getTag());
	                                              //droped.getTag()
	                                             //GridItem dropItem = ((DragGridItemHolder) droped.getTag()).item;

	                                            /* 
	                                             items = adapter.get;

	                                              View target = v;
	                                              GridItem targetItem = ((DragGridItemHolder) target.getTag()).item;
	                                              int index = items.indexOf(targetItem);
	                                              items.remove(dropItem);
	                                              items.add(index, dropItem);
	                                              */
	                                             // v.invalidate();
	                                              return true;
	                                              
	                                          }
	                      	                	


	                      	                    // Displays a message containing the dragged data.
	                      	                   // Toast.makeText(MatchColors.this, "Dragged data is ", Toast.LENGTH_LONG);

	                      	                    // Invalidates the view to force a redraw
	                      	                    //v.invalidate();

	                      	                    // Returns true. DragEvent.getResult() will return true.
	                      	                   // return(true);

	      							// An unknown action type was received.
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
    


