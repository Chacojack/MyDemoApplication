package demo.me.mydemoapplication.ui.vector;

import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import demo.me.mydemoapplication.R;


public class VectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);

        Log.d(VectorActivity.class.getSimpleName(), "onCreate: ");

        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(
                getResources(), R.drawable.vector_demo_bg, null);
        ((ImageView)findViewById(R.id.test)).setImageDrawable(vectorDrawableCompat);


    }
}
