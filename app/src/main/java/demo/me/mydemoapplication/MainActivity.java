package demo.me.mydemoapplication;

import android.content.Intent;

import demo.me.mydemoapplication.all.BaseListActivity;
import demo.me.mydemoapplication.all.SimpleRecyclerView;
import demo.me.mydemoapplication.gradle.ChannelActivity;
import demo.me.mydemoapplication.input.KeyboardActivity;
import demo.me.mydemoapplication.sp.SPActivity;
import demo.me.mydemoapplication.test.TestActivity;
import demo.me.mydemoapplication.ui.UIActivity;

public class MainActivity extends BaseListActivity {

    public final static String UI = "UI",GRADLE = "Gradle",SP = "SP",TEST = "TEST",Keyboard = "Keyboard";

    String[] string = {UI,GRADLE,SP,TEST,Keyboard};

    @Override
    protected void afterViews() {
        super.afterViews();
        simpleRecyclerView.addAllData(string);
        simpleRecyclerView.setOnSimpleItemClicked(new SimpleRecyclerView.OnSimpleItemClickedListener() {
            @Override
            public void onSimpleItemClicked(String s) {
                switch (s) {
                    case UI:
                        doUIClicked();
                        break;
                    case GRADLE:
                        doGradleClicked();
                        break;
                    case SP:
                        doSPClicked();
                        break;
                    case TEST:
                        doTestClicked();
                        break;
                    case Keyboard:
                        doKeyboardClicked();
                        break;
                }
            }
        });
    }

    private void doKeyboardClicked() {
        startActivity(new Intent(this, KeyboardActivity.class));
    }

    private void doTestClicked() {
        startActivity(new Intent(this, TestActivity.class));
    }

    private void doSPClicked() {
        startActivity(new Intent(this, SPActivity.class));
    }

    private void doGradleClicked() {
        startActivity(new Intent(this, ChannelActivity.class));
    }

    private void doUIClicked() {
        startActivity(new Intent(this, UIActivity.class));
    }



}
