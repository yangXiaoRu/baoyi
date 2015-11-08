package com.xiyou.baoyi.wanwan.adapter;

import java.util.ArrayList;

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
import com.xiyou.baoyi.wanwan.object.book_information;

public class gridViewAdapter extends BaseAdapter {
	ArrayList<book_information> list;
	Context context;

	public gridViewAdapter(ArrayList<book_information> l, Context c) {
		list = l;
		context = c;
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
		View view = View.inflate(context, R.layout.goods_main, null);
		TextView name = (TextView) view.findViewById(R.id.good_name);
		TextView price = (TextView) view.findViewById(R.id.good_price);
		final ImageView img = (ImageView) view.findViewById(R.id.good_photo);

		if (list.get(position).getTupians() == null) {
			img.setImageResource(list.get(position).getPhoto());
		} else {
			String imageUrls[] = list.get(position).getTupians();
			// 创建默认的ImageLoader配置参数
			ImageLoaderConfiguration configuration = ImageLoaderConfiguration
					.createDefault(context);
			ImageLoader.getInstance().init(configuration);

			// Initialize ImageLoader with configuration.
			System.out.println("图片地址:====" + imageUrls[0].toString());
			  DisplayImageOptions options = new DisplayImageOptions.Builder()  
              .showImageOnLoading(R.drawable.loading)  
              .showImageOnFail(R.drawable.loading_error)  
              .cacheInMemory(true)  
              .cacheOnDisk(true)  
              .bitmapConfig(Bitmap.Config.RGB_565)  
              .build();  
        
      ImageLoader.getInstance().displayImage(imageUrls[0], img, options);  

		}
		name.setText(list.get(position).getName().toString());
		price.setText("￥:" + list.get(position).getPrice());
		return view;
	}
}
