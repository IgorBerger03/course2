package com.example.course2.service;

import com.example.course2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathQuestionRepositoryTest {
    QuestionRepository expectedRepository = new MathQuestionRepository();

    @BeforeEach
    void addElements() {
        expectedRepository.add(new Question("Вопрос1", "Ответ1"));
        expectedRepository.add(new Question("Вопрос2", "Ответ2"));
        expectedRepository.add(new Question("Вопрос3", "Ответ3"));
        expectedRepository.add(new Question("Вопрос4", "Ответ4"));
    }

    @Test
    void add() {
        QuestionRepository actualRepository = new MathQuestionRepository();
        actualRepository.add(new Question("Вопрос1", "Ответ1"));
        actualRepository.add(new Question("Вопрос2", "Ответ2"));
        actualRepository.add(new Question("Вопрос3", "Ответ3"));
        actualRepository.add(new Question("Вопрос4", "Ответ4"));

        assertThat(expectedRepository.getAll())
                .isEqualTo(actualRepository.getAll());
    }

    @Test
    void remove() {
        expectedRepository.remove(new Question("Вопрос2", "Ответ2"));
        expectedRepository.remove(new Question("Вопрос4", "Ответ4"));

        QuestionRepository actualRepository = new MathQuestionRepository();
        actualRepository.add(new Question("Вопрос1", "Ответ1"));
        actualRepository.add(new Question("Вопрос3", "Ответ3"));

        assertThat(expectedRepository.getAll())
                .isEqualTo(actualRepository.getAll());
    }
}
