package com.samluys.devdemo.chapter4;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author luys
 * @describe
 * @date 2019/1/27
 * @email samluys@foxmail.com
 */
public class MyDemoView extends View {

    int mWidth = 100;
    int mHeight = 100;

    public MyDemoView(Context context) {
        super(context);
    }

    public MyDemoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyDemoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
           setMeasuredDimension(mWidth,mHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth,heightSize);
        }else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize,mHeight);
        }
    }
}
