package com.russelarms.digitdrawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/**
 * Created by russelarms on 21.02.2016.
 */
public class DigitDrawable extends Drawable {

    private int counter;
    private Paint mPaint;
    private Paint mPaintText;

    private RectF mRectF;
    private Bitmap mBitmap;

    public DigitDrawable(Bitmap image) {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaintText = new Paint();
        mPaintText.setColor(Color.WHITE);
        mPaintText.setTextSize(25);
        mPaintText.setTextAlign(Paint.Align.CENTER);

        mBitmap = image;

        mRectF = new RectF();
    }

    public void setCounter(int counter) {
        this.counter = counter;
        invalidateSelf();
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        int r = bounds.right;
//        int r = bounds.bottom;
        mRectF.set(bounds.left, bounds.top, r, bounds.bottom);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, null, mRectF, mPaint);

        String text = Integer.toString(counter);

        if (counter > 0) {
            canvas.drawText(text, mRectF.centerX(), mRectF.top - 2, mPaintText);
        }
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }
}
