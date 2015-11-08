package com.xiyou.baoyi.xinwa.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ScrollView;

public class DiscoverMyScrollView extends ScrollView {
	private OnScrollListener onScrollListener;

	private boolean isScrollAble = false;
	
	public DiscoverMyScrollView(Context context) {
		this(context, null);
	}

	public DiscoverMyScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DiscoverMyScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * ���ù����ӿ�
	 * 
	 * @param onScrollListener
	 */
	public void setOnScrollListener(OnScrollListener onScrollListener) {
		this.onScrollListener = onScrollListener;
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		System.out.println("scrollView��״̬�����˸ı䣬oldt=" + oldt + ",t=" + t);
		if (onScrollListener != null) {
			boolean result = false;
			if (oldt < t) {
				onScrollListener.onScroll(result);
			} else {
				result = true;
				onScrollListener.onScroll(result);
			}

		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		 
		 
		 return super.onTouchEvent(ev);
	}
	/**
	 * 
	 * �����Ļص��ӿ�
	 * 
	 * @author xiaanming
	 * 
	 */
	public interface OnScrollListener {
		/**
		 * �ص������� ����MyScrollView������Y�������
		 * 
		 * @param scrollY
		 *            ��
		 */
		public void onScroll(boolean isShow);
	}
//	public void setIsAbleScroll(boolean isScroll){
//		this.isScrollAble = isScroll;
//	}
}
