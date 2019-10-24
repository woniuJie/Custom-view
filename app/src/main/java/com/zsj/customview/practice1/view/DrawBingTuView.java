package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DrawBingTuView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    private List<Integer> mLists = new ArrayList<>();

    private int all;

    float startAngle;
    float middleAngle;
    float sweepAngle;

    public DrawBingTuView(Context context) {
        super(context);
        init();
    }

    public DrawBingTuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawBingTuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init() {
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

        int middleW = width / 2;
        int middleH = height / 2;

        mLists.add(20);
        mLists.add(10);
        mLists.add(30);
        mLists.add(10);
        mLists.add(30);

        all = 100;

        RectF rectF = new RectF();
        rectF.left = middleW - 300;
        rectF.right = middleW + 300;
        rectF.top = middleH - 300;
        rectF.bottom = middleH + 300;

        middleAngle = 4;

        int[] colors = {Color.GREEN, Color.RED, Color.YELLOW, Color.parseColor("#00f4ff"), Color.parseColor("#f4329c")};

        startAngle = -180;
        for (int i = 0; i < mLists.size(); i++) {
            startAngle = startAngle + middleAngle + sweepAngle;
            sweepAngle =((float)mLists.get(i)/(float)all) * 360 - middleAngle;
            mPaint.setColor(colors[i]);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);

        }

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(middleW,middleH,140,mPaint);

    }
}
