package demo.me.mydemoapplication.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by zjchai on 16/10/7.
 */

public class CustomView extends RelativeLayout {


    private static final String TAG = CustomView.class.getSimpleName();

    public CustomView(Context context) {
        this(context, null);
        Log.d(TAG, "CustomView: #1");
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Log.d(TAG, "CustomView: #2");
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "CustomView: #3");
        initView();
    }

    private void initView() {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d(TAG, "onFinishInflate: ");
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d(TAG, "onSizeChanged: ");
    }
}
