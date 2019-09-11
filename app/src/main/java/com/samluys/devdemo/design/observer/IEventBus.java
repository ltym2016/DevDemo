package com.samluys.devdemo.design.observer;

/**
 * @author luys
 * @describe
 * @date 2019-09-11
 * @email samluys@foxmail.com
 */
public interface IEventBus {
    // 订阅
    void register(Object object) ;
    // 取消订阅
    void unRegister(Object object) ;
    // 发送通知
    void post(String str) ;
}
