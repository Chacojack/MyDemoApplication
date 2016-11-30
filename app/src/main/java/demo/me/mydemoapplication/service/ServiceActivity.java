package demo.me.mydemoapplication.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import demo.me.mydemoapplication.R;

public class ServiceActivity extends AppCompatActivity {

    private static final String TAG = ServiceActivity.class.getSimpleName();

    ServiceConnection mServiceConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startService(new Intent(ServiceActivity.this, MyService.class));
            }
        });

        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                stopService(new Intent(ServiceActivity.this, MyService.class));
            }
        });

        findViewById(R.id.bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                bindService(new Intent(ServiceActivity.this, MyService.class), mServiceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(final ComponentName name, final IBinder service) {
                        Log.d(TAG, "onServiceConnected() called with: name = [" + name + "], service = [" + service + "]");
                    }

                    @Override
                    public void onServiceDisconnected(final ComponentName name) {
                        Log.d(TAG, "onServiceDisconnected() called with: name = [" + name + "]");
                    }
                }, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                unbindService(mServiceConnection);
            }
        });
        findViewById(R.id.finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });

        findViewById(R.id.other_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "run: Thread activity id :" + Thread.currentThread().getId());
                new Thread() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: Thread id :" + Thread.currentThread().getId());
                        Intent intent = new Intent(ServiceActivity.this, MyService.class);
                        startService(intent);
                    }
                }.start();
            }
        });


    }
}
