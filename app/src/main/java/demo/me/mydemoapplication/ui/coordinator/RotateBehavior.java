package demo.me.mydemoapplication.ui.coordinator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by zjchai on 16/4/27.
 */
public class RotateBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    public final static String TAG = RotateBehavior.class.getSimpleName();

    public RotateBehavior() {

    }

    /**
     * 不覆盖这个构造函数,不能在xml中使用
     *
     * @param context
     * @param attrs
     */
    public RotateBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {

        float offset = getOffset(parent, child);
        child.setRotation(90 * -offset / dependency.getHeight());
        child.setTranslationY(offset);
        return false;
    }

    private int getOffset(CoordinatorLayout parent, FloatingActionButton child) {
        int offset = 0;
        List<View> views = parent.getDependencies(child);
        for (View view : views) {
            if (view instanceof Snackbar.SnackbarLayout) {
                offset = (int) view.getTranslationY() - view.getHeight();
                Log.d(TAG, "getOffset: " + offset);
            }
        }

        return offset;

    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }


}
