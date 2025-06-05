package sky.pro.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.examinerservice.domain.Question;
import sky.pro.examinerservice.repository.MathQuestionRepository;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MathQuestionService implements QuestionService{
    private MathQuestionRepository repository;

    public MathQuestionService(MathQuestionRepository repository) {
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
        List<Question> questionsList = new ArrayList<>();
        questionsList.add(new Question("Что такое Пи, рациональное или иррациональное число?", "Пи — иррациональное число"));
        questionsList.add(new Question("Изображение, которое также можно увидеть в трех измерениях?", "Голограмма"));
        questionsList.add(new Question("Кто придумал знак равенства '='?", "Роберт Рекорд"));
        return questionsList.get(ThreadLocalRandom.current().nextInt(0, questionsList.size()));
    }
}
