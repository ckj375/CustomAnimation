package com.ckj.customanimation;

import android.graphics.Matrix;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by chenkaijian on 16-8-12.
 */
public class MyAnimation2 extends Animation {

    private int halfWidth;
    private int halfHeight;

    public MyAnimation2() {
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        setDuration(1000);
        setFillAfter(false);
        //保存View的中心点
        halfWidth = width / 2;
        halfHeight = height / 2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        final Matrix matrix = t.getMatrix();

        matrix.preRotate(interpolatedTime * 360, halfWidth, halfHeight);
        matrix.preScale(1 - interpolatedTime, 1 - interpolatedTime, halfWidth, halfHeight);
    }
}
