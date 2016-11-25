package demo.me.mydemoapplication.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.me.mydemoapplication.R;

public class FragmentActivity extends AppCompatActivity {

    TestFragment mFragment;
    TestFragment2 mTestFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_fragment, mFragment = new TestFragment());
        transaction.commit();

        findViewById(R.id.fragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if (mTestFragment2 != null) {
                    transaction.remove(mTestFragment2);
                }
                transaction.add(R.id.activity_fragment, mFragment = new TestFragment());
                transaction.commit();
            }
        });
        findViewById(R.id.fragment2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.activity_fragment, mTestFragment2 = new TestFragment2());
                transaction.commit();
            }
        });

    }


}
