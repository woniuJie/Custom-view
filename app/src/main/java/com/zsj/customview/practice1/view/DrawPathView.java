package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawPathView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public DrawPathView(Context context) {
        super(context);
        init();
    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        mPaint.setStyle(Paint.Style.FILL);
//        Path path = new Path();
//        path.setFillType(Path.FillType.EVEN_ODD);
//        path.addCircle(middleW,middleH,200, Path.Direction.CW);
//        path.addCircle(middleW,middleH,400, Path.Direction.CW);
//        canvas.drawPath(path,mPaint);


        Path path = new Path();
//        path1.addArc(200,200,600,600, -225,180);
//        path1.arcTo(400,200,800,600,-135,180,true);
//
//        path1.lineTo(450,800);
//        path1.lineTo(220,530);

        path.addArc(200, 200, 400, 400, -225, 225);
//        path.arcTo(400, 200, 600, 400, -180, 225, false);
//        path.lineTo(400, 542);

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        canvas.drawPath(path,mPaint);


    }
}
