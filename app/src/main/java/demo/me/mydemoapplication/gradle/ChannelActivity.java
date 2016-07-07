package demo.me.mydemoapplication.gradle;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;

import demo.me.mydemoapplication.R;
import demo.me.mydemoapplication.all.BaseActivity;

public class ChannelActivity extends BaseActivity {


    @Override
    protected void beforeViews() {
        super.beforeViews();
        setContentView(R.layout.activity_channel);
    }

    @Override
    protected void doInitViews() {
        super.doInitViews();
        ApplicationInfo info = null;
        TextView textView = (TextView) findViewById(R.id.tv_channel);
        try {
            info = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
            String msg = info.metaData.getString("UMENG_CHANNEL");
            textView.setText(msg);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
