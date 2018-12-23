package com.example.pengxuanping.databasejunit;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.MEDIA_MOUNTED;
import static android.os.Environment.getExternalStorageState;

public class DataBaseContext extends ContextWrapper{
    public DataBaseContext(Context context) {
        super(context);
    }



    @Override
    public File getDatabasePath(String name) {
        //判断是否存在sd卡
        boolean sdExist = MEDIA_MOUNTED.equals(getExternalStorageState());
        if(!sdExist){//如果不存在,
            return null;
        }
        else{//如果存在
            //获取sd卡路径
            String dbdir = Environment.getExternalStorageDirectory().getPath();
            //String dbdir=android.os.Environment.getExternalStorageDirectory().toString();  //storage/emulated/0/
            dbdir += "/DB";//数据库所在目录
            String dbpathname = dbdir+"/"+name;//数据库路径 /storage/emulated/0/scexam/info.db
            //判断目录是否存在，不存在则创建该目录
            File filedir= new File(dbdir);
            if(!filedir.exists())
                filedir.mkdirs();

            //数据库文件是否创建成功
            boolean isFileCreateSuccess = false;
            //判断文件是否存在，不存在则创建该文件
            File filepathname = new File(dbpathname);
            if(!filepathname.exists()){
                try {
                    isFileCreateSuccess = filepathname.createNewFile();//创建文件
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else
                isFileCreateSuccess = true;

            //返回数据库文件对象
            if(isFileCreateSuccess)
                return filepathname;
            else
                return null;
        }

    }


    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode,
                                               SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }

    /**
     * Android 4.0会调用此方法获取数据库。
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode,  SQLiteDatabase.CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }

}

