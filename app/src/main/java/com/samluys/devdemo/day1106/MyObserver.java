package com.samluys.devdemo.day1106;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author luys
 * @describe
 * @date 2018/11/6
 * @email samluys@foxmail.com
 */
public class MyObserver implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void connectOnCreate(){
        Log.e("LUYS", "OnCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void connectOnResume() {
        Log.e("LUYS", "ON_DESTROY");
    }
}
