package demo.me.mydemoapplication.network.download;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import demo.me.mydemoapplication.R;

public class DownloadDemoActivity extends AppCompatActivity {

    private static final String DOWNLOAD_PATH = "http://www.chatgame.me/static_file/ChatGame.apk";
    private static final String FILE_DIR = "/download/";
    private static final String FILE_PATH = FILE_DIR + "/chatgame.apk";
    private static final String TAG = DownloadDemoActivity.class.getSimpleName();

    private ProgressBar mProgressBar;
    private TextView mTextView;
    private boolean pause = false;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            int progress = msg.arg1;
            mTextView.setText(String.valueOf(progress));
            mProgressBar.setProgress(progress);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_demo);

        mProgressBar = (ProgressBar) findViewById(R.id.download_progressbar);
        mProgressBar.setMax(100);
        mProgressBar.setProgress(0);
        mTextView = (TextView) findViewById(R.id.txt_progress);

        findViewById(R.id.pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                pause = true;
            }
        });


        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                pause = false;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL(DOWNLOAD_PATH);
                            try {
                                File dir = new File(getExternalCacheDir() + FILE_DIR);
                                if (!dir.exists()) {
                                    if (dir.mkdirs()) {
                                        Log.d(TAG, "onClick: create dir success");
                                    }
                                }
                                File file = new File(getExternalCacheDir() + FILE_PATH);

                                int completeSize = 0;

                                if (file.exists()) {
                                    completeSize += file.length();
                                } else {
                                    if (file.createNewFile()) {
                                        Log.d(TAG, "onClick: create file success");
                                    }
                                }
                                RandomAccessFile accessFile = new RandomAccessFile(file, "rwd");

                                byte[] buffer = new byte[1024];
                                int length = 0;

                                URLConnection urlConnection = url.openConnection();
                                urlConnection.setRequestProperty("Range", "bytes=" + completeSize + "-");
                                long leftSize = urlConnection.getContentLength();
                                long fileSize = leftSize + completeSize;
                                Log.d(TAG, "run: fileSize :" + leftSize);
                                InputStream inputStream = urlConnection.getInputStream();

                                if (completeSize == fileSize) {
                                    Log.d(TAG, "run: file is exits and download over");
                                    return;
                                } else if (completeSize > fileSize) {
                                    Log.d(TAG, "run: file is exits but like not the file.");
                                    return;
                                }

                                accessFile.seek(completeSize);

                                while (!pause && (length = inputStream.read(buffer)) != -1) {
                                    accessFile.write(buffer, 0, length);
                                    completeSize += length;
                                    Message message = new Message();
                                    message.arg1 = (int) (completeSize * 100f / fileSize);
                                    Log.d(TAG, "run: download progress:" + message.arg1 + ",completeSize:" + completeSize + ",fileSize:" + fileSize);
                                    mHandler.sendMessage(message);
                                }

                                inputStream.close();
                                accessFile.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

    }


}
