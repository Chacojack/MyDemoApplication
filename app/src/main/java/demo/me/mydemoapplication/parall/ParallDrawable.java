package demo.me.mydemoapplication.parall;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by zjchai on 16/9/25.
 */

public class ParallDrawable extends Drawable{

    final Rect bounds = new Rect() ;
    Paint paint ;
    Path path ;
    BitmapShader shader ;

    public ParallDrawable(final Bitmap bitmap) {
        init() ;
        setBitmap(bitmap) ;
    }

    private void init() {
        ensurePaint();
        ensurePath();
        initPaint() ;
        initPath() ;
    }

    private void ensurePaint() {
        if (paint == null) {
            paint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
        }
    }

    private void ensurePath() {
        if (path == null) {
            path = new Path() ;
        }
    }


    private void initPaint() {
        paint.setShader(shader) ;
    }

    private void initPath() {
        ensurePath();
        path.reset();
        path.moveTo(0,0);
        path.lineTo(bounds.width(),bounds.height()/2);
        path.lineTo(bounds.width(),bounds.height());
        path.lineTo(0,bounds.height()/2);
        path.close();
    }

    @Override
    public void draw(final Canvas canvas) {
        canvas.drawPath(path,paint);
    }

    @Override
    public void setAlpha(final int alpha) {

    }

    @Override
    public void setColorFilter(final ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return 0;
    }


    @Override
    protected void onBoundsChange(final Rect bounds) {
        super.onBoundsChange(bounds);
        this.bounds.set(bounds);
        initPath();
    }

    public void setBitmap(Bitmap bitmap){
        shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP) ;
        ensurePaint();
        paint.setShader(shader) ;
    }
}
