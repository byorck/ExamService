package sky.pro.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.examinerservice.domain.Question;
import sky.pro.examinerservice.repository.JavaQuestionRepository;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionService javaQuestionService;

    @Test
    void add_ShouldAddRequiredQuestionsAndOneTimes() {
        Question question = new Question("String - объект?", "Да");
        when(javaQuestionRepository.add("String - объект?", "Да")).thenReturn(question);

        Question added = javaQuestionService.add("String - объект?", "Да");
        assertEquals(question, added);
    }

    @Test
    void remove_ShouldDeleteRequiredQuestion() {
        Question question = new Question("String - объект?", "Да");
        when(javaQuestionRepository.remove(question)).thenReturn(question);

        Question removed = javaQuestionService.remove(question);
        assertEquals(question, removed);
    }

    @Test
    void getAll() {
        Question question1 = new Question("Integer - объект?", "Да");
        Question question2 = new Question("int - объект?", "Нет");
        when(javaQuestionRepository.getAll()).thenReturn(java.util.List.of(question1, question2));

        Collection<Question> questions = javaQuestionService.getAll();

        assertEquals(2, questions.size());
        assertTrue(questions.stream().anyMatch(q -> q.getQuestion().equals("Integer - объект?") && q.getAnswer().equals("Да")));
        assertTrue(questions.stream().anyMatch(q -> q.getQuestion().equals("int - объект?") && q.getAnswer().equals("Нет")));

    }

    @Test
    void getRandomQuestion_ShouldReturnQuestionFromSet() {
        Question question1 = new Question("String - объект?", "Да");
        Question question2 = new Question("Integer - объект?", "Да");
        Question question3 = new Question("int - объект?", "Нет");
        when(javaQuestionRepository.getAll()).thenReturn(java.util.List.of(question1, question2, question3));

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertTrue(java.util.List.of(question1, question2, question3).contains(randomQuestion));
    }

    @Test
    void getRandomQuestion_ShouldThrowException_WhenNoQuestions() {
        when(javaQuestionRepository.getAll()).thenReturn(java.util.Collections.emptyList());

        assertThrows(IndexOutOfBoundsException.class, () -> javaQuestionService.getRandomQuestion());
    }
}