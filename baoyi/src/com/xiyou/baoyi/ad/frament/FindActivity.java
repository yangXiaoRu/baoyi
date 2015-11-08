package com.xiyou.baoyi.ad.frament;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.baoyi.R;

public class FindActivity extends Activity {

	private Button button;
	private EditText editText;
	private RadioGroup group;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.findactivity);
		getActionBar().hide();
		button = (Button) findViewById(R.id.off_button);
		editText = (EditText) findViewById(R.id.find_editText);
		group = (RadioGroup) findViewById(R.id.find_radiogroup);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				editText.setText("");
			}
		});
		group.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				RadioButton button1 = (RadioButton) findViewById(R.id.type_radiobutton1);
				RadioButton button2 = (RadioButton) findViewById(R.id.type_radiobutton2);
				RadioButton button3 = (RadioButton) findViewById(R.id.type_radiobutton3);
				RadioButton button4 = (RadioButton) findViewById(R.id.type_radiobutton4);
				
				if (arg1 == R.id.type_radiobutton1) {

					button1.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    课本");
				} else {
					button1.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.type_radiobutton2) {

					button2.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.wirte));
					button1.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    图书");
				} else {
					button2.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.type_radiobutton3) {

					button3.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
					button1.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    电子");
				} else {
					button3.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				}
				if (arg1 == R.id.type_radiobutton4) {

					button4.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.wirte));
					button2.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
					button1.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
					button3.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				//	editText.setText("    生活");
				} else {
					button4.setTextColor(FindActivity.this.getResources()
							.getColor(R.color.black));
				}

			}
		});
	}

}
