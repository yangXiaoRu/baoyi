package com.xiyou.baoyi.xinwa.object;

public class Content {
	private String str;
	private boolean isImg;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public boolean isImg() {
		return isImg;
	}

	public void setImg(boolean isImg) {
		this.isImg = isImg;
	}

	public Content(String str, boolean isImg) {
		super();
		this.str = str;
		this.isImg = isImg;
	}
	
}
