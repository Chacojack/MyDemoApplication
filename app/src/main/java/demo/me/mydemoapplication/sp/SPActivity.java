package demo.me.mydemoapplication.sp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import demo.me.mydemoapplication.R;

/**
 * Created by zjchai on 16/7/14.
 */
public class SPActivity extends Activity implements View.OnClickListener,SharedPreferences.OnSharedPreferenceChangeListener {

    EditText editTextName ;
    EditText editTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        findViewById(R.id.btn_activity).setOnClickListener(this);
        findViewById(R.id.btn_app).setOnClickListener(this);
        findViewById(R.id.btn_diy).setOnClickListener(this);

        editTextName = getEditName() ;
        editTextAge = getEditAge() ;

    }

    private EditText getEditName(){
        return (EditText) findViewById(R.id.edit_name);
    }

    private EditText getEditAge(){
        return (EditText) findViewById(R.id.edit_age);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_activity:
                doSaveWithSharePreference();
                break;
            case R.id.btn_app:
                doSaveWithAppSharePreference();
                break;
            case R.id.btn_diy:
                doSaveWithDIYSharePreference();
                break;
        }
    }

    private void doSaveWithDIYSharePreference() {
        SharedPreferences diySP = getSharedPreferences("diy",MODE_PRIVATE) ;
        diySP.edit()
                .putString("name",editTextName.getText().toString())
                .putString("age", editTextAge.getText().toString())
                .apply();
        diySP.registerOnSharedPreferenceChangeListener(this);
    }

    private void doSaveWithAppSharePreference() {
        SharedPreferences appSP = PreferenceManager.getDefaultSharedPreferences(this) ;
        appSP.edit()
                .putString("name",editTextName.getText().toString())
                .putString("age", editTextAge.getText().toString())
                .apply();
    }

    private void doSaveWithSharePreference() {
        SharedPreferences activitySP = getPreferences(MODE_PRIVATE) ;
        activitySP.edit()
                .putString("name",editTextName.getText().toString())
                .putString("age", editTextAge.getText().toString())
                .apply();

    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Snackbar.make(getWindow().getDecorView(),key+" changed to :"+sharedPreferences.getString(key,""),Snackbar.LENGTH_LONG).show();
    }
}
