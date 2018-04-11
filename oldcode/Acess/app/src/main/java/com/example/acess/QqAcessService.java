package com.example.acess;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.io.IOException;
import java.util.List;

public class QqAcessService extends AccessibilityService{
    private  final static String packagename = "com.tencent.mm";
    boolean hasAction = false;
    boolean locked = false;
    boolean background = false;
    private String name;
    private String scontent;
    AccessibilityNodeInfo itemNodeinfo;
    private KeyguardManager.KeyguardLock kl;
    private Handler handler = new Handler();


    @Override
    public void onAccessibilityEvent(final AccessibilityEvent event){
        int eventType = event.getEventType();
        Log.d("mylog","get envnet = "+eventType);
        switch (eventType){
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                Log.d("mylog","get notification event");
                List<CharSequence> texts = event.getText();
                for (CharSequence text : texts){
                    Log.d("text",text.toString());
                }
                Log.d("end","---------------");
                sendNotifacationReply(event);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (fill()) {
                            send();
                            back2Home();
                        }
                    }
                }, 1000);

        }
    }

    @Override
    public void onInterrupt(){

    }

    @SuppressLint("NewApi")
    private void send() {
        AccessibilityNodeInfo nodeInfo = getRootInActiveWindow();
        if (nodeInfo != null) {
            List<AccessibilityNodeInfo> list = nodeInfo
                    .findAccessibilityNodeInfosByText("发送");
            if (list != null && list.size() > 0) {
                for (AccessibilityNodeInfo n : list) {
                    if(n.getClassName().equals("android.widget.Button") && n.isEnabled())
                    {
                        n.performAction(AccessibilityNodeInfo.ACTION_CLICK);}
                }

            } else {
                List<AccessibilityNodeInfo> liste = nodeInfo
                        .findAccessibilityNodeInfosByText("Send");
                if (liste != null && liste.size() > 0) {
                    for (AccessibilityNodeInfo n : liste) {
                        if(n.getClassName().equals("android.widget.Button") && n.isEnabled())
                        {
                            n.performAction(AccessibilityNodeInfo.ACTION_CLICK);}
                    }
                }
            }
        }
        pressBackButton();
    }

    private void pressBackButton(){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void sendNotifacationReply(AccessibilityEvent event) {
        hasAction = true;
        if (event.getParcelableData() != null
                && event.getParcelableData() instanceof Notification) {
            Notification notification = (Notification) event
                    .getParcelableData();
            String content = notification.tickerText.toString();
            String[] cc = content.split(":");
            name = cc[0].trim();
            scontent = cc[1].trim();

            android.util.Log.i("maptrix", "sender name =" + name);
            android.util.Log.i("maptrix", "sender content =" + scontent);


            PendingIntent pendingIntent = notification.contentIntent;
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("NewApi")
    private boolean fill() {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode != null) {
            return findEditText(rootNode, "正在忙,稍后回复你");
        }
        return false;
    }


    private boolean findEditText(AccessibilityNodeInfo rootNode,String content){
        int count = rootNode.getChildCount();

        Log.d("mylog","root class= "+ rootNode.getClassName()+","+rootNode.getText()+","+count);
        for (int i=0; i<count; i++){
            AccessibilityNodeInfo nodeInfo = rootNode.getChild(i);
            if (nodeInfo == null){
                Log.d("mylog","nodeinfo = null");
                continue;
            }
            Log.d("mylog", "class=" + nodeInfo.getClassName());
            Log.e("mylog", "ds=" + nodeInfo.getContentDescription());

            if(nodeInfo.getContentDescription() != null){
                int nindex = nodeInfo.getContentDescription().toString().indexOf(name);
                int cindex = nodeInfo.getContentDescription().toString().indexOf(scontent);
                Log.e("mylog", "nindex=" + nindex + " cindex=" +cindex);
                if(nindex != -1){
                    itemNodeinfo = nodeInfo;
                    android.util.Log.i("mylog", "find node info");
                }
            }

            if ("android.widget.EditText".equals(nodeInfo.getClassName())) {
                android.util.Log.i("maptrix", "==================");
                Bundle arguments = new Bundle();
                arguments.putInt(AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT,
                        AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD);
                arguments.putBoolean(AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN,
                        true);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY,
                        arguments);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_FOCUS);
                ClipData clip = ClipData.newPlainText("label", content);
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                clipboardManager.setPrimaryClip(clip);
                nodeInfo.performAction(AccessibilityNodeInfo.ACTION_PASTE);
                return true;
            }

            if (findEditText(nodeInfo, content)) {
                return true;
            }
        }
        return false;
    }

    private void bing2Front(){
        ActivityManager activtyManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> runningRaskInfos = activtyManager.getRunningTasks(3);
        for (ActivityManager.RunningTaskInfo runningRaskInfo : runningRaskInfos){
            if (this.getPackageName().equals(runningRaskInfo.topActivity.getPackageName())){
               activtyManager.moveTaskToFront(runningRaskInfo.id,ActivityManager.MOVE_TASK_WITH_HOME);
               return;
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


}
