package sky.pro.examinerservice.repository;

import sky.pro.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(String question, String answer);

    Question remove(Question question);

    Collection<Question> getAll();
}
