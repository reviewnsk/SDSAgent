package com.aircode.sdsagent.component;


import static android.content.ContentValues.TAG;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.aircode.sdsagent.setting.Define;

public class SDSAgentReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.d(TAG,"[SDSAgentReceiver]  "+intent.getAction());
        if(Define.ACTION_STSRT.equals(intent.getAction())){
            Intent _intent = new Intent(context, SDSAgentService.class);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                context.startForegroundService(_intent);
            }else{
                context.startService(_intent);
            }
        }
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}