package com.xiyou.baoyi.ad.frament;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.baoyi.R;

public class FreeBookActivity extends Activity{

	private ListView listView;
	private RadioGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.freebookactivity);
		getActionBar().hide();
		group=(RadioGroup)findViewById(R.id.freebookactivity_radiogroup);
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				RadioButton button1 = (RadioButton) findViewById(R.id.freebookactivity_radiobutton1);
				RadioButton button2 = (RadioButton) findViewById(R.id.freebookactivity_radiobutton2);
				RadioButton button3 = (RadioButton) findViewById(R.id.freebookactivity_radiobutton3);
				RadioButton button4 = (RadioButton) findViewById(R.id.freebookactivity_radiobutton4);
		//		button1.setChecked(true);
				if (arg1 == R.id.freebookactivity_radiobutton1) {

					button1.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button4.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    课本");
				} else {
					button1.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.freebookactivity_radiobutton2) {

					button2.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.wirte));
					button1.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button4.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    图书");
				} else {
					button2.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.freebookactivity_radiobutton3) {

					button3.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button1.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button4.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    电子");
				} else {
					button3.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.freebookactivity_radiobutton4) {

					button4.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button1.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    生活");
				} else {
					button4.setTextColor(FreeBookActivity.this.getResources()
							.getColor(R.color.black));
				}

			}
		});
		listView=(ListView)findViewById(R.id.free_booklistView);
		BaseAdapter adapter=new BaseAdapter() {
			
			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				// TODO Auto-generated method stub
				View view=FreeBookActivity.this.getLayoutInflater().inflate(R.layout.freelistviewbook, arg2, false);
				return view;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 10;
			}
		};
		listView.setAdapter(adapter);
	}

}
