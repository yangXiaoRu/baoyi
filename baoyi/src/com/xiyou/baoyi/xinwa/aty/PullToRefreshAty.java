package com.xiyou.baoyi.xinwa.aty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baoyi.R;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.xiyou.baoyi.ad.aty.MainActivity;
import com.xiyou.baoyi.ad.frament.find.IssueAcyivity;
import com.xiyou.baoyi.xinwa.adapter.DiscoverAdapter;
import com.xiyou.baoyi.xinwa.utils.ActionBarUtil;
import com.xiyou.baoyi.xinwa.view.DiscoverListView;
import com.xiyou.baoyi.xinwa.view.PullToRefreshListView;
import com.xiyou.baoyi.xinwa.view.PullToRefreshView;
import com.xiyou.baoyi.xinwa.view.PullToRefreshView.OnFooterRefreshListener;
import com.xiyou.baoyi.xinwa.view.PullToRefreshView.OnHeaderRefreshListener;

public class PullToRefreshAty extends Activity implements
		OnHeaderRefreshListener, OnFooterRefreshListener {

	@ViewInject(R.id.pull_scrollview)
	private ScrollView scrollView;
//	@ViewInject(R.id.discover_text_hot)
//	private TextView text_hot;
//	@ViewInject(R.id.discover_publish_window)
//	private LinearLayout discover_publish;发布商品，和发布文章的
	@ViewInject(R.id.discover_above_us)
	private LinearLayout discover_above_us;
	private ImageButton btn_publish;
	@ViewInject(R.id.discover_card)
	private RelativeLayout discover_card;

	PullToRefreshView mPullToRefreshView;

	private DiscoverAdapter adapter;
	private List<String> list = new ArrayList<String>();
	private PullToRefreshListView listView;
	
	private LayoutInflater inflater;

	private PopupWindow popuWindow1; 
	
	private View contentView1;
	
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			List<String> result = (List<String>) msg.obj;
			switch (msg.what) {
			case DiscoverListView.REFRESH:
				mPullToRefreshView.onHeaderRefreshComplete();
				list.addAll(result);
				Toast.makeText(PullToRefreshAty.this, "数据已经更新", Toast.LENGTH_SHORT).show();
				break;
			case DiscoverListView.LOAD:
				mPullToRefreshView.onFooterRefreshComplete();
				list.addAll(result);
				break;
			}
			adapter.notifyDataSetChanged();
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_scrollview);
		ActionBarUtil
				.initActionBar(getActionBar(), R.layout.discover_actionbar);
		// 这里面进行初始化
		ViewUtils.inject(this);
		
		inflater = LayoutInflater.from(this);
		scrollView = (ScrollView) findViewById(R.id.pull_scrollview);
		scrollView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				return false;
			}
		});
		mPullToRefreshView = (PullToRefreshView) findViewById(R.id.main_pull_refresh_view);
		listView = (PullToRefreshListView) findViewById(R.id.listview);
		adapter = new DiscoverAdapter(this, list);
		listView.setAdapter(adapter);
		setListViewHeightBasedOnChildren(listView);
		initData();
		mPullToRefreshView.setOnHeaderRefreshListener(this);
		mPullToRefreshView.setOnFooterRefreshListener(this);
		
		
		btn_publish = (ImageButton) getActionBar().getCustomView()
				.findViewById(R.id.discover_publish);
		
		//这里让listView上面的控件获取焦点，这样listView数据加载完成之后，就能
		//屏蔽掉ListView自己主动上滑的现象
		discover_card.requestFocus();
		discover_card.setFocusable(true);
		discover_card.setFocusableInTouchMode(true);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(PullToRefreshAty.this, DetailGoodsAty.class);
				startActivity(i);
			}
		});

		btn_publish.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				Intent i = new Intent();
//				i.setClass(PullToRefreshAty.this, EditTextAty.class);
//				startActivity(i);
				
