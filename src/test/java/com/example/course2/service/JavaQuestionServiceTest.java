package com.example.course2.service;

import com.example.course2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    private final Set<Question> questions = new HashSet<>();

    @Mock
    JavaQuestionRepository javaRepository;

    @InjectMocks
    JavaQuestionService expectedService;

    @BeforeEach
    void addElements() {
        questions.add(new Question("Вопрос1", "Ответ1"));
        questions.add(new Question("Вопрос2", "Ответ2"));
        questions.add(new Question("Вопрос3", "Ответ3"));
        questions.add(new Question("Вопрос4", "Ответ4"));
        Mockito.when(javaRepository.getAll()).thenReturn(questions);
    }

    @Test
    void remove() {
        expectedService.remove(new Question("Вопрос2", "Ответ2"));
        expectedService.remove(new Question("Вопрос4", "Ответ4"));

        QuestionService actualService = new JavaQuestionService(javaRepository);
        actualService.add(new Question("Вопрос1", "Ответ1"));
        actualService.add(new Question("Вопрос3", "Ответ3"));

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void testAdd() {
        QuestionService actualService = new JavaQuestionService(javaRepository);
        actualService.add("Вопрос1", "Ответ1");
        actualService.add("Вопрос2", "Ответ2");
        actualService.add("Вопрос3", "Ответ3");
        actualService.add("Вопрос4", "Ответ4");

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void getRandomQuestion() {
        Question question = expectedService.getRandomQuestion();
        assertThat(expectedService.getAll().contains(question))
                .isTrue();
    }
}
