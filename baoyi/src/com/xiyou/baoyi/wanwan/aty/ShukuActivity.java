package com.xiyou.baoyi.wanwan.aty;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;

import com.example.baoyi.R;
import com.xiyou.baoyi.wanwan.adapter.goodsViewPagerAdapter;
import com.xiyou.baoyi.wanwan.fragments.BooksFragment;
import com.xiyou.baoyi.wanwan.object.FixedSpeedScroller;
import com.xiyou.baoyi.wanwan.object.MyPagerTransform;
import com.xiyou.baoyi.wanwan.view.MyViewPager;

public class ShukuActivity extends FragmentActivity {

	// 广告
	private ViewPager vp_guanggao;// 广告
	private int[] guangao_id = { R.drawable.ad_1, R.drawable.ad_2,
			R.drawable.ad_3, R.drawable.ad_4 };
	private ArrayList<View> GuanGao_imageviews = new ArrayList<View>();
	private int current_ad_page = 0;
	private int page_tag = -1;
	private Handler handler;
	private FixedSpeedScroller mScroller;
	// 商品
	// @ViewInject(R.id.GoodsViewPager)
	public static MyViewPager GoodsViewPager;
	private ArrayList<Fragment> fragmentsList = new ArrayList<Fragment>();
	private RadioGroup radioGroup;
	private RadioButton rb_0;
	private RadioButton rb_1;
	private RadioButton rb_2;
	private RadioButton rb_3;
	private RadioButton rb_4;
	private RadioButton rb_5;
	private ImageView cursor;
	private int currentPageIndex = 0;// 标记当前的页码

	// 底部的RadioGroup
	private RadioGroup rg_home;;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shu_ku_main);
		getActionBar().hide();
		// 广告栏
		vp_guanggao = (ViewPager) findViewById(R.id.vp_guang_gao);
		vp_guanggao.setPageTransformer(true, new MyPagerTransform());

		try {
			Field mField = ViewPager.class.getDeclaredField("mScroller");
			mField.setAccessible(true);
			mScroller = new FixedSpeedScroller(this,
					new AccelerateInterpolator());
			mField.set(vp_guanggao, mScroller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// end广告
//		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//		radioGroup.setOnCheckedChangeListener(new CheckedChangeListener1());
//
//		rb_0 = (RadioButton) findViewById(R.id.rb_kaoyan);
//		rb_1 = (RadioButton) findViewById(R.id.rb_dianzi);
//		rb_2 = (RadioButton) findViewById(R.id.rb_jingji);
//		rb_3 = (RadioButton) findViewById(R.id.rb_wenxue);
//		rb_4 = (RadioButton) findViewById(R.id.rb_waiyu);
//		rb_5 = (RadioButton) findViewById(R.id.rb_jisuanji);
		cursor = (ImageView) findViewById(R.id.cursor);

		GoodsViewPager = (MyViewPager) findViewById(R.id.GoodsViewPager);
		GoodsViewPager.setOffscreenPageLimit(0);
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 0:// 广告
					if (current_ad_page == 0
							|| current_ad_page == GuanGao_imageviews.size())// 当前页是第一页或者最后一页都要改变加减的状态
						page_tag = -page_tag;
					current_ad_page+=page_tag;
					vp_guanggao.setCurrentItem(current_ad_page);
					break;

				default:
					break;
				}
			}
		};
		inite_GuanGao(handler);
		initeCursor();
		initeGoodsViewPager();
		rg_home = (RadioGroup) findViewById(R.id.rg_home);
//		rg_home.setOnCheckedChangeListener(new CheckedChangeListener2());

	}

