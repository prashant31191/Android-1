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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MatchColors2 extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        final GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MatchColors2.this, "" + position, Toast.LENGTH_SHORT).show();
            }

        });

        gridview.setOnItemLongClickListener(new OnItemLongClickListener(){

					@Override
					public boolean onItemLongClick(AdapterView<?> arg0,
							View v, final int arg2, long arg3) {
						boolean res=false;
						   ClipData clipData = ClipData.newPlainText("", "");
	                         View.DragShadowBuilder dsb = new View.DragShadowBuilder(v);

	                	    res = v.startDrag(clipData, dsb, v, 0);
	                	    return res;
					}});

            int numVisibleChildren = gridview.getAdapter().getCount();
        //int numVisibleChildren = gridview.getChildCount();
            Log.i("no","n"+numVisibleChildren);
            for ( int i = 0; i < numVisibleChildren; i++ ) {
            	//Log.i("i","i"+i);
            	//Log.i("im","img"+((gridview.getAdapter().getItem(i))));
            	//Integer idd = (Integer) gridview.getAdapter().getItem(i);
            	//Log.i("idd","d"+idd);
            	//Log.i("nt","int"+idd.intValue());
                //ImageView view = (ImageView)findViewById(idd.intValue());
                //Log.i("view","v"+view);
            	
            	ImageView view = (ImageView) gridview.getAdapter().getView(i, null, gridview);//(ImageView)gridview.getChildAt(i);
            	Log.i("view","veryyyyy"+view.toString());	
            	/*int childSize = vgrp.getChildCount();
                	for(int k=0;k<childSize;k++)
                	{
                		if(vgrp.getChildAt(k) instanceof ImageView)
                		{
                			vgrp.getChildAt(k).setVisibility(View.VISIBLE);
                		}
                	}
            }*/

                
            	if(view!=null)
                {
              //  view.setOnTouchListener(new OnTouchListener (){
           /*     view.setOnLongClickListener(new OnLongClickListener(){

					@Override
					public boolean onLongClick(View v) {
						boolean res=false;
						   ClipData clipData = ClipData.newPlainText("Dragging", "Move");
	                         View.DragShadowBuilder dsb = new View.DragShadowBuilder(v);

	                	    res = v.startDrag(clipData, dsb, v, 0);
	                	    return res;
					}
                });*/
                

					/*@Override
					public boolean onTouch(View v, MotionEvent event) {
		                
		                	final int action = event.getAction();
		                	boolean res=false;

		                	 if (action == MotionEvent.ACTION_DOWN) {
		                		 
		                         ClipData clipData = ClipData.newPlainText("", "");
		                         View.DragShadowBuilder dsb = new View.DragShadowBuilder(v);

		                	    res = v.startDrag(clipData, dsb, v, 0);
		                	 }
		                	 Log.i("res","r"+res);
		                	 return res;
		                	
		                }
					});*/
                	
                

                view.setOnDragListener(new OnDragListener() {
		
                	  public boolean onDrag(View v, DragEvent event) {

                	        // Defines a variable to store the action type for the incoming event
                	        final int action = event.getAction();
							//return false;

                	        // Handles each of the expected events
                	        switch(action) {

                	            case DragEvent.ACTION_DRAG_STARTED:

                	                    v.setBackgroundColor(Color.BLUE);

                	                    // Invalidate the view to force a redraw in the new tint
                	                    v.invalidate();

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
                	                	v.setBackgroundColor(Color.RED);

                	                    // Invalidate the view to force a redraw in the new tint
                	                    v.invalidate();

                	                    return(true);

                	                case DragEvent.ACTION_DRAG_ENDED:

                	                    // Invalidates the view to force a redraw
                	                    v.invalidate();

                	                    // Does a getResult(), and displays what happened.
                	                    /*if (event.getResult()) {
                	                        Toast.makeText(CopyOfMatchColors.this, "The drop was handled.", Toast.LENGTH_LONG);

                	                    } else {
                	                        Toast.makeText(CopyOfMatchColors.this, "The drop didn't work.", Toast.LENGTH_LONG);

                	                    };*/

                	                    // returns true; the value is ignored.
                	                    return(true);
                	                case DragEvent.ACTION_DROP:

                	                    // Gets the item containing the dragged data
                	                    ClipData.Item item = event.getClipData().getItemAt(0);


                	                    // Displays a message containing the dragged data.
                	                   // Toast.makeText(CopyOfMatchColors.this, "Dragged data is ", Toast.LENGTH_LONG);
                    	                  if (event.getLocalState() == v) {
                                              return false;
                                          } else {
                                              View droped = (View) event.getLocalState();
                                              GridView parent = (GridView) droped.getParent();
                                              ImageAdapter adapter = (ImageAdapter) parent.getAdapter();
                                              Log.i("po","pos"+gridview.pointToPosition((int)event.getX(), (int)event.getY()));
                                              int ItemPos = (int) adapter.getItemId(gridview.pointToPosition((int)event.getX(), (int)event.getY()));
                                              Log.i("position","poss"+ ItemPos);
                                             //adapter.replaceItems(arg2,ItemPos);
                                             adapter.notifyDataSetChanged();
                                             gridview.invalidate();

                	                    // Invalidates the view to force a redraw
                	                    v.invalidate();

                	                    // Returns true. DragEvent.getResult() will return true.
                	                    return(true);}

							// An unknown action type was received.
                	                default:
                	                    Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
                	                    return(false);
                	        }
                	   };

        	
                });
       
            }}
            
        }

    }
    


