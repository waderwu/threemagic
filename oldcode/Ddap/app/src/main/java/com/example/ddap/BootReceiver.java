package com.example.ddap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

/**
 * Created by waderwu on 18-3-7.
 */

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO start your own service
//        Toast.makeText(context, "接收到开机启动广播", Toast.LENGTH_LONG).show();
        if (!Settings.canDrawOverlays(context)){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                Intent myintent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                context.startActivity(myintent);
            }
        }else{
            Intent serviceintent = new Intent(context, MyService.class);
            context.startService(serviceintent);
        }
    }

}