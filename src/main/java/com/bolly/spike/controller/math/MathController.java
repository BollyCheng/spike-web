package com.bolly.spike.controller.math;

import com.bolly.spike.model.entity.math.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/math")
public class MathController {

    @GetMapping("/main")
    public String mathPage() {
        return "math.main";
    }

    @PostMapping("/startExam")
    @ResponseBody
    public Question startExam() {

        return new Question();
    }

    @PostMapping("answerQuestion")
    @ResponseBody
    public Question answerQuestion(Question question) {

        return new Question();
    }



}
