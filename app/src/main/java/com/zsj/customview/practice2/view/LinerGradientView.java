package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LinerGradientView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public LinerGradientView(Context context) {
        super(context);
        init();
    }

    public LinerGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public LinerGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
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
         * 线性渐变
         * 构造方法：
         * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile) 。
         *
         * 参数：
         * x0 y0 x1 y1：渐变的两个端点的位置
         * color0 color1 是端点的颜色
         * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选：
         * CLAMP, MIRROR 和 REPEAT。
         * CLAMP 会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式
         */
        Shader shader = new LinearGradient(middleW-200,middleH-50,middleW+200,middleH+30,Color.GREEN,Color.RED, Shader.TileMode.MIRROR);
        mPaint.setShader(shader);
        canvas.drawRoundRect(middleW-200,middleH-50,middleW+200,middleH+50,50,50,mPaint);

    }
}