//				PopupWindow window = new PopupWindow(PullToRefreshAty.this);
//				window.setWidth(500);
//				window.setHeight(200);
//				View view = inflater.inflate(R.layout.discover_popup_window, null);
//				window.setContentView(view);
//				window.setBackgroundDrawable(new BitmapDrawable());  
//				window.setFocusable(true);
//				window.showAtLocation(mPullToRefreshView,Gravity.CENTER, 0, 0);
////				window.showAsDropDown(mPullToRefreshView);
//				System.out.println("wo lalllllllllllll");
				initPopuWindow1(mPullToRefreshView);
			}
		});


		discover_above_us.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(PullToRefreshAty.this, Above_us_aty.class);
				startActivity(i);
			}
		});
	}

	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {

			@Override
			public void run() {
				// mPullToRefreshView.onFooterRefreshComplete();
				Message msg = handler.obtainMessage();
				msg.what = DiscoverListView.LOAD;
				msg.obj = getData();
				handler.sendMessage(msg);
			}
		}, 1000);
	}

	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		mPullToRefreshView.postDelayed(new Runnable() {

			@Override
			public void run() {
				// 设置更新时间
				// mPullToRefreshView.onHeaderRefreshComplete("最近更新:01-23 12:01");
				// mPullToRefreshView.onHeaderRefreshComplete();
				Message msg = handler.obtainMessage();
				msg.what = DiscoverListView.REFRESH;
				msg.obj = getData();
				handler.sendMessage(msg);
			}
		}, 1000);

	}

	private void initData() {
		loadData(DiscoverListView.REFRESH);
	}

	private void loadData(final int what) {
		// 这里模拟从服务器获取数据
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg = handler.obtainMessage();
				msg.what = what;
				msg.obj = getData();
				handler.sendMessage(msg);
			}
		}).start();
	}

	// 测试数据
	public List<String> getData() {
		List<String> result = new ArrayList<String>();
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			long l = random.nextInt(10000);
			result.add("当前条目的ID：" + l);
		}
		return result;
	}
	
	public static void setListViewHeightBasedOnChildren(ListView listView) {
		if (listView == null)
			return;
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			// pre-condition
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0);
			totalHeight += listItem.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
	}
	
	private void initPopuWindow1(View parent) {  
	   	if (popuWindow1 == null) {
	   		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
				contentView1 = mLayoutInflater.inflate(R.layout.discover_popup_window, null);
				popuWindow1 = new PopupWindow(contentView1);
				popuWindow1.setWidth(500);
				popuWindow1.setHeight(180);
	   	}

	   	TextView shop  = (TextView) contentView1.findViewById(R.id.discover_publish_shop);
	   	TextView message  = (TextView)contentView1.findViewById(R.id.discover_publish_message);
	   	
	   	shop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(PullToRefreshAty.this, IssueAcyivity.class);
				startActivity(intent);
				PullToRefreshAty.this.overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
				popuWindow1.dismiss();
			}
		});
	   	
	   	message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(PullToRefreshAty.this, EditTextAty.class);
				startActivity(i);
			}
		});
	   	
	   	ColorDrawable cd = new ColorDrawable(0x000000);
	   	popuWindow1.setBackgroundDrawable(cd); 
	   	
	   	
	   	//产生背景变暗效果
	    WindowManager.LayoutParams lp=getWindow().getAttributes();
		lp.alpha = 0.4f;
		getWindow().setAttributes(lp);
	   	  
	   	popuWindow1.setOutsideTouchable(true);
	   	popuWindow1.setFocusable(true);
	   	popuWindow1.showAtLocation((View)parent.getParent(), Gravity.CENTER|Gravity.CENTER_HORIZONTAL, 0, 0);

    	popuWindow1.update();
    	popuWindow1.setOnDismissListener(new OnDismissListener(){
    	
    	//在dismiss中恢复透明度
    	public void onDismiss(){
    			WindowManager.LayoutParams lp=getWindow().getAttributes();
    			lp.alpha = 1f;
    			getWindow().setAttributes(lp);	
    		}			
    	 });
	} 
}
