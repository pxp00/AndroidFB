package com.example.pengxuanping.demo11;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ScoreBean {
    @Id
    private Long id; /* primary key */
    private String mathScore;
    private String englishScore;
    @Generated(hash = 1082999310)
    public ScoreBean(Long id, String mathScore, String englishScore) {
        this.id = id;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }
    @Generated(hash = 80522515)
    public ScoreBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMathScore() {
        return this.mathScore;
    }
    public void setMathScore(String mathScore) {
        this.mathScore = mathScore;
    }
    public String getEnglishScore() {
        return this.englishScore;
    }
    public void setEnglishScore(String englishScore) {
        this.englishScore = englishScore;
    }
}