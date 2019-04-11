package com.samluys.devdemo.other;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author luys
 * @describe
 * @date 2019/2/21
 * @email samluys@foxmail.com
 */
public class DynamicUtils {

//    public static void inject(Activity activity) {
//        Intent intent = activity.getIntent();
//        for (Field field: activity.getClass().getDeclaredFields()) {
//            if (field.isAnnotationPresent(DynamicIntentKey.class)) {
//                DynamicIntentKey annotation = field.getAnnotation(DynamicIntentKey.class);
//                String intentKey = annotation.value();
//
//                Serializable serializable  = intent.getSerializableExtra(intentKey);
//
//                boolean accessible = field.isAccessible();
//                field.setAccessible(true);
//                try {
//                    field.set(activity, serializable);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                field.setAccessible(accessible);
//            }
//        }
//    }
}
