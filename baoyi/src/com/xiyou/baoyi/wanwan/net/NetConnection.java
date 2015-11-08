package com.xiyou.baoyi.wanwan.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetConnection {
	// // �ж������Ƿ�ͨ��
	public static boolean isConnected(Context context) {
		try {
			ConnectivityManager connectivity = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {

				NetworkInfo info = connectivity.getActiveNetworkInfo();
				if (info != null && info.isConnectedOrConnecting()) {

					// if (info.getState() == NetworkInfo.State.CONNECTED) {
					System.out.println(" ������");
					return true;
					// }
				}
			}
		} catch (Exception e) {
			System.out.println(" �����жϳ�����");

			return false;
		}
		System.out.println(" ����");

		return false;
	}

}
