package demo.me.mydemoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long start = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < 1000; i++) {
            for (int i1 = 0; i1 < 1000; i1++) {
                for (int i2 = 0; i2 < 500; i2++) {
                    if (i == i1) {
                        // 使用没有用的循环来模拟初始化耗时
                        a++ ;
                    }
                }
            }
        }
        Log.d(TAG, "onCreate: use time " + (System.currentTimeMillis() - start));
        Log.d(TAG, "onCreate: a : "+a);
        setContentView(R.layout.activity_splash);
    }



}
