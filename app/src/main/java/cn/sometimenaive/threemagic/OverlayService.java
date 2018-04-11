package cn.sometimenaive.threemagic;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by waderwu on 18-4-11.
 */

public class OverlayService extends Service {

    final Context mcontext = this;

    public OverlayService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("info","myservice create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId){

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0,0,
                PixelFormat.TRANSPARENT
        );
        // flag 设置 Window 属性
        layoutParams.flags = 128;
        // type 设置 Window 类别（层级）
//      layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.type = 2010;
        final WindowManager windowManager = (WindowManager) this.getSystemService(WINDOW_SERVICE);

        final View view1 = View.inflate(this,R.layout.overlay,null);

//         windowManager.addView(floatingButton, layoutParams);

        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0,0,
                PixelFormat.TRANSPARENT
        );
        layoutParams2.gravity = Gravity.BOTTOM;
        layoutParams2.flags =  WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        layoutParams2.type = WindowManager.LayoutParams.TYPE_PHONE;
//           windowManager.addView(editText, layoutParams2);
        windowManager.addView(view1,layoutParams);

        Button button_my = (Button) view1.findViewById(R.id.button2);
        final EditText editText1 = (EditText) view1.findViewById(R.id.editText);
        button_my.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("test","you press button, and your password is "+editText1.getText().toString());
                if (editText1.getText().toString().equals("12345678")){
                    Log.d("tag","over");
                    windowManager.removeViewImmediate(view1);
//                        stopForeground(true);
//                        stopSelf();
                    android.os.Process.killProcess(android.os.Process.myPid());

                }
//                    Toast.makeText(MyService.this,"you also press button, and your password is "+editText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        Log.d("info","ondestroy");
        super.onDestroy();
    }
}