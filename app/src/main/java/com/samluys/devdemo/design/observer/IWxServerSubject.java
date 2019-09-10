package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe 定义抽象的被观察者
 * @date 2019-09-09
 * @email samluys@foxmail.com
 */
public interface IWxServerSubject {
    // 添加观察者
    void attachObserver(IObserver observer);
    // 移除观察者
    void detachObserver(IObserver observer);
    // 通知观察者
    void notifyObserver();
}
