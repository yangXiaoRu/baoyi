package com.xiyou.baoyi.xinwa.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.baoyi.R;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class DiscoverAdapter extends BaseAdapter {

	private Context mContext;
	private final LayoutInflater mInflater;
	private ArrayList<String> imgSrcList;
	private BitmapUtils bitmapUtils;

	public DiscoverAdapter(Context context,List<String> list) {
		super();
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		imgSrcList = new ArrayList<String>();

		bitmapUtils = new BitmapUtils(context);
		
		imgSrcList = (ArrayList<String>) list;
	}

	public void addSrc(List<String> imgSrcList) {
		this.imgSrcList.addAll(imgSrcList);
	}

	public void addSrc(String imgUrl) {
		this.imgSrcList.add(imgUrl);
	}

	@Override
	public int getCount() {
		return imgSrcList.size();
	}

	@Override
	public Object getItem(int position) {
		return imgSrcList.get(position);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		ImageItemHolder holder = null;
		if (view == null) {
			view = mInflater.inflate(R.layout.discover_listview_item, null);
			holder = new ImageItemHolder();
			ViewUtils.inject(holder, view);
			view.setTag(holder);
		} else {
			holder = (ImageItemHolder) view.getTag();
		}
		
		if(position%2 == 0){
			holder.layout1.setVisibility(LinearLayout.GONE);
			holder.layout2.setVisibility(LinearLayout.VISIBLE);
			holder.layout3.setVisibility(LinearLayout.GONE);
//			System.out.println("pisition 等于2");
		}else if(position%3 == 0){
			holder.layout3.setVisibility(LinearLayout.VISIBLE);
			holder.layout1.setVisibility(LinearLayout.GONE);
			holder.layout2.setVisibility(LinearLayout.GONE);
		}else{
			holder.layout1.setVisibility(View.VISIBLE);
			holder.layout2.setVisibility(View.GONE);
			holder.layout3.setVisibility(View.GONE);
		}
		
		if(position%3 == 0){
			
//			System.out.println("pisition 等于3");
		}
		// 还得判断当不显示这个布局时，就不加载网络图片
		
		
		// 加载网络图片
//		bitmapUtils.display(holder.imgItem1,
//				"http://42.121.254.191/images/logo_small.gif");
		// bitmapUtils.display((ImageView) view, imgSrcList.get(position),
		// displayConfig);
		// bitmapUtils.display((ImageView) view, imgSrcList.get(position));
		return view;
	}

	class ImageItemHolder {
		// 第一中布局
		@ViewInject(R.id.discover_layout1)
		private LinearLayout layout1;
		@ViewInject(R.id.discover_shopImg1)
		private ImageView imgItem1;

		@ViewInject(R.id.discover_shopImg2)
		private ImageView imgItem2;

		@ViewInject(R.id.discover_shopImg3)
		private ImageView imgItem3;

		// 第二种布局
		@ViewInject(R.id.discover_layout2)
		private LinearLayout layout2;
		
		@ViewInject(R.id.discover_layout2_shopImg1)
		private ImageView layout2_imgItem1;

		// 第三种布局
		@ViewInject(R.id.discover_layout3)
		private LinearLayout layout3;
		
		@ViewInject(R.id.discover_layout3_shopImg1)
		private ImageView layout3_imgItem1;
		
		@ViewInject(R.id.discover_layout3_shopImg2)
		private ImageView layout3_imgItem2;

	}

}
