package demo.me.mydemoapplication.thread;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

public class AsyncTaskActivity extends AppCompatActivity {


    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        mTextView = (TextView) findViewById(R.id.number);

        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute("开始异步线程");
        myAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "开始异步线程");


    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mTextView.setText(String.valueOf(0));
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);
            mTextView.setText(s);
        }

        @Override
        protected void onProgressUpdate(final Integer... values) {
            super.onProgressUpdate(values);
            mTextView.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onCancelled(final String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected String doInBackground(final String... params) {
            Log.d(MyAsyncTask.class.getSimpleName(), "doInBackground() called with: params = [" + params[0] + "]");
            for (int i = 0; i < 100; i++) {
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "执行完成";
        }
    }


}
