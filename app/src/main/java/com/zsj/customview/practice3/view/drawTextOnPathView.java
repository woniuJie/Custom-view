package com.zsj.customview.practice3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class drawTextOnPathView extends View {

    private Paint mPaint;
    public drawTextOnPathView(Context context) {
        super(context);
        init();
    }

    public drawTextOnPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public drawTextOnPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(100,600);
        path.lineTo(300,100);
        path.lineTo(500,600);
        path.lineTo(700,100);
        path.lineTo(900,600);

        PathEffect pathEffect = new CornerPathEffect(80);
        mPaint.setPathEffect(pathEffect);
//        canvas.drawPath(path,mPaint);


        mPaint.reset();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(60);
        canvas.drawTextOnPath("zhangshijie zhangshijie zhangshijie zhangshijie zhangshijie zhangshijie ",path,0,0,mPaint);

    }
}
