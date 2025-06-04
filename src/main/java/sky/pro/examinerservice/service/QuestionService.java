package sky.pro.examinerservice.service;

import sky.pro.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
