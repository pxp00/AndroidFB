package com.example.pengxuanping.demo11;

import android.content.Context;
import android.util.Log;

import com.example.pengxuanping.dao.DaoMaster;
import com.example.pengxuanping.dao.DaoSession;
import com.example.pengxuanping.dao.ScoreBeanDao;
import com.example.pengxuanping.dao.StudentBeanDao;

import java.util.List;

public class DbToOne {

    private ScoreBeanDao mScoreBeanDao;
    private StudentBeanDao mStudentBeanDao;
    ScoreBean mScoreBean;

    public DbToOne(Context context){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "StudentToOne.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();

        mScoreBeanDao = daoSession.getScoreBeanDao(); /* msgBean exist insert, del, update, select mtds */
        mStudentBeanDao  = daoSession.getStudentBeanDao();
        mScoreBean = new ScoreBean(); /* as record */
    }
    public void save() {
        StudentBean studentBean = new StudentBean();
        studentBean.setName("zone");
        studentBean.setStudentNum("123456");
        ScoreBean scoreBean = new ScoreBean();
        scoreBean.setEnglishScore("120");
        scoreBean.setMathScore("1000");
        mScoreBeanDao.insert(scoreBean);
        ScoreBean scoreBean1 = mScoreBeanDao.queryBuilder().unique();
        if (scoreBean1 != null) {
            studentBean.setScoreId(scoreBean1.getId());
            studentBean.setMScoreBean(scoreBean);
            mStudentBeanDao.insert(studentBean);
        }
    }

    public void query(){
        List<StudentBean> list = mStudentBeanDao.queryBuilder().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber: " + list.get(i).getStudentNum());
            Log.d("zoneLog", "name: " + list.get(i).getName());
            Log.d("zoneLog", "english: " + list.get(i).getMScoreBean().getEnglishScore());
            Log.d("zoneLog", "math: " + list.get(i).getMScoreBean().getMathScore());
        }

    }

}
