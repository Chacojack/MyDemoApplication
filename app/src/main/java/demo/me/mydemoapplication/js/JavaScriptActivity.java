package demo.me.mydemoapplication.js;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import demo.me.mydemoapplication.R;

@SuppressLint("SetJavaScriptEnabled")
public class JavaScriptActivity extends AppCompatActivity {

    private static final String TAG = JavaScriptActivity.class.getSimpleName();
    WebView mWebView ;
    Button mButton ;
    TextView mTextView ;
    EditText mEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_script);

        //initViews
        mWebView = (WebView) findViewById(R.id.web_view) ;
        mButton = (Button) findViewById(R.id.button) ;
        mEditText = (EditText) findViewById(R.id.edit) ;
        mTextView = (TextView) findViewById(R.id.text_view) ;

        //afterViews
        initWebView();


    }

    @SuppressLint("JavascriptInterface")
    private void initWebView() {
        mWebView.getSettings().setDefaultTextEncodingName("utf-8");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JavaScriptInterface(this),"jackJS");
        mWebView.loadUrl("file:///android_asset/jack.html");
    }


    private class JavaScriptInterface {

        Context mContext ;

        public JavaScriptInterface(Context context) {

            mContext = context ;

        }


        @JavascriptInterface
        public void postInfoFormJS(final String name){
            Log.d(TAG, "postInfoFormJS: name:"+name);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mTextView.setText(name);
                }
            });
        }


        @JavascriptInterface
        public String getInfoFromAndroid(){
            Log.d(TAG, "getInfoFromAndroid: ");
            return mEditText.getText().toString();
        }




    }
}
