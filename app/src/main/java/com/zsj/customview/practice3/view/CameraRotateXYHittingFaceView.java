package com.zsj.customview.practice3.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.zsj.customview.BitmapUtils;
import com.zsj.customview.R;
import com.zsj.customview.ScreenUtils;

/**
 * @created by PingYuan at 10/2/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class CameraRotateXYHittingFaceView extends View {

    private Camera mCamera = new Camera();
    private Matrix mMatrix = new Matrix();
    private int degree;
    private ObjectAnimator mObjectAnimator = ObjectAnimator.ofInt(this, "degree", 0, 360);
    private float newZ = 0;

    public CameraRotateXYHittingFaceView(Context context) {
        super(context);
    }

    public CameraRotateXYHittingFaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraRotateXYHittingFaceView(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        mObjectAnimator.setDuration(5000);
        mObjectAnimator.setInterpolator(new LinearInterpolator());
        mObjectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        newZ = (-metrics.density * 6);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CameraRotateXYHittingFaceView(Context context, @Nullable AttributeSet attrs, int
            defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
//        mObjectAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
//        mObjectAnimator.end();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(ScreenUtils.getScreenWidth(), (ScreenUtils.getScreenHeight() -
                ScreenUtils.dpTopx(48)) / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = BitmapUtils.getRawBitmap(getResources(), R.mipmap.maps);
        canvas.save();
        canvas.translate(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        mCamera.save();
        mCamera.getMatrix(mMatrix);
        mMatrix.preScale(2f, 2f);
        mCamera.rotateX(60);
        mCamera.setLocation(0, 0, -20);
        mCamera.applyToCanvas(canvas);
        mCamera.restore();
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, -bitmap.getWidth() / 2, -bitmap.getHeight() / 2, null);
        canvas.restore();

        bitmap.recycle();
    }

    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }


}
