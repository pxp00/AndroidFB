package com.example.pengxuanping.demo11;

import com.example.pengxuanping.dao.DaoSession;
import com.example.pengxuanping.dao.ScoreBeanDao;
import com.example.pengxuanping.dao.StudentBeanDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

@Entity
public class StudentBean{
    @Id
    private Long id;
    @Property(nameInDb = "STUDENT_NUM")
    private String studentNum;
    @Property(nameInDb = "NAME")
    private String name;
    @Property(nameInDb = "SCORE_ID")
    private Long scoreId;
    @ToOne(joinProperty = "scoreId") /* 1:1, external key */
    private ScoreBean mScoreBean;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1251043925)
    private transient StudentBeanDao myDao;
    @Generated(hash = 800189154)
    public StudentBean(Long id, String studentNum, String name, Long scoreId) {
        this.id = id;
        this.studentNum = studentNum;
        this.name = name;
        this.scoreId = scoreId;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentNum() {
        return this.studentNum;
    }
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getScoreId() {
        return this.scoreId;
    }
    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }
    @Generated(hash = 74897013)
    private transient Long mScoreBean__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 2071419542)
    public ScoreBean getMScoreBean() {
        Long __key = this.scoreId;
        if (mScoreBean__resolvedKey == null
                || !mScoreBean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ScoreBeanDao targetDao = daoSession.getScoreBeanDao();
            ScoreBean mScoreBeanNew = targetDao.load(__key);
            synchronized (this) {
                mScoreBean = mScoreBeanNew;
                mScoreBean__resolvedKey = __key;
            }
        }
        return mScoreBean;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1313885936)
    public void setMScoreBean(ScoreBean mScoreBean) {
        synchronized (this) {
            this.mScoreBean = mScoreBean;
            scoreId = mScoreBean == null ? null : mScoreBean.getId();
            mScoreBean__resolvedKey = scoreId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2072577263)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentBeanDao() : null;
    }
}

