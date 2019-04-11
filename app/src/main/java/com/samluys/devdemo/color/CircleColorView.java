package com.samluys.devdemo.color;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import androidx.annotation.Nullable;

/**
 * @author luys
 * @describe
 * @date 2019/3/21
 * @email samluys@foxmail.com
 */
public class CircleColorView extends View {

    private int mDefaultSize = 200;
    private Paint mPaint;
    private Paint mCirclePaint;

    private int mCenterX;
    private int mCenterY;
    private int mRadius;


    private int touchCircleX;

    private int touchCircleY;

    private float[] colorHSV = new float[]{0f, 1f, 1f};
    private OnSeekColorListener onSeekColorListener;


    public CircleColorView(Context context) {
        super(context);
        init();
    }

    public CircleColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init () {

        // View级别取消硬件加速器
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mCirclePaint = new Paint();
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(Color.WHITE);
        mCirclePaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthSize, heightSize);
        } else if (widthMode == MeasureSpec.EXACTLY && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSize, mDefaultSize);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.EXACTLY) {
            setMeasuredDimension(mDefaultSize, heightSize);
        } else {
            setMeasuredDimension(mDefaultSize, mDefaultSize);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int[]   colors = new int[]{0xffff0000,0xff00ff00,0xff00ffff,0xff0000ff};
//        float[] stops  = new float[]{0f,0.3f,0.6f,1f};
//
//        RadialGradient radialGradient = new RadialGradient(getWidth()/2,getWidth()/2,getWidth()/2,
//                colors, stops,
//                Shader.TileMode.REPEAT);
//        SweepGradient radialGradient = new SweepGradient(getWidth()/2,getWidth()/2,
//                0xffff0000, 0xffffff00);
//        mPaint.setShader(radialGradient);

//        RadialGradient radialGradient = new RadialGradient(mCenterX, mCenterX,
//                mRadius, 0xFFFFFFFF, 0x00FFFFFF, Shader.TileMode.CLAMP);
//
//        mPaint.setShader(radialGradient);

        canvas.drawCircle(mCenterX, mCenterY, mRadius, mPaint);
        canvas.drawCircle(touchCircleX,touchCircleY,10, mCirclePaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = w/2;
        mCenterY = w/2;
        mRadius = w/2;

//        int  colorCount = 24;
//        int  colorAngleStep = 360/colorCount;
//        int[] colors = new int[colorCount];
//        float hsv[] = new float[]{0,1,1};
//
//        for (int i = 0; i < colorCount; i++) {
//            hsv[0] = (i * colorAngleStep + 180) % 360;
//
//            Log.e("hsv[0]", "hsv[0] : " + hsv[0]);
//            colors[i] = Color.HSVToColor(hsv);
//            Log.e("colors[i]", "colors[i] : " + colors[i]);
//        }
//
//        SweepGradient sweepGradient = new SweepGradient(mCenterX, mCenterX, colors, null);
//        RadialGradient radialGradient = new RadialGradient(mCenterX, mCenterX,
//                mRadius, 0xffff0000, 0xffffff00, Shader.TileMode.CLAMP);
//        ComposeShader composeShader = new ComposeShader(sweepGradient, radialGradient, PorterDuff.Mode.MULTIPLY);
//
//        mPaint.setShader(composeShader);

        int colorCount = 12;
        int colorAngleStep = 360 / colorCount;
        int colors[] = new int[colorCount];
        float hsv[] = new float[]{0f, 1f, 1f};
        for (int i = 0; i < colors.length; i++) {
            hsv[0] = (i * colorAngleStep + 180) % 360;
            Log.e("hsv : " ,""+ hsv[0]);
            colors[i] = Color.HSVToColor(hsv);
        }

        SweepGradient sweepGradient = new SweepGradient(mCenterX, mCenterX, colors, null);
        RadialGradient radialGradient = new RadialGradient(mCenterX, mCenterX,
                mRadius, 0xFFFFFFFF, 0x00FFFFFF, Shader.TileMode.CLAMP);
        ComposeShader composeShader = new ComposeShader(sweepGradient, radialGradient, PorterDuff.Mode.SRC_OVER);

        mPaint.setShader(composeShader);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                int x = (int) event.getX();
                int y = (int) event.getY();
                int cx = x - mCenterX;
                int cy = y - mCenterY;
                double d = Math.sqrt(cx*cx + cy*cy);

                if (d <= mRadius) {
                    colorHSV[0] = (float) (Math.toDegrees(Math.atan2(cy,cx)) + 180f);

                    Log.e("colorHSV : " ,""+ colorHSV[0]);
                    colorHSV[1] = Math.max(0f, Math.min(1f, (float) (d / mRadius)));
                    touchCircleY = y;
                    touchCircleX = x;
                    if(onSeekColorListener != null) {
                        onSeekColorListener.onSeekColorListener(Color.HSVToColor(colorHSV));
                    }

                    postInvalidate();
                }

                break;
        }




        return true;
    }

    float hsv[] = new float[]{0,1,1};

    public void setHSVColor(int h, int s, int v) {
//        hsv[0] = h;
//        hsv[1] = ((float) s)/100;
//        hsv[2] = ((float) v)/100;
//
//        mPaint.setColor(Color.HSVToColor(hsv));
//
//        postInvalidate();

    }

    public interface OnSeekColorListener {
        void onSeekColorListener(int color);
    }

    public void setOnSeekColorListener(OnSeekColorListener onSeekColorListener) {
        this.onSeekColorListener = onSeekColorListener;
    }
}
