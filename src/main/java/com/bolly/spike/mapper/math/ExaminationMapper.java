package com.bolly.spike.mapper.math;

import com.bolly.spike.model.entity.math.Examination;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationMapper {

    void insertExamination(Examination exam);

    void updateExamDegreeById(Examination exam);

    void updateExamScoreById(Examination exam);

}
