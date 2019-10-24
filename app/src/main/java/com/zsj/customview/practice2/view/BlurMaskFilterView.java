package com.zsj.customview.practice2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.BitmapUtils;
import com.zsj.customview.R;

public class BlurMaskFilterView extends View {

    private Paint mPaint;

    private int width;
    private int height;

    public BlurMaskFilterView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
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

        int middleW = width/2;
        int middleH = height/2;
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromResource(getResources(),R.drawable.fuck,120,120);

        MaskFilter maskFilter = new BlurMaskFilter(100, BlurMaskFilter.Blur.NORMAL);

        mPaint.setMaskFilter(maskFilter);

        canvas.drawBitmap(bitmap,50,50,mPaint);


    }
}
