package com.example.pengxuanping.greendaotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pengxuanping.greendaotest.dao.DaoMaster;

public  class UpgradeHelper extends DaoMaster.OpenHelper{

    public UpgradeHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * Here is where the calls to upgrade are executed
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by migrating all tables data");

       MigrationHelper.getInstance().migrate(db,
                UserDao.class,
                ItemDao.class);
    }


}