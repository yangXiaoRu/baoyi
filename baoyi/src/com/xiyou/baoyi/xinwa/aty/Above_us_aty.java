package com.xiyou.baoyi.xinwa.aty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.baoyi.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.xiyou.baoyi.xinwa.adapter.ArticleAdapter;
import com.xiyou.baoyi.xinwa.object.Content;
import com.xiyou.baoyi.xinwa.utils.AnalysisJSON;

public class Above_us_aty extends Activity{
	private List<Content>list;
	private ListView listView;
	private String path = "news.json";
	private Button btnPublish;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.above_us_aty);
		list = new ArrayList<Content>();
		listView = (ListView) findViewById(R.id.img_txt_list);
		btnPublish = (Button) findViewById(R.id.btnPublish);
		
		initData();
		initImageLoader(this);
		
		ArticleAdapter adapter = new ArticleAdapter(list,this);
		listView.setAdapter(adapter);
		
		btnPublish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent();
				i.setClass(Above_us_aty.this,EditTextAty.class);
				startActivity(i);
			}
		});
	}
	private void initData() {
		// TODO Auto-generated method stub
		list = getAssetsData();
	}
	
	public List<Content> getAssetsData(){
		AssetManager am = this.getAssets();
		try {
			InputStream is = am.open(path);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] bt = new byte[1024];
			int len = 0;
			while((len = is.read(bt)) != -1){
				outputStream.write(bt, 0, len);
			}
			outputStream.close();
			is.close();
			String json = outputStream.toString();
			list = AnalysisJSON.getProvinceCities(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you
		// may tune some of them,
		// or you can create default configuration by
		// ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(
				context);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
		config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config.build());
	}
	
}
