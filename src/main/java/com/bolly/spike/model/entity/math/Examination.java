package com.bolly.spike.model.entity.math;

import com.alibaba.fastjson.annotation.JSONField;
import com.bolly.spike.model.entity.BaseEntity;

import java.util.Date;

/**
 * 试卷
 */
public class Examination extends BaseEntity {

    @JSONField(format = "yyyy-MM-dd")
    protected Date date; // 考试日期
    protected String title; // 试卷标题
    protected String totalCount; // 题目数量
    protected String totalScore; // 总分
    protected String difficultyDegree; // 难度系数(各题目难度系数的平均值)
    protected String actualScore; // 实际得分

    public Examination() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    public String getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(String difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getActualScore() {
        return actualScore;
    }

    public void setActualScore(String actualScore) {
        this.actualScore = actualScore;
    }
}
