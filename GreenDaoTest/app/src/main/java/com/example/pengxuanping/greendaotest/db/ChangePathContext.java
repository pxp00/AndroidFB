package com.example.pengxuanping.greendaotest.db;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.IOException;


public class ChangePathContext  extends ContextWrapper {

    private static final String TAG = "ChangePathContext"; /* logt + enter */

    /* cls_child must extends cls_parent's constructor_def or constructor_other: constructor use init fields*/
    public ChangePathContext(Context context) {
        super(context);
    }

    /**
     * 获得数据库路径，如果不存在，则创建对象对象
     *
     * @param name
     */
    @Override
    public File getDatabasePath(String name) {
        boolean isFileCreateSuccess = false;

        // 判断是否存在sd卡
        boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
        if (!sdExist) {// SD card不存在,
            Log.d("SD card ", " ++++++++++++++++++++++++++++SD card inexisting plz mount");
            //create a database on /root

            //1. exist dir or not
            String dbDir = "/DBTest";
            String dbPathname = dbDir + "/" + name;

            File filedir = new File(dbDir);
            if (!filedir.exists()){
                filedir.mkdirs(); //级联创建
            }

            // 2. exist file or not
            File filepathname = new File(dbPathname);
            if (!filepathname.exists()) {
                try {
                    isFileCreateSuccess = filepathname.createNewFile();// 创建文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else{
                isFileCreateSuccess = true;
            }

            //3.return obj_file
            if (isFileCreateSuccess){
                Log.d(TAG, "getDatabasePath: +++++++++++ create /DBTest/db_xxx path success\n\r");
                return filepathname;
            } else{
                return super.getDatabasePath(name);
            }

        } else {// SD card 存在
            Log.d(TAG, "getDatabasePath:  ++++++++++++ storage exist !!!");
            // 获取sd卡路径
            String dbDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
            Log.d(TAG, "SD card absolutePath" + dbDir); /* logd + enter */
            dbDir += "/database";// 数据库所在目录
            String dbPathname = dbDir + "/" + name;// 数据库路径

            // 1. 判断目录是否存在，不存在则创建该目录
            File filedir = new File(dbDir);
            if (!filedir.exists())
                filedir.mkdirs(); //级联创建


            // 2.判断文件是否存在，不存在则创建该文件
            File filepathname = new File(dbPathname);
            if (!filepathname.exists()) {
                try {
                    isFileCreateSuccess = filepathname.createNewFile();// 创建文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else{
                isFileCreateSuccess = true;
            }

            // 返回数据库文件对象
            if (isFileCreateSuccess)
                return filepathname;
            else
                return super.getDatabasePath(name);
        }
    }

    /**
     * 重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
     *
     * @param name
     * @param mode
     * @param factory
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
    }

    /**
     * Android 4.0会调用此方法获取数据库。
     *
     * @see android.content.ContextWrapper#openOrCreateDatabase(java.lang.String,
     *      int,
     *      android.database.sqlite.SQLiteDatabase.CursorFactory,
     *      android.database.DatabaseErrorHandler)
     * @param name
     * @param mode
     * @param factory
     * @param errorHandler
     */
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
    }

}
