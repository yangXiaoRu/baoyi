package com.richtext.xinwa.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.baoyi.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class RichEditText extends EditText {

	private Context mContext;

	private Editable mEditable;

	public RichEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	public RichEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	public RichEditText(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.mContext = context;
	}

	/**
	 * ���һ��ͼƬ
	 * 
	 * @param bitmap
	 * @param uri
	 */
	public void addImage(Bitmap bitmap, String filePath) {
		Log.i("imgpath", filePath);
		// String pathTag = "<img src=\"" + filePath + "\"/>";
		String pathTag = "<image>" + filePath + "</image>";
		SpannableString spanString = new SpannableString(pathTag);
		// ��ȡ��Ļ�Ŀ��
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int bmWidth = bitmap.getWidth();// ͼƬ�߶�
		int bmHeight = bitmap.getHeight();// ͼƬ���
		int zoomWidth = getWidth() - (paddingLeft + paddingRight);
		int zoomHeight = (int) (((float) zoomWidth / (float) bmWidth) * bmHeight);
		Bitmap newBitmap = zoomImage(bitmap, zoomWidth, zoomHeight);
		ImageSpan imgSpan = new ImageSpan(mContext, newBitmap);
		spanString.setSpan(imgSpan, 0, pathTag.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		mEditable = this.getText(); // ��ȡedittext����
		
		System.out.println("���ͼƬ֮ǰ������Ϊ" + mEditable.toString());
		this.setSelection(mEditable.length());
		System.out.println("1.selection�ĳ���Ϊ" + mEditable.length());
		mEditable.append("\n");// ����spanStringҪ��ӵ�λ��
		this.setSelection(mEditable.length());
		System.out.println("2.selection�ĳ���Ϊ" + mEditable.length());
		int start = this.getSelectionStart(); // ��������ӵ�λ��
		System.out.println("startΪ" + start);
		mEditable.insert(start, spanString);
		mEditable.append("\n");// ����spanStringҪ��ӵ�λ��
		this.setText(mEditable);
		this.setSelection(mEditable.length());
		System.out.println("ͼƬ������֮�󳤶�Ϊ" + mEditable.length() + ",selectionΪ"
				+ mEditable.length());
		// ������ƶ����
	}

	/**
	 * 
	 * @param bitmap
	 * @param filePath
	 * @param start
	 * @param end
	 */
	public void addImage(Bitmap bitmap, String filePath, int start, int end) {
		Log.i("imgpath", filePath);
		filePath = filePath.substring(6);
		// String pathTag = "<img src=\"" + filePath + "\"/>";
		String pathTag = "<image>" + filePath + "</image>";
		SpannableString spanString = new SpannableString(pathTag);
		// ��ȡ��Ļ�Ŀ��
		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int bmWidth = bitmap.getWidth();// ͼƬ�߶�
		int bmHeight = bitmap.getHeight();// ͼƬ���
		int zoomWidth = getWidth() - (paddingLeft + paddingRight);
		int zoomHeight = (int) (((float) zoomWidth / (float) bmWidth) * bmHeight);
		Bitmap newBitmap = zoomImage(bitmap, zoomWidth, zoomHeight);
		ImageSpan imgSpan = new ImageSpan(mContext, newBitmap);
		spanString.setSpan(imgSpan, 0, pathTag.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		Editable editable = this.getText(); // ��ȡedittext����

		editable.delete(start, end);// ɾ��
		editable.insert(start, spanString); // ����spanStringҪ��ӵ�λ��
	}

	/**
	 * 
	 * @param bitmap
	 * @param filePath
	 * @param start
	 * @param end
	 */
	public void addDefaultImage(String filePath, int start, int end) {
		Log.i("imgpath", filePath);
		System.out.println("·��Ϊ" + filePath);
		// String pathTag = "<img src=\"" + filePath + "\"/>";
		String pathTag = "<image>" + filePath + "</image>";
		SpannableString spanString = new SpannableString(pathTag);
		// ��ȡ��Ļ�Ŀ��
		// Bitmap Bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.default_img);
		Bitmap Bitmap = BitmapFactory.decodeFile(filePath);

		int paddingLeft = getPaddingLeft();
		int paddingRight = getPaddingRight();
		int bmWidth = Bitmap.getWidth();// ͼƬ�߶�
		int bmHeight = Bitmap.getHeight();// ͼƬ���
		System.out.println("����֮ǰͼƬ�Ŀ��Ϊ,width=" + bmWidth + ",height+"
				+ bmHeight);
		int zoomWidth = getWidth() - (paddingLeft + paddingRight);

		int zoomHeight = (int) (((float) zoomWidth / (float) bmWidth) * bmHeight);
		System.out.println("ZoomImageͼƬ�Ŀ��Ϊ,width=" + zoomWidth + ",height+"
				+ zoomHeight);
		Bitmap newBitmap = zoomImage(Bitmap, zoomWidth, zoomHeight);
		System.out.println("����֮��ͼƬ�Ŀ��Ϊ,width=" + newBitmap.getWidth()
				+ ",height+" + newBitmap.getHeight());
		if (Bitmap == null) {
			System.out.println("bitmapΪ��");
		}
		ImageSpan imgSpan = new ImageSpan(mContext, newBitmap);
		spanString.setSpan(imgSpan, 0, pathTag.length(),
				Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		if (mEditable == null) {
			mEditable = this.getText(); // ��ȡedittext����
		}
		mEditable.delete(start, end);// ɾ��
		mEditable.insert(start, spanString); // ����spanStringҪ��ӵ�λ��
	}

	/**
	 * ��ͼƬ��������
	 * 
	 * @param bgimage
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
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

	public void setRichText(String text) {
		this.setText("");
		this.mEditable = this.getText();
		this.mEditable.append(text);
		// ��������
		// String str = "<img src=\"([/\\w\\W/\\/.]*)\"\\s*/>";
		String str = "<image>([^<]*)</image>";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			final String localFilePath = matcher.group(1);
			String matchString = matcher.group();
			System.out.println("�ҵ���·��ΪmatchString=" + matchString);
			System.out.println("����һ��ΪlocalFilePath=" + localFilePath);

			final int matchStringStartIndex = text.indexOf(matchString);
			final int matchStringEndIndex = matchStringStartIndex
					+ matchString.length();

			setSelection(matchStringEndIndex);
			mEditable.append("\n");
			ImageLoader.getInstance().loadImage("file:/" + localFilePath,
					getDisplayImageOptions(), new ImageLoadingListener() {

						@Override
						public void onLoadingStarted(String uri, View arg1) {
							// TODO Auto-generated method stub
							// ����һ��Ĭ��ͼƬ
							System.out.println("���ؿ�ʼ");
							// addDefaultImage(localFilePath,
							// matchStringStartIndex, matchStringEndIndex);

						}

						@Override
						public void onLoadingFailed(String arg0, View arg1,
								FailReason arg2) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onLoadingComplete(String uri, View arg1,
								Bitmap bitmap) {
							// TODO Auto-generated method stub
							System.out.println("�������");
							addImage(bitmap, uri, matchStringStartIndex,
									matchStringEndIndex);
							// addImage(bitmap,uri);
						}

						@Override
						public void onLoadingCancelled(String arg0, View arg1) {
							// TODO Auto-generated method stub

						}
					});
		}
		this.setText(mEditable);
	}

	private DisplayImageOptions getDisplayImageOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.default_image)
				.showImageForEmptyUri(R.drawable.default_image)
				.showImageOnFail(R.drawable.default_img).cacheOnDisk(true)
				.cacheInMemory(true).bitmapConfig(Bitmap.Config.RGB_565)
				.considerExifParams(true).build();
		return options;
	}

	public String getRichText() {
		// System.out.println("���������Ϊ"+getText().toString());
		return this.getText().toString();
	}

}
