package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class StrokeJoinView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public StrokeJoinView(Context context) {
        super(context);
        init();
    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
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

        mPaint.setStrokeJoin(Paint.Join.MITER);

        Path path = new Path();
        path.moveTo(300,300);
        path.lineTo(600,300);
        path.lineTo(400,500);

        canvas.drawPath(path,mPaint);

        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        Path path1 = new Path();
        path1.moveTo(300,700);
        path1.lineTo(600,700);
        path1.lineTo(400,900);
        canvas.drawPath(path1,mPaint);

        mPaint.setStrokeJoin(Paint.Join.ROUND);
        Path path2 = new Path();
        path2.moveTo(300,1100);
        path2.lineTo(600,1100);
        path2.lineTo(400,1300);
        canvas.drawPath(path2,mPaint);

        /**
         * setStrokeJoin(Paint.Join join)
         * 设置拐角的形状。有三个值可以选择：MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITE
         */

        /**
         *
         * setStrokeMiter(float miter)
         * 它用于设置 MITER 型拐角的延长线的最大值。所谓「延长线的最大值」
         */

    }
}
