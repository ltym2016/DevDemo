package com.samluys.devdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.util.Log;

import java.util.List;

/**
 * @author luys
 * @describe
 * @date 2018/11/21
 * @email samluys@foxmail.com
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化工具类
        Utils.init(this);

        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.pid == pid) {
                processName = runningAppProcessInfo.processName;
            }
        }

        Log.e("ZOE——luys", "application start processName : " + processName);



    }
}
