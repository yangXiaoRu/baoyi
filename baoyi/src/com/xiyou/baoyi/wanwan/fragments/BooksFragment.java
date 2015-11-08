package com.xiyou.baoyi.wanwan.fragments;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.baoyi.R;
import com.xiyou.baoyi.wanwan.adapter.gridViewAdapter;
import com.xiyou.baoyi.wanwan.aty.GoodsDetailActivity;
import com.xiyou.baoyi.wanwan.object.book_information;
import com.xiyou.baoyi.wanwan.view.MyGridView;

@SuppressLint({ "ValidFragment", "NewApi" })
public class BooksFragment extends Fragment {
	private MyGridView GridViewList;
	private Context context;
	private int id;
	private gridViewAdapter adapter;
	private ArrayList<book_information> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("on onCreateView");
		View view = inflater.inflate(R.layout.book_fragment_layout, container,
				false);
		GridViewList = (MyGridView) view
				.findViewById(R.id.GridViewList);
		inite(id);

		return view;
	}

	// ���췽��
	public BooksFragment(Context c, int id) {
		System.out.println("���췽��");
		context = c;
		this.id = id;
	}

	private void inite(int tag) {
		switch (tag) {
		case 0:
			initeGridView_kaoyan();

			break;
		case 1:
			initeGridView_dianzi();

			break;
		case 2:
			initeGridView_jingji();
			break;
		case 3:

			initeGridView_novel();
		case 4:

		case 5:

			break;
		default:
			break;
		}
		// setViewPagerHeightBasedOnChildren();
	}

	
	private void initeGridView_kaoyan() {

		list = new ArrayList<book_information>();
		book_information b1 = new book_information("��������", 34f, "���壬��ѧ");
		b1.setPhoto(R.drawable.kaoyan_1);
		b1.setTupians(new String[] { "http://pic8.nipic.com/20100701/4905013_144046018575_2.jpg" });

		book_information b2 = new book_information("������ƫ��", 86f, "���");
		b2.setPhoto(R.drawable.kaoyan_2);
		b2.setTupians(new String[] { "http://pica.nipic.com/2007-09-25/20079251549954_2.jpg" });

		book_information b3 = new book_information("ͯ��", 13f, "�Դ�");
		b3.setPhoto(R.drawable.kaoyan_3);
		b3.setTupians(new String[] { "http://pic15.nipic.com/20110616/3596785_200756600000_2.jpg" });

		book_information b4 = new book_information("�軨Ů", 8f, "���");
		b4.setPhoto(R.drawable.kaoyan_4);
		b4.setTupians(new String[] { "http://pic4.nipic.com/20090827/2523450_111759002793_2.jpg" });

		book_information b5 = new book_information("��������", 34f, "���壬��ѧ");
		b5.setPhoto(R.drawable.kaoyan_1);
		b5.setTupians(new String[] { "http://pic8.nipic.com/20100701/4905013_144046018575_2.jpg" });

		book_information b6 = new book_information("������ƫ��", 86f, "���");
		b6.setPhoto(R.drawable.kaoyan_2);
		b6.setTupians(new String[] { "http://pica.nipic.com/2007-09-25/20079251549954_2.jpg" });

		book_information b7 = new book_information("ͯ��", 13f, "�Դ�");
		b7.setPhoto(R.drawable.kaoyan_3);
		b7.setTupians(new String[] { "http://pic15.nipic.com/20110616/3596785_200756600000_2.jpg" });

		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b4);
		list.add(b6);
		list.add(b7);

		System.out.println("��һ�ν��뿼�еĳ�ʼ��");
		adapter = new gridViewAdapter(list, context);
		GridViewList.setAdapter(adapter);
		GridViewList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ����ϸ���桢
				System.out.println("�����");
				Intent intent = new Intent(context, GoodsDetailActivity.class);
				context.startActivity(intent);
			}
		});

	}

	private void initeGridView_dianzi() {
		list = new ArrayList<book_information>();
		book_information b1 = new book_information("��������", 34f, "���壬��ѧ");
		b1.setPhoto(R.drawable.dianzi_1);
		book_information b2 = new book_information("������ƫ��", 86f, "���");
		b2.setPhoto(R.drawable.dianzi_2);

		book_information b3 = new book_information("ͯ��", 13f, "�Դ�");
		b3.setPhoto(R.drawable.dianzi_3);

		book_information b4 = new book_information("�軨Ů", 8f, "���");
		b4.setPhoto(R.drawable.dianzi_4);

		book_information b5 = new book_information("�軨Ů", 8f, "���");
		b5.setPhoto(R.drawable.dianzi_5);

		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);

		adapter = new gridViewAdapter(list, context);
		GridViewList.setAdapter(adapter);
		GridViewList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ����ϸ����
				Intent intent = new Intent(context, GoodsDetailActivity.class);
				context.startActivity(intent);
			}
		});

	}

	private void initeGridView_jingji() {
		list = new ArrayList<book_information>();
		book_information b1 = new book_information("���ص�", 22f, "̽��");
		b1.setPhoto(R.drawable.jingji_1);
		book_information b2 = new book_information("��������", 34f, "���壬��ѧ");
		b2.setPhoto(R.drawable.jingji_2);

		book_information b3 = new book_information("�����ϵ�5����", 42f, "̽��");
		b3.setPhoto(R.drawable.jingji_3);

		book_information b4 = new book_information("�軨Ů", 8f, "���");
		b4.setPhoto(R.drawable.jingji_4);

		book_information b5 = new book_information("ͯ��", 13f, "�Դ�");
		b5.setPhoto(R.drawable.jingji_5);

		book_information b6 = new book_information("����������", 6f, "�Ͽ���");
		b6.setPhoto(R.drawable.jingji_6);

		// book_information b7 = new book_information("����", 5.8f, "С˵");
		// book_information b8 = new book_information("������ƫ��", 86f, "���");
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(b5);
		list.add(b6);
		// list.add(b7);
		// list.add(b8);

		adapter = new gridViewAdapter(list, context);
		GridViewList.setAdapter(adapter);
		GridViewList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ����ϸ����
				Intent intent = new Intent(context, GoodsDetailActivity.class);
				context.startActivity(intent);
			}
		});

	}

	private void initeGridView_novel() {
		list = new ArrayList<book_information>();
		book_information b1 = new book_information("���ݷ���", 34f, "��ѧ");
		book_information b2 = new book_information("�ߵȴ���", 86f, "��ѧ");
		book_information b3 = new book_information("��������", 13f, "��ѧ");
		book_information b4 = new book_information("���������", 8f, "�����");
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);

		adapter = new gridViewAdapter(list, context);
		GridViewList.setAdapter(adapter);
		GridViewList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// ����ϸ����
				Intent intent = new Intent(context, GoodsDetailActivity.class);
				context.startActivity(intent);
			}
		});

	}
}
