package demo.me.mydemoapplication.ui.mesh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by zjchai on 16/9/17.
 */
public class MeshBitmapHelper {

    public static Bitmap mashBitmap(Bitmap bm, int t) {
        float width = bm.getWidth();
        float height = bm.getHeight();

        Bitmap bitmap = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        int n = 30;

        float[] verts = new float[(n + 1) * (n + 1) * 2];

        for (int j = 0; j <= n; j++) {
            for (int i = 0; i <= n; i++) {
                verts[(i + j * (n + 1)) * 2] = width * i / n;
                verts[(i + j * (n + 1)) * 2 + 1] = height * j / n;
            }
        }

        float[] result = spaceTimeAnimatorAtTime(verts, n, n, t);

        canvas.drawBitmapMesh(bm, n, n, result, 0, null, 0, paint);

        return bitmap;
    }

    public static float[] spaceTimeAnimatorAtTime(float[] vert, int width, int height, int t) {
        if (t == 0) {
            return vert;
        }
        t = 1 ;
        float[] result = copyFloats(vert);

        int positionX = width / 2;
        int positionY = height / 2;

        float centerX = getX(vert, width, positionX, positionY);

        float centerY = getY(vert, width, positionX, positionY);

        for (int y = -t; y <= t; y++) {
            for (int x = -t; x <= t; x++) {
                if (x == 0 || y == 0) {
                    setX(result,width,x + positionX,y + positionY,centerX);
                    setY(result,width,x + positionX,y + positionY,centerY);
                }
            }
        }

//        result[((1 + positionY) * (width + 1) + positionX) * 2] = centerX;
//        result[((1 + positionY) * (width + 1) + positionX) * 2 + 1] = centerY;

        return result;
    }

    public static float[] copyFloats(float[] floats) {
        float[] result = new float[floats.length];
        for (int i = 0; i < floats.length; i++) {
            result[i] = floats[i];
        }
        return result;
    }

    public static float getX(float[] floats, int width, int x, int y) {
        return floats[(x + y * (width + 1)) * 2];
    }

    public static float getY(float[] floats, int width, int x, int y) {
        return floats[(x + y * (width + 1)) * 2 + 1];
    }

    public static void setX(float[] floats, int width, int x, int y, float v) {
        floats[(x + y * (width + 1)) * 2] = v;
    }

    public static void setY(float[] floats, int width, int x, int y, float v) {
        floats[(x + y * (width + 1)) * 2 + 1] = v;
    }

}
