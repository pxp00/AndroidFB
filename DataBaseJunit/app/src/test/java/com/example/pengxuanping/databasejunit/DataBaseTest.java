package com.example.pengxuanping.databasejunit;

import android.util.Log;

import com.example.pengxuanping.databasejunit.dao.SQLiteDao;

import org.junit.Test;

/*
 * eg -> concept, Q -> A, what -> how & why (retrieve)
 * 1. app/build.gradle -> dependencies -> junit:4.12
 * 2. app/test/java/ -> creat class file -> new obj ->  methed ->  result -> R click execute validation
 * */
/*
* thinking flow:
*  db obj (->SQLiteHelper obj) -> insert/select/delete/update/
*
* */
public class DataBaseTest {
    private static final String TAG = "DataBaseTest";
    /*how  field init ? could use the expression or not ?*/
    MainActivity mainact = new MainActivity();
    DataBaseContext dbctx = new DataBaseContext(mainact);
    SQLiteDao sqldb = new SQLiteDao(dbctx);

    @Test
    public void insert(){
        String name = "hugo", sex = "male";
        int i =0;
        for(i = 0; i < 9; i ++){
            sqldb.insert(name + i, sex + i);
            Log.d(TAG, "insert: " + sex);
        }
    }

    @Test
    public void setect(){
        String name ="hugo", sex = null;
        int i =0;
        for(i = 0; i < 9; i ++){
            sex = sqldb.select(name + i);
            Log.d(TAG, "setect: " + sex);
        }
    }
    @Test
    public void update(){
        String name ="hugo", sex = "female";
        int i =0;
        for(i = 0; i < 9; i ++){
            sqldb.update(name + i, sex + i );
            Log.d(TAG, "update: " + sex);
        }
    }
    @Test
    public void delete(){
        String name ="hugo";
        int i =0;
        for(i = 0; i < 5 ; i ++){
            sqldb.delete(name + i);
            Log.d(TAG, "delete: "  + name);
        }
    }
}
