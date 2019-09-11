package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe
 * @date 2019-09-10
 * @email samluys@foxmail.com
 */
public abstract class NormalWolf {

    // 拿到被观察者对象
    protected IWolf iWolf;

    public abstract void reciveCommand(String info);
}
