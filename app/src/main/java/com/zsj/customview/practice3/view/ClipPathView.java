package com.zsj.customview.practice3.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.BitmapUtils;
import com.zsj.customview.R;
import com.zsj.customview.ScreenUtils;

public class ClipPathView extends View {

    private Paint mPaint;
    RectF rectF;
    int width;
    int height;

    public ClipPathView(Context context) {
        super(context);
        init();
    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        width = getWidth();
        height = (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2;

        rectF = new RectF();
        rectF.left = 0;
        rectF.top = 0;
        rectF.right = width;
        rectF.bottom = height;

    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.splash_lite);

        canvas.save();

        Path path = new Path();
        path.addCircle(width/2,height-width*2,width*2, Path.Direction.CW);
        canvas.clipPath(path);

        canvas.drawBitmap(bitmap, null, rectF, mPaint);

    }
}
