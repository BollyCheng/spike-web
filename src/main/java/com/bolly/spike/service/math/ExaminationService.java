package com.bolly.spike.service.math;

import com.bolly.spike.model.entity.math.Examination;

public interface ExaminationService {

    /**
     * 生成考试试卷
     */
    Examination generateExam();

}