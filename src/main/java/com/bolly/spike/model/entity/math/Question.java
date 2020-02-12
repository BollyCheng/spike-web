package com.bolly.spike.model.entity.math;

import com.alibaba.fastjson.annotation.JSONField;
import com.bolly.spike.model.entity.BaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;

public class Question extends BaseEntity {

    public static final int INDEX_FIRST = 1; // 题目编号,从1开始

    protected Long examId; // 试卷id
    protected Integer index; // 题目编号,从1开始
    protected String subject; // 题目,如3+4=?
    @JSONField(serialize = false)
    protected Integer rightAnswer; // 正确答案
    protected String options; // 选项(四选一),用分号分隔,如 A.6;B.7;C.8;D.9
    protected Integer score; // 分数
    protected Integer difficultyDegree; // 难度系数(0~100之间)
    protected String answer; // 答案
    protected Integer actualScore; // 实际得分

    public Question() {
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Integer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(Integer difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getActualScore() {
        return actualScore;
    }

    public void setActualScore(Integer actualScore) {
        this.actualScore = actualScore;
    }
}
