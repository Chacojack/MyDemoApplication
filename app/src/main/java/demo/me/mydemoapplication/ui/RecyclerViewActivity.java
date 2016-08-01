package demo.me.mydemoapplication.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import demo.me.mydemoapplication.R;

public class RecyclerViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) ;
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        List<String> datas = new ArrayList<>() ;

        Context context ;

        public MyAdapter(Context context) {
            this.context = context ;
            initDatas();
        }

        private void initDatas() {
            datas.clear();
            for (int i = 0; i < 40; i++) {
                datas.add(String.valueOf(i+1)) ;
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.vh_my,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bind(datas.get(position));
        }


        @Override
        public int getItemCount() {
            return datas.size();
        }


    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout root ;
        TextView textView ;
        Button add;
        Button gone ;

        public MyViewHolder(View itemView) {
            super(itemView);
            root = (LinearLayout) itemView.findViewById(R.id.ll_my_vh);
            textView = (TextView) itemView.findViewById(R.id.txt_my_vh);
            add = (Button) itemView.findViewById(R.id.btn_add_my_vh);
            gone = (Button) itemView.findViewById(R.id.btn_gone_my_vh);
        }

        public void bind(String data){
            textView.setText(data);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView view =  new TextView(root.getContext()) ;
                    view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    view.setBackgroundColor(Color.GREEN);
                    view.setText("新的");
                    root.addView(view);
                }
            });
            gone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setVisibility(View.GONE);
                }
            });
        }


    }
}
