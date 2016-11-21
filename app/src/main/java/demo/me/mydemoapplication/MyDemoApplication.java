package demo.me.mydemoapplication;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by zjchai on 2016/11/21.
 */

public class MyDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
