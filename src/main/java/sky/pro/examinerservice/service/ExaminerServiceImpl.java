package sky.pro.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.examinerservice.domain.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private List<QuestionService> questionService;
    private Random random;

    public ExaminerServiceImpl(List<QuestionService> questionService, Random random) {
        this.questionService = questionService;
        this.random = random;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQuestionsCollection = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            QuestionService randomQuestion = questionService.get(random.nextInt(questionService.size()));
            randomQuestionsCollection.add(randomQuestion.getRandomQuestion());
        }
        return randomQuestionsCollection;
    }
}
