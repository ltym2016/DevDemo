package com.samluys.devdemo.design.observer;

import android.util.Log;

/**
 * @author luys
 * @describe
 * @date 2019-09-10
 * @email samluys@foxmail.com
 */
public class LieShaLang extends NormalWolf {

    public LieShaLang(IWolf wolf) {
        this.iWolf = wolf;
        iWolf.attchObserver(this);
    }

    @Override
    public void reciveCommand(String info) {
        Log.e("LieShaLang", "LieShaLang" + info);
    }
}
