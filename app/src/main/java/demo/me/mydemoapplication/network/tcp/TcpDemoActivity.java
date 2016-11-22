package demo.me.mydemoapplication.network.tcp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import demo.me.mydemoapplication.R;

public class TcpDemoActivity extends AppCompatActivity {

    private static final String TAG = TcpDemoActivity.class.getSimpleName();

    private EditText mEditText;
    private TextView mTextView;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String result = bundle.getString("result");
            mTextView.setText(result);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcp_demo);

        mEditText = (EditText) findViewById(R.id.edit);
        mTextView = (TextView) findViewById(R.id.text);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final String msg = mEditText.getText().toString().trim();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket socket = new Socket("192.168.201.216", 8889);
                            OutputStream outputStream = socket.getOutputStream();
                            outputStream.write(msg.getBytes("UTF-8"));
                            socket.shutdownOutput();
                            Log.d(TAG, "run: send message:" + msg);
                            InputStream inputStream = socket.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                            String result = bufferedReader.readLine();
                            Log.d(TAG, "run: receiver message :" + result);
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putString("result", result);
                            message.setData(bundle);
                            mHandler.sendMessage(message);
                            socket.shutdownInput();
                            socket.close();
                            Log.d(TAG, "run: socket close");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }


}
