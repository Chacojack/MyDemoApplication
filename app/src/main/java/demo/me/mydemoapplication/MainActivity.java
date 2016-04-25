package demo.me.mydemoapplication;

import demo.me.mydemoapplication.all.BaseListActivity;

public class MainActivity extends BaseListActivity {

    public final static String UI = "UI";

    private String[] string = {UI};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(string);
    }


}
