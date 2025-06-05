package sky.pro.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.examinerservice.domain.Question;
import sky.pro.examinerservice.service.MathQuestionService;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final MathQuestionService service;

    public MathQuestionController(MathQuestionService service) {
        this.service = service;
    }

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return service.getRandomQuestion();
    }
}

