package com.xiyou.baoyi.wanwan.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class goodsViewPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragments;

	public goodsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
		super(fm);
		fragments = list;
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.size();
	}

}
