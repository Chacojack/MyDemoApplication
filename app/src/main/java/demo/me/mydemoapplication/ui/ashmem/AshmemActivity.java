package demo.me.mydemoapplication.ui.ashmem;

import android.os.MemoryFile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import demo.me.mydemoapplication.R;

public class AshmemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ashmem);

        try {
            MemoryFile memoryFile = new MemoryFile("MyAshmemDemo",1024*4);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
