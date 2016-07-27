package demo.me.mydemoapplication.ui.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo.me.mydemoapplication.R;

public class KeyBoardActivity extends AppCompatActivity {


    private static final String TAG = KeyBoardActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KeyBoardActivity.this,KeyBoardForwardActivity.class));
            }
        });
    }










}
