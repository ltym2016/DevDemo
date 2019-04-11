package com.samluys.devdemo.day1127;

/**
 * @author luys
 * @describe
 * @date 2018/12/2
 * @email samluys@foxmail.com
 */
public class SingleStonDemo {

    private static SingleStonDemo instance;

    private SingleStonDemo(){

    }

    private static SingleStonDemo getInstance() {
        if (instance == null) {
            synchronized (SingleStonDemo.class) {
                if (instance == null) {
                    instance = new SingleStonDemo();
                }
            }
        }

        return instance;
    }

}
