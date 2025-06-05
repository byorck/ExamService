package sky.pro.examinerservice.service;

import org.junit.jupiter.api.Test;
import sky.pro.examinerservice.domain.Question;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MathQuestionServiceTest {

    @Test
    void getRandomQuestion_ReturnsValidQuestion() {
        MathQuestionService service = new MathQuestionService(null); // репозиторий не нужен

        Question question = service.getRandomQuestion();

        assertNotNull(question);
        assertNotNull(question.getQuestion());
        assertNotNull(question.getAnswer());
    }
}