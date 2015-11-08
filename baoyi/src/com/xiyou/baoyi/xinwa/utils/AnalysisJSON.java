package com.xiyou.baoyi.xinwa.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.xiyou.baoyi.xinwa.object.Content;

public class AnalysisJSON {

	public static List<Content> getProvinceCities(String json) {
		List<Content> list = new ArrayList<Content>();

		try {
			JSONArray jsonArray = new JSONArray(json);
			int count = jsonArray.length();
			for (int i = 0; i < count; i++) {
				JSONObject object = jsonArray.getJSONObject(i);
				String detail = object.getString("detail");
				boolean img = false;
				if (detail.indexOf(".jpg") != -1
						|| detail.indexOf(".png") != -1) {
					img = true;
				}
				Content content = new Content(detail, img);

				list.add(content);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Content> getMessageList(String str) {
		List<Content> list = new ArrayList<Content>();
		String patternStr = "<image>([^<]*)</image>";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(str);
		System.out.println("��ȥ�˷�����,str=" + str);
		//�����Ϊ��ƥ��ͼƬ�ĵ�ַ�±�
		int matchStart = 0;
		//�����Ϊ��ƥ������
		int start = 0;
		
		// ����������ʽ�����￪ʼƥ��
		while (matcher.find()) {
			final String localFilePath = matcher.group(1);
			String matchString = matcher.group();
			System.out.println("matchString=" + matchString);
			System.out.println("localFilePath=" + localFilePath);
			//Ϊ�˷�ֹÿ���ַ������ظ�ƥ��ʱ��������������һ��ƥ��ĺ������ƥ�䣬�����ͱ�����
			//ÿ���ҵ�����ǰһ���ַ������±�
			final int matchStringStartIndex = str.indexOf(matchString,matchStart);
			final int matchStringEndIndex = matchStringStartIndex
					+ matchString.length();
			System.out.println("str���ܳ���Ϊ" + str.length() + ",��ʼ��Ϊ"
					+ matchStringStartIndex + ",������Ϊ" + matchStringEndIndex);
			String strContent;
			// ������bug������ôд�ģ������ǵ�ͼƬ��·��һ��ʱ�������ֻ��ƥ�䵽ǰ���·������������������
			//����һ�¸ղ���������ˣ��������������ԭ����
			//������ʹ��������ʽƥ��ʱ�������ƥ�䵽�ˣ������Զ����ϴ�ƥ���λ�ÿ�ʼƥ��
			//���������ԭ������ ������ƥ���������ͬʱ��str.indexof(string);������Ȼ�ҵ���ǰ��
			//ƥ��ɹ����ַ���
			strContent = str.substring(start, matchStringStartIndex);
			matchStart = matchStringEndIndex;
			start = matchStringEndIndex;
			
			Content txtContent = new Content(strContent, false);
			Content imgContent = new Content(localFilePath, true);

			list.add(txtContent);
			list.add(imgContent);
		}
		System.out.println("list�Ĵ�СΪ" + list.size());
		return list;
	}
}