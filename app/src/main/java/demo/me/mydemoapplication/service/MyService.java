package demo.me.mydemoapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zjchai on 2016/11/20.
 */

public class MyService extends Service {

    private static final String TAG = MyService.class.getSimpleName();

    private MyBinder mMyBinder;


    public class MyBinder extends Binder {

        MyService getService() {
            return MyService.this;
        }

    }


    @Nullable
    @Override
    public IBinder onBind(final Intent intent) {
        Log.d(TAG, "onBind() called with: intent = [" + intent + "]");
        return mMyBinder = new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() called . Thread id:" + Thread.currentThread().getId());
        super.onCreate();
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        Log.d(TAG, "onStartCommand() called with: intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(final Intent intent) {
        Log.d(TAG, "onUnbind() called with: intent = [" + intent + "]");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(final Intent intent) {
        Log.d(TAG, "onRebind() called with: intent = [" + intent + "]");
        super.onRebind(intent);
    }
}
