package demo.me.mydemoapplication.lombok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import demo.me.mydemoapplication.R;

public class LombokActivity extends AppCompatActivity {

    Student mStudent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lombok);

        Student build = Student.builder().id("110").build();

    }
}
