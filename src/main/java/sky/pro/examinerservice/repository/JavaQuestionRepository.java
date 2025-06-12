package sky.pro.examinerservice.repository;

import org.springframework.stereotype.Repository;
import sky.pro.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question questionTemp = new Question(question, answer);
        questions.add(questionTemp);
        return questionTemp;
    }

    @Override
    public Question remove(Question question) {
        questions.removeIf(question::equals);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
