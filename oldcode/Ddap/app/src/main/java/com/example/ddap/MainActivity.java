package com.example.ddap;

import android.app.DialogFragment;
import android.app.admin.DevicePolicyManager;
import android.bluetooth.BluetoothClass;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    private Button btnLock;
    private DevicePolicyManager mDpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mDpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
//
//        btnLock = (Button) findViewById(R.id.button);
//        btnLock.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                // lock screen
//                mDpm.lockNow();
//                mDpm.resetPassword("12345678",0);
//            }
//        });
//
//        ComponentName mDeviceAdminSample = new ComponentName(this,DdapReceiver.class);
//        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
//        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,mDeviceAdminSample);
//        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,"begin go");
//        startActivity(intent);

//        Button button = (Button) findViewById(R.id.button7);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DialogFragment newFragment = new TimePickerFragment();
//                newFragment.show(getSupportFragmentManager(), "timePicker");
//            }
//        });



        if (!Settings.canDrawOverlays(this)){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                Intent myintent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(myintent);
            }
        }else{
            Intent serviceintent = new Intent(this, MyService.class);
            startService(serviceintent);
        }



    }
//    @Override
//    protected void onActivityResult(int resquestCode, int resultCode, Intent data){
//
//    }
}
