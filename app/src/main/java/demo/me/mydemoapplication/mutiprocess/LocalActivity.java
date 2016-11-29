package demo.me.mydemoapplication.mutiprocess;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

public class LocalActivity extends AppCompatActivity {

    private static final String TAG = LocalActivity.class.getSimpleName();


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String message = data.getString("data");
            Log.d(TAG, "handleMessage: data:" + message);
        }
    };
    TextView mTextView;

    Messenger mMessenger;
    Messenger cMessenger = new Messenger(mHandler);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        mTextView = (TextView) findViewById(R.id.txt_message);

        findViewById(R.id.btn_attach_remote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(LocalActivity.this, RemoteService.class);

                bindService(intent, new ServiceConnection() {
                    @Override
                    public void onServiceConnected(final ComponentName name, final IBinder service) {
                        mMessenger = new Messenger(service);
                        Message message = new Message();
                        message.what = 123;
                        Bundle bundle = new Bundle();
                        bundle.putString("data", "柴泽建真帅!");
                        message.setData(bundle);
                        try {
                            message.replyTo = cMessenger;
                            mMessenger.send(message);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                            Log.d(TAG, "onServiceConnected: had remote exception");
                        }
                    }

                    @Override
                    public void onServiceDisconnected(final ComponentName name) {

                    }
                }, BIND_AUTO_CREATE);
            }
        });

    }
}
