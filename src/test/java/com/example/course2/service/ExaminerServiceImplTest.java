package com.example.course2.service;

import com.example.course2.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImplTest {
    private final Set<Question> javaQuestions = new HashSet<>();
    private final Set<Question> mathQuestions = new HashSet<>();

    @Spy
    private JavaQuestionService javaQuestionService = new JavaQuestionService(new JavaQuestionRepository());

    @Spy
    private MathQuestionService mathQuestionService = new MathQuestionService(new MathQuestionRepository());

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void addElements() {

        javaQuestions.add(new Question("javaВопрос1", "javaОтвет1"));
        javaQuestions.add(new Question("javaВопрос2", "javaОтвет2"));
        javaQuestions.add(new Question("javaВопрос3", "javaОтвет3"));
        javaQuestions.add(new Question("javaВопрос4", "javaОтвет4"));
        Mockito.when(javaQuestionService.getAll()).thenReturn(javaQuestions);

        mathQuestions.add(new Question("mathВопрос1", "mathОтвет1"));
        mathQuestions.add(new Question("mathВопрос2", "mathОтвет2"));
        mathQuestions.add(new Question("mathВопрос3", "mathОтвет3"));
        Mockito.when(mathQuestionService.getAll()).thenReturn(mathQuestions);
    }

    @Test
    void getJavaQuestionsPositive() {
        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(new ArrayList<>(javaQuestions).get(1));
        Set<Question> actual = new HashSet<>();
        actual.add(new Question("mathВопрос1", "mathОтвет1"));
        try {
            Assertions.assertThat(examinerService.getQuestions(1))
                    .isEqualTo(actual);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void getMathQuestionsPositive() {
        Mockito.when(mathQuestionService.getRandomQuestion()).thenReturn(new ArrayList<>(mathQuestions).get(1));

        Set<Question> actual = new HashSet<>();
        actual.add(new Question("Вопрос4", "Ответ4"));

        try {
            Assertions.assertThat(examinerService.getQuestions(1))
                    .isEqualTo(actual);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getQuestionsNegative() {
        Assertions.assertThatExceptionOfType(Exception.class)
                .isThrownBy(() -> examinerService.getQuestions(3))
                .withMessage("Запрошено слишком много вопросов");
    }

}
