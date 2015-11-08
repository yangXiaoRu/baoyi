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

	// �Զ���ķ�������ķ���
	public String get(final String url) {
		// ��Ӧ
		HttpResponse mHttpResponse = null;
		// ʵ��
		HttpEntity mHttpEntity = null;
		// ����һ���������
		HttpGet httpGet = new HttpGet(url);
		// ����һ��Http�ͻ��˶���
		HttpClient httpClient = new DefaultHttpClient();
		// ����ʹ��Http�ͻ��˷������󣬲���ȡ��Ӧ����

		InputStream inputStream = null;
		try {
			// �������󲢻����Ӧ����
			mHttpResponse = httpClient.execute(httpGet);
			// �����Ӧ����Ϣʵ��
			mHttpEntity = mHttpResponse.getEntity();

			// ��ȡһ��������
			inputStream = mHttpEntity.getContent();

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));

			String result = "";
			String line = "";
			while (null != (line = bufferedReader.readLine())) {
				result += line;
			}

			// �������ӡ������������LogCat�鿴
			System.out.println("��ȡ���Ľ��Ϊ��"+result);
			return result;
		} catch (Exception e) {
			System.out.println("����get�������");
		}
		return null;
	}
}