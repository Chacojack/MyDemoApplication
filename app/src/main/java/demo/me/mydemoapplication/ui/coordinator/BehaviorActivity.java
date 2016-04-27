package demo.me.mydemoapplication.ui.coordinator;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;

import demo.me.mydemoapplication.R;
import demo.me.mydemoapplication.all.BaseActivity;

/**
 * Created by zjchai on 16/4/27.
 */
public class BehaviorActivity extends BaseActivity {

    FloatingActionButton floatingActionButton;

    @Override
    protected void beforeViews() {
        super.beforeViews();
        setContentView(R.layout.activity_behavior);
    }

    @Override
    protected void doInitViews() {
        super.doInitViews();
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_behavior);
    }

    @Override
    protected void afterViews() {
        super.afterViews();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "FAB", Snackbar.LENGTH_INDEFINITE).setAction("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

    }
}
