package com.xiyou.baoyi.wanwan.object;

import com.example.baoyi.R;

public class book_information {
	String name;
	float price;
	String desctiption;
	String[] tupians = null;
	int sold;
	int photo = R.drawable.ad_1;
	int num = 0;
	String boss = "Ò×±¦";

	public book_information(String n, float p, String d) {
		name = n;
		price = p;
		desctiption = d;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPhoto() {
		return photo;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDesctiption() {
		return desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public String[] getTupians() {
		return tupians;
	}

	public void setTupians(String[] tupians) {
		this.tupians = tupians;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

}
