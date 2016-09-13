package demo.me.mydemoapplication.shader;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zjchai on 16/8/25.
 */
public class ShaderView extends View {

    private Paint mPaint ;

    public ShaderView(Context context) {
        super(context);
        init() ;
    }

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init() ;
    }

    public ShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init() ;
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG) ;
    }


}
