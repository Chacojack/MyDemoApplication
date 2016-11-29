package demo.me.mydemoapplication.ui.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by zjchai on 2016/11/30.
 */

public class MyView extends TextView {

    private static final String TAG = "TOUCH_EVENT_VIEW";

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }


    @Override
    public boolean dispatchTouchEvent(final MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent() start called with: ev = [" + ev.getAction() + "]" + " this hash:" + this.hashCode());
        boolean result = super.dispatchTouchEvent(ev);
        Log.d(TAG, "dispatchTouchEvent() over called with: ev = [" + ev.getAction() + "]" + ", result:" + result + " this hash:" + this.hashCode());
        return result;
    }


    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        Log.d(TAG, "onTouchEvent() start called with: event = [" + event.getAction() + "]" + " this hash:" + this.hashCode());
        boolean result = super.onTouchEvent(event);
        Log.d(TAG, "onTouchEvent() over called with: event = [" + event.getAction() + "]" + ", result:" + result + " this hash:" + this.hashCode());
        return true;
    }

}
