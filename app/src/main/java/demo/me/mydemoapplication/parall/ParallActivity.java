package demo.me.mydemoapplication.parall;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import demo.me.mydemoapplication.R;

public class ParallActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parall);

        recyclerView = (RecyclerView) findViewById(R.id.list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new ParallAdapter(10));

        recyclerView.setBackgroundColor(Color.GREEN);
    }


    private class ParallAdapter extends RecyclerView.Adapter<ParallViewHolder> {

        int number ;

        public ParallAdapter(final int i) {
            this.number = i;
        }

        @Override
        public ParallViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            View view = LayoutInflater.from(ParallActivity.this).inflate(R.layout.vh_parall, parent,false);
            return new ParallViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ParallViewHolder holder, final int position) {
            holder.bind();
        }

        @Override
        public int getItemCount() {
            return number;
        }
    }

    class ParallViewHolder extends RecyclerView.ViewHolder{

        Bitmap bitmap ;
        ImageView view;

        public ParallViewHolder(final View itemView) {
            super(itemView);
            view = (ImageView) itemView.findViewById(R.id.view);
            bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image_1) ;


        }

        public void bind(){
            view.setImageDrawable(new ParallDrawable(bitmap));
        }
    }
}
