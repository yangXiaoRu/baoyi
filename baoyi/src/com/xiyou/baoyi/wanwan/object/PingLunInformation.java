package com.xiyou.baoyi.wanwan.object;

//存储评论信息
public class PingLunInformation {
	String word;// 说的话
	String touxiang;// 头像
	String name;// 昵称

	public PingLunInformation(String w, String toux,String n) {
		word = w;
		touxiang = toux;
		name=n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getTouxiang() {
		return touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}

}
