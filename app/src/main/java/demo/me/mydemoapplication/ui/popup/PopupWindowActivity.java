package demo.me.mydemoapplication.ui.popup;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

public class PopupWindowActivity extends AppCompatActivity {

    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                showPopupWindow();
            }
        });

        findViewById(R.id.dismiss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            }
        });

        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

            }
        });

    }


    public void showPopupWindow() {

        int width = 300;
        int height = 260;

        TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.GREEN);
        textView.setLayoutParams(new ViewGroup.LayoutParams(width, height));

        popupWindow = new PopupWindow(textView, width, height);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);

        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);

    }

    public void showPopupWindowEnter() {

        int width = 300;
        int height = 260;

        TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.GREEN);
        textView.setLayoutParams(new ViewGroup.LayoutParams(width, height));

        popupWindow = new PopupWindow(textView, width, height);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);

        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);

    }
}
