package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BingTuView extends View {
    private Paint mPaint;


    public BingTuView(Context context) {
        super(context);
        initPaint();

    }

    public BingTuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();

    }

    public BingTuView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public void initPaint() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.GREEN);
        canvas.drawArc(200,200,600,600,-178,118,true,mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawArc(200,200,600,600,-62,4,true,mPaint);


        mPaint.setColor(Color.YELLOW);
        canvas.drawArc(200,200,600,600,-58,58,true,mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawArc(200,200,600,600,-2,4,true,mPaint);


        mPaint.setColor(Color.RED);
        canvas.drawArc(200,200,600,600,2,178,true,mPaint);
        mPaint.setColor(Color.WHITE);
        canvas.drawArc(200,200,600,600,178,4,true,mPaint);


        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(400,400,100,mPaint);
    }
}
