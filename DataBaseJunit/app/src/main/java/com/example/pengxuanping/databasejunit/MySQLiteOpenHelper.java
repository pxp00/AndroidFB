package com.example.pengxuanping.databasejunit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = "DataBase";

    /* ctx = act, dbname = "info.db" (need suffix), null, dbver = 1 */
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    /* creat xx.db file, when will call the method ? getWritableDataBase(), creat xx.db file, if existed just open */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student (_id integer primary key autoincrement, name text, sex text)");
        Log.d(TAG, "onCreate: create table student");
    }

    @Override
   /* creat table/ modify table structure, constructor parameter "version" be changed -> call this method,  */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("alter table student add account real");
        Log.d(TAG, "onUpgrade: add column account");
    }

}
