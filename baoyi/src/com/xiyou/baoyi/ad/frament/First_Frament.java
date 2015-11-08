package com.xiyou.baoyi.ad.frament;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.baoyi.R;
import com.xiyou.baoyi.ad.CircleFlowIndicator;
import com.xiyou.baoyi.ad.ViewFlow;
import com.xiyou.baoyi.ad.aty.BookActivity;
import com.xiyou.baoyi.ad.aty.ImagePagerAdapter;
import com.xiyou.baoyi.ad.aty.Second;
import com.xiyou.baoyi.ad.frament.find.IssueAcyivity;

public class First_Frament extends Fragment {
	private ViewFlow mViewFlow;
	private CircleFlowIndicator mFlowIndicator;// 小圆点
	private ArrayList<String> imageUrlList = new ArrayList<String>();
	ArrayList<String> linkUrlArray = new ArrayList<String>();
	ArrayList<String> titleList = new ArrayList<String>();
	private LinearLayout notice_parent_ll;
	private int mCurrPos;
	private Button button1, button2, button3, button4,button5;
	private TextView textView1,textView2;
	private ImageView imageView1,imageView2,imageView3;
	
	private Context context;
	public First_Frament(Context context){
		this.context = context;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.first_frament, container,
				false);
		button1 = (Button) rootView.findViewById(R.id.book_button);
		button2 = (Button) rootView.findViewById(R.id.life_button);
		button3 = (Button) rootView.findViewById(R.id.electron_button);
		button4 = (Button) rootView.findViewById(R.id.text_button);
		textView1=(TextView)rootView.findViewById(R.id.cu_textView);
		button5=(Button)rootView.findViewById(R.id.headline_button);
		textView1.setTypeface(Typeface.DEFAULT_BOLD, Typeface.BOLD);
		imageView1=(ImageView)rootView.findViewById(R.id.shu_imageView);
		imageView2=(ImageView)rootView.findViewById(R.id.close_imageView1);
		imageView3=(ImageView)rootView.findViewById(R.id.close_imageView2);
		imageView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//免费拿图书
//				Intent intent=new Intent();
//				intent.setClass(getActivity(), IssueAcyivity.class);
//				startActivity(intent);
//				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//免费拿衣服
				Intent intent=new Intent();
				intent.setClass(getActivity(), FreeCloseActivity.class);
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		imageView3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//免费拿物品
				Intent intent=new Intent();
				intent.setClass(getActivity(), FreeOtherActivity.class);
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 图书
				Intent intent=new Intent();
				intent.setClass(getActivity(), BookActivity.class);
				intent.putExtra("图书","图书");
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 课本
				Intent intent=new Intent();
				intent.setClass(getActivity(), FreeBookActivity.class);
				intent.putExtra("课本","课本");
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 生活
				Intent intent=new Intent();
				intent.setClass(getActivity(), FreeCloseActivity.class);
				intent.putExtra("生活","生活");
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 电子
				Intent intent=new Intent();
				intent.setClass(getActivity(), FreeOtherActivity.class);
				intent.putExtra("电子","电子");
				startActivity(intent);
				getActivity().overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});

		mViewFlow = (ViewFlow) rootView.findViewById(R.id.viewflow);
		mFlowIndicator = (CircleFlowIndicator) rootView
				.findViewById(R.id.circleFlowIndicator);

		imageUrlList
				.add("http://b.hiphotos.baidu.com/image/pic/item/d01373f082025aaf95bdf7e4f8edab64034f1a15.jpg");
		imageUrlList
				.add("http://g.hiphotos.baidu.com/image/pic/item/6159252dd42a2834da6660c459b5c9ea14cebf39.jpg");
		imageUrlList
				.add("http://d.hiphotos.baidu.com/image/pic/item/adaf2edda3cc7cd976427f6c3901213fb80e911c.jpg");
		imageUrlList
				.add("http://g.hiphotos.baidu.com/image/pic/item/b3119313b07eca80131de3e6932397dda1448393.jpg");

		linkUrlArray
				.add("http://blog.csdn.net/finddreams/article/details/44301359");
		linkUrlArray
				.add("http://blog.csdn.net/finddreams/article/details/43486527");
		linkUrlArray
				.add("http://blog.csdn.net/finddreams/article/details/44648121");
		linkUrlArray
				.add("http://blog.csdn.net/finddreams/article/details/44619589");
		titleList.add("常见Android进阶笔试题");
		titleList.add("GridView之仿支付宝钱包首页");
		titleList.add("仿手机QQ网络状态条的显示与消失 ");
		titleList.add("Android循环滚动广告条的完美实现 ");
		initBanner(imageUrlList);
		initRollNotice();
		return rootView;
	}

	private void initRollNotice() {

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				((Activity) context).runOnUiThread(new Runnable() {
					@Override
					public void run() {
						moveNext();
						Log.d("Task", "下一个");
					}
				});

			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 0, 2000);
	}

	private void moveNext() {
		setView(this.mCurrPos, this.mCurrPos + 1);
		// this.notice_vf.setInAnimation(this, R.anim.in_bottomtop);
		// this.notice_vf.setOutAnimation(this, R.anim.out_bottomtop);
		// this.notice_vf.showNext(); 我删除的
	}

	private void setView(int curr, int next) {

		View noticeView = getActivity().getLayoutInflater().inflate(
				R.layout.notice_item, null);
		TextView notice_tv = (TextView) noticeView.findViewById(R.id.notice_tv);
		if ((curr < next) && (next > (titleList.size() - 1))) {
			next = 0;
		} else if ((curr > next) && (next < 0)) {
			next = titleList.size() - 1;
		}
		notice_tv.setText(titleList.get(next));
		notice_tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();
				bundle.putString("url", linkUrlArray.get(mCurrPos));
				bundle.putString("title", titleList.get(mCurrPos));
				Intent intent = new Intent(getActivity(), Second.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
		/*
		 * if (notice_vf.getChildCount() > 1) { notice_vf.removeViewAt(0); }
		 * 我删除的 notice_vf.addView(noticeView, notice_vf.getChildCount());
		 */
		mCurrPos = next;

	}

	private void initBanner(ArrayList<String> imageUrlList) {

		mViewFlow.setAdapter(new ImagePagerAdapter(getActivity(), imageUrlList,
				linkUrlArray, titleList).setInfiniteLoop(true));
		mViewFlow.setmSideBuffer(imageUrlList.size()); // 实际图片张数，
														// 我的ImageAdapter实际图片张数为3

		mViewFlow.setFlowIndicator(mFlowIndicator);
		mViewFlow.setTimeSpan(4500);
		mViewFlow.setSelection(imageUrlList.size() * 1000); // 设置初始位置
		mViewFlow.startAutoFlowTimer(); // 启动自动播放
	}

}
