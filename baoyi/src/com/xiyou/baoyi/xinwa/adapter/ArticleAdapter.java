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
					System.out.println("��asset��ȡͼƬ");
					path = str.substring(0, str.length()-4);
					bitmap =  getBitmap(path);
				}else{
					System.out.println("������ȡ��Ƭ");
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
		System.out.println("ͼƬ��·��Ϊ"+pathName);
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
		//�õ���ͼƬ��id(name �Ǹ�ͼƬ�����֣�"drawable" �Ǹ�ͼƬ��ŵ�Ŀ¼��appInfo.packageName��Ӧ�ó���İ�)
		int resID = context.getResources().getIdentifier(name, "drawable", appInfo.packageName);
		//��������
		result = BitmapFactory.decodeResource(context.getResources(), resID);
		return result;
	}
	private Bitmap dealWithImage(Bitmap image){
		DisplayMetrics dm =context.getResources().getDisplayMetrics();  
        int w_screen = dm.widthPixels;  
        int h_screen = dm.heightPixels;
        if(image == null){
        	System.out.println("û�л�ȡ��ͼƬ��ͼƬΪ��");
        }
        System.out.println("��Ļ��Ϊ"+w_screen+",ͼƬ��Ϊ"+h_screen);
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        float width;
        float height;
        Bitmap bitmap;
        if(imageWidth > w_screen){
        	width = w_screen - 100;
        	height = width/imageWidth * imageHeight;
        	System.out.println("ͼƬ��Ϊ"+imageWidth+",ͼƬ��Ϊ"+imageHeight);
        	System.out.println("width��Ϊ"+width+",height��Ϊ"+height+"����Ϊ"+width/imageWidth);
        bitmap = zoomImage(image,width,height);
        }else{
        bitmap = zoomImage(image,imageWidth,imageHeight);
        }
        return bitmap;
	}
	private Bitmap zoomImage(Bitmap bgimage, double newWidth, double newHeight) {
		// ��ȡ���ͼƬ�Ŀ�͸�
		float width = bgimage.getWidth();
		float height = bgimage.getHeight();
		// ������Ϊ0 ����ԭͼ
		if (newWidth == 0) {
			newWidth = width;
			newHeight = height;
		}
		// ��������ͼƬ�õ�matrix����
		Matrix matrix = new Matrix();
		// ������������
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// ����ͼƬ����
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
