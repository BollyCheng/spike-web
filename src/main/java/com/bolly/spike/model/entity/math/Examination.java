package com.bolly.spike.model.entity.math;

import com.bolly.spike.model.entity.BaseEntity;

/**
 * 试卷
 */
public class Examination extends BaseEntity {

    protected String date; // 考试日期
    protected String title; // 试卷标题
    protected Integer totalCount; // 题目数量
    protected Integer totalScore; // 总分
    protected Integer difficultyDegree; // 难度系数(各题目难度系数的平均值)
    protected Integer actualScore; // 实际得分

    public Examination() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(Integer difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public Integer getActualScore() {
        return actualScore;
    }

    public void setActualScore(Integer actualScore) {
        this.actualScore = actualScore;
    }
}
