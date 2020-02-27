package com.samluys.devdemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.entry.DefaultApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

import java.util.List;

/**
 * @author luys
 * @describe
 * @date 2018/11/21
 * @email samluys@foxmail.com
 */
@DefaultLifeCycle(application = "com.samluys.devdemo.MyApplication",
        flags = ShareConstants.TINKER_ENABLE_ALL,
        loadVerifyFlag = false)
public class SampleApplicationLike extends DefaultApplicationLike {

    ApplicationLike tinkerApplicationLike;

    public SampleApplicationLike() {
        super(null, 0, false, 0, 0, null);
    }

    public SampleApplicationLike(Application application, int tinkerFlags, boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime, long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }


    @Override
    public void onCreate() {
        super.onCreate();
//        initTinkerPatch();
        //初始化工具类
//        Utils.init(this);this

//        int pid = android.os.Process.myPid();
//        String processName = "";
//        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//
//        List<ActivityManager.RunningAppProcessInfo> list = activityManager.getRunningAppProcesses();
//        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
//            if (runningAppProcessInfo.pid == pid) {
//                processName = runningAppProcessInfo.processName;
//            }
//        }
//
//        Log.e("ZOE——luys", "application start processName : " + processName);

        TinkerPatch.init(this)
                .reflectPatchLibrary()
                .setPatchRollbackOnScreenOff(true)
                .setPatchRestartOnSrceenOff(true)
                .setFetchPatchIntervalByHours(3);

        // 每隔3个小时（通过setFetchPatchIntervalByHours设置）去访问后台时候有更新,通过handler实现轮训的效果
        TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();

    }

//    private void initTinkerPatch() {
//        // 我们可以从这里获得Tinker加载过程的信息
//        if (BuildConfig.TINKER_ENABLE) {
//            tinkerApplicationLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
//            // 初始化TinkerPatch SDK
//            TinkerPatch.init(tinkerApplicationLike)
//                    .reflectPatchLibrary()
//                    .setPatchRollbackOnScreenOff(true)
//                    .setPatchRestartOnSrceenOff(true)
//                    .setFetchPatchIntervalByHours(3);
//            // 获取当前的补丁版本
//            Log.d("LUYS_TINKER", "Current patch version is " + TinkerPatch.with().getPatchVersion());
//
//            // fetchPatchUpdateAndPollWithInterval 与 fetchPatchUpdate(false)
//            // 不同的是，会通过handler的方式去轮询
//            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
//        }
//    }
}
