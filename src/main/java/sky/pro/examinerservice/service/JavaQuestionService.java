package sky.pro.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.examinerservice.domain.Question;
import sky.pro.examinerservice.repository.JavaQuestionRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService {
    private JavaQuestionRepository repository;

    public JavaQuestionService(JavaQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question,answer);
    }

    @Override
    public Question remove(Question question) {
        return repository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Collection<Question> questions = repository.getAll();
        if (questions.isEmpty()) {
            throw new IndexOutOfBoundsException("Нет доступных вопросов");
        }
        List<Question> questionsList = new ArrayList<>(questions);
        return questionsList.get(ThreadLocalRandom.current().nextInt(0, questions.size()));
    }
}
