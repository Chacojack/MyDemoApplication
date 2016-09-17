package demo.me.mydemoapplication.ui.colorMatrix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import demo.me.mydemoapplication.R;

public class ColorMatrixActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    ImageView imageView;
    SeekBar hue;
    SeekBar saturation;
    SeekBar lum;

    Bitmap bitmap;

    float mHue, mSaturation, mLum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_matrix);
        mHue = mLum = mSaturation = 1;

        imageView = (ImageView) findViewById(R.id.image);
        hue = (SeekBar) findViewById(R.id.hue);
        saturation = (SeekBar) findViewById(R.id.saturation);
        lum = (SeekBar) findViewById(R.id.lum);

        imageView.setImageResource(R.drawable.header_coordinator);
        hue.setOnSeekBarChangeListener(this);
        saturation.setOnSeekBarChangeListener(this);
        lum.setOnSeekBarChangeListener(this);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header_coordinator);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.hue:
                mHue = (progress - 50) / 50f * 180;
                break;
            case R.id.lum:
                mLum = progress * 1f / 50;
                break;
            case R.id.saturation:
                mSaturation = progress * 1f / 50;
                break;
        }
        imageView.setImageBitmap(ColorMatrixHelper.processImageEffect(bitmap, mHue, mSaturation, mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
