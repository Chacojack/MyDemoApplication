package demo.me.mydemoapplication.ui.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zjchai on 16/9/17.
 */
public class ClockView extends View {

    public static final int BIG_LENGTH = 24;
    public static final int BIG_WIDTH = 6;
    public static final int SMALL_WIDTH = 4;
    public static final int SMALL_LENGTH = 18;
    Paint paint;

    public ClockView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(BIG_WIDTH);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = getWidth() / 4;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        canvas.drawCircle(centerX, centerY, radius, paint);
        canvas.drawPoint(centerX, centerY, paint);

        for (int i = 0; i < 12; i++) {
            if (i % 3 == 0) { // 画大的刻度
                paint.setStrokeWidth(BIG_WIDTH);
                canvas.drawLine(centerX, centerY + radius - BIG_LENGTH, centerX, centerY + radius, paint);
            } else { // 画小的刻度
                paint.setStrokeWidth(SMALL_WIDTH);
                canvas.drawLine(centerX, centerY + radius - SMALL_LENGTH, centerX, centerY + radius, paint);
            }
            canvas.rotate((float) 30, centerX, centerY);
        }


    }
}
