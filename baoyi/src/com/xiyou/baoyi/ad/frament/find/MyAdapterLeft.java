package com.xiyou.baoyi.ad.frament.find;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baoyi.R;
public class MyAdapterLeft extends BaseAdapter {
	private List<Father> l;
	private Context context;
	private int selectItem = -1;

	public MyAdapterLeft(Context context, List<Father> l) {
		this.context = context;
		this.l = l;
	}

	@Override
	public int getCount() {
		return l.size();
	}

	@Override
	public Object getItem(int position) {
		return l.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item,
					null);
			holder.name = (TextView) convertView.findViewById(R.id.name);
			holder.img = (ImageView) convertView.findViewById(R.id.img);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
			holder.name.setText(l.get(position).getName());
			holder.img.setImageResource(l.get(position).getImage());
	
		if (position == selectItem) {
			convertView.setBackgroundColor(context.getResources().getColor(R.color.click));
			holder.name.setTextColor(Color.BLUE);
		} else {
			convertView.setBackgroundColor(context.getResources().getColor(R.color.defult));
			holder.name.setTextColor(Color.BLACK);
		}
		return convertView;
	}

	public void setSelectItem(int selectItem) {
		this.selectItem = selectItem;
	}

	class Holder {
		TextView name;
		ImageView img;
	}
	private void show(String str) {
		Toast.makeText(context, str, 0).show();
	}
}
