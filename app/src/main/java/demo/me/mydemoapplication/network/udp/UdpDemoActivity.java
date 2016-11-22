package demo.me.mydemoapplication.network.udp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import demo.me.mydemoapplication.R;

public class UdpDemoActivity extends AppCompatActivity {

    private static final String TAG = UdpDemoActivity.class.getSimpleName();

    EditText mEditText;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp_demo);

        mEditText = (EditText) findViewById(R.id.edit);
        mTextView = (TextView) findViewById(R.id.result);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            DatagramSocket socket = new DatagramSocket(8890);
                            String msg = mEditText.getText().toString().trim();
                            Log.d(TAG, "run: get msg:" + msg);
                            try {
                                byte[] bytes = msg.getBytes("UTF-8");
                                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("192.168.201.216", 8890));
                                Log.d(TAG, "run: packet msg:" + datagramPacket);
                                try {
                                    socket.send(datagramPacket);
                                    Log.d(TAG, "run: send msg:" + msg);
                                    socket.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        } catch (SocketException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });


    }
}
