package com.xiyou.baoyi.wanwan.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class NetGet {
	public NetGet() {
	}

	// 自定义的访问网络的方法
	public String get(final String url) {
		// 响应
		HttpResponse mHttpResponse = null;
		// 实体
		HttpEntity mHttpEntity = null;
		// 生成一个请求对象
		HttpGet httpGet = new HttpGet(url);
		// 生成一个Http客户端对象
		HttpClient httpClient = new DefaultHttpClient();
		// 下面使用Http客户端发送请求，并获取响应内容

		InputStream inputStream = null;
		try {
			// 发送请求并获得响应对象
			mHttpResponse = httpClient.execute(httpGet);
			// 获得响应的消息实体
			mHttpEntity = mHttpResponse.getEntity();

			// 获取一个输入流
			inputStream = mHttpEntity.getContent();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));

			String result = "";
			String line = "";
			while (null != (line = bufferedReader.readLine())) {
				result += line;
			}

			// 将结果打印出来，可以在LogCat查看
			System.out.println("获取到的结果为："+result);
			return result;
		} catch (Exception e) {
			System.out.println("网络get请求出错！");
		}
		return null;
	}
}