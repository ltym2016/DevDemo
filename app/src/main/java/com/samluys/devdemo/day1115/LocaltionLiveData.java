package com.samluys.devdemo.day1115;

import android.content.Context;

import androidx.lifecycle.LiveData;

/**
 * @author luys
 * @describe
 * @date 2018/11/15
 * @email samluys@foxmail.com
 */
public class LocaltionLiveData extends LiveData {

    private static LocaltionLiveData mLiveData;

    public static LocaltionLiveData getInstance(Context context) {
        if (mLiveData == null) {
            mLiveData = new LocaltionLiveData(context.getApplicationContext());
        }

        return mLiveData;
    }

    private LocaltionLiveData(Context context) {

    }

    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    //    private SimpleLo
}
