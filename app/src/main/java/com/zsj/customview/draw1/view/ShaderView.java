package com.zsj.customview.draw1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.zsj.customview.R;

public class ShaderView extends View {
    private Paint mPaint;
    public ShaderView(Context context) {
        super(context);
        init();
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //shader 为 着色器，android中使用它的子类
        //LinerGradient RadialGradient SweepGradient BitmapShader ComposeShader

        /**
         * 1、LinerGradient  线性渐变
         *
         * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, Shader.TileMode tile)
         * x0 y0 x1 y1：渐变的两个端点的位置
         * color0 color1 是端点的颜色
         * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和 REPEAT。
         * CLAMP （夹子模式？？？算了这个词我不会翻）会在端点之外延续端点处的颜色；MIRROR 是镜像模式；REPEAT 是重复模式
         */
        Shader shader = new LinearGradient(100,100,500,500
                ,Color.parseColor("#E91E63")
                ,Color.parseColor("#2196F3")
                ,Shader.TileMode.CLAMP);
        mPaint.setShader(shader);

        canvas.drawCircle(300,300,200,mPaint);

//        mPaint.setTextSize(80);
//        Shader shader1 = new LinearGradient(300,800,400,900
//                ,Color.parseColor("#E91E63")
//                ,Color.parseColor("#2196F3")
//                ,Shader.TileMode.CLAMP);
//        mPaint.setShader(shader1);
//        canvas.drawText("张士杰",300,800,mPaint);

        /**
         *  2、RadialGradient 辐射渐变
         *
         *  RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)
         *  参数：
         * centerX centerY：辐射中心的坐标
         * radius：辐射半径
         * centerColor：辐射中心的颜色
         * edgeColor：辐射边缘的颜色
         * tileMode：辐射范围之外的着色模式
         */
        Shader shader2 = new RadialGradient(300,800,200,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),Shader.TileMode.REPEAT);
        mPaint.setShader(shader2);
        canvas.drawCircle(300,800,200,mPaint);


        /**
         *  3、扫描渐变
         *
         *  SweepGradient(float cx, float cy, int color0, int color1)
         *
         * 参数：
         * cx cy ：扫描的中心
         * color0：扫描的起始颜色
         * color1：扫描的终止颜色
         */


        /**
         *  4、BitmapShader
         *
         *  BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
         *
         * 参数：
         * bitmap：用来做模板的 Bitmap 对象
         * tileX：横向的 TileMode
         * tileY：纵向的 TileMode。
         */
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Shader shader3 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
        mPaint.setShader(shader3);

        canvas.drawCircle(800,300,200,mPaint);

        /**
         *  5、ComposeShader 混合着色器
         *  构造方法：ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode)
         *
         * 参数：
         * shaderA, shaderB：两个相继使用的 Shader
         * mode: 两个 Shader 的叠加模式，即 shaderA 和 shaderB 应该怎样共同绘制。它的类型是 PorterDuff.Mode 。
         */

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Shader shader4 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_add);
        Shader shader5 = new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Shader shader6 = new ComposeShader(shader4,shader5, PorterDuff.Mode.SRC_OVER);
        mPaint.setShader(shader6);

        canvas.drawCircle(800,800,200,mPaint);
    }
}
