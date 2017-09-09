//package com.softlab.roundprogress;
//
//import android.animation.ValueAnimator;
//import android.content.Context;
//import android.content.res.TypedArray;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.support.annotation.ColorInt;
//import android.support.annotation.Nullable;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.View;
//
///**
// * Created by olehsalamakha on 8/25/17.
// */
//
//public class CircleProgress extends View {
//
//    private int mMainRadius;
//    private int mMainColor;
//    private Paint mMainPaint;
//    private int mStrockeWidth;
//
//    private int mIndicatorRadius;
//    private int mIndicatorColor;
//    private Paint mIndicatorPaint;
//
//    private int mainCenterX;
//    private int mainCenterY;
//
//    private int mIndicatorCenterX;
//    private int mIndicatorCenterY;
//
//    private ValueAnimator mRotateAnimator;
//
//    private float rotate;
//
//    public CircleProgress(Context context) {
//        super(context);
//        init(context, null);
//    }
//
//    public CircleProgress(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(context, attrs);
//    }
//
//    private void init(Context context, AttributeSet attrs) {
//
//        TypedArray ta = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleProgress, 0, 0);
//        mMainRadius = ta.getDimensionPixelSize(R.styleable.CircleProgress_round_progress_main_radius, 300);
//        mMainColor = ta.getColor(R.styleable.CircleProgress_round_progres_main_color, context.getResources().getColor(R.color.colorAccent));
//        mIndicatorColor = ta.getColor(R.styleable.CircleProgress_round_progress_indicator_color, context.getResources().getColor(R.color.colorAccent));
//        mIndicatorRadius = ta.getDimensionPixelSize(R.styleable.CircleProgress_round_progress_indicator_radius, 10);
//        mStrockeWidth = ta.getDimensionPixelSize(R.styleable.CircleProgress_round_progress_strocke_width, 4);
//        ta.recycle();
//
//        mMainPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mMainPaint.setStyle(Paint.Style.STROKE);
//        mMainPaint.setStrokeWidth(mStrockeWidth);
//
//        mMainPaint.setColor(mMainColor);
//        mIndicatorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mIndicatorPaint.setColor(mIndicatorColor);
//
//    }
//
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
//    }
//
//
//    private int measureWidth(int measureSpec) {
//        int size = getPaddingLeft() + getPaddingRight();
//        size += mMainRadius*2;
//        size += mIndicatorRadius*2;
//
//        return resolveSizeAndState(size, measureSpec, 0);
//    }
//
//    private int measureHeight(int measureSpec) {
//        int size = getPaddingBottom() + getPaddingTop();
//        size += mMainRadius * 2;
//        size += mIndicatorRadius*2;
//        return resolveSizeAndState(size, measureSpec, 0);
//    }
//
//    public void startAnimation() {
//        mRotateAnimator = ValueAnimator.ofFloat(0, 360);
//        mRotateAnimator.setDuration(1500);
//        mRotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        mRotateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override public void onAnimationUpdate(ValueAnimator animation) {
//                rotate = (float)animation.getAnimatedValue();
//                Log.d("CustomView", "rotate");
//                invalidate();
//            }
//        });
//
//        mRotateAnimator.start();
//    }
//
//    public void stopAnimation() {
//        mRotateAnimator.cancel();
//        rotate = 0;
//        invalidate();
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        canvas.save();
//        canvas.rotate(rotate, mainCenterX, mainCenterY);
//        mainCenterX = (getWidth() - getPaddingLeft() - getPaddingRight()) / 2;
//        mainCenterY = (getHeight() - getPaddingBottom() - getPaddingTop()) / 2;
//
//        mIndicatorCenterX = mainCenterX;
//        mIndicatorCenterY = mainCenterY - mMainRadius;
//
//        canvas.drawCircle(mainCenterX, mainCenterY, mMainRadius, mMainPaint);
//        canvas.drawCircle(mIndicatorCenterX, mIndicatorCenterY, mIndicatorRadius, mIndicatorPaint);
//
//        canvas.restore();
//
//    }
//
//    public void setMainRadius(int pixels) {
//        mMainRadius = pixels;
//        requestLayout();
//        invalidate();
//    }
//
//    public void setIndicatorRadius(int pixels) {
//        mIndicatorRadius = pixels;
//        requestLayout();
//        invalidate();
//    }
//
//    public void setStrocke(int pixels) {
//        mStrockeWidth = pixels;
//        requestLayout();
//        invalidate();
//    }
//
//    public void setMainColor(@ColorInt int color) {
//        mMainColor = color;
//        invalidate();
//    }
//
//    public void setIndicatorColor(@ColorInt int color) {
//        mIndicatorColor = color;
//        invalidate();
//    }
//
//
//    public int getMainRadius() {
//        return mMainRadius;
//    }
//
//    public int getIndicatorRadius() {
//        return mIndicatorRadius;
//    }
//
//    public int getMainColor() {
//        return mMainColor;
//    }
//
//    public int getIndicatorColor() {
//        return mIndicatorColor;
//    }
//
//    public int getStrockeWidth() {
//        return mStrockeWidth;
//    }
//
//
//
//}
