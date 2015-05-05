package com.dreamfac.clipdemo;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends Activity {

	public int count = 0;
	ClipDrawable drawable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageView imageview = (ImageView) findViewById(R.id.image);
		drawable = (ClipDrawable) imageview.getBackground();
		handler.sendEmptyMessage(1);

	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			drawable.setLevel(count);
			if (count <= 10000) {
				count += 100;
				try {
					Thread.sleep(200);
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
