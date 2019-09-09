package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe
 * @date 2019-09-03
 * @email samluys@foxmail.com
 */
public class XiaoMing {

    public void work(ICallback iCallback, String str) {
        if (iCallback != null) {
            iCallback.setResult("好的");
        }
    }
}
