package com.samluys.devdemo.day1203;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Scroller;

import androidx.appcompat.widget.AppCompatButton;

/**
 * @author luys
 * @describe
 * @date 2018/12/3
 * @email samluys@foxmail.com
 */
public class CustomButton extends AppCompatButton {

    private Scroller mScroller;


    public CustomButton(Context context) {
        this(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mScroller = new Scroller(context);
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int delta = destX - scrollX;

        mScroller.startScroll(scrollX, 0, delta,0 ,1000);
        Log.e("ZOE", "invalidate start");
        invalidate();
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            postInvalidate();
            Log.e("ZOE", "postInvalidate start");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e("zoe", "onTouchEvent被调用了");

        return super.onTouchEvent(event);
    }
}
