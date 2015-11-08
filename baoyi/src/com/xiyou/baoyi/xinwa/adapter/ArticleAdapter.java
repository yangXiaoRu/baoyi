package com.xiyou.baoyi.xinwa.adapter;

import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.baoyi.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.xiyou.baoyi.xinwa.object.Content;

public class ArticleAdapter extends BaseAdapter{

	private List<Content>list;
	private Context context;
	public ArticleAdapter(List<Content> list,Context context){
		this.list = list;
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list!= null?list.size():0;
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
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView == null){
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.img_txt_item,null);
			viewHolder.text = (TextView) convertView.findViewById(R.id.txt);
			viewHolder.img = (ImageButton) convertView.findViewById(R.id.img);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
			
			Content content = list.get(position);
			boolean isImg = content.isImg();
			if(isImg){
				viewHolder.text.setVisibility(View.GONE);
				String str = content.getStr();
				String path = "";
				Bitmap bitmap = null;
				if(!str.contains("emulated/")){
					System.out.println("从asset读取图片");
					path = str.substring(0, str.length()-4);
					bitmap =  getBitmap(path);
				}else{
					System.out.println("从相册读取照片");
					path = str;
					bitmap = getBitmapFromSDcare(path);
				}
				
				
				viewHolder.img.setImageBitmap(dealWithImage(bitmap));
			}else{
				viewHolder.img.setVisibility(View.GONE);
				viewHolder.text.setText(content.getStr());
			}
		return convertView;
	}
	
	private Bitmap getBitmapFromSDcare(String pathName) {
		// TODO Auto-generated method stub
		System.out.println("图片的路径为"+pathName);
		Bitmap bitmap = BitmapFactory.decodeFile(pathName);
		return bitmap;
	}

	class ViewHolder{
		TextView text;
		ImageButton img;
	}

	private Bitmap getBitmap(String name){
		Bitmap result = null;
		ApplicationInfo appInfo = context.getApplicationInfo();
		//得到该图片的id(name 是该图片的名字，"drawable" 是该图片存放的目录，appInfo.packageName是应用程序的包)
		int resID = context.getResources().getIdentifier(name, "drawable", appInfo.packageName);
		//代码如下
		result = BitmapFactory.decodeResource(context.getResources(), resID);
		return result;
	}
	private Bitmap dealWithImage(Bitmap image){
		DisplayMetrics dm =context.getResources().getDisplayMetrics();  
        int w_screen = dm.widthPixels;  
        int h_screen = dm.heightPixels;
        if(image == null){
        	System.out.println("没有获取到图片，图片为空");
        }
        System.out.println("屏幕宽为"+w_screen+",图片高为"+h_screen);
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        float width;
        float height;
        Bitmap bitmap;
        if(imageWidth > w_screen){
        	width = w_screen - 100;
        	height = width/imageWidth * imageHeight;
        	System.out.println("图片宽为"+imageWidth+",图片高为"+imageHeight);
        	System.out.println("width宽为"+width+",height高为"+height+"比例为"+width/imageWidth);
        bitmap = zoomImage(image,width,height);
        }else{
        bitmap = zoomImage(image,imageWidth,imageHeight);
        }
        return bitmap;
	}
	private Bitmap zoomImage(Bitmap bgimage, double newWidth, double newHeight) {
		// 获取这个图片的宽和高
		float width = bgimage.getWidth();
		float height = bgimage.getHeight();
		// 如果宽度为0 保持原图
		if (newWidth == 0) {
			newWidth = width;
			newHeight = height;
		}
		// 创建操作图片用的matrix对象
		Matrix matrix = new Matrix();
		// 计算宽高缩放率
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 缩放图片动作
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
				(int) height, matrix, true);
		return bitmap;
	}

	private DisplayImageOptions getDisplayImageOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.default_img)
				.showImageForEmptyUri(R.drawable.default_img)
				.showImageOnFail(R.drawable.default_img).cacheOnDisk(true)
				.cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565)
				.considerExifParams(true).build();
		return options;
	}
	
}
