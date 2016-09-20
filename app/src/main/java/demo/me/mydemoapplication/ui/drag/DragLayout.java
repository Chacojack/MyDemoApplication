package demo.me.mydemoapplication.ui.drag;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by zjchai on 16/9/18.
 */
public class DragLayout extends LinearLayout {

    ViewDragHelper viewDragHelper ;
    private ViewDragHelper.Callback callback ;

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DragLayout(Context context) {
        super(context);
        init() ;
    }

    private void init() {
        callback = new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return true;
            }


            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }

        } ;
        viewDragHelper = ViewDragHelper.create(this,1f,callback) ;
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                viewDragHelper.processTouchEvent(event);
                return true;
            }
        });
    }
}
