package com.samluys.devdemo.design.observer;

import android.util.Log;

/**
 * @author luys
 * @describe
 * @date 2019-09-03
 * @email samluys@foxmail.com
 */
public class MomCallbackImpl {


    public void say(XiaoMing xiaoMing, String string) {
        xiaoMing.work(new ICallback() {
            @Override
            public void setResult(String string) {

            }
        }, string);
    }


//    @Override
//    public void setResult(String string) {
//        Log.e("MomCallbackImpl", string);
//    }
}
