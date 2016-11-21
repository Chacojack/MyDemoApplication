package demo.me.mydemoapplication.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import demo.me.mydemoapplication.R;

public class DataBaseActivity extends AppCompatActivity {

    private static final String TAG = DataBaseActivity.class.getSimpleName();

    public static final String MY_DB_NAME = "my_dome_db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);


        findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(DataBaseActivity.this, "my_dome_db", null, 1);
                SQLiteDatabase database = dataBaseHelper.getReadableDatabase();
            }
        });

        findViewById(R.id.update_database).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
            }
        });

        findViewById(R.id.query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper db = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase database = db.getReadableDatabase();
                Cursor cursor = database.query("user", new String[]{"id", "name"}, null, null, null, null, null);
                int count = cursor.getCount();
                if (cursor.moveToFirst() && count > 0) {
                    for (int i = 0; i < count; i++) {
                        String id = cursor.getString(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        Log.d(TAG, String.format("onClick: user{ id:%s,name:%s}", id, name));
                        cursor.moveToNext();
                    }
                }
                cursor.close();
            }
        });

        findViewById(R.id.add_jack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper helper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id", "1206");
                values.put("name", "Jack");
                db.insert("user", null, values);
            }
        });

        findViewById(R.id.add_tom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper helper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id", "1207");
                values.put("name", "Tom");
                db.insert("user", null, values);
            }
        });

        findViewById(R.id.add_fuck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper helper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id", "1208");
                values.put("name", "Fuck");
                db.insert("user", null, values);
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
                db.delete("user", "name=?", new String[]{"Jack"});
            }
        });

        findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                DataBaseHelper helper = new DataBaseHelper(DataBaseActivity.this, MY_DB_NAME, null, 2);
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("id", "1310");
                values.put("name", "Jack Chai");
                db.update("user", values, "name=?", new String[]{"Jack"});
            }
        });

    }


}
