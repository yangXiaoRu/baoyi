package com.xiyou.baoyi.ad.aty;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.baoyi.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class ImagePagerAdapter extends BaseAdapter {

	private Context context;
	private List<String> imageIdList;
	private List<String> linkUrlArray;
	private List<String> urlTitlesList;
	private int size;
	private boolean isInfiniteLoop;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;

	public ImagePagerAdapter(Context context, List<String> imageIdList,
			List<String> urllist, List<String> urlTitlesList) {
		this.context = context;
		this.imageIdList = imageIdList;
		if (imageIdList != null) {
			this.size = imageIdList.size();
		}
		this.linkUrlArray = urllist;
		this.urlTitlesList = urlTitlesList;
		isInfiniteLoop = false;
		// ��ʼ��imageLoader ����ᱨ��
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.ic_launcher) // ����ͼƬ�����ڼ���ʾ��ͼƬ
				.showImageForEmptyUri(R.drawable.meinv) // ����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ
				.showImageOnFail(R.drawable.meinv) // ����ͼƬ���ػ��������з���������ʾ��ͼƬ
				.cacheInMemory(true) // �������ص�ͼƬ�Ƿ񻺴����ڴ���
				.cacheOnDisc(true) // �������ص�ͼƬ�Ƿ񻺴���SD����
				.build();

	}

	@Override
	public int getCount() {
		// Infinite loop
		return isInfiniteLoop ? Integer.MAX_VALUE : imageIdList.size();
	}

	/**
	 * get really position
	 * 
	 * @param position
	 * @return
	 */
	private int getPosition(int position) {
		return isInfiniteLoop ? position % size : position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup container) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = holder.imageView = new ImageView(context);
			holder.imageView
					.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
			holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		imageLoader.displayImage(
				(String) this.imageIdList.get(getPosition(position)),
				holder.imageView, options);

		holder.imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String url = linkUrlArray.get(ImagePagerAdapter.this
						.getPosition(position));
				String title = urlTitlesList.get(ImagePagerAdapter.this
						.getPosition(position));
				/*
				 * if (TextUtils.isEmpty(url)) {
				 * holder.imageView.setEnabled(false); return; }
				 */
				Bundle bundle = new Bundle();

				bundle.putString("url", url);
				bundle.putString("title", title);
				Intent intent = new Intent(context, Second.class);
				intent.putExtras(bundle);

				context.startActivity(intent);
			

			}
		});

		return view;
	}

	private static class ViewHolder {

		ImageView imageView;
	}

	/**
	 * @return the isInfiniteLoop
	 */
	public boolean isInfiniteLoop() {
		return isInfiniteLoop;
	}

	/**
	 * @param isInfiniteLoop
	 *            the isInfiniteLoop to set
	 */
	public ImagePagerAdapter setInfiniteLoop(boolean isInfiniteLoop) {
		this.isInfiniteLoop = isInfiniteLoop;
		return this;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

}