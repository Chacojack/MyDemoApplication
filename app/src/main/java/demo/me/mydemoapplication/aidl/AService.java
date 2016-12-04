package demo.me.mydemoapplication.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import demo.me.mydemoapplication.IAAidlInterface;

/**
 * Created by zjchai on 2016/12/3.
 */

public class AService extends Service {

    private static final String TAG = AService.class.getSimpleName();


    IAAidlInterface.Stub mAidlInterface = new IAAidlInterface.Stub() {

        @Override
        public void a(final int anInt, final long aLong, final boolean aBoolean, final float aFloat, final double aDouble, final String aString) throws RemoteException {
            Log.d(TAG, "a() called with: anInt = [" + anInt + "], aLong = [" + aLong + "], aBoolean = [" + aBoolean + "], aFloat = [" + aFloat + "], aDouble = [" + aDouble + "], aString = [" + aString + "]");
            Log.d(TAG, "a: process id:" + Process.myPid() + ", thread id:" + Thread.currentThread());
        }

        @Override
        public int a1(final int anInt, final long aLong, final boolean aBoolean, final float aFloat, final double aDouble, final String aString) throws RemoteException {
            Log.d(TAG, "a1() called with: anInt = [" + anInt + "], aLong = [" + aLong + "], aBoolean = [" + aBoolean + "], aFloat = [" + aFloat + "], aDouble = [" + aDouble + "], aString = [" + aString + "]");
            Log.d(TAG, "a1: process id:" + Process.myPid() + ", thread id:" + Thread.currentThread());
            return 11111;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(final Intent intent) {
        return mAidlInterface;
    }


}
