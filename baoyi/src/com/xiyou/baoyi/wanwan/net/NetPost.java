package com.xiyou.baoyi.wanwan.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

public class NetPost {
	// 传入参数列表
	List<NameValuePair> pairList = new ArrayList<NameValuePair>();
	String baseUrl;

	public NetPost(String baseUrl, List<NameValuePair> pairList) {
		this.baseUrl = baseUrl;
		this.pairList = pairList;
	}

	public String post() {
		try {
			HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList,
					HTTP.UTF_8);
			// URL使用基本URL即可，其中不需要加参数
			HttpPost httpPost = new HttpPost(baseUrl);
			// 将请求体内容加入请求中
			httpPost.setEntity(requestHttpEntity);
			// 需要客户端对象来发送请求
			HttpClient httpClient = new DefaultHttpClient();
			// 发送请求
			HttpResponse response = httpClient.execute(httpPost);
			// 显示响应
			if (null == response) {
				return "";
			}

			HttpEntity httpEntity = response.getEntity();
			InputStream inputStream = httpEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String result = "";
			String line = "";
			while (null != (line = reader.readLine())) {
				result += line;
			}

			return result;
		} catch (Exception e) {
			System.out.println("post网络请求出错！");
		}
		return "";

	}
}
