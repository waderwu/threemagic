package cn.sometimenaive.threemagic;

/**
 * Created by waderwu on 18-4-12.
 */

import java.io.IOException;
import java.util.List;
import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

@SuppressLint("NewApi")
public class LuckMoneyService extends AccessibilityService
{
    static final String TAG = "LuckMoneyService";
    static final String PACKAGENAME = "com.tencent.mm";
    private Handler handler = new Handler();
    @Override
    public void onAccessibilityEvent(final AccessibilityEvent event) {
        int eventType = event.getEventType();
        Log.d("LuckMoneyService", "get envnet = " + eventType);
        switch (eventType){
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                Log.d("mylog","get notification event");
                List<CharSequence> texts = event.getText();
                for (CharSequence text : texts){
                    Log.d("text",text.toString());
                    if (text.toString().contains("[QQ红包]")){
                        ClickNotification(event);
                    }
                }
                Log.d("end","---------------");
                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                openHongBao(event);
                break;
        }
    }

    @Override
    public void onInterrupt()
    {
        Toast.makeText(this, "中断抢红包服务", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onServiceConnected()
    {
        super.onServiceConnected();
        Toast.makeText(this, "连接抢红包服务", Toast.LENGTH_SHORT).show();
    }
    //点击通知事件
    private void ClickNotification(AccessibilityEvent event) {
        if (event.getParcelableData() != null && event.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) event.getParcelableData();
            String content = notification.tickerText.toString();

            Log.d(TAG+"hhahah",content);

            PendingIntent pendingIntent = notification.contentIntent;
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }


        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void openHongBao(AccessibilityEvent event)
    {
        CharSequence className = event.getClassName();

        Log.d(TAG+"class",className.toString());
        checkKey2();

//        if ("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI".equals(className))
//        {
//            // 点中了红包，下一步就是去拆红包
//            checkKey1();
//        } else if ("com.tencent.mm.ui.LauncherUI".equals(className) || "com.tencent.mobileqq.activity.ChatActivity".equals(className))
//        {
//            // 在聊天界面,去点中红包
//            checkKey2();
//        } else
//        {
//            // 在聊天界面,去点中红包
//            checkKey2();
//        }
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void checkKey2()
    {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo == null)
        {
            Log.w(TAG, "rootWindow为空");
            return;
        }
//        List<AccessibilityNodeInfo> wxList = nodeInfo.findAccessibilityNodeInfosByText("领取红包");
        List<AccessibilityNodeInfo> qqList = nodeInfo.findAccessibilityNodeInfosByText("QQ红包");
        Log.d(TAG,qqList.size()+"");

        if (!qqList.isEmpty())
        {
            qqList = nodeInfo.findAccessibilityNodeInfosByText("QQ红包");
            for (AccessibilityNodeInfo n : qqList)
            {
                Log.d(TAG,n.getText().toString());
                Log.d(TAG+"parent",n.getText().toString());
                n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                break;
            }
        }

        if (!qqList.isEmpty())
        {

            // 界面上的红包总个数
            int totalCount = qqList.size();
            Log.d("count",totalCount+"");
            // 领取最近发的红包
            for (int i = totalCount - 1; i >= 0; i--)
            {
                // 如果为领取过该红包，则执行点击、
                AccessibilityNodeInfo parent = qqList.get(i).getParent();
                Log.i(TAG, "-->领取红包:" + parent);
                if (parent != null)
                {
                    parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
//                pressBackButton();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        back2Home();
                    }
                }, 1000);

                break;
            }

        }

    }

    private void back2Home(){
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.setFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }


