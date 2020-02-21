package com.bolly.spike.controller.math;

import com.bolly.spike.model.dto.SpikeRestfulResult;
import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.MathService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/math")
public class MathController {

    public static final Logger LOGGER = LoggerFactory.getLogger(MathController.class);

    @Resource
    private MathService mathService;

    @GetMapping("/main")
    public String mathPage() {
        return "math.main.content";
    }

    @PostMapping("/startExam")
    @ResponseBody
    public SpikeRestfulResult startExam() {
        LOGGER.info("Start exam.");
        return new SpikeRestfulResult(mathService.startExam());
    }

    @PostMapping("/answerQuestion")
    @ResponseBody
    public SpikeRestfulResult answerQuestion(Question question) {
        LOGGER.info("Answer question(examId={}, index={}). answer={}", question.getExamId(), question.getIndex(), question.getAnswer());
        return new SpikeRestfulResult(mathService.answerQuestion(question));
    }

    @PostMapping("/findQuestionByExamIndex")
    @ResponseBody
    public SpikeRestfulResult findQuestionByExamIndex(Question question) {
        return new SpikeRestfulResult(mathService.findQuestionByExamIndex(question.getExamId(), question.getIndex()));
    }

    @PostMapping("/submitExam")
    @ResponseBody
    public SpikeRestfulResult submitExam(Examination examination) {
        LOGGER.info("Submit exam(id={}).", examination.getId());
        return new SpikeRestfulResult(mathService.submitExam(examination));
    }
}
