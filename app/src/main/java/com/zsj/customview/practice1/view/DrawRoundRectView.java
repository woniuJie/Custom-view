package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawRoundRectView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public DrawRoundRectView(Context context) {
        super(context);
        init();
    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawRoundRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        int middleW = width/2;
        int middleH = height/2;
        /**
         *  left, top, right, bottom 是四条边的坐标，rx 和 ry 是圆角的横向半径和纵向半径
         */

        canvas.drawRoundRect(middleW-300,middleH-50,middleW+300,middleH+50,50,50,mPaint);
    }
}
