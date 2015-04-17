package com.android.cricle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Circleview extends View implements Runnable  {
	
	private Bitmap mHourBitmap;	
	
	private boolean bInitComplete = false;
	float Angel = -90.0f;
	Matrix matx = new Matrix();
	Paint paint;
	public Circleview(Context context,AttributeSet attrs) {
		super(context,attrs);
		// TODO Auto-generated constructor stub
		init();
		new Thread(this).start();
	}
	
	

	public void init(){
		
		
		mHourBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pointer);
		bInitComplete = true;
		
		
	}
	public void setRotate_degree(float degree)
	{
		Angel = degree;
	}
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		matx.reset();
		canvas.drawColor(0x00);
		
		if (!bInitComplete){
			return ;
		}
		matx.setTranslate(mHourBitmap.getHeight(), 200);
		
		
//		matx.preRotate(Angel,mHourBitmap.getWidth()/2,mHourBitmap.getHeight()*4/5);
		matx.preRotate(Angel,mHourBitmap.getWidth()/2,mHourBitmap.getHeight()/4);
		
		canvas.drawBitmap(mHourBitmap, matx, null);
		
	}
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted())
		{
			      try
			      {
			    	Thread.sleep(300);
			    	Angel+=10;
			     
			      }
			      catch(InterruptedException e)
			      {
			    	  Thread.currentThread().interrupt();
			      }
			      postInvalidate();
		}
		
	}
	
	
	
}