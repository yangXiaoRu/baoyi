package com.xiyou.baoyi.wanwan.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DetailViewPager extends ViewPager {

	private boolean noScroll = false;

	public DetailViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DetailViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		/* return false;//super.onTouchEvent(arg0); */
		if (noScroll)
			return false;
		else
			return super.onTouchEvent(arg0);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (noScroll)
			return false;
		else
			return super.onInterceptTouchEvent(arg0);
	}

	public boolean isCanScroll() {
		return noScroll;
	}

	public void setnoScroll(boolean noScroll) {
		this.noScroll = noScroll;
	}
}
