package demo.me.mydemoapplication.ui.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zjchai on 16/9/17.
 */
public class LayerView extends View{
    public LayerView(Context context) {
        super(context);
    }

    public LayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LayerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG) ;

        paint.setColor(Color.RED);

        canvas.drawCircle(getWidth() / 2 - 50 , getHeight() / 2 , 100,paint);

        canvas.saveLayerAlpha(0,0,getWidth(),getHeight(),127,Canvas.FULL_COLOR_LAYER_SAVE_FLAG) ;

        paint.setColor(Color.GREEN);

        canvas.drawCircle(getWidth() / 2 + 50,getHeight() / 2 ,100 , paint);

        canvas.restore();

    }
}
