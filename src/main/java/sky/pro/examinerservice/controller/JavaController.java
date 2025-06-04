package sky.pro.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.examinerservice.domain.Question;
import sky.pro.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaController {
    QuestionService service;

    JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    Question addQuestion(String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping
    Collection<Question> getAllQuestions() {
        return service.getAll();
    }

    @GetMapping("/remove")
    Question removeQuestion(String question, String answer) {
        Question question1 = new Question(question, answer);
        return service.remove(question1);
    }
}
