package demo.me.mydemoapplication.ui.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import demo.me.mydemoapplication.R;

public class BitmapPreviewActivity extends AppCompatActivity {

    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_preview);

        imageView = (ImageView)findViewById(R.id.image_view) ;

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header_coordinator) ;
        Matrix matrix = new Matrix() ;
        matrix.postRotate(90) ;
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,false) ;

        imageView.setImageBitmap(bitmap1);

    }

}
