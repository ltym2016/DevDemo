package com.samluys.devdemo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luys
 * @describe 定义一个真实的被观察者
 * @date 2019-09-09
 * @email samluys@foxmail.com
 */
public class TigerChainSubject implements IWxServerSubject {

    // 订阅者列表「观察者列表」
    private List<IObserver> observers = new ArrayList<>() ;
    private String updateContent ;

    @Override
    public void attachObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(IObserver observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (IObserver iObserver:observers) {
            iObserver.reciveContent(updateContent);
        }
    }

    /**
     * TigerChain 在公号中发布文章
     * @param updateContent
     */
    public void submitContent(String updateContent){
        this.updateContent = updateContent ;
        this.notifyObserver();
    }
}
