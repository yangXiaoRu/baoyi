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
		// 当监听到开机消息时的处理

		NotificationManager nm = (NotificationManager) context
				.getSystemService(context.NOTIFICATION_SERVICE);

		Intent intent = new Intent(context, ShukuActivity.class);
		// 设置当前intent要启动的界面如果已经创建实例情况下的处理方式
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_NEW_TASK);
		// pendingIntent用于封装intent

		PendingIntent pi = PendingIntent.getActivity(context, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		Notification n = new Notification.Builder(context).setAutoCancel(true)
				.setTicker("这是在状态栏里面滚动显示的信息").setContentText("这是消息的实际内容")
				.setContentIntent(pi).setWhen(System.currentTimeMillis())
				.setContentTitle("消息的内容标题")
				.setSmallIcon(R.drawable.ic_launcher).build();
		// 第一个参数是当前notification的标志（用于将来删除）
		nm.notify(12, n);

	}

}
