package demo.me.mydemoapplication.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.me.mydemoapplication.R;

public class BroadcastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        findViewById(R.id.normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent();
                intent.setAction("jack.stopapplication.order");
                intent.putExtra("data","Jack");
                intent.putExtra("type",1);
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent();
                intent.setAction("jack.stopapplication.order");
                intent.putExtra("data","Jack");
                intent.putExtra("type",2);
                sendOrderedBroadcast(intent, null);
            }
        });

        findViewById(R.id.sticky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent();
                intent.setAction("jack.stopapplication.order");
                intent.putExtra("data","Jack");
                intent.putExtra("type",3);
                sendStickyBroadcast(intent);
            }
        });

    }
}
