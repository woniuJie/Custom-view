package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class RadialGradientView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public RadialGradientView(Context context) {
        super(context);
        init();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
         * 镭射渐变


         构造方法：
         RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)。

         参数：
         centerX centerY：辐射中心的坐标
         radius：辐射半径
         centerColor：辐射中心的颜色
         edgeColor：辐射边缘的颜色
         tileMode：辐射范围之外的着色模式
         */
        Shader shader = new RadialGradient(middleW,middleH,150,Color.BLUE,Color.RED, Shader.TileMode.MIRROR);
        mPaint.setShader(shader);
        canvas.drawRoundRect(middleW-200,middleH-50,middleW+200,middleH+50,50,50,mPaint);

    }
}
