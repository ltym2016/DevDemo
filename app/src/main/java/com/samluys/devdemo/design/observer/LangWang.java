package com.samluys.devdemo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luys
 * @describe
 * @date 2019-09-10
 * @email samluys@foxmail.com
 */
public class LangWang implements IWolf {

    private static LangWang instance;

    private LangWang() {

    }

    public static LangWang getInstance() {
        if (instance == null) {
            synchronized (LangWang.class) {
                if (instance == null) {
                    instance = new LangWang();
                }
            }
        }

        return instance;
    }

    // 除过狼王外的子狼「观察者」
    private List<NormalWolf> observers = new ArrayList<>();
    // 狼王下达的命令
    private String mingLing  ;

    @Override
    public void attchObserver(NormalWolf observer) {
        observers.add(observer);
    }

    @Override
    public void detchObserver(NormalWolf observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String str) {
        for (NormalWolf normalWolf : observers) {
            normalWolf.reciveCommand(str);
        }
    }

    public void publishCommand(String command) {
        notifyObserver(command);
    }
}
