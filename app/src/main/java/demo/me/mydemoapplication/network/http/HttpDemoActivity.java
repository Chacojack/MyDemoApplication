package demo.me.mydemoapplication.network.http;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import demo.me.mydemoapplication.R;

public class HttpDemoActivity extends AppCompatActivity {

    private static final String MY_URL = "https://chacojack.github.io/";
    private static final String TAG = HttpDemoActivity.class.getSimpleName();

    URL url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_demo);
        try {
            url = new URL(MY_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        findViewById(R.id.get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (url != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            getHttpResult();
                        }
                    }).start();
                }
            }
        });

        findViewById(R.id.header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (url != null) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            headerHttpResult();
                        }
                    }).start();
                }
            }
        });

    }

    private void headerHttpResult() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("HEAD");

            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                Log.d(TAG, String.format("headerHttpResult: key:%s,value:%s", key, value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getHttpResult() {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[1024];
            int length;
            while ((length = bufferedReader.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, length));
            }
            Log.d(TAG, String.format("onClick: get string:%s", builder.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
