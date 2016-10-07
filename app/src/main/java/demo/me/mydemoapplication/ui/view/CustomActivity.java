package demo.me.mydemoapplication.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import demo.me.mydemoapplication.R;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        CustomView customView = new CustomView(this) ;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.activity_custom);
        relativeLayout.addView(customView);
    }
}
