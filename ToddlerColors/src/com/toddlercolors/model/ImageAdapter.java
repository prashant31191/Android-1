package com.toddlercolors.model;

import com.example.toddlercolors.R;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mThumbIds = {
            R.drawable.apple, R.drawable.tomato,R.drawable.banana,R.drawable.lemon,R.drawable.kiwi,R.drawable.broccoli,
            R.drawable.grapes,R.drawable.eggplant,R.drawable.orange,R.drawable.carrot
    };

    public ImageAdapter(Context c) {
        mContext = c;
        
        
    }
    
    public ImageAdapter(Context c,Integer[] mThumb) {
        mContext = c;
        mThumbIds=mThumb;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
    	//return null;
        return mThumbIds[position];
    }

    public long getItemId(int position) {
    	//return 0;
        return position;
    }
    public Integer[] replaceItems(int startposition, int dropposition) {
    	Log.i("drop","drp"+mThumbIds[dropposition]);
    	Integer temp = mThumbIds[dropposition];
        mThumbIds[dropposition] = mThumbIds[startposition];
        Log.i("drop","aftdrp"+mThumbIds[dropposition]);
        mThumbIds[startposition]=temp;
        Log.i("drop","start"+mThumbIds[startposition]);
        return mThumbIds;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
    
    public Integer[] getImages()
    {
    	return mThumbIds;
    	
    }
    
    /*public void setImages(Integer[] mThumb)
    {
    	mThumbIds = mThumb;
    }*/

    // references to our images
    


}