package com.xiyou.baoyi.wanwan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.baoyi.R;

public class small_gridViewAdapter extends BaseAdapter {
	private Context context;
	private int[] s;

	public small_gridViewAdapter(Context context, int[] s) {
		this.context = context;
		this.s = s;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		View view = View.inflate(context, R.layout.small_img, null);
		ImageView img = (ImageView) view.findViewById(R.id.my_small);
		img.setImageResource(s[position]);
		return view;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return s.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
