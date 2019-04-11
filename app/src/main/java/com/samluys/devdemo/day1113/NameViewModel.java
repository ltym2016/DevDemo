package com.samluys.devdemo.day1113;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

/**
 * @author luys
 * @describe
 * @date 2018/11/13
 * @email samluys@foxmail.com
 */
public class NameViewModel extends ViewModel {
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }

        return mCurrentName;
    }
}
