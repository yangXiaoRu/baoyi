package com.xiyou.baoyi.xinwa.view;

import com.lidroid.xutils.view.annotation.event.OnTouch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class PullToRefreshListView extends ListView {

	public PullToRefreshListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public PullToRefreshListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
	
}
