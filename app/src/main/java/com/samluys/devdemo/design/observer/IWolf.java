package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe
 * @date 2019-09-10
 * @email samluys@foxmail.com
 */
public interface IWolf {
    // 添加观察者
    void attchObserver(NormalWolf observer) ;
    // 移除观察者
    void detchObserver(NormalWolf observer) ;
    // 通知观察者
    void notifyObserver(String str) ;
}
