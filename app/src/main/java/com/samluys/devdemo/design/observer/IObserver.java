package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe 定义抽象的观察者
 * @date 2019-09-09
 * @email samluys@foxmail.com
 */
public interface IObserver {
    // 观察者收到被观察者的信息
    void reciveContent(String info) ;
}
