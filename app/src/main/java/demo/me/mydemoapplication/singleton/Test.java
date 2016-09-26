package demo.me.mydemoapplication.singleton;

import android.content.Context;
import android.util.Log;

/**
 * Created by zjchai on 16/9/26.
 */
public class Test implements ITest {

    private static final String TAG = Test.class.getSimpleName();

    private static ITest instance;

    private Test(String test) {
        init(test);
    }

    public static ITest getInstance(String test) {
        if (instance == null) {
            synchronized (Test.class) {
                if (instance == null) {
                    instance = new Test(test);
                }
            }
        }
        return instance;
    }

    private void init(String test) {
        Log.d(TAG, "init: " + test);
    }
}