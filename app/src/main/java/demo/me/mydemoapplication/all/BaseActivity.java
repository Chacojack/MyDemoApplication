package demo.me.mydemoapplication.all;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by zjchai on 16/4/25.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logd("onCreate");
        initIntentExtra(savedInstanceState);
        initViews();
    }

    /**
     * 初始化传入数据
     *
     * @param savedInstanceState
     */
    protected void initIntentExtra(Bundle savedInstanceState) {
        logd("initIntentExtra");
    }

    private final void initViews() {
        beforeViews();
        doInitViews();
        afterViews();
    }

    /**
     * 初始化视图之前 在onCreate中
     */
    protected void beforeViews() {
        logd("beforeViews");
    }

    /**
     * 初始化视图操作 在onCreate中
     */
    protected void doInitViews() {
        logd("doInitViews");
    }

    /**
     * 初始化视图之后 在onCreate中
     */
    protected void afterViews() {
        logd("afterViews");
    }

    @Override
    protected void onStart() {
        super.onStart();
        logd("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logd("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logd("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logd("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logd("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logd("onDestroy");
    }

    public void logd(String s) {
        Log.d(this.getClass().getSimpleName(), s);
    }

}
