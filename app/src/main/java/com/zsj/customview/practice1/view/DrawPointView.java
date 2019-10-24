package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawPointView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public DrawPointView(Context context) {
        super(context);
        init();
    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(60);
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
        canvas.drawPoint(middleW-200,middleH-200,mPaint);

        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(middleW+200,middleH+200,mPaint);


        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(middleW-200,middleH+200,mPaint);


        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(middleW+200,middleH-200,mPaint);
    }
}
