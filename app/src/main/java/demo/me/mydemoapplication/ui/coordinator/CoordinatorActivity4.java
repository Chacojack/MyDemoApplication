package demo.me.mydemoapplication.ui.coordinator;

import android.app.Activity;
import android.os.Bundle;

import demo.me.mydemoapplication.R;

public class CoordinatorActivity4 extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initExtra(savedInstanceState);
        inject();
        afterInject();
        setContentView(R.layout.activity_coordinator4);
        afterViews();
    }

    /**
     * init Extra from intent
     *
     * @param savedInstanceState
     */
    private void initExtra(Bundle savedInstanceState) {

    }

    private void inject() {

    }

    private void afterInject() {

    }

    private void afterViews() {

    }

}
