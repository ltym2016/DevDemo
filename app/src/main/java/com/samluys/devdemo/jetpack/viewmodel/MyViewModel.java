package com.samluys.devdemo.jetpack.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.samluys.devdemo.base.BaseViewModel;

/**
 * @author luys
 * @describe
 * @date 2019-09-16
 * @email samluys@foxmail.com
 */
public class MyViewModel extends ViewModel {

    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    private MutableLiveData<Integer> number;

    public MutableLiveData<Integer> getNumber() {

        if (!handle.contains("number")) {
            handle.set("number", 0);
        }

        return handle.getLiveData("number");


//        if (number == null) {
//            number = new MutableLiveData<>();
//            number.setValue(0);
//        }
//        return number;
    }

    public void add() {
        getNumber().setValue(getNumber().getValue()+1);
    }
}
