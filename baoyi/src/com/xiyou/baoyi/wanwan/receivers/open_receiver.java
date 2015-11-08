package com.xiyou.baoyi.wanwan.receivers;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.baoyi.R;
import com.xiyou.baoyi.wanwan.aty.ShukuActivity;

public class open_receiver extends BroadcastReceiver {

	@SuppressLint("NewApi")
	@Override
	public void onReceive(Context context, Intent intent1) {
		// ��������������Ϣʱ�Ĵ���

		NotificationManager nm = (NotificationManager) context
				.getSystemService(context.NOTIFICATION_SERVICE);

		Intent intent = new Intent(context, ShukuActivity.class);
		// ���õ�ǰintentҪ�����Ľ�������Ѿ�����ʵ������µĴ���ʽ
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		// pendingIntent���ڷ�װintent

		PendingIntent pi = PendingIntent.getActivity(context, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		Notification n = new Notification.Builder(context).setAutoCancel(true)
				.setTicker("������״̬�����������ʾ����Ϣ").setContentText("������Ϣ��ʵ������")
				.setContentIntent(pi).setWhen(System.currentTimeMillis())
				.setContentTitle("��Ϣ�����ݱ���")
				.setSmallIcon(R.drawable.ic_launcher).build();
		// ��һ�������ǵ�ǰnotification�ı�־�����ڽ���ɾ����
		nm.notify(12, n);

	}

}
