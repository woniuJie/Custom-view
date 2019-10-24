package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PathEffectView extends View {

    private Paint mPaint;

    private int width;
    private int height;

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

    public void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
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

        int middleW = width / 2;
        int middleH = height / 2;

        /**
         * CornerPathEffect
         * 把所有拐角变成圆角。
         */

        PathEffect pathEffect = new CornerPathEffect(30);
        mPaint.setPathEffect(pathEffect);
        Path path = new Path();
        path.moveTo(0,300);
        path.lineTo(200,100);
        path.lineTo(400,300);
        path.lineTo(600,100);
        path.lineTo(800,300);

        canvas.drawPath(path,mPaint);

        /**
         * DiscretePathEffect
         * 把线条进行随机的偏离，让轮廓变得乱七八糟。乱七八糟的方式和程度由参数决定
         */
        PathEffect pathEffect1 = new DiscretePathEffect(20,5);
        mPaint.setPathEffect(pathEffect1);
        Path path1 = new Path();
        path1.moveTo(0,600);
        path1.lineTo(200,400);
        path1.lineTo(400,600);
        path1.lineTo(600,400);
        path1.lineTo(800,600);

        canvas.drawPath(path1,mPaint);

        /**
         * DashPathEffect
         * 使用虚线来绘制线条。
         *
         * 它的构造方法 DashPathEffect(float[] intervals, float phase) 中，
         * 第一个参数 intervals 是一个数组，它指定了虚线的格式：数组中元素必须为偶数（最少是 2 个），
         * 按照「画线长度、空白长度、画线长度、空白长度」……的顺序排列，
         * 例如上面代码中的 20, 5, 10, 5 就表示虚线是按照「画 20 像素、空 5 像素、画 10 像素、空 5 像素」的模式来绘制；
         * 第二个参数 phase 是虚线的偏移量
         */

        float[] s = {20,10,40,10};
        PathEffect pathEffect2 = new DashPathEffect(s,0);
        mPaint.setPathEffect(pathEffect2);
        Path path2 = new Path();
        path2.moveTo(0,900);
        path2.lineTo(200,700);
        path2.lineTo(400,900);
        path2.lineTo(600,700);
        path2.lineTo(800,900);

        canvas.drawPath(path2,mPaint);

        /**
         * PathDashPathEffect
         * 这个方法比 DashPathEffect 多一个前缀 Path ，所以顾名思义，它是使用一个 Path 来绘制「虚线」
         */
        Path path3 = new Path();
        path3.lineTo(30,30);
        path3.lineTo(0,60);
        path3.close();
        PathEffect pathEffect3 = new PathDashPathEffect(path3,40,0, PathDashPathEffect.Style.TRANSLATE);


        Path path4 = new Path();
        path4.moveTo(0,1300);
        path4.lineTo(200,1100);
        path4.lineTo(400,1300);
        path4.lineTo(600,1100);
        path4.lineTo(800,1300);

        mPaint.setPathEffect(pathEffect3);
        canvas.drawPath(path4,mPaint);

        /**
         * SumPathEffect
         * 这是一个组合效果类的 PathEffect 。它的行为特别简单，就是分别按照两种 PathEffect 分别对目标进行绘制。
         *
         */

        /**
         *  ComposePathEffect
         * 这也是一个组合效果类的 PathEffect 。不过它是先对目标 Path 使用一个 PathEffect，然后再对这个改变后的 Path 使用另一个 PathEffect
         */

    }
}
