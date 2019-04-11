package com.samluys.devdemo.day1203;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.samluys.devdemo.R;

public class GestureDemoActivity extends AppCompatActivity {

    private GestureDetector mGestureDetector;
    private int m = 50;
    private final static String TAG = GestureDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_demo);
        final CustomButton btn_click = findViewById(R.id.btn_click);

        mGestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.e(TAG, "onSingleTapUp");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.e(TAG, "onLongPress");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                return false;
            }
        });

//        btn_click.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return mGestureDetector.onTouchEvent(event);
//            }
//        });

        btn_click.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("zoe", "onTouch被调用了");
                // 如果返回false，则当前View的onTouchEvent方法会被调用。
                return false;
            }
        });

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("zoe", "onClick被调用了");
                m=m+50;
                btn_click.smoothScrollTo(-200-m,200);
            }
        });

        btn_click.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        TestBuilder testBuilder = new TestBuilder.Builder1(1,"zoe")
                .setAge(1)
                .setHeight(2)
                .setSex(1).build();

        TestBuilder testBuilder2 = new TestBuilder.Builder2(1,"zoe")
                .setAge(1)
                .setHeight(2)
                .setSex(1).build();
        final int startX = 0;
        final int delatX = 1000;

//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,1).setDuration(10000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float f = animation.getAnimatedFraction();
//                Log.e("ZOE", f+"");
//                btn_click.scrollTo(startX - (int) (delatX * f), 0);
//
//            }
//        });
//        valueAnimator.start();

    }
}
