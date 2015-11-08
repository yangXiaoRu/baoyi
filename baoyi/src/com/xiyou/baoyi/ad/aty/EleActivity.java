package com.xiyou.baoyi.ad.aty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.baoyi.R;

public class EleActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findactivity);
		getActionBar().hide();
		Intent intent=getIntent();
		final String s1=intent.getStringExtra("µç×Ó");
		
	}

}
