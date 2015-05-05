package com.dreamfac.clipdemo;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class MainActivity extends Activity {

	public int count = 0;
	ClipDrawable drawable;
	Drawable batteryDrawable;
	ShapeDrawable shapeDrawable;
	GradientDrawable gradientDrawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageview = (ImageView) findViewById(R.id.image);
		ImageView imageview_battery = (ImageView) findViewById(R.id.image_battery);
		batteryDrawable=imageview_battery.getDrawable();
		drawable = (ClipDrawable) imageview.getBackground();
		ImageView image_shape=(ImageView) findViewById(R.id.image_shape);
		gradientDrawable=(GradientDrawable) image_shape.getDrawable();
		
		handler.sendMessageDelayed(new Message(), 1000);

	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			drawable.setLevel(count);
//			gradientDrawable.setLevel(count);
			if (count <= 10000) {
				count += 100;
				if(count<400)
				batteryDrawable.setLevel(count/100);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				handler.sendEmptyMessage(1);
			}

		};
	};

	@Override
	protected void onResume() {
		super.onResume();
	}

}
