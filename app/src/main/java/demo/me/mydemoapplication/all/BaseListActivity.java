package demo.me.mydemoapplication.all;

/**
 * Created by zjchai on 16/4/25.
 */
public class BaseListActivity extends BaseActivity {

    protected SimpleRecyclerView simpleRecyclerView;

    @Override
    protected void doInitViews() {
        super.doInitViews();
        simpleRecyclerView = new SimpleRecyclerView(this);
        setContentView(simpleRecyclerView);
    }

}
