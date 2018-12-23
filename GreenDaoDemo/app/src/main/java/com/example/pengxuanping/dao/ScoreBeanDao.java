package com.example.pengxuanping.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.pengxuanping.demo11.ScoreBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SCORE_BEAN".
*/
public class ScoreBeanDao extends AbstractDao<ScoreBean, Long> {

    public static final String TABLENAME = "SCORE_BEAN";

    /**
     * Properties of entity ScoreBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MathScore = new Property(1, String.class, "mathScore", false, "MATH_SCORE");
        public final static Property EnglishScore = new Property(2, String.class, "englishScore", false, "ENGLISH_SCORE");
    }


    public ScoreBeanDao(DaoConfig config) {
        super(config);
    }
    
    public ScoreBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SCORE_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MATH_SCORE\" TEXT," + // 1: mathScore
                "\"ENGLISH_SCORE\" TEXT);"); // 2: englishScore
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SCORE_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ScoreBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mathScore = entity.getMathScore();
        if (mathScore != null) {
            stmt.bindString(2, mathScore);
        }
 
        String englishScore = entity.getEnglishScore();
        if (englishScore != null) {
            stmt.bindString(3, englishScore);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ScoreBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String mathScore = entity.getMathScore();
        if (mathScore != null) {
            stmt.bindString(2, mathScore);
        }
 
        String englishScore = entity.getEnglishScore();
        if (englishScore != null) {
            stmt.bindString(3, englishScore);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ScoreBean readEntity(Cursor cursor, int offset) {
        ScoreBean entity = new ScoreBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // mathScore
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // englishScore
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ScoreBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMathScore(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setEnglishScore(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ScoreBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ScoreBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ScoreBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
