package demo.me.mydemoapplication.ui.transition;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

public class Transition2Activity extends AppCompatActivity {

    private static final String TAG = Transition2Activity.class.getSimpleName();

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
                final Transition.TransitionListener listener = new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(final Transition transition) {
                        Log.d(TAG, "onTransitionStart() called with: transition = [" + transition + "]");
                    }

                    @Override
                    public void onTransitionEnd(final Transition transition) {
                        Log.d(TAG, "onTransitionEnd() called with: transition = [" + transition + "]");
                    }

                    @Override
                    public void onTransitionCancel(final Transition transition) {
                        Log.d(TAG, "onTransitionCancel() called with: transition = [" + transition + "]");
                    }

                    @Override
                    public void onTransitionPause(final Transition transition) {
                        Log.d(TAG, "onTransitionPause() called with: transition = [" + transition + "]");
                    }

                    @Override
                    public void onTransitionResume(final Transition transition) {
                        Log.d(TAG, "onTransitionResume() called with: transition = [" + transition + "]");
                    }
                };
                mFade.addListener(listener);

                TransitionManager.beginDelayedTransition(mRelativeLayout, mFade);

                mRelativeLayout.addView(mTextView);
            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    TransitionManager.endTransitions(mRelativeLayout);
                }
            }
        });

    }
}
