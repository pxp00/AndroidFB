package com.example.pengxuanping.greendaotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pengxuanping.greendaotest.dao.DaoMaster;
import com.example.pengxuanping.greendaotest.dao.DaoSession;

/* init all parameters(create db, oncreate, upgrade) and getDaosession */
public class DbManager {

    // 是否加密
    public static final boolean ENCRYPTED = true;
    private static final String DB_NAME = "test.db";
    private static DbManager mDbManager;
    private static DaoMaster.DevOpenHelper mDevOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;

    private Context mContext;

    /*
        DaoMaster
            1. DaoSession
            2. DevOpenHelper
                a. getReadableDB;
                b. getWritableDb;
    */

    /*
    *  openhelper(ctx, db_name) //set ctx(path_db), name_db, ver_db,  -> db(getwritableDb)//create DB, table -> daoMaster(db) -> daoSession -> xxx_dao(insert, del, update, quary)
    */

    /* init getDaoSession */
    private DbManager(Context context) {
        this.mContext = context;
        // init parameters of database: DevOpenHelper, DaoMaster, DaoSession;
        mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME); /* devhelper will clear all tabs then create tabs*/
        getDaoMaster(context);
        getDaoSession(context);
    }

    /* singleton */
    public static DbManager getInstance(Context context) {
        if (null == mDbManager) {
            synchronized (DbManager.class) {
                if (null == mDbManager) {
                    mDbManager = new DbManager(context);
                }
            }
        }
        return mDbManager;
    }

    /* getReadableDatabase */
    public static SQLiteDatabase getReadableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getReadableDatabase();
    }

    /* getWritableDatabase */
    public static SQLiteDatabase getWritableDatabase(Context context) {
        if (null == mDevOpenHelper) {
            getInstance(context);
        }
        return mDevOpenHelper.getWritableDatabase(); /* create db and table */
    }


    /* getDaoMaster singleton */
    public static DaoMaster getDaoMaster(Context context) {
        if (null == mDaoMaster) {
            synchronized (DbManager.class) {
                if (null == mDaoMaster) {
                    mDaoMaster = new DaoMaster(getWritableDatabase(context));
                }
            }
        }
        return mDaoMaster;
    }

   /* getDaoSession, singleton*/
    public static DaoSession getDaoSession(Context context) {
        if (null == mDaoSession) {
            synchronized (DbManager.class) {
                mDaoSession = getDaoMaster(context).newSession();
            }
        }
        return mDaoSession;
    }
}

