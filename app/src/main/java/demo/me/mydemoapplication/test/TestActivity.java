package demo.me.mydemoapplication.test;

import android.content.Intent;

import demo.me.mydemoapplication.all.BaseListActivity;
import demo.me.mydemoapplication.all.SimpleRecyclerView;

public class TestActivity extends BaseListActivity {
    public final static String SPARSEARRAY = "SPARSEARRAY";

    String[] string = {SPARSEARRAY};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(string);
        simpleRecyclerView.setOnSimpleItemClicked(new SimpleRecyclerView.OnSimpleItemClickedListener() {
            @Override
            public void onSimpleItemClicked(String s) {
                switch (s) {
                    case SPARSEARRAY:
                        doSparseArrayClick();
                        break;
                }
            }
        });
    }

    private void doSparseArrayClick() {
        startActivity(new Intent(this,SparseArrayActivity.class));
    }


}
