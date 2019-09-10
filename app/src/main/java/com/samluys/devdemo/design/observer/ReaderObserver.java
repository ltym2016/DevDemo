package com.samluys.devdemo.design.observer;

import android.util.Log;

/**
 * @author luys
 * @describe
 * @date 2019-09-09
 * @email samluys@foxmail.com
 */
public class ReaderObserver implements IObserver {

    // 微信用户的姓名
    private String uname ;

    public ReaderObserver(String name){
        this.uname = name ;
    }

    @Override
    public void reciveContent(String info) {
        Log.e("ReaderObserver", uname + "注意，TigerChain 发送了文章---" + info);
    }
}
