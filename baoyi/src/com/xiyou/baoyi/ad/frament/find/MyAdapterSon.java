package com.xiyou.baoyi.ad.frament.find;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baoyi.R;



public class MyAdapterSon extends BaseAdapter {
	private List<Son> l;
	private Context context;
	private int selectItem = -1;

	public MyAdapterSon(Context context, List<Son> l) {
		this.context = context;
		setData(l);
	}

	@Override
	public int getCount() {
		return l.size();
	}

	@Override
	public Son getItem(int position) {
		return l.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	// ¸üÐÂadapter
	public void updataAdapter( List<Son> l) {
		setData(l);
		this.notifyDataSetChanged();
	}

	public void setData( List<Son> l) {
		if (l != null)
			this.l = l;
		else
			this.l = new ArrayList<Son>();
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder = null;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item1,
					null);
			holder.name = (TextView) convertView.findViewById(R.id.item1_name);
			holder.img = (ImageView) convertView.findViewById(R.id.item1_img);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		
		if (l.size()>0) {
			holder.name.setText(l.get(position).getName());
			
			if (position == selectItem) {
				convertView.setBackgroundColor(context.getResources().getColor(R.color.click));
				holder.img.setVisibility(View.VISIBLE);
			} else {
				convertView.setBackgroundColor(context.getResources().getColor(R.color.defult));
				holder.img.setVisibility(View.INVISIBLE);
			}
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

