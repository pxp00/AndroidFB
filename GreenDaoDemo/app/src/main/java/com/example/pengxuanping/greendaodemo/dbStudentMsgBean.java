package com.example.pengxuanping.greendaodemo;

import android.content.Context;
import android.util.Log;

import com.example.pengxuanping.dao.DaoMaster;
import com.example.pengxuanping.dao.DaoSession;
import com.example.pengxuanping.dao.StudentMsgBeanDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;
/*
 only comprehand concept & flow and retrieve them repeatly -> retrieve  API(will improve efficiency)
 apply -> Q -> study resolve -> apply

 Q1, where does the database be restored(path)?
 Q2,
*/
public class dbStudentMsgBean {
    private StudentMsgBeanDao msgBeanDao; /* member field */
    private StudentMsgBean mstudentMsgBean;

    /*
    1. DaoMaster init name_db, create db;
    2. DaoSession new form DaoMaster;
    3. Xx_BeanDao get from DaoSession;
    */
    public dbStudentMsgBean(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "student.db", null); /* config parameters -> DevOpenHelper */
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb()); /* get  DB & obj_daoMaster */
        DaoSession daoSession = daoMaster.newSession(); /* get obj_daosession*/

        msgBeanDao = daoSession.getStudentMsgBeanDao(); /* msgBean exist insert, del, update, select mtds */
        mstudentMsgBean = new StudentMsgBean(); /* entity */
    }


    /* insert */
    public void insert() {
        mstudentMsgBean.setName("zoneLog"); /* entity set data*/
        mstudentMsgBean.setStudentNum("123456");
        msgBeanDao.insert(mstudentMsgBean); /* dao insert a record */
    }


    public void del() {
        List<StudentMsgBean> list = msgBeanDao.queryBuilder().build().list(); /* list_entity = dao.queryBuilder.build.list;  an element = a record */
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber: " + list.get(i).getStudentNum());
            Log.d("zoneLog", "name: " + list.get(i).getName());
            if (i == 0) {
                msgBeanDao.deleteByKey(list.get(0).getId()); /* del 1st record */
//                        msgBeanDao.delete(list.get(0));//通过传入实体类的实例来删除数据
            }
        }
    }

    public void update() {
        List<StudentMsgBean> list = msgBeanDao.queryBuilder().build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber: " + list.get(i).getStudentNum());
            Log.d("zoneLog", "name: " + list.get(i).getName());
            if (i == 0) {
                list.get(0).setName("zone==========>"); /* set filed_name data */
                msgBeanDao.update(list.get(0)); /* update by record index */
            }
        }
    }


    public void select() {
        List<StudentMsgBean> list = msgBeanDao.queryBuilder()
                .offset(1)/* as skip of SQL; offset&limit have to use together */
                .limit(3)/* 只获取结果集的前 3 个数据 */
                .orderAsc(StudentMsgBeanDao.Properties.StudentNum)//通过 StudentNum 这个属性进行正序排序
                .where(StudentMsgBeanDao.Properties.Name.eq("zone"))//数据筛选，只获取 Name = "zone" 的数据
                .build()
                .list();
    }

    public void query(){
        Query<StudentMsgBean> query= msgBeanDao.queryBuilder().where(StudentMsgBeanDao.Properties.Name.eq("zone")).build();
        List<StudentMsgBean> list1 = query.list();
        query.setParameter(0, "zone123"); /* update Name_field */
    }


}
