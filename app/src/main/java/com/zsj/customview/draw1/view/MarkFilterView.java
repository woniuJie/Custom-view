package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class MarkFilterView extends View {
    public MarkFilterView(Context context) {
        super(context);
    }

    public MarkFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint mPaint = new Paint();

        /**
         *  1\BlurMaskFilter
         *  模糊效果的 MaskFilter
         *  构造方法 BlurMaskFilter(float radius, BlurMaskFilter.Blur style) 中， radius 参数是模糊的范围， style 是模糊的类型。一共有四种：
         *
         * NORMAL: 内外都模糊绘制
         * SOLID: 内部正常绘制，外部模糊
         * INNER: 内部模糊，外部不绘制
         * OUTER: 内部不绘制，外部模糊
         */

        mPaint.setMaskFilter(new BlurMaskFilter(30,BlurMaskFilter.Blur.SOLID));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_hou);
        canvas.drawBitmap(bitmap,100,100,mPaint);


        /**
         *  2\ EmbossMaskFilter
         *  浮雕效果的 MaskFilter。
         *
         *  它的构造方法 EmbossMaskFilter(float[] direction, float ambient, float specular, float blurRadius) 的参数里，
         *  direction 是一个 3 个元素的数组，指定了光源的方向；
         *  ambient 是环境光的强度，数值范围是 0 到 1；
         *  specular 是炫光的系数；
         *  blurRadius 是应用光线的范围
         */
        mPaint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
        canvas.drawBitmap(bitmap,100,900,mPaint);


    }
}
