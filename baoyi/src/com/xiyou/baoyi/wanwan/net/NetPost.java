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
	// ��������б�
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
			// URLʹ�û���URL���ɣ����в���Ҫ�Ӳ���
			HttpPost httpPost = new HttpPost(baseUrl);
			// �����������ݼ���������
			httpPost.setEntity(requestHttpEntity);
			// ��Ҫ�ͻ��˶�������������
			HttpClient httpClient = new DefaultHttpClient();
			// ��������
			HttpResponse response = httpClient.execute(httpPost);
			// ��ʾ��Ӧ
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
			System.out.println("post�����������");
		}
		return "";

	}
}
