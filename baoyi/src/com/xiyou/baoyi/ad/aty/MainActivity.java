package com.xiyou.baoyi.ad.aty;



import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.baoyi.R;
import com.xiyou.baoyi.ad.frament.FindActivity;
import com.xiyou.baoyi.ad.frament.First_Frament;
import com.xiyou.baoyi.wanwan.aty.ShukuActivity;
import com.xiyou.baoyi.wanwan.aty.WodeActivity;
import com.xiyou.baoyi.xinwa.aty.PullToRefreshAty;


public class MainActivity extends Activity {

	private Button button;
	private RadioButton btnDiscover;
	private RadioButton btnBook;
	private RadioButton btnMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();
        button=(Button)findViewById(R.id.button_find);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			//	final Animation animation1=new AnimationUtils().loadAnimation(MainActivity.this,R.anim.out_to_life);
			//	final Animation animation=new AnimationUtils().loadAnimation(MainActivity.this,R.anim.in_from_right);
				
				
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, FindActivity.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);	
			}
		});
        First_Frament frament=new First_Frament(MainActivity.this);
		FragmentTransaction transaction=getFragmentManager().beginTransaction();
		transaction.replace(R.id.login_frament, frament);
		transaction.commit();
		btnDiscover = (RadioButton) findViewById(R.id.radiobutton3);
		btnBook = (RadioButton) findViewById(R.id.radiobutton2);
		btnMy = (RadioButton) findViewById(R.id.radiobutton4);
		btnDiscover.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, PullToRefreshAty.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		btnBook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, ShukuActivity.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
		btnMy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, WodeActivity.class);
				startActivity(intent);
				overridePendingTransition( R.anim.in_from_right,R.anim.out_to_life);
			}
		});
      
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
