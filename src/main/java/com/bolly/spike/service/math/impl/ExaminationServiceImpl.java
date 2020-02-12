package com.bolly.spike.service.math.impl;

import com.bolly.spike.mapper.math.ExaminationMapper;
import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.service.math.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ExaminationMapper examinationMapper;

    @Override
    public Examination generateExam() {
        Date today = new Date();
        Examination examination = new Examination();
        examination.setDate(new SimpleDateFormat("yyyy-MM-dd").format(today));
        examination.setTitle("数学测试-第(" + new SimpleDateFormat("yyMMdd").format(today) + ")期");
        examinationMapper.insertExamination(examination);
        return examination;
    }

    @Override
    public void updateExamDegreeById(Examination exam) {
        examinationMapper.updateExamDegreeById(exam);
    }

    @Override
    public void updateExamScoreById(Examination exam) {
        examinationMapper.updateExamScoreById(exam);
    }

    @Override
    public Examination findExamById(Long id) {
        return examinationMapper.findExamById(id);
    }

}
