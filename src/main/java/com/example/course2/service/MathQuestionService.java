package com.example.course2.service;

import com.example.course2.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class MathQuestionService implements QuestionService {
    final private MathQuestionRepository repository;

    public MathQuestionService(MathQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return this.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        repository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        if (repository.getAll().size() != 0) {
            return new ArrayList<>(repository.getAll()).get(random.nextInt(repository.getAll().size()));
        }
        return null;
    }
}
