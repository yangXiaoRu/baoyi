package com.xiyou.baoyi.wanwan.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.baoyi.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.xiyou.baoyi.wanwan.object.PingLunInformation;

public class PingLunAdapter extends BaseAdapter {
	List<PingLunInformation> list;
	Context context;

	public PingLunAdapter(List<PingLunInformation> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		View view = View.inflate(context, R.layout.pinglun_item_layout, null);
		// findviews
		ImageView touxiang = (ImageView) view
				.findViewById(R.id.pinlun_touxiang);
		TextView name = (TextView) view.findViewById(R.id.pinlun_name);
		TextView xinxi = (TextView) view.findViewById(R.id.pinlun_xinxi);

		// initeViews
		name.setText(list.get(position).getName().toString());
		xinxi.setText(list.get(position).getWord());
		// 设置加载头像（imageLoader）
		String touxiangUrl = list.get(position).getTouxiang();
		ImageLoaderConfiguration configuration = ImageLoaderConfiguration
				.createDefault(context);
		ImageLoader.getInstance().init(configuration);

		// Initialize ImageLoader with configuration.
		// System.out.println("图片地址:====" + imageUrls[0].toString());
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.loading)
				.showImageOnFail(R.drawable.loading_error).cacheInMemory(true)
				.cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();

		ImageLoader.getInstance().displayImage(touxiangUrl, touxiang, options);
		return view;
	}

}
