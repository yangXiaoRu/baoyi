package com.xiyou.baoyi.ad.frament.find;

import java.io.Serializable;
import java.util.List;

public class Father implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int image;
	private List<Son> sonList;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Son> getSonList() {
		return sonList;
	}
	public void setSonList(List<Son> sonList) {
		this.sonList = sonList;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}

	
}

