package com.victor.gankandroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by victor on 2017/6/26.
 * 音频效果view
 */

public class SoundView extends View {

    private int mWidth;             //view的宽度
    private int mRectCount = 20;    //矩形数量
    private int mRectWidth;         //矩形宽度
    private int mRectHeight;        //矩形高度--view的高度
    private int offset = 6;         //矩形间隙
    private Paint mPaint;
    private LinearGradient mLinearGradient;

    public SoundView(Context context) {
        this(context, null);
    }

    public SoundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public SoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, -1);
    }

    public SoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            double mRandom = Math.random();
            canvas.drawRect(
                    (float) (mWidth * 0.2 / 2 + mRectWidth * i + offset),
                    (float) (mRectHeight * mRandom),
                    (float) (mWidth * 0.2 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint
            );
        }
        postInvalidateDelayed(300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth * 0.8 / mRectCount);

        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP
        );
        mPaint.setShader(mLinearGradient);
    }
}
