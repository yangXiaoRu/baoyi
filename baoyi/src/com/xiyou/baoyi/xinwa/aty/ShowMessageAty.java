package com.xiyou.baoyi.xinwa.aty;

import java.util.ArrayList;
import java.util.List;

import com.example.baoyi.R;
import com.xiyou.baoyi.xinwa.adapter.ArticleAdapter;
import com.xiyou.baoyi.xinwa.object.Content;
import com.xiyou.baoyi.xinwa.utils.AnalysisJSON;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class ShowMessageAty extends Activity{
	private ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_msg_aty);
		Intent i = getIntent();
		String str = i.getStringExtra("message");
		System.out.println("传递过来的文章为"+str);
		listView = (ListView) findViewById(R.id.show_msg_list);
		List<Content>list = new ArrayList<Content>();
		list = AnalysisJSON.getMessageList(str);
		ArticleAdapter adapter = new ArticleAdapter(list, this);
		listView.setAdapter(adapter);
		
	}
}

