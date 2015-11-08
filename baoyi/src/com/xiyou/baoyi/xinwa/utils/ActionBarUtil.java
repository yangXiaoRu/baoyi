package com.xiyou.baoyi.xinwa.utils;

import android.app.ActionBar;
import android.app.Activity;

public class ActionBarUtil {

	public static void initActionBar(ActionBar bar,int resId){
		bar.setDisplayUseLogoEnabled(false);
		bar.setDisplayShowCustomEnabled(true);
		bar.setDisplayShowHomeEnabled(false);
		bar.setHomeButtonEnabled(false);
		bar.setDisplayShowTitleEnabled(false);
		bar.setCustomView(resId);
	}
}
