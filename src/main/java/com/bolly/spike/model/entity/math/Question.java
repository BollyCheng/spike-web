package com.bolly.spike.model.entity.math;

import com.bolly.spike.model.entity.BaseEntity;

public class Question extends BaseEntity {

    protected String examId; // 试卷id
    protected String index; // 题目编号,从1开始
    protected String subject; // 题目,如3+4=?
    protected String options; // 选项(四选一),用分号分隔,如 A.6;B.7;C.8;D.9
    protected String score; // 分数
    protected String difficultyDegree; // 难度系数(0~100之间)
    protected String answer; // 答案
    protected String actualScore; // 实际得分

    public Question() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(String difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getActualScore() {
        return actualScore;
    }

    public void setActualScore(String actualScore) {
        this.actualScore = actualScore;
    }
}
