package demo.me.mydemoapplication.stop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import demo.me.mydemoapplication.R;

public class StopTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_test);

        findViewById(R.id.btn_stop_exclude).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent("jack.stopapplication.stop");
                intent.putExtra("context","exclude") ;
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.btn_stop_include).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent("jack.stopapplication.stop");
                intent.putExtra("context","include") ;
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES) ;
                sendBroadcast(intent);
            }
        });
    }
}
