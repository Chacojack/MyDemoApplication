package demo.me.mydemoapplication;

import android.content.Intent;

import demo.me.mydemoapplication.all.BaseListActivity;
import demo.me.mydemoapplication.all.SimpleRecyclerView;
import demo.me.mydemoapplication.ui.UIActivity;

public class MainActivity extends BaseListActivity {

    public final static String UI = "UI";

    String[] string = {UI};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(string);
        simpleRecyclerView.setOnSimpleItemClicked(new SimpleRecyclerView.OnSimpleItemClickedListener() {
            @Override
            public void onSimpleItemClicked(String s) {
                switch (s) {
                    case UI:
                        doUIClicked();
                        break;
                }
            }
        });
    }

    private void doUIClicked() {
        startActivity(new Intent(this, UIActivity.class));
    }

}
