package com.aircode.sdsagent;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.aircode.sdsagent.component.SDSAgentService;
import com.aircode.sdsagent.setting.Config;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog dialog;
    private  Dialog d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"[SDSAgent] APP STAT");

        if(Config.IS_START_SERVICE_POSITION_ACTIVITY){
            Intent intent = new Intent(getApplicationContext(), SDSAgentService.class);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                startForegroundService(intent);
            }else{
                startService(intent);
            }
        }
        setContentView(R.layout.activity_main);

        if(dialog != null && dialog.isShowing()){
            dialog.dismiss();
            dialog = null;
        }

        if(d != null && d.isShowing()){
            d.dismiss();
            d = null;
        }

        finish();
    }

}