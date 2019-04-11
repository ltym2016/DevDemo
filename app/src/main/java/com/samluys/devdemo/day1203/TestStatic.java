package com.samluys.devdemo.day1203;

import android.util.Log;

/**
 * @author luys
 * @describe
 * @date 2018/12/7
 * @email samluys@foxmail.com
 */
public class TestStatic {

    static {
        Log.e("zoe", "static_test");
    }


    private TestStatic () {

    }

    public static TestStatic getInstance() {

        return null;
    }
}
