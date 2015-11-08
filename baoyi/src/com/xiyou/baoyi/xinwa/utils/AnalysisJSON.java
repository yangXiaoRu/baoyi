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
		System.out.println("进去此方法中,str=" + str);
		//这个是为了匹配图片的地址下标
		int matchStart = 0;
		//这个是为了匹配文字
		int start = 0;
		
		// 表明正则表达式从哪里开始匹配
		while (matcher.find()) {
			final String localFilePath = matcher.group(1);
			String matchString = matcher.group();
			System.out.println("matchString=" + matchString);
			System.out.println("localFilePath=" + localFilePath);
			//为了防止每次字符串有重复匹配时，我们让他从上一次匹配的后面继续匹配，这样就避免了
			//每次找到的是前一次字符串的下表
			final int matchStringStartIndex = str.indexOf(matchString,matchStart);
			final int matchStringEndIndex = matchStringStartIndex
					+ matchString.length();
			System.out.println("str的总长度为" + str.length() + ",开始点为"
					+ matchStringStartIndex + ",结束点为" + matchStringEndIndex);
			String strContent;
			// 这里有bug，先这么写的，问题是当图片的路径一样时，他这个只能匹配到前面的路径，所以先这样做了
			//声明一下刚才是我想错了，真正出现问题的原因是
			//当我们使用正则表达式匹配时，如果他匹配到了，他是自动从上次匹配的位置开始匹配
			//出现问题的原因在与 当俩次匹配的内容相同时，str.indexof(string);，他当然找的是前面
			//匹配成功的字符串
			strContent = str.substring(start, matchStringStartIndex);
			matchStart = matchStringEndIndex;
			start = matchStringEndIndex;
			
			Content txtContent = new Content(strContent, false);
			Content imgContent = new Content(localFilePath, true);

			list.add(txtContent);
			list.add(imgContent);
		}
		System.out.println("list的大小为" + list.size());
		return list;
	}
}