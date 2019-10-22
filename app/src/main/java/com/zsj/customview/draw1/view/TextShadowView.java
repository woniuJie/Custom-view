package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TextShadowView extends View {
    Paint mPaint;
    public TextShadowView(Context context) {
        super(context);
    }

    public TextShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.WHITE);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setAntiAlias(true);

        Path path = new Path();
        path.moveTo(100,1400);
        path.lineTo(300,1000);
        path.lineTo(500,1400);
        path.lineTo(700,1000);
        path.lineTo(900,1400);

        mPaint.setPathEffect(new CornerPathEffect(90));
        canvas.drawPath(path,mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(60);
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);

        /**
         * 1\drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
         *
         * 参数里，需要解释的只有两个： hOffset 和 vOffset。
         * 它们是文字相对于 Path 的水平偏移量和竖直偏移量，
         * 利用它们可以调整文字的位置。
         * 例如你设置 hOffset 为 5， vOffset 为 10，文字就会右移 5 像素和下移 10 像素。
         *
         */
        canvas.drawTextOnPath("Hello World Hello World Hello World Hello World ",path,0,10,mPaint);


        /**
         * 2\StaticLayout  支持换行，它既可以为文字设置宽度上限来让文字自动换行，也会在 \n 处主动换行。
         */
        TextPaint paint = new TextPaint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(60);

        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        StaticLayout staticLayout1 = new StaticLayout(text1, paint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        StaticLayout staticLayout2 = new StaticLayout(text2, paint, 600,
                Layout.Alignment.ALIGN_NORMAL, 1, 0, true);


        canvas.save();
        canvas.translate(50, 100);
        staticLayout1.draw(canvas);
        canvas.translate(0, 200);
        staticLayout2.draw(canvas);
        canvas.restore();

        /**
         *  3\ setTypeface(Typeface typeface)
         *  设置字体
         */

    }


}
