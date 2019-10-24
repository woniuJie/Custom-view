package com.zsj.customview.practice3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class StaticLayoutView extends View {

    private Paint mPaint;
    public StaticLayoutView(Context context) {
        super(context);
        init();
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        /**
         *  StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)，其中参数里：
         *
         * width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
         * align 是文字的对齐方向；
         * spacingmult 是行间距的倍数，通常情况下填 1 就好；
         * spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
         * includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
         */
       String s = "zsj\nlove\nlhy";
        TextPaint paint = new TextPaint();
        paint.setTextSize(60);
        paint.setColor(Color.GRAY);
        paint.setAntiAlias(true);
//
//        StaticLayout staticLayout = new StaticLayout(s,paint,s.length(), Layout.Alignment.ALIGN_NORMAL,1,0,true);
//        staticLayout.draw(canvas);


        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        StaticLayout staticLayout2 = new StaticLayout(text2, paint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

        canvas.save();
        staticLayout2.draw(canvas);
        canvas.restore();

    }
}
