package com.xiyou.baoyi.wanwan.object;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

//此类用于控制viewpager的切换速度
public class FixedSpeedScroller extends Scroller {
	private int mDuration = 2000;// 默认的切换时间

	public FixedSpeedScroller(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FixedSpeedScroller(Context context, Interpolator interpolator) {
		super(context, interpolator);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy, int duration) {
		// Ignore received duration, use fixed one instead
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

	@Override
	public void startScroll(int startX, int startY, int dx, int dy) {
		// Ignore received duration, use fixed one instead
		super.startScroll(startX, startY, dx, dy, mDuration);
	}

	public void setmDuration(int time) {
		mDuration = time;
	}

	public int getmDuration() {
		return mDuration;
	}

}