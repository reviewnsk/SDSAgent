package com.aircode.sdsagent.component;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.aircode.sdsagent.R;

public class NotificationHelper {
    public static void registerChannel(Context context){
        CharSequence name = context.getString(R.string.channel_name);
        String description = context.getString(R.string.channel_desc);
        String channelId = context.getString(R.string.channel_id);
        int importance = NotificationManager.IMPORTANCE_LOW;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public static Notification getNotification(Context context){
        return new NotificationCompat.Builder(context,context.getString(R.string.channel_id))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setOngoing(true)
                .setContentTitle(context.getString(R.string.app_name))
                .setContentText(context.getString(R.string.noti_desc))
                .setPriority(NotificationCompat.PRIORITY_LOW).build();
    }

    public static Notification getEmptyNotification(Context context){
        //return new NotificationCompat.Builder(context,"").build();
        return new NotificationCompat.Builder(context).getNotification();
        //return new Notification.Builder(context).getNotification();
    }
}
