package com.samluys.devdemo.capter3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * @author luys
 * @describe
 * @date 2019/1/23
 * @email samluys@foxmail.com
 */
public class MyHScrollView {
//    public MyHScrollView(Context context) {
//        super(context);
//    }
//
//    public MyHScrollView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean intercepted = false;
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                // 必须返回false。不然后续的事件就不会传递给子元素
//                intercepted =false;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (父容器决定拦截当前点击事件) {
//                    intercepted = true;
//                } else {
//                    intercepted = false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                // 必须返回false，不然子元素的ACTION_UP事件就不会调用，导致如果由onClick事件，就不会调用
//                intercepted = false;
//                break;
//        }
//
//        return intercepted;
//    }
}
