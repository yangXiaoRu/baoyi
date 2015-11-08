package com.xiyou.baoyi.wanwan.aty;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.baoyi.R;
import com.lidroid.xutils.ViewUtils;
import com.xiyou.baoyi.wanwan.adapter.PingLunAdapter;
import com.xiyou.baoyi.wanwan.object.PingLunInformation;

public class GoodsDetailActivity extends Activity {
	// 头部返回按钮
	private ImageView img_back;
	private TextView tv_backdetaile;
	// 图片展示
	private ViewPager goods_viewpager;

	// 评论
	private ListView PinglunListview;
	// 原价
	private TextView tv_yuanjia;
	private MyViewPagerAdapter adapter;
	private List<View> mListViews = new ArrayList<View>();

	// 底部的按钮
	private LinearLayout btns_layout;
	private RelativeLayout pinglun_layout;

	private Button btn_pinglun;
	private Button call_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("zhelijnkdfjdghdn");
		setContentView(R.layout.good_detaile);
		ViewUtils.inject(this); // 注入view和事件
		findviews();
		initeviews();
		getPinLun();
	}

	private void findviews() {
		// img_back = (ImageView) findViewById(R.id.back_detaile);
		// tv_backdetaile = (TextView) findViewById(R.id.tv_backdetaile);
		goods_viewpager = (ViewPager) findViewById(R.id.goods_viewpager);
		tv_yuanjia = (TextView) findViewById(R.id.tv_yuanjia);
		PinglunListview = (ListView) findViewById(R.id.pinlun_listView);

		btns_layout = (LinearLayout) findViewById(R.id.buttons_layout);
		pinglun_layout = (RelativeLayout) findViewById(R.id.pinglun_layout);

		btn_pinglun = (Button) findViewById(R.id.btn_pinglun);
		call_button = (Button) findViewById(R.id.call_button);
	}

	// 头部返回监听
	// @OnClick({ R.id.back_detaile, R.id.tv_backdetaile })
	// public void onclik(View v) {
	// GoodsDetailActivity.this.finish();
	// }

	private void initeviews() {
		// 设置小图和大图
		final int[] s = { R.drawable.ad_1, R.drawable.ad_2, R.drawable.ad_3 };
		// goods_small_gridview.setAdapter(new small_gridViewAdapter(
		// GoodsDetailActivity.this, s));
		// goods_small_gridview.setOnItemClickListener(new OnItemClickListener()
		// {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View view, int arg2,
		// long arg3) {
		// // 点击小图显示大图
		// // good_large.setImageResource(s[arg2]);
		// }
		// });

		// 隐藏不必要的两页
		// goodsInformationLayout.setVisibility(View.VISIBLE);
		// PinglunListLayout.setVisibility(View.GONE);
		// quPinglunLayout.setVisibility(View.GONE);
		// 为选项卡设置监听事件
		// 获取物品信息页面并展示
		// getGoodInformation();
		initData();
		adapter = new MyViewPagerAdapter(mListViews);
		goods_viewpager.setAdapter(adapter);
		SpannableString string = new SpannableString("￥499");
		string.setSpan(new StrikethroughSpan(), 0, string.length(),
				Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		tv_yuanjia.setText(string);
		btns_layout.setVisibility(View.VISIBLE);
		pinglun_layout.setVisibility(View.GONE);

		btn_pinglun.setOnClickListener(new to_pinglun());
		call_button.setOnClickListener(new to_call());
	}

	private class to_pinglun implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// 显示和隐藏界面布局
			btns_layout.setVisibility(View.GONE);
			pinglun_layout.setVisibility(View.VISIBLE);

		}
	}

	private class to_call implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			// 打开拨号界面
			Uri uri = Uri.parse("tel:18829289618");
			Intent intent = new Intent(Intent.ACTION_DIAL, uri);
			startActivity(intent);
		}
	}

	// private void getGoodInformation() {
	// String name = "海底两万里";
	// float price = 1.3f;
	// String des = "大学生必读的凡尔纳好书";
	// book_information good = new book_information(name, price, des);
	// TextView tv_name = (TextView) goodsInformationLayout
	// .findViewById(R.id.detail_name);
	// TextView tv_des = (TextView) goodsInformationLayout
	// .findViewById(R.id.detail_des);
	// TextView tv_num = (TextView) goodsInformationLayout
	// .findViewById(R.id.detail_num);
	// TextView tv_boss = (TextView) goodsInformationLayout
	// .findViewById(R.id.detail_boss);
	// TextView tv_price = (TextView) goodsInformationLayout
	// .findViewById(R.id.detail_price);
	// tv_name.setText("名称：" + good.getName().toString());
	// tv_des.setText("描述：" + good.getDesctiption());
	// tv_num.setText("库存：" + good.getNum() + " 件");
	// tv_boss.setText("卖家：" + good.getBoss());
	// tv_price.setText("￥价格：" + good.getPrice());
	// }

	private void getPinLun() {
		// 初始化评论界面（网络请求略）
		PingLunInformation p1 = new PingLunInformation("挺好的",
				"http://p4.so.qhimg.com/bdr/_240_/t0166206017e78eb5de.jpg",
				"暮光之城");
		PingLunInformation p2 = new PingLunInformation("书还好，就是旧了些",
				"http://p1.so.qhimg.com/bdr/_240_/t01ef6cfd51c8dd09c1.jpg",
				"越狱");
		PingLunInformation p3 = new PingLunInformation("挺好的，谢谢学长",
				"http://p0.so.qhimg.com/bdr/_240_/t0152fc3fc4ce835a7a.jpg",
				"颜小夭");
		PingLunInformation p4 = new PingLunInformation(
				"就是这本书！可惜没有了，要不一定给舍友要几本",
				"http://p2.so.qhimg.com/bdr/_240_/t01c6e11f1f954b8297.jpg",
				"加载中");
		PingLunInformation p5 = new PingLunInformation(
				"看着挺好的，不知到类容对不对。方便是必须的，谢谢学姐！以后自己有不用的书也会送给大家的！",
				"http://p2.so.qhimg.com/bdr/_240_/t013a32d59cfaa4af57.jpg",
				"乐乐");
		List<PingLunInformation> list = new ArrayList<PingLunInformation>();
		list.add(p5);
		list.add(p4);
		list.add(p3);
		list.add(p2);
		list.add(p1);
		PingLunAdapter adapter = new PingLunAdapter(list,
				GoodsDetailActivity.this);
		PinglunListview.setAdapter(adapter);
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
		private List<View> mListViews;

		public MyViewPagerAdapter(List<View> mListViews) {
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
					i.setClass(GoodsDetailActivity.this, DetailImageAty.class);
					i.putExtra("currentId", position);
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

	@Override
	public void onBackPressed() {
		if (pinglun_layout.getVisibility() == View.VISIBLE) {
			btns_layout.setVisibility(View.VISIBLE);
			pinglun_layout.setVisibility(View.GONE);
		} else {
			super.onBackPressed();
		}
	}
}
