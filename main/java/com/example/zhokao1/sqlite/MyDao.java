package com.example.zhokao1.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class MyDao {
    private MySqlite helper;
    private SQLiteDatabase mData;
    private Context mContext;

    public MyDao(Context context) {
        mContext = context;
        helper = new MySqlite(context);
        mData = helper.getWritableDatabase();
    }


    public void insertSqlite(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        mData.insert("liu", null, contentValues);
    }

    public ArrayList<String> selectName() {
        ArrayList<String> list = new ArrayList<>();
        Cursor cursor = mData.query("liu", null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            list.add(name);
        }
        return list;
    }

    public void delete() {
        mData.execSQL("delete from liu");
    }

}
