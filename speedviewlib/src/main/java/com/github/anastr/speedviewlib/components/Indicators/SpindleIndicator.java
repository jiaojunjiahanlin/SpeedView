package com.github.anastr.speedviewlib.components.Indicators;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Path;

import com.github.anastr.speedviewlib.Speedometer;

/**
 * this Library build By Anas Altair
 * see it on <a href="https://github.com/anastr/SpeedView">GitHub</a>
 */
public class SpindleIndicator extends Indicator {

    private Path indicatorPath = new Path();

    public SpindleIndicator(Speedometer speedometer) {
        super(speedometer);
        updateIndicator();
    }

    @Override
    public void draw(Canvas canvas, float degree) {
        canvas.save();
        canvas.rotate(90f + degree, getCenterX(), getCenterY());
        canvas.drawPath(indicatorPath, indicatorPaint);
        canvas.restore();
    }

    @Override
    protected void updateIndicator() {
        indicatorPath.reset();
        indicatorPath.moveTo(getCenterX(), getCenterY());
        indicatorPath.quadTo(getCenterX() - getIndicatorWidth(), getViewHeight()*.34f + getPadding()
                , getCenterX(), getViewHeight()*.18f + getPadding());
        indicatorPath.quadTo(getCenterX() + getIndicatorWidth(), getViewHeight()*.34f + getPadding()
                , getCenterX(), getCenterY());

        indicatorPaint.setColor(getIndicatorColor());
    }

    @Override
    protected void setWithEffects(boolean withEffects) {
        if (withEffects && !isInEditMode()) {
            indicatorPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.SOLID));
        }
        else {
            indicatorPaint.setMaskFilter(null);
        }
    }
}
