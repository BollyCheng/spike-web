package com.bolly.spike.controller.math;

import com.bolly.spike.model.dto.SpikeRestfulResult;
import com.bolly.spike.model.entity.math.Examination;
import com.bolly.spike.model.entity.math.Question;
import com.bolly.spike.service.math.MathService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/math")
public class MathController {

    @Resource
    private MathService mathService;

    @GetMapping("/main")
    public String mathPage() {
        return "math.main.content";
    }

    @PostMapping("/startExam")
    @ResponseBody
    public SpikeRestfulResult startExam() {
        return new SpikeRestfulResult(mathService.startExam());
    }

    @PostMapping("answerQuestion")
    @ResponseBody
    public SpikeRestfulResult answerQuestion(Question question) {
        return new SpikeRestfulResult(mathService.answerQuestion(question));
    }

}
