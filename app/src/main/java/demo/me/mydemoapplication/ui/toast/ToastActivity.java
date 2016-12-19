package demo.me.mydemoapplication.ui.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import demo.me.mydemoapplication.R;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        findViewById(R.id.btn_toast_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast toast = Toast.makeText(ToastActivity.this, "Toast 1", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        findViewById(R.id.btn_toast_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(ToastActivity.this, "Toast 2", Toast.LENGTH_LONG).show();
            }
        });

    }
}
