package com.xiyou.baoyi.wanwan.aty;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baoyi.R;
import com.xiyou.baoyi.wanwan.view.DetailViewPager;
import com.xiyou.baoyi.wanwan.view.XinwaZoomImageView;

public class DetailImageAty extends Activity {
	
	private XinwaZoomImageView zoomImageView;
	private Bitmap bitmap;
	private DetailViewPager viewPager;
	private MyViewPagerAdapter adapter;
	private List<View>mListViews = new ArrayList<View>();
	
	private TextView detail_image_num;
	
	private String text[] ={"1/3","2/3","3/3"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_image_aty);
		
		
		viewPager =  (DetailViewPager) findViewById(R.id.image_viewpager);
		detail_image_num = (TextView) findViewById(R.id.detail_image_num);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
		
		initData();
		
		adapter = new MyViewPagerAdapter(mListViews);
		viewPager.setAdapter(adapter);
		
		viewPager.setCurrentItem(getIntent().getIntExtra("currentId", 0));
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				detail_image_num.setText(text[arg0]);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	private void initData() {
		// TODO Auto-generated method stub
		LayoutInflater lf = getLayoutInflater().from(this);  
		XinwaZoomImageView view1 = (XinwaZoomImageView) lf.inflate(R.layout.xinwa_zoom_imageview, null);  
		XinwaZoomImageView view2 = (XinwaZoomImageView) lf.inflate(R.layout.xinwa_zoom_imageview, null);  
		XinwaZoomImageView view3 = (XinwaZoomImageView) lf.inflate(R.layout.xinwa_zoom_imageview, null);  
        view1.setImageBitmap(bitmap);
        view1.setViewPager(viewPager);
        
//      ((ZoomImageView) view2).setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.image1));
        view2.setImageBitmap(bitmap);
        view2.setViewPager(viewPager);
        
        view3.setImageBitmap(bitmap);
        view3.setViewPager(viewPager);
//        ((ZoomImageView) view3).setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.image2));
        mListViews.add(view1);  
        mListViews.add(view2);  
        mListViews.add(view3);
	}
	class MyViewPagerAdapter extends PagerAdapter{  
        private List<View> mListViews;  
          
        public MyViewPagerAdapter(List<View> mListViews) {  
            this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。  
        }  
  
        @Override  
        public void destroyItem(ViewGroup container, int position, Object object)   {     
            container.removeView(mListViews.get(position));//删除页卡  
        }  
  
  
        @Override  
        public Object instantiateItem(ViewGroup container, int position) {  //这个方法用来实例化页卡         
             container.addView(mListViews.get(position));//添加页卡  
             return mListViews.get(position);  
        }  
  
        @Override  
        public int getCount() {           
            return  mListViews.size();//返回页卡的数量  
        }  
          
        @Override  
        public boolean isViewFromObject(View arg0, Object arg1) {             
            return arg0==arg1;//官方提示这样写  
        }  
    }  
}
