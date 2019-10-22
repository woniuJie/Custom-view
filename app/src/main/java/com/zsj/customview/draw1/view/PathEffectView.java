package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PathEffectView extends View {

    private Paint mPaint;
    public PathEffectView(Context context) {
        super(context);
        init();
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(100,400);
        path.lineTo(300,100);
        path.lineTo(500,400);
        path.lineTo(700,100);
        path.lineTo(1000,400);

        /**
         *  1、CornerPathEffect
         *  把所有拐角变成圆角。
         */

        PathEffect pathEffect = new CornerPathEffect(100);
        mPaint.setPathEffect(pathEffect);
        canvas.drawPath(path,mPaint);

        /**
         * 2\DiscretePathEffect
         * 把线条进行随机的偏离，让轮廓变得乱七八糟。乱七八糟的方式和程度由参数决定
         *
         * 构造方法 DiscretePathEffect(float segmentLength, float deviation) 的两个参数中，
         * segmentLength 是用来拼接的每个线段的长度， deviation 是偏离量
         */

        Path path1 = new Path();
        path1.moveTo(100,900);
        path1.lineTo(300,500);
        path1.lineTo(500,900);
        path1.lineTo(700,500);
        path1.lineTo(1000,900);

        PathEffect pathEffect1 = new DiscretePathEffect(80,15);
        mPaint.setPathEffect(pathEffect1);
        canvas.drawPath(path1,mPaint);

        /**
         * 3 \ DashPathEffect
         * 使用虚线来绘制线条。
         * 构造方法 DashPathEffect(float[] intervals, float phase) 中，
         * 第一个参数 intervals 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），
         * 按照「画线长度、空白长度、画线长度、空白长度」……的顺序排列，
         * 例如上面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、空 5 像素、画 10 像素、空 5 像素」的模式来绘制；
         * 第二个参数 phase 是虚线的偏移量
         */


        Path path2 = new Path();
        path2.moveTo(100,1400);
        path2.lineTo(300,1000);
        path2.lineTo(500,1400);
        path2.lineTo(700,1000);
        path2.lineTo(1000,1400);

        PathEffect pathEffect2 = new DashPathEffect(new float[]{50,5,10,5},5);
        mPaint.setPathEffect(pathEffect2);
        canvas.drawPath(path2,mPaint);
    }
}
