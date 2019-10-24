package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawArcView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public DrawArcView(Context context) {
        super(context);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
         * drawArc() 是使用一个椭圆来描述弧形的。
         * left, top, right, bottom 描述的是这个弧形所在的椭圆；
         * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
         * sweepAngle 是弧形划过的角度；
         * useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，
         * 如果连接到圆心，就是扇形
         */

        canvas.drawArc(middleW-300,middleH-300,middleW+300,middleH+300,-180,60,false,mPaint);
        canvas.drawArc(middleW-300,middleH-300,middleW+300,middleH+300,-110,60,true,mPaint);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(middleW-300,middleH-300,middleW+300,middleH+300,0,60,true,mPaint);

        canvas.drawArc(middleW-300,middleH-300,middleW+300,middleH+300,80,60,false,mPaint);



    }
}
