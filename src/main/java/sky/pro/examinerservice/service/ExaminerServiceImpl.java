package sky.pro.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.examinerservice.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;
    QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService, Random random) {
        this.questionService = questionService;
        this.random = random;
    }

    public Collection<Question> getQuestions(int amount) {
        Collection<Question> questionRandomCollection = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questionRandomCollection.add(questionService.getRandomQuestion());
        }
        return questionRandomCollection;
    }
}
