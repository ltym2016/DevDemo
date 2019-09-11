package com.samluys.devdemo.design.observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author luys
 * @describe
 * @date 2019-09-11
 * @email samluys@foxmail.com
 */
public class CustomEventBus implements IEventBus {

    private static CustomEventBus instance;

    // 观察者是任意的对象
    private Object object ;

    private CustomEventBus() {

    }

    public static CustomEventBus getInstance() {
        if (instance == null) {
            synchronized (CustomEventBus.class) {
                if (instance == null) {
                    instance = new CustomEventBus();
                }
            }
        }

        return instance;
    }


    @Override
    public void register(Object object) {
        this.object = object;
    }

    @Override
    public void unRegister(Object object) {

    }

    @Override
    public void post(String str) {

        try {
            Class clazz = object.getClass();
            Method method = clazz.getMethod("onEvent", String.class);
            method.invoke(object, str);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
