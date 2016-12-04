package demo.me.mydemoapplication.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import demo.me.mydemoapplication.IAAidlInterface;
import demo.me.mydemoapplication.R;

public class AServiceActivity extends AppCompatActivity {

    private static final String TAG = AServiceActivity.class.getSimpleName();

    IAAidlInterface mAidlInterface;
    ServiceConnection mConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aservice);

        findViewById(R.id.bind_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(AServiceActivity.this, AService.class);

                bindService(intent, mConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(final ComponentName name, final IBinder service) {
                        Log.d(TAG, "onServiceConnected() called with: name = [" + name + "], service = [" + service + "]");
                        Log.d(TAG, "onServiceConnected: process id:" + Process.myPid() + ",thread id:" + Thread.currentThread());
                        mAidlInterface = IAAidlInterface.Stub.asInterface(service);
                    }

                    @Override
                    public void onServiceDisconnected(final ComponentName name) {
                        Log.d(TAG, "onServiceDisconnected() called with: name = [" + name + "]");
                        Log.d(TAG, "onServiceDisconnected: process id:" + Process.myPid() + ",thread id:" + Thread.currentThread());
                    }
                }, BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.execute_a_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mAidlInterface != null) {
                    try {
                        Log.d(TAG, "onClick: a process id:" + Process.myPid() + ",thread id:" + Thread.currentThread());
                        mAidlInterface.a(1, 111111111L, true, 1.111f, 11111, "柴小建真帅");
                    } catch (RemoteException e) {
                        Log.d(TAG, "has exception :" + e);
                        e.printStackTrace();
                    }
                }
            }
        });

        findViewById(R.id.execute_a1_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mAidlInterface != null) {
                    try {
                        Log.d(TAG, "onClick: a1 process id:" + Process.myPid() + ",thread id:" + Thread.currentThread());
                        int result = mAidlInterface.a1(3, 33333, false, 33.33f, 3333333, "真臭不要脸");
                        Log.d(TAG, "onClick() returned: " + result);
                    } catch (RemoteException e) {
                        Log.d(TAG, "onClick: has exception:" + e);
                        e.printStackTrace();
                    }
                }
            }
        });

        findViewById(R.id.unbind_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                unbindService(mConnection);
            }
        });

    }


}
