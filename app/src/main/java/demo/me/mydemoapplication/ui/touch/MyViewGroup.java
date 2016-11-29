package demo.me.mydemoapplication.ui.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Created by zjchai on 2016/11/30.
 */

public class MyViewGroup extends RelativeLayout {

    private static final String TAG = "TOUCH_EVENT_VIEW_GROUP";

    public MyViewGroup(Context context) {
        this(context, null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }

    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent() start called with: ev = [" + ev.getAction() + "]");
        boolean result = super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent() over called with: ev = [" + ev.getAction() + "]" + ", result:" + result);
        return result;
    }

    @Override
    public boolean onInterceptTouchEvent(final MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent() start called with: ev = [" + ev.getAction() + "]");
        boolean result = super.onInterceptTouchEvent(ev);
        result = true;
        Log.d(TAG, "onInterceptTouchEvent() over called with: ev = [" + ev.getAction() + "]" + ", result:" + result);
        return result;
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.d(TAG, "onTouchEvent() start called with: event = [" + event.getAction() + "]");
        boolean result = super.onTouchEvent(event);
        Log.d(TAG, "onTouchEvent() over called with: event = [" + event.getAction() + "]" + ", result:" + result);
        return result;
    }
}
