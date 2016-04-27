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
    SimpleAdapter adapter = new SimpleAdapter();

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

    /**
     * 为Recycler设置点击事件监听器
     *
     * @param simpleItemClickedListener
     */
    public void setOnSimpleItemClicked(OnSimpleItemClickedListener simpleItemClickedListener) {
        adapter.setOnSimpleItemClickedListener(simpleItemClickedListener);
    }

    public void addAllData(List<String> datas) {
        adapter.addAllData(datas);
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

        List<String> data = new ArrayList<>();
        OnSimpleItemClickedListener onSimpleItemClickedListener;

        public SimpleAdapter() {
        }

        public SimpleAdapter(OnSimpleItemClickedListener onSimpleItemClickedListener) {
            this.onSimpleItemClickedListener = onSimpleItemClickedListener;
        }

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SimpleViewHolder(LayoutInflater.from(getContext()).inflate(R.layout.vh_simple, parent, false));
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.bind(data.get(position), new OnSimpleItemClickedListener() {
                @Override
                public void onSimpleItemClicked(String s) {
                    if (onSimpleItemClickedListener != null) {
                        onSimpleItemClickedListener.onSimpleItemClicked(s);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void addAllData(List<String> datas) {
            data.addAll(datas);
            notifyDataSetChanged();
        }

        public OnSimpleItemClickedListener getOnSimpleItemClickedListener() {
            return onSimpleItemClickedListener;
        }

        public void setOnSimpleItemClickedListener(OnSimpleItemClickedListener onSimpleItemClickedListener) {
            this.onSimpleItemClickedListener = onSimpleItemClickedListener;
        }
    }


    class SimpleViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RelativeLayout rootLayout;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_simple);
            rootLayout = (RelativeLayout) itemView.findViewById(R.id.rl_simple);
        }

        public void bind(final String s, final OnSimpleItemClickedListener onSimpleItemClickedListener) {
            textView.setText(s);
            rootLayout.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSimpleItemClickedListener != null) {
                        onSimpleItemClickedListener.onSimpleItemClicked(s);
                    }
                }
            });
        }
    }

    public interface OnSimpleItemClickedListener {
        void onSimpleItemClicked(String s);
    }
}
