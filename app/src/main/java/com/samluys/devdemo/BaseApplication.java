package com.samluys.devdemo;

import android.app.Application;


/**
 * @author luys
 * @describe
 * @date 2019-07-14
 * @email samluys@foxmail.com
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        //内存泄漏检测
//        if (!LeakCanary.isInAnalyzerProcess(this)) {
//            LeakCanary.install(this);
//        }
    }
}
