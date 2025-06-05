package sky.pro.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import sky.pro.examinerservice.domain.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExaminerServiceImplTest {
    private ExaminerServiceImpl examinerService;

    @Mock
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        examinerService = new ExaminerServiceImpl(List.of(questionService), new Random());
    }

    @Test
    void getQuestions_ReturnsCorrectAmount() {
        int amount = 4;
        Question question = new Question("String - объект?", "Да");
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question);

        Collection<Question> questions = examinerService.getQuestions(amount);

        assertEquals(amount, questions.size());
        Mockito.verify(questionService, Mockito.times(amount)).getRandomQuestion();
    }

    @Test
    void getQuestions_ReturnsCorrectQuestions() {
        int amount = 3;
        Question question = new Question("String - объект?", "Да");
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question);

        Collection<Question> questions = examinerService.getQuestions(amount);

        for (Question q : questions) {
            assertEquals(question, q);
        }
        Mockito.verify(questionService, Mockito.times(amount)).getRandomQuestion();
    }
}