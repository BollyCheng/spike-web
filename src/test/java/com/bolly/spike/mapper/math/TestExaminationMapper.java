package com.bolly.spike.mapper.math;


import com.bolly.spike.model.entity.math.Examination;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-application.xml")
public class TestExaminationMapper {

    @Resource
    private ExaminationMapper examinationMapper;

    @Test
    public void testInsertExamination() {
        Examination exam = new Examination();
        exam.setDate("2020-01-01");
        exam.setTitle("测试新增试卷");
        examinationMapper.insertExamination(exam);

        Assert.assertNotNull(exam.getId());
    }

}
