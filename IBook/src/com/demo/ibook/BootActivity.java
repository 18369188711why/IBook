package com.demo.ibook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class BootActivity extends Activity{
	private final int SPLASH_DELAY_LENGTH= 6000;
	private ImageView startImage;

	@Override 
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_root);		
		
	   
		startImage=(ImageView)findViewById(R.id.startImage);
		startImage.setImageResource(R.drawable.start_image);
		
		new Handler().postDelayed(new Runnable(){
			public void run(){
				Animation anim=AnimationUtils.loadAnimation(getBaseContext(), R.anim.alpha_animation);
		        startImage.setAnimation(anim);
				Intent mainIntent=new Intent(BootActivity.this,LogInActivity.class);
				BootActivity.this.startActivity(mainIntent);
				BootActivity.this.finish();
			}
			
		}
			, SPLASH_DELAY_LENGTH);
		
		
		
	}
}
