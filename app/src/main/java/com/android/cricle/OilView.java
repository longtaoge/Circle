package com.android.cricle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;

/**
 * @ClassName: 类名称:OilView
 * @author 作者 E-mail: wc_zhang@calinks.com.cn
 * @Description: TODO
 * @version 创建时间：2013-8-27 下午2:06:18
 */
public class OilView extends View implements Runnable {

	private float angel = 0;
	private Matrix matrix;
	private Bitmap needleBm;

	private Bitmap oilBm;
	private Bitmap bootBm;

	public OilView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}

	public OilView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init();
	}

	public OilView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init();
	}

	private void init() {
		matrix = new Matrix();

		needleBm = BitmapFactory.decodeResource(getResources(),
				R.drawable.info_rt_base_needle_);
		bootBm = BitmapFactory.decodeResource(getResources(),
				R.drawable.info_rt_base_needle_boot_);
		oilBm = BitmapFactory.decodeResource(getResources(),
				R.drawable.info_rt_ins_oil_);
		new Thread(this).start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		matrix.reset();
		canvas.drawBitmap(oilBm, 0, 0, null);
		
		matrix.preTranslate( oilBm.getWidth() / 2-bootBm.getWidth()/2+3,
				oilBm.getHeight() / 2 - bootBm.getHeight() / 2);
		matrix.preRotate(angel, needleBm.getWidth()/2, needleBm.getHeight()/6);
		
		canvas.drawBitmap(needleBm, matrix, null);
		canvas.drawBitmap(bootBm, oilBm.getWidth() / 2 - bootBm.getWidth() / 2,
				oilBm.getHeight() / 2 - bootBm.getHeight() / 2, null);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(300);
				angel += 10;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			postInvalidate();
		}

	}
}
