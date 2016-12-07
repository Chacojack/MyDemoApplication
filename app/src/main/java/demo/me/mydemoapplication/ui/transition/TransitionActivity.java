package demo.me.mydemoapplication.ui.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;

import demo.me.mydemoapplication.R;

public class TransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        ViewGroup container = (ViewGroup) findViewById(R.id.scene_container);

        Scene aScene = Scene.getSceneForLayout(container, R.layout.a_scene, this);
        final Scene anotherScene = Scene.getSceneForLayout(container, R.layout.another_scene, this);

        findViewById(R.id.fade).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Transition transition = TransitionInflater.from(TransitionActivity.this).inflateTransition(R.transition.fade_transition);
                TransitionManager.go(anotherScene, transition);
            }
        });

        findViewById(R.id.set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                TransitionSet transition = (TransitionSet) TransitionInflater.from(TransitionActivity.this).inflateTransition(R.transition.set_transition);
                TransitionManager.go(anotherScene, transition);
            }
        });



    }
}