//	private class CheckedChangeListener2 implements OnCheckedChangeListener {
//
//		@Override
//		public void onCheckedChanged(RadioGroup arg0, int id) {
//			// TODO Auto-generated method stub
//			switch (id) {
//			case R.id.to_wode:
//				Intent intent = new Intent(ShukuActivity.this,
//						WodeActivity.class);
//				ShukuActivity.this.startActivity(intent);
//				break;
//			case R.id.to_shuku:
//
//			default:
//				break;
//			}
//
//		}
//	}

	private void initeCursor() {
		// 设置游标划线的长度
		int w = getWindowManager().getDefaultDisplay().getWidth() / 6;
		LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) cursor
				.getLayoutParams();
		params.width = w;
		cursor.setLayoutParams(params);
	}

	private class CheckedChangeListener1 implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup arg0, int id) {
			switch (id) {
			case R.id.rb_kaoyan:
				GoodsViewPager.setCurrentItem(0);
				break;
			case R.id.rb_dianzi:
				GoodsViewPager.setCurrentItem(1);
				break;
			case R.id.rb_jingji:
				GoodsViewPager.setCurrentItem(2);
				break;
			case R.id.rb_wenxue:
				GoodsViewPager.setCurrentItem(3);
				break;
			case R.id.rb_waiyu:
				GoodsViewPager.setCurrentItem(4);
				break;
			case R.id.rb_jisuanji:
				GoodsViewPager.setCurrentItem(5);
				break;
			default:
				break;
			}

		}
	}

	private void initeGoodsViewPager() {
		Fragment page_1 = new BooksFragment(ShukuActivity.this, 0);
		Fragment page_2 = new BooksFragment(ShukuActivity.this, 1);
		Fragment page_3 = new BooksFragment(ShukuActivity.this, 2);
		Fragment page_4 = new BooksFragment(ShukuActivity.this, 3);
		Fragment page_5 = new BooksFragment(ShukuActivity.this, 4);
		Fragment page_6 = new BooksFragment(ShukuActivity.this, 5);
		fragmentsList.add(page_1);
		fragmentsList.add(page_2);
		fragmentsList.add(page_3);
		fragmentsList.add(page_4);
		fragmentsList.add(page_5);
		fragmentsList.add(page_6);
		GoodsViewPager.setOffscreenPageLimit(0);
		goodsViewPagerAdapter adapter = new goodsViewPagerAdapter(
				ShukuActivity.this.getSupportFragmentManager(), fragmentsList);
		GoodsViewPager.setAdapter(adapter);
		GoodsViewPager.setOnPageChangeListener(new PageChangeListener());
	}

	private class PageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int id) {
			// 改变页的时候因该伴随游标的移动
			TranslateAnimation animation = null;
			switch (id) {
			case 0:
//				rb_0.setChecked(true);
				if (currentPageIndex == 1) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 2) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 3) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 4) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 5) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}

				break;
			case 1:
//				rb_1.setChecked(true);
				if (currentPageIndex == 0) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 2) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 3) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 4) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 5) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				break;
			case 2:
//				rb_2.setChecked(true);
				if (currentPageIndex == 0) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 1) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 3) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 4) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 5) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				break;
			case 3:
//				rb_3.setChecked(true);
				if (currentPageIndex == 0) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 1) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 2) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 4) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 5) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				break;
			case 4:
//				rb_4.setChecked(true);
				if (currentPageIndex == 0) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 1) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 2) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 3) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 5) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				break;
			case 5:
//				rb_5.setChecked(true);
				if (currentPageIndex == 0) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 1) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 1,
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 2) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 2,
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 3) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 3,
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				if (currentPageIndex == 4) {
					animation = new TranslateAnimation(
							Animation.RELATIVE_TO_SELF, 4,
							Animation.RELATIVE_TO_SELF, 5,
							Animation.RELATIVE_TO_SELF, 0,
							Animation.RELATIVE_TO_SELF, 0);
				}
				break;
			default:
				break;
			}
			if (animation != null) {
				currentPageIndex = id;
				animation.setDuration(300);
				animation.setFillAfter(true);
				cursor.startAnimation(animation);
			}
		}
	}

	private void inite_GuanGao(final Handler handler) {
		for (int id : guangao_id) {
			ImageView img = new ImageView(this);
			img.setBackgroundResource(id);
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT);
			img.setLayoutParams(params);
			GuanGao_imageviews.add(img);
		}
		vp_guanggao.setAdapter(new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return GuanGao_imageviews.size();
			}

			@Override
			public Object instantiateItem(View container, int position) {
				// TODO Auto-generated method stub
				((ViewPager) container).addView(GuanGao_imageviews
						.get(position));
				return GuanGao_imageviews.get(position);
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(GuanGao_imageviews
						.get(position));
			}
		});
		new Thread() {
			public void run() {
				while (true) {

					try {
						Thread.sleep(3000);
						handler.sendEmptyMessage(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
}
