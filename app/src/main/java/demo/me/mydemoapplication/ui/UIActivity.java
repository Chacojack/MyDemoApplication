package demo.me.mydemoapplication.ui;

import android.content.Intent;

import demo.me.mydemoapplication.all.BaseListActivity;
import demo.me.mydemoapplication.all.SimpleRecyclerView;
import demo.me.mydemoapplication.ui.bitmap.BitmapPreviewActivity;
import demo.me.mydemoapplication.ui.clock.ClockActivity;
import demo.me.mydemoapplication.ui.coordinator.BehaviorActivity;
import demo.me.mydemoapplication.ui.coordinator.CoordinatorActivity;
import demo.me.mydemoapplication.ui.coordinator.CoordinatorActivity2;

/**
 * Created by zjchai on 16/4/25.
 */
public class UIActivity extends BaseListActivity {

    public static final String COORDINATOR = "coordinator", COORDINATOR2 = "coordinator2", BEHAVIOR = "behavior", BITMAP = "bitmap";
    public static final String CLOCK = "clock";

    String[] strings = {COORDINATOR, COORDINATOR2, BEHAVIOR, BITMAP,CLOCK};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(strings);
        simpleRecyclerView.setOnSimpleItemClicked(new SimpleRecyclerView.OnSimpleItemClickedListener() {
            @Override
            public void onSimpleItemClicked(String s) {
                switch (s) {
                    case COORDINATOR:
                        doCoordinatorClick();
                        break;
                    case COORDINATOR2:
                        doCoordinatorClick2();
                        break;
                    case BEHAVIOR:
                        doBehaviorClick();
                        break;
                    case BITMAP:
                        doBitmapClick();
                        break;
                    case CLOCK:
                        doClockClick();
                        break;
                }
            }
        });
    }

    private void doClockClick() {
        startActivity(new Intent(this, ClockActivity.class));
    }

    private void doBitmapClick() {
        startActivity(new Intent(this, BitmapPreviewActivity.class));
    }

    private void doBehaviorClick() {
        startActivity(new Intent(this, BehaviorActivity.class));
    }

    private void doCoordinatorClick2() {
        startActivity(new Intent(this, CoordinatorActivity2.class));
    }

    private void doCoordinatorClick() {
        startActivity(new Intent(this, CoordinatorActivity.class));
    }
}
