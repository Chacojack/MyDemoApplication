package demo.me.mydemoapplication.input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import demo.me.mydemoapplication.R;
import demo.me.mydemoapplication.ui.keyboard.KeyBoardActivity;

public class KeyboardActivity extends AppCompatActivity {

    private static final String TAG = KeyBoardActivity.class.getSimpleName();
    EditText done;
    EditText edit;
    EditText previous;
    EditText next;

    OnEditorActionListener listener = new OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            Log.d(TAG, String.format("onEditorAction: v : %s,actionId : %d, event : %s",v,actionId,event));
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        done = (EditText) findViewById(R.id.edit_done) ;
        next = (EditText) findViewById(R.id.edit_next) ;
        previous = (EditText) findViewById(R.id.edit_previous) ;
        edit = (EditText) findViewById(R.id.edit) ;

        done.setOnEditorActionListener(listener);
        next.setOnEditorActionListener(listener);
        previous.setOnEditorActionListener(listener);
        edit.setOnEditorActionListener(listener);
    }



}
