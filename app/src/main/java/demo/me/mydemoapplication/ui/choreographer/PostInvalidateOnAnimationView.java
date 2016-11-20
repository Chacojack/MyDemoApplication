package demo.me.mydemoapplication.ui.choreographer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zjchai on 2016/10/30.
 */

public class PostInvalidateOnAnimationView extends View {

    public static final String TAG = PostInvalidateOnAnimationView.class.getSimpleName();

    int index = 0;

    public PostInvalidateOnAnimationView(Context context) {
        this(context, null);
    }

    public PostInvalidateOnAnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PostInvalidateOnAnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }


    @Override
    public void invalidate() {
        Log.d(TAG, "invalidate: time:" + System.currentTimeMillis());
        super.invalidate();
        if (index < 100) {
            index++;
            Log.d(TAG, "postInvalidateOnAnimation index : " + index + " time : " + System.currentTimeMillis());
            postInvalidateOnAnimation();
        }
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "onTouchEvent: start time : " + System.currentTimeMillis());
            postInvalidateOnAnimation();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

    }
}
