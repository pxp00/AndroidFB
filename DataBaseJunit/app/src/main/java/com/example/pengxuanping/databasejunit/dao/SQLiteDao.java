package com.example.pengxuanping.databasejunit.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pengxuanping.databasejunit.MySQLiteOpenHelper;

/* dao ? database access obj */
/* helper(create a db & tabele structure) -> dao(insert, select, delete, update table data) -> */
public class SQLiteDao {
    SQLiteDatabase db;
    Context mcontext;

    public SQLiteDao(Context context){
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context,"info.db",null, 1); //config prs
        db = helper.getWritableDatabase(); //create db
        mcontext = context;
    }

    public void insert(String name, String sex) {
        db.execSQL("insert into student(name, sex) values (?, ?)", new Object[]{name, sex});
        Toast.makeText(mcontext, "save"+name +"-"+ sex, Toast.LENGTH_SHORT).show();
    }

    /* Q: get the sex ? A: get raw(condition) -> get columns index(column name) -> getString */
    public String select(String name) {
        int index = 0;
        boolean ret = false;
        String str = null;
        Cursor cursor = db.rawQuery("select * from student where name = ?", new String[]{name});
        ret = cursor.moveToNext();
        if(ret){
            index = cursor.getColumnIndex("sex");
            str = cursor.getString(index);
            System.out.println("str is " + str);
        }
        cursor.close();
        return str;
    }

    /* Q: ret delete success ? A: N, execSQL ret void */
    public void delete(String name) {
        db.execSQL("delete from student where name = ?", new Object[]{name});
    }

    public void update(String name, String sex) {
        db.execSQL("update student set sex = ? where name = ?", new Object[]{name, sex});
    }
}


