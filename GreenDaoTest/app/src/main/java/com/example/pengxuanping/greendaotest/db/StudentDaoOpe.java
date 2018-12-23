package com.example.pengxuanping.greendaotest.db;

import android.content.Context;

import com.example.pengxuanping.greendaotest.bean.Student;
import com.example.pengxuanping.greendaotest.dao.StudentDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/* wrap table mtd (insert, delete, update, query) */

/*
    1. creat DB on specific path;
    2. create new table
    3. record(table): insert, delete, modify, query;
    4. modify structure of table: add a colum or table,
*/

public class StudentDaoOpe {

    private static StudentDao mstudentdao;
    /* 1. static: cls.field_x, generated before obj_x;
       2. private: cls_cur use, cls_child couldnot use; default: package_cur use
       3. final: couldn't modify, TAG, ToolUtils(one cls only)
    */

    /* constructor have  only, init parameters; */
    public StudentDaoOpe(Context context){
        mstudentdao = DbManager.getDaoSession(context).getStudentDao();
    }

    /* insert entity */
    public static void insertData(Context context, Student stu) {

        mstudentdao.insert(stu);
    }

    /*insert entities*/
    public static void insertInTx(List<Student> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        mstudentdao.insertInTx(list);
    }

    /* 添加数据至数据库，如果存在id(key_primary)，update(entity); 不存在id, insert(entity)；*/

    public static void saveData(Context context, Student student) {
        mstudentdao.save(student); /* haskey(id) update, hasn't id, insert; */
    }

    /*insert entities*/
    public static void saveInTx( List<Student> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        mstudentdao.saveInTx(list);
    }

    /* delete */
    public static void deleteData(Context context, Student student) {
        mstudentdao.delete(student);
    }

    /* delete by id */
    public static void deleteByKeyData(Context context, long id) {
        mstudentdao.deleteByKey(id);
    }

    /* del all */
    public static void deleteAllData(Context context) {
        mstudentdao.deleteAll();
    }

    /*  update record */
    public static void updateData(Context context, Student student) {
        mstudentdao.update(student);
    }

    /* query  all record */
    public static List<Student> queryAll(Context context) {
        QueryBuilder<Student> builder = mstudentdao.queryBuilder();
        return builder.build().list();
    }

    /* query record by id */
    public static List<Student> queryForId(Context context, long id) {
        QueryBuilder<Student> builder = mstudentdao.queryBuilder();
        return builder.where(StudentDao.Properties.Id.eq(id)).list();
    }

    /* query record by id */
    public static List<Student> selectStudentById(long id){
        QueryBuilder<Student> builder = mstudentdao.queryBuilder();
        return builder.where(StudentDao.Properties.Id.eq(id)).list();
    }

}
