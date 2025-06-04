package sky.pro.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.examinerservice.domain.Question;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();

    public Question add(String question, String answer) {
        Question questionTemp = new Question(question, answer);
        questions.add(questionTemp);
        return questionTemp;
    }

    public Question remove(Question question) {
        questions.removeIf(question::equals);
        return question;
    }

    public Collection<Question> getAll() {
        return questions;
    }

    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new IndexOutOfBoundsException("Нет доступных вопросов");
        }
        List<Question> questionsList = new ArrayList<>(questions);
        return questionsList.get(ThreadLocalRandom.current().nextInt(0, questions.size()));
    }
}
