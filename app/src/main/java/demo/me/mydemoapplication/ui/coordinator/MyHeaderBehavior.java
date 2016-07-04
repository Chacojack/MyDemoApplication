package demo.me.mydemoapplication.ui.coordinator;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zjchai on 16/4/29.
 */
public class MyHeaderBehavior extends AppBarLayout.ScrollingViewBehavior {

    public MyHeaderBehavior() {
    }

    public MyHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        if (ev == null) {
            return false;
        }
        return super.onInterceptTouchEvent(parent, child, ev);
    }
}
