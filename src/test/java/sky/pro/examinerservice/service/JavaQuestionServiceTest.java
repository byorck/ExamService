package sky.pro.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.examinerservice.domain.Question;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void add_ShouldAddRequiredQuestionsAndOneTimes() {
        Question question = javaQuestionService.add("String - объект?", "Да");

        Collection<Question> questionCollection = javaQuestionService.getAll();

        assertTrue(questionCollection.contains(question));
        assertEquals(1, questionCollection.size());
    }

    @Test
    void remove_ShouldDeleteRequiredQuestion() {
        Question question1 = javaQuestionService.add("String - объект?", "Да");
        Question question2 = new Question("String - объект?", "Да");

        Question removed = javaQuestionService.remove(question2);
        Collection<Question> questionCollection = javaQuestionService.getAll();

        assertEquals(question1, question2);
        assertEquals(question1, removed);
        assertFalse(questionCollection.contains(question1));
        assertEquals(0, questionCollection.size());
    }

    @Test
    void getAll() {
        javaQuestionService.add("Integer - объект?", "Да");
        javaQuestionService.add("int - объект?", "Нет");

        Collection<Question> questionCollection = javaQuestionService.getAll();

        assertEquals(2, questionCollection.size());
        assertTrue(questionCollection.stream().anyMatch(q -> q.getQuestion().equals("Integer - объект?") &&
                q.getAnswer().equals("Да")));
        assertTrue(questionCollection.stream().anyMatch(q -> q.getQuestion().equals("int - объект?") &&
                q.getAnswer().equals("Нет")));
    }

    @Test
    void getRandomQuestion_ShouldReturnQuestionFromSet() {
        javaQuestionService.add("String - объект?", "Да");
        javaQuestionService.add("Integer - объект?", "Да");
        javaQuestionService.add("int - объект?", "Нет");

        Question randomQuestion = javaQuestionService.getRandomQuestion();
        Collection<Question> allQuestions = javaQuestionService.getAll();

        assertTrue(allQuestions.contains(randomQuestion));
    }

    @Test
    void getRandomQuestion_ShouldThrowException_WhenNoQuestions() {
        assertThrows(IndexOutOfBoundsException.class, () -> javaQuestionService.getRandomQuestion());
    }
}