    private void pressBackButton(){
        Runtime runtime = Runtime.getRuntime();
        Log.d("back","back");
        try {
            runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    static final String TAG = "LuckMoneyService";
//
//    /** 微信的包名 */
//    static final String WECHAT_PACKAGENAME = "com.tencent.mm";
//    /** 红包消息的关键字 */
//    static final String WX_HONGBAO_TEXT_KEY = "[微信红包]";
//    static final String QQ_HONGBAO_TEXT_KEY = "[QQ红包]";
//    private boolean caihongbao = false;
//
//    Handler handler = new Handler();
//
//    @Override
//    public void onAccessibilityEvent(AccessibilityEvent event)
//    {
//        final int eventType = event.getEventType(); // ClassName:
//        // com.tencent.mm.ui.LauncherUI
//
//        // 通知栏事件
//        if (eventType == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED)
//        {
//            List<CharSequence> texts = event.getText();
//            if (!texts.isEmpty())
//            {
//                for (CharSequence t : texts)
//                {
//                    String text = String.valueOf(t);
//                    if (text.contains(WX_HONGBAO_TEXT_KEY) || text.contains(QQ_HONGBAO_TEXT_KEY))
//                    {
//                        openNotify(event);
//                        break;
//                    }
//                }
//            }
//        } else if (eventType == AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE)
//        {
//            // 从微信主界面进入聊天界面
//            openHongBao(event);
//        } else if (eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)
//        {
//            // 处理微信聊天界面
//            openHongBao(event);
//        }
//    }
//
//    @Override
//    public void onInterrupt()
//    {
//        Toast.makeText(this, "中断抢红包服务", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onServiceConnected()
//    {
//        super.onServiceConnected();
//        Toast.makeText(this, "连接抢红包服务", Toast.LENGTH_SHORT).show();
//    }
//
//    /** 打开通知栏消息 */
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void openNotify(AccessibilityEvent event)
//    {
//        if (event.getParcelableData() == null || !(event.getParcelableData() instanceof Notification))
//        {
//            return;
//        }
//        // 将微信的通知栏消息打开
//        Notification notification = (Notification) event.getParcelableData();
//        PendingIntent pendingIntent = notification.contentIntent;
//        try
//        {
//            pendingIntent.send();
//        } catch (PendingIntent.CanceledException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void openHongBao(AccessibilityEvent event)
//    {
//        CharSequence className = event.getClassName();
//
//        checkScreen(getApplicationContext());
//
//        if ("com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI".equals(className))
//        {
//            // 点中了红包，下一步就是去拆红包
//            checkKey1();
//        } else if ("com.tencent.mm.ui.LauncherUI".equals(className) || "com.tencent.mobileqq.activity.ChatActivity".equals(className))
//        {
//            // 在聊天界面,去点中红包
//            checkKey2();
//        } else
//        {
//            // 在聊天界面,去点中红包
//            checkKey2();
//        }
//    }
//
//    /**
//     *
//     * @description: 检查屏幕是否亮着并且唤醒屏幕
//     * @date: 2016-1-29 下午2:08:25
//     * @author: yems
//     */
//    private void checkScreen(Context context)
//    {
//        // TODO Auto-generated method stub
//        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//        if (!pm.isScreenOn())
//        {
//            wakeUpAndUnlock(context);
//        }
//
//    }
//
//    private void wakeUpAndUnlock(Context context)
//    {
//        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
//        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
//        // 解锁
//        kl.disableKeyguard();
//        // 获取电源管理器对象
//        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//        // 获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
//        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK, "bright");
//        // 点亮屏幕
//        wl.acquire();
//        // 释放
//        wl.release();
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void checkKey1()
//    {
//        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
//        if (nodeInfo == null)
//            return;
//
//        List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("拆红包");
//
//        if (list == null || list.size() == 0)
//        {
//            list = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/b2c");
//        }
//
//        for (AccessibilityNodeInfo n : list)
//        {
//            n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//        }
//    }
//
//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//    private void checkKey2()
//    {
//        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
//        if (nodeInfo == null)
//        {
//            Log.w(TAG, "rootWindow为空");
//            return;
//        }
//        List<AccessibilityNodeInfo> wxList = nodeInfo.findAccessibilityNodeInfosByText("领取红包");
//        List<AccessibilityNodeInfo> qqList = nodeInfo.findAccessibilityNodeInfosByText("QQ红包");
//
//        if (!qqList.isEmpty())
//        {
//            qqList = nodeInfo.findAccessibilityNodeInfosByText("QQ红包");
//            for (AccessibilityNodeInfo n : qqList)
//            {
//                n.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                break;
//            }
//        }
//
//        if (!wxList.isEmpty())
//        {
//            // 界面上的红包总个数
//            int totalCount = wxList.size();
//            // 领取最近发的红包
//            for (int i = totalCount - 1; i >= 0; i--)
//            {
//                // 如果为领取过该红包，则执行点击、
//                AccessibilityNodeInfo parent = wxList.get(i).getParent();
//                if (parent != null)
//                {
//                    parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                    break;
//                }
//            }
//        } else if (!qqList.isEmpty())
//        {
//
//            // 界面上的红包总个数
//            int totalCount = qqList.size();
//            // 领取最近发的红包
//            for (int i = totalCount - 1; i >= 0; i--)
//            {
//                // 如果为领取过该红包，则执行点击、
//                AccessibilityNodeInfo parent = qqList.get(i).getParent();
//                Log.i(TAG, "-->领取红包:" + parent);
//                if (parent != null)
//                {
//                    parent.performAction(AccessibilityNodeInfo.ACTION_CLICK);
//                    break;
//                }
//            }
//
//        }
//
//    }

}