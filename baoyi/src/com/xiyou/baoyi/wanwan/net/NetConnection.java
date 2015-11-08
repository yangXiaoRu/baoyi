package com.xiyou.baoyi.wanwan.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetConnection {
	// // 判断网络是否通畅
	public static boolean isConnected(Context context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {

				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnectedOrConnecting()) {

					// if (info.getState() == NetworkInfo.State.CONNECTED) {
					System.out.println(" 联网了");
					return true;
					// }
				}
			}
		} catch (Exception e) {
			System.out.println(" 网络判断出错了");

			return false;
		}
		System.out.println(" 最后的");

		return false;
	}

}
