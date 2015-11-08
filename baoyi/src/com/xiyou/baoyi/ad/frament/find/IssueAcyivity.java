package com.xiyou.baoyi.ad.frament.find;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baoyi.R;
import com.xiyou.baoyi.ad.aty.MainActivity;

public class IssueAcyivity extends Activity implements OnClickListener,OnDismissListener{
	// 发布商品
	private Button button1, button2, button3, button4, button5,button6,add_button,minus_button;
	private EditText editText1, editText2,editText3, editText4,editText5,editText6,editText7;

	private ImageView icon1, icon2, icon3;
	private TextView fenlei,textView;
	private LinearLayout aa,linear;
	private ListView lv1, lv2, lv3, lv4;
	private LinearLayout ll2;
	private PopupWindow popLeft, popMid, popRight;
	private List<Father> fatlist;
	private List<Son> sonlist, sonlist1, sonlist2, sonlist3, sonlist4;
	private List<Son> right;
	private int screenWidth;
	private int screenHeight;
	private MyAdapterLeft adapterleft;
	private MyAdapterSon adapterleftson;
	private int imaPosition;// 选中的
	private int i[]=new int[4];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.issueactivity);
		getActionBar().hide();
		initScreenWidth();
		intifatherlist();
		intiView();
		int j;
		for(j=0;j<4;j++){
			i[j]=0;
		}
		textView=(TextView)findViewById(R.id.textView);
		linear=(LinearLayout)findViewById(R.id.linear);
		button1 = (Button) findViewById(R.id.issueactivity_button);
		button2 = (Button) findViewById(R.id.issueactivity_button1);
		button3 = (Button) findViewById(R.id.issueactivity_button2);
		button4 = (Button) findViewById(R.id.issueactivity_button3);
		button6 = (Button) findViewById(R.id.issueactivity_button5);
		button5=(Button)findViewById(R.id.issueactivity_button4);
		editText1 = (EditText) findViewById(R.id.issueactivity_editText1);
		editText2 = (EditText) findViewById(R.id.issueactivity_editText2);
		editText3 = (EditText) findViewById(R.id.issueactivity_editText3);
		editText4 = (EditText) findViewById(R.id.issueactivity_editText4);
		editText5 = (EditText) findViewById(R.id.issueactivity_editText5);
		editText6 = (EditText) findViewById(R.id.issueactivity_editText6);
		editText7 = (EditText) findViewById(R.id.issueactivity_editText7);
		add_button=(Button)findViewById(R.id.add_button);
		minus_button=(Button)findViewById(R.id.minus_button);

		add_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				String s=editText3.getText().toString();
				int i=Integer.parseInt(s);
				i=i+1;
				s=Integer.toString(i);
				
				editText3.setText(s);
			}
		});
		
		minus_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String s=editText3.getText().toString();
				if(s.equals("1")){
					editText3.setText("1");
				}
				else{
					int i=Integer.parseInt(s);
					i=i-1;
					s=Integer.toString(i);
					editText3.setText(s);
			}
				}
			
		});
		
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(IssueAcyivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//添加照片
				Intent intentAddPicture = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 调用android的图库
				startActivityForResult(intentAddPicture, 1);//1是requestcode
			}
		});

		button3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//添加照片
				Intent intentAddPicture = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 调用android的图库
				startActivityForResult(intentAddPicture, 2);//1是requestcode
			}
		});

		button4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//添加照片
				Intent intentAddPicture = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 调用android的图库
				startActivityForResult(intentAddPicture, 3);//1是requestcode
			}
		});

		button5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//添加照片
				Intent intentAddPicture = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);// 调用android的图库
				startActivityForResult(intentAddPicture, 4);//1是requestcode
			}
		});

		button6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//描述完毕
				String s1=editText1.getText().toString();
				String s2=editText2.getText().toString();
				String s3=editText4.getText().toString();
				String s4=editText5.getText().toString();
				String s5=fenlei.getText().toString();
				String s6=editText6.getText().toString();
				String s7=editText7.getText().toString();
				if(s5.equals("选择分类")){
					Toast.makeText(IssueAcyivity.this, "请填写完整信息", 0).show();
				}
				else if(!s5.equals("电子")&&!s5.equals("生活")){
					if(!s1.equals("")&&!s2.equals("")&&!s3.equals("")&&!s4.equals("")&&!s6.equals("")&&!s7.equals("")){
						Intent intent=new Intent();
						intent.setClass(IssueAcyivity.this, MiaoActivity.class);
						startActivity(intent);
					}
					else{
						Toast.makeText(IssueAcyivity.this, "请填写完整信息", 0).show();
					}
				}
				else{
					if(!s1.equals("")&&!s2.equals("")&&!s3.equals("")&&!s4.equals("")){
						Intent intent=new Intent();
						intent.setClass(IssueAcyivity.this, MiaoActivity.class);
						startActivity(intent);
					}
					else{
						Toast.makeText(IssueAcyivity.this, "请填写完整信息", 0).show();
					}
				}
				
			}
		});

	}

	private void intiView() {
		fenlei = (TextView) findViewById(R.id.fenlei_textView);
		aa = (LinearLayout) findViewById(R.id.fenlei);
		aa.setOnClickListener(this);
		getPopLeft();
		getPopRight();
	}

	/** 初始化父类和子类 */
	private void intifatherlist() {
		fatlist = new ArrayList<Father>();
		sonlist = new ArrayList<Son>();
		sonlist1 = new ArrayList<Son>();
		sonlist2 = new ArrayList<Son>();
		sonlist3 = new ArrayList<Son>();
		sonlist4 = new ArrayList<Son>();
		List<String> list = new ArrayList<String>();
		list.add("计算机学院");
		list.add("通工学院");
		list.add("电子学院");
		list.add("自动化学院");
		list.add("经济管理学院");
		list.add("外国语学院");
		for (int i = 0; i < 6; i++) {
			Son s = new Son();
			s.setId(i + "");
			s.setName(list.get(i));
			sonlist4.add(s);
		}

		/** 初始化父类 */
		for (int i = 0; i < 3; i++) {
			Father father = new Father();
			father.setId(i + "");

			if (i == 0) {
				father.setImage(R.drawable.ic_category_all);
				father.setName("生活");
				father.setSonList(null);
			}
			if (i == 1) {
				father.setImage(R.drawable.ic_category_entertainment);
				father.setName("课本");
				father.setSonList(sonlist4);
			}
			if (i == 2) {
				father.setImage(R.drawable.ic_category_food);
				father.setName("电子");
				father.setSonList(null);
			}

			fatlist.add(father);
		}
	}

	private void initScreenWidth() {
		DisplayMetrics dm = new DisplayMetrics();
		dm = getResources().getDisplayMetrics();
		screenHeight = dm.heightPixels;
		screenWidth = dm.widthPixels;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.fenlei:
			getPopLeft();
			popLeft.showAsDropDown(fenlei);
			break;
		}
	}

	@Override
	public void onDismiss() {

	}

	/*** 获取PopupWindow实例 .分类 */
	private void getPopLeft() {
		if (null != popLeft) {
			popLeft.dismiss();
			return;
		} else {
			// 初始化分类弹窗
			initPopLeft();
		}
	}

	/*** 获取PopupWindow实例 .分类 */
	private void getPopRight() {
		if (null != popRight) {
			popRight.dismiss();
			return;
		} else {
			// 初始化分类弹窗
			// initPopRight();
		}
	}

	/**
	 * 创建分类弹出PopupWindow
	 */
	protected void initPopLeft() {
		// 获取自定义布局文件pop.xml的视图
		View left_view = getLayoutInflater().inflate(R.layout.popleft, null,
				false);
		left_view.setFocusable(true); // 这个很重要
		left_view.setFocusableInTouchMode(true);

		// PopupWindow(布局，宽度，高度)
		popLeft = new PopupWindow(left_view, screenWidth, screenHeight, true);
		popLeft.setFocusable(true);
		// 重写onKeyListener,按返回键消失
		left_view.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK) {
					popLeft.dismiss();
					// 为空的话就会重新构建不会保留
					// popLeft = null;
					return true;
				}
				return false;
			}
		});
		// 设置动画效果
		// popupWindow.setAnimationStyle(R.style.AnimationFade);
		// 点击其他地方消失
		left_view.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (popLeft != null && popLeft.isShowing()) {
					popLeft.dismiss();
				}
				return false;
			}
		});

		// pop.xml视图里面的控件
		lv1 = (ListView) left_view.findViewById(R.id.lv1);
		lv2 = (ListView) left_view.findViewById(R.id.lv2);
		ll2 = (LinearLayout) left_view.findViewById(R.id.ll2);

		adapterleft = new MyAdapterLeft(IssueAcyivity.this, fatlist);
		lv1.setAdapter(adapterleft);

		// listview的监听
		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {

				adapterleft.setSelectItem(position);
				imaPosition = position;
				adapterleft.notifyDataSetChanged();
				adapterleftson = new MyAdapterSon(IssueAcyivity.this, fatlist
						.get(position).getSonList());
				lv2.setAdapter(adapterleftson);
				// 二维数组里面有元素
				if (fatlist.get(position).getSonList() != null) {
					// 不为空才显示
					lv2.setVisibility(View.VISIBLE);
					lv2.setOnItemClickListener(new OnItemClickListener() {
						@Override
						public void onItemClick(AdapterView<?> parent,
								View view, int position, long id) {
							// 变色效果
							adapterleftson.setSelectItem(position);
							String name = adapterleftson.getItem(position)
									.getName();
							setHeadText(1, name, fatlist.get(imaPosition)
									.getImage());
							popLeft.dismiss();
						}
					});
					// 没元素
				} else {
					// 当没有下级时直接将信息设置textview中
					String name = fatlist.get(position).getName();
					int img = fatlist.get(position).getImage();
					// 第一个都是1
					setHeadText(1, name, img);
					popLeft.dismiss();
				}

			}
		});
	}

	private void setHeadText(int idx, String text, int image) {
		switch (idx) {
		case 1:
			fenlei.setText(text);
		if(text.equals("电子")||text.equals("生活")){
			linear.setVisibility(View.INVISIBLE);
			textView.setVisibility(View.INVISIBLE);
		}else{
			linear.setVisibility(View.VISIBLE);
			textView.setVisibility(View.VISIBLE);
		}
			break;

		}
	}
	//添加照片
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Uri uri;
	
		switch (requestCode) {
		case 1:
			switch (resultCode) {
			case Activity.RESULT_OK:
				if(i[0]==0){
				 uri = data.getData();
				Cursor cursor = IssueAcyivity.this.getContentResolver().query(
						uri, null, null, null, null);
				cursor.moveToFirst();
				String imgNo = cursor.getString(0); // 图片编号
				String imgPath = cursor.getString(1); // 图片文件路径
				String imgSize = cursor.getString(2); // 图片大小
				String imgName = cursor.getString(3); // 图片文件名 cursor.close();
														// //
				Options options = new BitmapFactory.Options(); //
				options.inJustDecodeBounds = false;
				options.inSampleSize = 10;
				Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
				Drawable drawable =new BitmapDrawable(bitmap);
				button2.setBackground(drawable);
				button3.setVisibility(View.VISIBLE);
				Animation animation=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.dim_to_sun);
				final Animation animation1=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.small_to_big);
				button3.startAnimation(animation1);
				i[0]=1;
				}
				else{
					 uri = data.getData();
						Cursor cursor = IssueAcyivity.this.getContentResolver().query(
								uri, null, null, null, null);
						cursor.moveToFirst();
						String imgNo = cursor.getString(0); // 图片编号
						String imgPath = cursor.getString(1); // 图片文件路径
						String imgSize = cursor.getString(2); // 图片大小
						String imgName = cursor.getString(3); // 图片文件名 cursor.close();
																// //
						Options options = new BitmapFactory.Options(); //
						options.inJustDecodeBounds = false;
						options.inSampleSize = 10;
						Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
						Drawable drawable =new BitmapDrawable(bitmap);
						button2.setBackground(drawable);
				}
				break;
			case Activity.RESULT_CANCELED:
				break;
			}
			break;
		case 2:	
			switch (resultCode) {
			case Activity.RESULT_OK:
				if(i[1]==0){
				uri = data.getData();
				Cursor cursor = IssueAcyivity.this.getContentResolver().query(
						uri, null, null, null, null);
				cursor.moveToFirst();
				String imgNo = cursor.getString(0); // 图片编号
				String imgPath = cursor.getString(1); // 图片文件路径
				String imgSize = cursor.getString(2); // 图片大小
				String imgName = cursor.getString(3); // 图片文件名 cursor.close();
														// //
				Options options = new BitmapFactory.Options(); //
				options.inJustDecodeBounds = false;
				options.inSampleSize = 10;
				Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
				Drawable drawable =new BitmapDrawable(bitmap);
				button3.setBackground(drawable);
				button4.setVisibility(View.VISIBLE);
				Animation animation=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.dim_to_sun);
				final Animation animation1=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.small_to_big);
				button4.startAnimation(animation1);
				i[1]=1;
				}
				else{
					uri = data.getData();
					Cursor cursor = IssueAcyivity.this.getContentResolver().query(
							uri, null, null, null, null);
					cursor.moveToFirst();
					String imgNo = cursor.getString(0); // 图片编号
					String imgPath = cursor.getString(1); // 图片文件路径
					String imgSize = cursor.getString(2); // 图片大小
					String imgName = cursor.getString(3); // 图片文件名 cursor.close();
															// //
					Options options = new BitmapFactory.Options(); //
					options.inJustDecodeBounds = false;
					options.inSampleSize = 10;
					Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
					Drawable drawable =new BitmapDrawable(bitmap);
					button3.setBackground(drawable);
				}
				break;
			case Activity.RESULT_CANCELED:
				break;
			}
			break;
		case 3:
			switch (resultCode) {
			case Activity.RESULT_OK:
				if(i[2]==0){
				uri = data.getData();
				Cursor cursor = IssueAcyivity.this.getContentResolver().query(
						uri, null, null, null, null);
				cursor.moveToFirst();
				String imgNo = cursor.getString(0); // 图片编号
				String imgPath = cursor.getString(1); // 图片文件路径
				String imgSize = cursor.getString(2); // 图片大小
				String imgName = cursor.getString(3); // 图片文件名 cursor.close();
														// //
				Options options = new BitmapFactory.Options(); //
				options.inJustDecodeBounds = false;
				options.inSampleSize = 10;
				Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
				Drawable drawable =new BitmapDrawable(bitmap);
				button4.setBackground(drawable);
				button5.setVisibility(View.VISIBLE);
				Animation animation=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.dim_to_sun);
				final Animation animation1=new AnimationUtils().loadAnimation(IssueAcyivity.this,R.anim.small_to_big);
				button5.startAnimation(animation1);
				i[2]=1;
				}
				else{
					uri = data.getData();
					Cursor cursor = IssueAcyivity.this.getContentResolver().query(
							uri, null, null, null, null);
					cursor.moveToFirst();
					String imgNo = cursor.getString(0); // 图片编号
					String imgPath = cursor.getString(1); // 图片文件路径
					String imgSize = cursor.getString(2); // 图片大小
					String imgName = cursor.getString(3); // 图片文件名 cursor.close();
															// //
					Options options = new BitmapFactory.Options(); //
					options.inJustDecodeBounds = false;
					options.inSampleSize = 10;
					Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
					Drawable drawable =new BitmapDrawable(bitmap);
					button4.setBackground(drawable);
				}
				break;
			case Activity.RESULT_CANCELED:
				break;
			}
			
			break;
		case 4:
			switch (resultCode) {
			case Activity.RESULT_OK:
				if(i[3]==0){
				uri = data.getData();
				Cursor cursor = IssueAcyivity.this.getContentResolver().query(
						uri, null, null, null, null);
				cursor.moveToFirst();
				String imgNo = cursor.getString(0); // 图片编号
				String imgPath = cursor.getString(1); // 图片文件路径
				String imgSize = cursor.getString(2); // 图片大小
				String imgName = cursor.getString(3); // 图片文件名 cursor.close();
														// //
				Options options = new BitmapFactory.Options(); //
				options.inJustDecodeBounds = false;
				options.inSampleSize = 10;
				Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
				Drawable drawable =new BitmapDrawable(bitmap);
				button5.setBackground(drawable);
				i[3]=1;
				}
				else{
					uri = data.getData();
					Cursor cursor = IssueAcyivity.this.getContentResolver().query(
							uri, null, null, null, null);
					cursor.moveToFirst();
					String imgNo = cursor.getString(0); // 图片编号
					String imgPath = cursor.getString(1); // 图片文件路径
					String imgSize = cursor.getString(2); // 图片大小
					String imgName = cursor.getString(3); // 图片文件名 cursor.close();
															// //
					Options options = new BitmapFactory.Options(); //
					options.inJustDecodeBounds = false;
					options.inSampleSize = 10;
					Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
					Drawable drawable =new BitmapDrawable(bitmap);
					button5.setBackground(drawable);
				}
				break;
			case Activity.RESULT_CANCELED:
				break;
			}
			
			break;
		}
	//5：处理条用系统图库后的处理

	}
	
	
}
