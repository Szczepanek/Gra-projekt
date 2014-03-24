package com.wiorek.gra;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ourSong = MediaPlayer.create(Splash.this, R.raw.beep1);
		ourSong.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(1500);					
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
				finally{
					Intent  openStartingPoint = new Intent("com.wiorek.gra.MENU");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
