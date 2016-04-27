package demo.me.mydemoapplication.ui.coordinator;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.me.mydemoapplication.R;
import demo.me.mydemoapplication.all.BaseActivity;
import demo.me.mydemoapplication.all.SimpleRecyclerView;

/**
 * Created by zjchai on 16/4/25.
 */
public class CoordinatorActivity extends BaseActivity {

    FloatingActionButton floatingActionButton;
    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    SimpleRecyclerView simpleRecyclerView;
    List<View> viewContainer;
    AppBarLayout appBarLayout;

    @Override
    protected void beforeViews() {
        super.beforeViews();
        setContentView(R.layout.activity_coordinator);
    }

    @Override
    protected void doInitViews() {
        super.doInitViews();
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_coordinator);
        viewPager = (ViewPager) findViewById(R.id.pager_coordinator);
        tabLayout = (TabLayout) findViewById(R.id.tab_coordinator);
        toolbar = (Toolbar) findViewById(R.id.toolbar_coordinator);
        appBarLayout = (AppBarLayout) findViewById(R.id.abl_coordinator);
        simpleRecyclerView = new SimpleRecyclerView(this);
    }

    @Override
    protected void afterViews() {
        super.afterViews();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logd("FloatingActionButton onClicked");
                Snackbar.make(v, "FAB clicked", Snackbar.LENGTH_LONG).setAction("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //取消之后的响应事件
                        logd("Snackbar cancel.");
                    }
                }).show();
            }
        });
        setSupportActionBar(toolbar);
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            temp.add(String.valueOf(i));
        }
        viewContainer = new ArrayList<>();
        viewContainer.add(simpleRecyclerView);
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewContainer.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewContainer.get(position));
                return viewContainer.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewContainer.get(position));
            }
        };
        simpleRecyclerView.addAllData(temp);
        viewPager.setAdapter(adapter);
    }
}
