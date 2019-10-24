package com.zsj.customview.practice1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class DrawBitmapView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public DrawBitmapView(Context context) {
        super(context);
        init();
    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DrawBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init() {
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

        int middleW = width / 2;
        int middleH = height / 2;

        Rect rect = new Rect();

        rect.left = middleW - 200;
        rect.top = middleH - 200;
        rect.right = middleW + 200;
        rect.bottom = middleH + 200;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_header);


        canvas.drawBitmap(bitmap, null, rect, mPaint);


    }
}
