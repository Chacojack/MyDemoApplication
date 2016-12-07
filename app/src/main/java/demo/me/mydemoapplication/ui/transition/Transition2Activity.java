package demo.me.mydemoapplication.ui.transition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

public class Transition2Activity extends AppCompatActivity {

    LinearLayout mRelativeLayout;
    TextView mTextView;
    Fade mFade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition2);

        mRelativeLayout = (LinearLayout) findViewById(R.id.activity_transition2);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                mTextView = new TextView(Transition2Activity.this);
                mTextView.setText("SSSSSS");

                mFade = new Fade(Fade.IN);

                TransitionManager.beginDelayedTransition(mRelativeLayout, mFade);

                mRelativeLayout.addView(mTextView);
            }
        });
    }
}
