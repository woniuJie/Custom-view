package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class ColorFilterView extends View {
    private Paint mPaint;
    public ColorFilterView(Context context) {
        super(context);
        init();
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);




    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         *  1、LightingColorFilter
         *  LightingColorFilter 的构造方法是 LightingColorFilter(int mul, int add) ，
         *  参数里的 mul 和 add 都是和颜色值格式相同的 int 值，其中 mul 用来和目标像素相乘，add 用来和目标像素相加：
         */
        ColorFilter lightFilter = new LightingColorFilter(0xffffff,0x003000);
        mPaint.setColorFilter(lightFilter);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_header);
        canvas.drawBitmap(bitmap,200,200,mPaint);
    }
}
