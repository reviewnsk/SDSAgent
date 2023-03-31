package com.aircode.sdsagent.component;

import static android.content.ContentValues.TAG;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.aircode.sdsagent.setting.Config;
import com.aircode.sdsagent.setting.Define;

public class SDSAgentService extends Service {
    public SDSAgentService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"[SDSAgentService] onCreate() call");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"[SDSAgentService] onStartCommand()");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationHelper.registerChannel(this);
        }

        Notification notification = NotificationHelper.getNotification(this);;
        startForeground(Define.SERVICE_ID, notification);

        for(int i = 0 ; i < 5 ; i++){
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
            Log.d(TAG,"[SDSAgentService] call :"+ i +" sec");
        }
        //return super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}