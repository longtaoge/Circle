package com.android.cricle;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class CircleActivity extends Activity {
    /** Called when the activity is first created. */
	
    private float Rotate =0f;
    OilView view;
    @Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       view =(OilView) findViewById(R.id.view3);
        view.setOnClickListener(new OnClickListener(){
           @Override
		public void onClick(View v) {
        	   Rotate=Rotate+10;
//        	   view.setRotate_degree(Rotate);
                   }
    
});
        
        
    }   
    
}