package demo.me.mydemoapplication.ui.mesh;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import demo.me.mydemoapplication.R;

public class MeshActivity extends AppCompatActivity {

    ImageView imageView ;
    Button button ;

    Bitmap bitmap ;
    int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesh);

        imageView = (ImageView) findViewById(R.id.image) ;
        button = (Button) findViewById(R.id.change);

        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.header_coordinator) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = MeshBitmapHelper.mashBitmap(MeshActivity.this.bitmap,number++ );
                imageView.setImageBitmap(bitmap);
            }
        });


    }



}
