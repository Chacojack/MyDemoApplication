package demo.me.mydemoapplication.all;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.me.mydemoapplication.R;

/**
 * Created by zjchai on 16/4/25.
 */
public class SimpleRecyclerView extends RelativeLayout {

    final static int LAYOUT_ID = R.layout.view_simple_recycler;

    RecyclerView recyclerView;
    private SimpleAdapter adapter = new SimpleAdapter();

    public SimpleRecyclerView(Context context) {
        super(context);
        initView();
    }

    public SimpleRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SimpleRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    void initView() {
        beforeViews();
        doInitViews();
        afterViews();
    }

    void beforeViews() {
        inflate(getContext(), LAYOUT_ID, this);
    }

    void doInitViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_simple);
    }

    void afterViews() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public void addAllData(String[] string) {
        adapter.addAllData(Arrays.asList(string));
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

        List<String> data = new ArrayList<>();

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SimpleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.vh_simple, parent, false));
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.bind(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void addAllData(List<String> datas) {
            data.addAll(datas);
            notifyDataSetChanged();
        }
    }


    class SimpleViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_simple);
        }

        public void bind(String s) {
            textView.setText(s);
        }
    }
}
