package demo.me.mydemoapplication.ui.colorMatrix;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by zjchai on 16/9/17.
 */
public class ColorMatrixHelper {


    public static Bitmap processImageEffect(Bitmap bm,float hue,float saturation, float lum){

        Bitmap bitmap = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(), Bitmap.Config.ARGB_8888) ;

        Canvas canvas = new Canvas(bitmap) ;
        Paint paint = new Paint() ;
        ColorMatrix hueMatrix = new ColorMatrix() ;
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMatrix = new ColorMatrix() ;
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix() ;
        lumMatrix.setScale(lum,lum,lum,1);

        ColorMatrix colorMatrix = new ColorMatrix() ;
        colorMatrix.postConcat(hueMatrix);
        colorMatrix.postConcat(saturationMatrix);
        colorMatrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix)) ;

        canvas.drawBitmap(bm,0,0,paint);
        return bitmap ;
    }

}
