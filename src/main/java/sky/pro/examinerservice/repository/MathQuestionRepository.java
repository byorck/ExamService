package sky.pro.examinerservice.repository;

import org.springframework.stereotype.Repository;
import sky.pro.examinerservice.domain.Question;

import java.util.*;

@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions;

    public MathQuestionRepository(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        throw new sky.pro.examinerservice.repository.MethodNotAllowedException("Добавление математических вопросов запрещено");
    }

    @Override
    public Question remove(Question question) {
        throw new sky.pro.examinerservice.repository.MethodNotAllowedException("Удаление математических вопросов запрещено");
    }

    @Override
    public Collection<Question> getAll() {
        throw new sky.pro.examinerservice.repository.MethodNotAllowedException("Получение математических вопросов запрещено");
    }
}
