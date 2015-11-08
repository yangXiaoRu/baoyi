package com.xiyou.baoyi.xinwa.aty;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.baoyi.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class DetailGoodsAty extends Activity {

	private List<ImageView> mListViews = new ArrayList<ImageView>();
	private MyViewPagerAdapter adapter;

	@ViewInject(R.id.goods_viewpager)
	private ViewPager goodsViewpager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_goods_aty);
		ViewUtils.inject(this);

		initData();

		adapter = new MyViewPagerAdapter(mListViews);
		goodsViewpager.setAdapter(adapter);

	}

	private void initData() {
		// TODO Auto-generated method stub
		ImageView view1 = new ImageView(this);
		ImageView view2 = new ImageView(this);

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.image);
		view1.setImageBitmap(bitmap);

		// ((ZoomImageView) view2).setImageBitmap(
		// BitmapFactory.decodeResource(getResources(), R.drawable.image1));
		view2.setImageBitmap(bitmap);

		mListViews.add(view1);
		mListViews.add(view2);
	}

	class MyViewPagerAdapter extends PagerAdapter {
		private List<ImageView> mListViews;

		public MyViewPagerAdapter(List<ImageView> mListViews) {
			this.mListViews = mListViews;// 构造方法，参数是我们的页卡，这样比较方便。
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mListViews.get(position));// 删除页卡
		}

		@Override
		public Object instantiateItem(ViewGroup container, final int position) { // 这个方法用来实例化页卡
			container.addView(mListViews.get(position));// 添加页卡

			View v = mListViews.get(position);
			v.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Intent i = new Intent();
					 i.setClass(DetailGoodsAty.this, DetailImageAty.class);
					 i.putExtra("currentId",position);
					 startActivity(i);
				}
			});

			return mListViews.get(position);
		}

		@Override
		public int getCount() {
			return mListViews.size();// 返回页卡的数量
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;// 官方提示这样写
		}
	}
}

