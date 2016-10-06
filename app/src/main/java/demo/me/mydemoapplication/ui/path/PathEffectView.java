package demo.me.mydemoapplication.ui.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zjchai on 16/10/5.
 */

public class PathEffectView extends View {

    Path mPath;
    Paint mPaint;

    public PathEffectView(Context context) {
        this(context, null);
    }

    public PathEffectView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathEffectView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        ensurePath();
        ensurePaint();
        initPaint();
    }

    private void initPath(int width, int height) {
        ensurePath();
        mPath.reset();
        mPath.moveTo(width / 4, height / 4);
        mPath.lineTo(width / 4, height * 3 / 4);
        mPath.lineTo(width * 3 / 4, height * 3 / 4);


    }

    private void initPaint() {
        mPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setPathEffect(new CornerPathEffect(30));
    }

    private void ensurePaint() {
        if (mPaint == null) {
            mPaint = new Paint();
        }
    }

    private void ensurePath() {
        if (mPath == null) {
            mPath = new Path();
        }
    }


    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        initPath(getWidth(), getHeight());

        canvas.drawPath(mPath, mPaint);

    }
}
