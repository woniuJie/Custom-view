package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class LightingColorFilterView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public LightingColorFilterView(Context context) {
        super(context);
        init();
    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init() {
        mPaint = new Paint();
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

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.a);

        ColorFilter colorFilter = new LightingColorFilter(0x00ffff, 0x000000);

        mPaint.setColorFilter(colorFilter);

        canvas.drawBitmap(bitmap, middleW - bitmap.getWidth() / 2, middleH - bitmap.getHeight() / 2, mPaint);


    }
}
