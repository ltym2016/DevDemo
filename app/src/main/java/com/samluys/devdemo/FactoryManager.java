package com.samluys.devdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * @author luys
 * @describe
 * @date 2019/3/21
 * @email samluys@foxmail.com
 */
public class FactoryManager {

    private static FactoryManager instance;

    private FactoryManager() {

    }

    public static FactoryManager getInstance() {
        if (instance == null) {
            synchronized (FactoryManager.class) {
                if (instance == null) {
                    instance = new FactoryManager();
                }
            }
        }

        return instance;
    }

    public void doFactory (Context context) {
        LayoutInflater.from(context).setFactory(new LayoutInflater.Factory() {
            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                TextView textView = new TextView(context, attrs);
                if (name.equals("Button")) {
                    return textView;
                }

                return null;
            }
        });
    }

}
