package demo.me.mydemoapplication.ui;

import demo.me.mydemoapplication.all.BaseListActivity;

/**
 * Created by zjchai on 16/4/25.
 */
public class UIActivity extends BaseListActivity {

    public static final String COORDINATOR = "coordinator";

    String[] strings = {COORDINATOR};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(strings);
    }
}
